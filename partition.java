class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> lst=new ArrayList<List<String>>();
        backtrack(s,lst,new ArrayList<String>(),0);
        return lst;
    }
    public void backtrack(String s, List<List<String>> lst, ArrayList<String> arr, int start) {
        if (start==s.length()) {
            lst.add(new ArrayList<String>(arr));
            return;
        }
        
        for (int i=start;i<s.length();i++) {
            String temp=s.substring(start,i+1);
            if (isPalindrome(temp)) {
                arr.add(temp);
                backtrack(s,lst,arr,i+1);
                arr.remove(arr.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s) {
        if (s.length()==1) return true;
        for (int i=0;i<s.length()/2;i++) {
            if (!s.substring(i,i+1).equals(s.substring(s.length()-i-1,s.length()-i))) return false;
        }
        return true;
    }
}
