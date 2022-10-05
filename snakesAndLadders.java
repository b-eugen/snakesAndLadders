package snakesAndLadders;

public class snakesAndLadders {
    public static void main(String[] main)
    {
        Game game = new Game();
        game.printOut();
        game.addPlayer("Jack");
        game.addPlayer("John");
        int ind = 1;
        do
        {
            System.out.println("Move "+ind++);
        }while (!game.step());
    }

    
}
