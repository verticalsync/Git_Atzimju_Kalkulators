package cc.vsync.atzimjukalkulators;

import java.util.Scanner;

public class Util {
	public static int askInt(Scanner sc, String teksts, int min, int max) {
		int r;
		
		do {
			System.out.print(teksts);
			while (!sc.hasNextInt()) {
				System.out.print(teksts);
				sc.next();
			}
			
			r = sc.nextInt();;
		} while (r < min || r > max);

		return r;
	}
	
	public static String askString(Scanner sc, String teksts, int minLength, int maxLength) {
		String r;
		
		do {
			System.out.print(teksts);
			while (!sc.hasNextLine()) {
				System.out.print(teksts);
				sc.next();
			}
			
			r = sc.next().split("\n")[0];
		} while (r.length() < minLength || r.length() > maxLength);
		
		return r;
	}
	
	public static double videjaAtzime(int[] atzimes, int[] svars) {
		double rezultats = 0;
		
		for (int i = 0; i < atzimes.length; i++) {
			rezultats += (double)(atzimes[i] * svars[i]) / 100;
		}
		
		return rezultats;
	}
}
