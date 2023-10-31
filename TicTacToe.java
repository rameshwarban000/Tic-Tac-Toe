package com.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
//	globle variable 
	static Integer userInput=0;
	static int computerMove;
	static boolean gameOver = false;
	static char[][] board = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };

//	main method started
	public static void main(String[] args) {


		printBoard();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			playerMove(scanner);
			if(gameOver) {
				System.out.println("Want to play again : Y / N ");
				String wantToplay = scanner.next();
				if(wantToplay.equalsIgnoreCase("y")) {
					resetBoard(board);
					printBoard();
					playerMove(scanner);
				}else {
					break;
				}
			}
			computerMove();
			if(gameOver) {
				System.out.println("Want to play again : Y / N ");
				String wantToplay = scanner.next();
				if(wantToplay.equalsIgnoreCase("y")) {
					resetBoard(board);
					printBoard();
					playerMove(scanner);
				}else {
					break;
				}
			}
			if(isGameFinished()) {
				System.out.println("There is no space on board");
				System.out.println("Want to play again : Y / N ");
				String wantToplay = scanner.nextLine();
				if(wantToplay.equalsIgnoreCase("y")) {
					resetBoard(board);
					printBoard();
					playerMove(scanner);
				}else {
					break;
				}
			}
		}
		System.out.println("Game Over...");
		scanner.close();
	}

private static void resetBoard(char[][] board) {
	System.out.println("Reseting Board...");
	board[0][0] = ' ';
	board[0][1] = ' ';
	board[0][2] = ' ';
	
	board[1][0] = ' ';
	board[1][1] = ' ';
	board[1][2] = ' ';
	
	board[2][0] = ' ';
	board[2][1] = ' ';
	board[2][2] = ' ';
	gameOver = false;
	System.out.println("Board Reseted...");
	}

private static void whoIsWin(char c) {
	if(		(board[0][0] == c && board[0][1] == c && board[0][2] == c) ||
			(board[1][0] == c && board[1][1] == c && board[1][2] == c) ||
			(board[2][0] == c && board[2][1] == c && board[2][2] == c) ||
			
			(board[0][0] == c && board[1][0] == c && board[2][0] == c) ||
			(board[0][1] == c && board[1][1] == c && board[2][1] == c) ||
			(board[0][2] == c && board[1][2] == c && board[2][2] == c) ||
			
			(board[0][0] == c && board[1][1] == c && board[2][2] == c) ||
			(board[0][2] == c && board[1][1] == c && board[2][0] == c) ) {
		gameOver = true;
		switch (c) {
		case 'X':
			System.out.println("Player Wins");
			break;
		case 'O':
			System.out.println("Computer Wins");
			break;
		}
	}
}

private static boolean isGameFinished() {
	
	for(int i =0; i < board.length; i++) {
		for(int j= 0; j< board[i].length;j++) {
			if ( board[i][j] == ' ') return false; 
		}
	}
	printBoard();
	System.out.println("Game is finished");
	return true;
	
}

//	This is computer move. Here you can see the compute has to play. How it is working, first we are
//	printing who is currently playing this  move. 
//	now second we are generating random number between 1 to 9 and passing this to isValidMove method. This valid move will return true or false base on 
//	out input if we pass 1 it will check if in board array boear[0][1] posotion is empty or not. Like this we are it is generate number and that mothod will be 
//	check if it is valid move than we are breaking this while loop and passing player symbol into boear and we are printing it.
	private static void computerMove() {
		System.out.println("Computer Move");
		
		Random random = new Random();
		while(true) {
		  computerMove = random.nextInt(9) + 1;
		 if(isValidMove(computerMove)) break;
		}
		placeMove( Integer.toString(computerMove), 'O');
		printBoard();
		whoIsWin('O');
	}

	private static boolean isValidMove( int position) {
		switch (position) {
		case 1:
			return (board[0][0] == ' ');
		case 2:
			return (board[0][1] == ' ');
		case 3:
			return (board[0][2] == ' ');
		case 4:
			return (board[1][0] == ' ');
		case 5:
			return (board[1][1] == ' ');
		case 6:
			return (board[1][2] == ' ');
		case 7:
			return (board[2][0] == ' ');
		case 8:
			return (board[2][1] == ' ');
		case 9:
			return (board[2][2] == ' ');
		default:
			return false;
		}
	}
	private static void playerMove( Scanner scanner) {
		
		while(true) {
			System.out.println("Where would you like to play? 1-9");
			userInput = scanner.nextInt();
			if(isValidMove(userInput)) { 
				break;
			}else{
				System.out.println(userInput + " :  it is not valid move.");
			};
		}
		placeMove( userInput.toString() , 'X');
		printBoard();
		whoIsWin( 'X');
	}

	private static void placeMove( String userInput, char symbol) {
		switch (userInput) {
		case "1":
			board[0][0] = symbol;
			break;
		case "2":
			board[0][1] = symbol;
			break;
		case "3":
			board[0][2] = symbol;
			break;
		case "4":
			board[1][0] = symbol;
			break;
		case "5":
			board[1][1] = symbol;
			break;
		case "6":
			board[1][2] = symbol;
			break;
		case "7":
			board[2][0] = symbol;
			break;
		case "8":
			board[2][1] = symbol;
			break;
		case "9":
			board[2][2] = symbol;
			break;

		default:
			System.out.println("Enter Valid Move : ");
			break;
		}
	}

	private static void printBoard() {
		System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
		System.out.println("-+-+-");
		System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
		System.out.println("-+-+-");
		System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
	}
}
