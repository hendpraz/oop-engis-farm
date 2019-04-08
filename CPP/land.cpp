#include <iostream>
using namespace std ;

#include "land.h"

void Land::render() {

}

void Land::Interact(int i) {
	if (i == 0){
		//Grow
		this->setGrass(true) ;
	}else if (i == 1) {
		//Be Eaten
		this->setGrass(false) ;
	}
}

bool Land::getGrass() {
	return grass ;
}

void Land::setGrass(bool _grass) {
	grass = _grass ;
}

bool Land::GetAtribute(int i) {
	if (i == 0){
		return grass ;
	}
	return false ;
}


