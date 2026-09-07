package cc.vsync.atzimjukalkulators;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int stSkaits;
		System.out.print("Ievadiet studentu skaitu: ");
		while (!sc.hasNextInt()) {
			System.out.print("Ievadiet studentu skaitu: ");
			sc.next();
		}

		stSkaits = sc.nextInt();
		
		
		sc.close();
	}
}
