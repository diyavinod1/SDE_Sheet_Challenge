class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] l=new int[n];
        int[] r=new int[n];
        Stack <Integer> st=new Stack<>();
        for (int i=0;i<n;i++) {
            while (!st.isEmpty() && heights[st.peek()]>=heights[i]) 
            st.pop();
            if (st.isEmpty()) l[i]=-1;
            else l[i]=st.peek();
            st.push(i);
        }
        st.clear();
        for (int i=n-1;i>=0;i--) {
            while (!st.isEmpty() && heights[st.peek()]>=heights[i]) 
            st.pop();
            if (st.isEmpty()) r[i]=n;
            else r[i]=st.peek();
            st.push(i);
        }
        int m=0;
        for (int i=0;i<n;i++){
            int w=r[i]-l[i]-1;
            m=Math.max(m,heights[i]*w);
        }
        return m;

    }
}
