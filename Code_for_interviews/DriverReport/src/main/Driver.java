package main;
import java.util.ArrayList;
import java.util.List;

public class Driver implements Comparable<Driver>{
	
	public Driver(String name){
		this.name = name;
	}
	
	private String name; 
	public List<Trip> trips = new ArrayList<Trip>();
	public Double totalMilesDriven;
	public double averageSpeed;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Trip> getTrips() {
		return trips;
	}
	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}
	public Double getTotalMilesDriven() {
		return totalMilesDriven;
	}
	public void setTotalMilesDriven(double totalMilesDriven) {
		this.totalMilesDriven = totalMilesDriven;
	}
	public Double getAverageSpeed() {
		return averageSpeed;
	}
	public void setAverageSpeed(double averageSpeed) {
		this.averageSpeed = averageSpeed;
	}
	
	@Override
	public int compareTo(Driver otherDriver) {
		int otherDriverMiles = otherDriver.getTotalMilesDriven().intValue();
		int thisDriversMiles = this.totalMilesDriven.intValue();
		return otherDriverMiles - thisDriversMiles;
	}
}
