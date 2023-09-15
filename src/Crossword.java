import java.util.Arrays;

public class Crossword {

    private Square[][] puzzle;

    private int count;

    public Crossword(boolean[][] blackSquares)
    {
        count =1;
        puzzle = new Square[blackSquares.length][blackSquares[1].length];
        for(int i = 0; i<blackSquares.length; i++){
            for(int j = 0; j<blackSquares[1].length; j++){
                if(toBeLabeled(i,j,blackSquares)) {
                    puzzle[i][j] = new Square(blackSquares[i][j], count);
                    count++;
                }
                else{
                    puzzle[i][j] = new Square(blackSquares[i][j], 0);
                }
            }
        }

    }

    private boolean toBeLabeled(int r, int c, boolean[][] blackSquares)
    {
        if(!blackSquares[r][c]) {
            if((r-1==-1||blackSquares[r-1][c]) && (c-1==-1|| blackSquares[r][c-1])){
                return true;
            }
            else if(r-1==-1||blackSquares[r-1][c]){
                return true;
            }
            else if(c-1==-1|| blackSquares[r][c-1]){
                return true;
            }

        }
        return false;

    }

    public Square[][] getPuzzle(){
        return puzzle;
    }


}