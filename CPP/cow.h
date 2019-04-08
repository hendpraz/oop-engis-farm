#ifndef cow_
#define cow_

#include "meatproducingfarmanimal.h"
#include "milkproducingfarmanimal.h"
#include "farmproduct.h"

class Cow : public MeatProducingFarmAnimal , public MilkProducingFarmAnimal {
	
	public :
		void render() ;
		void ToSound() ;
		int getDurationForHungryTime() ; ///Mengembalikan waktu lapar tertentu tergantung jenis	hewannya 
		FarmProduct* createProduct() ; 
		FarmProduct* getMeatProduct() ;
};

#endif
