#ifndef land_
#define land_

#include "cell.h"

class Land : public Cell  {
	private :
		bool grass ;
	public :
		void render() ;
		void Interact(int) ;
		
		bool getGrass() ;
		void setGrass(bool) ;
		
		bool GetAtribute(int) ;
};

#endif
