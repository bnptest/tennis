package kata.tennis.game;

import java.util.HashMap;
import java.util.Map;

public class ScorePrinter {

    private static final String LOVE = "Love";
    private static final String FIFTEEN = "Fifteen";
    private static final String THIRTY = "Thirty";
    private static final String FORTY = "Forty";

    private static final String SCORE_DEUCE = "DEUCE";
    private static final String SCORE_GAME_WON_TEMPLATE = "%s WON";
    private static final String SCORE_ADVANTAGE_TEMPLATE = "%s ADVANTAGE";
    private static final String SCORE_REGULAR_TEMPLATE = "%s %s - %s %s";

    private static final Map<Integer, String> scoreAliases = new HashMap<>();

    static {
        scoreAliases.put(0, LOVE);
        scoreAliases.put(1, FIFTEEN);
        scoreAliases.put(2, THIRTY);
        scoreAliases.put(3, FORTY);
    }

    public static String printWinner(Player winner) {
        return String.format(SCORE_GAME_WON_TEMPLATE,
                winner.getName());
    }


    public static String printAdvantage(Player leadingPlayer) {
        return String.format(SCORE_ADVANTAGE_TEMPLATE,
                leadingPlayer.getName());
    }

    public static String printDeuce() {
        return SCORE_DEUCE;
    }

    public static String printStandardScore(Player playerOne, int playerOneScore, Player playerTwo, int playerTwoScore) {
        return String.format(SCORE_REGULAR_TEMPLATE,
                playerOne.getName(),
                getScorePointsAlias(playerOneScore),
                getScorePointsAlias(playerTwoScore),
                playerTwo.getName());
    }

    private static String getScorePointsAlias(int points) {
        if (!scoreAliases.containsKey(points)) {
            throw new IllegalArgumentException("invalid score points");
        }
        return scoreAliases.get(points);
    }
}
