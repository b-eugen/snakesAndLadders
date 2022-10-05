package snakesAndLadders;

public class Snake extends Move{
    Snake()
    {
        super();
    }
    Snake(Square sq1, Square sq2)
    {
        super(sq1, sq2);
        if (sq1.getNumber() < sq2.getNumber())
        {
            super.swapSquares();
        }
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Snake: "+super.toString();
    }

    
}
