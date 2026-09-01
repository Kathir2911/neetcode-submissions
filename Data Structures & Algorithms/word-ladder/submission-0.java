class Solution {
    private static boolean canChange(String word1,String word2){
        int N=word1.length(),diff=0;
        for(int idx=0;idx<N;idx++){
            if(word1.charAt(idx)!=word2.charAt(idx)) diff++;
            if(diff>1) return false;
        }
        return diff==1;
    }

    private static int findIndex(String[] words,String word){
        for(int idx=0;idx<words.length;idx++){
            if(words[idx].equals(word)) return idx;
        }
        return -1;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int N=wordList.size();
        Deque<Integer> queue=new ArrayDeque<>();
        List<String>[] list=new ArrayList[N+1];
        for(int idx=0;idx<N+1;idx++){
            list[idx]=new ArrayList<>();
        }
        String[] words=new String[N+1];
        words[0]=beginWord;
        for(int idx=1;idx<=N;idx++) words[idx]=wordList.get(idx-1);
        for(int idx=0;idx<=N;idx++){
            for(int jdx=idx+1;jdx<=N;jdx++){
                if(canChange(words[idx],words[jdx])){
                    list[idx].add(words[jdx]);
                    list[jdx].add(words[idx]);
                }
            }
        }
        boolean[] visited=new boolean[N+1];
        queue.offer(0);
        visited[0]=true;
        int level=1;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int idx=0;idx<size;idx++){
                int current=queue.poll();
                if(words[current].equals(endWord)) return level;
                for(String neighbor:list[current]){
                    int next=findIndex(words,neighbor);
                    if(!visited[next]){
                        queue.offer(next);
                        visited[next]=true;
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
