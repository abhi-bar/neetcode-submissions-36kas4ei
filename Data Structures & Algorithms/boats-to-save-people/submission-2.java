class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int tot = 0;

        int l = 0;
        int r = people.length-1;

        int curr = 0;

        while (l<=r){
            if(l==r){
                curr++;
                break;
            }
            if(people[l]+people[r]==limit){
                curr++;
                l++;
                r--;
            }else if(people[l]+people[r]>limit){
                curr++;
                r--;
            }else {
                l++;
                r--;
                curr++;
            }
        }

        return curr;
    }
}