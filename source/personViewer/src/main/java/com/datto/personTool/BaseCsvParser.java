package com.datto.personTool;

public abstract class BaseCsvParser {
	public String[] parseValues(String line) {
		// TODO Handle quoted separators
		return line.split(",");
	}

	public abstract void processValues(String[] values) throws Exception;
}
