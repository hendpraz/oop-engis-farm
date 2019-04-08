#include <iostream>
using namespace std ;

#include "cell.h"

void Cell::render() {
	if (!this->getCreation() ){
		cout << "n" ;
	}
	else
	{
		this->getCreation()->render() ;	
	}
}

void Cell::Interact(int i) {
	//Nothing
}

void Cell::setCreation(Creation* _c){
	creation = _c ;
}

Creation* Cell::getCreation(){
	return creation ;
}

int Cell::getIdentity() {
	return -1 ; //Cell Murni
}

bool Cell::GetAtribute(int i) {
	return false ;
}

void Cell::Update() {
	if (!this->getCreation() ){
		//Nothing
	}
	else
	{
		this->getCreation()->Action(1) ; // Update	
	}
}

bool Cell::IsPossibleToInteract(int i) {
	return false ;	
}

		
