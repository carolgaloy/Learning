package org.cgl.sudoku.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.cgl.sudoku.model.*;

public class TerminalSudoku {
	
	public static void main(String[] args) throws IOException{
		
		System.out.println("start");
		
		// TODO: Leer los datos de inizialización de un sudoku completo. Leer del stdin. Leer líneas del stdin.
		// Crear un archivo sudoku1.txt, buscar un sudoku fácil y copiarlo. 
		
		TerminalSudoku terminalSudoku = new TerminalSudoku();
		
		Integer[] initialState = terminalSudoku.readInitialState();

		Board board = new Board(initialState);
		
		
		
		// TODO: Pasar los datos al programa que lo resuelve
		
		// TODO: Recibir la solución y escribirla. Escribir en el stdout
		
		System.out.println("done");

	}

	private Integer[] readInitialState() {
		
		Integer[] values = new Integer[81];
		Scanner in = new Scanner(System.in);
		Integer count = 0;

		while(in.hasNextLine()) {
			
			String strLine = in.nextLine();
			String[] strSplit = strLine.split(",");
			
			if (strLine.isEmpty()) {
				break;
			}
			
			for (int i = 0; i < 9; i++) {				
				if (!strSplit[i].equals(" ")){
					values[i + count] = Integer.parseInt(strSplit[i]);
				}								
			}
			
			System.out.println(strLine);
			count = count + 9;
			
		}
		return values;
	}
	
	// metodo read initial state --> devuelve un vector
	// se pasa a un solver del board --> que devuelve otro vector
	// pasarlo al stdoutput
	
	// modificar el run configuration para que sepa de dónde tiene que leer
}
