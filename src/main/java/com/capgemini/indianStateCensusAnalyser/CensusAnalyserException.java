package com.capgemini.indianStateCensusAnalyser;

public class CensusAnalyserException extends Exception {

	enum ExceptionType {
		CENSUS_FILE_PROBLEM;

	}

	ExceptionType type;

	public CensusAnalyserException(ExceptionType type) {

		this.type = type;
	}

	public CensusAnalyserException(String message, ExceptionType type) {
		super(message);
		this.type = type;

	}

	public ExceptionType getExceptionType() {
		return type;
	}

}
