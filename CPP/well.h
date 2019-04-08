#ifndef well_
#define well_

#include "facility.h"

class Well : public Facility  {
	private :

	public :
		void render() ;
		int getIdentity() ;
		void Interact(int) ;
};

#endif
