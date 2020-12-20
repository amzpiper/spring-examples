package spittr.cache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;
import spittr.model.Spitter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableCaching
public class CacheConfig {
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }

    @Bean
    public RedisConnectionFactory redisCF() {
        JedisConnectionFactory cf = new JedisConnectionFactory();
        cf.setHostName("");
        cf.setPort(6379);
        cf.setPassword("");
        return cf;
    }

    @Bean
    public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory cf) {
        RedisTemplate<String, String> redis = new RedisTemplate<>();
        redis.setConnectionFactory(cf);
        return redis;
    }

    @Bean
    public RedisTemplate<String, Spitter> redisTemplate2(RedisConnectionFactory cf) {
        RedisTemplate<String, Spitter> redis = new RedisTemplate<>();
        redis.setConnectionFactory(cf);
        redis.setKeySerializer(new StringRedisSerializer());
        redis.setValueSerializer(new Jackson2JsonRedisSerializer<Spitter>(Spitter.class));
        return redis;
    }

    @Bean
    public CacheManager cacheManager2() {
        return new ConcurrentMapCacheManager();
    }

    @Bean
    public EhCacheCacheManager cacheCacheManager(CacheManager cacheManager) {
        EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager();
        return ehCacheCacheManager;
    }

    @Bean
    public CacheManager cacheManager(RedisTemplate rs) {
//        return new RedisCacheManager(rs);
        return null;
    }

    @Bean
    public CacheManager cacheManager3(RedisTemplate rs) {
        CompositeCacheManager cacheManager = new CompositeCacheManager();
        List<CacheManager> managerList = new ArrayList<CacheManager>();
        managerList.add(new JCacheCacheManager());
//        managerList.add(new RedisCacheManager(rs));
        cacheManager.setCacheManagers(managerList);
        return cacheManager;
    }

}
