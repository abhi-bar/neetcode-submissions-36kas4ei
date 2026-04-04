class Solution {
    static class Tot{
        int u;
        int v;
        int distance;

        Tot(int u, int v, int distance) {
            this.u = u;
            this.v = v;
            this.distance = distance;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        if(points.length==1){
            return 0;
        }
//        store a list of (u,v,distance) sorted
        PriorityQueue<Tot> pq = new PriorityQueue<>((a,b)->Integer.compare(a.distance,b.distance));

//        Insert into the Hashmap
        HashMap<Integer, List<Tot>> hashMap = new HashMap<>();
        for (int i = 0; i < points.length-1; i++) {
            for (int j = i+1; j < points.length; j++) {
                int distance = distance(points[i], points[j]);
                Tot t = new Tot(i, j, distance);
                if(!hashMap.containsKey(i)){
                    hashMap.put(i, new ArrayList<>());
                }
                hashMap.get(i).add(t);

                Tot t2 = new Tot(j,i, distance);
                if(!hashMap.containsKey(j)){
                    hashMap.put(j, new ArrayList<>());
                }
                hashMap.get(j).add(t2);
            }
        }

        int count = 0;
        List<Integer> visited = new ArrayList<>();
        visited.add(0);

        List<Tot> tots = hashMap.get(0);
        pq.addAll(tots);

        while (!pq.isEmpty()){
            if(visited.size()==points.length){
                return count;
            }

            Tot poll = pq.poll();

            if(!visited.contains(poll.v)){
                visited.add(poll.v);
                count+=poll.distance;
                if(hashMap.containsKey(poll.v)) {
                    pq.addAll(hashMap.get(poll.v));
                }
            }
        }

        return 0;
    }

    private int distance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
