package Chess;


import javafx.scene.Node;

public class NodeController {

    private Node node;

    NodeController(Node node){
        System.out.println("no co� mam");
        this.node = node;
    }

    public Node getNodeController(){
        return node;
    }
}
