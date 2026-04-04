class LRUCache {

    LinkedList<Integer> list;
    HashMap<Integer,Integer> hashMap;

    int capacity;
    int filled = 0;

        public LRUCache(int capacity) {
            list=new LinkedList<>();
            hashMap = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if(hashMap.containsKey(key)){
                list.remove((Integer) key);
                list.addLast(key);
                return hashMap.get(key);
            }
            return -1;
        }

        public void put(int key, int value) {
            if(hashMap.containsKey(key)){
                hashMap.put(key,value);
                list.remove((Integer) key);
                list.addLast(key);
            }
            else{
                if(list.size() == capacity){
                    Integer i = list.removeFirst();
                    hashMap.remove(i);
//                    capacity++;
                }
                hashMap.put(key,value);
                list.addLast(key);
            }
//            capacity--;
        }
}
