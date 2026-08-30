class Solution {
    List<Integer> list;
    Random random;
    public Solution(int[] w) {
        int N=w.length;
        list=new ArrayList<>();
        for(int idx=0;idx<N;idx++){
            int count=w[idx];
            for(int jdx=0;jdx<count;jdx++) list.add(idx);
        }
        random=new Random();
    }

    public int pickIndex() {
        int index=random.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */