package com.angryian.terrain;

import com.angryian.entity.BaseObject;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

/**
 * Created with IntelliJ IDEA.
 * User: ibrown
 * Date: 3/4/13
 * Time: 11:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class Platform extends BaseObject{
    public Platform(float newX, float newY, Image newImage){
        x = newX;
        y = newY;
        setImage(newImage);
    }


}
