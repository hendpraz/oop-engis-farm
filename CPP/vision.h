#ifndef vision_
#define vision_

#include "map.h"

class Vision {
	private :
		Map* vmap ;
		
	public :
		void setMap(Map*) ;
		Map* getMap() ;
		
};

#endif
