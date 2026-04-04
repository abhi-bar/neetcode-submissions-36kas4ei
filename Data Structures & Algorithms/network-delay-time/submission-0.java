class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //        initially let k be 0

//        times = source, target, distance
        List<List<int[]>> graph = new ArrayList<>();
        int[] givenDistance = new int[n];

        for (int i = 0; i < n + 1; i++) {
            graph.add( new ArrayList<>());
        }
        for (int[] time : times) {
            graph.get(time[0]).add(new int[]{time[1], time[2]});
            // graph.get(time[1]).add(new int[]{time[1],time[2]});
        }


        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{distance[k], k});

        while (!pq.isEmpty()) {
            // curent edge
            int[] poll = pq.poll();
            
            int currentEle = poll[1];
            int currDistance = poll[0];
            
            List<int[]> list = graph.get(currentEle);

            if (distance[currentEle] < currDistance) {
                continue;
            }

            List<int[]> edge = graph.get(currentEle);

            for (int[] e : edge) {
                int nextNode = e[0];
                int distanceTillNextNode = e[1];
                if (distance[nextNode] > distanceTillNextNode + distance[currentEle]) {
                    distance[nextNode] = distanceTillNextNode + distance[currentEle];

                    pq.add(new int[]{distance[nextNode], nextNode});
                }
            }

        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }   
            max = Math.max(max, distance[i]);
        }

        if (max == Integer.MAX_VALUE) {
            return -1;
        }

        return max;
    }
}
