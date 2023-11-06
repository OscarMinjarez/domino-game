package org.itson.token;

import java.io.IOException;

/**
 *
 * @author luis-
 */
public class TokenController {
    private Token token;
    private TokenView tokenView;
    
    public TokenController() {
    }
    
    public void createToken(int value1, int value2) throws IOException {
        try {
            if (value1 == value2) {
                this.token = new MuleToken(value1, value2);
            }
            
            if (value1 != value2) {
                this.token = new NormalToken(value1, value2);
            }
            
            this.tokenView = new TokenView(this.token);
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }

    public TokenView getTokenView() {
        return this.tokenView;
    }

    public void rotateToken() {
        TokenHorVer currentOrientation = this.token.getTokenHorVer();
        
        if (currentOrientation == TokenHorVer.HORIZONTAL) {
            this.token.setTokenHorVer(TokenHorVer.VERTICAL);
            this.swapValuesAndPositions(this.token.getFaces()[0], this.token.getFaces()[1], TokenPosition.LEFT, TokenPosition.RIGHT);
        } else {
            this.token.setTokenHorVer(TokenHorVer.HORIZONTAL);
            this.swapValuesAndPositions(this.token.getFaces()[0], this.token.getFaces()[1], TokenPosition.TOP, TokenPosition.BOTTOM);
        }
    }

    private void swapValuesAndPositions(Token.Face face1, Token.Face face2, TokenPosition newPosition1, TokenPosition newPosition2) {
        int tempValue = face1.getValue();
        face1.setValue(face2.getValue());
        face2.setValue(tempValue);
        
        face1.setTokenPosition(newPosition1);
        face2.setTokenPosition(newPosition2);
    }
    
    public Token getToken() {
        return this.token;
    }
    
    public void setTokenView(TokenView tokenView) {
        this.tokenView = tokenView;
    }
}
