import java.io.FileInputStream;

public class Editdistace {

	public static void main(String[] args) {

		try {

			System.setIn(new FileInputStream("resources/" + args[0]));

		} catch (Exception e) {

			System.err.printf("Exception caught: %s\n", e.toString());

			System.exit(0);

		}

		String x = StdIn.readLine();

		String y = StdIn.readLine();

		printEditDistance(x, y);
	}

	/**
	 * 
	 * @param x
	 *            a non-null String
	 * 
	 * @param y
	 *            a non-null String
	 * 
	 * 
	 * 
	 *            Prints out the edit distance between x and y and the time taken to
	 *            compute it
	 * 
	 */

	public static void timeRecursiveEditDistance(String x, String y) {
		Stopwatch sw1 = new Stopwatch(); // makes timer
		int length1 = recursiveEditDistance(x, y, 0, 0);
		double time1 = sw1.elapsedTime();
		StdOut.printf("Recursive EditDistance length = %d; time = %.3f\n", length1, time1);// prints time

	}

	/**
	 * 
	 * @param x
	 *            a non-null String
	 * 
	 * @param y
	 *            a non-null String
	 * 
	 * 
	 * 
	 *            Prints out the edit distance between x and y and the time taken to
	 *            compute it using the dynamic programming version editDistance
	 * 
	 */

	public static void timeEditDistance(String x, String y) {
		Stopwatch sw = new Stopwatch(); // makes timer
		int length = EditDistance(x, y);
		double time = sw.elapsedTime();
		StdOut.printf("EditDistance length = %d; time = %.3f\n", length, time);// prints time 
	
	}

	/**
	 * 
	 * @param dnaLength
	 *            a non-negative integer
	 * 
	 * @return a random String of length dnaLength comprised of the four chars A, T,
	 *         G, and C
	 * 
	 * 
	 * 		makes a string with A, T, C, G randomly 
	 */

	public static String randomDNAString(int dnaLength) {
		String DNA = "";
		for (int i = 0; i <= dnaLength; i++) { // start for
			int r = (int) ((Math.random() * 4) + 1); // creates an equal chance to get a letter
			if (r == 1)
				DNA += "A"; //what happens when the chance = 1
			if (r == 2)
				DNA += "T";//what happens when the chance = 2
			if (r == 3)
				DNA += "C";//what happens when the chance = 3
			if (r == 4)
				DNA += "G";//what happens when the chance = 4
		} // end for
		return DNA;
	}

	/**
	 * Computes the length of a Longest Common Subsequence (LCS) of suffixes of x
	 * and y starting at positions i and j
	 * 
	 * @param x
	 * @param y
	 * @param i
	 * @param j
	 * @return the LCS length
	 * 
	 * 		this method uses recursive to make an error counter
	 * 
	 */
	
	
	private static int recursiveEditDistance(String x, String y, int i, int j) {
		if (i == x.length() && j == y.length()) {
			return 0;
		} else if (i == x.length() || j == y.length()) {
			if (x.length() < y.length()) {
				return 2 * x.length();
			} else {
				return 2 * y.length();
			}
		} else {
			// To make some progress toward the base, we need to shorten
			// at least one of the suffixes, moving i and/or j toward the end.
			int option1 = recursiveEditDistance(x, y, i + 1, j); // skip x[i]
			int option2 = recursiveEditDistance(x, y, i, j + 1); // skip y[j]
			int option3 = recursiveEditDistance(x, y, i + 1, j + 1); // skip both?
			if (x.charAt(i) != y.charAt(j)) {
				option3 += 1; // 1 character in common
			}
			// The *longest* common subsequence is the maximum of the options.
			return Math.min(option1 + 2, Math.min(option2 + 2, option3));
		}

	}

	/**
	 * Produces table of the LCS lengths for all suffixes of x and y
	 * 
	 * @param x
	 * @param y
	 * @return table with position [i][j] being for suffixes starting at i and j
	 * 
	 * 
	 *            This procedure should use dynamic programming to make table to show where the 
	 *            errors are counted. 
	 */
	private static int[][] optTable(String x, String y) {
		int[][] opt = new int[x.length() + 1][y.length() + 1];
		for (int i = x.length(); i >= 0; i--) {// starts i for loop
			for (int j = y.length(); j >= 0; j--) {// starts j for loop
				if (i == x.length() && j == y.length()) {
					opt[i][j] = 0;
				} else if (i == x.length() || j == y.length()) {
					if (x.length() < y.length()) {
						opt[i][j] = 2 * x.length();
					} else {
						opt[i][j] = 2 * y.length();
					}
				} else {
					// To make some progress toward the base, we need to shorten
					// at least one of the suffixes, moving i and/or j toward the end.
					int option1 = opt[i + 1][j] + 2; // skip x[i]
					int option2 = opt[i][j + 1] + 2; // skip y[j]
					int option3 = opt[i + 1][j + 1]; // skip both?
					if (x.charAt(i) != y.charAt(j)) {
						option3 += 1; // 1 character in common
					}
					opt[i][j] = Math.min(option2, Math.min(option1, option3)); 
				} // end else
			} // end j for loop
		} // end i for loop
		return opt;
	}// end method

	/**
	 * Computes the length of a Longest Common Subsequence (LCS) of x and y
	 * 
	 * @param x
	 * @param y
	 * @return the error amount
	 * 
	 * this method sends x and y to a new method and then returns the value from that 
	 * method
	 * 
	 */
	private static int EditDistance(String x, String y) {
		int opt[][] = optTable(x, y); // sends x and y then stores value into opt [][]
		return opt[0][0];
	}

	/**
	 * 
	 * @param x
	 *            a non-null String
	 * 
	 * @param y
	 *            a non-null String
	 * 
	 * 
	 * 
	 *            This procedure should use dynamic programming to print a table to show where the 
	 *            errors are counted.
	 */

	private static void printEditDistance(String x, String y) {
		int opt[][] = optTable(x, y);

		StringBuilder sbX = new StringBuilder(); // makes a String Builder
		StringBuilder sbY = new StringBuilder();
		int i = 0;
		int j = 0;
		while (i != x.length() && j != y.length()) {
			// To make some progress toward the base, we need to shorten
			// at least one of the suffixes, moving i and/or j toward the end.
			int option1 = opt[i + 1][j]; // skip x[i]
			int option2 = opt[i][j + 1]; // skip y[j]
			if (opt[i][j] == option2 + 2) {
				sbX.append("-");
				sbY.append(y.charAt(j));
				System.out.println("-" + " " + y.charAt(j) + " 2");// print with a 2 counter
				j++;
			} else if (opt[i][j] == option1 + 2) {
				sbY.append("-");
				sbX.append(y.charAt(i));
				System.out.println(x.charAt(i) + " " + "-" + " 2");// print with a 2 counter
				i++;
			} else {
				if (x.charAt(i) == y.charAt(j)) {
					System.out.println(x.charAt(i) + " " + y.charAt(j) + " 0"); // print with no counter
				} else {
					System.out.println(x.charAt(i) + " " + y.charAt(j) + " 1");// print with 1 counter 
				}
				sbX.append(x.charAt(i)); // adds a character to x 
				sbY.append(y.charAt(j));// adds a character to y
				i++;
				j++;

			}

		}
	}

}
