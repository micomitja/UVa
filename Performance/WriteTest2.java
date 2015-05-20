// For more information on this performance test, see
// http://www.redgreencode.com/why-is-java-io-slow
import java.io.*;
import java.util.*;

public class WriteTest2
{
	static final Random _random = new Random(211166910);
	static final int numLines = 1000000;
	static final int numChars = 100;
	static long total = 0;


	private static void PrintLines() {
		try {
			BufferedWriter stdout = new BufferedWriter(new OutputStreamWriter(System.out));

			for (int i=0; i<numLines; i++) {
				for (int j=0; j<numChars-2; j++) {
					int ch = _random.nextInt(95)+32;
					stdout.write((char)ch);
					total += ch;
				}
				stdout.newLine();
			}
			stdout.flush();
			stdout.close();
		} catch (IOException ioe) { System.err.println("Error"); }
	}

	public static void main(String args[])
	{
		long startTime = System.nanoTime();
		PrintLines();
		long stopTime = System.nanoTime();
		System.err.println(stopTime - startTime);
		System.err.println("t" + total);
	}
}
