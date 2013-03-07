package com.angryian.render;

import com.angryian.entity.BaseObject;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: ibrown
 * Date: 3/4/13
 * Time: 12:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class RenderLibrary {
    ArrayList<BaseObject> arr = new ArrayList<BaseObject>();
    public RenderLibrary(){
    }
    public void addToLibrary(BaseObject obj){
          arr.add(obj);
    }
    public void drawAll(){
        for(BaseObject obj : arr){
            obj.baseImage.draw(Math.round(obj.x),Math.round(obj.y),1);
        }
    }
}
