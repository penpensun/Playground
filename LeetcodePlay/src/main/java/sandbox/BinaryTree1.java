package sandbox;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class BinaryTree1 {
    static class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node () {
            value = -1;
            leftChild = null;
            rightChild = null;
        }

        public Node (int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }
        public void setValue(int value){
            this.value = value;
        }

        public Node getLeftChild (){
            return leftChild;
        }
        public Node getRightChild () {
            return rightChild;
        }

        public void setLeftChild (Node leftChild){
            this.leftChild = leftChild;
        }

        public void setRightChild (Node rightChild){
            this.rightChild = rightChild;
        }
    }

    Node rootNode;

    public BinaryTree1(Node rootNode){
        this.rootNode = rootNode;
    }
    public void insertValue(int newVal){
        Node currentNode = rootNode;
        while(true){
            if (newVal >= currentNode.getValue()) {
                if (currentNode.getRightChild() == null) {
                    currentNode.setRightChild(new Node(newVal));
                    break;
                }
                else currentNode = currentNode.getRightChild();
            } else {
                if (currentNode.getLeftChild() == null) {
                    currentNode.setLeftChild(new Node(newVal));
                    break;
                }
                else currentNode = currentNode.getLeftChild();
            }
        }
    }

    public Node search(int val){
        Node currentNode = this.rootNode;
        while (true) {
            if (currentNode == null)
                return null;
            if (currentNode.getValue() == val)
                return currentNode;
            else if (val >= currentNode.getValue())
                currentNode = currentNode.getRightChild();
            else currentNode = currentNode.getLeftChild();
        }
    }

    public int delete(Node n){

        return n.getValue();
    }

    public static Node[] bfs (BinaryTree1 bt){
        if (bt.rootNode == null)
            return null;
        ArrayList<Node> nodes = new ArrayList<>();
        ArrayDeque<Node> toVisit= new ArrayDeque<>();
        toVisit.add(bt.rootNode);
        while(!toVisit.isEmpty()){
            Node currentNode = toVisit.removeFirst();
            nodes.add(currentNode);
            if (currentNode.getLeftChild() != null)
                toVisit.add(currentNode.getLeftChild());
            if (currentNode.getRightChild() != null)
                toVisit.add(currentNode.getRightChild());
        }
        Node[] ans = new Node[nodes.size()];
        nodes.toArray(ans);
        return ans;
    }

    public static void main(String args[]){
        Node n1 = new Node(1);
        BinaryTree1 bt1 = new BinaryTree1(n1);
        bt1.insertValue(-1);
        bt1.insertValue(2);
        bt1.insertValue(-5);
        bt1.insertValue(-3);
        bt1.insertValue(4);
        Node n[] = BinaryTree1.bfs(bt1);
        for (int i=0;i<n.length;i++)
            System.out.println(n[i].getValue());
    }

}
