
import java.io.IOException;
import java.util.List;
import org.itson.engine.ControllerFactory;
import org.itson.game.Game;
import org.itson.game.GameController;
import org.itson.pit.Pit;
import org.itson.player.Player;
import org.itson.room.Room;
import org.itson.token.Token;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author oscar
 */
public class Pruebas {
    public static void main(String[] args) {
        try {
            GameController gameController = ControllerFactory.getGameController();
            gameController.createGame();
            gameController.createRoom();
            gameController.createPit();
            
            Game game = gameController.getGame();
            Room room = gameController.getRoom();
            Pit pit = gameController.getPit();
            
            Player player1 = gameController.createPlayer("Oscar");
            Player player2 = gameController.createPlayer("Aracely");
            Player player3 = gameController.createPlayer("Martin");
            Player player4 = gameController.createPlayer("Hector");
            
            gameController.addPlayerToTheRoom(player1);
            gameController.addPlayerToTheRoom(player2);
            gameController.addPlayerToTheRoom(player3);
//            gameController.addPlayerToTheRoom(player4);
            
            gameController.setGameInTheRoom(game);
            System.out.println(room);
            System.out.println(gameController.getGame());
            
            List<Token> tokens = gameController.generateTokens();
            gameController.saveTokensInThePit(tokens);
            System.out.println("Total tokens generated on the pit: " + gameController.getTokensFromPit().size());
            
            gameController.dealTokens(gameController.getPlayers(), 7);
            System.out.println("Total players on the game: " + gameController.getPlayers().size());
            System.out.println("Total tokens on the pit: " + gameController.getTokensFromPit().size());
            
            System.out.println("First mule token: " + gameController.getBiggestMuleTokenFromPlayers(gameController.getPlayers()));            
            
            for (Player player : gameController.getPlayers()) {
                System.out.println("Total tokens for " + player.getName() + ": " + player.getTokens().size());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
