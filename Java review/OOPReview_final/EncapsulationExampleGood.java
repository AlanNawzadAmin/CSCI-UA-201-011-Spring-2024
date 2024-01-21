package OOPReview_final;

class Circle {
//	You should use the principle of least privilege
	private double radius;
	private double area;
	private static double pi = 3.14159;
	
	public Circle(double radius) {
		this.radius = radius;
		this.area = pi * radius * radius;
	}
	
//	We can overload constructors.
//	You can call one constructor from another
	public Circle() {
		this(1);
	}
	
//	You should use accessor methods to encapsulate
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
}

public class EncapsulationExampleGood {
	public static void main(String [] args) {
		Circle c1;
		c1 = new Circle();
		Circle c2;
		c2 = new Circle(2.);
		
		System.out.println("radius is " + c1.getRadius());
		System.out.println("area is " + c1.getArea());
		System.out.println("radius is " + c2.getRadius());
		System.out.println("area is " + c2.getArea());
		
//		Note the difference between references and objects
//		c2 = c1 makes c2 point to the object at c1 so changes
//		to c2 will also affect c1.
		c2 = new Circle(c1.getRadius());
		c2.setRadius(10);
		System.out.println("radius is " + c1.getRadius());
		System.out.println("area is " + c1.getArea());
		System.out.println("radius is " + c2.getRadius());
		System.out.println("area is " + c2.getArea());
		
//		Encapsulate methods to change radius and area together
		c1.setRadius(4);
		
		System.out.println("radius is " + c1.getRadius());
		System.out.println("area is " + c1.getArea());
	}
}
