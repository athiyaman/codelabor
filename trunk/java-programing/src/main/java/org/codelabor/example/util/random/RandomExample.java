package org.codelabor.example.util.random;

import java.util.Random;

public class RandomExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random random = new Random();
		
		System.out.println("[boolean]");
		for (int i=0; i<10; i++) {
			boolean randomBoolean = random.nextBoolean();
			System.out.println(randomBoolean);
		}
		
		System.out.println("[byte]");
		for (int i=0; i<10; i++) {
			byte[] randomBytes = new byte[16];
			random.nextBytes(randomBytes);
			System.out.println(randomBytes);
		}		
		
		System.out.println("[int]");
		for (int i=0; i<10; i++) {
			int randomNumber = random.nextInt();
			System.out.println(randomNumber);
		}
		
		System.out.println("[long]");
		for (int i=0; i<10; i++) {
			long randomNumber = random.nextLong();
			System.out.println(randomNumber);
		}
		
		System.out.println("[float]");
		for (int i=0; i<10; i++) {
			float randomNumber = random.nextFloat();
			System.out.println(randomNumber);
		}
		
		System.out.println("[double]");
		for (int i=0; i<10; i++) {
			double randomNumber = random.nextDouble();
			System.out.println(randomNumber);
		}
		
		System.out.println("[gaussian]");
		for (int i=0; i<10; i++) {
			double randomNumber = random.nextGaussian();
			System.out.println(randomNumber);
		}
		
				
		
		


	}

}
