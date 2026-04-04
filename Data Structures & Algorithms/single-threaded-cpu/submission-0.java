class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
//        int[] newt = new int[3];
        int[][] newTask = new int[n][3];

        for (int i = 0; i < n; i++) {
            int[] task = tasks[i];
            int[] newt = new int[3];
            newt[0]=task[0];
            newt[1]=task[1];
            newt[2]=i;
            newTask[i]=newt;
        }

        Arrays.sort(newTask, Comparator.comparingInt((int[] a)->a[0]));


        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt((int[] a)
                                ->a[1])
                        .thenComparing(a->a[2]));


        int i =0;
        int k=0;

        int time = 0;

        int[] ans = new int[n];

        while (k<n){

            while (i<n && newTask[i][0]<=time){
                pq.add(newTask[i]);
                i++;
            }
            if(pq.isEmpty()){
                time=newTask[i][0];
                continue;
            }

            int[] poll = pq.poll();
            ans[k++]=poll[2];
            time+=poll[1];
        }

        return ans;
    }
}