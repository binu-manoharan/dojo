package tennis;

import java.util.Scanner;

public class Tennis {

    private final Scanner scanner;
    private Scores p1Score;
    private Scores p2Score;

    private enum Scores {
        ZERO,
        FIFTEEN,
        THIRTY,
        FORTY,
        ADVANTAGE,
        DISADVANTAGE,
        DUECE,
        WIN,
        LOSS;

        public Scores getMyNextScore(Scores score, Scores otherScore) {
            switch (score) {
                case ZERO:
                    return FIFTEEN;
                case FIFTEEN:
                    return THIRTY;
                case THIRTY:
                    return FORTY;
                case FORTY:
                    if (otherScore == ZERO || otherScore == FIFTEEN || otherScore == THIRTY) {
                        return WIN;
                    } else if (otherScore == FORTY) {
                        return ADVANTAGE;
                    } else if (otherScore == ADVANTAGE) {
                        return DUECE;
                    } else {
                        throw new IllegalStateException("Get next score for 40 failed!");
                    }
                case ADVANTAGE:
                    return WIN;
                case DUECE:
                    return ADVANTAGE;
                case DISADVANTAGE:
                    return DUECE;
                default:
                    throw new IllegalStateException("Must be WIN but why bother asking next score? " + score);
            }
        }
    }

    private enum Player {
        PLAYER_A,
        PLAYER_B
    }

    public static void main(String[] args) {
        final Tennis tennis = new Tennis();
        tennis.startGame();
    }

    private Tennis() {
        scanner = new Scanner(System.in);
    }

    private void startGame() {
        boolean gameOver = false;
        p1Score = Scores.ZERO;
        p2Score = Scores.ZERO;

        while(!gameOver) {
            System.out.println("Who wins the next point? 1 for Player A, 2 for Player B");
            final Player scoringPlayer = getNextPointScoringPlayer();
            assert scoringPlayer != null;

            addScore(scoringPlayer);
            gameOver = p1Score == Scores.WIN || p2Score == Scores.WIN;

            System.out.println(p1Score + "-" + p2Score);
        }
    }

    private void addScore(Player scoringPlayer) {
        if (scoringPlayer == Player.PLAYER_A) {
            p1Score = p1Score.getMyNextScore(p1Score, p2Score);
            switch (p1Score) {
                case DUECE:
                    p2Score = Scores.DUECE;
                    break;
                case ADVANTAGE:
                    p2Score = Scores.DISADVANTAGE;
                    break;
                case WIN:
                    p2Score = Scores.LOSS;
                    break;
            }
        } else if (scoringPlayer == Player.PLAYER_B) {
            p2Score = p2Score.getMyNextScore(p2Score, p2Score);
            switch (p2Score) {
                case DUECE:
                    p1Score = Scores.DUECE;
                    break;
                case ADVANTAGE:
                    p1Score = Scores.DISADVANTAGE;
                    break;
                case WIN:
                    p1Score = Scores.LOSS;
                    break;
            }
        } else {
            throw new IllegalStateException("Whom am I adding score to?!?!");
        }
    }

    private Player getNextPointScoringPlayer() {
        final int scorer = scanner.nextInt();
        return scorer == 1 ? Player.PLAYER_A : scorer == 2 ? Player.PLAYER_B : null;
    }
}
