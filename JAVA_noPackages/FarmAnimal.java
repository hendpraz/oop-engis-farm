import java.util.concurrent.ThreadLocalRandom;

public abstract class FarmAnimal extends Creation implements Vision{
	boolean hungry ; //Jika True Maka Hewan Tersebut Lapar 
	int hungryTime ; //Akan berkurang seiring waktu , jika hungryTime = 0 maka hewan lapar
		
	boolean hasUpdated ; //True Jika Hewan telah melakukan update
		
	FarmProduct selfproduct ; //Product yang hewan miliki selain meat
    
    static int countFarmAnimal;

    public int getDurationForHungryTime(){
        return 10;
    }

    public static int getCountAnimal(){
        return countFarmAnimal;
    }

    public void render(){
        System.out.print('H');
    }

    public void setHungryTime(int h){
        hungryTime = h;
    }

    public FarmAnimal() {
        hungry = false ;
        hasUpdated = false ;
        hungryTime = 10 ; //default
        selfproduct = null ; 
        countFarmAnimal ++ ;
        isMeatProducing = true;
    }
    
    public void setMeatProducing(boolean boo){
		isMeatProducing = boo;
	}
    
    public void GotKilled() {
        countFarmAnimal -- ;
    }
    
    public boolean getHungry() {
        return hungry ;
    }
    
    public void setHungry(boolean _h) {
        hungry = _h ;
    }
    
    public boolean getHasUpdated() {
        return hasUpdated ;
    }
    
    public void setHasUpdated(boolean _b) {
        hasUpdated = _b ;
    }
            
    public int getIdentity() {
        return -1 ; //FarmAnimal Murni
    }
    
    public boolean IsMeatProducing() {
        return false ;
    }
    
    public boolean IsEggProducing() {
        return false ;
    }
    
    public boolean IsMilkProducing() {
        return false ;
    }
    
    public void emptySelfProduct() {
        this.selfproduct = null ; 
    }
    
    public FarmProduct getMeatProduct(){
        return null ;
    }
    
    public void Action(int i) {
        if (i == 0){
            this.ToSound() ;
        }else if (i == 1){
            this.Update() ;
        }else if (i == 2){
            this.emptySelfProduct() ;
        }
        else if (i == 99){
            this.setHasUpdated(false) ;
        }
        
    }
    
    public void Update(){
        //ConstraintOfAnimalHasUpdated
        if (!this.getAtribute(0) ){
            this.ProsesPencernaan();
            this.Bergerak();	
            this.setHasUpdated(true);
        }
    }	
    
    public FarmProduct GetFarmProduct(int i){
        if (i == 0){
            return selfproduct ;
        }else if (i == 1){
            return this.getMeatProduct() ;
        }
        return null ;
    }
    
    public FarmProduct createProduct() {
        return null ;
    }
    
    public void ProsesPencernaan(){
        if (!this.getAtribute(0) ){
            
            
            if (hungry){
                //Cek Cell tempat sendiri
                int Brs_ , Kol_ ;
                Brs_ = this.getPosBaris() ;
                Kol_ = this.getPosKolom() ;		
                if (this.getMap().IsReachable(Brs_,Kol_) ){
                    if (this.getMap().getCell( Brs_,Kol_).getAtribute(0) ){
                        hungry = false ;
                        hungryTime = this.getDurationForHungryTime() ;
                        selfproduct = this.createProduct() ;
                        this.getMap().getCell( Brs_,Kol_).interact(1) ; //Rumput Dimakan
                    }
                }
    
            }
                
            if (hungryTime > 0 ){
                hungryTime -- ;
                //cout << hungryTime << endl ;
                if (hungryTime == 0){
                    hungry = true ;
                }
            }else {
                hungryTime -- ;
                //cout << hungryTime << endl ;
                if (hungryTime == -5){
                    this.getMap().getCell(this.getPosBaris(),this.getPosKolom()).setCreation(null) ;	
                    this.GotKilled() ;
                }
            }		
                    
          }
    }
    
