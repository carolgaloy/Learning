package org.cgl.sudoku.model;

public class Board {
	
	private Subset[] subsets;
	private Cell[] cells;
		
	public Board(Integer[] initialState) {
		
		cells = new Cell[81];
		
		for (int i = 0; i < 81; i++) {
			cells[i] = new Cell(""+i);
			cells[i].setValue(i);
		}
		
		subsets = new Subset[27];
				
		for (int i = 0; i < 9; i++) {
			subsets[i] = new Row(9, i, this);
			System.out.println("Row " + (i+1) + " created");
			subsets[i+9] = new Column(9, i, this);
			System.out.println("Column " + (i+1) + " created");
			subsets[i+9*2] = new Box(9, i, this);
			System.out.println("Box " + (i+1) + " created");
		}		
		
//		for (int i = 0; i < 9; i++) {
//			
//			for (int j = 0; j < 9; j++) {
//				
//				subsets[i].cells[j] = cells[((i*9)+j)];
//				cells[((i*9)+j)].setRow(subsets[i]);
//			}
//		}
		
//		for (int i = 0; i < 9; i++) {
//			
//			for (int j = 0; j < 9; j++) {
//				
//				subsets[(j+9)].cells[i] = cells[((i*9)+j)];
//				cells[((i*9)+j)].setColumn(subsets[(j+9)]);
//			}
//		}
		
//		for (int i = 0; i < 3; i++) {
//			
//			for (int j = 0; j < 3; j++) {
//				
//				subsets[(i+18)].cells[j] = cells[(j+(i*3))];
//				cells[(j+(i*3))].setBox(subsets[(i+18)]);
//				subsets[(i+18)].cells[(j+3)] = cells[(j+9+(i*3))];
//				cells[(j+9+(i*3))].setBox(subsets[(i+18)]);
//				subsets[(i+18)].cells[(j+6)] = cells[(j+18+(i*3))];
//				cells[(j+18+(i*3))].setBox(subsets[(i+18)]);
//			}
//		}
//		
//		for (int i = 0; i < 3; i++) {
//			
//			for (int j = 0; j < 3; j++) {
//				
//				subsets[(i+21)].cells[j] = cells[(j+27+(i*3))];
//				cells[(j+27+(i*3))].setBox(subsets[(i+21)]);
//				subsets[(i+21)].cells[(j+3)] = cells[(j+36+(i*3))];
//				cells[(j+36+(i*3))].setBox(subsets[(i+21)]);
//				subsets[(i+21)].cells[(j+6)] = cells[(j+45+(i*3))];
//				cells[(j+45+(i*3))].setBox(subsets[(i+21)]);
//			}
//		}
//		
//		for (int i = 0; i < 3; i++) {
//			
//			for (int j = 0; j < 3; j++) {
//				
//				subsets[(i+24)].cells[j] = cells[(j+54+(i*3))];
//				cells[(j+54+(i*3))].setBox(subsets[(i+24)]);
//				subsets[(i+24)].cells[(j+3)] = cells[(j+63+(i*3))];
//				cells[(j+63+(i*3))].setBox(subsets[(i+24)]);
//				subsets[(i+24)].cells[(j+6)] = cells[(j+72+(i*3))];
//				cells[(j+72+(i*3))].setBox(subsets[(i+24)]);
//			}
//		}
		
		// para comprobar que las posiciones son las correctas
		for (int i = 0; i < 81; i++){
			System.out.println("The positions of cell " + i + " are " + cells[i].getRow() + ", " + cells[i].getColumn() + " and " + cells[i].getBox());
		}
		
		for (int i = 0; i < 81; i++){		
			cells[i].setValue(initialState[i]);
		}
		
		// para comprobar que los valores se han asignado correctamente
		for (int i = 0; i < 81; i++) {
			
			if (i%9 != 8) {
				System.out.print(cells[i].getValue() + ",");
			} else {
				System.out.print(cells[i].getValue());
				System.out.println();
			}
			
		}

	}
	
	

	public Subset[] getSubsets() {
		return subsets;
	}



	public void setSubsets(Subset[] subsets) {
		this.subsets = subsets;
	}



	public Cell[] getCells() {
		return cells;
	}



	public void setCells(Cell[] cells) {
		this.cells = cells;
	}
	
	public Cell getCell(int id) {
		return cells[id];
	}



	public Integer[] solve() {
		
		Boolean done = true;
		
		do {
			
		} while (done = false);
		
		return null;
	}
}
