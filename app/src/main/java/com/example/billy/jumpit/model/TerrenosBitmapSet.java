package com.example.billy.jumpit.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

import com.example.billy.jumpit.R;

/**
 * Created by dam on 5/4/17.
 */

public class TerrenosBitmapSet extends BitmapSet{
    private Bitmap[] bitmaps;

    private int[][] sheetInfo = {
            { 0, 0, 16, 11, 1 },//    0: terreno bosque plat derecha
            { 32, 0, 32, 11, 0 },//   1: terreno bosque plat centro
            { 76, 0, 20, 11, 0 },	//2: terreno bosque plat izquierda
            { 0, 11, 16, 11, 0 },//   3: terreno cueva plat derecha
            { 32, 11, 32, 11, 0 }, // 4: terreno cueva plat centro
            { 76, 11, 20, 11, 0 }, // 5: terreno cueva plat izquierda
            { 0, 22, 16, 11, 0 }, //  6: terreno hielo plat derecha
            { 32, 22, 32, 11, 0 }, //  7: terreno hielo plat centro
            { 76, 22, 20, 11, 0 }, //  8: terreno hielo plat izquierda
            { 0, 33, 16, 11, 0 }, //  9: terreno prado plat derecha
            { 32, 33, 32, 11, 0 }, //  10: terreno prado plat centro
            { 76, 33, 20, 11, 0 }, //  11: terreno prado plat izquierda
            { 0, 44, 16, 11, 0 }, //  12: terreno infierno plat derecha
            { 32, 44, 32, 11, 0 }, //  13: terreno infierno plat centro
            { 76, 44, 20, 11, 0 }, //  14: terreno infierno plat izquiero
            { 0, 74, 32, 32, 0 }, //  15: cielo
    };

    public Bitmap getBitmap(int i) { return bitmaps[i]; }

    public TerrenosBitmapSet(Resources res) {
        super(res);
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inScaled = false;

        Bitmap bitmapsBMP = BitmapFactory.decodeResource(res, R.raw.terrenos, opts);
        Matrix rot1 = new Matrix();
        bitmaps = new Bitmap[sheetInfo.length];
        for (int i = 0; i < sheetInfo.length; i++) {
            int x = sheetInfo[i][0];
            int y = sheetInfo[i][1];
            int w = sheetInfo[i][2];
            int h = sheetInfo[i][3];
            bitmaps[i] = Bitmap.createBitmap(bitmapsBMP, x, y, w, h,
                    rot1, true);
        }
        bitmapsBMP.recycle();
    }
}
