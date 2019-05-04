package main.facilities;

import java.util.*;

public class Mixer extends Facility{
	private List<String> resepList;
	
	public void render() {
		System.out.print( "M" );
	}

	public int getIdentity() {
		return 4 ;
	}

	public void interact(int i){
		System.out.println( "Masukkan command 'Mix' untuk menggunakan Mixer" );
	}

	public void mix(){
		showListOfSideProduct();
	}

	public void showListOfSideProduct(){
		for(String str : resepList){
			System.out.println( str ); 
		}
	}
	
	public Mixer(){
		ArrayList<String> resepList = new ArrayList<String>();
		resepList.add("11. Beef Rolade"); //CowMeat + ChickenEgg
		resepList.add("12. Butter"); // ChickenEgg + CowMilk
		resepList.add("13. Omelet"); // DuckEgg + CowMilk
	}
}