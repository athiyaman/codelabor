package org.codelabor.javaprogramming.homework.exam8;


public class ARectangle extends APoint {

	protected int width;
	protected int height;

	public ARectangle(int i, int j) {
		this.width = i;
		this.height = j;
	}

	public ARectangle() {
		super();
	}

	public ARectangle(int i, int j, int k, int l) {
		super(i, j);
		this.width = k;
		this.height = l;
	}

	public void print() {
		System.out.println("x="+super.x+", y="+super.y+", width="+width+", height="+height);
	}
	
	

}
