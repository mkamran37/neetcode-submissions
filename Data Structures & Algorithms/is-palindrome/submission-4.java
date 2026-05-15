class Solution {
    public boolean isPalindrome(String s) {
        String st = s.toLowerCase().replaceAll("\\s", "");
        int i = 0, j = st.length() - 1;
        while(i < j) {
            System.out.println(st.charAt(j) - 'a');
            Character c1 = st.charAt(i);
            Character c2 = st.charAt(j);
            if (!Character.isLetter(c1) && !Character.isDigit(c1)) {
                i++;
            } else if (!Character.isLetter(c2) && !Character.isDigit(c2)) {
                j--;
            }
            else if (c1!=c2) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}
