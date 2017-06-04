package com.example.billy.jumpit.controller.activities.gameViews;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.billy.jumpit.R;

/**
 * Created by dam on 17/1/17.
 */

public class Shop extends LinearLayout {
    private ImageButton skin, powerUp, gemas, exit;
    private View vistaSkin, vistaPowerUp, vistaShop, vistaGems;
    private ImageButton btnExitSkin, btnExitPowerUp, btnExitGems;
    final Animation fadeout;

    public Shop(Context context) {
        this(context, null, 0);
    }

    public Shop(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Shop(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.shop, this);
        skin = (ImageButton) view.findViewById(R.id.skinBtnShop);
        powerUp = (ImageButton) view.findViewById(R.id.powerupBtnShop);
        gemas = (ImageButton) view.findViewById(R.id.gemas);
        exit = (ImageButton) view.findViewById(R.id.exitBtn);
        btnExitSkin = (ImageButton) view.findViewById(R.id.exitBtnSkin);
        btnExitPowerUp = (ImageButton) view.findViewById(R.id.exitBtnPowerUp);
        btnExitGems = (ImageButton) view.findViewById(R.id.exitBtnGems);

        vistaSkin = (View) findViewById(R.id.view5);
        vistaPowerUp = (View) findViewById(R.id.view6);
        vistaShop = (View) findViewById(R.id.shopView);
        vistaGems = (View) findViewById(R.id.view7);


        fadeout = AnimationUtils.loadAnimation(context, android.R.anim.fade_out);
        fadeout.setDuration(200);

        vistaSkin();
        vistapowerUp();
        vistaGems();
        btnclose();
    }


    public void vistaGems() {
        vistaGems.setVisibility(View.INVISIBLE);
        gemas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnExitGems.setVisibility(VISIBLE);
                vistaGems.setVisibility(View.VISIBLE);
                invisibleBtn();
            }
        });
        btnExitGems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vistaGems.startAnimation(fadeout);
                vistaGems.setVisibility(View.INVISIBLE);
                btnExitGems.setVisibility(View.INVISIBLE);
                visibleBtn();
            }
        });

    }

    public void vistaSkin() {
        vistaSkin.setVisibility(View.INVISIBLE);
        skin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vistaSkin.setVisibility(View.VISIBLE);
                btnExitSkin.setVisibility(View.VISIBLE);
                invisibleBtn();
            }
        });
        btnExitSkin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vistaSkin.startAnimation(fadeout);
                vistaSkin.setVisibility(View.INVISIBLE);
                btnExitSkin.setVisibility(View.INVISIBLE);
                visibleBtn();
            }
        });
    }

    public void btnclose() {
        exit.setVisibility(View.VISIBLE);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vistaSkin.startAnimation(fadeout);
                vistaSkin.setVisibility(View.INVISIBLE);
                vistaGems.startAnimation(fadeout);
                vistaGems.setVisibility(View.INVISIBLE);
                vistaPowerUp.startAnimation(fadeout);
                vistaPowerUp.setVisibility(View.INVISIBLE);
            }
        });
    }




    public void vistapowerUp(){
        vistaPowerUp.setVisibility(View.INVISIBLE);
        powerUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vistaPowerUp.setVisibility(View.VISIBLE);
                btnExitPowerUp.setVisibility(View.VISIBLE);
                invisibleBtn();
            }
        });
        btnExitPowerUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vistaPowerUp.startAnimation(fadeout);
                vistaPowerUp.setVisibility(View.INVISIBLE);
                btnExitPowerUp.setVisibility(View.INVISIBLE);
                visibleBtn();
            }
        });
    }


    public void invisibleBtn(){
        skin.setVisibility(View.INVISIBLE);
        powerUp.setVisibility(View.INVISIBLE);
        gemas.setVisibility(View.INVISIBLE);
        exit.setVisibility(View.VISIBLE);

    }

    public void visibleBtn(){
        skin.setVisibility(View.VISIBLE);
        powerUp.setVisibility(View.VISIBLE);
        gemas.setVisibility(View.VISIBLE);
        exit.setVisibility(View.VISIBLE);
    }

}
