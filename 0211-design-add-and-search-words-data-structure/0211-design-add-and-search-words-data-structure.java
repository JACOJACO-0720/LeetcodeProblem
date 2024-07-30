class WordDictionary {
    Node rootroot;
    
    public WordDictionary() {
        rootroot = new Node();
    }
    
    public void addWord(String word) {
        Node current = rootroot;
        for (int i = 0; i < word.length(); i++) {
            char tmp = word.charAt(i);
            if(current.nodeList[tmp-'a'] ==null){
                Node node = new Node();
                current.nodeList[tmp-'a']=node;
                current = current.nodeList[tmp-'a'];
                if(i==(word.length()-1)){
                    current.isWord=true;
                }
            }else{
                current = current.nodeList[tmp-'a'];
                if(i==(word.length()-1)){
                    current.isWord=true;
                }
            }
        }
    }
    
    public boolean search(String word) {
        if(word==null){
            return false;
        }

        Node current = rootroot;
        char tmp = word.charAt(0);
        if(word.length()==1){
            if(tmp=='.'){
                for (int i = 0; i < 26; i++) {
                    if(rootroot!=null&& current.nodeList[i]!=null && current.nodeList[i].isWord==true){
                        return true;
                    }
                }
                return false;
            }else{
                if(rootroot!=null&&rootroot.nodeList[tmp-'a']!=null&&rootroot.nodeList[tmp-'a'].isWord==true){
                    return true;
                }else{
                    return false;
                }
            }
        }

        if(tmp=='.'){
            for (int i = 0; i < 26; i++) {
                if(rootroot!=null&&current.nodeList[i]!=null ){
                    if(searchHelper(rootroot.nodeList[i], word.substring(1))==true){
                        return true;
                    }
                }
            }
            return false;
        }else{
            if(rootroot!=null&&rootroot.nodeList[tmp-'a']==null){
                return false;
            }else{
                return searchHelper(rootroot.nodeList[tmp-'a'], word.substring(1));
            }
        }
        
    }

    public boolean searchHelper(Node root, String word){
        if(word==null){
            return false;
        }

        Node current = root;
        char tmp = word.charAt(0);
        if(word.length()==1){
            if(tmp=='.'){
                for (int i = 0; i < 26; i++) {
                    if(current.nodeList[i]!=null && current.nodeList[i].isWord==true){
                        return true;
                    }
                }
                return false;
            }else{
                if(root.nodeList[tmp-'a']!=null&&root.nodeList[tmp-'a'].isWord==true){
                    return true;
                }else{
                    return false;
                }
            }
        }

        if(tmp=='.'){
            for (int i = 0; i < 26; i++) {
                if(current.nodeList[i]!=null ){
                    if(searchHelper(root.nodeList[i], word.substring(1))==true){
                        return true;
                    }
                }
            }
            return false;
        }else{
            if(root.nodeList[tmp-'a']==null){
                return false;
            }else{
                return searchHelper(root.nodeList[tmp-'a'], word.substring(1));
            }
        }
    }

    class Node {
        boolean isWord = false;
        Node[] nodeList; 
        public Node(){
            nodeList= new Node[26];
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */