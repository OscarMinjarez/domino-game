
package org.itson.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.itson.model.domain.Token;
import org.itson.model.enums.TokenHorVer;
import org.itson.model.enums.TokenPosition;

/**
 *
 * @author luis-
 */
public class TokenController {
    
    private static TokenController instance = new TokenController();
    
    private TokenController(){
        
    }
    
    public static TokenController get() {
        if (instance == null) {
            instance = new TokenController();
        }
        return instance;
    }
    
    private void swapValuesBetweenFaces(Token.Face face1, Token.Face face2) {
    int tempValue = face1.getValue();
    face1.setValue(face2.getValue());
    face2.setValue(tempValue);
}

public void rotateToken(Token token) {
    if (token.getTokenHorVer() == TokenHorVer.HORIZONTAL) {
        token.setTokenHorVer(TokenHorVer.VERTICAL);

        // Cambiar las posiciones de las caras cuando el token es horizontal
        token.getFaces()[0].setTokenPosition(TokenPosition.LEFT);
        token.getFaces()[1].setTokenPosition(TokenPosition.RIGHT);

        // Intercambiar los valores de las caras
        swapValuesBetweenFaces(token.getFaces()[0], token.getFaces()[1]);
    } else {
        token.setTokenHorVer(TokenHorVer.HORIZONTAL);

        // Cambiar las posiciones de las caras cuando el token es vertical
        token.getFaces()[0].setTokenPosition(TokenPosition.TOP);
        token.getFaces()[1].setTokenPosition(TokenPosition.BOTTOM);

        // Intercambiar los valores de las caras
        swapValuesBetweenFaces(token.getFaces()[0], token.getFaces()[1]);
    }
}

    public List<Token> generateToken() {
        List<Token> tiles = new ArrayList<>();
        Map<String, Token> uniqueToken = new HashMap<>();
        
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
//                Token newToken = new Token(Aqui deberia de establecerse los sprites de las imagenes );
                String tileKey = i + "-" + j; 

                if (!uniqueToken.containsKey(tileKey)) {
//                    uniqueToken.put(tileKey, newToken);
//                    tiles.add(newToken);
                }
            }
        }

        if (tiles.size() != 28) {
            throw new RuntimeException("ERROR: No se generaron las fichas correctamente.");
        }

        return tiles;
    }
}

