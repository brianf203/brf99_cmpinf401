public class Circle {
	
	private double radius = 5.0;
	String color = "Green";
	
	public Circle() {
		
	}
	
	public Circle(double radius) {
		
	}
	
	public Circle(double radius, String color) {
		
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public double getArea() {
		double area = Math.PI * radius * radius;
		return area;
	}
	
}