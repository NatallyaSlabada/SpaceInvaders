package com.mygdx.spaceinvaders.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.spaceinvaders.model.Alian;

public class GameScreen implements Screen {
    private Texture alianTexture;
    private SpriteBatch batch;
    private Alian alian;


    @Override
    public void show() {
        batch = new SpriteBatch();
        alianTexture = new Texture(Gdx.files.internal("invaders.png"));
        alian = new Alian(alianTexture,30 , 30, 200, 200);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0 ,0 ,1 );
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        alian.draw(batch);

        batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        alianTexture.dispose();
        batch.dispose();
    }
}
