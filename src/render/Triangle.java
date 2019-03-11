package render;

import model.Vertex;
import raster.Visibility;
import transforms.Col;
import transforms.Mat4;
import transforms.Point2D;
import transforms.Vec3D;

import java.util.function.Function;


public class Triangle {

    Function<Vertex, Col> shader = (vertex -> new Col(0xFFFFFF));
    Visibility vis;

    public Triangle(Visibility vis) {
        this.vis = vis;
    }

    public void setShader(Function<Vertex, Col> shader) {
        this.shader = shader;
    }

    public void rasterize(Vertex a, Vertex b, Vertex c) {
        a = a.dehomog();
        b = b.dehomog();
        c = c.dehomog();

        //viewPort TRANSFORMATION
        Point2D pA = transformViewport(a);
        Point2D pB = transformViewport(b);
        //další

        for (int y = (int) Math.max(pA.getY(), 0); y < pB.getY(); y++) {
            double s1 = (y - pA.getY()) / (pB.getY() - pA.getY());
            double x1 = 0;
            double s2, x2, z1, z2;
            /*for (int x = Math.max((int) x1, 0); x < x2; x++) {
                double t = 0;
                double z = 0;
                vis.put(x, y, z, shader.apply(new Vertex()));
            }*/
        }
    }


    public Point2D transformViewport(Vertex ver) { //
        return new Point2D(((vis.getBufferedImage().getWidth() - 1) * ver.getPosition().getX() + 1) / 2, //bod X
                ((vis.getBufferedImage().getWidth() - 1) * ver.getPosition().getY() + 1) / 2);          //bod Y
    }
}
