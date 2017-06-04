package com.example.billy.jumpit.controller.activities.main;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.billy.jumpit.controller.activities.Scenes.MainMenuBackgroundScene;
import com.example.billy.jumpit.model.BitmapSet;
import com.example.billy.jumpit.model.Bonk;
import com.example.billy.jumpit.model.RositoBitmapSet;
import com.example.billy.jumpit.model.RositoSkin;
import com.example.billy.jumpit.model.TerrenosBitmapSet;

/**
 * Created by dam on 20/3/17.
 */

public class  MainMenuView extends View {
    private BitmapSet bitmapSet;
    private TerrenosBitmapSet terrenosBitmapSet;
    private MainMenuBackgroundScene mainMenuBackgroundScene;
    private Bonk bonk;
    private RositoSkin rositoSkin;
    private RositoBitmapSet rositoBitmapSet;
    private boolean jump = false;
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
        terrenosBitmapSet = new TerrenosBitmapSet(this.getResources());
        mainMenuBackgroundScene = new MainMenuBackgroundScene(terrenosBitmapSet);
//        bonk = new Bonk(bitmapSet);
        rositoSkin = new RositoSkin(rositoBitmapSet);
    }

    @Override
    public void onDraw(Canvas canvas) {
        this.postInvalidateDelayed(1);
        if (bitmapSet == null) return;
        float sc = getHeight() / (16 * 16f);
        canvas.scale(sc, sc);
        if (jump)
            doJump();
        mainMenuBackgroundScene.draw(canvas);
//        bonk.draw(canvas);
        rositoSkin.draw(canvas);
    }
    public void doJump(){
        if (checkGround() && !goingUp) {
            jumpLength = 0;
            goingUp = true;
            jump = false;
        } else {
            //salto y suavizado del mismo
            if (jumpLength < 25 && goingUp) {
                if (jumpLength > 20) {
                    count++;
                    if (count > 2) {
//                        bonk.setY(bonk.getY() - 2);
                        rositoSkin.setY(rositoSkin.getY() - 2);
                        if (rositoSkin.getFrame() <= 5 ){
                            rositoSkin.setFrameCounter(0);
                            rositoSkin.setFrame(6);
                        }
                        jumpLength++;
                        count = 0;
                    }
                } else {
//                    bonk.setY(bonk.getY() - 2);
                    rositoSkin.setY(rositoSkin.getY() - 2);
                    jumpLength++;
                    if (rositoSkin.getFrame() <= 5 ){
                        rositoSkin.setFrameCounter(0);
                        rositoSkin.setFrame(6);
                    }
                }
            }
            //altura maxima del salto
            if (jumpLength >= 25)
                goingUp = false;
            // descenso
            if (!goingUp) {
                count++;
                if (jumpLength > 20) {
                    count++;
                    if (count > 2) {
//                        bonk.setY(bonk.getY() + 2);
                        rositoSkin.setY(rositoSkin.getY() + 2);
                        jumpLength--;
                        count = 0;
                    }
                } else {
//                    bonk.setY(bonk.getY() + 2);
                    rositoSkin.setY(rositoSkin.getY() + 2);
                    jumpLength--;
                }
            }
        }
    }
    // variables para controlar el salto
    boolean goingUp = true;
    int jumpLength = 0;
    int count = 0;//

    //detectar el tap para saltar
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        jump = true;
        return true;
    }
    // comprobar si hay suelo debajo y posicionar el personaje cuando este cayendo
    public boolean checkGround() {
//        int r = bonk.getY() >> 4;
//        int c = bonk.getX() >> 4;
        int r = rositoSkin.getY() >> 4;
        int c = rositoSkin.getX() >> 4;
        if (!mainMenuBackgroundScene.isGround(r+2, c))
            return false;
        else if (!goingUp) {
//            bonk.setY(r << 4);
            rositoSkin.setY(r << 4);
            jumpLength=0;
            if (rositoSkin.getFrame() >= 6 ){
                rositoSkin.setFrameCounter(0);
                rositoSkin.setFrame(0);
            }
        }
        return true;
    }
}
