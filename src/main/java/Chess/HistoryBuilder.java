package Chess;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class HistoryBuilder {

    private ListView historyList;

    HistoryBuilder(ListView historyList){
        this.historyList = historyList;
        listPropertySetter();
    }

    private History histories[] = new History[50];

    private int i = -1;

    private void create(){

    }
    private List<String> list = new ArrayList<>();

    public void addToList(int type, int xFrom, int yFrom, int xTo, int yTo){
        i++;
        histories[i] = new History.Builder()
                .type(type)
                .xFrom(xFrom)
                .yFrom(yFrom)
                .xTo(xTo)
                .yTo(yTo)
                .build();
        list.add(i, histories[i].toString());
        System.out.println(histories[i].toString());
        listProperty.set(FXCollections.observableArrayList(list));



        historyList.setCellFactory(param -> new ListCell<String>() {
            private ImageView imageView = new ImageView();
            @Override
            public void updateItem(String name, boolean empty) {
                super.updateItem(name, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    int start = 1;
                    if(name.startsWith("-")){
                        start = 2;
                    }

                    //String x = name.substring(start, name.length());      //HAHAHAHA nope
                    String x = name.substring(0,start);
                    System.out.println(x);

                    PawnsSetter pawnsSetter = new PawnsSetter(null);
                    pawnsSetter.choseYourIMG(Integer.parseInt(x), -1, 0);
                    imageView = pawnsSetter.getImg();
                    imageView.setFitWidth(30);
                    imageView.setFitHeight(30);
                    name = name.substring(start, name.length());

                    /*
                                                //StackOverFlow <3
                                         https://stackoverflow.com/questions/33592308/javafx-how-to-put-imageview-inside-listview

                    if(name.equals("RUBY"))
                        imageView.setImage(listOfImages[0]);
                    else if(name.equals("APPLE"))
                        imageView.setImage(listOfImages[1]);
                    else if(name.equals("VISTA"))
                        imageView.setImage(listOfImages[2]);
                    else if(name.equals("TWITTER"))
                        imageView.setImage(listOfImages[3]);
                        */
                    setText(name);
                    setGraphic(imageView);
                }
            }
        });


       // printElements(list);
//        System.out.println(historyCollection.size());
    }



    private ObservableList<String> historyCollection;
    private ListProperty<String> listProperty = new SimpleListProperty<>();

    private void listPropertySetter(){






       // historyCollection  = FXCollections.observableArrayList(list);

        historyList.itemsProperty().bind(listProperty);
    }



    private static void printElements(List<String> list) {
        for (Object o : list) {
            System.out.println(o.toString());
        }
    }
}
