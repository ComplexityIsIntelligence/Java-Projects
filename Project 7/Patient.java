
import java.util.PriorityQueue;


public class Patient implements Comparable<Patient> {  
	// attributes
	private String name;
	private int order; // order of arrival
	private int emergency; // 1 is normal, 5 is life-and-death situation

	// constructor                                                           
	public Patient(int order, String name, int priority) {
		this.order = order;
		this.name = name;
		this.emergency = priority;

	}
	 public void Reset(PriorityQueue<Patient> e){
		e.clear();
	 }

	public void NextPatient(PriorityQueue<Patient> e) {
	System.out.println(e.peek());
		System.out.println(e.poll());
	}

	 public void add(PriorityQueue<Patient> f,Patient e) {
		f.add(e);
	}

	 // getters and setters
	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmergency() {
		return emergency;
	}

	public void setEmergency(int emergency) {
		this.emergency = emergency;
	}

	public String toString() {
		return name;
	}


	public int compareTo( Patient o2) {          
		if (this.getEmergency() > o2.getEmergency()) {
	 		return -1;
	 	} else if (this.getEmergency() < o2.getEmergency()) {
	 		return 1;
	 	} else if (this.getOrder() > o2.getOrder()) {
	 		return -1;  //change to 1;
	} else {
	 		return 1;
	 	}
	 }

	
}
