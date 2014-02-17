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

	/**
	 * @return 返回当前日期，形式为"yyyy-MM-dd"。
	 */
	public static String current() {
		Calendar c = Calendar.getInstance();
		Date d = c.getTime();
		
		SimpleDateFormat f = new SimpleDateFormat(DEFAULT_FORMAT);
		return f.format(d);
	}

}
