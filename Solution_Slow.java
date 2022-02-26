class Solution {
    //Map<String,Integer> mp;
    int[][] arr;
    public int superEggDrop(int k, int n) {
        //mp= new HashMap<String,Integer>();
        arr = new int[k+1][n+1];
        for(int i =0;i<=k;i++)
            for(int j =0;j<=n;j++)
                arr[i][j]=-1;
        return solve(k,n);
    }
    
    public int solve(int e, int f){
        if(f== 0 || f==1)
            return f;
        if(e==1)
            return f;
       
        String key = e+" "+f;
        //if(mp.containsKey(key))
          //  return mp.get(key);
        if(arr[e][f]!=-1)
            return arr[e][f];
        int min = Integer.MAX_VALUE;
        for(int k=1;k<=f;k++){
            int lResult=solve(e-1,k-1);
            int rResult=solve(e,f-k);
            arr[e-1][k-1]=lResult;
            arr[e][f-k]=rResult;
            int tempAns = 1 + Math.max(lResult,rResult);
            if(tempAns<min)
                min=tempAns;
        }
        arr[e][f]=min;
        return min;
    }
}
