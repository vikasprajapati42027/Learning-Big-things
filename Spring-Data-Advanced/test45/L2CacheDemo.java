class CacheParent { String provider = "Ehcache"; }
class RedisCache extends CacheParent { String provider = "Redis"; }
public class L2CacheDemo {
    public static void main(String[] args) { System.out.println("Cache: " + new RedisCache().provider); }
}
