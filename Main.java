//package main;
/*
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
/*#include "eggproducingfarmanimal.h"
#include "meatproducingfarmanimal.h"
#include "milkproducingfarmanimal.h"

//Riil FarmAnimal
#include "chicken.h"*/

//Product
/*#include "product.h"
#include "farmproduct.h"
#include "sideproduct.h"*/

/*#include "map.h"

#include "cell.h"

//Macam-macam Cell
#include "land.h"
#include "facility.h"

//Macam-macam Land
#include "barn.h"
#include "grassland.h"
#include "coop.h"*/

//Macam-macam Facility
/*#include "well.h"
#include "mixer.h"
#include "truck.h"
*/
import main.facilities.*;
import main.farmanimal.*;
import main.land.*;
import main.products.*;
import main.src.*;

import java.util.*;
import java.io.*;

//BUGS LEFT : interact with animal, kill animal, inventory

class Main{

//main(int argc, char** argv)
public static void main(String args[]){
		
	//System.out.print( b.get << endl ;

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
	StringBuilder file = new StringBuilder() ;
	
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
    char[] char_array = new char[n]; 
    
    //strcpy(char_array, file.c_str() ); 
    for(int i = 0; i < file.length(); i++){
		char_array[i] = file.charAt(i);
	}
    
    
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
	
	Barn[] g_barn = new Barn[n_Barn] ;
	Grassland[] g_grassland = new Grassland [n_Grassland] ;
	Coop[] g_coop = new Coop [n_Coop] ;
	Mixer[] g_mixer = new Mixer [n_Mixer] ;
	Well[] g_well = new Well [n_Well] ;
	Truck[] g_truck = new Truck[n_Truck] ;
		
	
	
	///Create Map
	main.src.Map gmap = new main.src.Map (Baris,Kolom) ;	
	
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
					g_barn[iterator_barn] = new Barn();
					g_barn[iterator_barn].setGrass(false) ;
					gmap.setCell(i,j,g_barn[iterator_barn] ) ;
					iterator_barn += 1 ;
					break ;
				case '*' :
					g_barn[iterator_barn] = new Barn();
					g_barn[iterator_barn].setGrass(true) ;
					gmap.setCell(i,j,g_barn[iterator_barn] ) ;
					iterator_barn += 1 ;
					break ;	
				case '-' :
					g_grassland[iterator_grassland] = new Grassland();
					g_grassland[iterator_grassland].setGrass(false) ;
					gmap.setCell(i,j,g_grassland[iterator_grassland] ) ;
					iterator_grassland += 1 ;
					break ;	
				case '+' :
					g_grassland[iterator_grassland] = new Grassland();
					g_grassland[iterator_grassland].setGrass(true) ;
					gmap.setCell(i,j,g_grassland[iterator_grassland] ) ;
					iterator_grassland += 1 ;
					break ;
				case '=' :
					g_coop[iterator_coop] = new Coop();
					g_coop[iterator_coop].setGrass(false) ;
					gmap.setCell(i,j,g_coop[iterator_coop] ) ;
					iterator_coop += 1 ;
					break ;	
				case '#' :
					g_coop[iterator_coop] = new Coop();
					g_coop[iterator_coop].setGrass(true) ;
					gmap.setCell(i,j,g_coop[iterator_coop] ) ;
					iterator_coop += 1 ;
					break ;	
				case 'W' :
					g_well[iterator_well] = new Well();
					gmap.setCell(i,j,g_well[iterator_well] ) ;
					iterator_well += 1 ;
					break ;	
				case 'M' :
					g_mixer[iterator_mixer] = new Mixer();
					gmap.setCell(i,j,g_mixer[iterator_mixer] ) ;
					iterator_mixer += 1 ;
					break ;	
				case 'T' :
					g_truck[iterator_truck] = new Truck();
					gmap.setCell(i,j,g_truck[iterator_truck] ) ;
					iterator_truck += 1 ;
					break ;	
					
				default :
					break ;	
				}
							
