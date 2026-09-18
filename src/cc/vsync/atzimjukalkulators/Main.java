package cc.vsync.atzimjukalkulators;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		do{
			System.out.println("Izvele:");
			System.out.println("1 - Ievadit studentus");
			System.out.println("2 - Ievadīt kriterijus");
			System.out.println("3 - Ievadīt studentu atzīmes un redzēt vidējo");
			System.out.println("4 - Beigt");
			int izvele = Util.askInt(sc, "-> ", 1, 4);
			switch (izvele) {
				case 1:

			}
		}while (izvele != 4);

		int stSkaits = Util.askInt(sc, "Ievadiet studentu skaitu: ", 1, 100);
		int krSkaits = Util.askInt(sc, "Ievadiet kritēriju skaitu: ", 1, 20);
		
		String[] studenti = new String[stSkaits];
		String[] kriterijas = new String[krSkaits];
		int[] kriterijasSvars = new int[krSkaits];
		int[][] atzimes = new int[stSkaits][krSkaits];
		int totalSvars = 0;
		
		for (int i = 0; i < stSkaits; i++) {
			studenti[i] = Util.askString(sc, "Ievadiet " + (i+1) + ". studenta vārdu: ", 3, 16);
		}
		
		System.out.println();
		for (int i = 0; i < krSkaits; i++) {
			kriterijas[i] = Util.askString(sc, "Ievadiet " + (i+1) + ". kritēriju: ", 1, 100);
			kriterijasSvars[i] = Util.askInt(sc, "Ievadiet '" + kriterijas[i] + "' kritērijas svaru (5-100): ", 5, 100);
			totalSvars += kriterijasSvars[i];
		}
		
		if (totalSvars != 100) {
			System.out.println("\nVisu kritēriju svaru kopsummai ir jābūt 100%, ne vairāk, ne mazāk!");
			return;
		}
		
		System.out.println();
		for (int i = 0; i < stSkaits; i++) {
			System.out.printf("Ievadiet balles (1-10) studentam %s\n", studenti[i]);
			for (int j = 0; j < krSkaits; j++) {
				atzimes[i][j] = Util.askInt(sc, kriterijas[j] + " balles: ", 1, 10);
			}
		}
		
		System.out.println();
		for (int i = 0; i < stSkaits; i++) {
			System.out.printf("Studenta %s vidējā atzīme: %.2f", studenti[i], Util.videjaAtzime(atzimes[i], kriterijasSvars));
		}
		
		sc.close();
	}
}
