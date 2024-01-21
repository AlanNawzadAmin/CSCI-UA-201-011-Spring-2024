package OOPReview;

class CircleShape {
	private double radius;
	private double area;
	private static double pi = 3.14159;
	
	public CircleShape(double radius) {
		this.radius = radius;
		this.area = pi * radius * radius;
	}
	
	public CircleShape() {
		this(1);
	}
	
	public void setRadius(float radius) {
		this.radius = radius;
		this.area = pi * radius * radius;	
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double getArea() {
		return area;
	}
	
	public double getPerimeter() {
		return 2 * pi * radius;
	}
}

class RectangleShape{
	private double length;
	private double width;
	
	public RectangleShape(double length, double width) {
		this.length = length;
		this.width = width;
	}
	
	public RectangleShape() {
		this(1, 1);
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public void setLength(double length) {
		this.length = length;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getLength() {
		return length;
	}
	
	public double getArea() {
		return length * width;
	}
	
	public double getPerimeter() {
		return 2 * (length + width);
	}
}

public class AbsractClassExample {
	static double perimeter_x_area(CircleShape c) {
		return c.getArea() * c.getPerimeter();
	}
	
	static double perimeter_x_area(RectangleShape c) {
		return c.getArea() * c.getPerimeter();
	}
		
	public static void main(String [] args) {
		CircleShape c1 = new CircleShape(3);
		RectangleShape r1 = new RectangleShape(3, 4);
		
		System.out.println(perimeter_x_area(c1));
		System.out.println(perimeter_x_area(r1));
	}
}
