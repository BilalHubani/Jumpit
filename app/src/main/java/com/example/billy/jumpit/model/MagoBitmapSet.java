package com.example.billy.jumpit.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

import com.example.billy.jumpit.R;

/**
 * Created by dam on 5/4/17.
 */

public class MagoBitmapSet extends BitmapSet{
    private Bitmap[] bitmaps;

    private int[][] sheetInfo = {
            { 7, 4, 18, 32, 0 },//  0: correr 1
            { 36, 4, 17, 32, 0 },//  1: correr 2
            { 60, 4, 15, 32, 0 },	//  2: correr 3
            { 83, 4, 19, 32, 0 },	//  3: correr 4
            { 109, 4, 15, 32, 0 }, //  4: correr 5
            { 135, 4, 17, 32, 0 }, //  5: correr 6

            { 7, 42, 18, 34, 0 },//  6: salto 1
            { 35, 42, 16, 34, 0 },//  7: salto 2
            { 60, 42, 19, 34, 0 },	//  8: salto 3
            { 85, 42, 21, 34, 0 },	//  9: salto 4
            { 112, 42, 16, 34, 0 }, //  10: salto 5
    };

    public Bitmap getBitmap(int i) { return bitmaps[i]; }

    public MagoBitmapSet(Resources res) {
        super(res);
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inScaled = false;

        Bitmap bitmapsBMP = BitmapFactory.decodeResource(res, R.raw.mago, opts);
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
