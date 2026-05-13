package ubu.gii.dass.refactoring;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer {
	private String _name;
	private List<Rental> _rentals;

	public Customer(String name) {
		_name = name;
		_rentals = new ArrayList<Rental>();
	}

	public void addRental(Rental arg) { _rentals.add(arg); }
	public String getName() { return _name; }

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = _rentals.iterator();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasNext()) {
			Rental each = rentals.next();
			
			double thisAmount = each.getCharge();
			frequentRenterPoints += each.getFrequentRenterPoints();
			
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return result;
	}

	public String htmlStatement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = _rentals.iterator();
		String result = "<h1>Rental Record for <em>" + getName() + "</em></h1>\n";
		result += "<table>\n";
		while (rentals.hasNext()) {
			Rental each = rentals.next();
			
			double thisAmount = each.getCharge();
			frequentRenterPoints += each.getFrequentRenterPoints();
			
			result += "<tr><td>" + each.getMovie().getTitle() + "</td><td>" + String.valueOf(thisAmount) + "</td></tr>\n";
			totalAmount += thisAmount;
		}
		result += "</table>\n";
		result += "<p>Amount owed is <em>" + String.valueOf(totalAmount) + "</em></p>\n";
		result += "<p>You earned <em>" + String.valueOf(frequentRenterPoints) + "</em> frequent renter points</p>";
		return result;
	}
}
