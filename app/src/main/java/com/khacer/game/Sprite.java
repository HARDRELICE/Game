package com.khacer.game;

import android.graphics.Bitmap;

public class Sprite {
    private Bitmap bm;
    private int x, y, w, h, layer;

    public Sprite(Bitmap bm, int x, int y, int w, int h, int layer) {
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
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }
}
