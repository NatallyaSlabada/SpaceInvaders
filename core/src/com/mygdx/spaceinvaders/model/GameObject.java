package com.mygdx.spaceinvaders.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polygon;

public abstract class GameObject {
    Polygon bounds;
    Sprite spriteObject;

    public GameObject (Texture texture, float x, float y, float width, float height){
        bounds = new Polygon(new float[]{0f, 0f, width, 0f, width, height, 0f, height});
        bounds.setPosition(x,y );
        bounds.setOrigin(width/2f, height/2f);

        spriteObject = new Sprite(texture );
        spriteObject.setSize(width,height );
        spriteObject.setOrigin(width/2f, height/2f);
        spriteObject.setPosition(x,y );

    }

    public void draw (SpriteBatch batch){
        spriteObject.setPosition(bounds.getX(),bounds.getY());
        spriteObject.setRotation(bounds.getRotation());
        spriteObject.draw(batch);

    }

    public Polygon getBounds (){
        return bounds;
    }
}
