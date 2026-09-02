class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue=new PriorityQueue<>(Collections.reverseOrder());
        for(int stone:stones) queue.add(stone);
        while(queue.size()>1){
            int first=queue.poll();
            int second=queue.poll();
            if(first==second) continue;
            if(first<second) queue.add(second-first);
            else queue.add(first-second);
        }
        return queue.isEmpty()?0:queue.poll();
    }
}
