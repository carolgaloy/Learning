package org.cgl.sudoku.model;

public class Cell {

	private Integer value;
	private Integer id;
	private Subset[] position;
	
	public Cell(Integer id) {
		position = new Subset[3];
		this.id = id;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Subset[] getPosition() {
		return position;
	}

	public void setRow(Subset pos0) {
		position[0] = pos0;
	}
	
	public void setColumn(Subset pos1) {
		position[1] = pos1;
	}
	
	public void setBox(Subset pos2) {
		position[2] = pos2;
	}
	
	public String getRow() {
		return position[0].getId();
	}
	
	public String getColumn() {
		return position[1].getId();
	}
	
	public String getBox() {
		return position[2].getId();
	}
		
}
