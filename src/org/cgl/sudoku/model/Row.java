package org.cgl.sudoku.model;

public class Row extends Subset {
	
	public Row(Integer size, Integer id, Board board) {
		super(size);
		
		this.id = ("Row " + id);
		
		for (int i = 0; i < size; i++) {
			
			cells[i] = board.getCell(((id*9)+i));
			cells[i].setRow(this);
		}
		
	}

}
