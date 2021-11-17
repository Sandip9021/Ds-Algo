class WordBreak {
     
    Map<String,Boolean> memo = new HashMap<String,Boolean>();
    
     public boolean wordBreak(String s, List<String> wordDict) {
          if(s.length()==0){
               return true;
          }
         
          if(memo.containsKey(s)){
              return memo.get(s);
          }
         
         for(String str : wordDict){
              if(str.length() > s.length()){
                  continue;
              }
             
             boolean result = false;
             if(s.startsWith(str)){
                  String suffix = s.substring(str.length());
                  result = wordBreak(suffix,wordDict);
                  memo.put(suffix,result);
             }
             if(result){
                 return true;
             }
         }
         
         return false;
      
    }
    
   
}
