package day04.BTreeEx;

import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;

class BTree {
    public BTreeNode head = null;


    public String inOrderTraverse(BTreeNode currentNode) {
        String result = "";
        if(currentNode != null) {
            result += inOrderTraverse(currentNode.small);
            if(currentNode.s != null) {
                result += currentNode.s + " ";
            }
            result += inOrderTraverse(currentNode.middle);
            if(currentNode.l != null) {
                result += currentNode.l + " ";
            }
            result += inOrderTraverse(currentNode.large);
        }
        return result;
    }

    /**
     * Name: search
     * Desc: Search the tree for the needle, if the needle is not found return null, otherwise
     *          return a reference to the node that the needle exists at
     */
    public BTreeNode search(BTreeNode currentNode, Integer item) {
        if(currentNode != null) {
            if(currentNode.nodeType == 3) {
                if(currentNode.s >= item && currentNode.l <= item) {
                    return currentNode;
                } else {
                    if(item < currentNode.s) {
                        return currentNode.small == null ? currentNode : search(currentNode.small, item);
                    } else if(item > currentNode.l) {
                        return currentNode.large == null ? currentNode : search(currentNode.large, item);
                    } else {
                        return currentNode.middle == null ? currentNode : search(currentNode.middle, item);
                    }
                }
            } else {
                if(currentNode.s == item) {
                    return currentNode;
                } else {
                    if(item < currentNode.s) {
                        return currentNode.small == null ? currentNode : search(currentNode.small, item);
                    } else {
                        return currentNode.large == null ? currentNode : search(currentNode.large, item);
                    }
                }
            }
        }
        return null;
    }

    /**
     * Name: insert
     * Desc: Insert a new value into the tree. This does not handle the case where
     *          the value already exists in the tree.
     */
    public void insert(Integer item) {
        insert(search(head, item), item);
    }
    public void insert(BTreeNode currentNode, Integer item) {
        if(currentNode == null) {
            head = new BTreeNode(2, item, null, null);
            return;
        } else if(currentNode.nodeType == 2) {
            currentNode.nodeType = 3;
            currentNode.l = Math.max(item, currentNode.s);
            currentNode.s = Math.min(item, currentNode.s);
        } else {
            insertHelper(currentNode, item, null);
        }
    }

    /**
     * Name: insertHelper
     * Desc: Handles the case where the node where a value should be inserted
     *          already has the maximum number of values.
     */
    public void insertHelper(BTreeNode currentNode, Integer item, BTreeNode remainder) {
        BTreeNode parent, small, large;
        SortedMap<Integer, BTreeNode> nodeList = new TreeMap<Integer, BTreeNode>();

        if(currentNode.parent == null) {
            parent = new BTreeNode(null, null, null, null);
        } else {
            parent = currentNode.parent;
        }

        //New children
        small = new BTreeNode(2, Math.min(currentNode.s, Math.min(currentNode.l, item)), null, parent);
        large = new BTreeNode(2, Math.max(currentNode.s, Math.max(currentNode.l, item)), null, parent);

        //Is not a leaf
        if(currentNode.small != null && currentNode.middle != null && currentNode.large != null) {
            nodeList.put(currentNode.small.s, currentNode.small);
            nodeList.put(currentNode.large.s, currentNode.large);
            nodeList.put(currentNode.middle.s, currentNode.middle);
            nodeList.put(remainder.s, remainder);

            small.small = popNodeList(nodeList);
            small.large = popNodeList(nodeList);
            large.small = popNodeList(nodeList);
            large.large = popNodeList(nodeList);

            small.small.parent = small;
            small.large.parent = small;
            large.small.parent = large;
            large.large.parent = large;

        }

        int median = median(currentNode.s, currentNode.l, item);
        if(parent.nodeType == null) {
            parent.nodeType = 2;
            parent.s = median;
            parent.small = small;
            parent.large = large;
            head = parent;
            return;
        }
        if(parent.nodeType == 2) {
            parent.nodeType = 3;
            parent.s = Math.min(median, parent.s);
            parent.l = Math.max(median, parent.s);
            if(parent.small == currentNode) {
                if(small.s < parent.s) {
                    parent.middle = large;
                    parent.small = small;
                } else {
                    parent.middle = small;
                    parent.small = large;
                }
            } else {
                if(small.s < parent.s) {
                    parent.middle = large;
                    parent.large = small;
                } else {
                    parent.middle = small;
                    parent.large = large;
                }
            }
            return;
        }
        if(parent.nodeType == 3) {
            if(parent.small == currentNode) {
                parent.small = large;
                insertHelper(parent, median, small);
            } else {
                parent.large = small;
                insertHelper(parent, median, large);
            }
        }
    }

    /**
     * Name: median
     * Desc: Returns the median value of the 3 values given
     */
    public static Integer median(int i, int j, int k) {
        int[] valueList = {i, j, k};
        Arrays.sort(valueList);
        return valueList[1];
    }

    /**
     * Name: popNodeList
     * Desc: Given a SortedMap it will "pop" the smallest value off the list
     *          and return it, while removing it from the list.
     */
    public static BTreeNode popNodeList(SortedMap<Integer, BTreeNode> nodeList) {
        if(nodeList.isEmpty() == false) {
            BTreeNode temp = nodeList.get(nodeList.firstKey());
            nodeList.remove(nodeList.firstKey());
            return temp;
        } else {
            return null;
        }
    }
}
