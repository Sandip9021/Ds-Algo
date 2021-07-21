class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
         List<List<Integer>> result=new ArrayList<>();
          Arrays.sort(candidates);
          dfs(candidates,result,target,new ArrayList<>(),0);
         return result;
    }
    
    public void dfs(int[] candidates,List<List<Integer>> result,int target,List<Integer> li,int start){
        
        if(target==0){
            result.add(new ArrayList<>(li));
            return;
        }
                
        for(int i=start;i<candidates.length;i++){
             li.add(candidates[i]); 
             int newTarget=target- candidates[i];
             if(newTarget>=0){
                 dfs(candidates,result,newTarget,li,i);
             }
             li.remove(li.size()-1);
        }     
    }
    
   
}
