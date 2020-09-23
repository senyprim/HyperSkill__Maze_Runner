package maze;

public enum  Block {
    EMPTY(0,"  "),
    WALL(1,"\u2588\u2588"),
    PATH(2,"//");
    private int value;
    private String content;
    Block(int value, String content){
        this.value=value;
        this.content=content;
    }

    public int getValue() {
        return value;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return getContent();
    }
}
