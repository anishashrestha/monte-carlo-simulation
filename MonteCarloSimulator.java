
import java.text.NumberFormat;
import java.util.Arrays;


public class MonteCarloSimulator {

	final static double CONSERVATIVE_MEAN_RETURN = 6.189;
	final static double AGGRESSIVE_MEAN_RETURN = 9.4324;
	final static double CONSERVATIVE_STD_DEVIATION = 6.3438;
	final static double AGGRESSIVE_STD_DEVIATION = 15.675;
	final static double INIT_PORTFOLIO_VALUE = 100000;
	
	public static double simulatePortfolio(Portfolio portfolio, int years) {

		for (int i = 0; i < years; i++) {
			portfolio.updateYearEndMarketValue();
		}

		return portfolio.getInitMarketValue();
	}
	
	

	public static void main(String[] args) {

		int numberOfSimulations = 10000;
		int numberOfSimulationYears = 20;

		double[] conservativeMarketValues = new double[numberOfSimulations];
		double[] aggressiveMarketValues = new double[numberOfSimulations];

		for (int i = 0; i < numberOfSimulations; i++) {
			Portfolio conservativePortfolio = new Portfolio(
					CONSERVATIVE_MEAN_RETURN, CONSERVATIVE_STD_DEVIATION, INIT_PORTFOLIO_VALUE);
			Portfolio aggressivePortfolio = new Portfolio(
					AGGRESSIVE_MEAN_RETURN, AGGRESSIVE_STD_DEVIATION, INIT_PORTFOLIO_VALUE);
			conservativeMarketValues[i] = simulatePortfolio(
					conservativePortfolio, numberOfSimulationYears);
			aggressiveMarketValues[i] = simulatePortfolio(
					aggressivePortfolio, numberOfSimulationYears);
		}
		
		Arrays.sort(conservativeMarketValues);
		Arrays.sort(aggressiveMarketValues);

		NumberFormat formatter = NumberFormat.getCurrencyInstance();

		System.out.println("Conservative portfolio:");
		System.out.println("Median after 20 years: "
				+ formatter.format(MathUtils.getPercentileInSortedArray(conservativeMarketValues, 50)));
		System.out
				.println("10% best case after 20 year: "
						+ formatter.format(MathUtils.getPercentileInSortedArray(conservativeMarketValues, 90)));
		System.out
				.println("10% worst case after 20 year: "
						+ formatter.format(MathUtils.getPercentileInSortedArray(conservativeMarketValues, 10)));

		System.out.println();
		System.out.println("Aggressive portfolio: ");
		System.out.println("Median after 20 years: "
				+ formatter.format(MathUtils.getPercentileInSortedArray(aggressiveMarketValues,50)));
		System.out
				.println("10% best case after 20 year: "
						+ formatter.format(MathUtils.getPercentileInSortedArray(aggressiveMarketValues, 90)));
		System.out
				.println("10% worst case after 20 year: "
						+ formatter.format(MathUtils.getPercentileInSortedArray(aggressiveMarketValues, 10)));
	}

}
