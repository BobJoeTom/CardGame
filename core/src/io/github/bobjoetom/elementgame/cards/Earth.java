package io.github.bobjoetom.elementgame.cards;

/**
 * Created by Brenden on 4/16/2016.
 */
public class Earth extends Card {

    public Earth() {
        super();
        setID("Earth");
        setCardTexturePath("earth.png");
        setCardSelectedTexturePath("earth-Selected.png");
        setRenderedCard(getCardTexturePath());
    }

    @Override
    public boolean isCombinable(Card e) {

        if(e.getID()=="Fire"){
            return true;
        }
        return false;
    }

    @Override
    public Card combine(Card e) {
        if(e.getID()=="Fire"){
            return new Smeltery();
        }
        return new Card();
    }
}
