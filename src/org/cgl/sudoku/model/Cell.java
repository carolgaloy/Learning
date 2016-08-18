package org.cgl.sudoku.model;

public class Cell {

	private Integer value;
	private String id;
	private Subset[] containers;
	
	public Cell(String id) {
		containers = new Subset[3];
		this.id = id;
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
		
	public String toString(){
		return "The positions of cell " + id + " are " + getRow() + ", " + getColumn() + " and " + getBox();		
	}

	public Boolean valueMustBe(int value) {
		
		Boolean valueMustBe;
		
		for (Subset s : containers) {
			
			valueMustBe = s.valueMustBe(value, this);
			
			if (valueMustBe) {
				return true;
			}
			
		}
		
		return false;
	}

	public Boolean valueCanBe(int value, Subset subset) {
		
		Boolean valueCanBe;
		
		for (Subset s : containers) {
			
			if (s != subset) {
				
				valueCanBe = s.valueCanBe(value, this);
				
				if (!valueCanBe) {
					return false;
				}
			}			
		}
		
		return true;
	}

	public String getId() {
		return id;
	}
}
