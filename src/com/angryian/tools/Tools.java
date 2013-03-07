package com.angryian.tools;
import org.newdawn.slick.geom.Rectangle;
/**
 * Created with IntelliJ IDEA.
 * User: ibrown
 * Date: 3/1/13
 * Time: 11:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class Tools {
    public boolean collisionCheck(Rectangle rect1, Rectangle rect2){
        return rect1.intersects(rect2);
    }
}
