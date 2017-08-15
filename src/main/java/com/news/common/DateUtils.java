package com.news.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 * 
 * @author chen.zhijun
 * @since 2016-05-27
 */
public class DateUtils {

	private DateUtils() {

	}

	private static final SimpleDateFormat yyyyMMdd = new SimpleDateFormat(
			"yyyyMMdd");
	private static final SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat(
			"yyyy-MM-dd");
	private static final SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat(
			"yyyyMMddHHmmss");
	private static final SimpleDateFormat yyyy_MM_dd_HH_mm = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm");
	private static final SimpleDateFormat yyyy_MM_dd_HH_mm_ss = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	private static final SimpleDateFormat yyyy_MM_dd_HH_mm_ss_SSS = new SimpleDateFormat(
			"yyyyMMddHHmmssSSS");

	public static final String yyyyMMdd(Date date) {
		return yyyyMMdd.format(checkDate(date));
	}

	public static final String yyyy_MM_dd(Date date) {
		return yyyy_MM_dd.format(checkDate(date));
	}

	public static String yyyyMMddHHmmss(Date date) {
		return yyyyMMddHHmmss.format(checkDate(date));
	}

	public static String yyyy_MM_dd_HH_mm(Date date) {
		return yyyy_MM_dd_HH_mm.format(checkDate(date));
	}

	public static String yyyy_MM_dd_HH_mm_ss(Date date) {
		return yyyy_MM_dd_HH_mm_ss.format(checkDate(date));
	}

	public static String yyyy_MM_dd_HH_mm_ss_SSS(Date date) {
		return yyyy_MM_dd_HH_mm_ss_SSS.format(checkDate(date));
	}

	public static Date checkDate(Date date) {
		if (null == date) {
			return new Date();
		} else {
			return date;
		}
	}

	/**
	 * 格式 yyyyMMdd
	 */
	public static int calcAgeByBirthday(String marks) {
		int age = -1;
		Date birthday = null;
		try {
			birthday = yyyyMMdd.parse(marks);
		} catch (Exception e) {
			return -1;
		}

		Calendar cal = Calendar.getInstance();

		if (cal.before(birthday)) {
			throw new IllegalArgumentException(
					"The birthDay is before Now.It's unbelievable!");
		}

		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

		cal.setTime(birthday);
		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

		age = yearNow - yearBirth;

		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				if (dayOfMonthNow < dayOfMonthBirth) {
					age--;
				}
			} else {
				age--;
			}
		}

		return age;
	}

}
