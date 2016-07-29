package org.cgl.sudoku.model;

public class Row extends Subset {
	
	public Row(Integer size, Integer id, Board board) {
		super(size);
		
		this.id = ("Row" + id);
		
		Cell[] tempCells = board.getCells();
		
		for (int i = 0; i < size; i++) {
			
			this.cells[i] = tempCells[((id*9)+i)];
			tempCells[((id*9)+i)].setRow(this);
		}
		
		board.setCells(tempCells);
	}

}
