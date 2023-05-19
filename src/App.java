import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
    
}


// functions
//   public Node buildBalancedBst(Node root) {
//         List<Node> nodes = new ArrayList<>();
//         inorderTraversal(root, nodes);
//         return buildBalancedBstHelper(nodes, 0, nodes.size() - 1);
//     }
public Node buildBalancedBst(Node root){
    List<Node> nodes=new ArrayList<>();
    inorderTraversal(root,nodes);
    return buildBalancedBstHelper(nodes,0,nodes.size()-1);
}


    // private void inorderTraversal(Node root, List<Node> nodes) {
    //     if (root == null) {
    //         return;
    //     }
    //     inorderTraversal(root.left, nodes);
    //     nodes.add(root);
    //     inorderTraversal(root.right, nodes);
    // }
    private void inorderTraversal(Node root,List<Node> nodes){
        if(root==null){
            return;
        }
        inorderTraversal(root.left, nodes);
        nodes.add(root);
        inorderTraversal(root.right, nodes);
    }

    private Node buildBalancedBstHelper(List<Node> nodes, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        Node root = nodes.get(mid);
        root.left = buildBalancedBstHelper(nodes, left, mid - 1);
        root.right = buildBalancedBstHelper(nodes, mid + 1, right);
        return root;
    }

    
}

class Node{
    int val;
    Node left;
    Node right;
    public Node(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
}