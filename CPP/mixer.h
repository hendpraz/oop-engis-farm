#ifndef mixer_
#define mixer_

#include "facility.h"

class Mixer : public Facility  {
	private :

	public :
		void render() ;
		int getIdentity() ;
		void Interact(int i);
		void Mix();
		void showListOfSideProduct();

		
};

#endif
