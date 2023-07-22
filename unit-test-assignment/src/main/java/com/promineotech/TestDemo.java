package com.promineotech;
import java.util.Random;
import java.util.random.RandomGenerator;
public class TestDemo {


		
	public int addPositive(int a, int b) {
		if(a > 0 && b > 0) {
			int sum = a + b;
			return sum;
		}else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
			
	}
	
	public double addItemsInCart(double x, double y, double z) {
		if(x > 0.0 && y > 0.0 && z > 0.0 ) {
			double cartTotal = x + y + z;
			return cartTotal;
		} else {
			throw new IllegalArgumentException("Items in the cart must be positive!");
		}
	}
	
	public int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
	
	public int randomNumberSquared() {
		int squared = getRandomInt() * getRandomInt();
		return squared;
	}
}

