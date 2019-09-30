
public class RectangleOverlapingExample {
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(new Point(1, 1), new Point(2, 2));
		Rectangle r2 = new Rectangle(new Point(3, 3), new Point(4, 4));

		boolean areOverlapping = r1.isOverlapping(r2);
		System.out.println("areOverlapping : " + areOverlapping);

		calculateArea(r1, r2);
	}

	private static void calculateArea(Rectangle r1, Rectangle r2) {
		if (r1.isOverlapping(r2)) {
			//Calculating the bottom left and top right of the intersection
			Rectangle intersectedRectangle = null;
			/*if(r2.) {
				
			}*/
		} else {
			System.out.println("The rectangles doesn't overlap");
		}
	}
}

class Rectangle {
	private Point bottomLeft;
	private Point topRight;

	public Rectangle(Point bottomLeft, Point topRight) {
		super();
		this.bottomLeft = bottomLeft;
		this.topRight = topRight;
	}

	public Point getBottomLeft() {
		return bottomLeft;
	}

	public void setBottomLeft(Point bottomLeft) {
		this.bottomLeft = bottomLeft;
	}

	public Point getTopRight() {
		return topRight;
	}

	public void setTopRight(Point topRight) {
		this.topRight = topRight;
	}

	boolean isOverlapping(Rectangle other) {
		if (this.topRight.getY() < other.bottomLeft.getY() || this.bottomLeft.getY() > other.topRight.getY()) {
			return false;
		}

		if (this.topRight.getX() < other.bottomLeft.getX() || this.bottomLeft.getX() > other.topRight.getX()) {
			return false;
		}
		return true;
	}
}

class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
