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
			System.out.println("�μ��� ������ �����ϴ�.");
			break;
		case 1:
			result = rect.meth(Integer.parseInt(args[0]));
			System.out.println("���簢���� ����: "+result);
			break;
		case 2:
			result = rect.meth(Integer.parseInt(args[0]));
			System.out.println("���簢���� ����: "+result);
			break;
		case 3:
			result = rect.meth(Integer.parseInt(args[0]));
			System.out.println("������ü�� ����: "+result);
			break;
		default:
			System.out.println("�μ��� ������ �����ϴ�. ");
			break;
		}
	}

}
