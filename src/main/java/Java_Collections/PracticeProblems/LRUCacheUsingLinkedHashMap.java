// Syllabus practical: Evict the least recently accessed entry.
package Java_Collections.PracticeProblems;

import java.util.*;

public class LRUCacheUsingLinkedHashMap {
    static class LruCache<K, V> extends LinkedHashMap<K, V> {
        private final int limit;
        LruCache(int limit) {
            super(16, .75f, true);
            if (limit <= 0) throw new IllegalArgumentException("Limit");
            this.limit = limit;
        }
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > limit;
        }
    }

    public static void main(String[] args) {
        LruCache<String, Integer> cache = new LruCache<>(2);
        cache.put("A", 1); cache.put("B", 2);
        cache.get("A");
        cache.put("C", 3);
        System.out.println(cache.keySet());
        System.out.println(cache.containsKey("B"));
        cache.put("A", 10);
        System.out.println(cache.keySet());
    }
}
