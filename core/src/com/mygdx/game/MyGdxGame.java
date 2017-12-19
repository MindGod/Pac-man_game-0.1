package com.mygdx.game;

import ExternalLib.GifDecoder;

import com.badlogic.gdx.Input.Keys;

import java.util.Random;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Animation<TextureRegion> animation;
	ShapeRenderer shape;
	Color color;
	Map map;
	Line[] line = new Line[4];
	float elapsed;
	float x;
	float y;

	@Override
	public void create() {
		batch = new SpriteBatch();
		map = new Map();
		map.create();
		animation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP,Gdx.files.internal("Pac-man/Pac-man_avatar_down.gif").read());
		shape = new ShapeRenderer();

		line[0] = new Line();
		line[0].create(200, 300, 200, 200);
		
		line[1] = new Line();
		line[1].create(300, 300, 300, 200);
		
		line[2] = new Line();
		line[2].create(300, 200, 300, 300);
		
		line[3] = new Line();
		line[3].create(200, 200, 300, 200);
		
		

		x = 10;
		y = 0;

	}

	public void update() {

		if (Gdx.input.isKeyPressed(Keys.D)) {
			animation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP,
					Gdx.files.internal("Pac-man/Pac-man_avatar_right.gif").read());
			x += 3.5;
		}
		if (Gdx.input.isKeyPressed(Keys.A)) {
			animation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP,
					Gdx.files.internal("Pac-man/Pac-man_avatar_left.gif").read());
			x -= 3.5;
		}
		if (Gdx.input.isKeyPressed(Keys.W)) {
			y += 3.5;
			animation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP,
					Gdx.files.internal("Pac-man/Pac-man_avatar_up.gif").read());
		}
		if (Gdx.input.isKeyPressed(Keys.S)) {
			y -= 3.5;
			animation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP,
					Gdx.files.internal("Pac-man/Pac-man_avatar_down.gif").read());
		}
	}

	@Override
	public void render() {
		update();

		elapsed += Gdx.graphics.getDeltaTime();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		map.render();
		batch.begin();
		batch.draw(animation.getKeyFrame(elapsed), x, y);
		batch.end();
		
		line[0].render();
		line[1].render();
		line[2].render();
		line[3].render();
	}

	@Override
	public void dispose() {
		batch.dispose();
		shape.dispose();
		map.dispose();
	}
}