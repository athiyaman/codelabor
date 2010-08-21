package org.codelabor.javaprogramming.homework.exam11.circlepackage;

import org.codelabor.javaprogramming.homework.exam11.shapepackage.*;

public class Circle extends Shape {
	
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	public double getCircumference() {
		return radius * 2 * Math.PI;
	}

	public double getWidth() {
		return radius * 2;
	}

	public double getSquare() {
		return Math.pow(radius, 2) * Math.PI;
	}
}
