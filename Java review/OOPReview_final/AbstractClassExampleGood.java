package OOPReview_final;

// Abstract classes can save you code by polymorphism
abstract class Shape{
	private String color;
	
	public Shape() {
		color = "white";
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}

//	public abstract double getPerimeter();
//	public abstract double getArea();
}

class blob_shape extends Shape{
	private double wigglyness;
	
	public void setWigglyness(double wigglyness) {
		this.wigglyness = wigglyness;
	}
	
	public double getWigglyness() {
		return wigglyness;
	}
}

//Interfaces are similar to abstract classes but
//can be multiply inherited
interface ShapeWithAreaPerimeter{
	public abstract double getPerimeter();
	public abstract double getArea();
}

class CircleShape extends Shape implements ShapeWithAreaPerimeter{
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

class RectangleShape extends Shape implements ShapeWithAreaPerimeter{
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

public class AbstractClassExampleGood {
	static double perimeter_x_area(ShapeWithAreaPerimeter c) {
		return c.getArea() * c.getPerimeter();
	}
		
	public static void main(String [] args) {
		CircleShape c1 = new CircleShape(3);
		RectangleShape r1 = new RectangleShape(3, 4);
		
		System.out.println(perimeter_x_area(c1));
		System.out.println(perimeter_x_area(r1));
		System.out.println(r1.getColor());
		
////		Abstract classes cannot be instantiated
//		Shape s1 = new Shape();
	}
}
