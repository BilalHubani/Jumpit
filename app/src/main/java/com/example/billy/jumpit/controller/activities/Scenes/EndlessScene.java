package com.example.billy.jumpit.controller.activities.Scenes;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.billy.jumpit.model.BitmapSet;

/**
 * Created by dam on 10/2/17.
 */

public class EndlessScene {
    private char scene[][] = new char[16][30];
    private Paint paint;
    private BitmapSet bitmapSet;
    private int cont = 0;
    private int mapVel = 4;
    private int platformsDistance = 0;
    boolean creatingPlatform = false;

    public EndlessScene(BitmapSet bitmapSet) {
        this.bitmapSet = bitmapSet;
        this.scene = initiateMap(scene);
        paint = new Paint();
    }

    public boolean isGround(int y, int x) {
        if (y >= 16)
            return false;
        if (y<0){
            return false;
        }
        char s = scene[y][x];
        if (s == '-') return true;
        if (s == '<') return true;
        if (s == '>') return true;
        return false;
    }

    public void draw(Canvas canvas, int vel) {
        if (cont >= 15) {
            scene = updateMap();
            cont = 0;
        }
        for (int y = 0; y < 16; y++) {
            for (int x = 0; x < 30; x++) {
                Bitmap bitmap;
                switch (scene[y][x]) {
                    case '.':
                        bitmap = bitmapSet.getBitmap(23);
                        break;
                    case '-':
                        bitmap = bitmapSet.getBitmap(45);
                        break;
                    case '<':
                        bitmap = bitmapSet.getBitmap(45);
                        break;
                    case '>':
                        bitmap = bitmapSet.getBitmap(45);
                        break;
                    default:
                        bitmap = bitmapSet.getBitmap(23);
                        break;
                }
                canvas.drawBitmap(bitmap, x * 16 - cont, y * 16, paint);
            }
        }
        cont = cont + vel;
        mapVel = vel;
    }
    // update del mapa
    public char[][] updateMap() {
        int platforms = 0;
        int groundCounter = 0;
        int rng = 0;
        int creatingPlatformLong = 0;
        int lastPlatformAltitude = 15;
        int checkRng = 0;
        int lastPlatformX = 0;
        boolean done = false;
        platformsDistance = (int) (Math.random() * 16 );
        // buscamos info
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 29; j++) {
                // contamos las plataformas
                if (scene[i][j] == '>') {
                    platforms++;
                    if (j > lastPlatformX)
                        lastPlatformX = j;
                }
                // contamos el suelo
                if (i == 15 && scene[15][j] == '-') {
                    groundCounter++;
                }
                if ( scene[i][29] == ('>'/* plataforma */)){
                    lastPlatformAltitude = i;
                }
            }
        }
        // avanzamos el scene una posicion
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 29; j++) {
                scene[i][j] = scene[i][j + 1];
            }
        }
        // pintamos la ultima linea
        for (int i = 0; i < 16; i++) {
            //pintar plataforma nueva
            if (platforms <= 3 && i == 15 && platformsDistance>8 && !creatingPlatform && lastPlatformX<25 && !done) {
                do {
                    rng = (int) (Math.random() * 16 );
                    checkRng = rng-lastPlatformAltitude;
                }while(rng<4 || checkRng>3 || checkRng<(-3) );
                scene[rng][29] = '<';
                platformsDistance = 0;
                creatingPlatform = true;
            }else {
                // pintar cielo
                scene[i][29] = '.';
            }
            // random de la longitud de la plataforma
            if (scene[i][28] == '-' || scene[i][28] == '<') {
                for (int j = 28; j > 24; j--) {
                    if (scene[i][j] == '-')
                        creatingPlatformLong++;
                }
                rng = (int) (Math.random() * 11 + creatingPlatformLong);

                if (rng < 11) {
                    scene[i][29] = '-';
                }else {
                    scene[i][29] = '>';
                    creatingPlatform = false;
                    done = true;
                }
            }

        }
//        }
        return scene;

    }
    /*
- ver que plataformas hay hechas DONE
- maximo de plataformas?? DONE
- velocidad?? DONE
- random progresivo de longitud de plataforma long: 2-90% 3-70% 4-50% 5-20%
- distancia entre plataformas
- altura distinta, diferencia de 2?? determinado por random
- power ups
*/
// iniciamos el mapa
    public char[][] initiateMap(char[][] map) {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 30; j++) {
                map[i][j] = '.';
                map[15][j] = '-';
                map[15][29] = '>';
            }
        }
        return map;
    }
}