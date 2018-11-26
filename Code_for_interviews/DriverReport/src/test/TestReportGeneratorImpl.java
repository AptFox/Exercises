package test;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.junit.Test;
import org.junit.Assert;

import main.Driver;
import main.ReportGeneratorImpl;
import main.Trip;

public class TestReportGeneratorImpl {
	
	private ReportGeneratorImpl reportGenerator = new ReportGeneratorImpl();
	
	
	public void setupInputFromString(String testInputString) {
		  System.setIn(new ByteArrayInputStream(testInputString.getBytes()));
		  reportGenerator.consoleInputReader = new Scanner(System.in);
	}

	@Test
	public void testInitializeConsoleWithInvalidInput() {
		String testInputString = "Hello, World!\r\n";
		String expectedReturnStr = "EXIT";
		String actualReturnStr;
		InputStream stdin = System.in;
		try {
			setupInputFromString(testInputString);
			actualReturnStr = reportGenerator.initializeConsole();
		  
		} finally {
		  System.setIn(stdin);
		}
		Assert.assertEquals(expectedReturnStr, actualReturnStr);
	}
	@Test
	public void testInitializeConsoleWithValidInputForConsole() {
		String testInputString = "C";
		String expectedReturnStr = "C";
		String actualReturnStr;
		InputStream stdin = System.in;
		try {
			setupInputFromString(testInputString);
			actualReturnStr = reportGenerator.initializeConsole();
		  
		} finally {
		  System.setIn(stdin);
		}
		Assert.assertEquals(expectedReturnStr, actualReturnStr);
	}
	@Test
	public void testInitializeConsoleWithValidInputForFile() {
		String testInputString = "F";
		String expectedReturnStr = "F";
		String actualReturnStr;
		InputStream stdin = System.in;
		try {
			setupInputFromString(testInputString);
			actualReturnStr = reportGenerator.initializeConsole();
		  
		} finally {
		  System.setIn(stdin);
		}
		Assert.assertEquals(expectedReturnStr, actualReturnStr);
	}
	@Test
	public void testReadFromConsoleNormalInput() {
		String testInputString = 
				"Driver Dan\n"
				+ "Driver Bob\n"
				+ "Driver Kevin\n"
				+ "Trip Dan 07:15 07:45 17.3\n"
				+ "Trip Dan 06:12 06:32 21.8\n"
				+ "Trip Dan 06:12 06:32 21.8\n"
				+ "Trip Bob 01:12 06:32 80.8\n"
				+ "Trip Bob 11:12 13:32 28.8\n"
				+ "Trip Kevin 19:12 21:32 50.8\n"
				+ "!wq\n";
		List<String> expectedReturnList = new ArrayList<String>();
		expectedReturnList.add("Driver Dan");
		expectedReturnList.add("Driver Bob");
		expectedReturnList.add("Driver Kevin");
		expectedReturnList.add("Trip Dan 07:15 07:45 17.3");
		expectedReturnList.add("Trip Dan 06:12 06:32 21.8");
		expectedReturnList.add("Trip Dan 06:12 06:32 21.8");
		expectedReturnList.add("Trip Bob 01:12 06:32 80.8");
		expectedReturnList.add("Trip Bob 11:12 13:32 28.8");
		expectedReturnList.add("Trip Kevin 19:12 21:32 50.8");
		List<String> actualReturnList;
		InputStream stdin = System.in;
		try {
			setupInputFromString(testInputString);
			actualReturnList = reportGenerator.readFromConsole();
		  
		} finally {
		  System.setIn(stdin);
		}
		Assert.assertEquals(expectedReturnList, actualReturnList);
	}	
	@Test
	public void testReadFromConsoleInvalidTrips() {
		String testInputString = 
				"Driver Dan\n"
				+ "Driver Bob\n"
				+ "Driver Kevin\n"
				+ "Driver g 07:15 07:45 17.3\n"
				+ "Trip t06:12 06:32 21.8\n"
				+ "Trap z 06:12 0ff6:32 21.8\n"
				+ "Trip w 01:12 06:32 ewe280.8\n"
				+ "Trop ttttttttttttt 11:12 13:32 28.8\n"
				+ "Trip134455665334 19:1eefe221:32 333350.8\n"
				+ "!wq\n";
		List<String> expectedReturnList = new ArrayList<String>();
		expectedReturnList.add("Driver Dan");
		expectedReturnList.add("Driver Bob");
		expectedReturnList.add("Driver Kevin");
		expectedReturnList.add(null);
		expectedReturnList.add(null);
		expectedReturnList.add(null);
		expectedReturnList.add(null);
		expectedReturnList.add(null);
		expectedReturnList.add(null);
		List<String> actualReturnList;
		InputStream stdin = System.in;
		try {
			setupInputFromString(testInputString);
			actualReturnList = reportGenerator.readFromConsole();
		  
		} finally {
		  System.setIn(stdin);
		}
		Assert.assertEquals(expectedReturnList, actualReturnList);
	}	
	@Test
	public void testReadFromConsoleInvalidDrivers() {
		String testInputString = 
				"Driver1 Dan\n"
				+ "Draver Bob\n"
				+ "DriverKevin\n"
				+ "!wq\n";
		List<String> expectedReturnList = new ArrayList<String>();
		expectedReturnList.add(null);
		expectedReturnList.add(null);
		expectedReturnList.add(null);
		List<String> actualReturnList;
		InputStream stdin = System.in;
		try {
			setupInputFromString(testInputString);
			actualReturnList = reportGenerator.readFromConsole();
		  
		} finally {
		  System.setIn(stdin);
		}
		Assert.assertEquals(expectedReturnList, actualReturnList);
	}
	@Test
	public void testProcessInstructionsWithValidInstructions() {
		List<String> testInstructions = new ArrayList<String>();
		testInstructions.add("Driver Dan");
		testInstructions.add("Driver Bob");
		testInstructions.add("Driver Kevin");
		testInstructions.add("Trip Dan 07:15 07:45 17.3");
		testInstructions.add("Trip Dan 06:12 06:32 21.8");
		testInstructions.add("Trip Dan 06:12 06:32 21.8");
		testInstructions.add("Trip Bob 01:12 06:32 80.8");
		testInstructions.add("Trip Bob 11:12 13:32 28.8");
		testInstructions.add("Trip Kevin 19:12 21:32 50.8");
		
		Map<String,Driver> expectedReturnMap = new HashMap<String, Driver>();
		Driver expectedDanDriver = new Driver("Dan");
		expectedDanDriver.trips.add(new Trip(null, null, null));
		expectedDanDriver.trips.add(new Trip(null, null, null));
		expectedDanDriver.trips.add(new Trip(null, null, null));
		Driver expectedBobDriver = new Driver("Bob");
		expectedBobDriver.trips.add(new Trip(null, null, null));
		expectedBobDriver.trips.add(new Trip(null, null, null));
		Driver expectedKevinDriver = new Driver("Kevin");
		expectedKevinDriver.trips.add(new Trip(null, null, null));
		expectedReturnMap.put("Dan", expectedDanDriver);
		expectedReturnMap.put("Bob", expectedBobDriver);
		expectedReturnMap.put("Kevin", expectedKevinDriver);
		Map<String,Driver> actualReturnMap = reportGenerator.processInstructions(testInstructions);
		Assert.assertEquals(expectedReturnMap.size(), actualReturnMap.size());
		
		int actualBobDriverTripSize = actualReturnMap.get("Bob").trips.size();
		int expectedBobDriverTripSize = expectedBobDriver.trips.size();
		Assert.assertEquals(actualBobDriverTripSize, expectedBobDriverTripSize);
		
		int actualDanDriverTripSize = actualReturnMap.get("Dan").trips.size();
		int expectedDanDriverTripSize = expectedDanDriver.trips.size();
		Assert.assertEquals(expectedDanDriverTripSize, actualDanDriverTripSize);
		
		int actualKevinDriverTripSize = actualReturnMap.get("Kevin").trips.size();
		int expectedKevinDriverTripSize = expectedKevinDriver.trips.size();
		Assert.assertEquals(expectedKevinDriverTripSize, actualKevinDriverTripSize);
	}
	@Test
	public void testProcessInstructionsWithInvalidInstructions() {
		List<String> testInstructions = new ArrayList<String>();
		testInstructions.add(null);
		testInstructions.add(null);
		testInstructions.add(null);
		testInstructions.add(null);
		testInstructions.add(null);
		
		Map<String,Driver> expectedReturnMap = new HashMap<String, Driver>();
		Map<String,Driver> actualReturnMap = reportGenerator.processInstructions(testInstructions);
		Assert.assertEquals(expectedReturnMap, actualReturnMap);
	}

