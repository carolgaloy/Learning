package org.cgl.sudoku.ui;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

import org.cgl.sudoku.model.*;

public class TerminalSudoku {
	
	private final static Logger logger = Logger.getLogger(TerminalSudoku.class.getName());
	
	public static void main(String[] args) throws IOException{
		
		System.out.println("start");
		// logger.info("This is an INFO message");
		// logger.severe(() -> "This is a SEVERE message");
		// TODO: Leer los datos de inizialización de un sudoku completo. Leer del stdin. Leer líneas del stdin.
		// Crear un archivo sudoku1.txt, buscar un sudoku fácil y copiarlo. 
		
		TerminalSudoku terminalSudoku = new TerminalSudoku();
		
		Integer[] initialState = terminalSudoku.readInitialState();
		
		for (int i = 0; i < 81; i++) {
			
			if (i%9 != 8) {
				logger.finest(initialState[i] + ",");
			} else {
				logger.finest(initialState[i] + "");
				logger.finest("");
			}
			
		}

		Board board = new Board(initialState);	
		
		board.solve();
		
		// TODO: Pasar los datos al programa que lo resuelve
		
		// TODO: Recibir la solución y escribirla. Escribir en el stdout
		
		System.out.println("The solution is:");
		
		for (int i = 0; i < 81; i++) {
			
			if (i%9 != 8) {
				System.out.print(board.getCell(i).getValue()+ ",");
			} else {
				System.out.print(board.getCell(i).getValue() + "");
				System.out.println();
			}
			
		}
		
		System.out.println("done");
	}
	
	// Falta la validación de los valores
	private Integer[] readInitialState() {
		
		Integer[] values = new Integer[81];
		Integer position = 0;
		Scanner in = new Scanner(System.in);
		
		System.out.println("The file contains:");

		try {
			
			while (in.hasNextLine()) {
				
				String strLine = in.nextLine();
				
				if (strLine.isEmpty()) {
					break;
				}
				
				String[] strSplit = strLine.split(",");
				
				for (int i = 0; i < 9; i++) {					
					String currentString = strSplit[i];
					
					if (!currentString.equals(" ")) {
						try {
							values[position] = Integer.parseInt(currentString);
						} catch (NumberFormatException e) {
							// TODO Log de las variables (strLine, i, position, etc.)
							e.printStackTrace();
						}
					}
					position++;
				}
				
				System.out.println(strLine);				
			}
			
			System.out.println();
			
		} finally {
			
			in.close();
		}
			
		return values;
	}
	
	// metodo read initial state --> devuelve un vector
	// se pasa a un solver del board --> que devuelve otro vector
	// pasarlo al stdoutput
	
	// modificar el run configuration para que sepa de dónde tiene que leer
}
