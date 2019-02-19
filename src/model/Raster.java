package model;

import transforms.Point2D;

public interface Raster<T>{

    void set(int x, int y,T value);
    T get(int x,int y);
    int getWidth();
    int getHeight();

}
