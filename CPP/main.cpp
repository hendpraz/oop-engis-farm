#include <iostream>
#include <bits/stdc++.h>
#include <vector>
#include <string>
using namespace std ;

#include "vision.h"
#include "creation.h"
#include "renderable.h"

#include "player.h"

#include "farmanimal.h"

//Macam-macam FarmAnimal
#include "eggproducingfarmanimal.h"
#include "meatproducingfarmanimal.h"
#include "milkproducingfarmanimal.h"

//Riil FarmAnimal
#include "chicken.h"

//Product
#include "product.h"
#include "farmproduct.h"
#include "sideproduct.h"

#include "map.h"

#include "cell.h"

//Macam-macam Cell
#include "land.h"
#include "facility.h"

//Macam-macam Land
#include "barn.h"
#include "grassland.h"
#include "coop.h"

//Macam-macam Facility
#include "well.h"
#include "mixer.h"
#include "truck.h"



int main(int argc, char** argv) {		
	//cout << b->get << endl ;

	/*
	Ket : 
	              Tdk Berumput		Berumput
	Barn				x				*
	Coop   				=				#
	Grassland			-				+	
	
	Player : P
	Well : W , Mixer : M , Truck : T
				Tdk Lapar	Lapar
	Chicken			C		  c	
	*/
	
	////HardCode
	int Baris = 10 , Kolom = 9 ;
	
	//Tanpa Hewan
	string file = "" ;
 	file.append("Wxxxxx***") ;
 	file.append("*xxxxx***") ;
 	file.append("*xxxxxxxx") ;
 	file.append("----=+---") ;
	file.append("----=+---") ;
	file.append("---+#M---") ;
	file.append("T+===#===") ;
	file.append("==##=#===") ;
	file.append("===###=#=") ;
	file.append("==####===") ;
		
	//Count Object
	int n_Barn = 0, n_Grassland = 0, n_Coop = 0 , n_Mixer = 0 , n_Well = 0 , n_Truck = 0 ;
	
	int n = file.length(); 
    char char_array[n]; 
    strcpy(char_array, file.c_str() ); 
    for (int i = 0; i < n; i++) {
    	if ( char_array[i] == 'x' || char_array[i] == '*' ) {
    		n_Barn += 1 ;
    	} else if ( char_array[i] == '-' || char_array[i] == '+' ) {
    		n_Grassland  += 1 ;
    	} else if ( char_array[i] == '=' || char_array[i] == '#' ) {
    		n_Coop += 1 ;
    	} else if ( char_array[i] == 'M'  ) {
    		n_Mixer += 1 ;
    	} else if ( char_array[i] == 'W'  ) {
    		n_Well += 1 ;
    	} else if ( char_array[i] == 'T'  ) {
    		n_Truck += 1 ;
    	}
    }
	
	Barn g_barn [n_Barn] ;
	Grassland g_grassland [n_Grassland] ;
	Coop g_coop [n_Coop] ;
	Mixer g_mixer [n_Mixer] ;
	Well g_well [n_Well] ;
	Truck g_truck [n_Truck] ;
		
	
	
	///Create Map
	Map gmap(Baris,Kolom) ;	
	
	///SET Map		
	int iterator_file = 0 ;
	
	int iterator_barn = 0 ;
	int iterator_grassland = 0 ;
	int iterator_mixer = 0 ;
	int iterator_well = 0 ;
	int iterator_truck = 0 ;		
	int iterator_coop = 0 ;	
		
	for(int i = 0 ; i < gmap.getWidth() ; i ++ ){
		for(int j = 0 ; j < gmap.getHeight() ; j ++ ){	
				switch(char_array[iterator_file]) {
				case 'x' :
					g_barn[iterator_barn].setGrass(false) ;
					gmap.setCell(i,j,&g_barn[iterator_barn] ) ;
					iterator_barn += 1 ;
					break ;
				case '*' :
					g_barn[iterator_barn].setGrass(true) ;
					gmap.setCell(i,j,&g_barn[iterator_barn] ) ;
					iterator_barn += 1 ;
					break ;	
				case '-' :
					g_grassland[iterator_grassland].setGrass(false) ;
					gmap.setCell(i,j,&g_grassland[iterator_grassland] ) ;
					iterator_grassland += 1 ;
					break ;	
				case '+' :
					g_grassland[iterator_grassland].setGrass(true) ;
					gmap.setCell(i,j,&g_grassland[iterator_grassland] ) ;
					iterator_grassland += 1 ;
					break ;
				case '=' :
					g_coop[iterator_coop].setGrass(false) ;
					gmap.setCell(i,j,&g_coop[iterator_coop] ) ;
					iterator_coop += 1 ;
					break ;	
				case '#' :
					g_coop[iterator_coop].setGrass(true) ;
					gmap.setCell(i,j,&g_coop[iterator_coop] ) ;
					iterator_coop += 1 ;
					break ;	
				case 'W' :
					gmap.setCell(i,j,&g_well[iterator_well] ) ;
					iterator_well += 1 ;
					break ;	
				case 'M' :
					gmap.setCell(i,j,&g_mixer[iterator_mixer] ) ;
					iterator_mixer += 1 ;
					break ;	
				case 'T' :
					gmap.setCell(i,j,&g_truck[iterator_truck] ) ;
					iterator_truck += 1 ;
					break ;	
					
				default :
					break ;	
				}
							
			iterator_file += 1 ;			
		}
	}
	
	Player player ;
	int BrsPlayer = 1 , KolPlayer = 1 ;
	
	Chicken c ;	
	int BrsChicken = 0 , KolChicken = 4 ;
	//Chicken c2 ;
	//int BrsChicken2 = 3 , KolChicken2 = 4 ;
	
	///Setting Player And Animal
	c.setMap(&gmap) ;
	c.setPosisi(BrsChicken,KolChicken) ;	
	c.getMap()->getCell(c.getPosBaris() , c.getPosKolom() )->setCreation(&c) ;
	
	//c2.setMap(&gmap) ;
	//c2.setPosisi(BrsChicken2,KolChicken2) ;	
	//c2.getMap()->getCell(c2.getPosBaris() , c2.getPosKolom() )->setCreation(&c2) ;
	
	player.setMap(&gmap) ;	
	player.setPosisi(BrsPlayer,KolPlayer) ;	
	player.getMap()->getCell(player.getPosBaris() , player.getPosKolom() )->setCreation(&player) ;


	string input = "" ;
	while(input != "end" && FarmAnimal::getCountAnimal() != 0){		
		///RENDER
		for(int i = 0 ; i < gmap.getWidth() ; i ++ ){
			for(int j = 0 ; j < gmap.getHeight() ; j ++ ){
				cout << " " ;
				gmap.getCell(i,j)->render() ;
				cout << " " ;
			}
			cout << endl ;
		}	
		cout << endl << "Inventory : " ; player.showInventory() ;
		cout << endl << "Money : " << player.getMoney() ;
		cout << endl << "Water : " << player.getWater() ;
		
		///INPUT
		cout << endl << endl << "Command : " ;	
		cin >> input ;
		cout << endl ;
		if (input == "end"){
			
		}else if (input == "kiri"){
			player.Bergerak(0) ;
		}else if (input == "atas"){
			player.Bergerak(1) ;
		}else if (input == "kanan"){
			player.Bergerak(2) ;
		}else if (input == "bawah"){
			player.Bergerak(3) ;
		}else if (input == "kill"){
			player.Kill() ;
		}else if (input == "interact"){
			player.Interact() ;
		}else if (input == "grow"){
			player.Grow() ;
		}else if (input == "talk"){
			player.Talk() ;
		}else if (input == "mix"){
			player.Mix() ;
		}
	
		///UPDATE	
			for(int i = 0 ; i < gmap.getWidth() ; i ++ ){
				for(int j = 0 ; j < gmap.getHeight() ; j ++ ){
					gmap.getCell(i,j)->Update() ;
				}
			}
			for(int i = 0 ; i < gmap.getWidth() ; i ++ ){
				for(int j = 0 ; j < gmap.getHeight() ; j ++ ){								
					Creation* this_C = gmap.getCell(i,j)->getCreation();
					if (this_C) {
						this_C->Action(99) ;	
					}
					
				}
			}
		
	}
	
	cout << endl ;
	cout << "--------------------------------------" ;
	cout << endl ;
	///RENDER TERAKHIR
		for(int i = 0 ; i < gmap.getWidth() ; i ++ ){
			for(int j = 0 ; j < gmap.getHeight() ; j ++ ){
				cout << " " ;
				gmap.getCell(i,j)->render() ;
				cout << " " ;
			}
			cout << endl ;
		}	
		cout << endl << "Inventory : " ; player.showInventory() ;
		cout << endl << "Money : " << player.getMoney() ;
		cout << endl << "Water : " << player.getWater() ;
	cout << endl << endl << "~~~Tamat Deh~~~" << endl << endl ;
	
	
	
	return 0;
	
}

