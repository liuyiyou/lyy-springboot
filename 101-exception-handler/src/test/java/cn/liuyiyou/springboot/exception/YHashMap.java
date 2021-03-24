package cn.liuyiyou.springboot.exception;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author: liuyiyou.cn
 * @date: 2021/2/25
 * @version: V1.0
 */
public class YHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable {

    //默认初始化table数组容量16  2^4
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

    //table最大容量1073741824 2^30
    static final int MAXIMUM_CAPACITY = 1 << 30;

    //默认加载因子, 即当现有数组长度达到容量的75%时会进行扩容操作
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    //1.8新增 当链表的长度 >=8 - 1 时会转换为红黑树, 关于为什么要定义为8的详细解读在下面↓
    static final int TREEIFY_THRESHOLD = 8;

    //1.8新增 当红黑树的长度 <=6 时会转换为链表, 关于为什么红黑树 → 链表的阈值是6的详细解读在下面↓
    static final int UNTREEIFY_THRESHOLD = 6;

    //1.8新增 红黑树的最小容量
    static final int MIN_TREEIFY_CAPACITY = 64;

    //定义一个类型为Node<K,V>的table数组
    transient Node<K, V>[] table;

    //table数组的长度
    transient int size;

    //实际的扩容的阈值 threshold = 容量 * 加载因子
//在构造器中会被初始化为DEFAULT_INITIAL_CAPACITY的值16
//在第一次存储数据时会在inflateTable()方法中再次赋值threshold = (int) Math.min(capacity * loadFactor, MAXIMUM_CAPACITY + 1);
    int threshold;

    //实际的加载因子, 在构造器中进行初始化
//如果创建HashMap时没有指定loadFactor的大小则会初始化为DEFAULT_INITIAL_CAPACITY的值
    final float loadFactor;

    //HashMap更改的次数
//用来作为并发下判断是否有其它线程修改了该HashMap,抛出ConcurrentModificationException
    transient int modCount;

    static class Node<K, V> implements Map.Entry<K, V> {

        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        public Node(int hash, final K key, final V value, final Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(final V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        @Override
        public final String toString() {
            return key + "=" + value;
        }

        public final boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o instanceof Map.Entry) {
                Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
                if (Objects.equals(key, e.getKey()) &&
                    Objects.equals(value, e.getValue())) {
                    return true;
                }
            }
            return false;
        }
    }


    public YHashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " +
                initialCapacity);
        }
        if (initialCapacity > MAXIMUM_CAPACITY) {
            initialCapacity = MAXIMUM_CAPACITY;
        }
        if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
            throw new IllegalArgumentException("Illegal load factor: " +
                loadFactor);
        }
        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(initialCapacity);
    }


    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    @Override
    public V getOrDefault(final Object key, final V defaultValue) {
        return null;
    }

    @Override
    public void forEach(final BiConsumer<? super K, ? super V> action) {

    }

    @Override
    public void replaceAll(final BiFunction<? super K, ? super V, ? extends V> function) {

    }

    @Override
    public V putIfAbsent(final K key, final V value) {
        return null;
    }

    @Override
    public boolean remove(final Object key, final Object value) {
        return false;
    }

    @Override
    public boolean replace(final K key, final V oldValue, final V newValue) {
        return false;
    }

    @Override
    public V replace(final K key, final V value) {
        return null;
    }

    @Override
    public V computeIfAbsent(final K key, final Function<? super K, ? extends V> mappingFunction) {
        return null;
    }

    @Override
    public V computeIfPresent(final K key, final BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return null;
    }

    @Override
    public V compute(final K key, final BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return null;
    }

    @Override
    public V merge(final K key, final V value, final BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        return null;
    }

    /**
     * Returns a power of two size for the given target capacity.
     */
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
