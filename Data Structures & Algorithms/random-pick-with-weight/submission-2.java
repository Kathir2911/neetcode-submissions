class Solution {
    int[] nums;
    Random random;
    public Solution(int[] w) {
        random=new Random();
        int N=w.length;
        nums=new int[N];
        nums[0]=w[0];
        for(int idx=1;idx<N;idx++){
            nums[idx]=nums[idx-1]+w[idx];
        }
    }

    public int pickIndex() {
        int target=random.nextInt(nums[nums.length-1])+1;
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target) left=mid+1;
            else right=mid-1;
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */