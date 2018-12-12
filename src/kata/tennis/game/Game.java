package kata.tennis.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Game {

    private static final int MIN_GAME_POINTS = 3;

    private Player playerOne;
    private Player playerTwo;

    private Map<Player, Integer> scoreBoard;

    public Game(Player playerOne, Player playerTwo) {
        this.playerOne = Objects.requireNonNull(playerOne);
        this.playerTwo = Objects.requireNonNull(playerTwo);

        scoreBoard = new HashMap<>();
        scoreBoard.put(playerOne, 0);
        scoreBoard.put(playerTwo, 0);
    }

    public void addPointForPlayer(Player player) {
        if (!scoreBoard.containsKey(player)) {
            throw new IllegalArgumentException("invalid player");
        }
        if (hasWinner()) {
            throw new IllegalStateException("game already ended");
        }

        int oldPlayerScore = scoreBoard.get(player);
        scoreBoard.put(player, ++oldPlayerScore);
    }

    public String printScore() {
        if (hasWinner()) {
            return ScorePrinter.printWinner(getPlayerWithHighestScore());
        }
        if (isAdvantage()) {
            return ScorePrinter.printAdvantage(getPlayerWithHighestScore());
        }
        if (isDeuce()) {
            return ScorePrinter.printDeuce();
        }
        return ScorePrinter.printStandardScore(playerOne, getPlayerOneScore(), playerTwo, getPlayerTwoScore());
    }

    private boolean hasWinner() {
        return Math.max(getPlayerOneScore(), getPlayerTwoScore()) > MIN_GAME_POINTS
                && Math.abs(getPlayerOneScore() - getPlayerTwoScore()) >= 2;
    }

    private boolean isAdvantage() {
        return getPlayerOneScore() >= MIN_GAME_POINTS
                && getPlayerTwoScore() >= MIN_GAME_POINTS
                && Math.abs(getPlayerOneScore() - getPlayerTwoScore()) == 1;
    }

    private boolean isDeuce() {
        return getPlayerOneScore() == getPlayerTwoScore()
                && getPlayerOneScore() >= MIN_GAME_POINTS;
    }

    private Player getPlayerWithHighestScore() {
        return getPlayerOneScore() > getPlayerTwoScore()
                ? playerOne
                : playerTwo;
    }

    private int getPlayerOneScore() {
        return scoreBoard.get(playerOne);
    }

    private int getPlayerTwoScore() {
        return scoreBoard.get(playerTwo);
    }
}
