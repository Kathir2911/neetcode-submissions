class Pair{
    int val;
    int index;
    Pair(int val,int index){
        this.val=val;
        this.index=index;
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int N=nums.length;
        Pair[] pairs=new Pair[N];
        for(int idx=0;idx<N;idx++){
            pairs[idx]=new Pair(nums[idx],idx);
        }   
        Arrays.sort(pairs,(a,b)->a.val-b.val);     
        int left=0,right=N-1;
        while(left<right){
            int sum=pairs[left].val+pairs[right].val;
            if(sum==target) return new int[]{Math.min(pairs[left].index,pairs[right].index),Math.max(pairs[right].index,pairs[left].index)};
            else if(sum<target) left++;
            else right--;
        }
        return new int[]{-1,-1};
    }
}
