package org.cgl.sudoku.model;

public class Column extends Subset {
	
	public Column(Integer size, Integer id, Board board) {
		super(size);
		
		this.id = ("Column " + id);
		
		for (int i = 0; i < size; i++) {
			
			cells[i] = board.getCell(((i*9)+id));
			cells[i].setColumn(this);
			
		}
	}

}
