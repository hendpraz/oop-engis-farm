//#include "creation.h"
//#include "vision.h"
//#include "linkedlist.h"
//#include "product.h"
//#include "sideproduct.h"
//#include "farmproduct.h"

//#include "chickenegg.h"
//#include "chickenmeat.h"

//#include "beefrolade.h"
//#include "butter.h"
//#include "omelet.h"

import java.util.*;
import java.util.LinkedList;

public class Player extends Creation implements Vision{

private int money , water ;
private int max_water  ;
private LinkedList<Product> inventory ; 

public char render() {
	//System.out.print( 'P' );
	return 'P' ;
}

public void Bergerak(int i) {
	/*
	0 : Kiri
	1 : Atas
	2 : Kanan
	3 : Bawah
	*/
	int Brs_ = 0;
	int Kol_ = 0;
	
	switch(i){
		case 0 : 
			Brs_ = this.getPosBaris() ;
			Kol_ = this.getPosKolom() - 1 ;	
			break ;
		case 1 :
			Brs_ = this.getPosBaris() - 1;
			Kol_ = this.getPosKolom() ;
			break ;
		case 2 :
			Brs_ = this.getPosBaris() ;
			Kol_ = this.getPosKolom() + 1 ;
			break ;
		case 3 :			
			Brs_ = this.getPosBaris() + 1;
			Kol_ = this.getPosKolom() ;			
			break ;
	}
	
	if ( this.getMap().IsReachable(Brs_,Kol_) ){
		Cell current_cell = this.getMap().getCell( this.getPosBaris(), this.getPosKolom()  ) ;	
		Cell current_cell_tujuan = this.getMap().getCell( Brs_  , Kol_ ) ;	
		///ConstraintOfFacility
		if (current_cell_tujuan.getIdentity() != 3 && current_cell_tujuan.getIdentity() != 4 && current_cell_tujuan.getIdentity() != 5){
			
			///ConstraintOfCreation
			if (current_cell_tujuan.getCreation() == null){
				Creation this_ = current_cell.getCreation();	
				current_cell.setCreation(null) ;	
				current_cell_tujuan.setCreation(this_) ;			
				this.setPosisi(Brs_,  Kol_ ) ;
			}
		}			
		
	}
	
}

public boolean GetAtribute(int n){
	//do nothing
	return false;
}

public void GotKilled(){
	
}

public void Kill() {
	boolean done = false ;	
	int Brs_ , Kol_ ;
	
	///Kiri
	if (!done){
		Brs_ = this.getPosBaris() ;
		Kol_ = this.getPosKolom() - 1 ;		
		if (this.getMap().IsReachable(Brs_,Kol_) ){
			Creation p = this.getMap().getCell(Brs_,Kol_).getCreation() ;
			if ((p != null) && p.GetAtribute(1) ){	
				FarmProduct p_ = p.GetFarmProduct(1) ;
				inventory.add(p_) ;
				this.getMap().getCell(Brs_,Kol_).setCreation(null) ;		
				p.GotKilled() ;
				done = true ;
			}			
		}
	}
	///Atas
	if (!done){
		Brs_ = this.getPosBaris() - 1 ;
		Kol_ = this.getPosKolom() ;	
		if (this.getMap().IsReachable(Brs_,Kol_) ){		
			Creation p = this.getMap().getCell(Brs_,Kol_).getCreation() ;
			if ((p != null) && p.GetAtribute(1)){
				FarmProduct p_ = p.GetFarmProduct(1) ;
				inventory.add(p_) ;
				this.getMap().getCell(Brs_,Kol_).setCreation(null) ;		
				p.GotKilled() ;
				done = true ;
			}
		}
	}
	///Kanan
	if (!done){
		Brs_ = this.getPosBaris() ;
		Kol_ = this.getPosKolom() + 1 ;	
		if (this.getMap().IsReachable(Brs_,Kol_) ){		
			Creation p = this.getMap().getCell(Brs_,Kol_).getCreation() ;
			if ((p != null) && p.GetAtribute(1) ){
				FarmProduct p_ = p.GetFarmProduct(1) ;
				inventory.add(p_) ;
				this.getMap().getCell(Brs_,Kol_).setCreation(null) ;		
				p.GotKilled() ;
				done = true ;
			}
		}
	}
	///Bawah
	if (!done){
		Brs_ = this.getPosBaris() + 1 ;
		Kol_ = this.getPosKolom() ;	
		if (this.getMap().IsReachable(Brs_,Kol_) ){		
			Creation p = this.getMap().getCell(Brs_,Kol_).getCreation() ;
			if ((p != null) && (p.GetAtribute(1))){
				FarmProduct p_ = p.GetFarmProduct(1) ;
				inventory.add(p_) ;
				this.getMap().getCell(Brs_,Kol_).setCreation(null) ;		
				p.GotKilled() ;
				done = true ;
			}
		}
	}				
}

public void Mix() {
	boolean done = false ;
	int Brs_ , Kol_ ;
	///Kiri
	if (!done){
		Brs_ = this.getPosBaris() ;
		Kol_ = this.getPosKolom() - 1 ;		
		if (this.getMap().IsReachable(Brs_,Kol_) ){
			if (this.getMap().getCell(Brs_,Kol_).getIdentity() == 4 ){
				System.out.println( "11. Beef Rolade" ); //CowMeat + ChickenEgg
				System.out.println( "12. Butter" ); // ChickenEgg + Milk
				System.out.println( "13. Omelet" ); // DuckEgg + Milk
				System.out.println( "Masukkan kode sideProduct (11-13)");
				Scanner inp = new Scanner(System.in);
				int kode ;
				//cin >> kode ;
				kode = inp.nextInt();

				if (kode == 11 ){
					int i = 0 ;
					boolean bahan1 = false ; int idx_bahan1 =  0 ;
					boolean bahan2 = false ; int idx_bahan2 =  0 ;
					while(i < inventory.size() ){
						if (inventory.get(i).getProductID() == 1 ){
							bahan1 = true ; idx_bahan1 = i ; 
						}else if (inventory.get(i).getProductID() == 3){
							bahan2 = true ; idx_bahan2 = i ; 
						}
						i ++ ;
					}
					if (bahan1 && bahan2){
						inventory.remove(inventory.get( idx_bahan1) ) ;
						inventory.remove(inventory.get( idx_bahan2-1) ) ;
						SideProduct p = new BeefRolade() ;
						inventory.add(p) ;
					}
				}
				else if ( kode == 12){
					int i = 0 ;
					boolean bahan1 = false ; int idx_bahan1 =  0 ;
					boolean bahan2 = false ; int idx_bahan2 =  0 ;
					while(i < inventory.size() ){
						if (inventory.get(i).getProductID() == 1 ){
							bahan1 = true ; idx_bahan1 = i ; 
						}else if (inventory.get(i).getProductID() == 4){
							bahan2 = true ; idx_bahan2 = i ; 
						}
						i ++ ;
					}
					if (bahan1 && bahan2){
						inventory.remove(inventory.get( idx_bahan1) ) ;
						inventory.remove(inventory.get( idx_bahan2-1) ) ;
						SideProduct p = new Butter() ;
						inventory.add(p) ;
					}
				}else if ( kode == 13){
					int i = 0 ;
					boolean bahan1 = false ; int idx_bahan1 =  0 ;
					boolean bahan2 = false ; int idx_bahan2 =  0 ;
					while(i < inventory.size() ){
						if (inventory.get(i).getProductID() == 5 ){
							bahan1 = true ; idx_bahan1 = i ; 
						}else if (inventory.get(i).getProductID() == 4){
							bahan2 = true ; idx_bahan2 = i ; 
						}
						i ++ ;
					}
					if (bahan1 && bahan2){
						inventory.remove(inventory.get( idx_bahan1) ) ;
						inventory.remove(inventory.get( idx_bahan2-1) ) ;
						SideProduct p = new Omelet() ;
						inventory.add(p) ;
					}
				}
				done = true ;
			}		
		}
	}
	///Atas
	if (!done){
		Brs_ = this.getPosBaris() - 1 ;
		Kol_ = this.getPosKolom() ;	
		if (this.getMap().IsReachable(Brs_,Kol_) ){		
			if (this.getMap().getCell(Brs_,Kol_).getIdentity() == 4 ){
				System.out.println( "11. Beef Rolade" ); //CowMeat + ChickenEgg
				System.out.println( "12. Butter" ); // ChickenEgg + Milk
				System.out.println( "13. Omelet" ); // DuckEgg + Milk
				System.out.println( "Masukkan kode sideProduct (11-13)");
				
				Scanner inp = new Scanner(System.in);
				int kode ;
				//cin >> kode ;
				kode = inp.nextInt();

				if (kode == 11 ){
					int i = 0 ;
					boolean bahan1 = false ; int idx_bahan1 =  0 ;
					boolean bahan2 = false ; int idx_bahan2 =  0 ;
					while(i < inventory.size() ){
						if (inventory.get(i).getProductID() == 1 ){
							bahan1 = true ; idx_bahan1 = i ; 
						}else if (inventory.get(i).getProductID() == 3){
							bahan2 = true ; idx_bahan2 = i ; 
						}
						i ++ ;
					}
					if (bahan1 && bahan2){
						inventory.remove(inventory.get( idx_bahan1) ) ;
						inventory.remove(inventory.get( idx_bahan2-1) ) ;
						SideProduct p = new BeefRolade() ;
						inventory.add(p) ;
					}
				}
				else if ( kode == 12){
					int i = 0 ;
					boolean bahan1 = false ; int idx_bahan1 =  0 ;
					boolean bahan2 = false ; int idx_bahan2 =  0 ;
					while(i < inventory.size() ){
						if (inventory.get(i).getProductID() == 1 ){
							bahan1 = true ; idx_bahan1 = i ; 
						}else if (inventory.get(i).getProductID() == 4){
							bahan2 = true ; idx_bahan2 = i ; 
						}
						i ++ ;
					}
					if (bahan1 && bahan2){
						inventory.remove(inventory.get( idx_bahan1) ) ;
						inventory.remove(inventory.get( idx_bahan2-1) ) ;
						SideProduct p = new Butter() ;
						inventory.add(p) ;
					}
				}else if ( kode == 13){
					int i = 0 ;
					boolean bahan1 = false ; int idx_bahan1 =  0 ;
					boolean bahan2 = false ; int idx_bahan2 =  0 ;
					while(i < inventory.size() ){
						if (inventory.get(i).getProductID() == 5 ){
							bahan1 = true ; idx_bahan1 = i ; 
						}else if (inventory.get(i).getProductID() == 4){
							bahan2 = true ; idx_bahan2 = i ; 
						}
						i ++ ;
					}
					if (bahan1 && bahan2){
						inventory.remove(inventory.get( idx_bahan1) ) ;
						inventory.remove(inventory.get( idx_bahan2-1) ) ;
						SideProduct p = new Omelet() ;
						inventory.add(p) ;
					}
				}
				done = true ;
			}
		}
	}
	///Kanan
	if (!done){
		Brs_ = this.getPosBaris() ;
		Kol_ = this.getPosKolom() + 1 ;	
		if (this.getMap().IsReachable(Brs_,Kol_) ){		
			if (this.getMap().getCell(Brs_,Kol_).getIdentity() == 4 ){
				System.out.println( "11. Beef Rolade" ); //CowMeat + ChickenEgg
				System.out.println( "12. Butter" ); // ChickenEgg + Milk
				System.out.println( "13. Omelet" ); // DuckEgg + Milk
				System.out.println( "Masukkan kode sideProduct (11-13)");
				
				Scanner inp = new Scanner(System.in);
				int kode ;
				//cin >> kode ;
				kode = inp.nextInt();

				if (kode == 11 ){
					int i = 0 ;
					boolean bahan1 = false ; int idx_bahan1 =  0 ;
					boolean bahan2 = false ; int idx_bahan2 =  0 ;
					while(i < inventory.size() ){
						if (inventory.get(i).getProductID() == 1 ){
							bahan1 = true ; idx_bahan1 = i ; 
						}else if (inventory.get(i).getProductID() == 3){
							bahan2 = true ; idx_bahan2 = i ; 
						}
						i ++ ;
					}
					if (bahan1 && bahan2){
						inventory.remove(inventory.get( idx_bahan1) ) ;
						inventory.remove(inventory.get( idx_bahan2-1) ) ;
						SideProduct p = new BeefRolade() ;
						inventory.add(p) ;
					}
				}
				else if ( kode == 12){
					int i = 0 ;
					boolean bahan1 = false ; int idx_bahan1 =  0 ;
					boolean bahan2 = false ; int idx_bahan2 =  0 ;
					while(i < inventory.size() ){
						if (inventory.get(i).getProductID() == 1 ){
							bahan1 = true ; idx_bahan1 = i ; 
						}else if (inventory.get(i).getProductID() == 4){
							bahan2 = true ; idx_bahan2 = i ; 
						}
						i ++ ;
					}
					if (bahan1 && bahan2){
						inventory.remove(inventory.get( idx_bahan1) ) ;
						inventory.remove(inventory.get( idx_bahan2-1) ) ;
						SideProduct p = new Butter() ;
						inventory.add(p) ;
					}
				}else if ( kode == 13){
					int i = 0 ;
					boolean bahan1 = false ; int idx_bahan1 =  0 ;
					boolean bahan2 = false ; int idx_bahan2 =  0 ;
					while(i < inventory.size() ){
						if (inventory.get(i).getProductID() == 5 ){
							bahan1 = true ; idx_bahan1 = i ; 
						}else if (inventory.get(i).getProductID() == 4){
							bahan2 = true ; idx_bahan2 = i ; 
						}
						i ++ ;
					}
					if (bahan1 && bahan2){
						inventory.remove(inventory.get( idx_bahan1) ) ;
						inventory.remove(inventory.get( idx_bahan2-1) ) ;
						SideProduct p = new Omelet() ;
						inventory.add(p) ;
					}
				}
				done = true ;
			}
		}
	}
	///Bawah
	if (!done){
		Brs_ = this.getPosBaris() + 1 ;
		Kol_ = this.getPosKolom() ;	
		if (this.getMap().IsReachable(Brs_,Kol_) ){		
			if (this.getMap().getCell(Brs_,Kol_).getIdentity() == 4 ){
				System.out.println( "11. Beef Rolade" ); //CowMeat + ChickenEgg
				System.out.println( "12. Butter" ); // ChickenEgg + Milk
				System.out.println( "13. Omelet" ); // DuckEgg + Milk
				System.out.println( "Masukkan kode sideProduct (11-13)");
				
				Scanner inp = new Scanner(System.in);
				int kode ;
				//cin >> kode ;
				kode = inp.nextInt();

				if (kode == 11 ){
					int i = 0 ;
					boolean bahan1 = false ; int idx_bahan1 =  0 ;
					boolean bahan2 = false ; int idx_bahan2 =  0 ;
					while(i < inventory.size() ){
						if (inventory.get(i).getProductID() == 1 ){
							bahan1 = true ; idx_bahan1 = i ; 
						}else if (inventory.get(i).getProductID() == 3){
							bahan2 = true ; idx_bahan2 = i ; 
						}
						i ++ ;
					}
					if (bahan1 && bahan2){
						inventory.remove(inventory.get( idx_bahan1) ) ;
						inventory.remove(inventory.get( idx_bahan2-1) ) ;
						SideProduct p = new BeefRolade() ;
						inventory.add(p) ;
					}
				}
				else if ( kode == 12){
					int i = 0 ;
					boolean bahan1 = false ; int idx_bahan1 =  0 ;
					boolean bahan2 = false ; int idx_bahan2 =  0 ;
					while(i < inventory.size() ){
						if (inventory.get(i).getProductID() == 1 ){
							bahan1 = true ; idx_bahan1 = i ; 
						}else if (inventory.get(i).getProductID() == 4){
							bahan2 = true ; idx_bahan2 = i ; 
						}
						i ++ ;
					}
					if (bahan1 && bahan2){
						inventory.remove(inventory.get( idx_bahan1) ) ;
						inventory.remove(inventory.get( idx_bahan2-1) ) ;
						SideProduct p = new Butter() ;
						inventory.add(p) ;
					}
				}else if ( kode == 13){
					int i = 0 ;
					boolean bahan1 = false ; int idx_bahan1 =  0 ;
					boolean bahan2 = false ; int idx_bahan2 =  0 ;
					while(i < inventory.size() ){
						if (inventory.get(i).getProductID() == 5 ){
							bahan1 = true ; idx_bahan1 = i ; 
						}else if (inventory.get(i).getProductID() == 4){
							bahan2 = true ; idx_bahan2 = i ; 
						}
						i ++ ;
					}
					if (bahan1 && bahan2){
						inventory.remove(inventory.get( idx_bahan1) ) ;
						inventory.remove(inventory.get( idx_bahan2-1) ) ;
						SideProduct p = new Omelet() ;
						inventory.add(p) ;
					}
				}
				done = true ;
			}
		}
	}	
}

public void interact() {
	boolean done = false ;
	int Brs_ , Kol_ ;	
	///Kiri
	if (!done){
		Brs_ = this.getPosBaris() ;
		Kol_ = this.getPosKolom() - 1 ;	
		if (this.getMap().IsReachable(Brs_,Kol_) ){		
			//Well
			if (this.getMap().getCell(Brs_,Kol_).getIdentity() == 3 ){
				water = max_water ;
				done = true ;
			}
			//Truck
			if (this.getMap().getCell(Brs_,Kol_).getIdentity() == 5 && this.getMap().getCell(Brs_,Kol_).isPossibleToInteract(0) ){
				this.getMap().getCell(Brs_,Kol_).interact(0) ;
				Scanner inp = new Scanner(System.in);
				int kode ;
				//cin >> kode ;
				kode = inp.nextInt();
				int i = 0 ;
				boolean found = false ;
				while(i < inventory.size() && !found){
					if (inventory.get(i).getProductID() == kode){
						found = true ;
					}else{
						i ++ ;
					}
					
				}
				
				if (found == true){
					money += inventory.get(i).getHarga() ;
					inventory.remove(inventory.get(i) ) ;
				}
				done = true ;
			}
			//Animal
			if (this.getMap().getCell(Brs_,Kol_).getCreation() != null){
				Creation this_ = this.getMap().getCell(Brs_,Kol_).getCreation();	
				FarmProduct p = this_.GetFarmProduct(0) ;
				inventory.add(p) ;
				this_.Action(2) ;
			}

		}
	}
	///Atas
	if (!done){
		Brs_ = this.getPosBaris() - 1 ;
		Kol_ = this.getPosKolom() ;	
		if (this.getMap().IsReachable(Brs_,Kol_) ){		
			//Well
			if (this.getMap().getCell(Brs_,Kol_).getIdentity() == 3 ){
				water = max_water ;
				done = true ;
			}
			//Truck
			if (this.getMap().getCell(Brs_,Kol_).getIdentity() == 5 && this.getMap().getCell(Brs_,Kol_).isPossibleToInteract(0) ){
this.getMap().getCell(Brs_,Kol_).interact(0) ;
				Scanner inp = new Scanner(System.in);
				int kode ;
				//cin >> kode ;
				kode = inp.nextInt();
				int i = 0 ;
				boolean found = false ;
				while(i < inventory.size() && !found){
					if (inventory.get(i).getProductID() == kode){
						found = true ;
					}else{
						i ++ ;
					}
					
				}
				
				if (found == true){
					money += inventory.get(i).getHarga() ;
					inventory.remove(inventory.get(i) ) ;
				}
				done = true ;
			}
			//Animal
			if (this.getMap().getCell(Brs_,Kol_).getCreation() != null){
				Creation this_ = this.getMap().getCell(Brs_,Kol_).getCreation();	
				FarmProduct p = this_.GetFarmProduct(0) ;
				inventory.add(p) ;
				this_.Action(2) ;
			}	
					
		}
	}
	///Kanan
	if (!done){
		Brs_ = this.getPosBaris() ;
		Kol_ = this.getPosKolom() + 1 ;	
		if (this.getMap().IsReachable(Brs_,Kol_) ){		
			//Well
			if (this.getMap().getCell(Brs_,Kol_).getIdentity() == 3 ){
				water = max_water ;
				done = true ;			
			}
			//Truck
			if (this.getMap().getCell(Brs_,Kol_).getIdentity() == 5 && this.getMap().getCell(Brs_,Kol_).isPossibleToInteract(0) ){
this.getMap().getCell(Brs_,Kol_).interact(0) ;
				Scanner inp = new Scanner(System.in);
				int kode ;
				//cin >> kode ;
				kode = inp.nextInt();
				int i = 0 ;
				boolean found = false ;
				while(i < inventory.size() && !found){
					if (inventory.get(i).getProductID() == kode){
						found = true ;
					}else{
						i ++ ;
					}
					
				}
				
				if (found == true){
					money += inventory.get(i).getHarga() ;
					inventory.remove(inventory.get(i) ) ;
				}
				done = true ;
			}
			//Animal
			if (this.getMap().getCell(Brs_,Kol_).getCreation() != null){
				Creation this_ = this.getMap().getCell(Brs_,Kol_).getCreation();	
				FarmProduct p = this_.GetFarmProduct(0) ;
				inventory.add(p) ;
				this_.Action(2) ;
			}			
		}
	}
	///Bawah
	if (!done){
		Brs_ = this.getPosBaris() + 1 ;
		Kol_ = this.getPosKolom() ;	
		if (this.getMap().IsReachable(Brs_,Kol_) ){		
			//Well
			if (this.getMap().getCell(Brs_,Kol_).getIdentity() == 3 ){
				water = max_water ;
				done = true ;
			}
			//Truck
			if (this.getMap().getCell(Brs_,Kol_).getIdentity() == 5 && this.getMap().getCell(Brs_,Kol_).isPossibleToInteract(0) ){
this.getMap().getCell(Brs_,Kol_).interact(0) ;
				Scanner inp = new Scanner(System.in);
				int kode ;
				//cin >> kode ;
				kode = inp.nextInt();
				int i = 0 ;
				boolean found = false ;
				while(i < inventory.size() && !found){
					if (inventory.get(i).getProductID() == kode){
						found = true ;
					}else{
						i ++ ;
					}
					
				}
				
				if (found == true){
					money += inventory.get(i).getHarga() ;
					inventory.remove(inventory.get(i) ) ;
				}
				done = true ;
			}
			//Animal
			if (this.getMap().getCell(Brs_,Kol_).getCreation() != null){
				Creation this_ = this.getMap().getCell(Brs_,Kol_).getCreation();	
				FarmProduct p = this_.GetFarmProduct(0) ;
				inventory.add(p) ;
				this_.Action(2) ;
			}			
		}
	}				
}	

public void Talk() {
	boolean done = false ;
	int Brs_ , Kol_ ;	
	///Kiri
	if (!done){
		Brs_ = this.getPosBaris() ;
		Kol_ = this.getPosKolom() - 1 ;	
		if (this.getMap().IsReachable(Brs_,Kol_) ){		
			if (this.getMap().getCell(Brs_,Kol_).getCreation() != null){
				this.getMap().getCell(Brs_,Kol_).getCreation().Action(0) ;
				done = true ;
			}
		}
	}
	///Atas
	if (!done){
		Brs_ = this.getPosBaris() - 1 ;
		Kol_ = this.getPosKolom() ;	
		if (this.getMap().IsReachable(Brs_,Kol_) ){		
			if (this.getMap().getCell(Brs_,Kol_).getCreation() != null){
				this.getMap().getCell(Brs_,Kol_).getCreation().Action(0) ;
				done = true ;
			}
		}
	}
	///Kanan
	if (!done){
		Brs_ = this.getPosBaris() ;
		Kol_ = this.getPosKolom() + 1 ;	
		if (this.getMap().IsReachable(Brs_,Kol_) ){		
			if (this.getMap().getCell(Brs_,Kol_).getCreation() != null){
				this.getMap().getCell(Brs_,Kol_).getCreation().Action(0) ;
				done = true ;
			}
		}
	}
	///Bawah
	if (!done){
		Brs_ = this.getPosBaris() + 1 ;
		Kol_ = this.getPosKolom() ;	
		if (this.getMap().IsReachable(Brs_,Kol_) ){		
			if (this.getMap().getCell(Brs_,Kol_).getCreation() != null ){
				this.getMap().getCell(Brs_,Kol_).getCreation().Action(0) ;
				done = true ;
			}
		}
	}		
}

public int getMoney() {
	return money ;
}
public int getWater() {
	return water ;
}
public void setMoney(int _m) {
	money = _m ;
}
public void setWater(int _w) {
	water =  _w ;
}

public String showInventory(){
	//System.out.println() ;
	String str = "| " ;
	for(int i = 0 ; i < inventory.size() ; i ++ ){
		switch(inventory.get(i).getProductID() ){
		case 1 : 
			str += "Chicken Egg | " ;
			//System.out.print( "Chicken Egg" +"\n") ;	
			break ;
		case 2 :
			str += "Chicken Meat | " ;
			//System.out.print( "Chicken Meat" +"\n") ;	
			break ;
		case 3 :
			str += "Cow Meat | " ;
			//System.out.print( "Cow Meat" +"\n") ;
			break ;
		case 4 :	
			str += "Cow Milk | " ;
			//System.out.print( "Cow Milk" +"\n") ;
			break ;
		case 5 :	
			str += "Duck Egg | " ;
			//System.out.print( "Duck Egg" +"\n") ;
			break ;
		case 6 :	
			str += "Duck Meat | " ;
			//System.out.print( "Duck Meat" +"\n") ;
			break ;
		case 11 :	
			str += "Beef Rolade | " ;
			//System.out.print( "Beef Rolade" +"\n") ;
			break ;
		case 12 :	
			str += "Butter | " ;
			//System.out.print( "Butter" +"\n") ;
			break ;			
		case 13 :	
			str += "Ommelet | " ;
			//System.out.print( "Ommelet" +"\n") ;
			break ;
		}

	}
	
	return str ;
}

public Player() {
	money = 100 ;
	water = 10 ;
	max_water = 20 ;
	
	isMeatProducing = false;
	
	//Produk awal yang dimiliki
	FarmProduct p = new ChickenEgg() ;
	FarmProduct p2 = new ChickenMeat() ;
	FarmProduct p3 = new ChickenEgg() ;
	FarmProduct p4 = new ChickenEgg() ;
	FarmProduct p5 = new CowMeat();
	
	inventory = new LinkedList<Product>();
	
	if (inventory.isEmpty() ){
		inventory.add(p) ;
		inventory.add(p2) ;
		inventory.add(p3) ;
		inventory.add(p4) ;
		inventory.add(p5) ;
		//inventory.remove( inventory.get(0) ) ;
	}
	//inventory.add(p) ;
}

public void Grow() {
	if (water > 0 ){
		this.getMap().getCell(this.getPosBaris() ,this.getPosKolom() ).interact(0) ; ;
		water -= 1 ; 
	}
}

public void Action(int n){
	//do nothing
}

}
