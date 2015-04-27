package com.datto.personViewerTest;

import com.datto.personTool.Person;
import com.datto.personTool.PersonLink;
import com.datto.personTool.PersonTable;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PersonTableTest extends TestCase
{
    public PersonTableTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( PersonTableTest.class );
    }

    public void testPersonTable()
    {
    	PersonTable table = new PersonTable();
    	Person p1 = new Person();
    	p1.id = "p1";
    	p1.lastName = "Zanzibar";
    	p1.age = 102;
    	p1.firstName = "Charlie";
    	p1.githubAccount = "samson";
    	p1.thirdGradeGraduationDate = "1/1/1997";
    	table.add(p1);

    	Person p2 = new Person();
    	p2.id = "p2";
    	p2.lastName = "Muon";
    	p2.age = 10;
    	table.add(p2);

    	Person p3 = new Person();
    	p3.id = "p3";
    	p3.lastName = "Alpha";
    	p3.age = 35;
    	table.add(p3);

    	Person p4 = new Person();
    	p4.id = "p4";
    	p4.lastName = "Zanzibar";
    	p4.age = 34;
    	table.add(p4);

    	// Test ID lookup
    	assertTrue("p1 missing from id lookup",
    			table.personsById.containsKey("p1"));
    	assertTrue("p2 missing from id lookup",
    			table.personsById.containsKey("p2"));
    	assertTrue("p3 missing from id lookup",
    			table.personsById.containsKey("p3"));
    	assertTrue("p4 missing from id lookup",
    			table.personsById.containsKey("p4"));
    	
    	// Test age sort
    	String expectedAgeOrder = "p2,p4,p3,p1";
    	String actualAgeOrder = "";
    	String separator = "";
    	for(Person person:table.personsByAge) {
    		actualAgeOrder = actualAgeOrder + separator + person.id;
    		separator = ",";
    	}
    	assertTrue("Order by age is not correct",
    			actualAgeOrder.compareTo(expectedAgeOrder) == 0);
    	
    	// Test Last Name clustering
    	assertTrue("Zanzibar is missing from last name lookup",
    			table.personsByLastName.containsKey("Zanzibar"));
    	PersonLink link = table.personsByLastName.get("Zanzibar");
    	assertTrue("p1 missing from Zanzibar lookup",
    			link.person.id.compareTo("p1") == 0);
    	PersonLink link2 = link.nextPersonLink;
    	assertTrue("p4 missing from Zanzibar lookup",
    			link2.person.id.compareTo("p4") == 0);
    	assertTrue("Too many entries for last name Zanzibar",
    			link2.nextPersonLink == null);
    }
}


