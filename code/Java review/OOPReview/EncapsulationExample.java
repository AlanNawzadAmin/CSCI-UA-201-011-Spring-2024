package OOPReview;

class Circle {
	public double radius;
	public double area;
	public static double pi = 3.14159;
	
	public Circle(double radius) {
		this.radius = radius;
		this.area = pi * radius * radius;
	}
	
//	We can overload constructors.
//	Can we make this constructor simpler?
	public Circle() {
		this.radius = 1;
		this.area = pi;
	}
}

public class EncapsulationExample {
	public static void main(String [] args) {
		Circle c1 = new Circle();
		Circle c2 = new Circle(2.);
		
		System.out.println("radius is " + c1.radius);
		System.out.println("area is " + c1.area);
		System.out.println("radius is " + c2.radius);
		System.out.println("area is " + c2.area);
		
////		Is this a good way of copying a circle if
////		we do not want changes to c2 to affect c1?
//		c2 = c1;
//		c2.radius = 10;
//		c2.area = Circle.pi * 10 * 10;
//		System.out.println("radius is " + c1.radius);
//		System.out.println("area is " + c1.area);
//		System.out.println("radius is " + c2.radius);
//		System.out.println("area is " + c2.area);
//				
////		Is there a better way to do this?
//		c1.radius = 4;
//		c1.area = Circle.pi * 4 * 4;
//		
//		System.out.println("radius is " + c1.radius);
//		System.out.println("area is " + c1.area);
	}
}
