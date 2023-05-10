package mediaRentalManager;

import java.util.ArrayList;
import java.util.List;

public class Customer implements Comparable<Customer> {

	private final String name, address;
	private final String rentalPlan;
	private final ArrayList<String> queue = new ArrayList<>();
	private final ArrayList<String> rented = new ArrayList<>();

	public Customer(String name, String address, String rentalPlan) {
		this.name = name;
		this.address = address;
		this.rentalPlan = rentalPlan;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getRentalPlan() {
		return rentalPlan;
	}

	public String toString() {
		return "Name: " + name + ", Address: " + address + ", Plan: " + rentalPlan;
	}

	public List<String> getQueue() {
		return queue;
	}

	public List<String> getRented() {
		return rented;
	}

	public int compareTo(Customer customer) {
		return name.compareTo(customer.name);
	}

}
