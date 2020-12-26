package myGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

	static ArrayList<Integer>  playerLocations =  new ArrayList<Integer>();
	static ArrayList<Integer>  comLocations =  new ArrayList<Integer>();
	
	public static void main(String args[])
	{
		char[][] box = {{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '}};
		
		while(true) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Your plasement location ");
		int location = input.nextInt();
		while(playerLocations.contains(location)||comLocations.contains(location))
		{
			System.out.println("Location is incorrect ");
			location = input.nextInt();
			
		}
		getuserInputs(box, location , "player1");
		
		Random rand = new Random();
		int location2 = rand.nextInt(9)+1;
		while(playerLocations.contains(location2)||comLocations.contains(location2))
		{
			//System.out.println("Location is incorrect ");
		location2 = rand.nextInt(9)+1;
			
		}
		
		getuserInputs(box, location2 , "player2");
		

		gameLayout(box);
		 String output = validete();
		System.out.println(output);
		}
	}
	
	public static void gameLayout(char[][]box) {
		
		for (char[] row : box) {
			for (char c : row) {
				
				System.out.print(c);
			}
			System.out.println();
		}
		
		
	}
	
	public static void getuserInputs(char[][]box,int location , String type)
	{
		char sym = ' ';
		if(type.equals("player1"))
		{
			sym ='X';
			playerLocations.add(location);
		}
		else if(type.equals("player2"))
		{
			sym ='O';
			comLocations.add(location);
		}
		
		switch(location) {
		
		case 1: box[0][0] = sym;
		break;
		case 2: box[0][2] = sym;
		break;
		case 3: box[0][4] = sym;
		break;
		case 4: box[2][0] = sym;
		break;
		case 5: box[2][2] = sym;
		break;
		case 6: box[2][4] = sym;
		break;
		case 7: box[4][0] = sym;
		break;
		case 8: box[4][2] = sym;
		break;
		case 9: box[4][4] = sym;
		break;
		
		
		
		}
	}
		public static String validete()
		{
			List r1 = Arrays.asList(1,2,3);
			List r2 = Arrays.asList(4,5,6);
			List r3 = Arrays.asList(7,8,9);
			List c1 = Arrays.asList(1,4,7);
			List c2 = Arrays.asList(2,5,8);
			List c3 = Arrays.asList(3,6,9);
			List x1 = Arrays.asList(1,5,9);
			List x2 = Arrays.asList(3,5,7);
			
			
			List<List>win = new ArrayList<List>();
			win.add(r1);
			win.add(r2);
			win.add(r3);
			win.add(c1);
			win.add(c2);
			win.add(c3);
			win.add(x1);
			win.add(x2);
			
			for (List list : win) {
				if(playerLocations.containsAll(list)) {
					
					return "you won";
				}
				else if (comLocations.containsAll(list))
				{
					return "computer won";
				}
				else if(playerLocations.size()+comLocations.size()==9)
				{
					return "drow";
				}
				
			}
			return "";
			
		}
		
	
}
