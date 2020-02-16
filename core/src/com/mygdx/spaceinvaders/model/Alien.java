package com.mygdx.spaceinvaders.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.spaceinvaders.control.AlienController;

public class Alien extends GameObject {
    private AlienController alienController;

    public Alien(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
        alienController = new AlienController(bounds);
    }

    @Override
    public void draw (SpriteBatch batch){
        super.draw(batch);
        alienController.handle();
    }


}
