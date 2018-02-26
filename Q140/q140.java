package Q140;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class q140 {
	public static List<String> wordBreak(String s, List<String> wordDict) {
	    return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
		
	}       

	// DFS function returns an array including all substrings derived from s.
	public static List<String> DFS(String s, List<String> wordDict, HashMap<String, LinkedList<String>>map) {
	    if (map.containsKey(s)) 
	        return map.get(s);
	        
	    LinkedList<String>res = new LinkedList<String>();   
	  
	    if (s.length() == 0) {
	        res.add("");
	        return res;
	    }               
	    for (String word : wordDict) {
	        if (s.startsWith(word)) {
	            List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
	            for (String sub : sublist) 
	                res.add(word + (sub.isEmpty() ? "" : " ") + sub);               
	        }
	    }       
	    map.put(s, res);
	    return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "catsanddog";
		List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
		System.out.println(wordBreak(s, wordDict));
	}

}
