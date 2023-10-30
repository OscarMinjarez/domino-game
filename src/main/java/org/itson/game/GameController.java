
package org.itson.game;

import org.itson.pit.Pit;
import org.itson.room.Room;
import org.itson.token.Token;
import org.itson.token.TokenController;
import org.itson.pit.PitController;

public class GameController {
    private Room room;
    private Token[] tokens;
    private Pit pit;

    public void setRoom(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public void initializeTokens() {
        // Obtener los tokens generados desde TokenController y guardarlos en el arreglo tokens
        TokenController tokenController = TokenController.get();
        tokens = tokenController.generateToken().toArray(new Token[0]);

        
        
        PitController pitController = PitController.get();
        pitController.saveTokensOnPits(tokens);
        
        
    }
}

