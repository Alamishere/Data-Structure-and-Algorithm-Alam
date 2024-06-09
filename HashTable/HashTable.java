import java.util.ArrayList;

public class HashTable {

    private int size=7;
    private Node [] dataNodes;

    public HashTable(){
        dataNodes = new Node[size];
    }

    public class Node {
        private String key;
        private int value;
        private Node nextNode;
    
        public Node(String key, int value){
            this.key= key;
            this.value=value;
        }
    }
    public void printTable(){
        for(int i=0;i<dataNodes.length;i++){
            System.out.println(i+":");
            Node tempNode = dataNodes[i];
            while(tempNode!=null){
                System.out.println("   {"+ tempNode.key +"= "+ tempNode.value+ "}");
                tempNode=tempNode.nextNode;
            }
            
        }
    }

    private int hash(String key){
        int hash=0;
        char[] keyChars = key.toCharArray();
        for(int i=0;i< keyChars.length;i++){
            int asciiValue = keyChars[i];
            hash = (hash+asciiValue*23) % dataNodes.length;
        }
        return hash;
    }

    public void set(String key, int value){
        int index = hash(key);
        Node newNode = new Node(key, value);
        if(dataNodes[index] == null){
            dataNodes[index] = newNode;
        }
        else{
            Node temp = dataNodes[index];
            while(temp.nextNode != null){
                temp= temp.nextNode;
            }
            temp.nextNode = newNode;
        }
    }

    public int get(String key){
        int index =  hash(key);
        Node temp = dataNodes[index];
        while(temp != null){
            if(temp.key == key){
                temp = temp.nextNode;
                return temp.value;           
        }
    }
        return 0;
    }

    public ArrayList keys(){
        ArrayList<String> allKeys = new ArrayList<>();
        for(int i=0; i<dataNodes.length;i++){
            Node temp = dataNodes[i];
            while(temp != null){
                allKeys.add(temp.key);
                temp = temp.nextNode;
            }
        }
        return allKeys;
    }

    
}

    

