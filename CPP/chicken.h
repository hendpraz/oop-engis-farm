#ifndef chicken_
#define chicken_

#include "meatproducingfarmanimal.h"
#include "eggproducingfarmanimal.h"
#include "farmproduct.h"

class Chicken : public MeatProducingFarmAnimal , public EggProducingFarmAnimal {
	
	public :
		void render() ;
		void ToSound() ;
		int getDurationForHungryTime() ; ///Mengembalikan waktu lapar tertentu tergantung jenis	hewannya 
		FarmProduct* createProduct() ; 
		FarmProduct* getMeatProduct() ;
};

#endif
