import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int startWord = 0;
        int curword = 0;
        int curwidth = 0;
        int curspaceWithoutSpace=0;
        while(curword<words.length){
            if(curwidth + words[curword].length() <=maxWidth){
                curwidth = curwidth + words[curword].length()+1;
                curspaceWithoutSpace = curspaceWithoutSpace + words[curword].length();
                curword++;
            }else{
                StringBuilder tempSB = new StringBuilder();
                if(curword-startWord==1){
                    int remainSpace = maxWidth - curspaceWithoutSpace;
                    tempSB.append(words[startWord]);
                    for (int i = 0; i < remainSpace ; i++) {
                        tempSB.append(" ");
                    }
                }else{
                    int avgSpace = (maxWidth - curspaceWithoutSpace)/(curword-startWord-1);
                    int firstAddOneNum = (maxWidth - curspaceWithoutSpace)%(curword-startWord-1);
                    for (int i = startWord; i < startWord+firstAddOneNum; i++) {
                        tempSB.append(words[i]);
                        for (int j = 0; j < avgSpace+1; j++) {
                            tempSB.append(" ");
                        }
                    }
                    for (int i = startWord+firstAddOneNum; i < curword; i++) {
                        tempSB.append(words[i]);
                        if(i!=curword-1){
                            for (int j = 0; j < avgSpace; j++) {
                                tempSB.append(" ");
                            }
                        }

                    }
                }

                res.add(tempSB.toString());
                startWord = curword;
                curwidth = 0;
                curspaceWithoutSpace = 0;
            }
        }
        StringBuilder tempSB = new StringBuilder();
        for (int i = startWord; i < curword; i++) {
            tempSB.append(words[i]);
            if(i!=curword-1){
                tempSB.append(" ");
            }

        }
        while(tempSB.length()<maxWidth){
            tempSB.append(" ");
        }
        res.add(tempSB.toString());
        return res;
    }
}