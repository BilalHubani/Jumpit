package com.example.billy.jumpit.controller.activities.gameViews;

/**
 * Created by DAM on 20/3/17.
 */

import android.content.Context;
import android.provider.ContactsContract;
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
import com.example.billy.jumpit.controller.managers.SkinManager;
import com.example.billy.jumpit.controller.managers.UserCallback;
import com.example.billy.jumpit.controller.managers.UserManager;
import com.example.billy.jumpit.model.ClassLevel;
import com.example.billy.jumpit.model.UserCustomAtributes;

import java.util.ArrayList;
import java.util.List;

public class Levels extends LinearLayout implements UserCallback{



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

        //UserManager.getInstance().getUser();

        final ImageButton primernivel = (ImageButton) findViewById(R.id.primerNivel);
        final ImageButton segundonivel = (ImageButton) findViewById(R.id.segundoNivel);
        final ImageButton tercernivel = (ImageButton) findViewById(R.id.tercerNivel);
        final ImageButton cuartonivel = (ImageButton) findViewById(R.id.cuartoNivel);
        final ImageButton quintonivel = (ImageButton) findViewById(R.id.quintoNivel);




    }


    @Override
    public void onSuccess(List<UserCustomAtributes> userList) {

    }

    @Override
    public void onSuccess(UserCustomAtributes user) {

    }

    @Override
    public void onSucces() {

    }

    @Override
    public void onSucces(UserCustomAtributes user) {

    }

    @Override
    public void onFailure(Throwable t) {

    }
}
