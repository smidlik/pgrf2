package render;

import model.Vertex;
import raster.Visibility;

public class Point {
    private Visibility visibility;


    public Point(Visibility visibility) {
        this.visibility = visibility;
    }

    public void rasterize(Vertex v){




        visibility.put();
    }

}
