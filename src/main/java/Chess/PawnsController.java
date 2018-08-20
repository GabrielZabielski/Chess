package Chess;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.*;

public class PawnsController {

    private AnchorPane pane[][];
    private int tab[][];
    private boolean white = true;


    PawnsController(AnchorPane pane[][], int tab[][]) {
        this.pane = pane;
        this.tab = tab;


        mainMove();
    }


    private void mainMove(){
        //Mo¿liwoœæ wyboru
                //Czyj ruch?
                //Zmiana wybranego pionka - powrót do pocz¹tku
        //Mo¿liwe ruchy
        //Zmiana gracza

        startNewTure();
        System.out.println("done");


    }


    private void startNewTure(){
        System.out.println("Start new ture");
        System.out.println(white);
        int bigger, smaller;
        if(white){
            smaller = -7;
            bigger = 0;
        } else {
            smaller = 0;
            bigger = 7;
        }

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(tab[i][j] > smaller && tab[i][j] < bigger) {
                    pane[j][i].addEventHandler(MouseEvent.MOUSE_CLICKED, getMove);
                }
            }
        }
    }

private void posibleMoves(int type, int x, int y){

        if(type < 0 && type != -6 ){
            type = -type;
        }

        switch (type){
            case 1: //king
                king(x, y);
            case 2:
            case 3:
            case 4:
            case 5:
                rook(x,y);
                setPosibleMoves(type, x, y);
            case 6:
                pawn6(x,y);
                setPosibleMoves(type, x, y);
            case -6:
                pawn7(x,y);
                setPosibleMoves(type, x, y);

        }
}

    private void pawn6(int x, int y) {
        if (y == 1) {
            try {
                pane[x ][y +2].addEventHandler(MouseEvent.MOUSE_CLICKED, getMoveTo);
            } catch (IndexOutOfBoundsException e) {    /*nothing */ }
            try {
                pane[x ][y +1].addEventHandler(MouseEvent.MOUSE_CLICKED, getMoveTo);
            } catch (IndexOutOfBoundsException e) {    /*nothing */ }
        } else {
            try {
                pane[x ][y +1].addEventHandler(MouseEvent.MOUSE_CLICKED, getMoveTo);
            } catch (IndexOutOfBoundsException e) {    /*nothing */ }
        }
    }
    private void removePawn6(int x, int y){
        if (y == 6) {
            try {
                pane[x ][y +2].removeEventHandler(MouseEvent.MOUSE_CLICKED, getMoveTo);
            } catch (IndexOutOfBoundsException e) {    /*nothing */ }
            try {
                pane[x ][y +1].removeEventHandler(MouseEvent.MOUSE_CLICKED, getMoveTo);
            } catch (IndexOutOfBoundsException e) {    /*nothing */ }
        } else {
            try {
                pane[x ][y +1].removeEventHandler(MouseEvent.MOUSE_CLICKED, getMoveTo);
            } catch (IndexOutOfBoundsException e) {    /*nothing */ }
        }
    }

    private void pawn7(int x, int y) {
        if (y == 6) {
            try {
                pane[x ][y -2].addEventHandler(MouseEvent.MOUSE_CLICKED, getMoveTo);
            } catch (IndexOutOfBoundsException e) {    /*nothing */ }
            try {
                pane[x ][y -1].addEventHandler(MouseEvent.MOUSE_CLICKED, getMoveTo);
            } catch (IndexOutOfBoundsException e) {    /*nothing */ }
        } else {
            try {
                pane[x ][y -1].addEventHandler(MouseEvent.MOUSE_CLICKED, getMoveTo);
            } catch (IndexOutOfBoundsException e) {    /*nothing */ }
        }
    }
    private void removePawn7(int x, int y){
        if (y == 6) {
            try {
                pane[x ][y -2].removeEventHandler(MouseEvent.MOUSE_CLICKED, getMoveTo);
            } catch (IndexOutOfBoundsException e) {    /*nothing */ }
            try {
                pane[x ][y -1].removeEventHandler(MouseEvent.MOUSE_CLICKED, getMoveTo);
            } catch (IndexOutOfBoundsException e) {    /*nothing */ }
        } else {
            try {
                pane[x ][y -1].removeEventHandler(MouseEvent.MOUSE_CLICKED, getMoveTo);
            } catch (IndexOutOfBoundsException e) {    /*nothing */ }
        }
    }



    private void king(int x, int y){
        try {
            pane[x + 1][y + 1].addEventHandler(MouseEvent.MOUSE_CLICKED, getMoveTo);
        } catch (IndexOutOfBoundsException e ) {    /*nothing */   }
        try {
            pane[x+1][y].addEventHandler(MouseEvent.MOUSE_CLICKED,getMoveTo);
        } catch (IndexOutOfBoundsException e ) {    /*nothing */   }
        try{
            pane[x+1][y-1].addEventHandler(MouseEvent.MOUSE_CLICKED,getMoveTo);
        } catch (IndexOutOfBoundsException e ) {    /*nothing */   }
        try{
            pane[x][y+1].addEventHandler(MouseEvent.MOUSE_CLICKED,getMoveTo);
        } catch (IndexOutOfBoundsException e ) {    /*nothing */   }
        try{
            pane[x][y-1].addEventHandler(MouseEvent.MOUSE_CLICKED,getMoveTo);
        } catch (IndexOutOfBoundsException e ) {    /*nothing */   }
        try{
            pane[x+1][y].addEventHandler(MouseEvent.MOUSE_CLICKED,getMoveTo);
        } catch (IndexOutOfBoundsException e ) {    /*nothing */   }
        try{
            pane[x-1][y].addEventHandler(MouseEvent.MOUSE_CLICKED,getMoveTo);
        } catch (IndexOutOfBoundsException e ) {    /*nothing */   }
        try{
            pane[x-1][y-1].addEventHandler(MouseEvent.MOUSE_CLICKED,getMoveTo);
        } catch (IndexOutOfBoundsException e ) {    /*nothing */   }
    }

    private void rook(int x, int y){
        System.out.println("rook");
        for(int i = x+1; i < 8; i++){
            System.out.println("wtf");
            if(tab[y][i] == 0){
                System.out.println(i);
                pane[i][y].addEventHandler(MouseEvent.MOUSE_CLICKED, getMoveTo);
            } else break;
        }
        for(int i = x-1; i >= 0; i--){
            if(tab[y][i] == 0){
                System.out.println(i);
                pane[i][y].addEventHandler(MouseEvent.MOUSE_CLICKED, getMoveTo);
            } else break;
        }
        for(int i = y+1; i < 8; i++){
            if(tab[i][x] == 0){
                System.out.println(i);
                pane[x][i].addEventHandler(MouseEvent.MOUSE_CLICKED, getMoveTo);
            } else break;
        }
        for(int i = y-1; i >= 0; i--){
            if(tab[i][x] == 0){
                System.out.println(i);
                pane[x][i].addEventHandler(MouseEvent.MOUSE_CLICKED, getMoveTo);
            } else break;
        }
    }

    private void removeRook(int x, int y){
        System.out.println("rook");
        for(int i = x+1; i < 8; i++){
            System.out.println("wtf");
            if(tab[y][i] == 0){
                System.out.println(i);
                pane[i][y].removeEventHandler(MouseEvent.MOUSE_CLICKED, getMoveTo);
            } else break;
        }
        for(int i = x-1; i >= 0; i--){
            if(tab[y][i] == 0){
                System.out.println(i);
                pane[i][y].removeEventHandler(MouseEvent.MOUSE_CLICKED, getMoveTo);
            } else break;
        }
        for(int i = y+1; i < 8; i++){
            if(tab[i][x] == 0){
                System.out.println(i);
                pane[x][i].removeEventHandler(MouseEvent.MOUSE_CLICKED, getMoveTo);
            } else break;
        }
        for(int i = y-1; i >= 0; i--){
            if(tab[i][x] == 0){
                System.out.println(i);
                pane[x][i].removeEventHandler(MouseEvent.MOUSE_CLICKED, getMoveTo);
            } else break;
        }
    }


                    //  ACTIONS EVENTS

        public EventHandler<MouseEvent> getMove = (MouseEvent e) -> {
            int x = parse((e.getSceneX() - 255) / 74, 0);
            int y = parse((e.getSceneY() - 84) / 74, 0);
            System.out.println("1st move");

                nc = new NodeController(pane[x][y].getChildren().get(0));

                removeEventHandler1();

            posibleMoves(tab[y][x], x ,y);
        };

        public EventHandler<MouseEvent> getMoveTo = e -> {
            int x = parse((e.getSceneX() - 255) / 74, 0);
            int y = parse((e.getSceneY() - 84) / 74, 0);
            System.out.println("2ed move");

            pane[x][y].getChildren().add(geeeetNodeController());
            removeEventHandlerPosibleMoves();
        };




                   //   Pomocnicze

    private void removeEventHandlerPosibleMoves(){
        if(typeOfPawn < 0 && typeOfPawn != -6 ){
            typeOfPawn = -typeOfPawn;
        }

        switch (typeOfPawn){
            case 1: //king

            case 2:
            case 3:
            case 4:
            case 5:
                removeRook(xx,yy);
            case 6:
                removePawn6(xx,yy);
            case -6:
                removePawn7(xx,yy);
        }
        white = !white;
        startNewTure();
    }

    private NodeController nc;
    private int typeOfPawn, xx, yy;

    private void setPosibleMoves(int type, int x, int y){
        this.typeOfPawn = type;
        this.xx = x;
        this.yy = y;
    }


    private void setNodeController(NodeController nc){
        this.nc = nc;
    }

    private Node geeeetNodeController(){
        return nc.getNodeController();
    }

    private void removeEventHandler1(){
            System.out.println("reemove 1st eventhandler");
            int bigger, smaller;
            if(white){
                System.out.println(true);
                smaller = -7;
                bigger = 0;
            } else {
                smaller = 0;
                bigger = 7;
            }

            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    if(tab[i][j] > smaller && tab[i][j] < bigger) {
                        pane[j][i].removeEventHandler(MouseEvent.MOUSE_CLICKED, getMove);
                    }
                }
            }
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
                return parse(i - 1, j);  //TODO
            }
        }

}

