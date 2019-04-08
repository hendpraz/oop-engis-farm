#ifndef player_
#define player_

#include "creation.h"
#include "vision.h"
#include "linkedlist.h"
#include "product.h"
#include "sideproduct.h"
#include "farmproduct.h"

#include "chickenegg.h"
#include "chickenmeat.h"

#include "beefrolade.h"
#include "butter.h"
#include "omelet.h"
class Player : public Creation ,public Vision {
	private :
		int money , water ;
		int max_water  ;
		LinkedList<Product> inventory ; 
	public :
		Player() ;
		
		void render() ;
		
		void Bergerak(int i) ;
		
		void Kill() ;
		void Interact() ;
		void Grow() ;
		void Talk() ;
		void Mix() ;
		
		int getMoney() ;
		int getWater() ;
		void setMoney(int _m) ;
		void setWater(int _w) ;		
		
		
		///Inventory
		void showInventory() ;
};

#endif
