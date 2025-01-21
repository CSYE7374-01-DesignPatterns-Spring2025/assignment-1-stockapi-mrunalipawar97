package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {

	 /* List of all stocks in the market*/
	private List<StockAPI> stocks; 

	private static StockMarket instance;

	/* Private Constructor to prevent instantiation */
	private StockMarket() {
		this.stocks = new ArrayList<>();
	}

	/**
     * Get the single instance of StockMarket (Singleton).
     * Synchronized for thread safety.
     * 
     * @return the singleton instance of StockMarket
     */
	public static synchronized StockMarket getInstance() {
		if (instance == null) {
			instance = new StockMarket();
		}
		return instance;
	}

	/*  Add a stock to the stock market */
	public void addStock(StockAPI stock) {
		if (!stocks.contains(stock)) {
			stocks.add(stock);
			System.out.println("Stock " + stock.id + " has been added to the stock market.");
		} else {
			System.out.println("Stock " + stock.id + " already exists in the stock market.");
		}
	}

	/* Remove a stock from the stock market by ID */
	public void removeStock(String stockId) {
		StockAPI stockToRemove = null;
		for (StockAPI stock : stocks) {
			if (stock.id.equalsIgnoreCase(stockId)) {
				stockToRemove = stock;
				break;
			}
		}

		if (stockToRemove != null) {
			stocks.remove(stockToRemove);
			System.out.println("Stock " + stockId + " has been removed from the stock market.");
		} else {
			System.out.println("Stock " + stockId + " not found in the stock market.");
		}
	}

	/* Trade a stock by placing a bid on a specific stock by its ID */
	public void tradeStock(String stockId, String bid) {
		for (StockAPI stock : stocks) {
			if (stock.id.equalsIgnoreCase(stockId)) {
				stock.setBid(bid);
				System.out.println("Placed bid $" + bid + " on stock " + stock.id + ".");
				return;
			}
		}
		System.out.println("Stock " + stockId + " not found in the stock market.");
	}

	/* Display details of a specific stock */
	public void showStock(String stockId) {
		for (StockAPI stock : stocks) {
			if (stock.id.equalsIgnoreCase(stockId)) {
				System.out.println(stock + " | Metric: " + stock.getMetric());
				return;
			}
		}
		System.out.println("Stock " + stockId + " not found in the stock market.");
	}

	/* Display details of all stocks in the stock market */
	public void showAllStocks() {
		if (stocks.isEmpty()) {
			System.out.println("No stocks are currently available in the stock market.");
		} else {
			System.out.println("Stocks in the stock market:");
			for (StockAPI stock : stocks) {
				System.out.println(stock + " | Metric: " + stock.getMetric());
			}
		}
	}
	
	
	/* Demo method to simulate stock market operations */
	public static void demo() {

		System.out.println("\n=== StockMarket Demo ===");

		StockMarket stockMarket = StockMarket.getInstance();
		

		/* Create Mastercard and Visa stocks */
        StockAPI mastercard = new MastercardStock("MasterCard", 380.0, "Mastercard Inc.", "Finance");
        StockAPI visa = new VisaStock("Visa", 220.0, "Visa Inc.", "Finance");

        stockMarket.addStock(mastercard);
        stockMarket.addStock(visa);

        // Simulate 6 bids
        String[] bids = {"400", "410", "390", "420", "430", "440"};

        System.out.println("\n=== Bid Placement ===");
        for (String bid : bids) {
        	stockMarket.tradeStock("MasterCard", bid); // Place bids for Mastercard
        	stockMarket.tradeStock("Visa", bid); // Place bids for Visa
        }

        stockMarket.showAllStocks();

        stockMarket.removeStock("MasterCard");
        stockMarket.showAllStocks();

	}
}
