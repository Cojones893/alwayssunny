package com.angryian.entity;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
/**
 * Created with IntelliJ IDEA.
 * User: ibrown
 * Date: 3/2/13
 * Time: 12:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class BaseObject {
    private Rectangle rect;
    public Image baseImage;
    public float x;
    public float y;
    public BaseObject(){
    }
    public void setRect(Rectangle newRect){
        rect = newRect;
    }
    public Rectangle getRect(){
        return rect;
    }
    public void setImage(Image img){
        baseImage = img;
        rect = new Rectangle(0,0, baseImage.getWidth(), baseImage.getHeight());
    }
    public Rectangle getAbsoluteRect(){
        return new Rectangle(x, y, getRect().getWidth(), getRect().getHeight());
    }
}
