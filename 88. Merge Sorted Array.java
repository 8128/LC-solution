class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
      System.arraycopy(nums2, 0, nums1, m, n);
      Arrays.sort(nums1);
    }
  }

//这题傻逼出的，下面这个solution明明能用，LeetCode就是跑不通


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0,k=0;
        int[] ans = new int[m+n];
        while(i<=m&&j<=n){
            if(i==m&&j==n) break;
            if(i==m){
                ans[k]=nums2[j];
                j++;
                k++;
                continue;
            }
            if(j==n){
                ans[k]=nums1[i];
                i++;
                k++;
                continue;
            }
            if(nums1[i]>nums2[j]){
                ans[k]=nums2[j];
                j++;
                k++;
            }else{
                ans[k]=nums1[i];
                i++;
                k++;
            }
        }
        nums1=ans;
        for(int a:nums1){
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        Solution mSolution = new Solution();
        mSolution.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }
}