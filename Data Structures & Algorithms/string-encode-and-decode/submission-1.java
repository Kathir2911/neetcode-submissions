class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb=new StringBuilder();
        for(String str:strs){
            int N=str.length();
            sb.append("#"+N+"#"+str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list=new ArrayList<>();
        int start=0,N=str.length();
        while(start<N){
            start++;
            int temp=start;
            while(temp<str.length() && str.charAt(temp)!='#') temp++;
            System.out.println(str.substring(start,temp));
            int value=Integer.parseInt(str.substring(start,temp));
            System.out.println(temp+" "+value);
            temp=temp+1;
            list.add(str.substring(temp,temp+value));
            start=temp+value;
        }
        return list;
    }
}
