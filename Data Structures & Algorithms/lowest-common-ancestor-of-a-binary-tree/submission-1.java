/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private static boolean find(TreeNode root,TreeNode p,List<TreeNode> list){
        if(root==null) return false;
        list.add(root);
        if(root==p) return true;
        if(find(root.left,p,list) || find(root.right,p,list)) return true;
        list.remove(list.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1=new ArrayList<>();
        List<TreeNode> list2=new ArrayList<>();
        find(root,p,list1);
        find(root,q,list2);
        int start=0;
        TreeNode lcs=root;
        while(start<list1.size() && start<list2.size()){
            if(list1.get(start)==list2.get(start)){
                lcs=list1.get(start);
                start++;
            }
            else break;
        }
        return lcs;
    }
}