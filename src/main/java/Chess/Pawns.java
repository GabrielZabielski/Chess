package Chess;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


import java.io.*;


class Pawns {

    private int tab[][] = {
            {5, 4, 3, 2, 1, 3, 4, 5},
            {6, 6, 6, 6, 6, 6, 6, 6},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, -5, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {-6, -6, -6, -6, -6, -6, -6, -6},
            {-5, -4, -3, -2, -1, -3, -4, -5}
    };
  /*  private String pawnsPNG[] ={
            "Pawns/rook_Black_5.png",       //0
            "Pawns/knight_Black_4.png",     //1
            "Pawns/bishop_Black_3.png",     //2
            "Pawns/queen_Black_2.png",      //3
            "Pawns/king_Black_1.png",       //4
            "Pawns/pawn_Black_6.png",       //5
            "Pawns/rook_5.png",             //6
            "Pawns/knight_4.png",           //7
            "Pawns/bishop_3.png",           //8
            "Pawns/queen_2.png",            //9
            "Pawns/king_1.png",             //10
            "Pawns/pawn_6.png"              //11
    };  */

    public Pane pane[][];

    Pawns(Pane[][] pane) {
        this.pane = pane;
        pawnsAddToBoard();

    }

    private void getHistory(){
        //TODO
    }

    private void pawnsAddToBoard() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
          switch (tab[j][i]) {
                    case 5:
                        setPawn("Pawns/rook_Black_5.png", i, j, 5);
                        break;
                    case 4:
                        setPawn("Pawns/knight_Black_4.png", i, j, 4);
                        break;
                    case 3:
                        setPawn("Pawns/bishop_Black_3.png", i, j, 3);
                        break;
                    case 2:
                        setPawn("Pawns/queen_Black_2.png", i, j, 2);
                        break;
                    case 1:
                        setPawn("Pawns/king_Black_1.png", i, j, 1);
                        break;
                    case 6:
                        setPawn("Pawns/pawn_Black_6.png", i, j, 6);
                        break;
                    case -5:
                        setPawn("Pawns/rook_5.png", i, j, -5);
                        break;
                    case -4:
                        setPawn("Pawns/knight_4.png", i, j, -4);
                        break;
                    case -3:
                        setPawn("Pawns/bishop_3.png", i, j, -3);
                        break;
                    case -2:
                        setPawn("Pawns/queen_2.png", i, j, -2);
                        break;
                    case -1:
                        setPawn("Pawns/king_1.png", i, j, -1);
                        break;
                    case -6:
                        setPawn("Pawns/pawn_6.png", i, j, -6);
                        break;
                }
            }
        }
    }



    private void setPawn(String path, int i, int j, int pawnVar){
        //System.out.println(i);
        ImageView imageView = new ImageView(path);

        AnchorPane p = new AnchorPane(imageView);
        AnchorPane.setBottomAnchor(imageView, 5.0);
        AnchorPane.setLeftAnchor(imageView, 5.0);
        AnchorPane.setRightAnchor(imageView, 5.0);
        AnchorPane.setTopAnchor(imageView, 5.0);

        p.setCenterShape(true);

        pane[i][j].getChildren().add(p);
    }

    public int[][] getTab() {
        return tab;
    }
}
