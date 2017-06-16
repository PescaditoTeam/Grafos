package generadores;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		Scanner sc;
		try {
			sc = new Scanner(new File("Grafo.txt"));
			MatrizSimetrica mat = new MatrizSimetrica(9);
			int fila, columna;
			for (int i = 0; i < 7; i++) {
				fila = sc.nextInt();
				columna = sc.nextInt();
				mat.setValor(fila, columna);
			}
			System.out.println(mat.getValor(1, 6));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
}
