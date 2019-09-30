package com.akp.gfg.company.goldmansachs;

/**
 * This program is to find out if two rectangles overlap with each other and if
 * overlapping is found then prints the area of the overlapping area.
 * 
 * @author Ashish_Patel3
 *
 */
public class OverlappingRectangles {
	public static void main(String[] args) {
		Point l1 = new Point(1, 8);
		Point r1 = new Point(8, 1);

		Point l2 = new Point(5, 5);
		Point r2 = new Point(10, 1);

		boolean flag = isRectanglesOverlap(l1, r1, l2, r2);

		System.out.println("is rectangles overlaps : " + flag);

		if (flag) {

		}
	}

	private static boolean isRectanglesOverlap(Point l1, Point r1, Point l2, Point r2) {
		// If one rectangle is left side of others
		if (l1.x > r2.x || l2.x > r1.x) {
			return false;
		}

		// If one rectangle is above other
		if (l1.y < r2.y || l2.y < r1.y) {
			return false;
		}
		return true;
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
