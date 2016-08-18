package org.cgl.sudoku.model;

import java.util.logging.Logger;

import org.cgl.sudoku.ui.TerminalSudoku;

public class Board {
	
	private Subset[] subsets;
	private Cell[] cells;
	private final static Logger logger = Logger.getLogger(TerminalSudoku.class.getName());
		
	public Board(Integer[] initialState) {
		
		cells = new Cell[81];
		
		for (int i = 0; i < 81; i++) {
			cells[i] = new Cell(""+i);
			//cells[i].setValue(i);
		}
		
		subsets = new Subset[27];
				
		for (int i = 0; i < 9; i++) {
			subsets[i] = new Row(9, i, this);
			logger.finest("Row " + (i+1) + " created");
			subsets[i+9] = new Column(9, i, this);
			logger.finest("Column " + (i+1) + " created");
			subsets[i+9*2] = new Box(9, i, this);
			logger.finest("Box " + (i+1) + " created");
		}		
		
		// para comprobar que las posiciones son las correctas
		for (int i = 0; i < 81; i++){
			logger.finest(cells[i].toString());
		}
		
		for (int i = 0; i < 81; i++){		
			cells[i].setValue(initialState[i]);
		}
		
		System.out.println("The initial state is:");
		// para comprobar que los valores se han asignado correctamente
		for (int i = 0; i < 81; i++) {
			
			if (i%9 != 8) {
				System.out.print(cells[i].getValue() + ",");
			} else {
				System.out.print(cells[i].getValue());
				System.out.println();
			}			
		}
		System.out.println();
		
		for (int i = 0; i < 27; i++){
			logger.finest("I am " + subsets[i].getId() + " and " + subsets[i].toString());
		}
	}
	

	public Cell getCell(int id) {
		return cells[id];
	}


	public Integer[] solve() {
		
		Boolean cellHasChanged;
		
		do {
			
			cellHasChanged = false;
			
			for (Cell c : cells) {
				
				if (c.getValue() == null) {
					
					for (int j = 1; j < 10; j++) {
						
						Boolean valueMustBe = c.valueMustBe(j);
						
						if (valueMustBe) {
							c.setValue(j);
							cellHasChanged = true;
							break;
						}						
					}					
				}				
			}			
		} while (cellHasChanged == true);
		
		return null;
	}
	
	public Boolean isComplete() {
		
		for (int i = 0; i < 81; i++) {
			if (cells[i].getValue() == null) {
				return false;
			}
		}
		return true;
	}
}
