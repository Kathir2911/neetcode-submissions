class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt((int[] a)->a[0]).thenComparingInt(a->a[1]));
        List<int[]> list=new ArrayList<>();
        int start=intervals[0][0],end=intervals[0][1];
        int N=intervals.length;
        for(int idx=1;idx<N;idx++){
            if(intervals[idx][0]<=end){
                end=Math.max(intervals[idx][1],end);
            }
            else{
                list.add(new int[]{start,end});
                start=intervals[idx][0];
                end=intervals[idx][1];
            }
        }
        list.add(new int[]{start,end});
        return list.toArray(new int[0][]);
    }
}
