package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Desc:
 * Generates a report of drivers total miles driven and average speed. 
 * The values reported are rounded to the nearest integer. The report is sorted by most miles driven to least.
 * 
 * @author Michael Miller
 *
 */
public class ReportGeneratorImpl implements IReportGenerator{
	
	public Scanner consoleInputReader;
	private Pattern driverInstructionPattern  = Pattern.compile("^(Driver)\\s[a-zA-Z]+$");
	private Pattern tripInstructionPattern  = Pattern.compile("^(Trip)\\s[a-zA-Z]+\\s(\\d{2}):(\\d{2})(?::(\\d{2}))?\\s(\\d{2}):(\\d{2})(?::(\\d{2}))?\\s(?:\\d{0,2}\\.\\d{1,2})$|^\\d{1,2}$");
	
	/**
	 *  Desc:
	 * Makes calls to other methods to generate the report. 
	 * The method to initialize the console is called first 
	 * then based on the return value a read method is called.
	 * Based on the return from the read method, a report is generated. 
	 * 
	 */
	public void generateReport() {
		//read methods return here and generate the report using a different method.
		consoleInputReader = new Scanner(System.in);
		String inputSource = initializeConsole(); 
		Map<String,Driver> driversMap = null;
		List<String> instructions = null;
		try {
			switch (inputSource) {
				case "C":
					instructions = readFromConsole();
					driversMap = processInstructions(instructions);
					break;
				case "F":
					instructions = readFromFile();
					driversMap = processInstructions(instructions);
					break;
			}
			if(driversMap != null) {
				calculateAverageDriverSpeed(driversMap);
				roundTotalMilesDriven(driversMap);
				printReport(driversMap);
			}
			consoleInputReader.close();
		}catch(FileNotFoundException e){
			System.out.println("Unable to locate specified file.");
			System.out.println("Verify that is present in the same directory as the program or specify a fully qualified path.");
			System.out.println("Exiting app...");
		}
	}
	
	/**
	 * Desc:
	 * Generates initial output to user and gathers input source
	 * 
	 * @return inputSource - A String containing either 'C', 'F' or 'EXIT'
	 */
	public String initializeConsole() {
		//displays starting message and returns flag to indicate how input will be taken into the application. 
		String inputSource;
		System.out.println("Root Driver Report Generator");
		System.out.println();
		System.out.println("Select input style:");
		System.out.println("C for Console");
		System.out.println("F for txt file");
		System.out.println();
		System.out.print("Input Style: ");
		inputSource = consoleInputReader.nextLine().toUpperCase();
		boolean inputIsValid = inputSource.equalsIgnoreCase("C") || inputSource.equalsIgnoreCase("F"); 
		if(!inputIsValid) {
			System.out.println("Invalid Input. Exiting app...");
			inputSource = "EXIT";
		}
		
		return inputSource;
	}
	
	/**
	 * Desc:
	 * Repeatedly reads input from the user until the exit chars are entered. 
	 * 
	 * @return instructions - A list of strings. Each string is a validated command input by the user.
	 */
	public List<String> readFromConsole() {
		//loops input from console and uses commands to signal end and report generation 
		Pattern exitPattern = Pattern.compile("^(!wq)$");
		List<String> instructions = new ArrayList<String>();
		System.out.println();
		System.out.println("Console input selected.");
		System.out.println("Available commands:");
		System.out.println("Driver [Name]");
		System.out.print("Trip [Name] [Start Time] [Stop Time] [Miles Driven]");
		System.out.println();
		System.out.println("Enter !wq to complete input. Awaiting input:");
		System.out.println();
		String currentInput = consoleInputReader.nextLine();
		while(!exitPattern.matcher(currentInput).matches()) {
			String validatedInput = validateNextLineOfInput(currentInput);
			instructions.add(validatedInput);
			currentInput = consoleInputReader.nextLine();
		}
		return instructions;
	}
	
	/**
	 * Desc:
	 * Repeatedly reads input from a file until the end of the file is reached. 
	 * 
	 * @return instructions - A list of strings. Each string is a validated command input by the user.
	 * @throws FileNotFoundException
	 */
	public List<String> readFromFile() throws FileNotFoundException {
		 //loops input from file with file reader
		List<String> instructions = new ArrayList<String>();
		System.out.println("Txt file input selected.");
		System.out.print("Enter txt file name: ");
		String txtFileName = consoleInputReader.nextLine();
		File file = new File(txtFileName); 
		consoleInputReader = new Scanner(file);
		while(consoleInputReader.hasNextLine()) {
			String currentInput = consoleInputReader.nextLine();
			String validatedInput = validateNextLineOfInput(currentInput);
			instructions.add(validatedInput);
		}
		return instructions;
	}
	
