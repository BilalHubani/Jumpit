package com.example.billy.jumpit.controller.activities.gameViews;

/**
 * Created by DAM on 20/3/17.
 */

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.billy.jumpit.R;
import com.example.billy.jumpit.controller.activities.gameViews.MaterialPaletteAdapterLevels;
import com.example.billy.jumpit.controller.activities.main.MainActivity;
import com.example.billy.jumpit.model.ClassLevel;

import java.util.ArrayList;
import java.util.List;

public class Levels extends LinearLayout {
    private ImageButton primerNivel;
    private ImageButton segundoNivel;
    private ImageButton tercerNivel;
    private ImageButton cuartoNivel;
    private ImageButton quintoNivel;

    public Levels(Context context) {
        this(context, null, 0);
    }

    public Levels(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Levels(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.levels, this);
        primerNivel = (ImageButton) findViewById(R.id.primerNivel);
        segundoNivel  = (ImageButton)findViewById(R.id.segundoNivel);
        tercerNivel  = (ImageButton)findViewById(R.id.tercerNivel);
        cuartoNivel  = (ImageButton)findViewById(R.id.cuartoNivel);
        quintoNivel  = (ImageButton)findViewById(R.id.quintoNivel);
        levels();
    }
    public void levels(){
        primerNivel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("entra","1");
            }
        });
        segundoNivel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("entra","2");
            }
        });
        tercerNivel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("entra","3");
            }
        });
        cuartoNivel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("entra","4");
            }
        });
        quintoNivel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("entra","5");
            }
        });
    }
}
