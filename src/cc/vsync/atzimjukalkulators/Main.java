package cc.vsync.atzimjukalkulators;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static String[] studenti;
	static String[] kriterijas;
	static int[] kriterijasSvars;
	static int[][] atzimes;
	static int totalSvars = 0;
	
	public static void inputStudents() {
		int stSkaits = Util.askInt(sc, "Ievadiet studentu skaitu: ", 1, 100);
		studenti = new String[stSkaits];
		
		for (int i = 0; i < stSkaits; i++) {
			studenti[i] = Util.askString(sc, "Ievadiet " + (i+1) + ". studenta vārdu: ", 3, 16);
		}
	}
	
	public static void inputCriteria() {
		int krSkaits = Util.askInt(sc, "Ievadiet kritēriju skaitu: ", 1, 20);
		kriterijas = new String[krSkaits];
		kriterijasSvars = new int[krSkaits];
		totalSvars = 0;
		
		for (int i = 0; i < krSkaits; i++) {
			kriterijas[i] = Util.askString(sc, "Ievadiet " + (i+1) + ". kritēriju: ", 1, 100);
			kriterijasSvars[i] = Util.askInt(sc, "Ievadiet '" + kriterijas[i] + "' kritērijas svaru (5-100): ", 5, 100);
			totalSvars += kriterijasSvars[i];
		}
		
		if (totalSvars != 100) {
			System.out.println("\nVisu kritēriju svaru kopsummai ir jābūt 100%, ne vairāk, ne mazāk!\nAtkārtoti ierakstiet kritērijas!\n");
			inputCriteria();
			return;
		}
	}
	
	public static void calculateGrades() {
		if (studenti == null || kriterijas == null) {
			System.out.println("Jums ir vispirms jaievada studenti, un tad kriterijas.");
			return;
		}
		
		atzimes = new int[studenti.length][kriterijas.length];
		
		for (int i = 0; i < studenti.length; i++) {
			System.out.printf("Ievadiet balles (1-10) studentam %s\n", studenti[i]);
			for (int j = 0; j < kriterijas.length; j++) {
				atzimes[i][j] = Util.askInt(sc, kriterijas[j] + " balles: ", 1, 10);
			}
		}
		
		System.out.println();
		for (int i = 0; i < studenti.length; i++) {
			System.out.printf("Studenta %s vidējā atzīme: %.2f\n", studenti[i], Util.videjaAtzime(atzimes[i], kriterijasSvars));
		}
	}
	
	public static void main(String[] args) {
		int izvele = 0;
		
		do {
			System.out.println("Izvele:");
			System.out.println("1 - Ievadit studentus");
			System.out.println("2 - Ievadīt kriterijus");
			System.out.println("3 - Ievadīt studentu atzīmes un redzēt vidējo");
			System.out.println("4 - Beigt");
			
			izvele = Util.askInt(sc, "-> ", 1, 4);
			
			switch (izvele) {
				case 1: inputStudents(); break;
				case 2: inputCriteria(); break;
				case 3: calculateGrades(); break;
				default: break;
			}
			
			System.out.println();
		} while (izvele != 4);
		
		sc.close();
	}
}
