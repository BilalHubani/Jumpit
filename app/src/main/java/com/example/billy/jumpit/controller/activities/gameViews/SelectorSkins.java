package com.example.billy.jumpit.controller.activities.gameViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.billy.jumpit.R;

/**
 * Created by dam on 17/1/17.
 */

public class SelectorSkins extends LinearLayout {

    public SelectorSkins(Context context) {
        this(context, null, 0);
    }

    public SelectorSkins(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SelectorSkins(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.skinselector, this);

    }
}
