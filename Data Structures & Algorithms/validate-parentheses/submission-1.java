class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack=new ArrayDeque<>();
        for(char ch:s.toCharArray()){
            if(ch==']' || ch=='}' || ch==')'){
                if(stack.isEmpty()) return false;
                if(ch==']' && stack.peek()!='[') return false;
                if(ch==')' && stack.peek()!='(') return false;
                if(ch=='}' && stack.peek()!='{') return false;
                stack.pop();
                continue;
            }
            stack.push(ch);
        }
        return stack.isEmpty()?true:false;
    }
}
