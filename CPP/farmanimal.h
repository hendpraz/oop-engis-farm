#ifndef farmanimal_
#define farmanimal_

#include "creation.h"
#include "vision.h"

#include "farmproduct.h"

class FarmAnimal : public Creation ,public Vision   {
	private :
		bool hungry ; //Jika True Maka Hewan Tersebut Lapar 
		int hungryTime ; //Akan berkurang seiring waktu , jika hungryTime = 0 maka hewan lapar
		
		static int CountFarmAnimal ;
		bool hasUpdated ; //True Jika Hewan telah melakukan update
		
		FarmProduct* selfproduct ; //Product yang hewan miliki selain meat
		
		
	public :
		///
		FarmAnimal() ;
		void render() ;
		void GotKilled() ;
		~FarmAnimal() ;		
		bool getHungry() ;
		void setHungry(bool) ;
		
		bool getHasUpdated() ;
		void setHasUpdated(bool) ;
		
		void setHungryTime(int) ;
		
		void Action(int) ;
		void Update() ;
		void Bergerak() ;
		void ProsesPencernaan() ;
		bool GetAtribute(int) ;
		void emptySelfProduct() ;

		///
		virtual int getIdentity() ;		
		virtual void ToSound() ;	
		virtual int getDurationForHungryTime() ; ///Mengembalikan waktu lapar tertentu tergantung jenis	hewannya 
		//Identity
		virtual bool IsMeatProducing() ;
		virtual bool IsEggProducing() ;
		virtual bool IsMilkProducing() ;
		
		virtual FarmProduct* GetFarmProduct(int) ;
		virtual FarmProduct* createProduct() ; //Hasil Produk Hewannya
		
		virtual FarmProduct* getMeatProduct() ; //Jika dia MeatProducingAnimal maka dia punya Meat
		
		static int getCountAnimal () ;
		
		
		 
};

#endif
