class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack=new ArrayDeque<>();
        for(String str:tokens){
            str=str.trim();
            if(!str.equals("+") && !str.equals("-") && !str.equals("*") && !str.equals("/")){
                stack.push(Integer.parseInt(str));
                continue;
            }
            int second=stack.pop();
            int first=stack.pop();
            switch(str.charAt(0)){
                case '+':
                    stack.push(first+second);
                    break;
                
                case '-':
                    stack.push(first-second);
                    break;

                case '*':
                    stack.push(first*second);
                    break;

                case '/':
                    stack.push(first/second);
                    break;
            }
        }
        return stack.pop();
    }
}
