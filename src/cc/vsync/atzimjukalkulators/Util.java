package cc.vsync.atzimjukalkulators;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
	
	public static void WriteFile(String file, String content) {
		try (BufferedWriter IO = new BufferedWriter(new FileWriter(file))) {
			IO.write(content);
		} catch (IOException e) {
			System.out.println("Kļūda kāmēr mēgināja rakstīt failā: " + e);
		}
	}
	
	public static double videjaAtzime(int[] atzimes, int[] svars) {
		double rezultats = 0;
		
		for (int i = 0; i < atzimes.length; i++) {
			rezultats += (double)(atzimes[i] * svars[i]) / 100;;
		}
		
		return rezultats;
	}

	public static void sortGrades(String[] studenti, int[][] atzimes, double[] videjasAtzimes, boolean ascending) {
		for (int i = 0; i < videjasAtzimes.length - 1; i++) {
			boolean swapped = false;

			for (int j = 0; j < videjasAtzimes.length - i - 1; j++) {
				boolean shouldSwap = ascending
						? videjasAtzimes[j] > videjasAtzimes[j + 1]
						: videjasAtzimes[j] < videjasAtzimes[j + 1];

				if (shouldSwap) {
					double tempAtzime = videjasAtzimes[j];
					videjasAtzimes[j] = videjasAtzimes[j + 1];
					videjasAtzimes[j + 1] = tempAtzime;

					String tempStudents = studenti[j];
					studenti[j] = studenti[j + 1];
					studenti[j + 1] = tempStudents;

					int[] tempAtzimes = atzimes[j];
					atzimes[j] = atzimes[j + 1];
					atzimes[j + 1] = tempAtzimes;

					swapped = true;
				}
			}

			if (!swapped) {
				break;
			}
		}
	}
}