			iterator_file += 1 ;			
		}
	}
	
	Player player = new Player();
	int BrsPlayer = 1 , KolPlayer = 1 ;
	
	Chicken c = new Chicken();	
	int BrsChicken = 0 , KolChicken = 4 ;
	//Chicken c2 ;
	//int BrsChicken2 = 3 , KolChicken2 = 4 ;
	
	///Setting Player And Animal
	c.setMap(gmap) ;
	c.setPosisi(BrsChicken,KolChicken) ;	
	c.getMap().getCell(c.getPosBaris() , c.getPosKolom() ).setCreation(c) ;
	
	//c2.setMap(gmap) ;
	//c2.setPosisi(BrsChicken2,KolChicken2) ;	
	//c2.getMap().getCell(c2.getPosBaris() , c2.getPosKolom() ).setCreation(c2) ;
	
	player.setMap(gmap) ;	
	player.setPosisi(BrsPlayer,KolPlayer) ;	
	player.getMap().getCell(player.getPosBaris() , player.getPosKolom() ).setCreation(player) ;


	String input = "" ;
	while((input != "end") && (FarmAnimal.getCountAnimal() != 0)){		
		///RENDER
		for(int i = 0 ; i < gmap.getWidth() ; i ++ ){
			for(int j = 0 ; j < gmap.getHeight() ; j ++ ){
				System.out.print( " " );
				gmap.getCell(i,j).render() ;
				System.out.print( " " );
			}
			System.out.println( );
		}	
		System.out.println( "\nInventory : " );
		player.showInventory() ;
		System.out.println( "\nMoney : " + player.getMoney() );
		System.out.println( "Water : " + player.getWater() );
		
		///INPUT
		System.out.print( "\n\nCommand : ") ;	
		//cin >> input ;
		Scanner inp2 = new Scanner(System.in);
		input = inp2.nextLine();
		System.out.println() ;
		if (input == "end"){
			
		}else if (input.matches("kiri")){
			player.Bergerak(0) ;
		}else if (input.matches("atas")){
			player.Bergerak(1) ;
		}else if (input.matches("kanan")){
			player.Bergerak(2) ;
		}else if (input.matches("bawah")){
			player.Bergerak(3) ;
		}else if (input.matches("kill")){
			player.Kill() ;
		}else if (input.matches("interact")){
			player.interact() ;
		}else if (input.matches("grow")){
			player.Grow() ;
		}else if (input.matches("talk")){
			player.Talk() ;
		}else if (input.matches("mix")){
			player.Mix() ;
		}else{
			System.out.println("INPUT SALAH!");
			System.out.print("Input Anda : " + input);
			System.out.print("\n-----\n");
		}
	
		///UPDATE	
			for(int i = 0 ; i < gmap.getWidth() ; i ++ ){
				for(int j = 0 ; j < gmap.getHeight() ; j ++ ){
					gmap.getCell(i,j).update() ;
				}
			}
			for(int i = 0 ; i < gmap.getWidth() ; i ++ ){
				for(int j = 0 ; j < gmap.getHeight() ; j ++ ){								
					Creation this_C = gmap.getCell(i,j).getCreation();
					if (this_C != null) {
						this_C.Action(99) ;	
					}
					
				}
			}
		
	}
	
	System.out.println();
	System.out.print( "--------------------------------------" );
	System.out.println();
	///RENDER TERAKHIR
		for(int i = 0 ; i < gmap.getWidth() ; i ++ ){
			for(int j = 0 ; j < gmap.getHeight() ; j ++ ){
				System.out.print( " " );
				gmap.getCell(i,j).render() ;
				System.out.print( " " );
			}
			System.out.println();
		}	
		System.out.println("\nInventory : " ) ; 
		player.showInventory() ;
		System.out.println("\nMoney : " + player.getMoney()) ;
		System.out.println("\nWater : " + player.getWater()) ;
	System.out.print( "\n\n~~~Tamat Deh~~~\n\n" ) ;
	
}

}
