public class FractionCalculatorTest {
	public static void main(String[] args) {
		FractionCalculator calculator = new FractionCalculator();
		InputElement firstElement = new InputElement();
		InputElement currentElement = firstElement;

		boolean haveFirstElement = false;
		String input = "";

		System.out.print("Enter the operation: ");
		input = System.console().readLine();

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == ' ') {
				currentElement.add();
				currentElement = currentElement.nextElement;
			} else {
			currentElement.element += input.charAt(i);
			}
		}
		
		System.out.println(firstElement.element);
		System.out.println(firstElement.nextElement.element);
	}
}
