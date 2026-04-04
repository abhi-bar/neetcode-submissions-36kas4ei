class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> list = new HashSet<>();
        Set<Integer> list2 = new HashSet<>();
        Set<Integer> list3 = new HashSet<>();

        for (int i = 0; i < triplets.length; i++) {
            if(triplets[i][0]==target[0]){
                list.add(i);
            }
            if(triplets[i][1]==target[1]){
                list2.add(i);
            }
            if(triplets[i][2]==target[2]) {
                list3.add(i);
            }
        }
        
        List<int[]> li = new ArrayList<>();
        
        for(int i : list){
            for(int j : list2){
                int[] arr =  new int[3];

                arr[0] = Math.max(triplets[i][0], triplets[j][0]);
                arr[1] = Math.max(triplets[i][1], triplets[j][1]);
                arr[2] = Math.max(triplets[i][2], triplets[j][2]);
                
                li.add(arr);

                System.out.println(Arrays.toString(arr));

//                if(Arrays.equals(arr, target)){
//                    return true;
//                }
            }
        }

        for(int[] i : li){
            for(int j : list3){
                int[] arr =  new int[3];

                arr[0] = Math.max(i[0], triplets[j][0]);
                arr[1] = Math.max(i[1], triplets[j][1]);
                arr[2] = Math.max(i[2], triplets[j][2]);

                System.out.println(Arrays.toString(arr));

                if(Arrays.equals(arr, target)){
                    return true;
                }
            }
        }

        return false;  
    }
}
