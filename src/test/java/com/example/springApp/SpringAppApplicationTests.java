package com.example.springApp;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class SpringAppApplicationTests {

	@Mock
	private INumbersProvider mockNumbersProvider;
	@InjectMocks
	private ClassWithMock classWithMock;

	@Test
	void contextLoads() {

	}

	@Test
	void testSum() {
		var result = TestMethods.calculateSum(1, 2, 3);
		var expectedResult = 6;
		assertEquals(expectedResult, result);
	}

	@Test
	void testSmallestNumberWithStub() {
		var stub = new NumbersProviderStub(new int[] { 100, 20, 11 });
		var toMock = new ClassWithMock(stub);
		assertEquals(11, toMock.getSmallestNumber());
	}

	@Test
	void testSmallestNumberWithMockito() {
		when(mockNumbersProvider.numbers()).thenReturn(new int[] { 100, 20, 11});
		assertEquals(11, classWithMock.getSmallestNumber());
	}

	@Test
	void testSmallestNumberWithMockitoNoNumbers() {
		when(mockNumbersProvider.numbers()).thenReturn(new int[0]);
		assertEquals(-1, classWithMock.getSmallestNumber());
	}

}

record NumbersProviderStub(int[] numbers) implements INumbersProvider {


}
