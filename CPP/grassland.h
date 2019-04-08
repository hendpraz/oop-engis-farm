#ifndef grassland_
#define grassland_

#include "land.h"


class Grassland : public Land  {
	private :

	public :
		Grassland() ;
		Grassland(bool) ;
		void render() ;
		int getIdentity() ;
		

};

#endif
