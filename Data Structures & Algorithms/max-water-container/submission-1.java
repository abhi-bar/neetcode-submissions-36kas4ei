class Solution {
    public int maxArea(int[] heights) {
        int start = 0 ;
        int end = heights.length-1;

        int maxG = Integer.MIN_VALUE;
        while(end>start){
            System.out.println("end: "+heights[end]+ " start: "+heights[start]);
            if(end-start==2){
                int part1 = Math.min(heights[start],heights[start+1]);
                int part2 = Math.min(heights[start],heights[end])*2;
                int part3 = Math.min(heights[start+1],heights[end]);

                maxG = Math.max(maxG, Math.max(part2, Math.max(part1, part3)));
                return maxG;
            }

            int maxL = Math.min(heights[start], heights[end]) * (end-start);
            maxG = Math.max(maxG,maxL);


            if(heights[start]>heights[end]){
                end--;
            }
            else{
                start++;
            }
        }

        return maxG;
    }
}
