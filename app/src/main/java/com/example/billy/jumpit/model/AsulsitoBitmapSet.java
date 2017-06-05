package com.example.billy.jumpit.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

import com.example.billy.jumpit.R;

/**
 * Created by dam on 5/4/17.
 */

public class AsulsitoBitmapSet extends BitmapSet{
    private Bitmap[] bitmaps;

    private int[][] sheetInfo = {
            { 7, 6, 18, 30, 0 },//  0: correr 1
            { 36, 6, 17, 30, 0 },//  1: correr 2
            { 60, 6, 15, 30, 0 },	//  2: correr 3
            { 83, 6, 19, 30, 0 },	//  3: correr 4
            { 109, 6, 15, 30, 0 }, //  4: correr 5
            { 135, 6, 17, 30, 0 }, //  5: correr 6

            { 7, 45, 18, 31, 0 },//  6: salto 1
            { 35, 45, 16, 31, 0 },//  7: salto 2
            { 60, 45, 19, 31, 0 },	//  8: salto 3
            { 85, 45, 21, 31, 0 },	//  9: salto 4
            { 112, 45, 16, 31, 0 }, //  10: salto 5
    };

    public Bitmap getBitmap(int i) { return bitmaps[i]; }

    public AsulsitoBitmapSet(Resources res) {
        super(res);
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inScaled = false;

        Bitmap bitmapsBMP = BitmapFactory.decodeResource(res, R.raw.azulete, opts);
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
