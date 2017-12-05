package com.cs3.linkedgrid;

import java.util.Scanner;

public class Linkedgrid {
	private Node root;
	private int size;
	private Node xmarker;
	private Node ymarker;
	//private int step;
	
	public Linkedgrid(int size){
		//create first layer
		this.size = size;
		root = new Node();
		xmarker = root;
		ymarker = root;
		Node temp;
		
		for(int x = 0; x < this.size-1; x++){//make the first row
			
			temp = new Node();
			temp.setLeft(xmarker);
			xmarker.setRight(temp);
			xmarker = temp;
			
		}
		for(int y = 0; y < this.size-1; y++){//repeat to create the rest of the rows
			//make the first node of the row
			temp = new Node();
			temp.setUp(ymarker);
			ymarker.setDown(temp);
			ymarker = temp;
			xmarker = ymarker;
			for(int x = 0; x < size-1; x++){//make a row and connect each node to the above one
				temp = new Node();
				temp.setLeft(xmarker);
				xmarker.setRight(temp);
				temp.setUp(temp.getLeft().getUp().getRight());
				temp.getUp().setDown(temp);
				xmarker = temp;
			}
		}
		
	}
	
	public void display(){
		ymarker = root;
		
		for(int y = 0; y < this.size; y++){
			Node temp = ymarker;
			System.out.print(temp.getData() + "\t");
			for(int x = 0; x < this.size-1; x++){
				temp = temp.getRight();
				System.out.print(temp.getData() + "\t");
			}
			ymarker = ymarker.getDown();
			System.out.println();
		}
	}
	
	private int step = 1;
	
	private Scanner scan = new Scanner(System.in);
	private String prompt;
	
	public void kT(Node location, int complete){
		if(location.getData() == 0){
			location.setData(step);
			//System.out.println("printed");
			//display();
			if(step == complete){
				System.out.println("Found: ");
				display();
				prompt = scan.next();
				System.out.println("===============================================================");
			}
			step++;
			
			try{
				kT(location.getRight().getRight().getUp(), complete);//spot 1
			}catch(NullPointerException e){
				//System.out.println(1);
			}
			
			try{
				kT(location.getRight().getRight().getDown(), complete);//spot 2
			}catch(NullPointerException e){
				//System.out.println(2);
			}
			
			try{
				kT(location.getDown().getDown().getRight(), complete);//spot 3
			}catch(NullPointerException e){
				//System.out.println(3);
			}
			
			try{
				kT(location.getDown().getDown().getLeft(), complete);//spot 4
			}catch(NullPointerException e){
				//System.out.println(4);
			}
			
			try{
				kT(location.getLeft().getLeft().getDown(), complete);//spot 5
			}catch(NullPointerException e){
				//System.out.println(5);
			}
			
			try{
				kT(location.getLeft().getLeft().getUp(), complete);//spot 6
			}catch(NullPointerException e){
				//System.out.println(6);
			}
			
			try{
				kT(location.getUp().getUp().getLeft(), complete);//spot 7
			}catch(NullPointerException e){
				//System.out.println(7);
			}
			
			try{
				kT(location.getUp().getUp().getRight(), complete);//spot 8
			}catch(NullPointerException e){
				//System.out.println(8);
			}
			
			step--;
			location.setData(0);
			
		}
	}
	
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}
