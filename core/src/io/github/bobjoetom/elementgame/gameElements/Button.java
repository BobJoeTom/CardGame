package io.github.bobjoetom.elementgame.gameElements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import io.github.bobjoetom.elementgame.Game;

/**
 * Created by Brenden on 4/17/2016.
 */
public class Button {

    private int WIDTH;
    private int HEIGHT;

    private  String texturePath;
    private  String selectedTexturePath;

    private Texture renderedButton;
   // private Vector2 truePosistion = new Vector2(0f,0f);//FIX
    private Vector2 renderPosistion = new Vector2(0f,0f);//FIX

    private boolean selected = false;
    private boolean visible = false;

    public boolean isVisible() {return visible;}
    public void setVisible(boolean visible) {this.visible = visible;}

    public void render(SpriteBatch sb){
        if(visible)sb.draw(renderedButton, (renderPosistion.x - (WIDTH/2)), (renderPosistion.y - (HEIGHT/2)), WIDTH, HEIGHT);
    }

    public void update(){
    }

    public int getHEIGHT() {return HEIGHT;}
    public void setHEIGHT(int HEIGHT) {this.HEIGHT = HEIGHT;}

    public int getWIDTH() {return WIDTH;}
    public void setWIDTH(int WIDTH) {this.WIDTH = WIDTH;}

    //public Vector2 getTruePosistion() { return truePosistion; }
    public Vector2 getRenderPosistion() { return renderPosistion; }

    //public void setTruePosistion(Vector2 coords){ truePosistion.set(coords); }
    public void setRenderPosistion(Vector2 coords) { renderPosistion.set(coords); }

    public boolean isSelected(){
        return selected;
    }
    public void setSelected(boolean b){
        selected = b;
    }

    public void select(){
        if(isSelected()==true){
            setSelected(false);
            setRenderedButton(getSelectedTexturePath());
        }else if(isSelected()==false){
            setSelected(true);
            setRenderedButton(getTexturePath());
        }
    }

    public String getSelectedTexturePath() {return selectedTexturePath;}
    public void setSelectedTexturePath(String selectedTexturePath) {this.selectedTexturePath = selectedTexturePath;}

    public String getTexturePath() {return texturePath;}
    public void setTexturePath(String texturePath) {this.texturePath = texturePath;}

    public Texture getRenderedButton() {return renderedButton;}
    public void setRenderedButton(Texture renderedButton) {
        this.renderedButton = renderedButton;
    }
    public void setRenderedButton(String renderedButton) {
        this.renderedButton = new Texture(renderedButton);
    }

    //////////////MAYBE HAVE ENABLED TO CLICK AND THE ENABLED BELOW TO A CLICK ENABLE, MIGHT BE EASIER FOR LOGIC
    private int enabledCounter = 0;
    private boolean enabled = true;

    public int getEnabledCounter() {
        return enabledCounter;
    }

    public void setEnabledCounter(int enabledCounter) {
        this.enabledCounter = enabledCounter;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void checkClicked (float ix, float iy) {
        iy = Game.HEIGHT - iy;
        if (ix > getRenderPosistion().x-WIDTH/2 && ix < (getRenderPosistion().x + WIDTH/2)){
            //if (ix > getRenderPosistion().x && ix < (getRenderPosistion().x + WIDTH)){
            if (iy > getRenderPosistion().y - HEIGHT/2 && iy < (getRenderPosistion().y + HEIGHT/2)) {
                // if (iy > getRenderPosistion().y && iy < (getRenderPosistion().y + HEIGHT)) {
                if(isEnabled() == true) {
                    System.out.println("Button clicked!!!");
                    System.out.println(Gdx.input.getX() + " " + Gdx.input.getY());
                    System.out.println(renderPosistion.x + " " + renderPosistion.y);
                    select();
                }else if(getEnabledCounter()%5==0){
                    setEnabled(true);
                }else{
                    setEnabledCounter(getEnabledCounter()+1);
                    System.out.println("Not Enabled");
                }
            }
        }
        System.out.println("NO CARD HERE");
    }

    public boolean checkIfClicked (float ix, float iy) {
        iy = Game.HEIGHT - iy;
        if (ix > getRenderPosistion().x-WIDTH/2 && ix < (getRenderPosistion().x + WIDTH/2)){
            //if (ix > getRenderPosistion().x && ix < (getRenderPosistion().x + WIDTH)){
            if (iy > getRenderPosistion().y - HEIGHT/2 && iy < (getRenderPosistion().y + HEIGHT/2)) {
                // if (iy > getRenderPosistion().y && iy < (getRenderPosistion().y + HEIGHT)) {
                if(isEnabled() == true) {
                    System.out.println("Button clicked!!!");
                    System.out.println(Gdx.input.getX() + " " + Gdx.input.getY());
                    System.out.println(renderPosistion.x + " " + renderPosistion.y);
                    return true;
                }else if(getEnabledCounter()%5==0){
                    setEnabled(true);
                }else{
                    setEnabledCounter(getEnabledCounter()+1);
                    System.out.println("Not Enabled");
                }
            }
        }
        System.out.println("NO CARD HERE");
        return false;
    }

    public void checkClicked () {
        if(Gdx.input.justTouched()) {
            int iy = Gdx.input.getY();
            int ix = Gdx.input.getY();
            iy = Game.HEIGHT - iy;
            if (ix > getRenderPosistion().x - WIDTH / 2 && ix < (getRenderPosistion().x + WIDTH / 2)) {
                //if (ix > getRenderPosistion().x && ix < (getRenderPosistion().x + WIDTH)){
                if (iy > getRenderPosistion().y - HEIGHT / 2 && iy < (getRenderPosistion().y + HEIGHT / 2)) {
                    // if (iy > getRenderPosistion().y && iy < (getRenderPosistion().y + HEIGHT)) {
                    if (isEnabled() == true) {
                        System.out.println("Button clicked!!!");
                        System.out.println(Gdx.input.getX() + " " + Gdx.input.getY());
                        System.out.println(renderPosistion.x + " " + renderPosistion.y);
                        select();
                    } else if (getEnabledCounter() % 5 == 0) {
                        setEnabled(true);
                    } else {
                        setEnabledCounter(getEnabledCounter() + 1);
                        System.out.println("Not Enabled");
                    }
                }
            }
            System.out.println("NO CARD HERE");
        }
    }

    public boolean checkIfClicked () {
        if(Gdx.input.justTouched()) {
            int iy = Gdx.input.getY();
            int ix = Gdx.input.getY();
            iy = Game.HEIGHT - iy;
            if (ix > getRenderPosistion().x - WIDTH / 2 && ix < (getRenderPosistion().x + WIDTH / 2)) {
                //if (ix > getRenderPosistion().x && ix < (getRenderPosistion().x + WIDTH)){
                if (iy > getRenderPosistion().y - HEIGHT / 2 && iy < (getRenderPosistion().y + HEIGHT / 2)) {
                    // if (iy > getRenderPosistion().y && iy < (getRenderPosistion().y + HEIGHT)) {
                    if (isEnabled() == true) {
                        System.out.println("Button clicked!!!");
                        System.out.println(Gdx.input.getX() + " " + Gdx.input.getY());
                        System.out.println(renderPosistion.x + " " + renderPosistion.y);
                        return true;
                    } else if (getEnabledCounter() % 5 == 0) {
                        setEnabled(true);
                    } else {
                        setEnabledCounter(getEnabledCounter() + 1);
                        System.out.println("Not Enabled");
                    }
                }
            }
            System.out.println("NO CARD HERE");
        }
        return false;
    }
}
