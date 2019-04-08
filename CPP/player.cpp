#include <iostream>
using namespace std ;

#include "player.h"


void Player::render() {
	cout << 'P' ;
}

void Player::Bergerak(int i) {
	/*
	0 : Kiri
	1 : Atas
	2 : Kanan
	3 : Bawah
	*/
	int Brs_ , Kol_ ;
	
	switch(i){
		case 0 : 
			Brs_ = this->getPosBaris() ;
			Kol_ = this->getPosKolom() - 1 ;	
			break ;
		case 1 :
			Brs_ = this->getPosBaris() - 1;
			Kol_ = this->getPosKolom() ;
			break ;
		case 2 :
			Brs_ = this->getPosBaris() ;
			Kol_ = this->getPosKolom() + 1 ;
			break ;
		case 3 :			
			Brs_ = this->getPosBaris() + 1;
			Kol_ = this->getPosKolom() ;			
			break ;
	}
	
	if ( this->getMap()->IsReachable(Brs_,Kol_) ){
		Cell *current_cell = this->getMap()->getCell( this->getPosBaris(), this->getPosKolom()  ) ;	
		Cell *current_cell_tujuan = this->getMap()->getCell( Brs_  , Kol_ ) ;	
		///ConstraintOfFacility
		if (current_cell_tujuan->getIdentity() != 3 && current_cell_tujuan->getIdentity() != 4 && current_cell_tujuan->getIdentity() != 5){
			
			///ConstraintOfCreation
			if (!current_cell_tujuan->getCreation() ){
				Creation* this_ = current_cell->getCreation();	
				current_cell->setCreation(NULL) ;	
				current_cell_tujuan->setCreation(this_) ;			
				this->setPosisi(Brs_,  Kol_ ) ;
			}
		}			
		
	}
	
}

void Player::Kill() {
	bool done = false ;	
	int Brs_ , Kol_ ;
	
	///Kiri
	if (!done){
		Brs_ = this->getPosBaris() ;
		Kol_ = this->getPosKolom() - 1 ;		
		if (this->getMap()->IsReachable(Brs_,Kol_) ){
			Creation* p = this->getMap()->getCell(Brs_,Kol_)->getCreation() ;
			if (p && p->GetAtribute(1) ){	
				FarmProduct* p_ = p->GetFarmProduct(1) ;
				inventory.add(p_) ;
				this->getMap()->getCell(Brs_,Kol_)->setCreation(NULL) ;		
				p->GotKilled() ;
				done = true ;
			}			
		}
	}
	///Atas
	if (!done){
		Brs_ = this->getPosBaris() - 1 ;
		Kol_ = this->getPosKolom() ;	
		if (this->getMap()->IsReachable(Brs_,Kol_) ){		
			Creation* p = this->getMap()->getCell(Brs_,Kol_)->getCreation() ;
			if (p && p->GetAtribute(1)){
				FarmProduct* p_ = p->GetFarmProduct(1) ;
				inventory.add(p_) ;
				this->getMap()->getCell(Brs_,Kol_)->setCreation(NULL) ;		
				p->GotKilled() ;
				done = true ;
			}
		}
	}
	///Kanan
	if (!done){
		Brs_ = this->getPosBaris() ;
		Kol_ = this->getPosKolom() + 1 ;	
		if (this->getMap()->IsReachable(Brs_,Kol_) ){		
			Creation* p = this->getMap()->getCell(Brs_,Kol_)->getCreation() ;
			if (p && p->GetAtribute(1) ){
				FarmProduct* p_ = p->GetFarmProduct(1) ;
				inventory.add(p_) ;
				this->getMap()->getCell(Brs_,Kol_)->setCreation(NULL) ;		
				p->GotKilled() ;
				done = true ;
			}
		}
	}
	///Bawah
	if (!done){
		Brs_ = this->getPosBaris() + 1 ;
		Kol_ = this->getPosKolom() ;	
		if (this->getMap()->IsReachable(Brs_,Kol_) ){		
			Creation* p = this->getMap()->getCell(Brs_,Kol_)->getCreation() ;
			if (p && p->GetAtribute(1) ){
				FarmProduct* p_ = p->GetFarmProduct(1) ;
				inventory.add(p_) ;
				this->getMap()->getCell(Brs_,Kol_)->setCreation(NULL) ;		
				p->GotKilled() ;
				done = true ;
			}
		}
	}				
}

