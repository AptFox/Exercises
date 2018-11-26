package main;
import java.time.LocalTime;

public class Trip {
	
	public Trip(LocalTime startTime, LocalTime stopTime, Double milesDriven){
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.milesDriven = milesDriven;
	}
	
	public LocalTime startTime;
	public LocalTime stopTime;
	
	
	private Double milesDriven;
	
	public Double speed;
	
	

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getStopTime() {
		return stopTime;
	}

	public void setStopTime(LocalTime stopTime) {
		this.stopTime = stopTime;
	}

	public double getMilesDriven() {
		return milesDriven;
	}

	public void setMilesDriven(double milesDriven) {
		this.milesDriven = milesDriven;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
}
