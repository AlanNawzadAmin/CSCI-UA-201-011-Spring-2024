package OOPReview_final;

class Rectangle extends Object{
	private double length;
	private double width;
	
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}
	
	public Rectangle() {
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
}

class Square extends Rectangle{
	private double length;
	
	public Square(double length) {
		super(length, length);
//		You can use the super keyword to access overridden
//		methods and attributes, as well as custom constructors.
		
//		super.length = length;
		
//		super.setLength(length);
//		super.setWidth(width);
	}
	
//	You can override methods of the superclass
	public void setLength(double length) {
		super.setLength(length);
		super.setWidth(length);
	}
}

class helper {

}

public class InheritanceExampleGood {	
	static void function_square(Square s) {
		s.setLength(3.);
	}
	
	static void function_rectangle(Rectangle s) {
		s.setLength(3.);
	}
	
	public static void main(String [] args) {
		Square s1 = new Square(10.);
		
		System.out.println("length is " + s1.getLength());
		System.out.println("width is " + s1.getWidth());
		
////		Inheritance is "is a" relationship.
//		Rectangle r1 = new Rectangle(10., 10.);
//		Square s2 = new Square(10.);
//		
//		System.out.println(r1 instanceof Rectangle);
//		System.out.println(r1 instanceof Square);
//		System.out.println(s2 instanceof Rectangle);
//		System.out.println(s2 instanceof Square);
		
////		References can only point to their assigned class.
//		Rectangle r1;
//		r1 = new Square(10.);
//		Square s2;
//		s2 = new Rectangle(10., 10.);
		
////		The type of the reference is used by the compiler
////		to detect if fields or methods *can* be called.
//		Rectangle r1;
//		r1 = new Square(10.);
////		function_square(r1);
		
////		The method that is actually used is decided at runtime,
////		not compile time (Dynamic binding)!
//		Rectangle r1;
//		r1 = new Square(10.);
//		function_rectangle(r1);
//		System.out.println("length is " + s1.getLength());
//		System.out.println("width is " + s1.getWidth());

////		Casting creates a new reference that points to the same object
//		Square s3;
//		s3 = (Square) r1;
//		function_square(s3);
	}
}
