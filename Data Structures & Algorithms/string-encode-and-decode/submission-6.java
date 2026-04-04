class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty()){
            return "null";
        }
        StringBuilder sn = new StringBuilder();
        for (String s: strs) {
            sn.append(s).append("-");
        }
//        System.out.println(strs.isEmpty());

        if(strs.size()==1 && strs.get(0).equals("")){
            return "";
        }
        return sn.toString();
    }

    public List<String> decode(String str) {
        if(str.equals("null")){
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(str.split("-")));
//        return new ArrayList<>(Arrays.asList(str.split(",", -1)));
        return list;
    }
}
