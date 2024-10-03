import java.util.*;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<List<String>>();
        
        // 如果endWord不在wordList中，直接返回空结果
        if (!wordList.contains(endWord)) {
            return res;
        }

        // 使用一个HashSet存储wordList以便快速查找
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return res;
        }

        // 前驱节点记录，记录每个单词的前驱单词集合
        HashMap<String, List<String>> predecessors = new HashMap<>();
        for (String word : wordSet) {
            predecessors.put(word, new ArrayList<>());
        }

        // 队列用于BFS，存储当前层次的单词
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        
        // 访问过的单词集合
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        boolean found = false;
        Set<String> currentLevelVisited = new HashSet<>();
        
        // BFS
        while (!queue.isEmpty() && !found) {
            int size = queue.size();
            currentLevelVisited.clear();

            // 遍历当前层的所有单词
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                
                // 对于每个单词，尝试改变它的每一位字母以找到相邻单词
                char[] wordArray = word.toCharArray();
                for (int j = 0; j < wordArray.length; j++) {
                    char originalChar = wordArray[j];
                    
                    // 尝试用26个字母替换该位置
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;
                        wordArray[j] = c;
                        String newWord = new String(wordArray);
                        
                        // 如果新单词在单词列表中
                        if (wordSet.contains(newWord)) {
                            // 如果找到了endWord
                            if (newWord.equals(endWord)) {
                                found = true;
                            }

                            // 如果是当前层第一次访问的单词，加入队列
                            if (!visited.contains(newWord)) {
                                if (!currentLevelVisited.contains(newWord)) {
                                    queue.add(newWord);
                                    currentLevelVisited.add(newWord);
                                }
                                // 记录前驱关系
                                predecessors.get(newWord).add(word);
                            }
                        }
                    }
                    // 恢复原始字符
                    wordArray[j] = originalChar;
                }
            }
            // 将当前层访问过的节点标记为已访问
            visited.addAll(currentLevelVisited);
        }

        // 如果找到了endWord，进行路径回溯
        if (found) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            backtrack(res, path, beginWord, endWord, predecessors);
        }

        return res;
    }

    // 回溯函数，用于生成所有路径
    private void backtrack(List<List<String>> res, List<String> path, String beginWord, String word,
                           HashMap<String, List<String>> predecessors) {
        if (word.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            res.add(temp);
            return;
        }

        // 回溯所有前驱节点
        for (String predecessor : predecessors.get(word)) {
            path.add(predecessor);
            backtrack(res, path, beginWord, predecessor, predecessors);
            path.remove(path.size() - 1);
        }
    }
}
