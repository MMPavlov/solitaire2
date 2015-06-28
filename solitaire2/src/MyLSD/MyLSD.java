package MyLSD;


import java.util.Arrays;
import java.util.Random;

public class MyLSD {
	
	final private static int MAX = 1000000;
	final static int R  = 256;

	private static int[] generate() {
		int[] data = new int[MAX ];

		Random random = new Random();

		for (int i = 0; i < data.length; i++) {
			data[i] = random.nextInt(Integer.MAX_VALUE); // [0 .. MAX-1]
		}

		return data;
	}
	
private  static void sort(int[] data){
		
		int N = data.length;
		int[] aux = new int[N];
		int[] count = new int[R+1]; 
		
		for (int j = 0; j < 4; j ++) {
			
		
		
			for (int i = 0; i < N; i++) {
				count[(data[i] >>> j*8 & 0xFF) + 1]++;
			}
		
			for (int r = 0; r < R; r++) {
				count[r+1] += count[r];
			}
		
			for (int i = 0; i < N; i++) {
				aux[count[data[i] >>> j*8 & 0xFF]++] = data[i];
			}
		
			for (int i = 0; i < count.length; i++) {
				data[i] = aux[i];
			}
			
			Arrays.fill(count, 0);
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		long total = 0;
		long totalOriginal = 0;
		
		long start;
		long stop;
		
		int[] data = generate();
		
		int[] data1 = data.clone();

		start = System.nanoTime();
		Arrays.sort(data);
		stop = System.nanoTime();
		totalOriginal += (stop - start);

		start = System.nanoTime();
		sort(data1);
		stop = System.nanoTime();
		
		total += (stop - start);
		
		System.out.println("total original " + totalOriginal );
		System.out.println("total LSD " + total );
		System.out.println("ratio " + (double)totalOriginal / (double)total);
	}
	


}
