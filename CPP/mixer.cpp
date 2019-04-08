#include <iostream>
using namespace std ;

#include "mixer.h"

void Mixer::render() {
	cout << "M" ;
}

int Mixer::getIdentity() {
	return 4 ;
}

void Mixer::Interact(int i){
	cout << "Masukkan command 'Mix' untuk menggunakan Mixer" << endl << endl;
}

void Mixer::Mix(){
	showListOfSideProduct();
	
}

void Mixer::showListOfSideProduct(){
	cout << "11. Beef Rolade" <<endl; //CowMeat + ChickenEgg
	cout << "12. Butter" << endl; // 2 Milk
	cout << "13. Omelet" << endl; // ChickenEgg + Milk
}