	/**
	 * Desc:
	 * Compares a string to a RegEx pattern to determine if it's a valid instruction. 
	 * Returns null when command is invalid.
	 * 
	 * @param currentInput - a string containing a 'Trip' or 'Driver' command
	 * @return instruction - A single validated command. 
	 */
	private String validateNextLineOfInput(String currentInput) {
		String instruction = null;
		if(driverInstructionPattern.matcher(currentInput).matches()) {
			instruction = currentInput;
		}
		else if(tripInstructionPattern.matcher(currentInput).matches()) {
			instruction = currentInput;
			}
		if(instruction == null) {
			System.out.println("Invalid Input.");
		}
		return instruction;
	}
	

	
	/**
	 * Desc:
	 * Processes a list of instructions into a map of Drivers. 
	 * Drivers are created by 'Driver' commands. 'Trip' commands 
	 * only create Trips for which a valid driver already exists.
	 * 'Trip' commands for which there is no Driver are discarded.  
	 * 
	 * @param instructions - A list of strings. Each string, a validated command.
	 * @return driversMap - A map of Driver objects processed from the instructions in the following format <DriverName,Driver> 
	 */
	public Map<String,Driver> processInstructions(List<String> instructions) {
		Map<String, Driver> driversMap = new HashMap<String, Driver>();
		for(String instruction : instructions) {
			if(instruction != null) {
				String[] instructionArr = instruction.split("\\s");
				if(instructionArr[0].equalsIgnoreCase("Driver")) {
					Driver newDriver = new Driver(instructionArr[1]);
					newDriver.setTotalMilesDriven(0.0);
					newDriver.setAverageSpeed(0.0);
					driversMap.putIfAbsent(newDriver.getName(), newDriver);
				}else {
					String driverName = instructionArr[1];
					if(driversMap.containsKey(driverName)) {
						Driver currentDriver  = driversMap.get(driverName);
						String startTimeStr = instructionArr[2];
						String stopTimeStr = instructionArr[3];
						Double milesDriven = Double.parseDouble(instructionArr[4]);
						LocalTime startTime = LocalTime.parse(startTimeStr);
						LocalTime stopTime = LocalTime.parse(stopTimeStr);
						Trip newTrip = new Trip(startTime, stopTime, milesDriven);
						calculateSpeed(newTrip);
						boolean tripSpeedIsValid = !(newTrip.getSpeed() > 100 || newTrip.getSpeed() < 5);
						if(tripSpeedIsValid) {
							currentDriver.getTrips().add(newTrip);
							currentDriver.totalMilesDriven += newTrip.getMilesDriven();	
						}
					}else {
						System.out.println();
						System.out.println("The driver does not exist for the entered trip.");
						System.out.println("Please enter the driver before entering their trip.");
						System.out.println("The following trip command was not processed: "+ instruction);
						System.out.println();
					}
				}
			}
		}
		return driversMap;
	}
	
	/**
	 * Desc:
	 * Calculates and sets the speed of a trip by getting the time elapsed between start/stop time
	 * in minutes, converting to hours and then dividing by the miles driven.  
	 * 
	 * @param trip - a Trip object where startTime, stopTime and milesDriven are not null
	 */
	public void calculateSpeed(Trip trip) {
		Long minutesTraveled = Duration.between(trip.startTime, trip.stopTime).toMinutes();
		Double mph = trip.getMilesDriven() / (minutesTraveled.doubleValue() / 60);
		trip.setSpeed(mph);
	}
	
	/**
	 * Desc:
	 * Iterates through a map of drivers and rounds their total miles driven to the nearest integer
	 * 
	 * @param driversMap - A map of Driver objects
	 */
	public void roundTotalMilesDriven(Map<String, Driver> driversMap) {
		for(String driverName : driversMap.keySet()) {
			Driver currentDriver = driversMap.get(driverName);
			if(currentDriver.totalMilesDriven != null) {
				Double totalMilesDriven = (double) Math.round(currentDriver.getTotalMilesDriven());
				currentDriver.setTotalMilesDriven(totalMilesDriven);
			}
		}
	}
	
	/**
	 * Desc:
	 * Iterates through a map of Driver objects, calculates their average speed from their Trip objects
	 * and rounds their average speed to the nearest integer
	 * 
	 * @param driversMap - A map of Driver objects
	 */
	public void calculateAverageDriverSpeed(Map<String, Driver> driversMap) {
		for(String driverName : driversMap.keySet()) {
			Driver currentDriver = driversMap.get(driverName);
			List<Trip> tripsList = currentDriver.getTrips();
			if(tripsList != null) {
				Double averageDriverSpeed = 0.0;
				for(Trip trip : tripsList) {
					averageDriverSpeed += trip.getSpeed();
				}
				Integer totalNumberOfTrips = tripsList.size();
				averageDriverSpeed = (double) Math.round(averageDriverSpeed / totalNumberOfTrips.doubleValue());
				currentDriver.setAverageSpeed(averageDriverSpeed);
			}
		}
	}
	
	
	/**
	 * Desc:
	 * Takes the values from a map of drivers, converts to a list, sorts the list by most miles driven 
	 * and prints a report of drivers. 
	 * 
	 * @param driversMap - A map of Driver objects
	 */
	private void printReport(Map<String, Driver> driversMap) {
		//Sort the drivers in the report by most miles driven to least.
		List<Driver> driversList = new ArrayList<Driver>(driversMap.values());
		Collections.sort(driversList);
		System.out.println();
		System.out.println("Driver Report:");
		for(Driver driver : driversList) {
			System.out.println(driver.getName()+": "+driver.getTotalMilesDriven().intValue() + " miles @ " + driver.getAverageSpeed().intValue() + " mph");
		}

	}
}
