package se.sebpa096.tobhu543.ddd.ui.components;

import org.newdawn.slick.*;
import se.sebpa096.tobhu543.ddd.resources.ButtonImageResources;
import se.sebpa096.tobhu543.ddd.resources.FontResources;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.ui.listeners.ButtonMouseListener;
import se.sebpa096.tobhu543.ddd.ui.listeners.MouseListener;


/**
 * A Button Component. Used for clicking. Or ignoring. Mostly clicking.
 */
public class Button extends Component {

    private Image standardImage = null;
    private Image hoverImage = null;
    private Image clickedImage = null;
    private Image currentImage = null;
    private String label = "";
    private MouseListener mouseListener;
    private float labelOffsetX;
    private float labelOffsetY;
    private Font font;

    public Button(String label, Image standardImage) {
	this.font = (Font)GlobalResources.getResource(GlobalResources.FONT_RESOURCES, FontResources.MENU_FONT);
        setLabel(label);
        this.standardImage = standardImage;
        this.currentImage = standardImage;
        this.setWidth(standardImage.getWidth());
        this.setHeight(standardImage.getHeight());
        this.mouseListener = new ButtonMouseListener(this);
    }

    public Button(String label, Image standardImage, Image hoverImage, Image clickedImage) {
        this(label, standardImage);
        this.hoverImage = hoverImage;
        this.clickedImage = clickedImage;
    }

    @SuppressWarnings("UnusedDeclaration") public Button( String label) {
        this(label, (Image)GlobalResources.getResource(GlobalResources.BUTTON_RESOURCES, ButtonImageResources.DEFAULT_STANDARD));
        this.hoverImage = (Image)GlobalResources.getResource(GlobalResources.BUTTON_RESOURCES, ButtonImageResources.DEFAULT_HOVER);
        this.clickedImage = (Image)GlobalResources.getResource(GlobalResources.BUTTON_RESOURCES, ButtonImageResources.DEFAULT_CLICKED);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
        updateLabelOffset();
    }

    public Image getStandardImage() {
        return standardImage;
    }

    @SuppressWarnings("UnusedDeclaration") public void setStandardImage(Image standardImage) {
        this.standardImage = standardImage;
    }

    public Image getHoverImage() {
        return hoverImage;
    }

    @SuppressWarnings("UnusedDeclaration") public void setHoverImage(Image hoverImage) {
        this.hoverImage = hoverImage;
    }

    public Image getClickedImage() {
        return clickedImage;
    }

    @SuppressWarnings("UnusedDeclaration") public void setClickedImage(Image clickedImage) {
        this.clickedImage = clickedImage;
    }

    public Image getCurrentImage() {
        return currentImage;
    }

    public void setCurrentImage(Image currentImage) {
        this.currentImage = currentImage;
    }


    public MouseListener getMouseListener() {
        return mouseListener;
    }

    public void setMouseListener(MouseListener mouseListener) {
        this.mouseListener = mouseListener;
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) {
	currentImage.draw(getRenderX(), getRenderY(), getWidth(), getHeight());
        font.drawString(getRenderX() + labelOffsetX,
                getRenderY() + labelOffsetY, this.label);
    }

    private void updateLabelOffset() {
        this.labelOffsetX = (this.getWidth() - font.getWidth(this.label)) / 2;
        this.labelOffsetY = (this.getHeight() - font.getHeight(this.label)) / 2;
    }

    private float getLabelOffsetX() {
        return this.labelOffsetX;
    }

    private float getLabelOffsetY() {
        return this.labelOffsetY;
    }

    @Override
    public void updateRenderPos() {
        setRenderX(this.getX() + this.getParentUI().getX());
        setRenderY(this.getY() + this.getParentUI().getY());
        updateLabelOffset();
    }

}
