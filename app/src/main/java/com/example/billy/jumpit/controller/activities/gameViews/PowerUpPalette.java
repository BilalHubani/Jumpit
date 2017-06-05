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
import android.widget.LinearLayout;

import com.example.billy.jumpit.R;
import com.example.billy.jumpit.controller.managers.PowerUpCallback;
import com.example.billy.jumpit.controller.managers.PowerUpManager;
import com.example.billy.jumpit.model.ClassPowerUp;
import com.example.billy.jumpit.model.PowerUp;

import java.util.ArrayList;
import java.util.List;

public class PowerUpPalette extends LinearLayout implements PowerUpCallback{
    private List<PowerUp> datas;
    private Context context;

    public PowerUpPalette(Context context) {
        this(context, null, 0);
    }

    public PowerUpPalette(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PowerUpPalette(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.powerup, this);

        PowerUpManager.getInstance().getAllPowerUp(this);

    }

    @Override
    public void onSuccess(List<PowerUp> powerUpsList) {
        datas = powerUpsList;
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecycleViewPU);
        recyclerView.setAdapter(new MaterialPaletteAdapterPU(datas, context));
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setHorizontalScrollBarEnabled(false);
    }

    @Override
    public void onSucces() {

    }

    @Override
    public void onSucces(PowerUp powerUp) {

    }

    @Override
    public void onFailure(Throwable t) {

    }
}
