package org.cgl.sudoku.model;

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
	
	public String toString(){
		return "My cells are " + cells[0].getId() + ", " + cells[1].getId() + ", " + cells[2].getId() + ", " + cells[3].getId() + ", " + cells[4].getId() + ", " + cells[5].getId() + ", " + cells[6].getId() + ", " + cells[7].getId() + ", " + cells[8].getId() + ", ";
	}

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
	public boolean valueCanBe(int value, Cell cell) {
		
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
	}
	
}
