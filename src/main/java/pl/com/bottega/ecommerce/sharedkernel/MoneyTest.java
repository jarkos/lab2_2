package pl.com.bottega.ecommerce.sharedkernel;

import static org.junit.Assert.assertThat;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class MoneyTest {

	@Test
	public void testAdd10PLNand20PLN_sholudEquals30PLN_resultTrue() {
		Money money1 = new Money(10, "PLN");
		Money money2 = new Money(20, "PLN");
		Money result = new Money(30, "PLN");
		assertThat(money1.add(money2),is(equalTo(result)));
	}
	
	@Test (expected = IllegalArgumentException.class)
		public void testAdd10PLNand20GBP_shouldIllegalArgumentExceptionResult() {
			Money money1 = new Money(10, "PLN");
			Money money2 = new Money(20, "GBP");
			money1.add(money2);		
		}
	
	@Test
	public void testSubstract30PLNand10PLN_sholudEquals20PLN_resultTrue() {
		Money money1 = new Money(30, "PLN");
		Money money2 = new Money(10, "PLN");
		Money result = new Money(20, "PLN");
		assertThat(money1.subtract(money2),is(equalTo(result)));
	}
	
	@Test (expected = IllegalArgumentException.class)
		public void testSubstract20PLNand10GBP_shouldThrowIllegalArgumentException() {
			Money money1 = new Money(20, "PLN");
			Money money2 = new Money(10, "GBP");
			money1.subtract(money2);		
		}
	
	@Test
		public void test10PLNmultiplyBy10_sholudReturn100PLN_resultTrue() {
			Money money1 = new Money(10, "PLN");
			Money result = new Money(100, "PLN");
			assertThat(money1.multiplyBy(10), is(equalTo(result)));
		}
	
	@Test (expected = java.lang.AssertionError.class)
	public void test10PLNmultiplyBy10_sholudReturn100EUR_shouldThrowAssertionError() {
		Money money1 = new Money(10, "PLN");
		Money expected = new Money(100, "EUR");
		assertThat(money1.multiplyBy(10), is(equalTo(expected)));
	}
	
	@Test
		public void test10PLNlessThan100PLN_shouldResultTrue() {
			Money money1 = new Money(10.00, "PLN");
			Money money2 = new Money(100.00, "PLN");
			assertThat(money1.lessThan(money2), is(true));
		}
	
	@Test
	public void test99PLNgreaterThan100PLN_shouldResultFalse() {
		Money money1 = new Money(99, "PLN");
		Money money2 = new Money(100, "PLN");
		assertThat(money1.greaterThan(money2), is(false));
	}
	
	@Test
	public void test100PLNequals100PLN_shouldResultTrue() {
		Money money1 = new Money(100, "PLN");
		Money money2 = new Money(100, "PLN");
		assertThat(money1.equals(money2), is(true));
	}
	
	@Test
	public void test100PLNlessOrEquals100PLN_shouldResultTrue() {
		Money money1 = new Money(99, "PLN");
		Money money2 = new Money(100, "PLN");
		assertThat(money1.lessOrEquals(money2), is(true));
	}
}
