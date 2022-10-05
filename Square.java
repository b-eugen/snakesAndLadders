package snakesAndLadders;

public class Square {
    private int number;
    public Square()
    {
        number = 1;
    }
    public Square(int number)
    {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
    public int incrementNumber(int increment) {
        this.number+= increment;
        return this.number;
    }

    public int setNumber(int number) {
        this.number= number;
        return this.number;
    }

    public String toString()
    {
        return Integer.toString(number);
    }

    public boolean equals(Square other)
    {
        if (other.number==this.number)
        {
            return true;
        }
        return false;
    }
}
