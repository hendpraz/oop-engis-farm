#ifndef creation_
#define creation_

#include "renderable.h"
#include "farmproduct.h"

class Creation : public Renderable{
	private :
		int posBaris , posKolom ;
	public :
		int getPosBaris() ;
		int getPosKolom() ;
		void setPosisi(int,int) ;
		
		void render() ;
		
		virtual void GotKilled() ;
		
		virtual void Action(int) ;
		virtual bool GetAtribute(int) ;
		
		virtual FarmProduct* GetFarmProduct(int) ; 
}; 

#endif

