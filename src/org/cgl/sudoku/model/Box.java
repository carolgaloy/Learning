package org.cgl.sudoku.model;

public class Box extends Subset {
	
	public Box(Integer size, Integer id, Board board) {
		super(size);
		
		this.id = ("Box " + id);
		
		int rowBox = id/3;
		int colBox = id%3;
		int baseNum = rowBox * 27 + colBox * 3;
		
		for (int i = 0; i < 3; i++) {			
			
			for (int j = 0; j < 3; j++) {
				
				cells[i] = board.getCell((i*9)+j+baseNum);
				cells[i].setBox(this);
				
			}			
		}		
	}	
}