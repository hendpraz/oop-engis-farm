#ifndef product_
#define product_

class Product  {
	private :
		int productID;
		int harga;
	public :
		Product(int ID, int _harga);
		int getProductID();
		int getHarga();
};

#endif
