package com.mygdx.spaceinvaders.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.spaceinvaders.model.Alien;

public class GameScreen implements Screen {
    private Texture alienTexture;
    private SpriteBatch batch;
    private Alien alien;
    private OrthographicCamera camera;
    public static float deltaCff;


    @Override
    public void show() {
        batch = new SpriteBatch();
        alienTexture = new Texture(Gdx.files.internal("invaders.png"));
        alienTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        alien = new Alien(alienTexture,0 , 0, 1f, 1f*1.1f);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0 ,0 ,1 );
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        deltaCff = delta;

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        alien.draw(batch);
        batch.end();

    }

    @Override
    public void resize(int width, int height) {
        float aspectRatio = (float) height/width;
        camera = new OrthographicCamera(20f, 20f*aspectRatio);

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
        alienTexture.dispose();
        batch.dispose();
    }
}
