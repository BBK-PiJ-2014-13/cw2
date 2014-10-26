/**
 * Created by keith for the second coursework assignment.
 */

/* Modified by Ilya Ivanov for second coursework assignment. */

public class Fraction {
	private int numerator;
	private int denominator;

	public Fraction(int num, int denom) {
		if (denom == 0) {
			System.out.println("Invalid fraction with denominator 0");
			// this should use exceptions
			return;
		}
		int gcd = myGcd(num, denom);
		setNumerator(num / gcd);
		setDenominator(denom / gcd);
	}

	@Override
	// TODO Untested
	public String toString() {
		if (getNumerator() == 1) {
			return "" + getNumerator();
		}
		return "" + getNumerator() + '/' + getDenominator();
	}

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int num) {
		numerator = num;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int num) {
		denominator = num;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Fraction fraction = (Fraction) o;

		if (getDenominator() != fraction.getDenominator())
			return false;
		if (getNumerator() != fraction.getNumerator())
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = numerator;
		result = 31 * result + denominator;
		return result;
	}

	// TODO Untested
	public Fraction add(Fraction other) {
		int thisNum = this.getNumerator();
		int thisDenom = this.getDenominator();
		int otherNum = other.getNumerator();
		int otherDenom = other.getDenominator();
		if (thisDenom == otherDenom) {
			thisNum += otherNum;
		} else {
			thisNum = thisNum * otherDenom + otherNum * thisDenom;
			thisDenom *= otherDenom;

		}
		return new Fraction(thisNum, thisDenom);
	}

	// TODO Untested
	public Fraction subtract(Fraction other) {
		int thisNum = this.getNumerator();
		int thisDenom = this.getDenominator();
		int otherNum = other.getNumerator();
		int otherDenom = other.getDenominator();
		if (thisDenom == otherDenom) {
			thisNum -= otherNum;
		} else {
			thisNum = thisNum * otherDenom - otherNum * thisDenom;
			thisDenom *= otherDenom;

		}

		return new Fraction(thisNum, thisDenom);
	}

	public Fraction multiply(Fraction other) {

		int num = this.getNumerator() * other.getNumerator();
		int denom = this.getDenominator() * other.getDenominator();
		return new Fraction(num, denom);
	}

	// TODO Untested
	public Fraction divide(Fraction other) {
		int thisNum = this.getNumerator();
		int thisDenom = this.getDenominator();
		int otherNum = other.getNumerator();
		int otherDenom = other.getDenominator();
		Fraction divisor = new Fraction(thisNum, thisDenom);
		Fraction dividend = new Fraction(otherDenom, otherNum);
		return divisor.multiply(dividend);
	}

	// TODO Untested
	public Fraction absValue() {
		int thisNum = this.getNumerator();
		int thisDenom = this.getDenominator();
		if (thisNum < 0) {
			thisNum = 0 - thisNum;
		}
		return new Fraction(thisNum, thisDenom);
	}

	// TODO Untested
	public Fraction negate() {
		int thisNum = this.getNumerator();
		int thisDenom = this.getDenominator();
		thisNum = 0 - thisNum;
		return new Fraction(thisNum, thisDenom);
	}

	private int myGcd(int a, int b) {
		while (b != 0) {
			int t = b;
			b = a % b;
			a = t;
		}
		return a;
	}
}
