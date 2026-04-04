class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        System.out.println("Sum "+sum/4);
        if(sum%4!=0)return false;

        int[] side = new int[4];

        return dfs(0,matchsticks,side);
    }

    private boolean dfs(int i, int[] matchsticks, int[] sides){

        if(i==matchsticks.length)
        {
            return sides[0]==sides[1] && sides[1]==sides[2] && sides[2]==sides[3];
        }

        for (int j = 0; j < 4; j++) {
            sides[j]+=matchsticks[i];
            if(dfs(i+1, matchsticks, sides)) return true;
            sides[j]-=matchsticks[i];
        }
        return false;
    }
}