
import java.io.IOException;
import java.util.List;
import org.itson.board.Board;
import org.itson.engine.ControllerFactory;
import org.itson.game.Game;
import org.itson.game.GameController;
import org.itson.pit.Pit;
import org.itson.player.Player;
import org.itson.room.Room;
import org.itson.token.MuleToken;
import org.itson.token.Token;
import org.itson.token.TokenComponent;
import org.itson.token.TokenManager;


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
            gameController.createBoard();
            
            Game game = gameController.getGame();
            Room room = gameController.getRoom();
            Pit pit = gameController.getPit();
            Board board = gameController.getBoard();
            
            Player player1 = gameController.createPlayer("Oscar");
            Player player2 = gameController.createPlayer("Aracely");
            Player player3 = gameController.createPlayer("Martin");
//            Player player4 = gameController.createPlayer("Hector");
            
            gameController.addPlayerToTheRoom(player1);
            gameController.addPlayerToTheRoom(player2);
            gameController.addPlayerToTheRoom(player3);
            // gameController.addPlayerToTheRoom(player4);
            
            gameController.setGameInTheRoom(game);
            System.out.println(room);
            System.out.println(gameController.getGame());
            gameController.generateTokens();
            gameController.saveTokensInThePit(gameController.getTokensComponents());
            System.out.println("Total tokens generated on the pit: " + gameController.getTokensFromPit().size());
            
            gameController.dealTokens(gameController.getPlayers(), 7);
            System.out.println("Total players on the game: " + gameController.getPlayers().size());
            System.out.println("Total tokens on the pit: " + gameController.getTokensFromPit().size());
            
            MuleToken firstMuleToken = gameController.getBiggestMuleTokenFromPlayers(gameController.getPlayers());
            System.out.println("Biggest mule token: " + firstMuleToken);            
            
            for (Player player : gameController.getPlayers()) {
                System.out.println("Total tokens for " + player.getName() + ": " + player.getTokens().size());
            }
            
            System.out.println("Tokens on the board after putting the biggest mule token: ");
            gameController.putTokenOnBoard(firstMuleToken);
            System.out.println("Total tokens on the board: " + gameController.getTokensFromTheBoard().size());
            System.out.println("Total tokens on the pit: " + gameController.getTokensFromPit().size());
            
            gameController.setInPlayers(gameController.getPlayers());
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }   
}
