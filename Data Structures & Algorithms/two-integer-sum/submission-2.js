class Solution {
    /**
     * @param {number[]} nums
     * @param {number} target
     * @return {number[]}
     */
    twoSum(nums, target) {
        const map = new Map();

        for (let i = 0; i < nums.length; i++) {
            const find = target - nums[i]

            if(map.has(find)){
                return [map.get(find), i];
            }

            map.set(nums[i],i);
        }
    }
}
