package render;

import model.Vertex;
import raster.Visibility;
import transforms.Col;
import transforms.Point2D;

import java.awt.*;

public abstract class Rasterizer {
    protected Visibility vis;

    protected void  draw(int x, int y, float z, Col color){
        vis.put(x, y, z, color);
    }

    protected Point2D transformViewport(Vertex ver) { //
        return new Point2D(((vis.getBufferedImage().getWidth() - 1) * ver.getPosition().getX() + 1) / 2, //bod X
                ((vis.getBufferedImage().getWidth() - 1) * ver.getPosition().getY() + 1) / 2);          //bod Y
    }
}