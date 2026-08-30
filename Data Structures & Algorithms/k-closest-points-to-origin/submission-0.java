class Position{
    int[] points;
    int distance;
    Position(int[] points,int distance){
        this.points=points;
        this.distance=distance;
    }
}
class Solution {

    public int[][] kClosest(int[][] points, int k) {
        int N=points.length;
        PriorityQueue<Position> minheap=new PriorityQueue<>(Comparator.comparingInt((Position p)->p.distance));
        for(int[] point:points){
            int distance=point[0]*point[0]+point[1]*point[1];
            minheap.add(new Position(point,distance));
        }
        List<int[]> list=new ArrayList<>();
        while(k-->0){
            list.add(minheap.poll().points);
        }
        return list.toArray(new int[0][]);
    }
}