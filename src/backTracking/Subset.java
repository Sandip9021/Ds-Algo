class Subset {
    public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> result = new ArrayList<>();
         dfs(result,new ArrayList<>(),0,nums);
         return result;
    }
    
    public void dfs(List<List<Integer>> result,List<Integer> li,int start,int[] nums){
        result.add(new ArrayList(li));  
         
        if(li.size()==nums.length){
               return;  
         }  
        
         for(int i=start;i<nums.length;i++){
              li.add(nums[i]);
              dfs(result,li,i+1,nums);
              li.remove(li.size()-1);
         }
    }
}
