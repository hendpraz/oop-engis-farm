#ifndef barn_
#define barn_

#include "land.h"


class Barn : public Land  {

	public :
		Barn() ;
		Barn(bool) ;
		void render() ;
		int getIdentity() ;
		
};

#endif
