class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder s = new StringBuilder();
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->y[0]-x[0]);

        if(a>0) pq.add(new int[]{a,'a'});
        if(b>0) pq.add(new int[]{b,'b'});
        if(c>0) pq.add(new int[]{c,'c'});

        while (!pq.isEmpty()){
            int[] remove = pq.remove();

            if(s.length()>1 && s.charAt(s.length()-1)==(char)remove[1] && s.charAt(s.length()-2)==(char)remove[1]){
                if(!pq.isEmpty()){
                    int[] remove2 = pq.remove();
                    s.append((char)remove2[1]);
                    
                    remove2[0]--;
                    pq.add(remove);
                    if(remove2[0]>0){
                        pq.offer(remove2);
                    }
                }
            }else {
                s.append((char) remove[1]);
                remove[0]--;
                if(remove[0]>0){
                    pq.offer(remove);
                }
            }
        }
        
        return s.toString();
    }
}