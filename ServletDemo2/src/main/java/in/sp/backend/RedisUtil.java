package in.sp.backend;

import redis.clients.jedis.Jedis;

public class RedisUtil {
    private static Jedis getConnection() {
        return new Jedis("localhost", 6379); 
    }

    public static void saveSession(String sessionId, String name) {
        try (Jedis jedis = getConnection()) {
        	System.out.println("--in save session funtion of redisUtil--");
        	System.out.println("--with session id-->"+sessionId);
            String redisKey = "session:" + sessionId;
            jedis.set(redisKey, name);
            jedis.expire(redisKey, 3600); 
        }
    }

    public static String getSession(String sessionId) {
        try (Jedis jedis = getConnection()) {
            String redisKey = "session:" + sessionId;
            return jedis.get(redisKey);
        }
    }

    public static void deleteSession(String sessionId) {
        try (Jedis jedis = getConnection()) {
            String redisKey = "session:" + sessionId;
            jedis.del(redisKey);
        }
    }
}
