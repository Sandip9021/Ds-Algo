public class Problem_14_CommonLongestPrefix {
	
	public static void main(String[] args) {
		String[] strs= {"caa","","a","acb"};
		String prefix=longestCommonPrefix(strs);
		System.out.println("Prefix:"+prefix);
	}
	
    public static String longestCommonPrefix(String[] strs) {
        int len=strs.length;
        
        if(len==0) {
        	return "";
        }
        if(len==1) {
        	return strs[0];
        }
        int i=0,j=1;
        String prefix="";
        String ResultPrefix="";
        boolean first=true;
      
        while(j<=len-1) {
        	char[] s1=strs[i].toCharArray();
        	char[] s2=strs[j].toCharArray();
        	int l = s1.length>s2.length ? s2.length:s1.length;
        	for(int p=0;p<l;p++) {
        		if(s1[p]==s2[p]) {
        			prefix=prefix+s1[p];
        		}else {
        			break;
        		}
        	}
        	if(first) {
        		ResultPrefix=prefix;
        		first=false;
        	}else {
        		ResultPrefix= ResultPrefix.length()>prefix.length() ? prefix:ResultPrefix; 
        	}
        	prefix="";
        	i++;
        	j++;
        }
        return ResultPrefix;
    }

}
