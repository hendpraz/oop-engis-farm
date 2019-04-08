#include <iostream>
#include <cstdlib>
using namespace std ;

#include "farmanimal.h"

int FarmAnimal::CountFarmAnimal = 0 ;

int FarmAnimal::getDurationForHungryTime() {
	return 10 ; //default
}

int FarmAnimal::getCountAnimal() {
	return CountFarmAnimal ;
}

void FarmAnimal::render() {
	cout << 'H' ;
}

void FarmAnimal::setHungryTime(int h) {
	hungryTime = h ;
}

FarmAnimal::FarmAnimal() {
	hungry = false ;
	hasUpdated = false ;
	hungryTime = 10 ; //default
	selfproduct = NULL ; 
	CountFarmAnimal ++ ;
}

void FarmAnimal::GotKilled() {
	CountFarmAnimal -- ;
	//delete this ;
}

FarmAnimal::~FarmAnimal() {
	//cout << "Mati >_<" << endl ;
}

bool FarmAnimal::getHungry() {
	return hungry ;
}

void FarmAnimal::setHungry(bool _h) {
	hungry = _h ;
}

bool FarmAnimal::getHasUpdated() {
	return hasUpdated ;
}

void FarmAnimal::setHasUpdated(bool _b) {
	hasUpdated = _b ;
}
		
int FarmAnimal::getIdentity() {
	return -1 ; //FarmAnimal Murni
}

bool FarmAnimal::IsMeatProducing() {
	return false ;
}

bool FarmAnimal::IsEggProducing() {
	return false ;
}

bool FarmAnimal::IsMilkProducing() {
	return false ;
}

void FarmAnimal::emptySelfProduct() {
	this->selfproduct = NULL ; 
}

FarmProduct* FarmAnimal::getMeatProduct(){
	return NULL ;
}

void FarmAnimal::Action(int i) {
	if (i == 0){
		this->ToSound() ;
	}else if (i == 1){
		this->Update() ;
	}else if (i == 2){
		this->emptySelfProduct() ;
	}
	else if (i == 99){
		this->setHasUpdated(false) ;
	}
	
}

void FarmAnimal::Update(){
	//ConstraintOfAnimalHasUpdated
	if (!this->GetAtribute(0) ){
		this->ProsesPencernaan() ;
		this->Bergerak() ;	
		/*
		if (this->selfproduct == NULL){
			cout << "NULL" << endl ;
		}else{
			cout << this->selfproduct->getProductID() << endl ;
		}*/
		this->setHasUpdated(true) ;
	}
}	

FarmProduct* FarmAnimal::GetFarmProduct(int i){
	if (i == 0){
		return selfproduct ;
	}else if (i == 1){
		return this->getMeatProduct() ;
	}
	
	return NULL ;
}

FarmProduct* FarmAnimal::createProduct() {
	return NULL ;
}

void FarmAnimal::ProsesPencernaan(){
	if (!this->GetAtribute(0) ){
		
		
		if (hungry){
			//Cek Cell tempat sendiri
			int Brs_ , Kol_ ;
			Brs_ = this->getPosBaris() ;
			Kol_ = this->getPosKolom() ;		
			if (this->getMap()->IsReachable(Brs_,Kol_) ){
				if (this->getMap()->getCell( Brs_,Kol_)->GetAtribute(0) ){
					hungry = false ;
					hungryTime = this->getDurationForHungryTime() ;
					selfproduct = this->createProduct() ;
					this->getMap()->getCell( Brs_,Kol_)->Interact(1) ; //Rumput Dimakan
				}
			}

		}
			
		if (hungryTime > 0 ){
			hungryTime -- ;
			//cout << hungryTime << endl ;
			if (hungryTime == 0){
				hungry = true ;
			}
		}else {
			hungryTime -- ;
			//cout << hungryTime << endl ;
			if (hungryTime == -5){
				this->getMap()->getCell(this->getPosBaris(),this->getPosKolom())->setCreation(NULL) ;	
				this->GotKilled() ;
			}
		}		
				
  	}
}

