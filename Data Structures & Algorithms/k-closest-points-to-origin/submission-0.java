class Solution {
    public int[][] kClosest(int[][] points, int k) {

        HashMap<Double, List<int[]>> hashMap = new HashMap<>();
        PriorityQueue<Double> priorityQueue = new PriorityQueue<>();

        for(int[] pointArr: points ){
            double d = distance(pointArr);
            List<int[]> list = hashMap.getOrDefault(d, new ArrayList<>());
            list.add(pointArr);
            hashMap.put(d, list);
        }

        hashMap.forEach((d, list) -> {
            System.out.print(d + " -> ");
            list.forEach(p -> System.out.print(Arrays.toString(p) + " "));
            System.out.println();
        });
        priorityQueue.addAll(hashMap.keySet());

        int[][] result = new int[k][2];
        int x = 0;

        for (int i = 0; i < k; i++) {
            Double poll = priorityQueue.poll();
            List<int[]> ints = hashMap.get(poll);
            // System.out.println(ints.toString());
            for(int[] l: ints){
                System.out.println(ints.size());
                result[x] = l;
                x++;
            }

            if(ints.size()>1){
                i += ints.size()-1;
            }
        }

        return result;

    }

    private double distance(int[] data){
//        (sqrt((x1 - x2)^2 + (y1 - y2)^2))
        int x = data[0];
        int y = data[1];

        return Math.sqrt((Math.pow(x,2))+(Math.pow(y,2)));
    }
}
