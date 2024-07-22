class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node current = root;
        int offset = 0;
        for (int i = 0; i < word.length(); i++) {
            offset = word.charAt(i)-'a';
            if(current.NodeArray[offset]==null){
                Node tempNode = new Node();
                current.NodeArray[offset]= tempNode;
                current = tempNode;
            }else{
                current = current.NodeArray[offset];
            }
        }
        current.isWord = true;
        
    }
    
    public boolean search(String word) {
        Node current = root;
        int offset = 0;
        for (int i = 0; i < word.length(); i++) {
            offset = word.charAt(i)-'a';
            if(current.NodeArray[offset]==null){
                return false;
            }else{
                current = current.NodeArray[offset];
            }
        }
        if(current.isWord == true){
            return true;
        }else{
            return false;
        }
        
    }
    
    public boolean startsWith(String prefix) {
        Node current = root;
        for (int i = 0; i < prefix.length(); i++) {
            int offset = prefix.charAt(i)-'a';
            if(current.NodeArray[offset]==null){
                return false;
            }else{
                current = current.NodeArray[offset];
            }
        }
        return true;
    }

    public class Node{
        Node[] NodeArray = new Node[26];
        boolean isWord;
        public Node(){
            isWord = false;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */