package com.angryian.entity;

/**
 * Created with IntelliJ IDEA.
 * User: ibrown
 * Date: 3/2/13
 * Time: 12:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class Mob extends BaseObject
{
    public int STATE = 0;
    public final int IDLE = 0;
    public final int WALK = 1;
    public final int RUN = 2;
    public final int JUMP = 3;
    public final int ATTACK = 4;

    public float lift = 0;

    public Mob(){

    }

}
