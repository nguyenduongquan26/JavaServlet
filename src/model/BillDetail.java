package model;

public class BillDetail {
	private long billId;
	private int itemId;
	private int price;
	private short quantity;
	private String itemName;
	private String imageUrl;
	
	public BillDetail(long billId, int itemId, int price, short quantity) {
		this(billId, itemId, price, quantity, null, null);
	}
	
	

	public BillDetail(long billId, int itemId, int price, short quantity, String itemName, String imageUrl) {
		super();
		this.billId = billId;
		this.itemId = itemId;
		this.price = price;
		this.quantity = quantity;
		this.itemName = itemName;
		this.imageUrl = imageUrl;
	}



	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public long getBillId() {
		return billId;
	}
	public void setBillId(long billId) {
		this.billId = billId;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public short getQuantity() {
		return quantity;
	}
	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}



	public String getImageUrl() {
		return imageUrl;
	}



	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
}
