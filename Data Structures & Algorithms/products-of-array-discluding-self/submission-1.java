class Solution {
    public int[] productExceptSelf(int[] input) {

        int length = input.length;

        int[] pref = new int[length];
        pref[0] = 1;
        pref[1] = input[0];
        for(int i=2;i<length;i++) {
            pref[i] = input[i-1]*pref[i-1];
        }
        
        int[] suff = new int[length];
        suff[length-1] = 1;
        suff[length-2] = input[length-1];
        for (int i=length-3;i>=0;i--) {
            suff[i] =  input[i+1] * suff[i+1];
        }

        int[] output = new int[length];
        for(int i=0;i<length;i++) {
            output[i] = pref[i] * suff[i];
        }

        return output;

    }
}  
