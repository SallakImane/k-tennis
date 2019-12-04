package com.imane.kata_tennis;

import java.util.Scanner;


public class SPRINT1 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {

        StringBuilder result = new StringBuilder();

        /* set first player name */
        System.out.print("Player 1 name :");
        Player firstPlayer = new Player(scanner.nextLine());

        /* set second player name */
        System.out.print("Player 2 name :");
        Player secondPlayer = new Player(scanner.nextLine());




        System.out.printf("Enter point winner [1 = %s, 2 = %s, 0 = exit] : ", firstPlayer.getName(), secondPlayer.getName());



        /*initialize game between two players*/
        Game game = new Game(firstPlayer, secondPlayer);
        boolean gameOver=false;

        /* start the game */
        while (!gameOver ) {
            String command = scanner.nextLine();
            if ("1".equals(command)) {
                game.incrementeScore(firstPlayer);

            } else if ("2".equals(command)) {
                game.incrementeScore(secondPlayer);

            } else if ("0".equals(command)) {
                printPoint(result, game, firstPlayer, secondPlayer);
                System.err.println(result);
                System.out.println("------------------------------");

            } else {
            }
            if (game.getWinner() != null) {
                gameOver=true;
                printPoint(result, game, firstPlayer, secondPlayer);
                System.err.println(result);
            }
        }
    }

    private static void printPoint(StringBuilder result, Game game, Player firstPlayer, Player secondPlayer) {
        result.append("\n");
        result.append(""+game.getPlayerOne().getName());
        for (String item : game.getPlayerOne().getAllPoint()) {
            result.append(" \t "+item);
        }
        if(game.getWinner() != null) {
            result.append(" \t ");
            result.append(firstPlayer.getScore());
            result.append(" \t ");
            result.append((game.getWinner().equals(firstPlayer)) ? game.getWinner().getName()+" win the game" : "");
        }
        result.append("\n");
        result.append(""+game.getPlayerTwo().getName());
        for (String item : game.getPlayerTwo().getAllPoint()) {
            result.append(" \t "+item);
        }
        if(game.getWinner() != null) {
            result.append(" \t ");
            result.append(secondPlayer.getScore());
            result.append(" \t ");
            result.append((game.getWinner().equals(secondPlayer)) ? game.getWinner().getName()+" win the game" : "");
        }
        result.append("\n");
    }
}

