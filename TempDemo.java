import java.io.*;

public class TempDemo {
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		
		TempRun obj = new TempRun();

		obj.runTemp();		
		System.out.println();
		obj.runAQI();
		
		System.out.println("\n[Using Time] : " + (System.currentTimeMillis() - startTime) / 1000 + "s");
	}// MAIN
}// END

