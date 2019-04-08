#ifndef meatproducingfarmanimal_
#define meatproducingfarmanimal_

#include "farmanimal.h"

class MeatProducingFarmAnimal : virtual public FarmAnimal  {
	
	public :
		void render() ;
		bool IsMeatProducing() ;
};

#endif
