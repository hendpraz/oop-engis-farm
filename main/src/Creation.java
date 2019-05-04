package main.src;
import main.products.*;

public abstract class Creation implements Renderable, Vision{
    //Atribut
	private int posBaris, posKolom ;
	private Map vmap;
	protected boolean isMeatProducing;

    //Method
    public void setMap(Map _m) {
	vmap = _m ;
}

	public Map getMap() {
		return vmap ;
	}

	public int getPosBaris(){
        return posBaris;
    }
	public int getPosKolom(){
        return posKolom;
    }

	public void setPosisi(int _brs,int _kol) {
	    posBaris = _brs ;
	    posKolom = _kol ;
    }

	public abstract void render() ;
		
	public abstract void GotKilled();
		
	public abstract void Action(int n);
	public boolean GetAtribute(int n){
		if(n == 1){
			return isMeatProducing;
		} else{
			return false;
		}
	}
	public FarmProduct GetFarmProduct(int i){
		return null;
	} 
}; 
