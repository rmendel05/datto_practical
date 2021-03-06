package com.datto.personViewerTest;

import com.datto.personTool.Person;
import com.datto.personTool.PersonCsvParser;
import com.datto.personTool.PersonTable;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PersonCsvParserTest extends TestCase
{
    public PersonCsvParserTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( PersonCsvParserTest.class );
    }

    public void testPersonCsvParser() throws Exception
    {
    	PersonCsvParser parser = new PersonCsvParser();
    	String[] values = parser.parseValues("id,first,last,21,xyz@loves-github.com,5/22/1999");
    	parser.processValues(values);
    	PersonTable table = parser.table;
    	assertTrue("No entry was added to the table.",
    			!table.personsById.isEmpty());
    	assertTrue("Entry could not be found by id key",
    			table.personsById.containsKey("id"));
    	Person person = table.personsById.get("id");
    	assertTrue("id does not match",
    			person.id.compareTo("id") == 0);
    	assertTrue("first name does not match",
    			person.firstName.compareTo("first") == 0);
    	assertTrue("last name does not match",
    			person.lastName.compareTo("last") == 0);
    	assertTrue("age does not match",
    			person.age == 21);
    	assertTrue("github account does not match",
    			person.githubAccount.compareTo("xyz@loves-github.com") == 0);
    	assertTrue("date of third grade graduation does not match",
    			person.thirdGradeGraduationDate.compareTo("5/22/1999") == 0);
    }
}

