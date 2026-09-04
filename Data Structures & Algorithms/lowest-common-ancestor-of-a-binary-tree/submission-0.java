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
    private static boolean find(TreeNode root,TreeNode val,List<TreeNode> list){
        if(root==null) return false;
        list.add(root);
        if(root==val) return true;
        if(find(root.left,val,list) || find(root.right,val,list)) return true;
        list.remove(list.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1=new ArrayList<>();
        List<TreeNode> list2=new ArrayList<>();
        find(root,p,list1);
        find(root,q,list2);
        TreeNode lca=root;
        for(TreeNode val:list1) System.out.print(val.val+" ");
        System.out.println();
        for(TreeNode val:list2) System.out.print(val.val+" ");
        int start=0;
        while(start<list1.size() && start<list2.size()){
            if(list1.get(start).equals(list2.get(start))){
                lca=list1.get(start);
                start++;
            }
            else break;
        }
        return lca;
    }
}