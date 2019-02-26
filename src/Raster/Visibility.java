package Raster;

import Raster.ImgBuffer;
import Raster.ZBuffer;
import transforms.Col;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Visibility {

    private ImgBuffer imgBuffer;
    private ZBuffer<Float> zBuffer;
    private int widht;
    private int height;

    public Visibility(int widht,int height) {
        this.height=height;
        this.widht=widht;
        this.imgBuffer = new ImgBuffer(widht,height);
        this.zBuffer = new ZBuffer<Float>(widht,height);
        init(Color.BLACK.getRGB());
    }

    public void put(int x, int y, float z, Col color){
        if(z < zBuffer.get(x,y)){
            imgBuffer.set(x,y,color.getRGB());
            zBuffer.set(x,y,z);
        }
    }

    public void init(int color){
        for (int i = 0; i < imgBuffer.getHeight(); i++) {
            for (int j = 0; j < imgBuffer.getHeight(); j++) {
                //imgBuffer.set(i,j,color);
                zBuffer.set(j,i,1f); //místo 1f je správně: new Float(1)
            }
        }
        imgBuffer.clear(color);
    }

    public BufferedImage getBufferedImage() {
        return imgBuffer.getImg();
    }
}
