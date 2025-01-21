package edu.neu.csye7374;

/**
 * @author mrunalipawar
 *
 */
public class VisaStock extends StockAPI {

	/**
	 * Visa is also stable but emphasizes transaction volume. Its metric increases
	 * with the number of bids (volume)
	 */
	public VisaStock(String id, double price, String description, String sector) {
		super(id, price, description, sector);
	}

	/* Update price based on the latest bid */
	@Override
	protected void updatePrice() {
		if (!bids.isEmpty()) {
			double latestBid = Double.parseDouble(bids.get(bids.size() - 1));
			price = latestBid; // Update price directly based on the latest bid
		}
	}

	/* Metric reflects the number of bids (transaction volume)*/
	@Override
	public int getMetric() {
		return bids.size(); // Metric reflects transaction volume
	}

	/* String representation includes transaction volume */
	@Override
	public String toString() {
		return "VisaStock [ID=" + id + ", Price=" + price + ", Sector=" + sector + ", Volume=" + volume 
		           + ", Description=" + description + ", TransactionVolume=" + bids.size() + "]" 
		           ;
	}

}
