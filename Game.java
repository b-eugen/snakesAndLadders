package snakesAndLadders;
import java.util.*;

public class Game {
    public final static int NUM_SQUARES = 100;
    public final static int NUM_SNAKES = 10;
    public final static int NUM_LADDERS = 10;
    public final static int DICE_MAX = 6;
    private Square[] squares;
    private ArrayList<Player> players;
    private Snake[] snakes;
    private Ladder[] ladders;

    public int getSquareSnakeStart(Square square)
    {
        int ind = 0;
        if (snakes.length > 0)
        {

            for(Snake snake:snakes)
            {
                if (snake==null)
                {
                    break;
                }
                if (snake.getStart().equals(square))
                {
                    return ind;
                }
                ind++;
            }
        }
        return -1;
    }

    public int getSquareLadderStart(Square square)
    {
        int ind = 0;
        if (ladders.length > 0)
        {

            for(Ladder ladder:ladders)
            {
                if (ladder==null)
                {
                    break;
                }
                if (ladder.getStart().equals(square))
                {
                    return ind;
                }
                ind++;
            }
        }
        return -1;
    }

    public boolean isSquareSnakeStart(Square square)
    {
        if (snakes.length > 0)
        {

            for(Snake snake:snakes)
            {
                if (snake==null)
                {
                    break;
                }
                // System.out.println(square+" "+snake);
                if (snake.getStart().equals(square))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSquareSnakeEnd(Square square)
    {
        if (snakes.length > 0)
        {
            
            for(Snake snake:snakes)
            {
                if (snake==null)
                {
                    break;
                }
                // System.out.println(square+" "+snake);
                if (snake.getEnd().equals(square))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSquareSnake(Square square)
    {
        return this.isSquareSnakeStart(square) || this.isSquareSnakeEnd(square);
    }

    public boolean isSquareLadderStart(Square square)
    {
        if (ladders.length > 0)
        {
            for(Ladder ladder:ladders)
            {
                if (ladder==null)
                {
                    break;
                }
                // System.out.println(square+" "+ladder + " "+ladders.length);
                if (ladder.getStart().equals(square))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSquareLadderEnd(Square square)
    {
        if (ladders.length >0)
        {
            for(Ladder ladder:ladders)
            {
                if (ladder==null)
                {
                    break;
                }
                // System.out.println(square+" "+ladder + " "+ladders.length);
                if (ladder.getEnd().equals(square))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSquareLadder(Square square)
    {
        return this.isSquareLadderStart(square) || this.isSquareLadderEnd(square);
    }

    public Game()
    {
        squares = new Square[NUM_SQUARES];
        for (int i=1; i<= NUM_SQUARES; i++)
        {
            squares[i-1]=new Square(i);
        }

        ladders=new Ladder[NUM_LADDERS];
        Random rand = new Random();
        for(int ind=0; ind<NUM_LADDERS; ind++)
        {
            int start = 100;
            int end = 100;
            do
            {
                start = rand.nextInt(NUM_SQUARES);
            }while (isSquareLadder(squares[start])==true);
            do
            {
                end = rand.nextInt(NUM_SQUARES);
            }while (isSquareLadder(squares[end])==true || start == end);
            ladders[ind] = new Ladder(squares[start], squares[end]);
        }

        snakes = new Snake[NUM_SNAKES];
        for(int ind=0; ind<NUM_SNAKES; ind++)
        {
            int start = 100;
            int end =100;
            do
            {
                start = rand.nextInt(NUM_SQUARES);
            }while ((isSquareSnake(squares[start])==true || isSquareLadder(squares[start])==true));

            do
            {
                end = rand.nextInt(NUM_SQUARES);
            }while ((isSquareSnake(squares[end])==true || isSquareLadder(squares[end])==true) || start == end);
            snakes[ind] = new Snake(squares[start], squares[end]);
        }

        players = new ArrayList<Player>();

    }

    public void printOut()
    {
        for(Snake snake: snakes)
        {
            System.out.println(snake.toString());
        }
        for(Ladder ladder: ladders)
        {
            System.out.println(ladder.toString());
        }
    }

    public void addPlayer(String name)
    {
        players.add(new Player(name));
    }

    public boolean step()
    {
        Random rand= new Random();
        for (Player player:players)
        {
            int roll  =rand.nextInt(DICE_MAX)+1;
            System.out.println(player + " rolls "+roll + " starting at "+player.getPosition());
            player.move(roll);
            
            
            if (player.getPosition().getNumber() >= 100)
            {
                System.out.println(player + " is victorious");
                return true;
            }
            int snakeStart = this.getSquareSnakeStart(player.getPosition());
            int ladderStart = this.getSquareLadderStart(player.getPosition());
            if (snakeStart>=0)
            {
                player.setSquare(snakes[snakeStart].getEnd());
                System.out.println("Player "+ player+" takes snake "+snakes[snakeStart]);
            }
            else if(ladderStart > 0)
            {
                player.setSquare(ladders[ladderStart].getEnd());
                System.out.println("Player "+ player+" takes ladder "+ladders[ladderStart]);
            }
        }
        return false;
    }
}
