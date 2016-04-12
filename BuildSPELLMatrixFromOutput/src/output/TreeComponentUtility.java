package output;

import genericTree.Node;
import genericTree.Tree;
import java.util.ArrayList;

public class TreeComponentUtility {

    public static ArrayList<ComponentNode> getComponentNodesTotal(Tree<ComponentNode> tree) {
        ArrayList<ComponentNode> components = new ArrayList<ComponentNode>();
        
        Node<ComponentNode> root = tree.getRoot();
        
        getComponentNodesTotal(root, components);
        
        return components;
    }
    
    private static void getComponentNodesTotal(Node<ComponentNode> node, ArrayList<ComponentNode> components) {
        ComponentNode component = node.getData();
        int componentPosition = components.indexOf(component);
        if (componentPosition == -1) {
            components.add(component);
        }
        else {
            ComponentNode existentComponent = components.get(componentPosition);
            existentComponent.add(component);
        }
        
        for (Node<ComponentNode> child : node.getChildren()) {
            getComponentNodesTotal(child, components);
	}
    }
}
