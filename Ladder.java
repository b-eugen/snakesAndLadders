package snakesAndLadders;

public class Ladder extends Move{
    Ladder()
    {
        super();
    }
    Ladder(Square sq1, Square sq2)
    {
        super(sq1, sq2);
        if (sq1.getNumber() > sq2.getNumber())
        {
            super.swapSquares();
        }
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Ladder: "+super.toString();
    }

    
}
