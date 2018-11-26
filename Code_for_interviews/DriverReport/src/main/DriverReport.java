package main;

public class DriverReport {
	
	private static IReportGenerator reportGenerator= new ReportGeneratorImpl();
	
	public static void main(String[] args) {
		reportGenerator.generateReport();
	}

}
