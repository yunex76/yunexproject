package com.yunex.junitbook.ch02;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.yunex.junitbook.ch01.Calculator;

/**
 * 파라미터화 테스트
 * @author 남윤혁
 * @since 2011-11-23
 */
@RunWith(value=Parameterized.class)
public class ParameterizedTest {

	private double expected;
	private double valueOne;
	private double valueTwo;
	
	@Parameters
	public static Collection<Integer[]> getTestParameters() {
		return Arrays.asList(new Integer[][] {
				{2, 1, 1},	// 예상값, 값1, 값2
				{3, 2, 1},	// 예상값, 값1, 값2
				{4, 3, 1},	// 예상값, 값1, 값2
		});
	}
	
	public ParameterizedTest(double expected, double valueOne, double valueTwo) {
		this.expected = expected;
		this.valueOne = valueOne;
		this.valueTwo = valueTwo;
	}
	
	@Test
	public void sum() {
		Calculator calc = new Calculator();
		assertEquals(expected, calc.add(valueOne, valueTwo), 0);
	}
}
