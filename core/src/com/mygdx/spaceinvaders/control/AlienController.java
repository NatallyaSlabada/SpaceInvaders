package com.mygdx.spaceinvaders.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.mygdx.spaceinvaders.view.GameScreen;

public class AlienController {
    private Polygon alienBounds;

    public AlienController(Polygon alienBounds){
        this.alienBounds = alienBounds;
    }
    private float alienSpeed;
    private float speedVelocity = 10f;
    private float speedMAX = 10f;
    private float rotationSpeed = 30f;

    public void handle(){
        //Up-Down movement and speed
        if (Gdx.input.isKeyPressed(Input.Keys.UP)){
            alienSpeed += speedVelocity * GameScreen.deltaCff;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            alienSpeed -= speedVelocity * GameScreen.deltaCff;
        }
        else {
           downSpeed();
        }
        alienSpeed = sliceSpeed();

        //Rotation
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            alienBounds.rotate(rotationSpeed* alienSpeed *GameScreen.deltaCff);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            alienBounds.rotate(-rotationSpeed* alienSpeed *GameScreen.deltaCff);
        }

        alienBounds.setPosition(
                alienBounds.getX() + MathUtils.cosDeg(alienBounds.getRotation()+90)* alienSpeed *GameScreen.deltaCff,
                alienBounds.getY() + MathUtils.sinDeg(alienBounds.getRotation()+90)* alienSpeed *GameScreen.deltaCff
        );
    }
    private void downSpeed (){
        if (alienSpeed > speedVelocity * GameScreen.deltaCff){
            alienSpeed -= speedVelocity * GameScreen.deltaCff;
        }
        else if (alienSpeed < -speedVelocity * GameScreen.deltaCff){
            alienSpeed += speedVelocity * GameScreen.deltaCff;
        }
        else alienSpeed = 0f;
    }
    private float sliceSpeed (){
        if (alienSpeed > speedMAX){
            return speedMAX;
        }
        else if (alienSpeed < -speedMAX){
            return -speedMAX;
        }
        else return alienSpeed;
    }
}
