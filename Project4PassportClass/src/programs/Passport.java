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
	private String firstname;
	private String middlename;
	private String lastname;
	private StringBuffer stamp = new StringBuffer();
	private char separator = ',';
	public static int OBJECT_COUNT = 0;

	public Passport(String firstname, String middlename, String lastname) {
		this.firstname = validateAndFormat(firstname);
		this.middlename = validateAndFormat(middlename);
		this.lastname = validateAndFormat(lastname);
		OBJECT_COUNT++;
	}

	public String toString() {
		if (middlename == null || middlename.isBlank()) {
			return lastname + separator + firstname;
		} else {
			return lastname + separator + firstname + separator + middlename;
		}

	}

	public Passport(String firstname, String lastname) {
		this(firstname, "", lastname);
	}

	public Passport() {
		this("Samplefirstname", "Samplemiddlename", "Samplelastname");
	}

	public Passport(Passport passport) {

		this.firstname = passport.firstname;
		this.middlename = passport.middlename;
		this.lastname = passport.lastname;
		this.stamp = new StringBuffer(passport.stamp);
		this.separator = passport.separator;
	}

	public Passport addStamp(String stamp) {
		if (!stamp.equals(null) && !stamp.isBlank()) {
			this.stamp.append(stamp);
		}
		return this;
	}

	public StringBuffer getStamps() {
		StringBuffer stampCopy = new StringBuffer(stamp);
		return stampCopy;
	}

	public char getSeparator() {
		return this.separator;
	}

	public boolean setSeparator(char separator) {
		if (separator != '@' && !Character.isSpaceChar(separator) && !Character.isLetter(separator)) {
			this.separator = separator;
			return true;
		}else {
			return false;
		}
	}

	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		} else if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Passport passport = (Passport) obj;

		if (firstname.equals(passport.firstname)) {
			return true;
		}
		if (middlename.equals(passport.middlename)) {
			return true;
		}
		if (lastname.equals(passport.lastname)) {
			return true;
		}
		return false;
	}

	public int compareTo(Passport passport) {
		String passStr = passport.toString();
		String passOrig = lastname + ',' + firstname + ',' + middlename;
		int x = passOrig.compareTo(passStr);
		return x;
	}

	public static int getNumberOfPassportObjects() {
		return OBJECT_COUNT;
	}

	public static void resetNumberOfPassportObjects() {
		OBJECT_COUNT = 0;
	}

	public static Passport normalize(Passport passport, boolean uppercase) {
		Passport normPass = new Passport();
		normPass.separator = passport.separator;
		normPass.stamp = new StringBuffer(passport.stamp);

		if (uppercase == true) {
			normPass.lastname = passport.lastname.toUpperCase();
			normPass.middlename = passport.middlename.toUpperCase();
			normPass.firstname = passport.firstname.toUpperCase();
		} else {
			normPass.lastname = passport.lastname.toLowerCase();
			normPass.middlename = passport.middlename.toLowerCase();
			normPass.firstname = passport.firstname.toLowerCase();
		}
		return normPass;
	}

	public boolean changeLastname(String lastname) {
		if (!lastname.equals(this.lastname) && !lastname.isBlank()) {
			this.lastname = lastname;
			return true;
		} else {
			return false;
		}
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
		if (name != null && !name.isBlank()) {
			name = name.trim();
			name = name.toLowerCase();
			name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
		}

		return name;
	}
}