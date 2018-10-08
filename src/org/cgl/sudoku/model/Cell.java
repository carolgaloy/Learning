package org.cgl.sudoku.model;

import java.util.HashSet;
import java.util.Set;

public class Cell {

	private Integer value;
	private int id;
	private Subset[] containers;
	private Set<Integer> possibleValues;
	
	public Cell(int id) {
		containers = new Subset[3];
		this.id = id;
		possibleValues = new HashSet<Integer>();
		
		for (int i = 1; i < 10; i++) {
			possibleValues.add(i);
		}
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Subset[] getPosition() {
		return containers;
	}

	public void setRow(Subset pos0) {
		containers[0] = pos0;
	}
	
	public void setColumn(Subset pos1) {
		containers[1] = pos1;
	}
	
	public void setBox(Subset pos2) {
		containers[2] = pos2;
	}
	
	public String getRow() {
		return containers[0].getId();
	}
	
	public String getColumn() {
		return containers[1].getId();
	}
	
	public String getBox() {
		return containers[2].getId();
	}
	
	public HashSet<Integer> getPossibleValues() {
		return (HashSet<Integer>) possibleValues;
	}

	public void setPossibleValues(HashSet<Integer> possibleValues) {
		this.possibleValues = possibleValues;
	}
		
	public String toString(){
		return "The positions of cell " + id + " are " + getRow() + ", " + getColumn() + " and " + getBox();		
	}

	/*
	 * Checks if the cell must have the value. 
	 */
	public boolean valueMustBe(int value) {
		
		Boolean valueMustBe;
		
		for (Subset s : containers) {
			
			valueMustBe = s.valueMustBe(value, this);
			
			if (valueMustBe) {
				return true;
			}			
		}		
		return false;
	}

	/*
	 * Checks if the value can be in the cell. If it can be in the cell,
	 * then it is a possible value of the subset.
	 */
	public boolean valueCanBe(int value, Subset subset) {

		//Boolean valueCanBe;

		if (this.possibleValues.contains(value)) {
			return true;
		}
		
		/*for (Subset s : containers) {

			if (s != subset) {

				valueCanBe = s.valueCanBe(value, this);

				if (!valueCanBe) {
					return false;
				}
			}			
		}*/
		return false;
	}

	/* Checks if the value is correct by checking
	 * each cell of each subset (row, column and box).
	 * Returns true if the value is not in any sister cell.
	 */
	public boolean checkValue (int value) {
		
		for (Subset s : containers) {
			
			for (Cell c : s.cells) {
				
				if (c.getValue() != null) {
					
					if (c.getValue() == value) {						
						return false;
					}
				}
			}
		}		
		return true;
	}

	public int getId() {
		return id;
	}
	
	public void removePossiblesFromSubsets (int value) {
		
		for (Subset s : containers) {
			
			for (Cell c : s.cells) {
				
				c.possibleValues.remove(value);
			}			
		}
	}
	
	public Boolean comparePossibles(Cell cell) {
		
		if (this.possibleValues.equals(cell.possibleValues)) {
			return true;
		}
		
		return false;		
	}
}
