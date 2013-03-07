package com.angryian;

import com.angryian.render.RenderLibrary;
import com.angryian.terrain.Platform;
import com.angryian.pc.Character;
import com.angryian.tools.Collision;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 * Created with IntelliJ IDEA.
 * User: ibrown
 * Date: 2/21/13
 * Time: 11:55 AM
 * To change this template use File | Settings | File Templates.
 */

public class MainGame extends BasicGame
{
    Character character = null;
    Image background = null;
    Platform platform = null;
    Platform platform1 = null;
    RenderLibrary renderer = new RenderLibrary();
    Collision collision = new Collision();
    float x = 200f;
    float y = 400f;
    Rectangle rect1;
    Rectangle rect2;

    public MainGame()
    {
        super("Always Sunny");
    }

    @Override
    public void init(GameContainer gc) throws SlickException
    {
        character = new Character(x,y,new Image("/data/guy.png"));
        background = new Image("/data/background.png");
        platform = new Platform(300, 375, new Image("/data/platform.png"));
        platform1 = new Platform(400, 300, new Image("/data/platform.png"));
        character.collision = collision;
        renderer.addToLibrary(character);
        renderer.addToLibrary(platform);
        renderer.addToLibrary(platform1);
        collision.addToLibrary(platform);
        collision.addToLibrary(platform1);
        //rect1 = new Rectangle(0,0,character.image.getWidth(), character.image.getHeight());
        //rect2 = new Rectangle(300, 375, platform.getWidth(), platform.getHeight());
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException
    {
        character.processControls(gc);
        character.update(gc, delta);
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException
    {
        background.draw(0,0,2);
        renderer.drawAll();
    }

    public static void main(String[] args) throws SlickException
    {
        AppGameContainer app = new AppGameContainer(new MainGame());

        app.setDisplayMode(700, 500, false);
        app.start();
    }
}