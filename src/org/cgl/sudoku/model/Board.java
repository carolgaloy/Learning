package org.cgl.sudoku.model;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import org.cgl.sudoku.ui.TerminalSudoku;

public class Board {
	
	private Subset[] subsets;
	private Cell[] cells;
	private final static Logger logger = Logger.getLogger(TerminalSudoku.class.getName());
		
	public Board(Integer[] initialState) {
		
		cells = new Cell[81];
		
		for (int i = 0; i < 81; i++) {
			cells[i] = new Cell(i);
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
		
		// Checks if the positions are correct.
		for (int i = 0; i < 81; i++){
			logger.finest(cells[i].toString());
		}
		
		for (int i = 0; i < 81; i++){		
			cells[i].setValue(initialState[i]);
			if (cells[i].getValue() != null) {
				cells[i].getPossibleValues().clear();
				cells[i].removePossiblesFromSubsets(initialState[i]);
			}
		}
		
		System.out.println("The initial state is:");
		// Checks if the values have been assigned correctly.
		for (int i = 0; i < 81; i++) {
			
			if (i%9 != 8) {
				
				if (cells[i].getValue() != null) {
					System.out.print(cells[i].getValue() + ",");
				} else {
					System.out.print(" ,");
				}
				
			} else {
				
				if (cells[i].getValue() != null) {
					System.out.println(cells[i].getValue());
				} else {
					System.out.println(" ");
				}
				
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
			
			for (Cell cell : cells) {
				
				if (cell.getValue() == null) {
					
					if (cell.getPossibleValues().size() == 1) {
						Integer value = cell.getPossibleValues().iterator().next();
						cell.setValue(value);
						cell.removePossiblesFromSubsets(value);
						cell.getPossibleValues().clear();
						cellHasChanged = true;
					}
					
					for (Integer value : cell.getPossibleValues()) {						
						Boolean valueMustBe = cell.valueMustBe(value);
						
						if (valueMustBe) {
							Boolean checkValue = cell.checkValue(value);
							
							if (checkValue) {
								
								cell.setValue(value);
								cell.removePossiblesFromSubsets(value);
								cell.getPossibleValues().clear();
								cellHasChanged = true;
								break;
								
							}
						}						
					}					
				}				
			}
			
			reducePossibles();
			//checkUniques();

		} while (cellHasChanged == true);

		return null;
	}
	
	/*
	 * For each subset, check how many cells have with no value. If there are more than 2,
	 * then check if there are two of them that contain exactly 2 equal values in their 
	 * possible values. Then, remove this values from the possibles' other cells in the 
	 * same subset.
	 */
	public void reducePossibles() {
		
		for (Subset subset : subsets) {
			
			Set<Cell> cellsWithNoValue = subset.cellsWithNoValue(); 
			
			if (cellsWithNoValue.size() > 2) {
				
				for (int i = 0; i < 8; i++) {
					
					if (subset.cells[i].getValue() == null) {
						
						for (int j = i+1; j < 9; j++) {
							
							Boolean possiblesAreEqual = false;
							
							if (subset.cells[i].getPossibleValues().size() == 2) {								
								possiblesAreEqual = subset.cells[i].comparePossibles(subset.cells[j]);								
							}
							
							if (possiblesAreEqual) {
								
								for (Cell cell : cellsWithNoValue) {
									
									if (cell != subset.cells[i] && cell != subset.cells[j]) {
										
										for (Integer value : subset.cells[i].getPossibleValues()) {
											
											cell.getPossibleValues().remove(value);
										}										
									}									
								}
							}
						}
					}
				}
			}
		}
	}
	
	public void checkUniques() {
		for (Subset subset : subsets) {
			for (Cell cell : subset.cells) {
				if (cell.getValue() == null) {
					Boolean isUnique = false;
					for (Integer value : cell.getPossibleValues()) {
						
						for (Cell otherCell : subset.cells) {
							if (otherCell != cell) {
								isUnique = otherCell.getPossibleValues().contains(value);
							}
							if (isUnique) {
								cell.setValue(value);
								cell.getPossibleValues().clear();
							}
						}
					}
				}
			}
		}
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
