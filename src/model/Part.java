package Model;

public class Part {
    private final Types type;
    private final int start;
    private final int count;

    public Part(Types type, int start, int count) {
        this.type = type;
        this.start = start;
        this.count = count;
    }

    public Types getType() {
        return type;
    }

    public int getStart() {
        return start;
    }

    public int getCount() {
        return count;
    }
}
