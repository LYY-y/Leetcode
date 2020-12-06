import java.util.LinkedList;

/**705. 设计哈希集合
 不使用任何内建的哈希表库设计一个哈希集合

 具体地说，你的设计应该包含以下的功能

 add(value)：向哈希集合中插入一个值。
 contains(value) ：返回哈希集合中是否存在这个值。
 remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。

 示例:

 MyHashSet hashSet = new MyHashSet();
 hashSet.add(1);
 hashSet.add(2);
 hashSet.contains(1);    // 返回 true
 hashSet.contains(3);    // 返回 false (未找到)
 hashSet.add(2);
 hashSet.contains(2);    // 返回 true
 hashSet.remove(2);
 hashSet.contains(2);    // 返回  false (已经被删除)

 注意：

 所有的值都在 [0, 1000000]的范围内。
 操作的总数目在[1, 10000]范围内。
 不要使用内建的哈希集合库。
 */
public class DesignHashSet {
    //88.11%,29.13%
    boolean[] hash = null;
    /** Initialize your data structure here. */
    public DesignHashSet() {
        hash = new boolean[1000001];
    }

    public void add(int key) {
        hash[key] = true;
    }

    public void remove(int key) {
        hash[key]=false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return hash[key];
    }

    class MyHashSet {
        private Bucket[] bucketArray;
        private int keyRange;

        /** Initialize your data structure here. */
        public MyHashSet() {
            this.keyRange = 769;
            this.bucketArray = new Bucket[this.keyRange];
            for (int i = 0; i < this.keyRange; ++i)
                this.bucketArray[i] = new Bucket();
        }

        protected int _hash(int key) {
            return (key % this.keyRange);
        }

        public void add(int key) {
            int bucketIndex = this._hash(key);
            this.bucketArray[bucketIndex].insert(key);
        }

        public void remove(int key) {
            int bucketIndex = this._hash(key);
            this.bucketArray[bucketIndex].delete(key);
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int bucketIndex = this._hash(key);
            return this.bucketArray[bucketIndex].exists(key);
        }
    }



/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
}

//优秀解答，单独链表法
class MyHashSet {
    private Bucket[] bucketArray;
    private int keyRange;

    /** Initialize your data structure here. */
    public MyHashSet() {
        this.keyRange = 769;
        this.bucketArray = new Bucket[this.keyRange];
        for (int i = 0; i < this.keyRange; ++i)
            this.bucketArray[i] = new Bucket();
    }

    protected int _hash(int key) {
        return (key % this.keyRange);
    }

    public void add(int key) {
        int bucketIndex = this._hash(key);
        this.bucketArray[bucketIndex].insert(key);
    }

    public void remove(int key) {
        int bucketIndex = this._hash(key);
        this.bucketArray[bucketIndex].delete(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketIndex = this._hash(key);
        return this.bucketArray[bucketIndex].exists(key);
    }
}


class Bucket {
    private LinkedList<Integer> container;

    public Bucket() {
        container = new LinkedList<Integer>();
    }

    public void insert(Integer key) {
        int index = this.container.indexOf(key);
        if (index == -1) {
            this.container.addFirst(key);
        }
    }

    public void delete(Integer key) {
        this.container.remove(key);
    }

    public boolean exists(Integer key) {
        int index = this.container.indexOf(key);
        return (index != -1);
    }
}
