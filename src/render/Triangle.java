package render;

import model.Vertex;
import raster.Visibility;
import transforms.Col;
import transforms.Point2D;
import util.Lerp;

import java.awt.*;
import java.util.function.Function;


public class Triangle extends Rasterizer{

    Lerp<Vertex> lerp = new Lerp<>();
    Function<Vertex, Col> shader = (vertex -> new Col(0xFFFFFF));

    public Triangle() {

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
        Point2D pC = transformViewport(c);
        //další

        for (int y = (int) Math.max(pA.getY(), 0); y < pB.getY(); y++) {
            double s1 = (y - pA.getY()) / (pB.getY() - pA.getY());
            double s2 = 0;
            Vertex ab = lerp.lerp(a,b,s1);
            Vertex ac = lerp.lerp(a,c,s2);
            double x1 = 0;
            double x2 = 0;
            double z1 = 0;
            double z2 = 0;
            for (int x = Math.max((int) x1, 0); x < x2; x++) {
                float t = 0;
                float z = 0;

                Vertex abc = lerp.lerp(ab,ac,t);

                // Vykreslení bodu + shader, případně barva ....
                //vis.put(x, y, z, shader.apply(new Vertex()));
                draw(x, y, z, new Col(Color.WHITE.getRGB()));
            }
        }
    }



    }
}
