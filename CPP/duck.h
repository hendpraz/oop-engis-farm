#ifndef duck_
#define duck_

#include "meatproducingfarmanimal.h"
#include "eggproducingfarmanimal.h"
#include "farmproduct.h"

class Duck : public MeatProducingFarmAnimal , public EggProducingFarmAnimal {
	
	public :
		void render() ;
		void ToSound() ;
		int getDurationForHungryTime() ; ///Mengembalikan waktu lapar tertentu tergantung jenis	hewannya 
		FarmProduct* createProduct() ; 
		FarmProduct* getMeatProduct() ;
};

#endif
