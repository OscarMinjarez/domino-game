package org.itson.token;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import org.itson.model.domain.Entity;
import org.itson.utils.Vector2;

public class Token extends Entity {

    private Face[] faces;
    private Vector2 position;
    private TokenHorVer tokenHorVer;

    public Token(int value1, int value2) throws IOException {
        this.faces = new Face[2];
        
        try {
            this.faces[0] = new Face(value1);
            this.faces[1] = new Face(value2);
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }
    
    public Token(int value1, int value2, Vector2 position, TokenHorVer tokenHorVer, TokenPosition tokenPosition) throws IOException {
        this.faces = new Face[2];
        
        try {
            this.faces[0] = new Face(value1, tokenPosition);
            this.faces[1] = new Face(value2, tokenPosition);
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
        
        this.position = position;
        this.tokenHorVer = tokenHorVer;
    }


    public class Face {

        private int value;
        private TokenPosition tokenPosition;
        private BufferedImage image;

        public Face(int value) throws IOException {
            this.value = value;
            
            this.image = ImageIO.read(getClass().getResource("/assets/sprites/" + this.value + ".jpg"));
        }
        
        public Face(int value, TokenPosition tokenPosition) throws IOException {
            this.value = value;
            this.tokenPosition = tokenPosition;
            
            this.image = ImageIO.read(getClass().getResource("/assets/sprites/" + this.value + ".jpg"));
        }

        public Face() {

        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setTokenPosition(TokenPosition tokenPosition) {
            this.tokenPosition = tokenPosition;
        }

        @Override
        public String toString() {
            return "Face{" + "value=" + value + ", tokenPosition=" + tokenPosition + ", image=" + image + '}';
        }
    }

    public Face[] getFaces() {
        return faces;
    }

    public void setFaces(Face[] faces) {
        this.faces = faces;
    }

    public TokenHorVer getTokenHorVer() {
        return tokenHorVer;
    }

    public void setTokenHorVer(TokenHorVer tokenHorVer) {
        this.tokenHorVer = tokenHorVer;
    }

    public void setTokenPosition(TokenPosition tokenPosition) {
        this.faces[0].setTokenPosition(tokenPosition);

        if (tokenHorVer == TokenHorVer.HORIZONTAL) {
            if (tokenPosition == TokenPosition.TOP) {
                this.faces[1].setTokenPosition(TokenPosition.RIGHT);
            } else if (tokenPosition == TokenPosition.BOTTOM) {
                this.faces[1].setTokenPosition(TokenPosition.LEFT);
            }
        } else {
            if (tokenPosition == TokenPosition.LEFT) {
                this.faces[1].setTokenPosition(TokenPosition.TOP);
            } else if (tokenPosition == TokenPosition.RIGHT) {
                this.faces[1].setTokenPosition(TokenPosition.BOTTOM);
            }
        }
    }

    @Override
    public String toString() {
        return "Token{" + "faces=" + Arrays.toString(faces) + ", position=" + position + ", tokenHorVer=" + tokenHorVer + '}';
    }
}
