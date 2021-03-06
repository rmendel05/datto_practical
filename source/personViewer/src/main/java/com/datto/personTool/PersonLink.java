package com.datto.personTool;

public final class PersonLink {
	public Person person = null;
	public PersonLink nextPersonLink = null;
	
	public PersonLink(Person person) {
		this.person = person;
	}
	
	public void putAtEnd(PersonLink personLink) {
		PersonLink lastPersonLink = this;
		while(lastPersonLink.nextPersonLink != null)
			lastPersonLink = lastPersonLink.nextPersonLink;
		
		lastPersonLink.nextPersonLink = personLink;
	}
}
