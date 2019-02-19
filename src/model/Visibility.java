package model;

import Raster.ImgBuffer;
import Raster.ZBuffer;

public class Visibility {

    private ImgBuffer imgBuffer;
    private ZBuffer<Float> zBuffer;
    private int widht;
    private int height;

    public Visibility(int widht,int height) {
        this.height=height;
        this.widht=widht;
        this.imgBuffer = new ImgBuffer(widht,height);
        this.zBuffer = new ZBuffer<>(widht,height);
    }

    public void put(int x,int y,float z){
        zBuffer.set(x,y,z);
    }

    public void init(){
        for (int i = 0; i < imgBuffer.getHeight(); i++) {
            for (int j = 0; j < imgBuffer.getHeight(); j++) {
                imgBuffer.set(i,j,0);
            }
        }
        zBuffer=new ZBuffer<>(height,widht);
    }
}
