package com.angryian.tools;

import com.angryian.entity.BaseObject;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: ibrown
 * Date: 3/6/13
 * Time: 1:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class Collision {
    public ArrayList<BaseObject> arr = new ArrayList<BaseObject>();
    public Collision(){

    }
    public void addToLibrary(BaseObject obj){
          arr.add(obj);
    }
}
