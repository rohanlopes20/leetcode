package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

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
//        System.out.println(new BinaryTreeDepth().rangeSumBST(root122, 1, 5));

        TreeNode code4 = new TreeNode(4);
        TreeNode code5 = new TreeNode(5);
        TreeNode code3 = new TreeNode(3, code4, code5);
        TreeNode code1 = new TreeNode(1, new TreeNode(8), code3);
//        System.out.println(new Codec().serialize(code1));
//        System.out.println(new Codec().deserialize("1,2,3,null,null,4,5"));
//        System.out.println(new Codec().serialize(null));
        //Input: root = [1,2,3,null,null,4,5]

//        System.out.println(new BinaryTreeDepth().sortedArrayToBST(new int[]{-10,-3,0,5,9}));
//        System.out.println(new BinaryTreeDepth().createBinaryTree(new int[][]{{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}}));
//        System.out.println(new BinaryTreeDepth().sumNumbers(code1));
//        System.out.println(new BinaryTreeDepth().isCompleteTree(code1));
//        int[] inorder = new int[]{9,3,15,20,7}, postorder = {9,15,7,20,3};
//        System.out.println(new BinaryTreeDepth().buildTree(inorder, postorder));
//        System.out.println(new BinaryTreeDepth().hasPathSum(code1, 9));
//        System.out.println(new BinaryTreeDepth().pathSum(code1, 9));
//        int[] nums = new int[]{1,2,3,3};
//        Set<Integer> list11 = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        TreeNode code44 = new TreeNode(-8);
        TreeNode code55 = new TreeNode(7);
        TreeNode code33 = new TreeNode(7, code44, code55);
        TreeNode code11 = new TreeNode(1, new TreeNode(0), code33);
//        System.out.println(new BinaryTreeDepth().maxLevelSum(code11));
//        System.out.println(new BinaryTreeDepth().largestValues(code11));
        int[] arr = new int[]{1,2,3};
