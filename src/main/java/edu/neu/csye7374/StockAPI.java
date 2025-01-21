package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mrunalipawar
 * 
 * StockAPI serves as a base class for all stock types.
 * It provides common attributes like ID, price, and description.
 */
abstract class StockAPI implements Tradable {

	protected String id;
	protected double price;
	protected String description;
	protected List<String> bids;
	protected int volume;   // Total volume of shares traded
    protected String sector;  


	/**
     * Constructor to initialize a StockAPI instance.
     * 
     * @param id          Unique identifier for the stock
     * @param price       Initial price of the stock
     * @param description Description of the stock
     * @param sector      Sector the stock belongs to
     */
	public StockAPI(String id, double price, String description, String sector) {
		this.id = id;
		this.price = price;
		this.description = description;
		this.sector = sector;
        this.bids = new ArrayList<>(); // Initialize the list of bids
        this.volume = 0;               // Initialize volume to 0
	}

	/* Add a bid to the stock and update its price*/
	@Override
	public void setBid(String bid) {
		bids.add(bid);// Add the bid to the list of bids
		volume++;         // Increment the trade volume
		updatePrice(); // Trigger price update in the subclass
	}

	/* To calculate the stock's performance metric */
	@Override
	public int getMetric() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getMetric'");
	}

	/* To update price, implemented by subclasses */
	protected abstract void updatePrice();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	/* String representation of the stock */
	@Override
	public String toString() {
		return "Stock [ID =" + id + ", Price =" + price + ", Sector =" + sector +
	               ", Volume =" + volume + ", Description =" + description + "]";
	}
}
