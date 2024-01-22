package OOPReview;


class Rectangle{
	private double length;
	private double width;
	
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}
	
	public Rectangle() {
		this.length = 1;
		this.width = 1;
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
		this.length = length;
	}
}

public class InheritanceExample {
	public static void main(String [] args) {
		Square s1 = new Square(10.);
		
		System.out.println("length is " + s1.getLength());
		System.out.println("width is " + s1.getWidth());
		
////		Which of these are true?
//		Rectangle r1 = new Rectangle(10., 10.);
//		Square s2 = new Square(10.);
//		
//		System.out.println(r1 instanceof Rectangle);
//		System.out.println(r1 instanceof Square);
//		System.out.println(s2 instanceof Rectangle);
//		System.out.println(s2 instanceof Square);
		
////		Which of these will raise an error?
//		Rectangle r1;
//		r1 = new Square(10.);
//		Square s2;
//		s2 = new Rectangle(10., 10.);
		
////		Will this code raise an error?
//		Rectangle r1;
//		r1 = new Square(10.);
//		function_rectangle(r1);
		
////		What will this code output?
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
