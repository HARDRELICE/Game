package com.khacer.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GameView extends View {

    Handler handler;
    Runnable r;
    int fps = 60;

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

    Bitmap background = getResBm(R.drawable.img, 1000, 100);
    Sprite ff = new Sprite(background,0,0,1000,100,0);

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Sprite y = new Sprite(getResBm(R.drawable.img, 200, 200), 0,200, 200, 200, 1);
        pqs.add(y);
        pqs.add(ff);
        handler = new Handler();
        r = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };
    }

    public void AddSprite(Sprite s) {
        pqs.add(s);
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
        pqs.element().moveX(10);
        for (Sprite x: pqs) {
            canvas.drawBitmap(x.getBm(), x.getX(), x.getY(), null);
        }
        getHandler().postDelayed(r, 1000/fps);
    }
}