void Player::Mix() {
	bool done = false ;
	int Brs_ , Kol_ ;
	///Kiri
	if (!done){
		Brs_ = this->getPosBaris() ;
		Kol_ = this->getPosKolom() - 1 ;		
		if (this->getMap()->IsReachable(Brs_,Kol_) ){
			if (this->getMap()->getCell(Brs_,Kol_)->getIdentity() == 4 ){
				int kode ;
				cin >> kode ;

				if (kode == 11 ){
					int i = 0 ;
					bool bahan1 = false ; int idx_bahan1 =  0 ;
					bool bahan2 = false ; int idx_bahan2 =  0 ;
					while(i < inventory.count() ){
						if (inventory.get(i)->getProductID() == 1 ){
							bahan1 = true ; idx_bahan1 = i ; 
						}else if (inventory.get(i)->getProductID() == 3){
							bahan2 = true ; idx_bahan2 = i ; 
						}
						i ++ ;
					}
					if (bahan1 && bahan2){
						inventory.remove(inventory.get( idx_bahan1) ) ;
						inventory.remove(inventory.get( idx_bahan2-1) ) ;
						SideProduct* p = new BeefRolade() ;
						inventory.add(p) ;
					}
				}
				else if ( kode == 12){
					int i = 0 ;
					bool bahan1 = false ; int idx_bahan1 =  0 ;
					bool bahan2 = false ; int idx_bahan2 =  0 ;
					while(i < inventory.count() ){
						if (inventory.get(i)->getProductID() == 1 ){
							bahan1 = true ; idx_bahan1 = i ; 
						}else if (inventory.get(i)->getProductID() == 4){
							bahan2 = true ; idx_bahan2 = i ; 
						}
						i ++ ;
					}
					if (bahan1 && bahan2){
						inventory.remove(inventory.get( idx_bahan1) ) ;
						inventory.remove(inventory.get( idx_bahan2-1) ) ;
						SideProduct* p = new Butter() ;
						inventory.add(p) ;
					}
				}else if ( kode == 13){
					int i = 0 ;
					bool bahan1 = false ; int idx_bahan1 =  0 ;
					bool bahan2 = false ; int idx_bahan2 =  0 ;
					while(i < inventory.count() ){
						if (inventory.get(i)->getProductID() == 5 ){
							bahan1 = true ; idx_bahan1 = i ; 
						}else if (inventory.get(i)->getProductID() == 4){
							bahan2 = true ; idx_bahan2 = i ; 
						}
						i ++ ;
					}
					if (bahan1 && bahan2){
						inventory.remove(inventory.get( idx_bahan1) ) ;
						inventory.remove(inventory.get( idx_bahan2-1) ) ;
						SideProduct* p = new Omelet() ;
						inventory.add(p) ;
					}
				}
				done = true ;
			}		
		}
	}
	///Atas
	if (!done){
		Brs_ = this->getPosBaris() - 1 ;
		Kol_ = this->getPosKolom() ;	
		if (this->getMap()->IsReachable(Brs_,Kol_) ){		
			if (this->getMap()->getCell(Brs_,Kol_)->getIdentity() == 4 ){
int kode ;
				cin >> kode ;

				if (kode == 11 ){
					int i = 0 ;
					bool bahan1 = false ; int idx_bahan1 =  0 ;
					bool bahan2 = false ; int idx_bahan2 =  0 ;
					while(i < inventory.count() ){
						if (inventory.get(i)->getProductID() == 1 ){
							bahan1 = true ; idx_bahan1 = i ; 
						}else if (inventory.get(i)->getProductID() == 3){
							bahan2 = true ; idx_bahan2 = i ; 
						}
						i ++ ;
					}
					if (bahan1 && bahan2){
						inventory.remove(inventory.get( idx_bahan1) ) ;
						inventory.remove(inventory.get( idx_bahan2-1) ) ;
						SideProduct* p = new BeefRolade() ;
						inventory.add(p) ;
					}
				}
				else if ( kode == 12){
					int i = 0 ;
					bool bahan1 = false ; int idx_bahan1 =  0 ;
					bool bahan2 = false ; int idx_bahan2 =  0 ;
					while(i < inventory.count() ){
						if (inventory.get(i)->getProductID() == 1 ){
							bahan1 = true ; idx_bahan1 = i ; 
						}else if (inventory.get(i)->getProductID() == 4){
							bahan2 = true ; idx_bahan2 = i ; 
						}
						i ++ ;
					}
					if (bahan1 && bahan2){
						inventory.remove(inventory.get( idx_bahan1) ) ;
						inventory.remove(inventory.get( idx_bahan2-1) ) ;
						SideProduct* p = new Butter() ;
						inventory.add(p) ;
					}
				}else if ( kode == 13){
					int i = 0 ;
					bool bahan1 = false ; int idx_bahan1 =  0 ;
					bool bahan2 = false ; int idx_bahan2 =  0 ;
					while(i < inventory.count() ){
						if (inventory.get(i)->getProductID() == 5 ){
							bahan1 = true ; idx_bahan1 = i ; 
						}else if (inventory.get(i)->getProductID() == 4){
							bahan2 = true ; idx_bahan2 = i ; 
						}
						i ++ ;
					}
					if (bahan1 && bahan2){
						inventory.remove(inventory.get( idx_bahan1) ) ;
						inventory.remove(inventory.get( idx_bahan2-1) ) ;
						SideProduct* p = new Omelet() ;
						inventory.add(p) ;
					}
				}
				done = true ;
			}
		}
	}
	///Kanan
	if (!done){
		Brs_ = this->getPosBaris() ;
		Kol_ = this->getPosKolom() + 1 ;	
		if (this->getMap()->IsReachable(Brs_,Kol_) ){		
			if (this->getMap()->getCell(Brs_,Kol_)->getIdentity() == 4 ){
int kode ;
				cin >> kode ;

				if (kode == 11 ){
					int i = 0 ;
					bool bahan1 = false ; int idx_bahan1 =  0 ;
					bool bahan2 = false ; int idx_bahan2 =  0 ;
					while(i < inventory.count() ){
						if (inventory.get(i)->getProductID() == 1 ){
							bahan1 = true ; idx_bahan1 = i ; 
						}else if (inventory.get(i)->getProductID() == 3){
							bahan2 = true ; idx_bahan2 = i ; 
						}
						i ++ ;
					}
					if (bahan1 && bahan2){
						inventory.remove(inventory.get( idx_bahan1) ) ;
						inventory.remove(inventory.get( idx_bahan2-1) ) ;
						SideProduct* p = new BeefRolade() ;
						inventory.add(p) ;
					}
				}
				else if ( kode == 12){
					int i = 0 ;
					bool bahan1 = false ; int idx_bahan1 =  0 ;
					bool bahan2 = false ; int idx_bahan2 =  0 ;
					while(i < inventory.count() ){
						if (inventory.get(i)->getProductID() == 1 ){
							bahan1 = true ; idx_bahan1 = i ; 
						}else if (inventory.get(i)->getProductID() == 4){
							bahan2 = true ; idx_bahan2 = i ; 
						}
						i ++ ;
					}
					if (bahan1 && bahan2){
						inventory.remove(inventory.get( idx_bahan1) ) ;
						inventory.remove(inventory.get( idx_bahan2-1) ) ;
						SideProduct* p = new Butter() ;
						inventory.add(p) ;
					}
				}else if ( kode == 13){
					int i = 0 ;
					bool bahan1 = false ; int idx_bahan1 =  0 ;
					bool bahan2 = false ; int idx_bahan2 =  0 ;
					while(i < inventory.count() ){
						if (inventory.get(i)->getProductID() == 5 ){
							bahan1 = true ; idx_bahan1 = i ; 
						}else if (inventory.get(i)->getProductID() == 4){
							bahan2 = true ; idx_bahan2 = i ; 
						}
						i ++ ;
					}
					if (bahan1 && bahan2){
						inventory.remove(inventory.get( idx_bahan1) ) ;
						inventory.remove(inventory.get( idx_bahan2-1) ) ;
						SideProduct* p = new Omelet() ;
						inventory.add(p) ;
					}
				}
				done = true ;
			}
		}
	}
	///Bawah
	if (!done){
		Brs_ = this->getPosBaris() + 1 ;
		Kol_ = this->getPosKolom() ;	
		if (this->getMap()->IsReachable(Brs_,Kol_) ){		
			if (this->getMap()->getCell(Brs_,Kol_)->getIdentity() == 4 ){
int kode ;
				cin >> kode ;

				if (kode == 11 ){
					int i = 0 ;
					bool bahan1 = false ; int idx_bahan1 =  0 ;
					bool bahan2 = false ; int idx_bahan2 =  0 ;
					while(i < inventory.count() ){
						if (inventory.get(i)->getProductID() == 1 ){
							bahan1 = true ; idx_bahan1 = i ; 
						}else if (inventory.get(i)->getProductID() == 3){
							bahan2 = true ; idx_bahan2 = i ; 
						}
						i ++ ;
					}
					if (bahan1 && bahan2){
						inventory.remove(inventory.get( idx_bahan1) ) ;
						inventory.remove(inventory.get( idx_bahan2-1) ) ;
						SideProduct* p = new BeefRolade() ;
						inventory.add(p) ;
					}
				}
				else if ( kode == 12){
					int i = 0 ;
					bool bahan1 = false ; int idx_bahan1 =  0 ;
					bool bahan2 = false ; int idx_bahan2 =  0 ;
					while(i < inventory.count() ){
						if (inventory.get(i)->getProductID() == 1 ){
							bahan1 = true ; idx_bahan1 = i ; 
						}else if (inventory.get(i)->getProductID() == 4){
							bahan2 = true ; idx_bahan2 = i ; 
						}
						i ++ ;
					}
					if (bahan1 && bahan2){
						inventory.remove(inventory.get( idx_bahan1) ) ;
						inventory.remove(inventory.get( idx_bahan2-1) ) ;
						SideProduct* p = new Butter() ;
						inventory.add(p) ;
					}
				}else if ( kode == 13){
					int i = 0 ;
					bool bahan1 = false ; int idx_bahan1 =  0 ;
					bool bahan2 = false ; int idx_bahan2 =  0 ;
					while(i < inventory.count() ){
						if (inventory.get(i)->getProductID() == 5 ){
							bahan1 = true ; idx_bahan1 = i ; 
						}else if (inventory.get(i)->getProductID() == 4){
							bahan2 = true ; idx_bahan2 = i ; 
						}
						i ++ ;
					}
					if (bahan1 && bahan2){
						inventory.remove(inventory.get( idx_bahan1) ) ;
						inventory.remove(inventory.get( idx_bahan2-1) ) ;
						SideProduct* p = new Omelet() ;
						inventory.add(p) ;
					}
				}
				done = true ;
			}
		}
	}	
}

