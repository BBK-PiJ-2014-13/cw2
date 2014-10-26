
public class InputElement {
	String element;
	InputElement nextElement;
	
	public InputElement() {
		element = "";
		nextElement = null;
	}
	
	public void add() {
		if (nextElement == null) {
			nextElement = new InputElement();
		} else {
			nextElement.add();
		}
	}
	

}
