package frank.interview.number.question.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import frank.interview.number.questions.McNuggets;

public class McNuggetsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBuyable() {
		assertEquals(false, McNuggets.buyable(1));
		assertEquals(false, McNuggets.buyable(2));
		assertEquals(false, McNuggets.buyable(3));
		assertEquals(false, McNuggets.buyable(4));
		assertEquals(false, McNuggets.buyable(5));
		assertEquals(true,  McNuggets.buyable(6));
		assertEquals(false, McNuggets.buyable(7));
	}
	
	@Test
	public void testBuyableAutomatic() {
		int num = 500;
		boolean [] result = bruteForceResults(num);
		for (int i = 0; i <= num; i++) {
			System.out.println(i+": \t"+result[i]);
			assertEquals(result[i], McNuggets.buyable(i));
		}
	}
	
	private boolean[] bruteForceResults(int n) {
		boolean [] result = new boolean [n+1];
		for (int i = 0; i <= n; i++) {
			result[i] = false;
		}
		result[0] = true;
		for (int k = 0; k <= n; k++) {
			if (result[k] == true) {
				int i = k;
				while (i <= n) {
					result[i] = true;
					i += 6;
				}
				i = k;
				while (i <= n) {
					result[i] = true;
					i += 9;
				}
				i = k;
				while (i <= n) {
					result[i] = true;
					i += 20;
				}
			}
		}
		return result;
	}

}
