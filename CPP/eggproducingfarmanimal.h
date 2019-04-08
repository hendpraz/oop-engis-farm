#ifndef eggproducingfarmanimal_
#define eggproducingfarmanimal_

#include "farmanimal.h"

class EggProducingFarmAnimal : virtual public FarmAnimal  {
	
	public :
		void render() ;		
		bool IsEggProducing() ;
};

#endif
