package kata.tennis;

import kata.tennis.game.Game;
import kata.tennis.game.Player;

public class Main {

    public static void main(String[] args) {
        Player player1 = new Player("1", "PlayerOne");
        Player player2 = new Player("2", "PlayerTwo");

        Game game = new Game(player1, player2);

        game.addPointForPlayer(player1);
        game.addPointForPlayer(player1);
        game.addPointForPlayer(player1);
        game.addPointForPlayer(player1);

        System.out.println(game.printScore());

    }
}
