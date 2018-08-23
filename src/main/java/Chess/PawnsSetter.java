package Chess;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


class PawnsSetter {

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
            "PawnsSetter/rook_Black_5.png",       //0
            "PawnsSetter/knight_Black_4.png",     //1
            "PawnsSetter/bishop_Black_3.png",     //2
            "PawnsSetter/queen_Black_2.png",      //3
            "PawnsSetter/king_Black_1.png",       //4
            "PawnsSetter/pawn_Black_6.png",       //5
            "PawnsSetter/rook_5.png",             //6
            "PawnsSetter/knight_4.png",           //7
            "PawnsSetter/bishop_3.png",           //8
            "PawnsSetter/queen_2.png",            //9
            "PawnsSetter/king_1.png",             //10
            "PawnsSetter/pawn_6.png"              //11
    };  */

    public Pane pane[][];

    PawnsSetter(Pane[][] pane) {
        this.pane = pane;
    }

    private void getHistory(){
        //TODO
    }

    public void loopingTheTab() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                choseYourIMG(tab[j][i], i, j);
            }
        }
    }

    public void choseYourIMG(int typeOfPawn, int i, int j){
          switch (typeOfPawn) {
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



    public void setPawn(String path, int i, int j, int pawnVar) {
        ImageView imageView = new ImageView(path);

        if (i == -1) {  //way for history ListView
            setImageView(imageView);
        }
        else {          //way for stting pawns on chess board


            AnchorPane p = new AnchorPane(imageView);

            AnchorPane.setBottomAnchor(imageView, 5.0);
            AnchorPane.setLeftAnchor(imageView, 5.0);
            AnchorPane.setRightAnchor(imageView, 5.0);
            AnchorPane.setTopAnchor(imageView, 5.0);

            p.setCenterShape(true);

            pane[i][j].getChildren().add(p);
        }
    }

    private ImageView img;
    private void setImageView(ImageView img){
        this.img = img;
    }

    public ImageView getImg() {
        return img;
    }

    public int[][] getTab() {
        return tab;
    }
}