	@Test
	public void testCalculateSpeed() {
		Double expectedSpeed = 5.0;
		Double milesDriven = 20.0;
		LocalTime startTime = LocalTime.parse("01:00");
		LocalTime stopTime = LocalTime.parse("05:00");
		Trip testTrip = new Trip(startTime, stopTime, milesDriven);
		reportGenerator.calculateSpeed(testTrip);
		Double actualSpeed = testTrip.getSpeed();
		Assert.assertEquals(expectedSpeed, actualSpeed);
	}

	@Test
	public void testRoundTotalMilesDriven() {
		Map<String,Driver> testDrivesrMap = new HashMap<String, Driver>();
		Driver danDriver = new Driver("Dan");
		danDriver.totalMilesDriven = 76.7666665;
		testDrivesrMap.put("Dan", danDriver);
		reportGenerator.roundTotalMilesDriven(testDrivesrMap);
		Double expectedRoundedReturn = 77.0;
		Double actualRoundedReturn = danDriver.totalMilesDriven;
		Assert.assertEquals(expectedRoundedReturn, actualRoundedReturn);
	}

	@Test
	public void testCalculateAverageDriverSpeed() {
		Map<String,Driver> testDriverMap = new HashMap<String, Driver>();
		Driver danDriver = new Driver("Dan");
		Double milesDriven = 20.0;
		LocalTime startTime = LocalTime.parse("01:00");
		LocalTime stopTime = LocalTime.parse("05:00");
		Trip trip1 = new Trip(startTime, stopTime, milesDriven);
		Trip trip2 = new Trip(startTime, stopTime, milesDriven);
		Trip trip3 = new Trip(startTime, stopTime, milesDriven);
		trip1.setSpeed(5.0);
		trip2.setSpeed(5.0);
		trip3.setSpeed(5.0);
		danDriver.trips.add(trip1);
		danDriver.trips.add(trip2);
		danDriver.trips.add(trip3);
		testDriverMap.put("Dan", danDriver);
		reportGenerator.calculateAverageDriverSpeed(testDriverMap);
		Double expectedAverageSpeed = 5.0;
		Double actualAverageSpeed = danDriver.averageSpeed;
		Assert.assertEquals(expectedAverageSpeed, actualAverageSpeed);
	}
	
