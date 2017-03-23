import static org.junit.Assert.*;
import java.util.Random;

import org.junit.Test;


public class CreateLunsTests {

	@Test
	public void testCreateOneLun() {
		try{
			// Step1: connect Storage array
			StorageArray sa = new StorageArray();
			// Create one Lun, test if it succeeds
			int lunid = sa.createlun();
			assert(lunid>0);
			// Check if it can be accessed
			boolean ret = sa.accessLun(lunid);
			assertTrue(ret);
		}catch(Exception e){
			fail("create luns failed");
		}
		
	}
	
	@Test
	public void testCreateMultipleLun() {
		int[] lunIds;
		
		try{
			// Step1: connect Storage array
			StorageArray sa = new StorageArray();
			
			// Step2: generate a number for luns creation
			int max_num_luns = 256;
			Random rnd = new Random();
			int nums = 1 + rnd.nextInt(256);
			lunIds = new int[nums];
			
			for (int iloop = 1; iloop <= nums; iloop++ ){
				// Create one Lun, test if it succeeds
				int lunid = sa.createlun();
				assert(lunid>0);
				lunIds[iloop] = lunid;
			}
			
			for (int iloop = 1; iloop <= nums; iloop++ ){
				// Check if it can be accessed
				boolean ret = sa.accessLun(lunIds[iloop]);
				assertTrue(ret);
			}
			
		}catch(Exception e){
			fail("create multiple luns failed");
		}
		
	}

}
