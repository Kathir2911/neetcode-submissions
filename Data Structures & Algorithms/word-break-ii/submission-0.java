class Solution {
    private static void dfs(String str,List<String> wordDict,int index,List<String> path,List<String> result){
        if(index==str.length()){
            result.add(String.join(" ",path));
            return;
        }
        for(String word:wordDict){
            if(index+word.length()<=str.length() && str.substring(index,index+word.length()).equals(word)){
                path.add(word);
                dfs(str,wordDict,index+word.length(),path,result);
                path.remove(path.size()-1);
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> path=new ArrayList<>();
        List<String> result=new ArrayList<>();
        dfs(s,wordDict,0,path,result);
        return result;
    }
}