void FarmAnimal::Bergerak(){	
	int Brs_ , Kol_ ;
	bool done = false ;	
	int rnd_number = rand() % 4 ;
	
	int i = 0 ;
	
	while (i < 4 && !done) {
		rnd_number = rnd_number % 4 ;
		
		///Kiri
		if (!done && rnd_number == 0){
			Brs_ = this->getPosBaris() ;
			Kol_ = this->getPosKolom() - 1 ;		
			if (this->getMap()->IsReachable(Brs_,Kol_) ){
				Cell *current_cell = this->getMap()->getCell( this->getPosBaris(), this->getPosKolom()  ) ;	
				Cell *current_cell_tujuan = this->getMap()->getCell( Brs_  , Kol_ ) ;	
				///ConstraintOfFacility
				if (current_cell_tujuan->getIdentity() != 3 && current_cell_tujuan->getIdentity() != 4 && current_cell_tujuan->getIdentity() != 5){				
					///ConstraintOfCreation
					if (!current_cell_tujuan->getCreation() ){
						///ConstraintOfLand 	
						if ( (this->IsMeatProducing() && current_cell_tujuan->getIdentity() == 0)  
							|| (this->IsEggProducing() && current_cell_tujuan->getIdentity() == 1) 
							|| (this->IsMilkProducing() && current_cell_tujuan->getIdentity() == 2) 
						  )		
						  {	  	
						  	Creation* this_ = current_cell->getCreation();	

						  		current_cell->setCreation(NULL) ;	
								current_cell_tujuan->setCreation(this_) ;			
								this->setPosisi(Brs_,  Kol_ ) ;
								//this->setHasUpdated(true) ;
								done = true ;
						  //	}					
						  }				
					}
				}
			}
		}
		///Atas
		if (!done && rnd_number == 1){
			Brs_ = this->getPosBaris() - 1 ;
			Kol_ = this->getPosKolom() ;	
			if (this->getMap()->IsReachable(Brs_,Kol_) ){		
				Cell *current_cell = this->getMap()->getCell( this->getPosBaris(), this->getPosKolom()  ) ;	
				Cell *current_cell_tujuan = this->getMap()->getCell( Brs_  , Kol_ ) ;	
				///ConstraintOfFacility
				if (current_cell_tujuan->getIdentity() != 3 && current_cell_tujuan->getIdentity() != 4 && current_cell_tujuan->getIdentity() != 5){				
					///ConstraintOfCreation
					if (!current_cell_tujuan->getCreation() ){
						///ConstraintOfLand 	
						if ( (this->IsMeatProducing() && current_cell_tujuan->getIdentity() == 0)  
							|| (this->IsEggProducing() && current_cell_tujuan->getIdentity() == 1) 
							|| (this->IsMilkProducing() && current_cell_tujuan->getIdentity() == 2) 
						  )		
						  {	  	
						  	Creation* this_ = current_cell->getCreation();	
						  	//ConstraintOfAnimalHasUpdated
						  	//if (!this->GetAtribute(0) ){
						  		current_cell->setCreation(NULL) ;	
								current_cell_tujuan->setCreation(this_) ;			
								this->setPosisi(Brs_,  Kol_ ) ;
								//this->setHasUpdated(true) ;
								done = true ;
						  	//}					
						  }				
					}
				}
			}
		}
		///Kanan
		if (!done && rnd_number == 2){
			Brs_ = this->getPosBaris() ;
			Kol_ = this->getPosKolom() + 1 ;	
			if (this->getMap()->IsReachable(Brs_,Kol_) ){		
				Cell *current_cell = this->getMap()->getCell( this->getPosBaris(), this->getPosKolom()  ) ;	
				Cell *current_cell_tujuan = this->getMap()->getCell( Brs_  , Kol_ ) ;	
				///ConstraintOfFacility
				if (current_cell_tujuan->getIdentity() != 3 && current_cell_tujuan->getIdentity() != 4 && current_cell_tujuan->getIdentity() != 5){				
					///ConstraintOfCreation
					if (!current_cell_tujuan->getCreation() ){
						///ConstraintOfLand 	
						if ( (this->IsMeatProducing() && current_cell_tujuan->getIdentity() == 0)  
							|| (this->IsEggProducing() && current_cell_tujuan->getIdentity() == 1) 
							|| (this->IsMilkProducing() && current_cell_tujuan->getIdentity() == 2) 
						  )		
						  {	  	
						  	Creation* this_ = current_cell->getCreation();	
						  	//ConstraintOfAnimalHasUpdated
						  	//if (!this->GetAtribute(0) ){
						  		current_cell->setCreation(NULL) ;	
								current_cell_tujuan->setCreation(this_) ;			
								this->setPosisi(Brs_,  Kol_ ) ;
								//this->setHasUpdated(true) ;
								done = true ;
						  	//}					
						  }				
					}
				}
			}
		}
		///Bawah
		if (!done && rnd_number == 3){
			Brs_ = this->getPosBaris() + 1 ;
			Kol_ = this->getPosKolom() ;	
			if (this->getMap()->IsReachable(Brs_,Kol_) ){		
				Cell *current_cell = this->getMap()->getCell( this->getPosBaris(), this->getPosKolom()  ) ;	
				Cell *current_cell_tujuan = this->getMap()->getCell( Brs_  , Kol_ ) ;	
				///ConstraintOfFacility
				if (current_cell_tujuan->getIdentity() != 3 && current_cell_tujuan->getIdentity() != 4 && current_cell_tujuan->getIdentity() != 5){				
					///ConstraintOfCreation
					if (!current_cell_tujuan->getCreation() ){
						///ConstraintOfLand 	
						if ( (this->IsMeatProducing() && current_cell_tujuan->getIdentity() == 0)  
							|| (this->IsEggProducing() && current_cell_tujuan->getIdentity() == 1) 
							|| (this->IsMilkProducing() && current_cell_tujuan->getIdentity() == 2) 
						  )		
						  {	  	
						  	Creation* this_ = current_cell->getCreation();	
						  	//ConstraintOfAnimalHasUpdated
						  	//if (!this->GetAtribute(0) ){
						  		current_cell->setCreation(NULL) ;	
								current_cell_tujuan->setCreation(this_) ;			
								this->setPosisi(Brs_,  Kol_ ) ;
								//this->setHasUpdated(true) ;
								done = true ;
						  	//}					
						  }				
					}
				}
			}
		}
		
		rnd_number ++ ;
		i ++ ;
	}
	
			

}

void FarmAnimal::ToSound(){
	
}

bool FarmAnimal::GetAtribute(int i) {
	if (i == 0){
		return hasUpdated ;
	}else if (i == 1){
		return this->IsMeatProducing() ;
	}
	
	return false ;
}


