package org.cgl.sudoku.model;

public class Subset {
	
	protected Cell[] cells;
	protected String id;

	public Subset(Integer size, String id) {
		
		cells = new Cell[size];
		this.id = id;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
