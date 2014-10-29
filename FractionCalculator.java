public class FractionCalculator {

	FractionCalculator calculator = new FractionCalculator();
	InputElement firstElement = new InputElement();
	InputElement currentElement = firstElement;
	Fraction currentFraction = null;
	Fraction nextFraction = null;
	String operation = null;
	boolean nextIsFraction = true;
	boolean keepGoing = true;

	public void start() {
		System.out.print("Enter the operation: ");
		String input = System.console().readLine();
		addInput(input);
		performOperation();
	}

	// Put input into separate objects with strings
	public void addInput(String s) {
		boolean newElement = true;

		for (int i = 0; i < s.length(); i++) {

			// Determine type of next element
			if (newElement) {
				newElement = false;
				if (Character.isDigit(s.charAt(i))) {
					currentElement.isFraction = true;
				} else {
					currentElement.isFraction = false;
				}
			}

			// Add elements to linked list
			if (s.charAt(i) == ' ') {
				currentElement.add();
				currentElement = currentElement.nextElement;
				newElement = true;
			} else {
				currentElement.element += s.charAt(i);
			}
		}
	}

	public void performOperation() {
		currentElement = firstElement;
		while (keepGoing) {
			if (currentElement.isFraction) { // If current element is fraction
				if (currentFraction != null) { // If we have current fraction
					if (operation != null) { // If we have an operation
						// Perform the operation
					} else { // If we don't have an operation
						// TODO Print error and restart
					}
				} else { // If we don't have current fraction
					currentFraction = stringToFraction(currentElement.element); // Assign current fraction
				}
			} else { // If current element is operation

				// Analyze the operation; either perform the operation on current fraction or remember the operation
				if (isStandaloneOperation(currentElement.element)) { // If it's a standalone operation
					currentFraction = performStandaloneOperation(currentElement.element); // Perform the operation on
																							// current fraction
				} else { // If it's an operation that is performed on two fractions
					operation = currentElement.element;
				}
			}
			if (currentElement.nextElement != null) { // If there are more elements in the list
				currentElement = currentElement.nextElement; // Cycle to next element
			} else {
				break; // End the program
			}

		}
	}

	public boolean isStandaloneOperation(String s) {
		switch (s) {
		case "+":
		case "-":
		case "*":
		case "/":
			return false;
		}
		return true;
	}

	public Fraction performStandaloneOperation(String s) {
		Fraction performedFraction = new Fraction(0, 1);
		switch (s) {
		case "a":
		case "A":
		case "abs":
			performedFraction = currentFraction.absValue();
			break;
		case "n":
		case "N":
		case "neg":
			performedFraction = currentFraction.negate();
			break;
		case "c":
		case "C":
		case "clear":
			operation = "";
			currentFraction = null;
			break;
		case "q":
		case "Q":
		case "quit":
			keepGoing = false;
			break;
		}
		return performedFraction;
	}

	public void evaluate(Fraction fraction, String inputString) {

	}

	public Fraction stringToFraction(String s) {
		boolean isNumerator = true;
		int numerator = 0;
		int denominator = 1;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				if (isNumerator) {
					numerator = Character.getNumericValue(c);
				} else {
					denominator = Character.getNumericValue(c);
				}

			} else if (c == '/') {
				isNumerator = false;
			} else if (c == ' ') {
			} else {
				// TODO Print error and restart
			}
		}
		return new Fraction(numerator, denominator);
	}

	public void printErrorAndRestart() {
		System.out.println("Error");
		firstElement = new InputElement();
		currentElement = firstElement;
		currentFraction = null;
		nextFraction = null;
		operation = null;
		nextIsFraction = true;
		keepGoing = true;
		start();
	}

}
