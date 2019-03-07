package model;

public class Item {
	private int id;
	private int categoryId;
	private String name;
	private int price;
	private String imageUrl;
	public Item(int id, int categoryId, String name, int price, String imageUrl) {
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.price = price;
		this.imageUrl = imageUrl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
}
