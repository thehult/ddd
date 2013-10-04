package se.sebpa096.tobhu543.ddd.ui.components;

import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import se.sebpa096.tobhu543.ddd.resources.FontResources;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.ui.UI;

public class Label extends Component {
    private String text;
    private Font font;

    public Label(String text) {
        this(text, 0, 0);
    }

    public Label(String text, int x, int y) {
        super();
        this.setText(text);
        this.setX(x);
        this.setY(y);
        this.font = (Font)GlobalResources.getResource(GlobalResources.FONT_RESOURCES, FontResources.MENU_FONT);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) {
        graphics.setFont(this.font);
        graphics.drawString(text,
               getRenderX(),
               getRenderY());
        graphics.resetFont();
    }

    @Override
    public void updateRenderPos() {
        this.setRenderX(this.getX() + this.getParentUI().getX() + (this.getWidth() - font.getWidth(this.getText())) / 2);
        this.setRenderY(this.getY() + this.getParentUI().getY() + (this.getHeight() - font.getHeight(this.getText())) / 2);
    }
}
