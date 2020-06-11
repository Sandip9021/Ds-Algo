public class Problem_28_strStr {
	
	public static void main(String[] args) {
		int n=strStr("hello","el");
		System.out.println(n);
	}
	  
	 public static int strStr(String haystack, String needle) {
		 if(needle==null || needle.equals("") || needle.isEmpty()) {
			 return 0;
		 }
		 if(needle.length() > haystack.length()) {
			 return -1;
		 }
		 int len=needle.length();
		 int start=0;
		 int end=len;
		 while(end<=haystack.length()) {
			 String sub=haystack.substring(start, end);
			 if(needle.equals(sub)) {
				 return start;
			 }
			 start=start+1;
			 end=end+1;
		 }
	    return -1;
	 }

}
