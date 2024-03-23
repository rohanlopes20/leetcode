package com.leetcode;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {
    private List<Integer> list = new ArrayList<>();
    int size;
    int current;
    public NestedIterator(List<NestedInteger> nestedList) {
        setNestedInteger(list, nestedList);
        size = list.size();
        current = 0;
    }

    private void setNestedInteger(List<Integer> list, List<NestedInteger> nestedInteger) {
        for(NestedInteger iterator : nestedInteger) {
            if(iterator.isInteger()) {
                list.add(iterator.getInteger());
            } else {
                setNestedInteger(list, iterator.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return list.get(current++);
    }

    @Override
    public boolean hasNext() {
        return list.size() > current;
    }

    public static void main(String[] args) {
//        NestedIterator i = new NestedIterator(nestedList);
//        while (i.hasNext()) v[f()] = i.next();
        //1,[4,[6]]
        List<NestedInteger> nestedList = new ArrayList<>();
        nestedList.add(new NestedInteger() {
            @Override
            public boolean isInteger() {
                return true;
            }

            @Override
            public Integer getInteger() {
                return 1;
            }

            @Override
            public List<NestedInteger> getList() {
                return null;
            }
        });
        nestedList.add(new NestedInteger() {
            @Override
            public boolean isInteger() {
                return false;
            }

            @Override
            public Integer getInteger() {
                return null;
            }

            @Override
            public List<NestedInteger> getList() {
                List<NestedInteger> nestedList = new ArrayList<>();
                nestedList.add(new NestedInteger() {
                    @Override
                    public boolean isInteger() {
                        return true;
                    }

                    @Override
                    public Integer getInteger() {
                        return 3;
                    }

                    @Override
                    public List<NestedInteger> getList() {
                        return null;
                    }
                });
                return nestedList;
            }
        });
        NestedIterator iterator = new NestedIterator(nestedList);
        while(iterator.hasNext()) {
            Integer integer = iterator.next();
            System.out.println(integer);
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */