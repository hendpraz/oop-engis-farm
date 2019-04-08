#ifndef cell_
#define cell_

#include "renderable.h"
#include "creation.h"

class Cell : public Renderable  {
	private :
		Creation* creation = NULL ;

		
	public :
		void render() ;
		
		
		void setCreation(Creation* ) ;
		Creation* getCreation() ;
		virtual int getIdentity() ;
		
		virtual bool GetAtribute(int) ;
		virtual void Interact(int) ;
		virtual bool IsPossibleToInteract(int) ;
		// 0 : Barn
		// 1 : Coop
		// 2 : Grassland 
		// 3 : Well
		// 4 : Mixer
		// 5 : Truck
		
		virtual void Update() ;



};

#endif
