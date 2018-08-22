package Chess;

public class Pawn {

    private int[][] tab;
    private boolean white;

    Pawn(int[][] tab){
    this.tab = tab;
    }

    public boolean posible(int x, int y,  int x1, int y1, boolean white){
        if(white){

            if(y1 == 6 && x == x1 && y == y1-2){                    // check if its 1st move
                if(tab[y1-1][x] == 0 && tab[y1-2][x] == 0){         // check if empty
                    return true;
                }
            }
            else if(y == y1-1 && tab[y][x] == 0 && x == x1){        // normal move
                return true;
            }
            else if(y == y1-1 && ((x == x1 -1 && tab[y][x-1] > 0) || (x == x1 +1 && tab[y][x+1] > 0))){
                return true;
            }
        }
        else if(!white){
            if(y1 == 1 && x == x1 && y == y1+2){                    // check if its 1st move
                if(tab[y1+1][x] == 0 && tab[y1+2][x] == 0){         // check if empty
                    return true;
                }
            }
            else if(y == y1+1 && tab[y][x] == 0 && x == x1){        // normal move
                return true;
            }
        }
        return false;
    }
}