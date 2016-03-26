package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class IDNumberVerification {
	String[] regionCodes;
	Date startDate;
	Date endDate;
	boolean isRcodeValid(String rc) {
		for (String s : regionCodes) {
			if (s.compareTo(rc) == 0)
				return true;
		}
		
		return false;
	}
	boolean isWithinRange(Date testDate) {
		  return testDate != null && !(testDate.before(startDate) || testDate.after(endDate));
	}
	boolean isDateValid(String date) {
		Date testDate = null;
		try {
			testDate = getDate(date);
		}
		catch (ParseException ex) {
			return false;
		}
		
		return isWithinRange(testDate);
	}
	private Date getDate(String date) throws ParseException {
		Date testDate;
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		dateFormat.setLenient(false);
		testDate = dateFormat.parse(date);
		return testDate;
	}
	
	boolean checksumValid(String id) {
		char X = id.charAt(id.length() - 1);
		int cksm = X == 'X' ? 10 : X - '0';
		
 		int res = cksm;
		int pow = 17;
		
		for (int i = 1; i < id.length(); ++i, --pow) {
			res += ( (id.charAt(i - 1) - '0') * (1 << pow) );
		}
		res = res % 11;
		
		return res == 1;
	}
	public String verify(String id, String[] regionCodes) {
		this.regionCodes = regionCodes;
		try {
			this.startDate = getDate("19000101");
			this.endDate = getDate("20111231");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String rCode = id.substring(0, 6);
		String date = id.substring(6, 14);
		String sc = id.substring(14, 17);
		
		if ( Integer.parseInt(sc) != 0 ) { 
			
			if (isRcodeValid(rCode) && isDateValid(date) && checksumValid(id)) {
				return (Integer.parseInt(sc) & 1) == 1 ? "Male" : "Female";
			}
				
		}
		
		
		return "Invalid";
	}
	
	@Test
	public void test() {
		assertTrue( verify("532531592305210236", new String[]{"542423", "231223", "340103", "321084", "120225", "430702", "431024", "511028", "210181", "511800", "140929", "632721", "370105", "451202", "510124", "532531", "130525", "152221", "653121", "421003", "430202", "510107", "530128", "510114", "320501", "510422", "230108", "331121", "410701", "542231", "310112", "500101", "469024", "130201", "445224", "513329", "371701", "421202", "321203", "150921"}).equals("Invalid"));
		assertTrue( verify("230231198306900162", new String[]{"230231"}).equals("Invalid"));
		assertTrue( verify("441323200312060636", new String[]{"441323"}).equals("Male"));
		assertTrue( verify("62012319240507058X", new String[]{"620123"}).equals("Female"));
//		assertTrue( checksumValid("321669197204300886"));
//		assertTrue( checksumValid("62012319240507058X"));
//		assertTrue( checksumValid("441323200312060636"));
//		assertTrue( !checksumValid("520381193206090891"));
		
	}
}
