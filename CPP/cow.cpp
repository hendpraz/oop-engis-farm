#include <iostream>
using namespace std ;

#include "cow.h"
#include "cowmilk.h"
#include "cowmeat.h"

void Cow::render() {
	if (this->getHungry() ){
		cout << "s" ;
	}else{
		cout << "S" ;
	}
}

void Cow::ToSound() {
	cout << "Suara Cow" << endl ;
}

int Cow::getDurationForHungryTime() {
	return 25 ; 
}

FarmProduct* Cow::createProduct() {
	FarmProduct* p = new CowMilk() ;
	return p ;
}

FarmProduct* Cow::getMeatProduct() {
	FarmProduct* p = new CowMeat() ;
	return p ;
}
