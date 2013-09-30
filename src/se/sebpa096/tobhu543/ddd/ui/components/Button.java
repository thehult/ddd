package se.sebpa096.tobhu543.ddd.ui.components;

import org.newdawn.slick.*;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.ui.listeners.ButtonMouseListener;
import se.sebpa096.tobhu543.ddd.ui.listeners.MouseListener;


public class Button extends Component {
    private Image standardImage = null;
    private Image hoverImage = null;
    private Image clickedImage = null;
    private Image currentImage = null;
    private String label;
    private MouseListener mouseListener;
    private float labelOffsetX;
    private float labelOffsetY;
    private Font font;

    public Button(String label, Image standardImage) {
        super();
        this.font = (Font)GlobalResources.getResource("font", "menuFont");
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

    public Button( String label) throws SlickException {
        this(label, (Image)GlobalResources.getResource("buttonImage", "defaultStandard"));
        this.hoverImage = (Image)GlobalResources.getResource("buttonImage", "defaultHover");
        this.clickedImage = (Image)GlobalResources.getResource("buttonImage", "defaultClicked");
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

    public void setStandardImage(Image standardImage) {
        this.standardImage = standardImage;
    }

    public Image getHoverImage() {
        return hoverImage;
    }

    public void setHoverImage(Image hoverImage) {
        this.hoverImage = hoverImage;
    }

    public Image getClickedImage() {
        return clickedImage;
    }

    public void setClickedImage(Image clickedImage) {
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
        getCurrentImage().draw(getRenderX(),
                getRenderY(),
                getWidth(),
                getHeight());
        font.drawString(getRenderX() + getLabelOffsetX(),
                getRenderY() + getLabelOffsetY(),
                this.getLabel());
    }

    private void updateLabelOffset() {
        this.labelOffsetX = (this.getWidth() - font.getWidth(this.getLabel())) / 2;
        this.labelOffsetY = (this.getHeight() - font.getHeight(this.getLabel())) / 2;
    }

    private float getLabelOffsetX() {
        return this.labelOffsetX;
    }

    private float getLabelOffsetY() {
        return this.labelOffsetY;
    }

    @Override
    public void updateRenderPos() {
        super.setRenderX(this.getX() + this.getParentUI().getX());
        super.setRenderY(this.getY() + this.getParentUI().getY());
        updateLabelOffset();
    }

}
