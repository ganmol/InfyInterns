package com.infy.business.validator;




public class Validator {

	// don't tamper with the signature 
	public void validateMentorId(Integer mentorId) throws Exception{
		String s=String.valueOf(mentorId);
		if(s.length()!=5){
			throw new Exception("Validator.INVALID_MENTOR_ID");
		}
		
		// Your code goes here
		
		
	}
	
	
}
