package solutions.DesignAndDatastructuresProblems;

public class DesignAddAndSearchWordsDataStructure {

    static class Node{
        Node[] childs;
        boolean isWord;
        Node(){
            isWord = false;
            childs = new Node[26];
        }
        boolean addLetter(char c){
            int idx = c - 'a';
            if(childs[idx] == null){
                childs[idx] = new Node();
                return true;
            }
            return false;
        }
        Node getChild(char c){
            int idx = c - 'a';
            return childs[idx];
        }
        Node getChild(int idx){
            if(idx < 0 || idx >= 26)
                return null;
            return childs[idx];
        }
    }
        Node root;
        public DesignAddAndSearchWordsDataStructure() {
            root = new Node();
        }

        public void addWord(String word) {
            Node node = root;
            for(int i = 0 ; i< word.length(); i++){
                node.addLetter(word.charAt(i));
                node = node.getChild(word.charAt(i));
            }
            node.isWord = true;
        }

        public boolean search(String word) {
            return search(0,word,root);
        }
        private boolean search(int idx, String word,Node node){

            if(node == null)
                return false;
            if(idx == word.length()){
                return node.isWord;
            }


            if(word.charAt(idx) != '.')
                return search(idx+1,word,node.getChild(word.charAt(idx)));
            for(int i= 0; i < 26; i++){
                boolean result = search(idx+1,word,node.getChild(i));
                if(result)
                    return true;
            }
            return false;
        }


    public static void main(String[] args) {
            DesignAddAndSearchWordsDataStructure d = new DesignAddAndSearchWordsDataStructure();
            d.addWord("bad");
        System.out.println(d.search("bad"));
    }
}
