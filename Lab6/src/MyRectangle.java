public class MyRectangle {
	
	private int width;
	private int height;
	private int startX;
	private int startY;

	public MyRectangle() {
		this.startX = 0;
		this.startY = 0;
		this.width = 0;
		this.height = 0;
	}

	public MyRectangle(int x, int y, int w, int h) {
		this.startX = x;
		this.startY = y;
		this.width = w;
		this.height = h;
	}

	public int area() {
		return width * height;
	}

	public String toString() {
		StringBuilder S = new StringBuilder();
		S.append("Width: " + width);
		S.append(" Height: " + height);
		S.append(" X: " + startX);
		S.append(" Y: " + startY);
		return S.toString();
	}

	public boolean isInside(int x, int y) {
		if(startX <= x && x <= startX + width && startY <= y && y <= startY + height) {
			return true;
		}
		else {
			return false;
		}
	}

	public void setSize(int w, int h) {
		this.width = w;
		this.height = h;
	}

	public void setPosition(int x, int y) {
		this.startX = x;
		this.startY = y;
	}

}