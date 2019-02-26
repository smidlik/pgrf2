package Model;

public class Arrow extends Solid{

    public Arrow(){
        vertexBuffer.add(new Vertex());//0
        vertexBuffer.add(new Vertex());//1
        vertexBuffer.add(new Vertex());//2
        vertexBuffer.add(new Vertex());//3
        vertexBuffer.add(new Vertex());//4

        indexBuffer.add(0);indexBuffer.add(1); //LINE
        indexBuffer.add(2);indexBuffer.add(3);indexBuffer.add(4); //Triangle

        parts.add(new Part(Types.LINES,0,1));
        parts.add(new Part(Types.TRIANGLES,2,1));
    }


}
