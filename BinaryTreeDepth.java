package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeDepth {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(15);
        TreeNode two = new TreeNode(7);
        TreeNode three = new TreeNode(20, one, two);
        TreeNode four = new TreeNode(9);
        TreeNode root = new TreeNode(3, four, three);

//        System.out.println(new BinaryTreeDepth().maxDepth(root));
        TreeNode left1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);
        TreeNode root1 = new TreeNode(1, left1, right1);
        TreeNode left12 = new TreeNode(2);
        TreeNode right12 = new TreeNode(1);
        TreeNode root2 = new TreeNode(1, left12, right12);
//        System.out.println(new BinaryTreeDepth().isSameTree(root1, root2));
//        System.out.println(new BinaryTreeDepth().isSameTree(new TreeNode(0, new TreeNode(-8), null), new TreeNode(0, new TreeNode(-5), null)));

//        root = [3,4,5,1,2], subRoot = [4,1,2]
        TreeNode root12 = new TreeNode(4, new TreeNode(1),new TreeNode(2));
        TreeNode root11 = new TreeNode(3, root12, new TreeNode(5) );
        TreeNode subTree = new TreeNode(4, new TreeNode(1),new TreeNode(2) );

//        System.out.println(new BinaryTreeDepth().isSubtree(root11, subTree));
//        System.out.println(new BinaryTreeDepth().isSubtree(new TreeNode(1, new TreeNode(1), null), new TreeNode(1, null, null)));

        TreeNode root111 = new TreeNode(2, null, new TreeNode(5) );
        TreeNode root122 = new TreeNode(1, root111, new TreeNode(3));
//        System.out.println(new BinaryTreeDepth().binaryTreePaths(root122));


        TreeNode root1112 = new TreeNode(22, new TreeNode(14), new TreeNode(7) );
        TreeNode root1111 = new TreeNode(20, new TreeNode(15), root1112 );
        TreeNode root1113 = new TreeNode(20, new TreeNode(15), new TreeNode(7) );
        TreeNode root1222 = new TreeNode(3, new TreeNode(9), root1111);
//        System.out.println(new BinaryTreeDepth().levelOrder(root1222));

//        System.out.println(new BinaryTreeDepth().isBalanced(root1222));
//        System.out.println(new BinaryTreeDepth().tree2str(root122));
//        System.out.println(new BinaryTreeDepth().leafSimilar(root122, root111));
        System.out.println(new BinaryTreeDepth().rangeSumBST(root122, 1, 5));
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        return rangeSumBSTHelper(root, low, high, 0);
    }

    public int rangeSumBSTHelper(TreeNode root, int low, int high, int sum) {
        if(root == null) {
            return 0;
        }

        if(root.val >= low && root.val <= high) {
            sum += root.val;
        }

        if(root.right != null)
            sum += rangeSumBSTHelper(root.right, low, high, 0);
        if(root.left != null)
            sum += rangeSumBSTHelper(root.left, low, high, 0);

        return sum;
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }

        if(root1 == null && root2 != null) {
            return false;
        }

        if(root1 != null && root2 == null) {
            return false;
        }
        List<Integer> left  = new ArrayList<>();
        List<Integer> right  = new ArrayList<>();
        leafSimilar(root1, left);
        leafSimilar(root2, right);
        return left.equals(right);
    }

    public void leafSimilar(TreeNode root1, List<Integer> list) {
        if(root1.left == null && root1.right == null) {
            list.add(root1.val);
            return;
        }
        if(root1.left != null)
            leafSimilar(root1.left, list);
        if(root1.right != null)
            leafSimilar(root1.right, list);
    }

    public String tree2str(TreeNode root) {
        String str = tree2strHelper(root, "");
        return str.substring(1, str.length() - 1);
    }

    public String tree2strHelper(TreeNode root, String str) {
        if(root == null) {
            return str;
        }

        str += "(";
        str += root.val;
        if(root.left == null && root.right != null) {
            str += "()";
        } else {
            str += tree2strHelper(root.left, "");
        }
        str += tree2strHelper(root.right, "");
        str += ")";

        return str;
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        return treeHight(root) != -1;
    }

    public int treeHight(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int rightHeight = 0;
        int leftHeight = 0;

        if(root.right != null) {
            rightHeight   = treeHight(root.right);
        }

        if(root.left != null) {
            leftHeight   = treeHight(root.left);
        }

        if(leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        if(Math.abs(rightHeight - leftHeight) > 1) {
            return -1;
        }

        int height = Math.max(rightHeight, leftHeight) + 1;

        System.out.println(height);

        return height;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs2(ans, root, 0);
        return ans;
    }

    public void dfs2(List<List<Integer>> ans, TreeNode root, int height) {
        if(root == null) {
            return;
        }
        if(ans.size() <= height) {
            List<Integer> integerList = new ArrayList<>();
            integerList.add(root.val);
            ans.add(integerList);
        } else {
            ans.get(height).add(root.val);
        }
        dfs2(ans, root.left,  height + 1);
        dfs2(ans, root.right, height + 1);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        dfs(ans, root, "");
        return ans;
    }

    public void dfs(List<String> ans, TreeNode root, String s) {
        s += root.val;

        if(root.left == null && root.right == null) {
            ans.add(s);
        }

        if(root.right != null) {
            String tmp = s;
            tmp += "->";
            dfs(ans, root.right, tmp);
        }

        if(root.left != null) {
            String tmp = s;
            tmp += "->";
            dfs(ans, root.left, tmp);
        }
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) {
            return true;
        }

        if(root == null || subRoot == null) {
            return false;
        }

        if (isSameTree(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }

        if(p == null  || q == null) {
            return false;
        }

        if(p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public int maxDepth(TreeNode root) {
        int depth = 0;

        if(root != null) {
            depth =  Math.max( maxDepth(root.left), maxDepth(root.right)) + 1;
        }

        return depth;
    }
}
