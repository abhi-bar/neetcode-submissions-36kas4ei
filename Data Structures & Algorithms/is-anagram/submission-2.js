class Solution {
    /**
     * @param {string} s
     * @param {string} t
     * @return {boolean}
     */
    isAnagram(s, t) {
            const map = new Map();

        for(const ch of s){
            map.set(ch, (map.get(ch) || 0) +1);
        }

        for(const ch of t){
            if(!map.has(ch) || map.get(ch)==0){
                return false
            }

            map.set(ch, map.get(ch)-1);
        }

        return map.size>0 && [...map.values()].every(v=>v==0)
    }
}
