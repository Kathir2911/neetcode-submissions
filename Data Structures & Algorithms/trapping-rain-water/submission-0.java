class Solution {
    public int trap(int[] height) {
        Deque<Integer> stack=new ArrayDeque<>();
        int result=0;
        for(int idx=0;idx<height.length;idx++){
            while(!stack.isEmpty() && height[stack.peek()]<=height[idx]){
                int current=height[stack.pop()];
                if(!stack.isEmpty()){
                    int right=height[idx];
                    int left=height[stack.peek()];
                    int heights=Math.min(right,left)-current;
                    int width=idx-stack.peek()-1;
                    result+=(width*heights);
                }
            }
            stack.push(idx);
        }
        return result;
    }
}
