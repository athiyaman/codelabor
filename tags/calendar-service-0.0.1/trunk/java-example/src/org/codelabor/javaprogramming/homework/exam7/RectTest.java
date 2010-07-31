package org.codelabor.javaprogramming.homework.exam7;

public class RectTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Rect rect = new Rect();
		int result;
		switch (args.length) {
		case 0: 
			System.out.println("인수의 개수가 적습니다.");
			break;
		case 1:
			result = rect.meth(Integer.parseInt(args[0]));
			System.out.println("정사각형의 넓이: "+result);
			break;
		case 2:
			result = rect.meth(Integer.parseInt(args[0]));
			System.out.println("직사각형의 넓이: "+result);
			break;
		case 3:
			result = rect.meth(Integer.parseInt(args[0]));
			System.out.println("정육면체의 넓이: "+result);
			break;
		default:
			System.out.println("인수의 개수가 많습니다. ");
			break;
		}
	}

}
