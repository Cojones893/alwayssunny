package com.angryian.pc;
import com.angryian.entity.BaseObject;
import com.angryian.entity.Mob;
import com.angryian.tools.Collision;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.Input;

/**
 * Created with IntelliJ IDEA.
 * User: ibrown
 * Date: 3/2/13
 * Time: 12:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class Character extends Mob {
    public Rectangle rect;
    public Collision collision;
    public BaseObject objOn;
    float scale = 1f;
    float lift = 0;
    float gravity = .001f;

    boolean LEFT = false;
    boolean RIGHT = false;
    boolean UP = false;
    boolean DOWN = false;
    boolean flipped = false;
    boolean onObj = false;
    boolean doubleJump = false;
    boolean canDoubleJump = false;
    public Character(float newX, float newY, Image newImage){
        x = newX;
        y = newY;
        setImage(newImage);
    }


    public boolean intersects(Shape shape){
        Rectangle testRect = new Rectangle(x,y,baseImage.getWidth(),baseImage.getHeight());
        return testRect.intersects(shape);
    }
    public void processControls(GameContainer gc){
        Input input = gc.getInput();
        LEFT = input.isKeyDown(Input.KEY_A);
        RIGHT = input.isKeyDown(Input.KEY_D);
        UP = input.isKeyDown(Input.KEY_W);
        DOWN = input.isKeyDown(Input.KEY_S);
    }
    public void update(GameContainer gc, int delta) {
        if(LEFT && !flipped){
            setImage(baseImage.getFlippedCopy(true,false));
            flipped=true;
        }
        if(RIGHT && flipped){
            setImage(baseImage.getFlippedCopy(true,false));
            flipped=false;
        }
        switch (STATE){
            case IDLE:
                idling(delta);
                break;
            case WALK:
                walking(delta);
                break;
            case JUMP:
                jumping(delta);
                break;
            default:
                break;
        }
    }
    public void idling(int delta){
        if(LEFT || RIGHT){
            STATE = WALK;
        }if(UP){
            STATE = JUMP;
            lift = .4f;
        }
    }
    public void walking(int delta){

        if(LEFT){
            x -= .2f * delta;
        }
        else if(RIGHT){
            x += .2f * delta;
        }
        if(UP){
            STATE = JUMP;
            lift = .4f;
        }if(!LEFT && !RIGHT){
            STATE = IDLE;
        }
        if(onObj && !this.intersects(objOn.getAbsoluteRect())){
            onObj=false;
            STATE=JUMP;
            lift=0;
        }
    }

    public void jumping(int delta){
        y -= lift*delta;
        lift -= gravity*delta;
        if(!UP){
            canDoubleJump=true;
        }
        if(lift<0){
            for(BaseObject obj : collision.arr){
                if(this.intersects(obj.getAbsoluteRect()) && y+getRect().getHeight()<obj.y+5){
                    objOn=obj;
                    onObj = true;
                    STATE = IDLE;
                    doubleJump=false;
                    canDoubleJump=false;
                }
            }

        }

        if(UP && canDoubleJump && !doubleJump){
            doubleJump=true;
            lift = .3f;
            canDoubleJump=false;
        }
        if(y>400){
            y=400;
            STATE=IDLE;
            doubleJump=false;
            canDoubleJump=false;
        }
        if(LEFT){
            x -= .2f * delta;
        }
        else if(RIGHT){
            x += .2f * delta;
        }
    }
}
