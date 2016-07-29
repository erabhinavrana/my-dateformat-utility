/**
 * 
 */
package com.abhi.dateformat.main;

import java.text.ParseException;

import com.abhi.dateformat.constant.DateFormatConstant;
import com.abhi.dateformat.util.DateFormatUtil;

/**
 * @author Abhinav
 *
 */
public class DateFormatMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 String ddMMMYYYYHHMM = "15Jun2016 10:00";
		 String ddMMMyyyy = "06Jul1985";
		 DateFormatUtil.parseInputDateString(ddMMMYYYYHHMM);
		 DateFormatUtil.parseInputDateString(ddMMMyyyy);
				
		 try {
		 System.out.println("Formatted Date --- "+ DateFormatUtil.formatDate(ddMMMYYYYHHMM, "ddMMMyyyyHHmm", "yyyy-MM-dd'T'HH:mm:ss"));
		 System.out.println("Formatted Birth Date --- "+ DateFormatUtil.formatDate(ddMMMyyyy, "ddMMMyyyy", "yyyy-MM-dd"));
		 } catch (ParseException e) {
			 System.out.println(DateFormatConstant.INCORRECTDATESTRING);
		 }

	}

}
