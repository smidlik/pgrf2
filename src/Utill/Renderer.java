package Utill;

import Model.Part;
import Model.Solid;
import transforms.Mat4;

public class Renderer {

    private Mat4 viewMatrix;
    private Triangle triangle;
    private Line line;
    private Point point;



    public void render(Solid solid){
        for (Part part:solid.getParts()) {
         switch (part.getType()){
             case LINES:

                break;
             case TRIANGLES:

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
}
