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
	
	public static void main(String[] args) {
		int stSkaits = askInt("Ievadiet studentu skaitu: ", 1, 100);
		int krSkaits = askInt("Ievadiet kritēriju skaitu: ", 1, 20);
		
		String[] studenti = new String[stSkaits];
		
		for (int i = 0; i < stSkaits; i++) {
			studenti[i] = askString("Ievadiet " + (i+1) + ". studenta vārdu: ", 3, 16);
		}
		
		String[] kriterijas = new String[krSkaits];
		int[] kriterijasSvars = new int[krSkaits];
		int totalSvars = 0;
		
		for (int i = 0; i < krSkaits; i++) {
			kriterijas[i] = askString("Ievadiet " + (i+1) + ". kritēriju: ", 1, 100);
			kriterijasSvars[i] = askInt("Ievadiet '" + kriterijas[i] + "' kritērijas svaru (5-100): ", 5, 100);
			totalSvars += kriterijasSvars[i];
		}
		
		if (totalSvars != 100) {
			System.out.println("Visu kritēriju svaram kopsumma ir jābūt 100%, ne vairak, ne mazāk!");
		} else {
			// TODO: pabeigt kodu
		}
		
		sc.close();
	}
}
