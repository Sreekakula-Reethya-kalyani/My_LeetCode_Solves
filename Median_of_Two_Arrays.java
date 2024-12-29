//Hard One
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] t=new int[nums1.length+nums2.length];
        for(int i=0;i<nums1.length;i++){
            t[i]=nums1[i];
        }
        for(int i=0;i<nums2.length;i++){
            t[nums1.length+i]=nums2[i];
        }
        Arrays.sort(t);
        double b=0;
        int n=t.length;
        if(t.length %2!=0){
            return t[n/2];
        }else{
             return (t[n / 2 - 1] + t[n / 2]) / 2.0;
        }
    }
}
