#include <iostream>
using namespace std ;

#include "product.h"

Product::Product (int ID, int _harga) {
	productID = ID;
	harga = _harga;
}

int Product::getProductID(){
	return productID;
}

int Product::getHarga(){
	return harga;
}
