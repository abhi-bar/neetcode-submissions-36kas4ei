class Solution {
    public int[] sortArray(int[] nums) {    
        mergeSortDiv(nums, 0, nums.length-1);
        return nums;
    }

    private void mergeSortDiv(int[] arr, int l, int r){
        if(l>=r) return;

        int mid = l + ((r-l)/2);

        mergeSortDiv(arr, l, mid);
        mergeSortDiv(arr, mid+1, r);

        merge(arr, l, mid, r);
    }

    private void merge(int[] arr, int l, int mid, int r) {

        int[] left = Arrays.copyOfRange(arr, l, mid+1);
        int[] right = Arrays.copyOfRange(arr, mid + 1, r+1);

        System.out.println(left.length);
        System.out.println(right.length);


        int start1 = 0;
        int start2 = 0;

        int index = l;


        while (start1<left.length && start2<right.length) {
            if(left[start1] > right[start2]){
                arr[index] = right[start2];
                start2++;
            }else {
                arr[index] = left[start1];
                start1++;
            }
            index++;
        }


        while (start1<left.length){
            arr[index++] = left[start1++];
        }
        while (start2<right.length){
            arr[index++] = right[start2++];
        }

    }
}