package com.ds.quickOrder;

import java.util.Calendar;

public  class Constants {

	public static Integer makeHashUserId() {
		Calendar cal = Calendar.getInstance();
		Integer result  = (int) cal.getTimeInMillis();
		
		result = result + ((int)(Math.random() * 10000));
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(makeHashUserId());
	}

}
