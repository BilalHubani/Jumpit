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
    }
}
