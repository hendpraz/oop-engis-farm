#include <iostream>
using namespace std ;

#include "creation.h"

int Creation::getPosBaris() {
	return posBaris ;
}

int Creation::getPosKolom() {
	return posKolom ;
}

void Creation::setPosisi(int _brs,int _kol) {
	posBaris = _brs ;
	posKolom = _kol ;
}

void Creation::render() {

}

void Creation::GotKilled() {
	//delete this ;
}

void Creation::Action(int i) {
	
}

bool Creation::GetAtribute(int i) {
	return false ;
}

FarmProduct* Creation::GetFarmProduct(int i) {
	return NULL ;
}



