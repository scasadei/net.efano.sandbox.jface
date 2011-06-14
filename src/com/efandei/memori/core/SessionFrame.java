package com.efandei.memori.core;

import java.util.Date;

public class SessionFrame extends Frame {

	String authorName;
	Date startTime;

	public SessionFrame (String anAuthorName, Date aDate) {
		super(null,null);
		authorName = anAuthorName;
		startTime = aDate;
	}

}
