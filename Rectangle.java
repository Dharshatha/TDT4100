package encapsulation;

public class Rectangle {
	private int minY;
	private int minX;
	private int maxY;
	private int maxX;

	
	public Rectangle(){
		this.maxX=0;
		this.minX=0;
		this.maxY =0;
		this.minY =0;
		
	}
	
	public int getMinX() {
		return this.minX;
	}
	
	public int getMinY() {
		return this.minY;
	}
	
	public int getMaxX() {
		return this.maxX;
	}
	
	public int getMaxY() {
		return this.maxY;
	}
	
	public void setMinX(int minx) {
		this.minX = minx;
	}
	
	public void setMinY(int miny) {
		this.minY = miny;
	}
	
	public void setMaxX(int maxx) {
		this.maxX = maxx;
	}
	
	public void setMaxY(int maxy) {
		this.maxY = maxy;
	}
	
	public int getWidth() {
		if (this.isEmpty()) {
			return 0;
		}
		else if (this.maxX == this.minX) {
			return 1;
		}
		else {
		int Width = this.maxX - this.minX +1;
		return Width;
		}
	}
	
	public int getHeight() {
		if (this.isEmpty()) {
			return 0;
		}
		
		else if (this.maxY == this.minY) {
			return 1;
		}
		else {
		int Height = this.maxY - this.minY+1;
		return Height;
		}
	}
	
	public boolean isEmpty() {
		if ((getMinX() == 0 && getMaxX()==0) || (getMaxY()==0) || (getMinY()==0))  {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	// Sjekker om rektangelet rect er innenfor vårt rektangel.	
	public boolean contains(int x, int y) {
		int y1 = this.minY;
		int y2 = this.maxY;
		int x1 = this.minX;
		int x2 = this.maxX;
		
		if(this.isEmpty()) {
			return false;
		}
		
		if (y1 <= y  && y <= y2 && x1 <= x && x<=x2) {
			return true;
		}
		

		else {
			return false;
		}		
	}
	
// Sjekker om rektangelet rect er innenfor vårt rektangel.	
	public boolean contains (Rectangle rect) {
		int y1 = this.minY;
		int y2 = this.maxY;
		int x1 = this.minX;
		int x2 = this.maxX;
		if ((y1 <= rect.getMinY()) && (y2 >= rect.getMaxY()) && (x1 <= rect.getMinX()) && (x2 >= rect.getMaxX())) {
			return true;
		}
		
		else if(rect.isEmpty()) {
			return false;
		}
		else {
			return false;
		}
		
	}
	
	public boolean add(int x,int y) {
		int sjekkX = this.maxX + this.minX;
		int sjekkY = this.maxY + this.minY;
		if(this.isEmpty()) {
			this.setMinX(x);
			this.setMinY(y);
			this.setMaxX(x);
			this.setMaxY(y);
			return true;
		}
		else {
			if (getMinX() > x) {
				this.setMinX(x);
			}
			if (getMaxX() < x) {
				this.setMaxX(x);				
			}
			if (getMinY() > y) {
				this.setMinY(y);
			}
			if (getMaxY() < y) {
				this.setMaxY(y);
			}
			
			if((sjekkX != maxX + minX) || (sjekkY != maxY + minY))
			{
				return true;
			}
			return false;
		}		
	}
	
	
	
	public boolean add(Rectangle rect) {
		int sjekkX = this.maxX + this.minX;
		int sjekkY = this.maxY + this.minY;
		if(this.isEmpty()) {
			this.setMinX(rect.getMinX());
			this.setMinY(rect.getMinY());
			this.setMaxX(rect.getMaxX());
			this.setMaxY(rect.getMaxY());
			return true;
		}
		else {
			if (getMinX() > rect.getMinX()) {
				this.setMinX(rect.getMinX());
			}
			if (getMaxX() < rect.getMaxX()) {
				this.setMaxX(rect.getMaxX());				
			}
			if (getMinY() > rect.getMinY()) {
				this.setMinY(rect.getMinY());
			}
			if (getMaxY() < rect.getMaxY()) {
				this.setMaxY(rect.getMaxY());
			}
			
			if((sjekkX != maxX + minX) || (sjekkY != maxY + minY))
			{
				return true;
			}
			return false;
		}		
	}
	
	public Rectangle union(Rectangle rec)
	{
		Rectangle ny_rect = new Rectangle();
		ny_rect.add(rec);
		ny_rect.add(this);		
		return ny_rect;
	}
	

}
 
