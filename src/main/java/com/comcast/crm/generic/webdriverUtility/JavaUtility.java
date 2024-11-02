package com.comcast.crm.generic.webdriverUtility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(5000);
		return randomNumber;
	}
	
	public String getSystemDateYYYYDDMM(){
		LocalDate date = LocalDate.now();
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyyddmm");
		return date.format(ofPattern);
	}
	
	public StringBuilder generatePhonumber() {
		 // Create an instance of the Random class
        Random random2 = new Random();

        // Generate a random 10-digit number as a string
        StringBuilder tenDigitNumber = new StringBuilder();
        
        // First digit should not be 0, so generate between 1 and 9
        tenDigitNumber.append(random2.nextInt(9) + 1);
        
        // Generate the remaining 9 digits
        for (int i = 0; i < 9; i++) {
            tenDigitNumber.append(random2.nextInt(10)); // Append a random digit between 0 and 9
        }
        return tenDigitNumber;
	}

}
