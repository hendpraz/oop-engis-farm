#ifndef coop_
#define coop_

#include "land.h"


class Coop : public Land  {

	public :
		Coop() ;
		Coop(bool) ;
		void render() ;
		int getIdentity() ;
		
};

#endif
