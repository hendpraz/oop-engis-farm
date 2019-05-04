package facilities;

public class Well extends Facility {
	public char render(){
		return 'W' ; //System.out.print("W");
	}
	
	public int getIdentity(){
		return 3;
	}
	
	public void interact(int i){
		System.out.println("Air telah diisi penuh");
	}
};
