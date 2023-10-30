package org.itson.token;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luis-
 */
public class TokenController {

    private static TokenController instance = new TokenController();

    private TokenController() {

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

    public List<Token> generateTokens() throws IOException {
        List<Token> tokens = new ArrayList<>();
        
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                if (i == j) {
                    tokens.add(new MuleToken(i, j));
                }
                
                if (i != j) {
                    tokens.add(new NormalToken(i, j));
                }
            }
        }
        
        if (tokens.size() == 28) {
            System.out.println("Tokens was create.");
        } else {
            System.out.println("We can't create the tokens");
        }
        
        return tokens;
    }
}
