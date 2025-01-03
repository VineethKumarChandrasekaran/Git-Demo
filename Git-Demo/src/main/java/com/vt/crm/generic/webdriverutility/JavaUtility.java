package com.vt.crm.generic.webdriverutility;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	
	public int generateRandomNum()
	{
		Random random=new Random();
		int rvalue = random.nextInt();
		return rvalue;
	}
	
	
	public String getLocalDateTime()
	{
		String timeStamp = LocalDateTime.now().toString().replace(":","-");
		return timeStamp;
	}
	
	//current date
	public String getSystemDateYYYYDDMM()
	{
		Date dateobj=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD");
		String date=sdf.format(dateobj);
		return date;
		
	}
	
	//secific date
	public String getrequiredDateYYYDDMM(int day)
	{
		Date date=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD");
	Calendar cal = sdf.getCalendar();
	sdf.format(date);
	cal.add(Calendar.DAY_OF_MONTH, day);
	String req_date = sdf.format(cal.getTime());
	//System.out.println(req_date);
	return req_date;
	
	}
	
	//To Generate the Random Mobile Number
	public StringBuilder getRandomPhoneNumber() {
		Random random = new Random();
		int firstdigit = random.nextInt(4) + 6;
		StringBuilder mobilenumber = new StringBuilder();
		mobilenumber.append(firstdigit);
		for(int i=0;i<9;i++) {
			mobilenumber.append(random.nextInt(10));
		}
		return mobilenumber;
	}
	
}
