package edu.neu.csye7374;

/**
 * @author mrunalipawar
 */
public class MastercardStock extends StockAPI {

	/**
	 * Mastercard is known for consistent growth in digital payments. Reflects
	 * growth via revenue-based metrics
	 */

	/* Simulates Mastercard's revenue growth rate */
	private double revenueGrowthRate; // based on bids

	public MastercardStock(String id, double price, String description, String sector) {
		super(id, price, description, sector);
		this.revenueGrowthRate = 0.05; // Assume 5% revenue growth rate
	}

	/* Update price based on the latest bid and growth rate */
	@Override
	protected void updatePrice() {
		if (!bids.isEmpty()) {
			double latestBid = Double.parseDouble(bids.get(bids.size() - 1));
			price = latestBid * (1 + revenueGrowthRate); // Update price based on growth
		}
	}

	/* Metric reflects revenue growth percentage */
	@Override
	public int getMetric() {
		return (int) (revenueGrowthRate * 100); // Metric as growth percentage
	}

	/* String representation includes revenue growth rate */
	@Override
	public String toString() {
		return "MastercardStock [ID=" + id + ", " + "Price=" + price + ", " + "Sector=" + sector + ", " + "Volume="
				+ volume + ", Description=" + description + ", RevenueGrowthRate=" + (revenueGrowthRate * 100) + "%]"
				;
	}

}
