package com.mygdx.spaceinvaders.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;


public abstract class GameObject {
    Rectangle bounds;
    Sprite spriteObject;

    public GameObject (Texture texture, float x, float y, float width, float height){
        bounds = new Rectangle(x,y,width,height);
        spriteObject = new Sprite(texture );
    }

    public void draw (SpriteBatch batch){
        spriteObject.setBounds(bounds.getX(),bounds.getY(),bounds.getWidth() ,bounds.getHeight() );
        spriteObject.draw(batch);

    }
}
