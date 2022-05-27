import java.util.Random;

public class FasterFunctions {
	public static void main(String[] args) {
		float totalTime = 0;
		long startTime = System.currentTimeMillis();
		//Your Code Here
		Thread slowSorter = new Thread(()->slowSortLargeArray());
		Thread ack = new Thread(()->fixedAckermann());
		Thread millions = new Thread(()->millionsOfSqrts());
		System.out.println("Efficient code beginning");
		slowSorter.start();
		ack.start();
		millions.start();
		
		float endTime = (float)((double)System.currentTimeMillis() - (double)startTime) / 1000.0f;
		totalTime += endTime;
		System.out.println("Total Time: " + totalTime);
	}
	public static void fixedAckermann() {
		ackermann(3,14);

		System.out.println("Done with ackermann");
	}
	public static void slowSortLargeArray() {
		final int BIL = 100_000;
		int[] nums = new int[BIL];
		for(int i = 0; i < BIL; i++) {
			nums[i] = new Random().nextInt();
		}
		for(int i = 0; i < BIL - 1; i++) {
			for(int j = i + 1; j < BIL; j++){
				if(nums[i] > nums[j]) {
					int t = nums[i];
					nums[i] = nums[j];
					nums[j] = t;
				}
			}
		}
		System.out.println("Smallest Value: " + nums[0]);
		System.out.println("Largest Value: " + nums[nums.length - 1]);
	}
	
	public static long ackermann(long m, long n) {
		if(m == 0) {
			return n + 1;
		}else if(m > 0 && n == 0) {
			return ackermann(m - 1, 1);
		}else {
			return ackermann(m - 1, ackermann(m, n - 1));
		}
	}
	
	public static void millionsOfSqrts() {
		for(int i = 0; i < 400000000; i++) {
			double d = Math.sqrt(new Random().nextInt(Integer.MAX_VALUE));
		}
		System.out.println("Done with millionsOrSqrts");
	}
}
