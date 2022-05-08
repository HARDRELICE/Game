package com.khacer.game;

import android.graphics.Bitmap;

import androidx.annotation.Nullable;

public class Sprite {
    private Bitmap bm;
    private int x, y, w, h, layer;

    public Sprite(Bitmap bm, int x, int y, int w, int h, int layer) {
        bm.setWidth(w);
        bm.setHeight(h);
        this.bm = bm;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.layer = layer;
    }

    public Bitmap getBm() {
        return bm;
    }

    public void setBm(Bitmap bm) {
        this.bm = bm;
        bm.setWidth(this.w);
        bm.setHeight(this.h);
    }

    public void setBm(Bitmap bm, int w, int h) {
        this.bm = bm;
        setW(w);
        setH(h);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
        this.bm.setWidth(w);
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
        this.bm.setHeight(h);
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public void moveX(int dx) {
        this.x += dx;
    }

    public void moveY(int dy) {
        this.y += dy;
    }

    public void move(int dx, int dy) {
        moveX(x);
        moveY(y);
    }

    public void moveTo(int x, int y) {
        setX(x);
        setY(y);
    }
}
