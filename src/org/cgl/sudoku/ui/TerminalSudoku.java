package org.cgl.sudoku.ui;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;
import org.cgl.sudoku.model.Board;

public class TerminalSudoku {
	
	private final static Logger logger = Logger.getLogger(TerminalSudoku.class.getName());
	
	public static void main(String[] args) throws IOException{
		
		System.out.println("start");
		// logger.info("This is an INFO message");
		// logger.severe(() -> "This is a SEVERE message");
		
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
		
		// TODO: Recibir la soluci�n y escribirla. Escribir en el stdout
		
		System.out.println("The solution is:");
		
		for (int i = 0; i < 81; i++) {
			
			if (i%9 != 8) {
				
				if (board.getCell(i).getValue() != null) {
					System.out.print(board.getCell(i).getValue()+ ",");
				} else {
					System.out.print(" ,");
				}
				
			} else {
				
				if (board.getCell(i).getValue() != null) {
					System.out.println(board.getCell(i).getValue() + "");
				} else {
					System.out.println(" ");
				}				
			}			
		}
		
		/*
		 * If the Sudoku is complete, write "Done", if not, write "Couldn't finish"
		 * and the possible values of the cells with no value.
		 */
		System.out.println();
		if (board.isComplete()) {
			System.out.println("Done");
		} else {
			System.out.println("Couldn't finish");
			System.out.println("Possible values for clear cells");
			for (int i = 0; i < 81; i++) {
				if (board.getCell(i).getValue() == null) {
					Integer j = i + 1;
					System.out.print("Cell " + j + ": ");
					System.out.println(board.getCell(i).getPossibleValues());
				}
			}
		}		
	}
	
	// TODO: Falta la validaci�n de los valores
	private Integer[] readInitialState() {
		
		Integer[] values = new Integer[81];
		Integer position = 0;
		Scanner in = new Scanner(System.in);

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
							
			}
			
		} finally {
			
			in.close();
		}
			
		return values;
	}
}
