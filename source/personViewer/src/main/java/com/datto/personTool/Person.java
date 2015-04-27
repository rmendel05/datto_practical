package com.datto.personTool;

public final class Person {
	public String id = null;
	public String firstName = null;
	public String lastName = null;
	public int age = Integer.MAX_VALUE;
	public String githubAccount = null;
	public String thirdGradeGraduationDate = null;
	
	@Override
	public String toString() {
		String ageString = "";
		if(age < Integer.MAX_VALUE)
			ageString = Integer.toString(age);
		
		return id + "," +
				firstName + "," +
				lastName + "," +
				ageString + "," +
				githubAccount + "," +
				thirdGradeGraduationDate;
	}
}
