package org.itson.view;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Paint;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import org.itson.model.domain.Token;
import org.itson.model.enums.TokenHorVer;
import org.itson.model.enums.TokenPosition;
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
    tokens.add(new Token(new Sprite("face1.png"), new Sprite("face2.png"), new Vector2(100, 100), TokenHorVer.HORIZONTAL, TokenPosition.TOP));
//    setContentView(new GameView(this));
}

    public void draw() {
    //    canvas.(Color.WHITE);
    for (Token token : tokens) {
        token.draw();
    }
}

    public void update() {
        for (Token token : tokens) {
            token.update();
    }
}

}