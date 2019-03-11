package com.company;

import java.util.Scanner;

public class Tic {

    static Scanner in;
    char [][] board;
    static int size = 6;

    char currentPlayerMark;

    public Tic(){


        board = new char[size][size];
        populateBoard();





    }

    public static void main(String[] args){
        //System.out.println("Enter size: ");
        //in = new Scanner(System.in);
        //size = in.nextInt();
        Tic t = new Tic();
        t.printBoard();
        t.placeMark(0,0, true);
        t.checkForWin(0,0);
        t.printBoard();
        t.placeMark(0,2, false);
        t.checkForWin(0,2);
        t.printBoard();
        t.placeMark(1,1, true);
        t.checkForWin(1,1);
        t.printBoard();
        t.placeMark(0,2, false);
        t.checkForWin(0,2);
        t.printBoard();
        t.placeMark(2,2, true);
        t.checkForWin(2,2);
        t.printBoard();

    }


    private void populateBoard(){
        // Loop through rows
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '-';
            }
        }

    }

    public void printBoard() {
        System.out.println("-------------");

        for (int i = 0; i < size; i++) {
            System.out.print("| ");
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public boolean isBoardFull() {
        boolean isFull = true;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == '-') {
                    isFull = false;
                }
            }
        }

        return isFull;
    }

    public void checkForWin(int x, int y) {
        if ((y + 2 < size && board[x][y+1] == board[x][y] && board[x][y] == board[x][y+2])
                || (x + 2 < size && board[x][y] == board[x+1][y] && board[x][y] == board[x+2][y])
                || (x + 2 < size && y + 2 < size && board[x][y] == board[x+1][y+1] && board[x][y] == board[x+2][y+2])
                || (x - 2 >= 0 && y - 2 >= 0 && board[x][y] == board[x-1][y-1] && board[x][y] == board[x-2][y-2])){
            printBoard();
            System.out.println(board[x][y] + " : Win!!!");
            return;
        }
        System.out.println("Please continue!!!");
    }


    public boolean placeMark(int row, int col, boolean X) {

        if ((row >= 0) && (row < size)) {
            if ((col >= 0) && (col < size)) {
                if (board[row][col] == '-') {
                    board[row][col] = X ? 'X' : 'O';
                    return true;
                }
            }
        }

        return false;
    }



}
