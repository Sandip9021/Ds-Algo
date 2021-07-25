class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
   
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
             if(i>start && candidates[i]==candidates[i-1]){
                  continue;
             }
             li.add(candidates[i]); 
             int newTarget=target- candidates[i];
             if(newTarget>=0){
                 dfs(candidates,result,newTarget,li,i+1);
             }
             li.remove(li.size()-1);
        }     
    }
    
    
}
