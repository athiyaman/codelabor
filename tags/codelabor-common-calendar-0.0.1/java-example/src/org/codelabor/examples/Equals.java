package org.codelabor.examples;

public class Equals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = "str";
		String str2 = "str";

		System.out.print("str1 == str2: ");
		System.out.println(str1 == str2);		
		System.out.print("str1.equals(str2): ");
		System.out.println(str1.equals(str2));
		System.out.println("str1.toString(): "+str1.toString());
		System.out.println("str2.toString(): "+str2.toString());
		System.out.println();
		
		String str3 = new String("str");
		String str4 = new String("str");

		System.out.print("str3 == str4: ");
		System.out.println(str3 == str4);		
		System.out.print("str3.equals(str4): ");
		System.out.println(str3.equals(str4));
		System.out.println("str3.toString(): "+str3.toString());
		System.out.println("str4.toString(): "+str4.toString());
		System.out.println();		
		
		Integer int1 = new Integer(0);
		Integer int2 = new Integer(0);

		System.out.print("int1 == int2: ");
		System.out.println(int1 == int2);		
		System.out.print("int1.equals(int2): ");
		System.out.println(int1.equals(int2));
		System.out.println("int1.toString(): "+int1.toString());
		System.out.println("int2.toString(): "+int2.toString());		
		System.out.println();
		
		Object obj1 = new Object();
		Object obj2 = new Object();

		System.out.print("obj1 == obj2: ");
		System.out.println(obj1 == obj2);		
		System.out.print("obj1.equals(obj2): ");
		System.out.println(obj1.equals(obj2));	
		System.out.println("obj1.toString(): "+obj1.toString());
		System.out.println("obj2.toString(): "+obj2.toString());		

		
		

	}

}
