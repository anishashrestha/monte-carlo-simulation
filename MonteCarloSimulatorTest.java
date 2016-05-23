import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class MonteCarloSimulatorTest {

	@Test
	public void getPercentile() {
		double[] test1 = new double[] { 0, 1, 2, 3, 4 };
		double[] test2 = new double[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		double[] test3 = new double[] { 4 };
		double[] test4 = new double[] { -4, 4 };

		assertEquals("Test for median of array with odd length", 2,
				MonteCarloSimulator.getPercentileInSortedArray(test1, 50), 0);
		assertEquals("Test for median of array with odd length", 2,
				MonteCarloSimulator.getPercentileInSortedArray(test1, 50), 0);
		assertEquals("Test for 90th percentile of array with odd length", 4,
				MonteCarloSimulator.getPercentileInSortedArray(test1, 90), 0);
		assertEquals("Test for 100th percentile of array with odd length", 4,
				MonteCarloSimulator.getPercentileInSortedArray(test1, 100), 0);

		assertEquals("Test for median of array with even length", 4.5,
				MonteCarloSimulator.getPercentileInSortedArray(test2, 50), 0);
		assertEquals("Test for 90th percentile of array with even length", 8.5,
				MonteCarloSimulator.getPercentileInSortedArray(test2, 90), 0);

		assertEquals("Test for median of array with one element", 4,
				MonteCarloSimulator.getPercentileInSortedArray(test3, 50), 0);
		assertEquals("Test for 90th percentile of array with one element", 4,
				MonteCarloSimulator.getPercentileInSortedArray(test3, 90), 0);

		assertEquals("Test for median of array with a negative number", 0,
				MonteCarloSimulator.getPercentileInSortedArray(test4, 50), 0);
		assertEquals(
				"Test for 90th percentile of array with a negative number", 4,
				MonteCarloSimulator.getPercentileInSortedArray(test4, 90), 0);

	}

	@Test
	public void testExceptionMessage() {
		try {
			double[] test5 = new double[] {};
			double ans = MonteCarloSimulator.getPercentileInSortedArray(test5, 90);
			fail("Expected an IndexOutOfBoundsException to be thrown");
		} catch (IndexOutOfBoundsException anIndexOutOfBoundsException) {
			assertEquals(anIndexOutOfBoundsException.getMessage(), "-1");
		}
	}

}
