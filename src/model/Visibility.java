package model;

public class Visibility {

    private ImgBuffer imgBuffer;
    private ZBuffer<Float> zBuffer;

    public Visibility(int widht,int height) {
        this.imgBuffer = new ImgBuffer(widht,height);
        this.zBuffer = new ZBuffer<>(widht,height);
    }

    public void put(float x,float y,float z, int color){



    }
}
