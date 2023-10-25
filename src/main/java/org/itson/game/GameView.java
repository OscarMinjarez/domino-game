package org.itson.game;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Paint;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import org.itson.token.Token;
import org.itson.token.TokenHorVer;
import org.itson.token.TokenPosition;
import org.itson.utils.Vector2;

/**
 *
 * @author arace
 */
public class GameView {

    public GameView() {
    }
    private List<Token> tokens = new ArrayList<>();
    
    protected void onCreate() {
//    super.onCreate();

    tokens = new ArrayList<>();
//    tokens.add(new Token(new Sprite("face1.png"), new Sprite("face2.png"), new Vector2(100, 100), TokenHorVer.HORIZONTAL, TokenPosition.TOP));
//    setContentView(new GameView(this));
}

    public void draw() {
    //    canvas.(Color.WHITE);
    for (Token token : tokens) {
        
    }
}

    public void update() {
        for (Token token : tokens) {
//            token.update();
    }
}

}