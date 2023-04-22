import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static String matchFound(String[][] anyBoard) {
        for (int col = 0; col < 3; col++) {
            if (
                    (anyBoard[0][col] == anyBoard[1][col]) &&
                    (anyBoard[1][col] == anyBoard[2][col]) &&
                    (anyBoard[2][col] == anyBoard[0][col])
            ) {
                return anyBoard[0][col];
            }
        }
        for (int row = 0; row < 3; row++) {
            if (
                    (anyBoard[row][0] == anyBoard[row][1]) &&
                    (anyBoard[row][1] == anyBoard[row][2]) &&
                    (anyBoard[row][2] == anyBoard[row][0])
            ) {
                return anyBoard[row][0];
            }
        }
        if (
                (anyBoard[0][0] == anyBoard[1][1]) &&
                (anyBoard[1][1] == anyBoard[2][2]) &&
                (anyBoard[2][2] == anyBoard[0][0])
        ) {
            return anyBoard[0][0];
        }
        if (
                (anyBoard[0][2] == anyBoard[1][1]) &&
                (anyBoard[1][1] == anyBoard[2][0]) &&
                (anyBoard[2][0] == anyBoard[0][2])
        ) {
            return anyBoard[0][2];
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        while (true) {
            System.out.println("Tic Tac Toe");
            System.out.println("1. Play\n2. Quit");
            System.out.println("Select an option:");
            String select = scn.next();
            if (select.equals("1")) {
                System.out.println("Game started.");
                String[][] board =  {
                        {"0", "1", "2"},
                        {"3", "4", "5"},
                        {"6", "7", "8"},
                };
                boolean gameSet = false;
                int turn = 1;
                while (true) {
                    for (int i = 0; i < board.length; i++) {
                        System.out.println(Arrays.toString(board[i]));
                    }
                    if (turn % 2 == 1) {
                        while (true) {
                            System.out.println("Player 1's turn (X).");
                            System.out.println("Please select a grid:");
                            int player1Move = scn.nextInt();
                            int row = Math.floorDiv(player1Move, 3);
                            int column = player1Move % 3;
                            if (!(board[row][column].equals("X")) && !(board[row][column].equals("O"))) {
                                board[row][column] = "X";
                                break;
                            } else if (board[row][column].equals("O")) {
                                System.out.println("Your opponent has already picked this spot!");
                            } else if (board[row][column].equals("X")) {
                                System.out.println("You already picked this spot");
                            }
                        }
                        turn++;
                    } else {
                        while (true) {
                            System.out.println("Player 2's turn (O).");
                            System.out.println("Please select a grid:");
                            int player2Move = scn.nextInt();
                            int row = Math.floorDiv(player2Move, 3);
                            int column = player2Move % 3;
                            if (!(board[row][column].equals("O")) && !(board[row][column].equals("X"))) {
                                board[row][column] = "O";
                                break;
                            } else if (board[row][column].equals("X")) {
                                System.out.println("Your opponent has already picked this spot!");
                            } else if (board[row][column].equals("O")) {
                                System.out.println("You already picked this spot");
                            }
                        }
                        turn++;
                    }
                    String matchFound = matchFound(board);
                    if (matchFound == "X") {
                        for (int i = 0; i < board.length; i++) {
                            System.out.println(Arrays.toString(board[i]));
                        }
                        System.out.println("Player 1 Wins!");
                        gameSet = true;
                    } else if (matchFound == "O") {
                        for (int i = 0; i < board.length; i++) {
                            System.out.println(Arrays.toString(board[i]));
                        }
                        System.out.println("Player 2 Wins!");
                        gameSet = true;
                    } else if (turn > 9 && matchFound == null) {
                        for (int i = 0; i < board.length; i++) {
                            System.out.println(Arrays.toString(board[i]));
                        }
                        System.out.println("Draw!");
                        gameSet = true;
                    }
                    if (gameSet == true) {
                        break;
                    }
                }
            } else if (select.equals("2")) {
                System.out.println("See you next time!");
                break;
            } else {
                System.out.println("Unsupported input.");
            }
        }
    }
}
