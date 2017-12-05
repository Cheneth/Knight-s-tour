package com.cs3.linkedgrid;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int SIZE = 8;//"x" where x*x is the dimensions of the board (can be changed to 6 for example)
		Linkedgrid linkedgrid = new Linkedgrid(SIZE);
		linkedgrid.kT(linkedgrid.getRoot().getRight(), (SIZE*SIZE));//parameters is the starting node on the grid (grid is a square each node is one space on the chess board), and the second is the amount of moves needed to finish a solution (aka the number of spaces on the board))
		
		
		
	}

}
