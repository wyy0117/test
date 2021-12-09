package com.wyy.test;

import java.util.*;

/**
 * @Date: 2021/10/13
 * @Author: wyy
 */
public class AdjustableHashMap<K, V> {
    private Map<K, V> map = new HashMap<>();
    /**
     * 维护key的顺序，默认是加入的顺序
     */
    private ArrayList<K> keyList = new ArrayList<>();

    /**
     * 元素分页大小
     */
    private final int pageSize;

    /**
     * 当前游标在keyList中的下标
     */
    private int currentIndex = -1;

    /**
     * 当前被访问的元素是否被删除
     */
    private  boolean currentNodeDeleted = false;

    public AdjustableHashMap(int pageSize) {
        this.pageSize = pageSize;
    }

    public V get(K key) {
        return map.get(key);
    }

    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    public Set<K> keySet() {
        return map.keySet();
    }

    public Collection<V> values() {
        return map.values();
    }

    public int size() {
        return keyList.size();
    }

    public void put(K key, V value) {
        map.put(key, value);
        int index = keyList.indexOf(key);
        if (index >= 0) {
            keyList.add(index, key);
        } else {
            keyList.add(key);
        }
    }

    public void remove(K key) {
        map.remove(key);
        int index = keyList.indexOf(key);
        if (index >= 0) {
            keyList.remove(key);
            if (index < currentIndex) {
                currentIndex--;
            } else if (index == currentIndex) {
                currentNodeDeleted = true;
            }
        }
    }

    public K getCurrentCursor() {
        return keyList.get(currentIndex);
    }

    public int getPageNo() {
        if (currentIndex < 0) {
            return -1;
        }
        return currentIndex / pageSize + 1;
    }

    public void access(int index) {
        if (index < 0) {
            return;
        }
        if (index >= size()) {
            currentIndex = size() - 1;
        } else {
            currentIndex = index;
        }
        currentNodeDeleted = false;
    }

    public void access(K k) {
        int index = keyList.indexOf(k);
        if (index < 0)  {
            return;
        }
        currentIndex = index;
        currentNodeDeleted = false;
    }

    public void reset() {
        currentIndex = -1;
        currentNodeDeleted = false;
    }

    public K nextKey() {
        if (currentNodeDeleted) {
            currentNodeDeleted = false;
            if (currentIndex < size()) {
                return keyList.get(currentIndex);
            } else {
                // 删除的结点是最后一个结点
                return null;
            }
        }
        int size = keyList.size();
        if (size > 0) {
            if (currentIndex == -1) {
                currentIndex = 0;
            } else if (currentIndex < size - 1) {
                currentIndex++;
            } else if (currentIndex == size - 1) {
                return null;
            }
        }

        return keyList.get(currentIndex);
    }

    public V next() {
        K key = nextKey();
        return map.get(key);
    }

    public K nextKey(K k) {
        int index = keyList.indexOf(k);
        if (index >= 0) {
            currentIndex = index;
            currentNodeDeleted = false;
            return keyList.get(currentIndex);
        } else {
            return null;
        }
    }

    public V next(K k) {
        K key = nextKey(k);
        return map.get(key);
    }

    public void moveToTop(K key) {
        int index = keyList.indexOf(key);
        if (index <= 0) {
            return;
        }

        if (index == currentIndex) {
            currentIndex = 0;
        }

        keyList.remove(index);
        keyList.add(0, key);
    }

    public void moveToBottom(K key) {
        int index = keyList.indexOf(key);
        if (index < 0) {
            return;
        }

        if (index == size() - 1){
            return;
        }

        if (index == currentIndex) {
            currentIndex = size() - 1;
        }

        keyList.remove(index);
        keyList.add(key);
    }

    public void moveUp(K key) {
        int index = keyList.indexOf(key);
        if (index <= 0) {
            return;
        }

        if (index == currentIndex) {
            currentIndex -= 1;
        }

        K upKey = keyList.get(index - 1);
        keyList.set(index - 1, key);
        keyList.set(index, upKey);
    }

    public void moveDown(K key) {
        int index = keyList.indexOf(key);
        if (index < 0) {
            return;
        }

        if (index == size() - 1) {
            return;
        }

        if (index == currentIndex) {
            currentIndex += 1;
        }

        K downKey = keyList.get(index + 1);
        keyList.set(index + 1, key);
        keyList.set(index, downKey);
    }
}
