#include <iostream>
using namespace std ;

#include "duck.h"
#include "duckegg.h"
#include "duckmeat.h"

void Duck::render() {
	if (this->getHungry() ){
		cout << "d" ;
	}else{
		cout << "D" ;
	}
}

void Duck::ToSound() {
	cout << "Suara Duck" << endl ;
}

int Duck::getDurationForHungryTime() {
	return 20 ; 
}

FarmProduct* Duck::createProduct() {
	FarmProduct* p = new DuckEgg() ;
	return p ;
}

FarmProduct* Duck::getMeatProduct() {
	FarmProduct* p = new DuckMeat() ;
	return p ;
}
