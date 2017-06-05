package com.example.billy.jumpit.controller.activities.gameViews;

/**
 * Created by DAM on 20/3/17.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.billy.jumpit.R;
import com.example.billy.jumpit.controller.managers.SkinCallback;
import com.example.billy.jumpit.controller.managers.SkinManager;
import com.example.billy.jumpit.controller.managers.UserCallback;
import com.example.billy.jumpit.model.ClassSkin;
import com.example.billy.jumpit.model.Skin;

import java.util.List;

public class SkinPalette extends LinearLayout implements SkinCallback{
    private ImageView imgskin;
    private TextView nameskin;
    private List<Skin> datas;
    private List<Skin> datasAdquerido;
    private Context context;
    private Button button, btnShowSkin;
    private View vistaShowSkin;
    private int contador = 0;


    public SkinPalette(Context context) {
        this(context, null, 0);
    }

    public SkinPalette(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SkinPalette(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.skins, this);
        SkinManager.getInstance().getAllSkins(this);

        SkinManager.getInstance().getAllSkinsByUser(this);
        //Log.e("-------->>>>", "" + datas.size());

        //RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecycleView);
        //recyclerView.setAdapter(new MaterialPaletteAdapter(datas, context));
        //recyclerView.setLayoutManager(new LinearLayoutManager(context));
        //recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        //recyclerView.setHorizontalScrollBarEnabled(false);

    }


    @Override
    public void onSuccess(List<Skin> skinsList) {

//        for(Skin skin: getAllSkins){
//            boolean bool = false;
//            for(Skin skin2 : getAllSkinsByUser){
//                if(skin2.equals(skin)){ bool = true; }
//            }
//            if(!bool){
//                datas.add(skin);
//            }
//        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecycleView);
        recyclerView.setAdapter(new MaterialPaletteAdapter(datas, context));
        //recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setHorizontalScrollBarEnabled(false);
    }

    @Override
    public void onSucces() {

    }

    @Override
    public void onSucces(Skin skin) {

    }

    @Override
    public void onFailure(Throwable t) {

    }
}
