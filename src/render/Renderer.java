package render;

import model.Part;
import model.Solid;
import model.Vertex;
import transforms.Mat4;
import util.Lerp;

public class Renderer {

    private Mat4 viewMatrix;
    private Triangle triangle;
    private Line line;
    private Point point;
    private Lerp<Vertex> lerp = new Lerp();



    public void render(Solid solid) {
        for (Part part : solid.getParts()) {
            switch (part.getType()) {
                case LINES:

                    break;
                case TRIANGLES:
                    for (int i = 0; i < part.getCount(); i++) {
                        Vertex a, b, c;

                        a = solid.getVertexBuffer().get(solid.getIndexBuffer().get(3 * i + part.getStart()));
                        b = solid.getVertexBuffer().get(solid.getIndexBuffer().get(3 * i + part.getStart() + 1));
                        c = solid.getVertexBuffer().get(solid.getIndexBuffer().get(3 * i + part.getStart() + 2));
                        renderTriangle(a, b, c);
                    }
                    break;
                case POINTS:

                    break;
                case LINE_LOOP:

                    break;
                case LINE_STRIP:

                    break;
                case TRIANGL_FAN:

                    break;
                case TRIANGL_STRIP:

                    break;
            }

        }
    }


    private void renderTriangle(Vertex a,Vertex b, Vertex c){
        if(a.getPosition().getZ()<b.getPosition().getZ()){
            Vertex pom = a;
            a = b;
            b = pom;
        }
        if (b.getPosition().getZ()<c.getPosition().getZ()){
            Vertex pom = b;
            b = c;
            c = pom;
        }
        if (a.getPosition().getZ()<c.getPosition().getZ()){
            Vertex pom = a;
            a = c;
            c = pom;
        }

        if(a.getPosition().getZ()<0){
            return;
        }
        if(b.getPosition().getZ()<0){
            double t1 = -b.getPosition().getZ()/(a.getPosition().getZ()-b.getPosition().getZ());
            Vertex ab = lerp.lerp(b,a,t1); //Výpočet interpolace
            Vertex ac = lerp.lerp(c,a,t1);

            //rt.rasterize(a,ab,ac);

            //...
            /**
             * rt.rasterize(a,b,ac);
             * rt.rasterize(bc,b,ac);
             *
             * */
        }
        if(c.getPosition().getZ()<0){

        }
    }
}

