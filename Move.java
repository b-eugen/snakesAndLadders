package snakesAndLadders;

public abstract class Move {
    private Square start;
    private Square end;
    public Move()
    {
        start = new Square();
        end = new Square();
    }

    public Move(Square start, Square end)
    {
        this.start=start;
        this.end = end;
    }

    public Square getStart() {
        return start;
    }

    public Square getEnd()
    {
        return end;
    }

    public String toString()
    {
        return String.format("Start: %s, End: %s", start, end);
    }

    public void swapSquares()
    {
        Square placeholder = start;
        start=end;
        end=placeholder;
    }

}
