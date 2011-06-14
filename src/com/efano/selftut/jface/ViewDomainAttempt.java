package com.efano.selftut.jface;

/*******************************************************************************
 * Copyright (c) 2006, 2009 The Pampered Chef, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Coconut Palm Software, Inc. - Initial API and implementation
 *     Matthew Hall - bug 260337
 ******************************************************************************/

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ViewerSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

/**
 * Demonstrates binding a TableViewer to a collection.
 */
public class ViewDomainAttempt {
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		final Display display = Display.getDefault();

		// In an RCP application, the threading Realm will be set for you
		// automatically by the Workbench. In an SWT application, you can do
		// this once, wrapping your binding method call.
		Realm.runWithDefault(SWTObservables.getRealm(display), new Runnable() {
			@Override
			public void run() {

				ViewModel viewModel = new ViewModel();
				Shell shell = new View(viewModel).createShell();

				// The SWT event loop
				while (!shell.isDisposed()) {
					if (!display.readAndDispatch()) {
						display.sleep();
					}
				}
			}
		});
	}

	// Minimal JavaBeans support
	public static abstract class AbstractModelObject {
		private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
				this);

		public void addPropertyChangeListener(PropertyChangeListener listener) {
			propertyChangeSupport.addPropertyChangeListener(listener);
		}

		public void addPropertyChangeListener(String propertyName,
				PropertyChangeListener listener) {
			propertyChangeSupport.addPropertyChangeListener(propertyName,
					listener);
		}

		public void removePropertyChangeListener(PropertyChangeListener listener) {
			propertyChangeSupport.removePropertyChangeListener(listener);
		}

		public void removePropertyChangeListener(String propertyName,
				PropertyChangeListener listener) {
			propertyChangeSupport.removePropertyChangeListener(propertyName,
					listener);
		}

		protected void firePropertyChange(String propertyName, Object oldValue,
				Object newValue) {
			propertyChangeSupport.firePropertyChange(propertyName, oldValue,
					newValue);
		}
	}

	// The data model class. This is normally a persistent class of some sort.
	static class Person extends AbstractModelObject {
		// A property...
		String name = "John Smith";

		public Person(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			String oldValue = this.name;
			this.name = name;
			firePropertyChange("name", oldValue, name);
		}
	}

	// The View's model--the root of our Model graph for this particular GUI.
	//
	// Typically each View class has a corresponding ViewModel class.
	// The ViewModel is responsible for getting the objects to edit from the
	// data access tier. Since this snippet doesn't have any persistent objects
	// to retrieve, this ViewModel just instantiates a model object to edit.
	static class ViewModel {
		// The model to bind
		private List<Person> people = new LinkedList<Person>();
		{
			people.add(new Person("Steve Northover"));
			people.add(new Person("Grant Gayed"));
			people.add(new Person("Veronika Irvine"));
			people.add(new Person("Mike Wilson"));
			people.add(new Person("Christophe Cornu"));
			people.add(new Person("Lynne Kues"));
			people.add(new Person("Silenio Quarti"));
		}

		public List<Person> getPeople() {
			return people;
		}
	}

	// The GUI view
	static class View {
		private ViewModel viewModel;
		private Table committers;

		public View(ViewModel viewModel) {
			this.viewModel = viewModel;
		}

		public Shell createShell() {
			// Build a UI
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			shell.setLayout(new FillLayout());
			committers = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
			committers.setLinesVisible(true);
			TableColumn column = new TableColumn(committers, SWT.NONE);

			// Set up data binding.
			TableViewer peopleViewer = new TableViewer(committers);
			ViewerSupport.bind(peopleViewer, new WritableList(viewModel
					.getPeople(), Person.class), BeanProperties.value(
					Person.class, "name"));

			column.pack();

			Button addDataButton = new Button(shell, SWT.NONE);
			addDataButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDoubleClick(MouseEvent e) {
					// Button newDataText;
					// String newData = newDataText.getText();
					Person newData = new Person("ciccio");
					viewModel.getPeople().add(newData);
					System.out.println(newData.getName());
					System.out.println(viewModel.getPeople().toString());
					//strings.println();
				}});
			
			// Open and return the Shell
			shell.setSize(100, 300);
			shell.open();
			return shell;
		}
	}

}