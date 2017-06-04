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
import com.example.billy.jumpit.model.TerrenosBitmapSet;

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
    private ArrayList<Integer> bitmapplataformas;
    private String[] scene;
    private Paint paint;
    private int cont = 0;
    private GameViewHistoria game;
    boolean creatingPlatform = false;
    private int platformsDistance = 0;
    private TerrenosBitmapSet bitmapSet;
    private String aux;
    public Boolean pausa = false;
    private int nivel = 0;
    public HistoryScene(GameViewHistoria game) {
        this.game = game;
        this.bitmapSet = game.getTerrenosBitmapSet();
        paint = new Paint();
        bitmapplataformas = new ArrayList();
    }
    public void load(int resource) {
        this.nivel = resource;
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
    public boolean isWall(int y, int x) {
        if (y >= 16)
            return false;
        if (y<0){
            return false;
        }
        char s = scene[y].charAt(x);
        if (s == '#') return true;
        return false;
    }

    public int getBitmap(int r, int c) {
        char e = scene[r].charAt(c);
        int i = -1;
        switch (e) {
            case '<': i = bitmapplataformas.get(0); break;
            case '-': i = bitmapplataformas.get(1); break;
            case '>': i = bitmapplataformas.get(2); break;
            case '[': i = 5; break;
            case '#': i = bitmapplataformas.get(1); break;
            case ']': i = 5; break;
            case '|': i = 5; break;
            case '{': i = 5; break;
            case '}': i = 5; break;
        }
        return i;
    }
    public void draw(Canvas canvas, int vel) {
        if (cont > 15) {
            updateMap();
            cont = 0;
        }
        if (scene == null) return;
        for(int y = 0; y < scene.length; y++) {
            for(int x = 0; x < 30; x++) {
                Bitmap bitmap;
                switch (scene[y].charAt(x)) {
                    case '.':
                        bitmap = bitmapSet.getBitmap(15);
                        break;
                    case '-':
                        bitmap = bitmapSet.getBitmap(bitmapplataformas.get(1));
                        break;
                    case '>':
                        bitmap = bitmapSet.getBitmap(bitmapplataformas.get(2));
                        break;
                    case '<':
                        bitmap = bitmapSet.getBitmap(bitmapplataformas.get(0));
                        break;
                    case '#':
                        bitmap = bitmapSet.getBitmap(15);
                        break;
                    default:
                        bitmap = bitmapSet.getBitmap(23);
                        break;
                }
                canvas.drawBitmap(bitmap, x * 16 - cont, y * 16, paint);
            }
        }
        cont = cont + vel;
    }

    public void updateMap() {
        if(!pausa) {
            for (int i = 0; i < 16; i++) {
                scene[i] = scene[i].substring(1);
            }
        }
    }

    public Boolean getPausa() {
        return pausa;
    }

    public void setPausa(Boolean pausa) {
        this.pausa = pausa;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public ArrayList<Integer> getBitmapplataformas() {
        return bitmapplataformas;
    }

    public void setBitmapplataformas(ArrayList<Integer> bitmapplataformas) {
        this.bitmapplataformas = bitmapplataformas;
    }

    public void limpiarbitmapplataformas(){
        bitmapplataformas.clear();
    }
}
