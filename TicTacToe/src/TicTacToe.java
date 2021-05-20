import java.util.Scanner;

public class TicTacToe {

    public static Scanner input = new Scanner(System.in);

    public static boolean boardFilled = false, playerWon = false;

    public static int count = 0;

    public static int player1Move, player2Move;

    public static String[][] board = {
            {"1", "2", "3"},
            {"4", "5", "6"},
            {"7", "8", "9"}
    };

    public static void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(" " + board[i][j] + " ");
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("-----------");
        }
        System.out.println();
    }

    public static boolean checkBoardFor(String marker) {
        boolean playerWon = false;
        if (board[0][0].equals(marker)) {
            if (board[1][0].equals(marker)) {
                if (board[2][0].equals(marker)) {
                    playerWon = true;
                }
            } else if (board[0][1].equals(marker)) {
                if (board[0][2].equals(marker)) {
                    playerWon = true;
                }
            } else if (board[1][1].equals(marker)) {
                if (board[2][2].equals(marker)) {
                    playerWon = true;
                }
            }
        } else if (board[0][1].equals(marker)) {
            if (board[1][1].equals(marker)) {
                if (board[2][1].equals(marker)) {
                    playerWon = true;
                }
            }
        } else if (board[0][2].equals(marker)) {
            if (board[1][2].equals(marker)) {
                if (board[2][2].equals(marker)) {
                    playerWon = true;
                }
            } else if (board[1][1].equals(marker)) {
                if (board[2][0].equals(marker)) {
                    playerWon = true;
                }
            }
        } else if (board[1][0].equals(marker)) {
            if (board[1][1].equals(marker)) {
                if (board[1][2].equals(marker)) {
                    playerWon = true;
                }
            }
        } else if (board[2][0].equals(marker)) {
            if (board[2][1].equals(marker)) {
                if (board[2][2].equals(marker)) {
                    playerWon = true;
                }
            }
        }

        return playerWon;

    }

    public static boolean checkBoardFilled() {
        boolean boardFilled = false;
        int spacesFilled = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j].equals("X") || board[i][j].equals("O")) spacesFilled++;
            }
        }

        if(spacesFilled == 9) boardFilled = true;
        return boardFilled;
    }

    public static void placeMarker(String marker, int boxNumber) {
        switch (boxNumber) {
            case 1: board[0][0] = marker; break;
            case 2: board[0][1] = marker; break;
            case 3: board[0][2] = marker; break;
            case 4: board[1][0] = marker; break;
            case 5: board[1][1] = marker; break;
            case 6: board[1][2] = marker; break;
            case 7: board[2][0] = marker; break;
            case 8: board[2][1] = marker; break;
            case 9: board[2][2] = marker; break;
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe! Player 1 is X and Player 2 is O");

        printBoard();
        System.out.print("Choose a box to place an X in P1: ");
        player1Move = Integer.parseInt(input.nextLine());
        placeMarker("X", player1Move);

        for (int i = 0; i < 4 || !checkBoardFilled(); i++) {
            printBoard();
            System.out.print("Choose a box to place an O in P2: ");
            player2Move = Integer.parseInt(input.nextLine());
            placeMarker("O", player2Move);
            if(count >= 2) {
                playerWon = checkBoardFor("O");
                if(playerWon) {
                    System.out.println("Player 2 Won!");
                    break;
                }
            }
            count++;
            printBoard();
            System.out.print("Choose a box to place an X in P1: ");
            player1Move = Integer.parseInt(input.nextLine());
            placeMarker("X", player1Move);
            if(count >= 2) {
                playerWon = checkBoardFor("X");
                if(playerWon) {
                    System.out.println("Player 1 Won!");
                    break;
                }
            }

        }

        if(checkBoardFilled()) {
            System.out.println("The game ended in a tie");
        }


    }



}