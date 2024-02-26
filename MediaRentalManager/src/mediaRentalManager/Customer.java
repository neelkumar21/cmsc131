package mediaRentalManager;

import java.util.ArrayList;

public class Customer implements Comparable<Customer>{
	private String name, address, plan;
	private ArrayList<String> receiving = new ArrayList<>();
	private ArrayList<String> rented = new ArrayList<>();

	public Customer(String name, String address, String plan) {
		this.name = name;
		this.address = address;
		this.plan = plan;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPlan() {
		return plan;
	}

	public void addToQueue(String title, boolean receive) {
		if (receive) {
			receiving.add(title);
		}
		else {
			rented.add(title);
		}
	}

	public void removeQueue(String title, boolean receive) {
		if(receive) {
			for (int i = 0; i < receiving.size(); i++) {
				if (receiving.get(i).equals(title)) {
					receiving.remove(i);
				}
			}
		}
		else {
			for (int i = 0; i < rented.size(); i++) {
				if (rented.get(i).equals(title)) {
					rented.remove(i);
				}
			}
		}
		
	}

	public ArrayList<String> getQueue(boolean receive) {
		if(receive) {
			return receiving;
		}
		else {
			return rented;
		}
	}

	@Override
	public int compareTo(Customer customer) {
		return getName().compareTo(customer.getName());
	}
}
