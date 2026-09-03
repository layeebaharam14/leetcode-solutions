class Solution {
    public String removeStars(String str) {
        Stack<Character> s=new Stack();
		String res = "";
	
		for(int i=0;i<str.length();i++)
		{
			char c = str.charAt(i);
		
			if(c=='*')
			{
				s.pop();
			}
			else {
				s.push(c);
			}
		}
		int t=s.size();
		for(int i=0; i<t; i++)
		{
			char c =s.pop();
			res=c+res;
		}
		return res;
    }
}