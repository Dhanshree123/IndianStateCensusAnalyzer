package com.capgemini.indianStateCensusAnalyser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyzerTest {

	private static final String INDIA_CENSUS_CSV_FILE_PATH = "C:\\Users\\Admin\\eclipse-workspace\\IndianStateCensusAnalyser\\StateCensusData.csv";
	private static final String WRONG_FILE_PATH = "C:\\Users\\Admin\\eclipse-workspace\\IndianStateCensusAnalyser\\StateCensus.csv";
	private static final String WRONG_TYPE_FILE_PATH = "C:\\Users\\Admin\\eclipse-workspace\\IndianStateCensusAnalyser\\StateCensusData.txt";
	private static final String WRONG_DELIMITER_PATH = "C:\\Users\\Admin\\eclipse-workspace\\IndianStateCensusAnalyser\\StateCensusWrongDelimiter.csv";
	private static final String WRONG_HEADER_PATH = "C:\\Users\\Admin\\eclipse-workspace\\IndianStateCensusAnalyser\\StateCensusWrongHeader.csv";

	@Test
	public void givenIndianCensusCSVFileReturnsCorrectRecords() {
		try {
			CSVStateCensus csvStateCensus = new CSVStateCensus();
			int numOfRecords = csvStateCensus.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
			Assert.assertEquals(36, numOfRecords);

		} catch (CensusAnalyserException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenIndianCensusDataWithWrongFileShouldThrowException() {
		try {
			CSVStateCensus csvStateCensus = new CSVStateCensus();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			csvStateCensus.loadIndiaCensusData(WRONG_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(e.getExceptionType(), CensusAnalyserException.ExceptionType.WRONG_FILE_PATH);
		}
	}

	@Test
	public void givenIndianCensusDataWithWrongFileTypeShouldThrowException() {
		try {
			CSVStateCensus csvStateCensus = new CSVStateCensus();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			csvStateCensus.loadIndiaCensusData(WRONG_TYPE_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(e.getExceptionType(), CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE);
		}
	}

	@Test
	public void givenIndianCensusDataWithWrongDelimiterShouldThrowException() {
		try {
			CSVStateCensus csvStateCensus = new CSVStateCensus();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			csvStateCensus.loadIndiaCensusData(WRONG_DELIMITER_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(e.getExceptionType(), CensusAnalyserException.ExceptionType.WRONG_DELIMITER_TYPE);
		}
	}

	@Test
	public void givenIndianCensusDataWithWrongHeaderShouldThrowException() {
		try {
			CSVStateCensus csvStateCensus = new CSVStateCensus();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			csvStateCensus.loadIndiaCensusData(WRONG_HEADER_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(e.getExceptionType(), CensusAnalyserException.ExceptionType.WRONG_HEADER);
		}
	}
}
