package com.crm.webdriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Java_Utility {
	public int getRandomNumber() {
		Random r = new Random();
		int randomno = r.nextInt(200);
		return randomno;
	}
	
	public String getSystemDateyyyymmdd() {
		Date  d = new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(d);
		return date;
	}
	
	public String getRequiredDateyyyymmdd(int days) {
		Date d= new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		String actdate= sdf.format(d);
		Calendar cal = sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String reqdate= sdf.format(cal.getTime());
		return reqdate;
	}
}
