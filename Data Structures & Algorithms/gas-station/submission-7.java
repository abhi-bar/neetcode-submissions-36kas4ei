class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int max = 0;
        int fuel = 0;

        int index = 0;

        System.out.println(Arrays.toString(gas));
        System.out.println(Arrays.toString(cost));

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            max+=diff;
            
//            this step was missing
            fuel += diff;

            System.out.println("i: "+i+", fuel:" + fuel +" max:"+max);

            if(fuel<0){
                fuel = 0;
                index = i+1;
            }

        }

        if(max<0) return -1;
        System.out.println("left gas  is: "+ max);


//        System.out.println(index2);
        return index;
    }
}
