package org.codelabor.javaprogramming.homework.exam8;


public class ARectangleTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ARectangle r1 = new ARectangle();
		ARectangle r2 = new ARectangle(20, 20);
		ARectangle r3 = new ARectangle(10, 20, 30, 30);
		r1.print();
		r2.print();
		r3.print();
	}

}
