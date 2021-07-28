public CombinationSum3{
  
   public List<List<Integer>> combinationSum3(int k, int n) {        
       List<List<Integer>> result=new ArrayList<>();
        if(k>n){
             return result;
        }
         dfs(k,result,n,1,new ArrayList<>());
       return result;
    }
    
    public void dfs(int k,List<List<Integer>> result,int target,int start,List<Integer> li){
        
        if(target==0 && li.size()==k){
             result.add(new ArrayList<>(li));
             return;
        }
       
        
        
        for(int i=start;i<=9;i++){
              li.add(i);
              int newTarget= target - i;
              if(newTarget>=0 || li.size()<=k){
                  dfs(k,result,newTarget,i+1,li);
              }
              li.remove(li.size()-1);
        }
        
    }

}
