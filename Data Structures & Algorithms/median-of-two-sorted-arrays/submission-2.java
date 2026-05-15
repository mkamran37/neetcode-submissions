class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {

        // Ensure A is smaller
        if (A.length > B.length) {
            return findMedianSortedArrays(B, A);
        }

        int total = A.length + B.length;
        int half = total / 2;

        int l = 0, r = A.length;

        while (l <= r) {
            int i = (l + r) / 2;      // elements taken from A
            int j = half - i;         // elements taken from B

            int Aleft  = (i > 0) ? A[i - 1] : Integer.MIN_VALUE;
            int Aright = (i < A.length) ? A[i] : Integer.MAX_VALUE;
            int Bleft  = (j > 0) ? B[j - 1] : Integer.MIN_VALUE;
            int Bright = (j < B.length) ? B[j] : Integer.MAX_VALUE;

            if (Aleft <= Bright && Bleft <= Aright) {

                if (total % 2 == 1) {
                    return Math.min(Aright, Bright);
                }

                return (Math.max(Aleft, Bleft) +
                        Math.min(Aright, Bright)) / 2.0;
            }
            else if (Aleft > Bright) {
                r = i - 1;
            }
            else {
                l = i + 1;
            }
        }

        return 0; // never reached
    }
}
