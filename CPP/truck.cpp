#include <iostream>
using namespace std ;

#include "truck.h"

void Truck::render() {
	cout << "T" ;
}

int Truck::getIdentity() {
	return 5 ;
}

Truck::Truck() {
	time_truck = 0 ;
	truck_duration = 12 ;	
}

void Truck::Update() {
	if (time_truck > 0 ){
		time_truck -= 1 ;
	}else {
		//cout << "Truck Ada" << endl << endl ;
	}
}

void Truck::Interact(int i) {
	showListOfProduct();
	
	//Transaksi dilakukan oleh player
}

bool Truck::IsPossibleToInteract(int i) {
	return (time_truck == 0) ;	
}

void Truck::showListOfProduct(){
	cout << "1. ChickenEgg, harga 1500" <<endl;
	cout << "2. ChickenMeat, harga 5000" <<endl;
	cout << "3. CowMeat, harga 10000" <<endl;
	cout << "4. CowMilk, harga 2500" <<endl;
	cout << "5. DuckEgg, harga 2000" <<endl;
	cout << "6. DuckMeat, harga 7000" <<endl;
	
	cout << "11. Beef Rolade, harga 15000" <<endl; //CowMeat + ChickenEgg
	cout << "12. Butter, harga 6000" << endl; // 2 Milk
	cout << "13. Omelet, harga 5000" << endl; // ChickenEgg + Milk
	
}

void Truck::trukPergi(){
	time_truck = truck_duration ;
}
