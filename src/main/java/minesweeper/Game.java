package minesweeper;

import java.util.Random;

public class Game implements Minesweeper{
	Cell[][] GridCell;
	int r,c;
	Random rand = new Random();
	int valueCol, valueRow;
	
	public void startGrid(int row, int col) {
	r=row;
	c=col;
	GridCell= new Cell[row][col];
	for (int i=0;i<c;i++){
		for (int j=0;j<r;j++){
			GridCell[i][j].value=0; //para saber que se inicializan sin bombas
		}
	}
	double aMines=row*col*0.15; //calculo de minas
	int amountMines = (int)aMines; //parte entera del calculo
	for (int i=0;i<amountMines;i++){         						
			valueRow = rand.nextInt(row);							//random de filas
			valueCol = rand.nextInt(col);						    //random de columnas
			if (!thereIsMine(row,col)) {GridCell[row][col].value=-1;}	//la mina ya esta en esa ubicacion?
			else {i--;}
			}
	fillAdjacent(row,col,r,c); //AutoCompleto la matriz
	}
	public void uncover(int row, int col) {
		//Descubrir una celda
		GridCell[row][col].uncoverState=false;
		}
	public void flagAsMine(int row, int col) {
		// Bandera en la celda
		GridCell[row][col].suspicious=true;
	}
	public void clearFlag(int row, int col) {
		// Borrar bandera en la celda
		GridCell[row][col].suspicious=false;
	}
	public boolean isGameOver() {
		// Termino el juego?
		/*Si eso es falso hay que determinar
		 *que esten todas las celdas destapadas y que la 
		 *cantidad de banderas coincida con la cantidad 
		 *y la posicion de bombas que hay */
		if (GridCell[r][c].uncoverState==true & thereIsMine(r,c)) {return true;}
		return false;
	}
	public boolean isWinningGame() {
		// Si isGameOver es verdadero... isWinningGame?
		return false;
	}
	public void display() {
		// Pantallazo de como va el juego
		for (int i=0;i<c;i++){
			for (int j=0;j<r;j++){
				if (GridCell[i][j].uncoverState) {System.out.print("-  ");}
				if (GridCell[i][j].suspicious) {System.out.print("F");}
				else {System.out.print(GridCell[i][j].value);}
			 System.out.print("\n");
			}
		}
	}
	public void displayInternal() {
		// Muestra los valores de adentro
		for (int i=0;i<c;i++){
			for (int j=0;j<r;j++){System.out.print(GridCell[i][j].value);}
			 System.out.print("\n");
			}
		}
	public void displayRaw() {
		//Muestra 1 si la celda tiene mina 0 si no tiene mina
		for (int i=0;i<c;i++){
			for (int j=0;j<r;j++){
				if (thereIsMine(i,j)) {System.out.print("1  ");}
				else {System.out.print("0  ");}
			 System.out.print("\n");
			}
		}
	}
	public void fillAdjacent(int row, int col,int r, int c){ //recibe la fila y la columna en que esta, y la fila y columna maxima	
	for (int fila=max(0,row-1);fila<=min(r-1,row+1);fila++){
		for(int columna=max(0,col-1);columna<=min(c-1,col+1);columna++){
		if (!thereIsMine(fila,columna)) {
			GridCell[fila][columna].value++;
		}	
		}
	}
	}
	private boolean thereIsMine(int row, int col){
		if (thereIsMine(row,col)) {return true;}
		else {return false;}
	}
	public int max (int a, int b) {
					if (a>b) {return a;}
					else {return b;} // retorna b ya sea mayor o igual a a.
									}
	public int min (int a, int b) {
		if (a<b) {return a;}
		else {return b;} // retorna b ya sea menor o igual a a.
						}
}