void Player::Interact() {
	bool done = false ;
	int Brs_ , Kol_ ;	
	///Kiri
	if (!done){
		Brs_ = this->getPosBaris() ;
		Kol_ = this->getPosKolom() - 1 ;	
		if (this->getMap()->IsReachable(Brs_,Kol_) ){		
			//Well
			if (this->getMap()->getCell(Brs_,Kol_)->getIdentity() == 3 ){
				water = max_water ;
				done = true ;
			}
			//Truck
			if (this->getMap()->getCell(Brs_,Kol_)->getIdentity() == 5 && this->getMap()->getCell(Brs_,Kol_)->IsPossibleToInteract(0) ){
				this->getMap()->getCell(Brs_,Kol_)->Interact(0) ;
				int kode ;
				cin >> kode ;
				int i = 0 ;
				bool found = false ;
				while(i < inventory.count() && !found){
					if (inventory.get(i)->getProductID() == kode){
						found = true ;
					}else{
						i ++ ;
					}
					
				}
				
				if (found == true){
					money += inventory.get(i)->getHarga() ;
					inventory.remove(inventory.get(i) ) ;
				}
				done = true ;
			}
			//Animal
			if (this->getMap()->getCell(Brs_,Kol_)->getCreation() ){
				Creation* this_ = this->getMap()->getCell(Brs_,Kol_)->getCreation();	
				FarmProduct* p = this_->GetFarmProduct(0) ;
				inventory.add(p) ;
				this_->Action(2) ;
			}

		}
	}
	///Atas
	if (!done){
		Brs_ = this->getPosBaris() - 1 ;
		Kol_ = this->getPosKolom() ;	
		if (this->getMap()->IsReachable(Brs_,Kol_) ){		
			//Well
			if (this->getMap()->getCell(Brs_,Kol_)->getIdentity() == 3 ){
				water = max_water ;
				done = true ;
			}
			//Truck
			if (this->getMap()->getCell(Brs_,Kol_)->getIdentity() == 5 && this->getMap()->getCell(Brs_,Kol_)->IsPossibleToInteract(0) ){
this->getMap()->getCell(Brs_,Kol_)->Interact(0) ;
				int kode ;
				cin >> kode ;
				int i = 0 ;
				bool found = false ;
				while(i < inventory.count() && !found){
					if (inventory.get(i)->getProductID() == kode){
						found = true ;
					}else{
						i ++ ;
					}
					
				}
				
				if (found == true){
					money += inventory.get(i)->getHarga() ;
					inventory.remove(inventory.get(i) ) ;
				}
				done = true ;
			}
			//Animal
			if (this->getMap()->getCell(Brs_,Kol_)->getCreation() ){
				Creation* this_ = this->getMap()->getCell(Brs_,Kol_)->getCreation();	
				FarmProduct* p = this_->GetFarmProduct(0) ;
				inventory.add(p) ;
				this_->Action(2) ;
			}	
					
		}
	}
	///Kanan
	if (!done){
		Brs_ = this->getPosBaris() ;
		Kol_ = this->getPosKolom() + 1 ;	
		if (this->getMap()->IsReachable(Brs_,Kol_) ){		
			//Well
			if (this->getMap()->getCell(Brs_,Kol_)->getIdentity() == 3 ){
				water = max_water ;
				done = true ;			
			}
			//Truck
			if (this->getMap()->getCell(Brs_,Kol_)->getIdentity() == 5 && this->getMap()->getCell(Brs_,Kol_)->IsPossibleToInteract(0) ){
this->getMap()->getCell(Brs_,Kol_)->Interact(0) ;
				int kode ;
				cin >> kode ;
				int i = 0 ;
				bool found = false ;
				while(i < inventory.count() && !found){
					if (inventory.get(i)->getProductID() == kode){
						found = true ;
					}else{
						i ++ ;
					}
					
				}
				
				if (found == true){
					money += inventory.get(i)->getHarga() ;
					inventory.remove(inventory.get(i) ) ;
				}
				done = true ;
			}
			//Animal
			if (this->getMap()->getCell(Brs_,Kol_)->getCreation() ){
				Creation* this_ = this->getMap()->getCell(Brs_,Kol_)->getCreation();	
				FarmProduct* p = this_->GetFarmProduct(0) ;
				inventory.add(p) ;
				this_->Action(2) ;
			}			
		}
	}
	///Bawah
	if (!done){
		Brs_ = this->getPosBaris() + 1 ;
		Kol_ = this->getPosKolom() ;	
		if (this->getMap()->IsReachable(Brs_,Kol_) ){		
			//Well
			if (this->getMap()->getCell(Brs_,Kol_)->getIdentity() == 3 ){
				water = max_water ;
				done = true ;
			}
			//Truck
			if (this->getMap()->getCell(Brs_,Kol_)->getIdentity() == 5 && this->getMap()->getCell(Brs_,Kol_)->IsPossibleToInteract(0) ){
this->getMap()->getCell(Brs_,Kol_)->Interact(0) ;
				int kode ;
				cin >> kode ;
				int i = 0 ;
				bool found = false ;
				while(i < inventory.count() && !found){
					if (inventory.get(i)->getProductID() == kode){
						found = true ;
					}else{
						i ++ ;
					}
					
				}
				
				if (found == true){
					money += inventory.get(i)->getHarga() ;
					inventory.remove(inventory.get(i) ) ;
				}
				done = true ;
			}
			//Animal
			if (this->getMap()->getCell(Brs_,Kol_)->getCreation() ){
				Creation* this_ = this->getMap()->getCell(Brs_,Kol_)->getCreation();	
				FarmProduct* p = this_->GetFarmProduct(0) ;
				inventory.add(p) ;
				this_->Action(2) ;
			}			
		}
	}				
}	

