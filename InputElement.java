
public class InputElement {
	public String element;
	public InputElement nextElement;
	public boolean isFraction;
	
	public InputElement() {
		element = "";
		nextElement = null;
		isFraction = true; // Fraction or operation
	}
	
	public void add() {
		if (nextElement == null) {
			nextElement = new InputElement();
		} else {
			nextElement.add();
		}
	}
	

}
