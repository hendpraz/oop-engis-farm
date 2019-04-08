#include <iostream>
using namespace std ;

#include "chicken.h"
#include "chickenegg.h"
#include "chickenmeat.h"

void Chicken::render() {
	if (this->getHungry() ){
		cout << "c" ;
	}else{
		cout << "C" ;
	}
}

void Chicken::ToSound() {
	cout << "Suara Chicken" << endl ;
}

int Chicken::getDurationForHungryTime() {
	return 15 ; 
}

FarmProduct* Chicken::createProduct() {
	FarmProduct* p = new ChickenEgg() ;
	return p ;
}

FarmProduct* Chicken::getMeatProduct() {
	FarmProduct* p = new ChickenMeat() ;
	return p ;
}
