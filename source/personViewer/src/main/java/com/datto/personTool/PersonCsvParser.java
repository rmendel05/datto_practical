package com.datto.personTool;

public final class PersonCsvParser extends BaseCsvParser {
	public static final String CSV_FILE_FORMAT = "[id],[first_name],[last_name],[age],[github_account],[date_of_third_grade_graduation]";
	
	public PersonTable table = new PersonTable();
	
	public PersonCsvParser() {
	}
	
	public PersonTable getData() {
		return table;
	}

	@Override
	public void processValues(String[] values) throws Exception {
		Person person = new Person();
		int valueCount = values.length;
		if(valueCount >= 1)
			person.id = values[0];
		if(valueCount >= 2)
			person.firstName = values[1];
		if(valueCount >= 3)
			person.lastName = values[2];
		if(valueCount >= 4) {
			String rawAge = values[3];
			if(!isNullOrEmpty(rawAge)) {
				try {
					person.age = Integer.parseInt(rawAge);
				} catch(NumberFormatException e) {
					throw new Exception("Failed to parse [" + rawAge + "] to integer property [age]: " + e.getMessage());
				}
			}
		}
		if(valueCount >= 5) {
			person.githubAccount = values[4];
		}
		if(valueCount >= 6) {
			person.thirdGradeGraduationDate = values[5];
		}
		
		table.add(person);
	}

	private boolean isNullOrEmpty(String string) {
		return string == null ||
				string.trim().isEmpty();
	}
}