package raster;

public interface Raster<T>{

    void set(int x, int y,T value);
    T get(int x,int y);
    int getWidth();
    int getHeight();

}
