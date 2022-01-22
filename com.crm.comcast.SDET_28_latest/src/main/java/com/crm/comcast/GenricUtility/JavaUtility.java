package com.crm.comcast.GenricUtility;


import java.util.Date;
import java.util.Random;
   /**
    * 
    * @author kajal
    *
    */
public class JavaUtility {
	/**
	 * This method will return random number
	 * @return
	 */
		public int getRandomNumber() {
					Random ran = new Random();	
					int randomNumber = ran.nextInt();
					return randomNumber;
									
}
		/**
		 * 
		 * This method will return the system date and time
		 * @return
		 */
		
		public String getsystemDateAndTime() {
			Date date = new Date();
			String dateAndTime = date.toString();
			String YYYY = dateAndTime.split(" ")[5];
			String DD = dateAndTime.split(" ")[2];
			@SuppressWarnings("deprecation")
			int MM = date.getMonth()+1;
			String finalFormat = YYYY +"-"+MM+"-"+DD;
			return finalFormat;
		}	
}
