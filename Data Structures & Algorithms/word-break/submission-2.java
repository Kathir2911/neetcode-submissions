class Solution {
    private static Set<String> set;
    private static Boolean[] dp;
    private static boolean dfs(String str,int index){
        if(index==str.length()) return true;
        if(dp[index]!=null) return dp[index];
        for(int idx=index;idx<str.length();idx++){
            if(set.contains(str.substring(index,idx+1))){
                if(dfs(str,idx+1)) return dp[index]=true;
            }
        }
        
        return dp[index]=false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int N=s.length();
        dp=new Boolean[N];
        set=new HashSet<>(wordDict);
        return dfs(s,0);
    }
}
