package cc.vsync.atzimjukalkulators;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	public static int askInt(String teksts, int min, int max) {
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
	
	public static String askString(String teksts, int minLength, int maxLength) {
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
	
	static double videjaAtzime(int[] atzimes, int[] svars) {
		double rezultats = 0;
		
		for (int i = 0; i < atzimes.length; i++) {
			rezultats += (double)(atzimes[i] * svars[i]) / 100;
		}
		
		return rezultats;
	}
	
	public static void main(String[] args) {
		int stSkaits = askInt("Ievadiet studentu skaitu: ", 1, 100);
		int krSkaits = askInt("Ievadiet kritēriju skaitu: ", 1, 20);
		
		String[] studenti = new String[stSkaits];
		String[] kriterijas = new String[krSkaits];
		int[] kriterijasSvars = new int[krSkaits];
		int[][] atzimes = new int[stSkaits][krSkaits];
		int totalSvars = 0;
		
		for (int i = 0; i < stSkaits; i++) {
			studenti[i] = askString("Ievadiet " + (i+1) + ". studenta vārdu: ", 3, 16);
		}
		
		System.out.println();
		for (int i = 0; i < krSkaits; i++) {
			kriterijas[i] = askString("Ievadiet " + (i+1) + ". kritēriju: ", 1, 100);
			kriterijasSvars[i] = askInt("Ievadiet '" + kriterijas[i] + "' kritērijas svaru (5-100): ", 5, 100);
			totalSvars += kriterijasSvars[i];
		}
		
		if (totalSvars != 100) {
			System.out.println("\nVisu kritēriju svaram kopsumma ir jābūt 100%, ne vairak, ne mazāk!");
			return;
		}
		
		System.out.println();
		for (int i = 0; i < stSkaits; i++) {
			System.out.printf("Ievadiet balles (1-10) studentam %s\n", studenti[i]);
			for (int j = 0; j < krSkaits; j++) {
				atzimes[i][j] = askInt(kriterijas[j] + " balles: ", 1, 10);
			}
		}
		
		System.out.println();
		for (int i = 0; i < stSkaits; i++) {
			System.out.printf("Studenta %s vidējā atzīme: %.2f", studenti[i], videjaAtzime(atzimes[i], kriterijasSvars));
		}
		
		sc.close();
	}
}