void Player::Talk() {
	bool done = false ;
	int Brs_ , Kol_ ;	
	///Kiri
	if (!done){
		Brs_ = this->getPosBaris() ;
		Kol_ = this->getPosKolom() - 1 ;	
		if (this->getMap()->IsReachable(Brs_,Kol_) ){		
			if (this->getMap()->getCell(Brs_,Kol_)->getCreation() ){
				this->getMap()->getCell(Brs_,Kol_)->getCreation()->Action(0) ;
				done = true ;
			}
		}
	}
	///Atas
	if (!done){
		Brs_ = this->getPosBaris() - 1 ;
		Kol_ = this->getPosKolom() ;	
		if (this->getMap()->IsReachable(Brs_,Kol_) ){		
			if (this->getMap()->getCell(Brs_,Kol_)->getCreation() ){
				this->getMap()->getCell(Brs_,Kol_)->getCreation()->Action(0) ;
				done = true ;
			}
		}
	}
	///Kanan
	if (!done){
		Brs_ = this->getPosBaris() ;
		Kol_ = this->getPosKolom() + 1 ;	
		if (this->getMap()->IsReachable(Brs_,Kol_) ){		
			if (this->getMap()->getCell(Brs_,Kol_)->getCreation() ){
				this->getMap()->getCell(Brs_,Kol_)->getCreation()->Action(0) ;
				done = true ;
			}
		}
	}
	///Bawah
	if (!done){
		Brs_ = this->getPosBaris() + 1 ;
		Kol_ = this->getPosKolom() ;	
		if (this->getMap()->IsReachable(Brs_,Kol_) ){		
			if (this->getMap()->getCell(Brs_,Kol_)->getCreation() ){
				this->getMap()->getCell(Brs_,Kol_)->getCreation()->Action(0) ;
				done = true ;
			}
		}
	}		
}

