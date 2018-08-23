package Chess;

import javafx.scene.control.ListView;
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
    private StackPane greyField;

    private Pawn pawn;

    private HistoryBuilder historyBuilder;

    PawnController_V2(AnchorPane pane[][], int tab[][], boolean white, StackPane greenField, StackPane greyField, ListView historyList) {
        this.pane = pane;
        this.tab = tab;
        this.white = white;
        this.greenField = greenField;
        this.greyField = greyField;
            pawn = new Pawn(tab);

            historyBuilder = new HistoryBuilder(historyList);

    }



    private int xx, yy;
    void setC(double x, double y) {
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

        private boolean posibleMoveForThisPawn(int x, int y) {

        if (absolute(tab[y1][x1]) == 6) {
            return pawn.posible(x, y, x1, y1, white);
        } else {
            System.out.println(tab[y1][x1]);
        }
/*
                    wtf... switch case doesn't work O_o
                        you can move any pawn(all id) like a pawn( 6 or -6 id) :O
                            i need to rename Pawn :D

        switch (absolute(tab[y1][x1])){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6: {
                return pawn.posible(x, y, x1, y1, white);
            }
        }
        return false;
    }
*/
    return false;
    }


    private void movingPawns(int toX, int toY){
        tab[toY][toX] = tab[y1][x1];
        tab[y1][x1] = 0;

        pane[toX][toY].getChildren().add(0, pane[x1][y1].getChildren().get(1));

        pane[x1][y1].getChildren().add(1, greyField);

        soutTab();
        setNewPawnSelectedValue();

        historyBuilder.addToList(tab[toY][toX], x1, y1, toX, toY);

        white = !white;     //Moved
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
        pane[x1][y1].getChildren().get(0).setVisible(true);         //show green squer
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
            pane[x1][y1].getChildren().get(0).setVisible(false);    //hide green squer
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
