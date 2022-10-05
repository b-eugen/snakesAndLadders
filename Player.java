package snakesAndLadders;

public class Player {
    private Square position;
    private String name;

    public Player()
    {
        this.position = new Square();
        this.name = "Player";
    }

    public Player(String name)
    {
        this.position = new Square();
        this.name = name;
    }

    public int move(int move)
    {
        return position.incrementNumber(move);
    }

    // public int setSquare(int number)
    // {
    //     return position.setNumber(number);
    // }
    public Square setSquare(Square new_postition)
    {
        return position=new_postition;
    }

    public Square getPosition()
    {
        return position;
    }
    public String toString()
    {
        return name;
    }
}
