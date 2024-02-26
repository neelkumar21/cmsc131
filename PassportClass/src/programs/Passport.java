package programs;

/**
 * This class represents a person's passport. It has three instance variables
 * representing the first, last and middle name (all are String variables). A
 * character instance variable representing a separator (to be used for
 * formatting purposes) is also part of the class. In addition, the class has a
 * StringBuffer instance variable that represents the passport stamps the person
 * has received.
 * 
 * For this class you need to define and use a private method called
 * validateAndFormat that takes a character as a parameter.
 * 
 * The class will keep track of the number of instances created by using a
 * private static field called objectCount.
 * 
 * @author CS
 *
 */
public class Passport {
	String firstName;
	String middleName;
	String lastName;
	char separator;
	StringBuffer stamps;
	private static int objectCount = 0;

	public Passport(String firstname, String middlename, String lastname) {
		if (validateAndFormat(firstname) == null || middlename == null || validateAndFormat(lastname) == null) {
			return;
		}

		firstName = validateAndFormat(firstname);

		if (middlename.isBlank()) {
			middleName = "";
		} else {
			middleName = validateAndFormat(middlename);
		}
		lastName = validateAndFormat(lastname);

		stamps = new StringBuffer();
		objectCount++;
		separator = ',';
	}

	public String toString() {
		if (middleName.isBlank()) {
			return lastName + getSeparator() + firstName;
		}
		return lastName + getSeparator() + firstName + getSeparator() + middleName;

	}

	public Passport(String firstname, String lastname) {
		this(firstname, "", lastname);
		separator = ',';
	}

	public Passport() {
		this("SAMPLEFIRSTNAME", "SAMPLEMIDDLENAME", "SAMPLELASTNAME");
		separator = ',';
	}

	public Passport(Passport passport) {
		firstName = passport.firstName;
		middleName = passport.middleName;
		lastName = passport.lastName;

	}

	public Passport addStamp(String stamp) {
		if (!stamp.isBlank()) {
			stamps.append(stamp);
		}
		return this;

	}

	public StringBuffer getStamps() {
		return new StringBuffer(stamps);

	}

	public char getSeparator() {
		return separator;

	}

	public boolean setSeparator(char separator) {
		if (separator == '@' || Character.isSpaceChar(separator) || Character.isLetter(separator)) {
			return false;
		} else {
			this.separator = separator;
			return true;
		}

	}

	public boolean equals(Object obj) {

		Passport object = new Passport((Passport) obj);
		if (obj == this) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		if (this.firstName.equals(object.firstName.trim()) && this.middleName.equals(object.middleName.trim())
				&& this.lastName.equals(object.lastName.trim())) {
			return true;
		}

		return false;
	}

	public int compareTo(Passport passport) {
		int similarity = this.lastName.compareTo(passport.lastName);
		if (similarity != 0) {
			return similarity;
		} else {
			similarity = this.firstName.compareTo(passport.firstName);
			if (similarity != 0) {
				return similarity;
			} else {
				similarity = this.middleName.compareTo(passport.middleName);
			}

		}

		return similarity;
	}

	public static int getNumberOfPassportObjects() {
		return objectCount;
	}

	public static void resetNumberOfPassportObjects() {
		objectCount = 0;
	}

	public static Passport normalize(Passport passport, boolean uppercase) {
		if (passport == null) {
			return null;
		}
		if (uppercase) {
			passport.firstName = passport.firstName.toUpperCase();
			passport.middleName = passport.middleName.toUpperCase();
			passport.lastName = passport.lastName.toUpperCase();
		} else {
			passport.firstName = passport.firstName.toLowerCase();
			passport.middleName = passport.middleName.toLowerCase();
			passport.lastName = passport.lastName.toLowerCase();
		}
		return passport;
	}

	public boolean changeLastname(String lastname) {
		String changedLastName = validateAndFormat(lastname);
		if (changedLastName != null) {
			this.lastName = changedLastName;
			return true;
		}
		return false;
	}

	/*
	 * This method will generate and return a formatted string in lowercase with the
	 * first character in uppercase. The parameter is valid if it is not null and it
	 * is not blank according to the string method isBlank(). If the parameter is
	 * invalid, the method will return null and perform no further processing. If
	 * the parameter is valid, spaces surrounding the parameter will be removed, the
	 * string will be converted to lowercase, and the first character of the string
	 * (after spaces have been removed) will be in upper case. The following methods
	 * can be helpful during the implementation of this method:
	 * Character.toUpperCase, and the string methods charAt and substring.
	 * 
	 * You can test this method by initially defining it public; once you have
	 * tested it, make it private.
	 * 
	 */

	private static String validateAndFormat(String name) {
		name = name.trim();
		String formattedName = name;
		if (name == null || name.isBlank()) {
			return null;
		} else {
			formattedName = formattedName.toLowerCase();
			char uppercase = name.charAt(0);
			String lowercase = formattedName.substring(1);
			formattedName = uppercase + lowercase;
		}
		return formattedName;
	}
}