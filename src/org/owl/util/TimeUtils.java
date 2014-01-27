package org.owl.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author Kim
 *
 */
public class TimeUtils {
	
	private static final String DEFAULT_FORMAT = "yyyy-MM-dd";

	public static String current() {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat f = new SimpleDateFormat(DEFAULT_FORMAT);
		Date d = c.getTime();
		return f.format(d);
	}

}
