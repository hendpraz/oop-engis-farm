package products;

public class Product{
	private int productID;
	private int harga;
	
	public Product(int _productID, int _harga){
		productID = _productID;
		harga = _harga;
	}
	
	public int getProductID(){
		return productID;
	}
	
	public int getHarga(){
		return harga;
	}
}
