package com.example.billy.jumpit.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

import com.example.billy.jumpit.R;

/**
 * Created by dam on 5/4/17.
 */

public class MoconsioBitmapSet extends BitmapSet{
    private Bitmap[] bitmaps;

    private int[][] sheetInfo = {
            { 10, 12, 35, 25, 0 },//  0: walking right 1
            { 48, 12, 35, 25, 0 },//  1: walking right 2
            { 10, 12, 35, 25, 0 },//  0: walking right 1
            { 48, 12, 35, 25, 0 },//  1: walking right 2
            { 10, 12, 35, 25, 0 },//  0: walking right 1
            { 48, 12, 35, 25, 0 },//  1: walking right 2

            { 10, 40, 35, 33, 0 },	//  2: jump right 3
            { 48, 40, 35, 33, 0 },	//  3: jump right 4
            { 10, 40, 35, 33, 0 },	//  2: jump right 3
            { 48, 40, 35, 33, 0 },	//  3: jump right 4
            { 10, 40, 35, 33, 0 },	//  2: jump right 3
    };

    public Bitmap getBitmap(int i) { return bitmaps[i]; }

    public MoconsioBitmapSet(Resources res) {
        super(res);
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inScaled = false;

        Bitmap bitmapsBMP = BitmapFactory.decodeResource(res, R.raw.moconsio, opts);
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
