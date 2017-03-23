import java.util.Random;

public class StorageArray {

	public int createlun(){
		Random rnd = new Random();
		int id = rnd.nextInt(10000);
		return id;
	}
	
	public boolean accessLun(int id){
		return true;
	}
	
	public int getLunSize(int id){
		int lunsize = 1;
		return lunsize;
	}
	
	public int resizeLun(int id, int size){
		int lunsize = size;
		return lunsize;
	}
		

}
