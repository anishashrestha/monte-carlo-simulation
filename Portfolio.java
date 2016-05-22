import java.util.Random;


public class Portfolio {
	double meanReturn;
	double risk;
	double marketValue;
	static final double INFLATION_RATE = 3.5;
	
	public Portfolio (double meanReturn, double risk, double marketValue){
		this.meanReturn = meanReturn;
		this.risk = risk;
		this.marketValue = marketValue;
	}
	
	public void updateYearEndMarketValue(){
		Random r = new Random();
		double actualReturn =  (r.nextGaussian() * risk) + meanReturn;
		double inflatedMarketValue = marketValue + (marketValue * INFLATION_RATE/100);
		marketValue = inflatedMarketValue + (actualReturn*inflatedMarketValue)/100;
		
	}

	public double getMeanReturn() {
		return meanReturn;
	}

	public double getRisk() {
		return risk;
	}


	public double getInitMarketValue() {
		return marketValue;
	}


	public static double getInflationRate() {
		return INFLATION_RATE;
	}
	
	
	

}
