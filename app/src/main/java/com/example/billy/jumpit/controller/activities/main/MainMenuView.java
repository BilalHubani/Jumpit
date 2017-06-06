package com.example.billy.jumpit.controller.activities.main;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

import com.example.billy.jumpit.R;
import com.example.billy.jumpit.controller.activities.Scenes.EndlessScene;
import com.example.billy.jumpit.controller.activities.Scenes.MainMenuBackgroundScene;
import com.example.billy.jumpit.model.BitmapSet;
import com.example.billy.jumpit.model.Bonk;
import com.example.billy.jumpit.model.Character;
import com.example.billy.jumpit.model.DragonBitmapSet;
import com.example.billy.jumpit.model.DragonSkin;
import com.example.billy.jumpit.model.MoconsioBitmapSet;
import com.example.billy.jumpit.model.MoconsioSkin;
import com.example.billy.jumpit.model.PokemonBitmapSet;
import com.example.billy.jumpit.model.RositoBitmapSet;
import com.example.billy.jumpit.model.RositoSkin;
import com.example.billy.jumpit.model.TerrenosBitmapSet;
import com.example.billy.jumpit.model.UserCustomAtributes;

import java.util.List;

/**
 * Created by dam on 20/3/17.
 */

public class  MainMenuView extends View {
    private MainMenuBackgroundScene mainMenuBackgroundScene;
    private MoconsioSkin moconsioSkin;
    private MoconsioBitmapSet moconsioBitmapSet;
    private RositoSkin rositoSkin;
    private RositoBitmapSet rositoBitmapSet;
    private Paint paint;
    private BitmapSet bitmapSet;
    private PokemonBitmapSet pokemonBitmapSet;
    private DragonBitmapSet dragonBitmapSet;
    private TerrenosBitmapSet terrenosBitmapSet;
    private Bonk bonk;
    private DragonSkin dragonSkin;
    private Character character;
    private int vel = 4;
    private int velCounter = 1;
    private boolean paused = false;
    private boolean jump = false;
    private boolean stateJumping = false;
    private int jumpCounter = 0;
    private int jumpIncrement = 2;
    private int jumpMaxHeigh = 70;
    private int jumpAux;
    public MainMenuView(Context context) {
        this(context, null, 0);
    }

    public MainMenuView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MainMenuView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        bitmapSet = new BitmapSet(this.getResources());
        rositoBitmapSet = new RositoBitmapSet(this.getResources());
//        moconsioBitmapSet = new MoconsioBitmapSet(this.getResources());
        terrenosBitmapSet = new TerrenosBitmapSet(this.getResources());
        mainMenuBackgroundScene = new MainMenuBackgroundScene(terrenosBitmapSet);
//        bonk = new Bonk(bitmapSet);
        rositoSkin = new RositoSkin(rositoBitmapSet);
        rositoSkin.setX(20);
//        moconsioSkin = new MoconsioSkin(moconsioBitmapSet);
    }

    @Override
    public void onDraw(Canvas canvas) {
        this.postInvalidateDelayed(1);
        if (bitmapSet == null) return;
        float sc = getHeight() / (16 * 16f);
        canvas.scale(sc, sc);
        if (jump) {
            doGoingUp();
        } else if (!checkGround()) {
            doGoingDown();
        }
        mainMenuBackgroundScene.draw(canvas);
//        bonk.draw(canvas);
        rositoSkin.draw(canvas);
//        moconsioSkin.draw(canvas);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.jumpMaxHeigh = rositoSkin.getJumpMaxHeight();
        if (event.getAction() == MotionEvent.ACTION_DOWN && !stateJumping){
            if (rositoSkin.getFrame() <= 5 ){
                rositoSkin.setFrameCounter(0);
                rositoSkin.setFrame(6);
            }
//            if (dragonSkin.getFrame() <= 3 ){
//                dragonSkin.setFrameCounter(0);
//                dragonSkin.setFrame(4);
//            }
            jump = true;
            stateJumping = true;
        }
        if (event.getAction() == MotionEvent.ACTION_UP){
            jump = false;
        }
        return true;
    }
    public void doGoingUp(){

        if (jumpCounter<jumpMaxHeigh-10){
//            bonk.setY(bonk.getY()-jumpIncrement);
            rositoSkin.setY(rositoSkin.getY()-jumpIncrement);
//            dragonSkin.setY(dragonSkin.getY()-jumpIncrement);
            jumpCounter += jumpIncrement;
            jumpAux = jumpCounter;
        }else if(jumpCounter<jumpMaxHeigh){
//            bonk.setY(bonk.getY() - jumpIncrement+1);
            rositoSkin.setY(rositoSkin.getY() - jumpIncrement+1);
//            dragonSkin.setY(dragonSkin.getY() - jumpIncrement+1);
            jumpCounter += jumpIncrement-1;
            jumpAux = jumpCounter;
        }else if (jumpCounter >= jumpMaxHeigh){
            jump = false;
        }
    }
    public void doGoingDown(){
        if (rositoSkin.getFrame() <= 5 ){
            rositoSkin.setFrameCounter(0);
            rositoSkin.setFrame(6);
        }
//        if (dragonSkin.getFrame() <= 3 ){
//            dragonSkin.setFrameCounter(0);
//            dragonSkin.setFrame(4);
//        }
        if (jumpCounter>jumpAux-10){
//            bonk.setY(bonk.getY() + jumpIncrement-1);
            rositoSkin.setY(rositoSkin.getY() + jumpIncrement-1);
//            dragonSkin.setY(dragonSkin.getY() + jumpIncrement-1);
            jumpCounter -= jumpIncrement-1;
        }else {
//            bonk.setY(bonk.getY()+jumpIncrement);
            rositoSkin.setY(rositoSkin.getY()+jumpIncrement);
//            dragonSkin.setY(dragonSkin.getY()+jumpIncrement);
            jumpCounter -= jumpIncrement;
        }
    }
    public boolean checkGround() {
        if (rositoSkin.getFrame() > 5 && !stateJumping){
            rositoSkin.setFrameCounter(0);
            rositoSkin.setFrame(0);
        }
//        if (dragonSkin.getFrame() > 3 && !stateJumping){
//            dragonSkin.setFrameCounter(0);
//            dragonSkin.setFrame(0);
//        }
//        int r = bonk.getY() >> 4;
        int r = (rositoSkin.getY()) >> 4;
//        int r = (dragonSkin.getY()) >> 4;
        if (r >=16){
            paused = true;
        }
//        int c = bonk.getX() >> 4;
        int c = rositoSkin.getX() >> 4;
//        int c = dragonSkin.getX() >> 4;
        if (!mainMenuBackgroundScene.isGround(r+2, c)){
            stateJumping = true;
            return false;
        }else {
            if (!jump) {
//                bonk.setY(r << 4);
                rositoSkin.setY((r << 4) + 8);
//                dragonSkin.setY((r << 4) + 8);
                stateJumping = false;
                jumpCounter = 0;
            }
        }
        return true;
    }
}
