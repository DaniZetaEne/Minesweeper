package minesweeper;

public class Cell {
int value; //if is a mine, value = -1, else the value is equal to the number of adjacent mines
boolean uncoverState; //if the mine is uncovered = true, else false
boolean suspicious; //true if the player thinks that the cell contains a bomb
}
