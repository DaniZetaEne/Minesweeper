package minesweeper;
import java.util.Scanner;

public class Start {
 public static void main(String[] args) {
	minesweeperImp juego = new minesweeperImp();
	Scanner a=new Scanner(System.in);
	System.out.println("Ingresar cantidad de filas: ");
	String nivel = a.next();
	int rowMax = Integer.parseInt(nivel);
	System.out.println("Ingresar cantidad de columnas: ");
	nivel = a.next();
	int colMax= Integer.parseInt(nivel);
	juego.startGrid(rowMax,colMax);
	juego.display();
	//System.out.println(); - 
	// juego.displayInternal(); - binary matrix (1-mines/0-empty)
	//System.out.println();
	//juego.displayRaw();
	int row,col;
	while (!juego.isGameOver()) {
			System.out.println("Fila/Columa");
			nivel = a.next();
			while (Integer.parseInt(nivel)<0|Integer.parseInt(nivel)>rowMax){System.out.println("Ingrese un nro entre 1 y " + rowMax);
			  															  nivel = a.next();}
			row = Integer.parseInt(nivel);
			nivel = a.next();
			while (Integer.parseInt(nivel)<0|Integer.parseInt(nivel)>colMax){System.out.println("Ingrese un nro entre 1 y " + colMax);
																							 nivel = a.next();}
			col = Integer.parseInt(nivel);
			System.out.println("Destapar"); // enter 'd'
			System.out.println("Plantar bandera");// enter 'p'
			System.out.println("Borrar bandera");// enter 'b'
			String opcions = a.next();
			char opcion=opcions.charAt(0);
			switch(opcion) {
							case 'd':
								juego.uncover(row, col);
								break;
							case 'p':
								juego.flagAsMine(row, col);
								break;
							case 'b':
								juego.clearFlag(row, col);
								break;
							default:
								System.out.println("No ingresó una opción válida. Ingrese d/p/b");
							}
			juego.display();
		 						}
		if (juego.isWinningGame()){System.out.println("Gano el juego");}
		else {System.out.println("Perdio el juego");}
 									}
					}
