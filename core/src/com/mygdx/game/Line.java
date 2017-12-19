package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;

public class Line {
	ShapeRenderer shape;
	Color color;
	Vector2 v1, v2;
	float x1, y1, x2, y2;

	public void create(float x1, float x2, float y1, float y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	    shape = new ShapeRenderer();
		v1 = new Vector2(x1, y1);
		v2 = new Vector2(x2, y2);
		color = Color.BLUE;
		
	}

	public void update() {
		
	}

	public void render() {
		update();
		
		shape.begin(ShapeType.Line);
		shape.setColor(color);
		shape.line(v1, v2);
		shape.end();
	}

	public void dispose() {
		shape.dispose();
	}
}