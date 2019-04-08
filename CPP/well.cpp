#include <iostream>
using namespace std ;

#include "well.h"

void Well::render() {
	cout << "W" ;
}

int Well::getIdentity() {
	return 3 ;
}

void Well::Interact(int) {
	cout << "Air telah diisi penuh" << endl;
}