//        new BinaryTreeDepth().permute(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        // n = 4, left = [4,3], right = [0,1]
        new BinaryTreeDepth().getLastMoment(7, new int[] {},new int[]{0,1,2,3,4,5,6,7});

        Comparator<Long> newCom = new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                Integer s1 = Integer.valueOf(o1 + "" + o2);
                Integer s2 = Integer.valueOf(o2 + "" + o1);

                return s1.compareTo(s2);
            }
        };

        Long[] numsIntegers = Arrays.stream(arr).boxed().toArray(Long[]::new);

        Arrays.sort(numsIntegers, newCom);

        Arrays.stream(numsIntegers).map(i-> String.valueOf(i)).collect(Collectors.joining());
    }

    public int getLastMoment(int n, int[] left, int[] right) {
        int ans = 0;

        for (int i = 0; i < left.length; i++) {
            if(left[i] >= n) {
                ans = Math.max(left[i], ans);
            }
        }

        for (int j = 0; j < right.length; j++) {
            if(n - right[j] >= n) {
                ans = Math.max(n - right[j], ans);
            }
        }

        return ans;
    }

    public int averageOfSubtree(TreeNode root) {
        int counter = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if(curr != null) {
                int avg = sumHelper(curr);

                if(avg == curr.val) {
                    counter++;
                }
                queue.add(curr.right);
                queue.add(curr.left);
            }
        }


        return counter;
    }

    private int sumHelper(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        int countOfElements = 0;
        int currentSum = 0;

        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if(curr != null) {
                countOfElements++;
                currentSum += curr.val;

                queue.add(curr.right);
                queue.add(curr.left);
            }
        }
        return currentSum/countOfElements;
    }



    public int[] findArray(int[] pref) {
        int[] ans = new int[pref.length];
        int prev = 0;

        for(int i= 0; i < pref.length; i++) {
            int current = pref[i] ^ prev;
            ans[i] = current;
            prev = current ^ pref[i] ^ prev;
            System.out.println(prev);
        }

        return ans;
    }

    public void permute(List<Integer> input) {
        System.out.println(permuteHelper(new ArrayList<>(input)));
    }

    // 1,2,3 | 1,3,2 | 2,1,3 | 2,3,1 | 3,1,2 | 3,2,1
    public List<List<Integer>> permuteHelper(List<Integer> currResult) {
        List<List<Integer>> ans2 = new ArrayList<>();
        System.out.println(currResult);
        if(currResult.size() == 1) {
            ans2.add(currResult);
            return ans2;
        }
        for(int i = 0; i < currResult.size(); i++) {
            int curr = currResult.remove(0);
            List<List<Integer>> results = permuteHelper(new ArrayList<>(currResult));
            for(List<Integer> integers : results) {
                integers.add(curr);
            }
            ans2.addAll(results);
            currResult.add(curr);
        }
        return ans2;
    }

    public List<Integer> largestValues(TreeNode root) {
        List<List<Integer>> listPerRow = new ArrayList<>();

        helper(root, listPerRow, 0);

        List<Integer> ans = listPerRow.stream().map(i->Arrays.stream(i.stream().mapToInt(ii->ii).toArray()).max().getAsInt()).collect(Collectors.toList());
        return ans;
    }

    void helper(TreeNode node, List<List<Integer>> listPerRow, int index) {
        if(node == null) {
            return;
        }
        if(listPerRow.size() - 1 < index) {
            listPerRow.add(new ArrayList<>());
            listPerRow.get(index).add(node.val);
        } else {
            listPerRow.get(index).add(node.val);
        }
        int currRow = index + 1;
        helper(node.left, listPerRow, currRow);
        helper(node.right, listPerRow, currRow);
    }

    public int maxLevelSum(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        maxLevelSumHelper(root, list, 0);
        Integer max = Integer.MIN_VALUE;
        int index = 0;
        for(int i = 0; i < list.size() ; i ++) {
            if(list.get(i) > max) {
                max = list.get(i);
                index = i;
            }
        }

        return index;
    }

    public void maxLevelSumHelper(TreeNode node, List<Integer> sums, int level) {
        if(node == null) {
            return;
        }

        if(sums.size() <= level) {
            sums.add(node.val);
        } else {
            sums.set(level, sums.get(level) + node.val);
        }

        maxLevelSumHelper(node.left, sums, level + 1);
        maxLevelSumHelper(node.right, sums,level + 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();

        sumHelper2(root, list, new ArrayList<>(), 0, targetSum);
        System.out.println(list);
        return list;
    }

    private void sumHelper2(TreeNode node, List<List<Integer>> list, List<Integer> nodes, int sum, int targetSum) {
        if(node == null) return;

        nodes.add(node.val);
        if(node.left == null && node.right == null) {
            if(sum + node.val == targetSum) {
                list.add(nodes);
            }
            return;
        }
        sumHelper2(node.left, list, new ArrayList<>(nodes), sum + node.val, targetSum);
        sumHelper2(node.right, list, new ArrayList<>(nodes), sum + node.val, targetSum);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList<>();
        sumHelper(root, list, 0);
        System.out.println(list);
        return list.contains(targetSum);
    }

    private void sumHelper(TreeNode node, List<Integer> list, int sum) {
        if(node == null) return;
        if(node.left == null && node.right == null) {
            list.add(sum + node.val);
            return;
        }
        sumHelper(node.left, list, sum + node.val);
        sumHelper(node.right, list, sum + node.val);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> integerIntegerMap = new HashMap<>();

        for(int i = 0; i < inorder.length; i++) {
            integerIntegerMap.put(i, inorder[i]);
        }
        TreeNode root = new TreeNode(postorder[postorder.length-1]);

//        if not preorder or not inorder:
//        return None
//
//        root = TreeNode(preorder[0])
//        mid = inorder.index(preorder[0])
//        root.left = self.buildTree(preorder[1 : mid + 1], inorder[:mid])
//        root.right = self.buildTree(preorder[mid + 1 :], inorder[mid + 1 :])
//        return root

        return treeBuilderHelper(root, integerIntegerMap);
    }

    private TreeNode treeBuilderHelper(TreeNode treeNode, Map<Integer, Integer> integerIntegerMap) {


        return treeNode;
    }

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        boolean nullFound = false;

        while(!queue.isEmpty()) {
            TreeNode element = queue.poll();

            if(element == null) {
                nullFound = true;
            } else {
                if(nullFound) {
                    return false;
                }

                queue.add(element.left);
                queue.add(element.right);
            }
        }
        return true;
    }

    public int sumNumbers(TreeNode root) {
        int sum = 0;
        List<String> stringList = new ArrayList<>();
        sumHelper(root, stringList, "");

        for(String integer : stringList) {
            sum += Integer.parseInt(integer);
        }

        System.out.println(stringList);
        return sum;
    }

    private void sumHelper(TreeNode node, List<String> integers, String str) {
        if(node == null) return;
        if(node.left == null && node.right == null) {
            integers.add(str + "" + node.val);
            return;
        }
        sumHelper(node.left, integers, str + "" + node.val);
        sumHelper(node.right, integers, str + "" + node.val);
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
//        descriptions[i] = [parenti, childi, isLefti] indicates that parenti is the parent of
//        childi in a binary tree of unique values. Furthermore,
//        If isLefti == 1, then childi is the left child of parenti.
//        If isLefti == 0, then childi is the right child of parenti
        Map<Integer, TreeNode> treeNodeMap = new HashMap<>();
        Set<Integer> childs = new HashSet<>();

        for(int i = 0; i < descriptions.length; i++) {
            int parent = descriptions[i][0];
            int child  = descriptions[i][1];
            boolean isLeft = descriptions[i][2] == 1;

            TreeNode node = treeNodeMap.getOrDefault(parent, new TreeNode(parent));

            if(isLeft) {
                node.left = treeNodeMap.getOrDefault(child, new TreeNode(child));
                treeNodeMap.put(child, node.left);

            } else {
                node.right = treeNodeMap.getOrDefault(child, new TreeNode(child));
                treeNodeMap.put(child, node.right);
            }
            childs.add(child);
            treeNodeMap.put(parent, node);
        }

        TreeNode root = null;

        for(int i = 0; i < descriptions.length; i++) {
            if(!childs.contains(descriptions[i][0])) {
                root = treeNodeMap.get(descriptions[i][0]);
                break;
            }
        }

        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode treeNode = helperBST(nums, 0, nums.length );
        return treeNode;
    }

    public TreeNode helperBST(int[] nums, int left, int right) {
        if(left >= right) {
            return null;
        }
        int mid = (right+left)/2;
        TreeNode rootNode = new TreeNode(nums[mid]);
        rootNode.left = helperBST(nums, left, mid);
        rootNode.right = helperBST(nums, mid+1, right);
        return rootNode;
    }

    static class Codec {

        // Encodes a tree to a single string.
       /*  public String serialize(TreeNode root) {
           List<String> strings = new ArrayList<>();
            if(root != null)
                getString(root, strings);
            return "[" + strings.stream().collect(Collectors.joining(",")) + "]";
        }*/

        public String serialize(TreeNode root) {
            if (root == null) return "#";
            return root.val + "," + serialize(root.left) + "," + serialize(root.right);
        }
        /*private void getString(TreeNode root, List<String> strings) {
            Queue<TreeNode> treeNodes = new LinkedList<>();
            treeNodes.add(root);

            while(!treeNodes.isEmpty()) {
                TreeNode treeNode = treeNodes.poll();
                if(treeNode == null) {
                    List<TreeNode> nulls = treeNodes.stream().filter(Objects::nonNull).collect(Collectors.toList());
                    if(!treeNodes.isEmpty() && !nulls.isEmpty())
                        strings.add("null");
                    continue;
                }
                strings.add(String.valueOf(treeNode.val));
                treeNodes.add(treeNode.left);
                treeNodes.add(treeNode.right);
            }
        }*/

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
            return helper(queue);
        }

        private TreeNode helper(Queue<String> queue) {
            String s = queue.poll();
            if (s == null || s.isEmpty() || s.equals("null")) return null;
            TreeNode root = new TreeNode(Integer.valueOf(s));
            root.left = helper(queue);
            root.right = helper(queue);
            return root;
        }
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
