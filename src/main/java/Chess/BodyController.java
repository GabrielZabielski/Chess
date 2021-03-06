package Chess;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class BodyController {

    @FXML
    private GridPane boardcenter;
    @FXML
    private StackPane greenField;
    @FXML
    private StackPane greyField;




    private AnchorPane pane[][] = new AnchorPane[8][8];
    private int tab[][];
    private boolean white = true;
    private PawnController_V2 pawnController_v2;

    public void initialize(){

    fieldsBuilder();

    // add pawnsSetter to the board
    PawnsSetter pawnsSetter = new PawnsSetter(pane);
    pawnsSetter.loopingTheTab();
    this.tab = pawnsSetter.getTab();

    //PawnsController pawnsController = new PawnsController(pane, tab);

        pawnController_v2 = new PawnController_V2(pane,tab, white, greenField, greyField, historyList);
        boardcenter.addEventHandler(MouseEvent.MOUSE_CLICKED, setClick);

    }

    private EventHandler<MouseEvent> setClick = e -> {
        double x =e.getX();
        double y =e.getY();
        pawnController_v2.setC(x, y);
    };


    private void fieldsBuilder(){
        for(int i = 0; i<8;i++){
            for (int j = 0; j<8;j++){

                pane[i][j] = new AnchorPane();
                boardcenter.add(pane[i][j], i, j);

                if((i % 2 == 0 && j % 2 == 0)||(i % 2 == 1 && j % 2 == 1)) {
                    pane[i][j].setStyle("-fx-background-color: white;");
                } else{
                    pane[i][j].setStyle("-fx-background-color: black;");
                }
            }
        }

    }


    @FXML
    private ListView<String> historyList;

}

