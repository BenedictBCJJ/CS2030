import java.lang.String;


public class Cruise {
	final String identifier;
	final int arrival;
	final int loaders;
	final int serviceTime;

	public Cruise(String identifier, int arrival, int loaders, int serviceTime) {
		this.identifier = identifier;
		this.arrival = arrival;
		this.loaders = loaders;
		this.serviceTime = serviceTime;
	}

	@Override
	public String toString() {
		return String.format(identifier + "@%04d",arrival);
	}

	public int getArrivalTime() {
		int minutes = this.arrival % 100;
		int hours = this.arrival / 100;
		int totalMinutes = hours * 60 + minutes;
		return totalMinutes;
	}

	public int getNumOfLoadersRequired() {
		return this.loaders;
	}

	public int getServiceCompletionTime() {
		int arrival_time = this.getArrivalTime();
		return arrival_time + serviceTime;
	}
}

