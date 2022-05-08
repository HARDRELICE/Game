package com.khacer.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GameView extends View {

    private final PriorityQueue<Sprite> pqs = new PriorityQueue<Sprite>(100, new Comparator<Sprite>() {
        @Override
        public int compare(Sprite sprite, Sprite t1) {
            if(sprite.getLayer() < t1.getLayer()) {
               return 1;
            } else if(sprite.getLayer() > t1.getLayer()) {
                return -1;
            }
            return 0;
        }
    });

    Bitmap background = getResBm(R.drawable.img, 100, 100);

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        pqs.add(new Sprite(background,0,0,100,100,0));
    }

    public Bitmap getResBm(int resId, int width, int height) {
        return Bitmap.createScaledBitmap(
            BitmapFactory.decodeResource(getResources(), resId),
            width,
            height,
            true
        );
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        for (Sprite x: pqs) {
            canvas.drawBitmap(x.getBm(), x.getX(), x.getY(), null);
        }
    }
}
