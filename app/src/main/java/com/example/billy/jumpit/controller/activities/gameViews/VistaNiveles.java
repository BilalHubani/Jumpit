package com.example.billy.jumpit.controller.activities.gameViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.billy.jumpit.R;

/**
 * Created by dam on 17/1/17.
 */

public class VistaNiveles extends LinearLayout {

    public VistaNiveles(Context context) {
        this(context, null, 0);
    }

    public VistaNiveles(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VistaNiveles(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.menuniveles, this);
        final View vistaHistoria = (View) findViewById(R.id.listamenulevels);
        vistaHistoria.setVisibility(INVISIBLE);
        Animation fadeout;

        fadeout = AnimationUtils.loadAnimation(context, android.R.anim.fade_out);
        fadeout.setDuration(200);

        final ImageButton historia = (ImageButton) findViewById(R.id.btnhistoria);
        final ImageButton endless = (ImageButton) findViewById(R.id.btnendless);
        final ImageButton exit = (ImageButton) findViewById(R.id.levelExitBtn);

        historia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                historia.setVisibility(INVISIBLE);
                endless.setVisibility(INVISIBLE);
                vistaHistoria.setVisibility(VISIBLE);
            }
        });
        exit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            //commit
                historia.setVisibility(VISIBLE);
                endless.setVisibility(VISIBLE);
                vistaHistoria.setVisibility(INVISIBLE);
            }
        });

    }
}