    public void Bergerak(){	
        int Brs_ , Kol_ ;
        boolean done = false ;	
        int rnd_number = rand() % 4 ;
        
        int i = 0 ;
        
        while (i < 4 && !done) {
            rnd_number = rnd_number % 4 ;
            
            ///Kiri
            if (!done && rnd_number == 0){
                Brs_ = this.getPosBaris() ;
                Kol_ = this.getPosKolom() - 1 ;		
                if (this.getMap().IsReachable(Brs_,Kol_) ){
                    Cell current_cell = this.getMap().getCell( this.getPosBaris(), this.getPosKolom()  ) ;	
                    Cell current_cell_tujuan = this.getMap().getCell( Brs_  , Kol_ ) ;	
                    ///ConstraintOfFacility
                    if (current_cell_tujuan.getIdentity() != 3 && current_cell_tujuan.getIdentity() != 4 && current_cell_tujuan.getIdentity() != 5){				
                        ///ConstraintOfCreation
                        if (current_cell_tujuan.getCreation() == null){
                            ///ConstraintOfLand 	
                            if ( (this.IsMeatProducing() && current_cell_tujuan.getIdentity() == 0)  
                                || (this.IsEggProducing() && current_cell_tujuan.getIdentity() == 1) 
                                || (this.IsMilkProducing() && current_cell_tujuan.getIdentity() == 2) 
                              )		
                              {	  	
                                  Creation this_ = current_cell.getCreation();	
    
                                      current_cell.setCreation(null) ;	
                                    current_cell_tujuan.setCreation(this_) ;			
                                    this.setPosisi(Brs_,  Kol_ ) ;
                                    //this.setHasUpdated(true) ;
                                    done = true ;
                              //	}					
                              }				
                        }
                    }
                }
            }
            ///Atas
            if (!done && rnd_number == 1){
                Brs_ = this.getPosBaris() - 1 ;
                Kol_ = this.getPosKolom() ;	
                if (this.getMap().IsReachable(Brs_,Kol_) ){		
                    Cell current_cell = this.getMap().getCell( this.getPosBaris(), this.getPosKolom()  ) ;	
                    Cell current_cell_tujuan = this.getMap().getCell( Brs_  , Kol_ ) ;	
                    ///ConstraintOfFacility
                    if (current_cell_tujuan.getIdentity() != 3 && current_cell_tujuan.getIdentity() != 4 && current_cell_tujuan.getIdentity() != 5){				
                        ///ConstraintOfCreation
                        if (current_cell_tujuan.getCreation() == null){
                            ///ConstraintOfLand 	
                            if ( (this.IsMeatProducing() && current_cell_tujuan.getIdentity() == 0)  
                                || (this.IsEggProducing() && current_cell_tujuan.getIdentity() == 1) 
                                || (this.IsMilkProducing() && current_cell_tujuan.getIdentity() == 2) 
                              )		
                              {	  	
                                  Creation this_ = current_cell.getCreation();	
                                  //ConstraintOfAnimalHasUpdated
                                  //if (!this.getAtribute(0) ){
                                      current_cell.setCreation(null) ;	
                                    current_cell_tujuan.setCreation(this_) ;			
                                    this.setPosisi(Brs_,  Kol_ ) ;
                                    //this.setHasUpdated(true) ;
                                    done = true ;
                                  //}					
                              }				
                        }
                    }
                }
            }
            ///Kanan
            if (!done && rnd_number == 2){
                Brs_ = this.getPosBaris() ;
                Kol_ = this.getPosKolom() + 1 ;	
                if (this.getMap().IsReachable(Brs_,Kol_) ){		
                    Cell current_cell = this.getMap().getCell( this.getPosBaris(), this.getPosKolom()  ) ;	
                    Cell current_cell_tujuan = this.getMap().getCell( Brs_  , Kol_ ) ;	
                    ///ConstraintOfFacility
                    if (current_cell_tujuan.getIdentity() != 3 && current_cell_tujuan.getIdentity() != 4 && current_cell_tujuan.getIdentity() != 5){				
                        ///ConstraintOfCreation
                        if (current_cell_tujuan.getCreation() == null){
                            ///ConstraintOfLand 	
                            if ( (this.IsMeatProducing() && current_cell_tujuan.getIdentity() == 0)  
                                || (this.IsEggProducing() && current_cell_tujuan.getIdentity() == 1) 
                                || (this.IsMilkProducing() && current_cell_tujuan.getIdentity() == 2) 
                              )		
                              {	  	
                                  Creation this_ = current_cell.getCreation();	
                                  //ConstraintOfAnimalHasUpdated
                                  //if (!this.getAtribute(0) ){
                                      current_cell.setCreation(null) ;	
                                    current_cell_tujuan.setCreation(this_) ;			
                                    this.setPosisi(Brs_,  Kol_ ) ;
                                    //this.setHasUpdated(true) ;
                                    done = true ;
                                  //}					
                              }				
                        }
                    }
                }
            }
            ///Bawah
            if (!done && rnd_number == 3){
                Brs_ = this.getPosBaris() + 1 ;
                Kol_ = this.getPosKolom() ;	
                if (this.getMap().IsReachable(Brs_,Kol_) ){		
                    Cell current_cell = this.getMap().getCell( this.getPosBaris(), this.getPosKolom()  ) ;	
                    Cell current_cell_tujuan = this.getMap().getCell( Brs_  , Kol_ ) ;	
                    ///ConstraintOfFacility
                    if (current_cell_tujuan.getIdentity() != 3 && current_cell_tujuan.getIdentity() != 4 && current_cell_tujuan.getIdentity() != 5){				
                        ///ConstraintOfCreation
                        if (current_cell_tujuan.getCreation()  == null){
                            ///ConstraintOfLand 	
                            if ( (this.IsMeatProducing() && current_cell_tujuan.getIdentity() == 0)  
                                || (this.IsEggProducing() && current_cell_tujuan.getIdentity() == 1) 
                                || (this.IsMilkProducing() && current_cell_tujuan.getIdentity() == 2) 
                              )		
                              {	  	
                                  Creation this_ = current_cell.getCreation();	
                                  //ConstraintOfAnimalHasUpdated
                                  //if (!this.getAtribute(0) ){
                                      current_cell.setCreation(null) ;	
                                    current_cell_tujuan.setCreation(this_) ;			
                                    this.setPosisi(Brs_,  Kol_ ) ;
                                    //this.setHasUpdated(true) ;
                                    done = true ;
                                  //}					
                              }				
                        }
                    }
                }
            }
            
            rnd_number ++ ;
            i ++ ;
        }
        
                
    
    }
    
    public void ToSound(){  
    }
    
    public boolean getAtribute(int i) {
        if (i == 0){
            return hasUpdated ;
        }else if (i == 1){
            return this.IsMeatProducing() ;
        }
        
        return false ;
    }

	public int rand(){
		int min = 0;
		int max = 10;
		int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		
		return randomNum;
	}
}
