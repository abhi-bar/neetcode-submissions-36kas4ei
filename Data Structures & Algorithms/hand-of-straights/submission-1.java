class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer, Integer> hash = new HashMap<>();

        for(int i:hand){
            hash.put(i, hash.getOrDefault(i,0)+1);
        }

        int min = Integer.MAX_VALUE;


        int length = hand.length;

        while (length>0){

            if(length%groupSize==0){
                min = Integer.MAX_VALUE;
                for(Map.Entry<Integer, Integer> map: hash.entrySet()){
                    min = Math.min(map.getKey(), min);
                }
            }

            if(hash.containsKey(min) && hash.get(min)>0){
                length--;
                hash.put(min, hash.get(min)-1);

                if(hash.get(min)==0){
                    hash.remove(min);
                }

                ++min;
            }else {
                return false;
            }
        }

        return true;
    }
}
