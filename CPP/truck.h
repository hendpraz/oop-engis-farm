#ifndef truck_
#define truck_

#include "facility.h"

class Truck: public Facility  {
	private :
		int time_truck ; //Sisa waktu truck untuk kembali ke kebun , jika time_truck = 0 maka truck telah kembali
		int truck_duration  ; //Jangka Waktu Truck Ke Pasar Dan Balik Lagi
		
	public :
		friend class player;
		Truck() ;
		void render() ;
		int getIdentity() ;
		void Update() ;
		
		void Interact(int) ;
		bool IsPossibleToInteract(int) ;
		
		void trukPergi();
		void showListOfProduct();
};

#endif
