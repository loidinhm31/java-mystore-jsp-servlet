package com.july.mystore.model;

public class Product {
	private long productID;
	private String productSKU;
	private String productName;
	private float productPrice;
	private int productStock;
	private String productManufacturer;
	private String productCategory;
	private int productCondition;
	private String productDescription;
	private String productSrc;

	private int inCartQuantity;
	
	public Product() {
		
	}
	

	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}
	
	public String getProductSKU() {
		return productSKU;
	}

	public void setProductSKU(String productSKU) {
		this.productSKU = productSKU;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}

	public String getProductManufacturer() {
		return productManufacturer;
	}

	public void setProductManufacturer(String productManufacturer) {
		this.productManufacturer = productManufacturer;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public int getProductCondition() {
		return productCondition;
	}

	public void setProductCondition(int productCondition) {
		this.productCondition = productCondition;
	}

	public String getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	public int getInCartQuantity() {
		return inCartQuantity;
	}


	public void setInCartQuantity(int inCartQuantity) {
		this.inCartQuantity = inCartQuantity;
	}


	public String getProductSrc() {
		return productSrc;
	}


	public void setProductSrc(String productSrc) {
		this.productSrc = productSrc;
	}


	
	
}
