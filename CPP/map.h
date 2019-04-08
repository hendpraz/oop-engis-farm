#ifndef map_
#define map_

#include "cell.h"
#include <vector>
#include "creation.h"

class Map {
	private :
		vector<vector<Cell*> > mc;  //matrix of cell	
		int width , height ;	
		
	public :
		
		Map(int,int) ;
		
		int getWidth() ;
		int getHeight() ;
		
		Cell* getCell(int,int) ;
		void setCell(int,int,Cell*) ;
		
		void setCreation(int _i, int _j,Creation*) ;
		
		bool IsReachable(int,int) ;
		
		

};

#endif
