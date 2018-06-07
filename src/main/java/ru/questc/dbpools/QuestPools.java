package ru.questc.dbpools;

import com.zaxxer.hikari.pool.HikariPool;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;
import lombok.val;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 *
 *
 * @author CatCoder
 * @author PROgrm_JARvis
 */
@Accessors(fluent = true)
public abstract class QuestPools {

    /**
     * Static instance of QuqstPools. Default in most cases
     */
    @Getter private static QuestPools instance;

    /**
     * Sets up global (read static) {@code QuestPools}'s instance to be used as default.
     *
     * @see #hikariPool()
     * @see #jedisPool()
     */
    public static void setupInstance(@NonNull final QuestPools instance) {
        if (QuestPools.instance == null) QuestPools.instance = instance;
        throw new IllegalStateException("QuestPools already has default instance");
    }

    /**
     * Gets ready-for-use {@link HikariPool} instance to be used for JDBC-related operations.
     *
     * @return {@code HikariPool} ready for usage.
     */
    public abstract HikariPool getHikariPool();

    /**
     *  Gets ready-for-use {@link JedisPool} instance to be used for Redis-related operations.
     *
     * @return {@code JedisPool} ready for usage.
     */
    public abstract JedisPool getJedisPool();

    /**
     * Gets ready-for-use {@link HikariPool} of default {@link QuestPools} instance.
     *
     * @return default {@code HikariPool} ready for usage.
     */
    public static HikariPool hikariPool() {
        return instance.getHikariPool();
    }

    /**
     * Gets ready-for-use {@link JedisPool} of default {@link QuestPools} instance.
     *
     * @return default {@code JedisPool} ready for usage.
     */
    public static JedisPool jedisPool() {
        return instance.getJedisPool();
    }
}
