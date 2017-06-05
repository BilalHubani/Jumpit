package com.example.billy.jumpit.controller.activities.gameViews;

/**
 * Created by DAM on 20/3/17.
 */

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.billy.jumpit.R;
import com.example.billy.jumpit.controller.activities.gameViews.MaterialPaletteAdapter;
import com.example.billy.jumpit.model.ClassSkin;

import java.util.ArrayList;
import java.util.List;

public class Skin extends LinearLayout {
    private ImageView imgskin;
    private TextView nameskin;
    private List<ClassSkin> datas;
    private Button button, btnShowSkin;
    private View vistaShowSkin;


    public Skin(Context context) {
        this(context, null, 0);
    }

    public Skin(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Skin(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.skins, this);
        datas = new ArrayList<>();
        datas.add(new ClassSkin("Chico Rosa", R.drawable.skinrosita));
        datas.add(new ClassSkin("dragonsio", R.drawable.blackdragon));
        datas.add(new ClassSkin("moconsio", R.drawable.moco));
        datas.add(new ClassSkin("Vikingo", R.drawable.vikingsshop));
        datas.add(new ClassSkin("mago", R.drawable.magoshop));
        datas.add(new ClassSkin("azulete", R.drawable.azuleteshop));
        datas.add(new ClassSkin("caballero", R.drawable.caballeroshop));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecycleView);
        recyclerView.setAdapter(new MaterialPaletteAdapter(datas, context));
        //recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setHorizontalScrollBarEnabled(false);

    }
}
