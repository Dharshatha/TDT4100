package encapsulation;

//Bruker stringbuilder siden den gjør at man kan endre en streng. 
public class LineEditor { 
	
	private StringBuilder text;
	private int insertionIndex;
	
	public LineEditor(String text) {
		this.text = new StringBuilder(text);
		this.insertionIndex = 0;
	}
	
	public LineEditor() {
		this.text=new StringBuilder("");
		this.insertionIndex = 0;
	}
	
	public LineEditor(String text, int insertionIndex) {
		this.text = new StringBuilder(text);
		if (insertionIndex<0) {
			throw new IllegalArgumentException("Du kan ikke ha negativ index");
		}
		else if (insertionIndex > text.length()) {
			throw new IllegalArgumentException("Du kan ikke ha større index enn tekstlengden");
		}
		else {
			this.insertionIndex = insertionIndex;
		}
		
	}
	
	public void left() {
		if (this.insertionIndex!=0) {
			this.insertionIndex= this.insertionIndex - 1;
		}
	}
	
	public void right() {
		if (this.insertionIndex<this.text.length()) {
			this.insertionIndex = this.insertionIndex + 1;
		}
	}
	
	public void insertString(String text) {
		this.text.insert(this.insertionIndex, text);
		this.insertionIndex = this.insertionIndex + text.length();
	}
	
	public void deleteLeft() {
		if (this.insertionIndex!=0) {
				this.text.deleteCharAt(this.insertionIndex-1);
				this.insertionIndex = this.insertionIndex -1;
		}
	}
	

	public void deleteRight() {
		int index = this.text.length();
		if (this.insertionIndex < index) {
			this.text.deleteCharAt(this.insertionIndex);
		}
	}
	
	public String getText() {
		return this.text.toString();
	}
	
	public void setText(String text) {
		this.text = new StringBuilder(text);
	}
	
	public void setInsertionIndex(int index) {
		if (index > this.text.length()) {
			throw new IllegalArgumentException("Du kan ikke ha større index enn tekstlengden");
		}
		else if (index< 0) {
			throw new IllegalArgumentException("Du kan ikke ha negativ indeks");
		}
		else {
			this.insertionIndex = index;
		}
	}
	
	public int getInsertionIndex() {
		return this.insertionIndex;
	}
	
	public String toString() {
		return this.text.toString();
	}
	
}