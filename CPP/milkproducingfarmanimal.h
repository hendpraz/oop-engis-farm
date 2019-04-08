#ifndef milkproducingfarmanimal_
#define milkproducingfarmanimal_

#include "farmanimal.h"

class MilkProducingFarmAnimal : virtual public  FarmAnimal  {
	
	public :
		void render() ;
		bool IsMilkProducing() ;
};

#endif
