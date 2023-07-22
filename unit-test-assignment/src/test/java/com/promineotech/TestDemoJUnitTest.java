package com.promineotech;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import com.promineotech.TestDemo;

import static org.junit.jupiter.params.provider.Arguments.arguments;


class TestDemoJUnitTest {

	private TestDemo testDemo;
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectedException) {
		
		if(!expectedException) {
			assertThat(testDemo.addPositive(a,b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(arguments(2, 4, 6, false));
	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly1() {
		assertThat(testDemo.addPositive(4,5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40,50)).isEqualTo(90);
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddItemsInCart")
	void assertThatItemsInCartAreAddedCorrectly(double x, double y, double z, double expected, boolean expectedException) {
		
		if(!expectedException) {
			assertThat(testDemo.addItemsInCart(x,y,z)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addItemsInCart(x,y,z)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	

	static Stream<Arguments> argumentsForAddItemsInCart() {
	return Stream.of(arguments(1.99, 5.50, 2.00, 9.49, false));
	}

	@Test
	void assertThatItemsInCartAreAddedCorrectly() {
	assertThat(testDemo.addItemsInCart(3.00,5.50,6.75)).isEqualTo(15.25);
	assertThat(testDemo.addItemsInCart(40.15,75.50,100.25)).isEqualTo(215.90);
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}
}