int Player::getMoney() {
	return money ;
}
int Player::getWater() {
	return water ;
}
void Player::setMoney(int _m) {
	money = _m ;
}
void Player::setWater(int _w) {
	water =  _w ;
}

void Player::showInventory(){
	cout << endl ;
	
	for(int i = 0 ; i < inventory.count() ; i ++ ){
		switch(inventory.get(i)->getProductID() ){
		case 1 : 
			cout << "Chicken Egg" << endl ;	
			break ;
		case 2 :
			cout << "Chicken Meat" << endl ;	
			break ;
		case 3 :
			cout << "Cow Meat" << endl ;
			break ;
		case 4 :			
			cout << "Cow Milk" << endl ;
			break ;
		case 5 :			
			cout << "Duck Egg" << endl ;
			break ;
		case 6 :			
			cout << "Duck Meat" << endl ;
			break ;
		case 11 :			
			cout << "Beef Rolade" << endl ;
			break ;
		case 12 :			
			cout << "Butter" << endl ;
			break ;			
		case 13 :			
			cout << "Ommelet" << endl ;
			break ;
		}

	}
}

Player::Player() {
	money = 100 ;
	water = 10 ;
	max_water = 20 ;
	
	FarmProduct* p = new ChickenEgg() ;
	FarmProduct* p2 = new ChickenMeat() ;
	FarmProduct* p3 = new ChickenEgg() ;
	FarmProduct* p4 = new ChickenEgg() ;
	
	if (inventory.isEmpty() ){
		inventory.add(p) ;
		inventory.add(p2) ;
		inventory.add(p3) ;
		inventory.add(p4) ;
		//inventory.remove( inventory.get(0) ) ;
	}
	//inventory.add(p) ;
}

void Player::Grow() {
	if (water > 0 ){
		this->getMap()->getCell(this->getPosBaris() ,this->getPosKolom() )->Interact(0) ; ;
		water -= 1 ; 
	}
}


