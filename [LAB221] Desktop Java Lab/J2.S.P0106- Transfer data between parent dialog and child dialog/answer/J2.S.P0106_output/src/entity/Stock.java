package entity;

public class Stock {
	int stockId;
	String stockName;
	String address;
	String dateAvailable;
	String note;
	
	public Stock () {
		
	}
	
	public Stock (int id, String stockName, String address, String dateAvailable, String note) {
		this.stockId = id;
		this.stockName = stockName;
		this.address = address;
		this.dateAvailable = dateAvailable;
		this.note = note;
	}
	
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDateAvailable() {
		return dateAvailable;
	}
	public void setDateAvailable(String dateAvailable) {
		this.dateAvailable = dateAvailable;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
