package mediaRentalManager;

import java.util.ArrayList;
import java.util.Collections;

public class MediaRentalManager implements MediaRentalManagerInt {
	ArrayList<Customer> customers = new ArrayList<>();
	ArrayList<Media> media = new ArrayList<>();
	int limit = 2;

	@Override
	public void addCustomer(String name, String address, String plan) {
		customers.add(new Customer(name, address, plan));
	}

	@Override
	public void addMovie(String title, int copiesAvailable, String rating) {
		media.add(new Movies(title, copiesAvailable, rating));
	}

	@Override
	public void addAlbum(String title, int copiesAvailable, String artist, String songs) {
		media.add(new Album(title, copiesAvailable, artist, songs));

	}

	@Override
	public void setLimitedPlanLimit(int value) {
		limit = value;
	}

	@Override
	public String getAllCustomersInfo() {
		String customerOutput = "";
		customerOutput += "***** Customers' Information *****\n";
		Collections.sort(customers);
		for (int i = 0; i <= customers.size() - 1; i++) {
			customerOutput += "Name: " + customers.get(i).getName();
			customerOutput += ", Address: " + customers.get(i).getAddress();
			customerOutput += ", Plan: " + customers.get(i).getPlan() + "\n";
			customerOutput += "Rented: " + customers.get(i).getQueue(false) + "\n";
			customerOutput += "Queue: " + customers.get(i).getQueue(true) + "\n";

		}

		return customerOutput;

	}

	@Override
	public String getAllMediaInfo() {
		Collections.sort(media);
		String mediaOutput = "";
		mediaOutput += "***** Media Information *****\n";

		for (int i = 0; i < media.size(); i++) {
			if (media.get(i) instanceof Movies) {
				if (media.get(i).getTitle() != null)
					mediaOutput += "Title: " + media.get(i).getTitle();
				mediaOutput += ", Copies Available: " + media.get(i).getCopiesAvailable();
				if (media.get(i).getRating() != null)
					mediaOutput += ", Rating: " + media.get(i).getRating();
				mediaOutput += "\n";
			} else {
				if (media.get(i).getTitle() != null)
					mediaOutput += "Title: " + (media.get(i)).getTitle();
				mediaOutput += ", Copies Available: " + (media.get(i)).getCopiesAvailable();
				if (media.get(i).getArtist() != null)
					mediaOutput += ", Artist: " + (media.get(i)).getArtist();
				if (media.get(i).getSongs() != null)
					mediaOutput += ", Songs: " + (media.get(i)).getSongs();
				mediaOutput += "\n";
			}
		}

		return mediaOutput;
	}

	@Override
	public boolean addToQueue(String customerName, String mediaTitle) {
		for (int i = 0; i <= customers.size() - 1; i++) {
			if (customerName.equals(customers.get(i).getName())) {
				for (int j = 0; j <= customers.get(i).getQueue(true).size() - 1; j++) {
					if (customers.get(i).getQueue(true).size() == 0) {
						break;
					} else if (mediaTitle.equals(customers.get(i).getQueue(true).get(j))) {
						return false;
					}
				}
				customers.get(i).addToQueue(mediaTitle, true);

			}
		}
		return true;
	}

	@Override
	public boolean removeFromQueue(String customerName, String mediaTitle) {
		for (int i = 0; i <= customers.size() - 1; i++) {
			if (customerName.equals(customers.get(i).getName())) {
				customers.get(i).removeQueue(mediaTitle, true);
				return true;
			}

		}

		return false;
	}

	@Override

	public String processRequests() {
		String result = "";
		Collections.sort(customers);

		for (int i = 0; i <= customers.size() - 1; i++) {
			int length = customers.get(i).getQueue(true).size();
			int count = 0;

			for (int j = 0; j <= length - 1; j++) {
				for (int m = 0; m <= media.size()-1; m++) {
					String mediaTitle = media.get(m).getTitle();
					if (mediaTitle.equals(customers.get(i).getQueue(true).get(count))) {
						if (media.get(m).getCopiesAvailable() > 0) {
							if (customers.get(i).getPlan().equals("UNLIMITED")) {
								customers.get(i).removeQueue(mediaTitle, true);
								customers.get(i).addToQueue(mediaTitle, false);
								media.get(m).changeCopies(-1);
								result += "Sending " + mediaTitle + " to " + customers.get(i).getName() + "\n";
								break;
							} else if (customers.get(i).getPlan().equals("LIMITED")) {
								if (customers.get(i).getQueue(false).size() < limit) {
									customers.get(i).removeQueue(mediaTitle, true);
									customers.get(i).addToQueue(mediaTitle, false);
									media.get(m).changeCopies(-1);
									result += "Sending " + mediaTitle + " to " + customers.get(i).getName() + "\n";
									break;
								}
							}
						} else {
							count++;
						}
					}
				}
			}
		}
		return result;
	}

	@Override
	public boolean returnMedia(String customerName, String mediaTitle) {
		for (int i = 0; i <= customers.size() - 1; i++) {
			if (customers.get(i).getName().equals(customerName)) {
				for (int j = 0; j <= customers.get(i).getQueue(false).size() - 1; j++) {
					if (customers.get(i).getQueue(false).get(j).equals(mediaTitle)) {
						customers.get(i).removeQueue(mediaTitle, false);
						for (int m = 0; m < media.size(); m++) {
							if ((media.get(m)).getTitle().equals(mediaTitle)) {
								(media.get(m)).changeCopies(1);
							}
						}

					}
					return true;
				}
			}

		}

		return false;
	}

	@Override
	public ArrayList<String> searchMedia(String title, String rating, String artist, String songs) {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i <= media.size() - 1; i++) {
			if (media.get(i) instanceof Movies) {
				if (title == null || media.get(i).getTitle().equals(title)) {
					if (rating == null || media.get(i).getRating().equals(rating)) {
						if (artist == null && songs == null) {
							list.add((media.get(i)).getTitle());
						}
					}
				}

			} else {
				if (title == null || media.get(i).getTitle().equals(title)) {
					if (songs == null || media.get(i).getSongs().contains(songs)) {
						if (artist == null || media.get(i).getArtist().equals(artist)) {
							if (rating == null) {
								list.add((media.get(i)).getTitle());
							}

						}
					}
				}
			}
		}
		Collections.sort(list);
		return list;
	}

}
