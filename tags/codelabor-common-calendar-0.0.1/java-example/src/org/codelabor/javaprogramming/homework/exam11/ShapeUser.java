package org.codelabor.javaprogramming.homework.exam11;

import org.codelabor.javaprogramming.homework.exam11.shapepackage.Shape;
import org.codelabor.javaprogramming.homework.exam11.circlepackage.Circle;

public class ShapeUser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Shape shape = new Circle(5);
		System.out.println("s의 너비 = "+shape.getWidth());
		System.out.println("s의 넓 = "+shape.getSquare());
		System.out.println("s의 둘레 = "+shape.getCircumference());

	}

}
