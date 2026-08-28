class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int N=asteroids.length;
        Deque<Integer> stack=new ArrayDeque<>();
        for(int asteroid:asteroids){
            boolean destroyed=false;
            while(!stack.isEmpty() && stack.peek()>0 && asteroid<0){
                if(stack.peek()<-asteroid){
                    stack.pop();
                    continue;
                }
                if(stack.peek()==-asteroid) stack.pop();
                destroyed=true;
                break;
            }
            if(!destroyed) stack.push(asteroid);
        }
        int[] result=new int[stack.size()];
        for(int idx=stack.size()-1;idx>=0;idx--){
            result[idx]=stack.pop();
        }
        return result;
    }
}