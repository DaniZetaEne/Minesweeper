package minesweeper;

import java.util.Random;
import java.util.Set;
import com.despegar.highflight.utils.Matrix2DCellPosition;
import com.despegar.highflight.utils.MatrixUtils;

public class minesweeperImp implements Minesweeper{
	Cell[][] GridCell;
	int r,c, amountMines;
	Random rand = new Random();
	int valueCol, valueRow;
	int lastRow,lastCol;
	int matBin[][];
	boolean endWin;
	public void startGrid(int row, int col) {
	r=row-1;
	c=col-1;
	GridCell= new Cell[row][col];
	for (int j=0;j<=c;j++){
		for (int i=0;i<=r;i++){
			GridCell[i][j]=new Cell();
			GridCell[i][j].value=0; 
			GridCell[i][j].uncoverState=false;
			GridCell[i][j].suspicious=false;
							  }
						  }
	double aMines=row*col*0.15; //calculation of mines
    amountMines = (int)aMines; //integer part of the calculation
    if (amountMines==0) {amountMines=1;} //so that there is at least one mine
	for (int i=0;i<amountMines;i++){         						
			valueRow = rand.nextInt(row);							//random row
			valueCol = rand.nextInt(col);						    //random column
			if (!thereIsMine(valueRow,valueCol)) {GridCell[valueRow][valueCol].value=-1;}
			else {i--;}
								   }
	matBin= new int[row][col];
	for (int j=0;j<=c;j++){     //binary matrix 
		for (int i=0;i<=r;i++){
			matBin[i][j]=0;
			if (thereIsMine(i,j)) {	fillAdjacent(i,j,row,col); 
									matBin[i][j]=1;} 
							  }
						  }
	}
	public void fillAdjacent(int row, int col,int r, int c){ 	
		for (int fila=max(0,row-1);fila<=min(r-1,row+1);fila++){
			for(int columna=max(0,col-1);columna<=min(c-1,col+1);columna++){
					if (!thereIsMine(fila,columna)) {
									GridCell[fila][columna].value++;
													}	
																		    }
															   }
		}
	public void uncover(int row, int col) { 
		if (GridCell[row-1][col-1].value!=-1){
				Set<Matrix2DCellPosition> setPosition=MatrixUtils.cascade(matBin, row-1, col-1);
				for(Matrix2DCellPosition M : setPosition){
						GridCell[M.getRow()][M.getColumn()].uncoverState=true;
														 }
											 }
		GridCell[row-1][col-1].uncoverState=true;
		lastRow=row-1;
		lastCol=col-1;
		}
	public void flagAsMine(int row, int col) {
		GridCell[row-1][col-1].suspicious=true;
		lastRow=row-1;
		lastCol=row-1;
	}
	public void clearFlag(int row, int col) {
		GridCell[row-1][col-1].suspicious=false;
		lastRow=row-1;
		lastCol=row-1;
	}
	public boolean isGameOver() {
		int counter=0;
		int total=((r+1)*(c+1))-amountMines;
		if(GridCell[lastRow][lastCol].uncoverState==true && GridCell[lastRow][lastCol].value==-1) {
					 endWin=false;
					 return true;}
		for (int j=0;j<=c;j++){
			for (int i=0;i<=r;i++){
					  if((GridCell[i][j].value!=-1)&(GridCell[i][j].uncoverState)){counter++;}
							   	  }
							  }
		if (counter==total){
			endWin=true;				
			return true;}
		else {return false;}
	}
	public boolean isWinningGame() {
		return endWin;
	}
	public void display() {
		for (int i=0;i<=r;i++){
			for (int j=0;j<=c;j++){
				if (GridCell[i][j].suspicious) {System.out.print("F ");}
				else {if (!GridCell[i][j].uncoverState) {System.out.print("- ");}
						else {if(GridCell[i][j].value==-1){System.out.print("M ");}
							  else {System.out.print(GridCell[i][j].value+ " ");}
							 }
				     }
								  }
			System.out.println();	
							  }
						   }
	public void displayInternal() {
		for (int i=0;i<=r;i++){
					for (int j=0;j<=c;j++){System.out.print(GridCell[i][j].value +" ");}
					System.out.println();	
							  }
								  }
	public void displayRaw() {
		for (int i=0;i<=r;i++){
			for (int j=0;j<=c;j++){
				if (thereIsMine(i,j)) {System.out.print("1  ");}
				else {System.out.print("0  ");}
								  }
			System.out.println();
								  }
							 }
	private boolean thereIsMine(int row, int col){
		return GridCell[row][col].value==-1;
												 }
	public int max (int a, int b) {
					if (a>b) {return a;}
					else {return b;} 
								  }
	public int min (int a, int b) {
				if (a<b) {return a;}
				else {return b;} 
								  }

}

