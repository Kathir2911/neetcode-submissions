class Solution {
    private static boolean isPossible(int[] piles,int h,int rate){
        int hours=0;
        for(int pile:piles){
            hours+=((pile+rate-1)/rate);
            if(hours>h) return false;
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right=Arrays.stream(piles).max().getAsInt();
        while(left<=right){
            int mid=left+(right-left)/2;
            if(isPossible(piles,h,mid)) right=mid-1;
            else  left=mid+1;
        }
        return left;
    }
}
