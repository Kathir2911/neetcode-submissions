class Solution {
    public int climbStairs(int n) {
        int previous=1,current=1;
        for(int idx=1;idx<n;idx++){
            int temp=current;
            current+=previous;
            previous=temp;
        }
        return current;
    }
}
