package minesweeper;

import java.util.Scanner;


public class menu{
	public static void main(String[] args){
		Game juego = new Game();
		System.out.println("Ingresar can de c y de f:");
		Scanner a=new Scanner(System.in);
		String nivel= a.next();
		int row = Integer.parseInt(nivel);
		 nivel= a.next();
		int col = Integer.parseInt(nivel);
		System.out.println("Ingresar accion [u/f/c]:");
		String opcion= a.next();
		switch(opcion) {
		 case 'u': 
			 juego.uncover(row, col);
		     break;
		 case 'f':
			 juego.flagAsMine(row, col);
			 break;
		 case 'c':
			 juego.clearFlag(row, col);
			 break;
		}	
		
	 }
}

