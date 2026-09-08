package cc.vsync.atzimjukalkulators;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	public static int askInt(String teksts, int min) {
		int r;
		
		do {
			System.out.print(teksts);
			while (!sc.hasNextInt()) {
				System.out.print(teksts);
				sc.next();
			}
			
			r = sc.nextInt();;
		} while (r < min);

		return r;
	}
	
	public static void main(String[] args) {
		int stSkaits = askInt("Ievadiet studentu skaitu: ", 1);
		
		sc.close();
	}
}
