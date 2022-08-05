package ru.netology.homework14;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Game game = new Game();

    Player player1 = new Player(1, "Igor", 100 );
    Player player2 = new Player(2, "Valera99", 59);
    Player player3 = new Player(3, "Kot", 98);
    Player player4 = new Player(4, "Masha", 98);



    @Test
    public void shouldCompareStrength() {

        game.register(player1);
        game.register(player2);

        int exp = 1;
        int act = game.round(player1.getName(), player2.getName());

        Assertions.assertEquals(exp, act);
    }

    @Test
    public void shouldCompareEqualsStrength() {

        game.register(player3);
        game.register(player4);

        int exp = 0;
        int act = game.round(player3.getName(), player4.getName());

        Assertions.assertEquals(exp, act);
    }

    @Test
    public void shouldCompareStrengthReturn() {
        game.register(player2);
        game.register(player3);

        int exp = 2;
        int act = game.round(player2.getName(), player3.getName());
    }

    @Test
    public void shouldNotRegisteredExceptionPlayer1() {
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player3.getName(), player2.getName());
        });
    }

    @Test
    public void shouldNotRegisteredExceptionPlayer2() {
        Game regPlayers = new Game();
        regPlayers.register(player3);
        regPlayers.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            regPlayers.round(player3.getName(), player1.getName());
        });
    }

    @Test
    public void shouldNotRegisteredExceptionPlayer1AndPlayer2() {
        Game regPlayers = new Game();
        regPlayers.register(player1);
        regPlayers.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            regPlayers.round(player3.getName(), player4.getName());
        });
    }

}
