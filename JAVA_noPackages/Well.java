public class Well extends Facility {
	public void render(){
		System.out.print("W");
	}
	
	public int getIdentity(){
		return 3;
	}
	
	public void interact(int i){
		System.out.println("Air telah diisi penuh");
	}
};
