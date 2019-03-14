package raster;

import java.util.ArrayList;
import java.util.List;

public class ZBuffer<T> implements Raster<T> {

    private int height,width;
    private List<T> canvas;

    public ZBuffer(int width,int height){
        this.height=height;
        this.width=width;
        canvas = new ArrayList<>(height*width);

    }

    @Override
    public void set(int x, int y, T value) {
        canvas.add(width*y+x,value);
    }

    @Override
    public T get(int x, int y) {
        return canvas.get(width*y+x);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
