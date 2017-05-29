package com.example.billy.jumpit.controller.activities.Scenes;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.widget.Toast;

import com.example.billy.jumpit.R;
import com.example.billy.jumpit.controller.activities.gameViews.GameViewHistoria;
import com.example.billy.jumpit.model.BitmapSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dam on 26/5/17.
 */

public class HistoryScene {
    public final static int SCENE_HEIGHT = 16;
    private char scene2[][] = new char[16][30];
    private String[] scene;
    private Paint paint;
    private int cont = 0;
    private GameViewHistoria game;
    boolean creatingPlatform = false;
    private int platformsDistance = 0;
    private BitmapSet bitmapSet;
    public HistoryScene(GameViewHistoria game) {
        this.game = game;
        this.bitmapSet = game.getBitmapSet();
        paint = new Paint();
    }
    public void load(int resource) {
        // load scene
        scene = new String[SCENE_HEIGHT];
        try {
            InputStream res = game.getResources().openRawResource(resource);
            BufferedReader reader = new BufferedReader(new InputStreamReader(res));
            for (int i = 0; i < SCENE_HEIGHT; i++) {
                String linea = reader.readLine();
                scene[i] = linea;
            }
            reader.close();
        }
        catch (IOException e) {
            scene = null;
        }
    }

    public boolean isGround(int y, int x) {
        if (y >= 16)
            return false;
        if (y<0){
            return false;
        }
        char s = scene[y].charAt(x);
        if (s == '-') return true;
        if (s == '<') return true;
        if (s == '>') return true;
        return false;
    }

    public int getBitmap(int r, int c) {
        char e = scene[r].charAt(c);
        Log.e("getBitmap", ""+e);
        int i = -1;
        switch (e) {
            case '<': i = 35; break;
            case '-': i = 36; break;
            case '>': i = 37; break;
            case '[': i = 44; break;
            case '#': i = 45; break;
            case ']': i = 46; break;
            case '|': i = 40; break;
            case '{': i = 21; break;
            case '}': i = 22; break;
        }
        return i;
    }
    public void draw(Canvas canvas) {
        if (cont > 15) {
            scene2 = updateMap();
            cont = 0;
        }
        if (scene == null) return;
        for(int y = 0; y < scene.length; y++) {
            for(int x = 0; x < scene[0].length(); x++) {
                Bitmap bitmap;
//                Log.e("draw",""+scene[y].charAt(x));
                switch (scene[y].charAt(x)) {
                    case '.':
                        bitmap = bitmapSet.getBitmap(23);
                        break;
                    case '-':
                        bitmap = bitmapSet.getBitmap(45);
                        break;
                    default:
                        bitmap = bitmapSet.getBitmap(23);
                        break;
                }
                canvas.drawBitmap(bitmap, x * 16 - cont, y * 16, paint);
            }
        }
        cont = cont + 4;
    }

    public char[][] updateMap() {
        int platforms = 0;
        int platformsLong1 = 0;
        int platformsLong2 = 0;
        int platformsLong3 = 0;
        int groundCounter = 0;
        int rng = 0;
        int creatingPlatformLong = 0;
        int lastPlatformAltitude = 15;
        int checkRng = 0;
        int lastPlatformX = 20;
        platformsDistance++;
        // buscamos info
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 29; j++) {
                // contamos las plataformas
                if (scene2[i][j] == ('-'/* plataforma */) && scene2[i][j + 1] == ('.' /* cielo */)) {
                    platforms++;
                    lastPlatformX = j;
                }
                // contamos el suelo
                if (i == 15 && scene2[15][j] == '-') {
                    groundCounter++;
                }
                if ( scene2[i][29] == ('-'/* plataforma */)){
                    lastPlatformAltitude = i;
                }
            }
        }
        // avanzamos el scene una posicion
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 29; j++) {
                scene2[i][j] = scene2[i][j + 1];
            }
        }
        // pintamos la ultima linea
        for (int i = 0; i < 16; i++) {
//            if (i == 15 && groundCounter < 3) {
//                scene[i][29] = '-';
//                creatingPlatform = true;
//            }else {
            //pintar plataforma nueva
            if (platforms < 6 && i == 15 && lastPlatformX<25 && !creatingPlatform) {
                do {
                    rng = (int) (Math.random() * 15 );
                    checkRng = rng-lastPlatformAltitude;
                }while(rng<6 || checkRng>2 || checkRng<(-2) );
                scene2[rng][29] = '-';
                platformsDistance = 0;
                creatingPlatform = true;
            }else {
                // pintar cielo
                scene2[i][29] = '.';
            }
            // random de la longitud de la plataforma
            if (scene2[i][28] == '-') {
                for (int j = 28; j > 24; j--) {
                    if (scene2[i][j] == '-')
                        creatingPlatformLong++;
                }
                rng = (int) (Math.random() * 10 + creatingPlatformLong);

                if (rng < 11)
                    scene2[i][29] = '-';
                else
                    creatingPlatform = false;
            }

        }
//        }
        return scene2;

    }
}
