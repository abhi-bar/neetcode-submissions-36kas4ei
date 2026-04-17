class Solution {
    public String multiply(String num1, String num2){
        if(num1.equals("0") || num2.equals("0")) return "0";
        
        // if(num1.length()<num2.length()){
        //     return multiply(num2,num1);
        // }
        
        String res = "";
        int zero = 0;
        for (int i = num2.length()-1; i>=0; i--) {
            String curr = mul(num1, num2.charAt(i), zero);
            res = add(res, curr);
            zero++;
        }
        
        return res;
    }
    

    private String mul(String num1, char c, int zero) {
        int i = num1.length()-1, carry =0;
        int digit = c - '0';
        StringBuilder cur = new StringBuilder();
        
        while (i>=0 || carry>0){
            int n = (i>=0)? num1.charAt(i)-'0':0;
            int prod = n*digit+carry;
            cur.append(prod%10);
            carry = prod/10;
            i--;
        }
        
        return cur.reverse().toString() + "0".repeat(zero);
    }

    private String add(String prevRes, String curr) {
        int i = prevRes.length()-1, j = curr.length()-1, carry = 0;
        StringBuilder res = new StringBuilder();
        
        while(i>=0 || j>=0 ||carry>0){
            int n1 = (i>=0)?prevRes.charAt(i)-'0':0;
            int n2 = (j>=0)?curr.charAt(j)-'0':0;
            int total = n1+n2+carry;
            res.append(total%10);
            carry = total/10;
            i--;
            j--;
        }
        return res.reverse().toString();
    }
}
