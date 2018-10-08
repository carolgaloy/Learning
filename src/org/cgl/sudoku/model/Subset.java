package org.cgl.sudoku.model;

import java.util.HashSet;
import java.util.Set;

public abstract class Subset {
	
	protected Cell[] cells;
	protected String id;
	
	public Subset(Integer size) {		
		cells = new Cell[size];		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Cell[] getCells() {
		return cells;
	}
	
	public String toString(){
		return "My cells are " + cells[0].getId() + ", " + cells[1].getId() + ", " + cells[2].getId() + ", " + cells[3].getId() + ", " + cells[4].getId() + ", " + cells[5].getId() + ", " + cells[6].getId() + ", " + cells[7].getId() + ", " + cells[8].getId() + ", ";
	}

	/*
	 * Checks if the value can be in any cell of the subset. 
	 * If true, then it can't be assigned in the cell.
	 */
	public boolean valueMustBe(int value, Cell cell) {
		
		Boolean valueCanBe;
		
		for (Cell c : cells) {
			
			if (c != cell) {
				
				if (c.getValue() != null) {

					if (c.getValue() == value) {
						return false;
					}
					
				} else {
					
					valueCanBe = c.valueCanBe(value, this);
					
					if (valueCanBe) {
						return false;
					}					
				}
			}			
		}		
		return true;		
	}

	/*
	 * Checks if the value is already in any of the cells of the subset. 
	 */
/*	public boolean valueCanBe(int value, Cell cell) {
		
		for (Cell c : cells) {
			
			if (c != cell) {
				
				if (c.getValue() != null) {
					if (c.getValue() == value) {
						return false;
					}				
				}
			}			
		}		
		return true;
	}*/

	/*
	 * Returns the cells that have no value.
	 */
	public Set<Cell> cellsWithNoValue() {

		Set<Cell> cellsWithNoValue = new HashSet<Cell>();
		
		for (Cell cell : cells) {
			
			if (cell.getValue() == null) {					
				cellsWithNoValue.add(cell);
			}
		}
		return cellsWithNoValue;
	}	
}
