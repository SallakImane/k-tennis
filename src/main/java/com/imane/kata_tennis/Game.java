package com.imane.kata_tennis;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Game {

    private Player playerOne;
    private Player playerTwo;
    private Player winner;
    private boolean gameOver;
    private boolean lastPoint = false;

    /*Initialize score of two players*/
    Game(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.playerOne.setScore(0);
        this.playerTwo.setScore(0);
    }

    private void reinitScore() {
        this.playerOne.setScore(0);
        this.playerTwo.setScore(0);
    }

    /* When two player has 40 point, the next player who win a point, w'll win the game*/
    private boolean isLastPoint() {
        if (this.playerOne.getScore().equals(3) && this.playerTwo.getScore().equals(3)) {
            return true;
        }
        return false;
    }


    /* Function Schow score */
    private String schowScore(Integer score) {
        switch (score) {
            case 1:
                return ScoreEnum.FIFTEEN.getValue().toString();
            case 2:
                return ScoreEnum.THIRTY.getValue().toString();
            case 3:
                return ScoreEnum.FORTY.getValue().toString();
            default:
                return ScoreEnum.ZERO.getValue().toString();
        }
    }

    /*table point history per player*/
    private void historyPonit(Player p) {
        p.getAllPoint().add(schowScore(p.getScore()));
        if (p.equals(this.playerOne)) {
            this.playerTwo.getAllPoint().add(schowScore(this.playerTwo.getScore()));
        } else {
            this.playerOne.getAllPoint().add(schowScore(this.playerOne.getScore()));
        }
    }

    /*Increment player score*/
    void incrementeScore(Player p) {
        if (isLastPoint()) {
            this.winner = p;
            reinitScore();
        } else {
            p.setScore(p.getScore() + 1);
            historyPonit(p);
        }
    }
}
