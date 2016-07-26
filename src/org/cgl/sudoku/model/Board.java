package org.cgl.sudoku.model;

public class Board {
	
	private Subset[] subsets;
	private Cell[] cells;
		
	public Board(Integer[] initialState) {
		
		cells = new Cell[9*9];
		subsets = new Subset[9*3];
		
		for (int i = 0; i < 9; i++) {
			subsets[i] = new Row(9, ("Row" + i));
			System.out.println("Row " + (i+1) + " created");
			subsets[i+9] = new Column(9, ("Column" + i));
			System.out.println("Column " + (i+1) + " created");
			subsets[i+9*2] = new Box(9, ("Box" + i));
			System.out.println("Box " + (i+1) + " created");
		}
		
		for (int i = 0; i < 81; i++) {
			cells[i] = new Cell(i);
			cells[i].setValue(i);
//			subsets[i/9].cells[i%9] = cells[i];
//			subsets[(i/9)+9].cells[i%9] = cells[i];
//			subsets[(i/9)+(9*2)].cells[i%9] = cells[i];
//			cells[i].setPosition(subsets[i/9], subsets[(i/9)+9], subsets[(i/9)+(9*2)]);
//			System.out.println("The positions of cell " + i + " are row " + (i/9) + ", column " + ((i/9)+9) + ", box " + ((i/9)+(9*2)));
		}
		
		for (int i = 0; i < 9; i++) {
			
			for (int j = 0; j < 9; j++) {
				
				subsets[i].cells[j] = cells[((i*9)+j)];
				cells[((i*9)+j)].setRow(subsets[i]);
			}
		}
		
		for (int i = 0; i < 9; i++) {
			
			for (int j = 0; j < 9; j++) {
				
				subsets[(j+9)].cells[i] = cells[((i*9)+j)];
				cells[((i*9)+j)].setColumn(subsets[(j+9)]);
			}
		}
		
		for (int i = 0; i < 3; i++) {
			
			for (int j = 0; j < 3; j++) {
				
				subsets[(i+18)].cells[j] = cells[(j+(i*3))];
				cells[(j+(i*3))].setBox(subsets[(i+18)]);
				subsets[(i+18)].cells[(j+3)] = cells[(j+9+(i*3))];
				cells[(j+9+(i*3))].setBox(subsets[(i+18)]);
				subsets[(i+18)].cells[(j+6)] = cells[(j+18+(i*3))];
				cells[(j+18+(i*3))].setBox(subsets[(i+18)]);
			}
		}
		
		for (int i = 0; i < 3; i++) {
			
			for (int j = 0; j < 3; j++) {
				
				subsets[(i+21)].cells[j] = cells[(j+27+(i*3))];
				cells[(j+27+(i*3))].setBox(subsets[(i+21)]);
				subsets[(i+21)].cells[(j+3)] = cells[(j+36+(i*3))];
				cells[(j+36+(i*3))].setBox(subsets[(i+21)]);
				subsets[(i+21)].cells[(j+6)] = cells[(j+45+(i*3))];
				cells[(j+45+(i*3))].setBox(subsets[(i+21)]);
			}
		}
		
		for (int i = 0; i < 3; i++) {
			
			for (int j = 0; j < 3; j++) {
				
				subsets[(i+24)].cells[j] = cells[(j+54+(i*3))];
				cells[(j+54+(i*3))].setBox(subsets[(i+24)]);
				subsets[(i+24)].cells[(j+3)] = cells[(j+63+(i*3))];
				cells[(j+63+(i*3))].setBox(subsets[(i+24)]);
				subsets[(i+24)].cells[(j+6)] = cells[(j+72+(i*3))];
				cells[(j+72+(i*3))].setBox(subsets[(i+24)]);
			}
		}
		
		for (int i = 0; i < 81; i++){
			System.out.println("The positions of cell " + i + " are row " + cells[i].getRow() + ", column " + cells[i].getColumn() + ", box " + cells[i].getBox());
		}

	}

	public void Solve(){
	}
}
