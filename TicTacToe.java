package Normalproject;

import java.util.Scanner;

public class TicTacToe {
    static int tictactoe[][] = new int[3][3];
    public static void main(String args[])
    {
        int player1 = 1;
        int player2 = 2;
        int count = 0;
        boolean player1turn = true;
        do {
            printBoard();
            int player;
            if(player1turn)
            {
                player=player1;
            }
            else{
                player= player2;
            }
            System.out.println("Player %s turn.".formatted(player));
            Scanner sc = new Scanner(System.in);
            int playerInput = sc.nextInt();
            sc.close();
                int rowIndex = playerInput / 10 ;
                int colIndex = playerInput % 10;
                tictactoe[rowIndex][colIndex] = player;
            count++;
            boolean playerWins = checkWin(rowIndex,colIndex);
            if (playerWins) {
                printBoard();
                System.out.println("Congratulations! Player %s wins.".formatted(player));
                break;
            }
            player1turn = !player1turn; //viceversa
        } while (count < 9);
    }
    public static void printBoard()
    {
        for(int i = 0 ; i < tictactoe.length ; i++)
        {
            for(int j = 0 ; j < tictactoe.length ; j++)
            {
                if (tictactoe[i][j] == 1) {
                    System.out.print( "X    ");
                }
                else if (tictactoe[i][j] == 2) {
                    System.out.print( "O    ");
                }
                else{
                    System.out.print(tictactoe[i][j] + "    ");
                }
            }
            System.out.println("    ");
        }
    }
    public static boolean checkWin(int rowIndex, int colIndex)
    {
        if(tictactoe[rowIndex][0] == tictactoe[rowIndex][1] && tictactoe[rowIndex][1]== tictactoe[rowIndex][2])
        {
            return true;
        }
        else if(tictactoe[0][colIndex] == tictactoe[1][colIndex] && tictactoe[1][colIndex]== tictactoe[2][colIndex])
        {
            return true;
        }
        else if (rowIndex == colIndex && tictactoe[0][0] == tictactoe[1][1] && tictactoe[1][1] == tictactoe[2][2]) {
            return true;
        }
        else if (rowIndex + colIndex == 2 && tictactoe[0][2] == tictactoe[1][1] && tictactoe[1][1] == tictactoe[2][0]) {
            return true;
        }
        return false;

        // return (tictactoe[rowIndex][0] == tictactoe[rowIndex][1] && tictactoe[rowIndex][1]== tictactoe[rowIndex][2]) 
        // || (tictactoe[0][colIndex] == tictactoe[1][colIndex] && tictactoe[1][colIndex]== tictactoe[2][colIndex])
        // ||  (rowIndex == colIndex && tictactoe[0][0] == tictactoe[1][1] && tictactoe[1][1] == tictactoe[2][2])
        // || (rowIndex + colIndex == 2 && tictactoe[0][2] == tictactoe[1][1] && tictactoe[1][1] == tictactoe[2][0]);

    }
}