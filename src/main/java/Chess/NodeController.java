package Chess;


import javafx.scene.Node;

public class NodeController {

    private Node node;

    public NodeController(Node node){

        this.node = node;
    }

    public Node getNodeController(){
        return node;
    }
}
