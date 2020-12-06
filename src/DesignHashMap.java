import java.util.Arrays;

/**706. 设计哈希映射
 不使用任何内建的哈希表库设计一个哈希映射

 具体地说，你的设计应该包含以下的功能

 put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
 get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
 remove(key)：如果映射中存在这个键，删除这个数值对。

 示例：

 MyHashMap hashMap = new MyHashMap();
 hashMap.put(1, 1);
 hashMap.put(2, 2);
 hashMap.get(1);            // 返回 1
 hashMap.get(3);            // 返回 -1 (未找到)
 hashMap.put(2, 1);         // 更新已有的值
 hashMap.get(2);            // 返回 1
 hashMap.remove(2);         // 删除键为2的数据
 hashMap.get(2);            // 返回 -1 (未找到)

 注意：

 所有的值都在 [0, 1000000]的范围内。
 操作的总数目在[1, 10000]范围内。
 不要使用内建的哈希库。
 * */
public class DesignHashMap {
    //89.63%,76.91%
    int[] map;
    /** Initialize your data structure here. */
    public DesignHashMap() {
        map = new int[100001];
        Arrays.fill(map,-1);
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        map[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return map[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map[key] = -1;
    }



    //优秀解答
    class ListNode {
        int key;
        int value;
        ListNode next;
        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    ListNode[] buckets;
    /** Initialize your data structure here. */
//
//    public DesignHashMap2() {
//        buckets = new ListNode[100001];
//    }

    /** value will always be non-negative. */
    public void put2(int key, int value) {
        int idx = getIdx(key);

        ListNode pre = getPre(buckets[idx], key);

        if (pre == null) {
            buckets[idx] = new ListNode(key, -1);
            buckets[idx].next = new ListNode(key, value);
        } else if (pre.next == null) {
            pre.next = new ListNode(key, value);
        } else {
            pre.next.value = value;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get2(int key) {
        int idx = getIdx(key);

        ListNode pre = getPre(buckets[idx], key);

        if (pre == null) {
            return -1;
        } else if (pre.next == null) {
            return -1;
        } else {
            return pre.next.value;
        }
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove2(int key) {
        int idx = getIdx(key);

        ListNode pre = getPre(buckets[idx], key);

        if (pre == null) {
            return;
        } else if (pre.next == null) {
            return;
        } else {
            pre.next = pre.next.next;
        }
    }

    public int getIdx(int key) {
        return Integer.hashCode(key) % buckets.length;
    }

    public ListNode getPre(ListNode dummy, int key) {
        ListNode cur = dummy;
        ListNode pre = dummy;
        while (cur != null && cur.key != key) {
            pre = cur;
            cur = cur.next;
        }

        return pre;
    }

    public static void main(String[] args){
        DesignHashMap hashMap = new DesignHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.get(1);// 返回 1
        hashMap.get(3); // 返回 -1 (未找到)
        hashMap.put(2, 1); // 更新已有的值
        hashMap.get(2); // 返回 1
        hashMap.remove(2);  // 删除键为2的数据
        hashMap.get(2);// 返回 -1 (未找到)

    }
}