	@Test
	public void testReadFromFile() {
		List<String> expectedReturnList = new ArrayList<String>();
		expectedReturnList.add("Driver Dan");
		expectedReturnList.add("Driver Bob");
		expectedReturnList.add("Driver Kevin");
		expectedReturnList.add("Driver Joe");
		expectedReturnList.add("Trip Dan 07:15 07:45 17.3");
		expectedReturnList.add("Trip Dan 06:12 06:32 21.8");
		expectedReturnList.add("Trip Dan 06:12 06:32 21.8");
		expectedReturnList.add("Trip Dan 06:12 06:32 21.8");
		expectedReturnList.add("Trip Dan 06:12 06:32 21.8");
		expectedReturnList.add("Trip Bob 01:12 06:32 80.8");
		expectedReturnList.add("Trip Bob 11:12 13:32 28.8");
		expectedReturnList.add("Trip Bob 01:12 06:32 80.8");
		expectedReturnList.add("Trip Bob 11:12 13:32 28.8");
		expectedReturnList.add("Trip Bob 01:12 06:32 80.8");
		expectedReturnList.add("Trip Bob 11:12 13:32 28.8");
		expectedReturnList.add("Trip Kevin 19:12 21:32 50.8");
		expectedReturnList.add("Trip Kevin 19:12 21:32 50.8");
		expectedReturnList.add("Trip Kevin 19:12 21:32 50.8");
		expectedReturnList.add("Trip Kevin 19:12 21:32 50.8");
		expectedReturnList.add("Trip Kevin 19:12 21:32 50.8");
		expectedReturnList.add("Trip Kevin 19:12 21:32 50.8");
		System.out.println(System.getProperty("user.dir"));
		String testInputString = System.getProperty("user.dir")+"\\resources\\testInputFile.txt";
		InputStream stdin = System.in;
		List<String> actualReturnList = null;
		try {
			setupInputFromString(testInputString);
			actualReturnList = reportGenerator.readFromFile();
		} catch (FileNotFoundException e) {
			Assert.fail("File not found");
		} finally {
		  System.setIn(stdin);
		}
		Assert.assertEquals(expectedReturnList, actualReturnList);
		
	}

}
