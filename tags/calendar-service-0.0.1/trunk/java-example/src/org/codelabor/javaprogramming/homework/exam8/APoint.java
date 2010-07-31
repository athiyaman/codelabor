package org.codelabor.javaprogramming.homework.exam8;

public class APoint {
	protected int x;
	protected int y;
	
	public APoint() {
		this(0, 0);
	}

	public APoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void print() {
		System.out.println("x="+x+", y="+y);
	}
}
