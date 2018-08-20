package Chess;

import javafx.scene.effect.BlendMode;
import javafx.scene.effect.Glow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.awt.*;

public class PawnController_V2 {

    private AnchorPane pane[][];
    private  int tab[][];
    private boolean white;
    private boolean check = false;
    private StackPane greenField;

    private Pawn pawn;


    PawnController_V2(AnchorPane pane[][], int tab[][], boolean white, StackPane greenField) {
        this.pane = pane;
        this.tab = tab;
        this.white = white;
        this.greenField = greenField;
            pawn = new Pawn(tab);

    }



    public int xx, yy;
    public void setC(double x, double y) {
        this.xx = parse(x / 74, 0);
        this.yy = parse(y / 74, 0);
        //System.out.println(xx + "  y  " + yy);
        //System.out.println(tab[yy][xx]);

        try {
            if (white && tab[yy][xx] < 0) {
                pane[xx][yy].getChildren().add(0, greenField);
                setPawnSelected(xx, yy);
            }
            else if (!white && tab[yy][xx] > 0) {
                pane[xx][yy].getChildren().add(0, greenField);
                setPawnSelected(xx, yy);
            }
            else if (posibleMoveForThisPawn(xx, yy)) {
                movingPawns(xx, yy);
            }
        } catch (IllegalArgumentException e) {     /*nothing*/ }
        catch (ArrayIndexOutOfBoundsException e) {     /*nothing*/ }

    }

    private boolean posibleMoveForThisPawn(int x, int y){


        switch (absolute(tab[y1][x1])){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return pawn.posible(x, y, x1, y1, white);

        }
        return false;
    }

    private void movingPawns(int x, int y){
        tab[y][x] = tab[y1][x1];
        tab[y1][x1] = 0;
        pane[x][y].getChildren().add(0, pane[x1][y1].getChildren().get(1));
        setNewPawnSelectedValue();
        white = !white;
        soutTab();
    }

    private void soutTab(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                System.out.print(tab[i][j]+" ");
            }
            System.out.println(" ");
        }
    }


    private int x1, y1;
    private void setPawnSelected(int x1, int y1){
        this.x1 = x1;
        this.y1 = y1;
    }
    private int getx1(){
        return x1;
    }
    private int gety1(){
        return y1;
    }
    private void setNewPawnSelectedValue(){
        x1 = - 20;
        y1 = - 20;
    }

    private int j = 0;
    private int parse ( double i, int j){
        if (i < 1) {
            return j;
        }
        if (i > 8) {
            return 7;
        } else {
            j++;
            return parse(i - 1, j);
        }
    }

    private int absolute(int x){
        if(x < 0){
            System.out.println(x);
            return -x;
        }
        else return x;
    }
}
