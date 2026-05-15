class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        if (A.length > B.length) {
            return findMedianSortedArrays(B, A);
        }
        int TOTAL = A.length + B.length;
        int HALF = TOTAL/2;
        int l = 0, r = A.length;
        while (l <= r) {
            int i = (l + r)/2;
            int j = HALF - i;
            
            int ALeft = i > 0 ? A[i - 1] : Integer.MIN_VALUE;
            int ARight = i < A.length ? A[i] : Integer.MAX_VALUE;
            int BLeft = j > 0 ? B[j - 1] : Integer.MIN_VALUE;
            int BRight = j < B.length ? B[j] : Integer.MAX_VALUE;

            if (ALeft <= BRight && ARight >= BLeft) {
                if (TOTAL % 2 != 0) {
                    return Math.min(ARight, BRight);
                }
                return (Math.max(ALeft, BLeft) + Math.min(ARight, BRight))/2.0;
            }
            if (ALeft > BRight) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
        return 0.0;
    }
}
