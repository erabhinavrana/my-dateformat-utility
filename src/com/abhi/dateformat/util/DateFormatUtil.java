/**
 * 
 */
package com.abhi.dateformat.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static com.abhi.dateformat.constant.DateFormatConstant.*;

/**
 * @author Abhinav
 *
 */
public class DateFormatUtil {

	/**
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String parseInputDateString(String dateStr) {
		if (dateStr != null) {
			for (String parse : formats) {
				ThreadLocal<SimpleDateFormat> threadLocalFormat = new ThreadLocal<SimpleDateFormat>(){
					@Override
					protected SimpleDateFormat initialValue(){
						return new SimpleDateFormat(parse);
					}
				};
				try {
					threadLocalFormat.get().parse(dateStr);
                     return parse; 
				} catch (ParseException e) {

				}
			}
		}
		return INCORRECTDATESTRING;
	}

	/**
	 * 
	 * @param inputDate
	 * @param inputDateFormat
	 * @param toDateFormat
	 * @return
	 * @throws ParseException
	 */
	public static String formatDate(String inputDate, String inputDateFormat,
			String toDateFormat) throws ParseException {
		ThreadLocal<SimpleDateFormat> inputDateFormatter = new ThreadLocal<SimpleDateFormat>() {
			@Override
			protected SimpleDateFormat initialValue() {
				return new SimpleDateFormat(inputDateFormat);
			}
		};

		ThreadLocal<SimpleDateFormat> toDateFormatter = new ThreadLocal<SimpleDateFormat>() {
			@Override
			protected SimpleDateFormat initialValue() {
				return new SimpleDateFormat(toDateFormat);
			}
		};

		return toDateFormatter.get().format(
				inputDateFormatter.get().parse(inputDate));
	}
}
