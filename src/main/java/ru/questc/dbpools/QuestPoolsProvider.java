package ru.questc.dbpools;

import com.zaxxer.hikari.pool.HikariPool;
import redis.clients.jedis.JedisPool;

import java.util.Optional;

/**
 * Provider used for JDBC and Redis -related operations using HikariCP and Jedis pools respectively.
 */
public interface QuestPoolsProvider {

    /**
     * Retrieves whether Hikari-pools are enabled.
     * This guarantees that {@link #getHikariPool()} will return non-empty Optional.
     *
     * @return whether or not Hikari-pools are enabled.
     */
    boolean isHikariEnabled();

    /**
     * Retrieves whether Jedis-pools are enabled.
     * This guarantees that {@link #getJedisPool()} will return non-empty Optional.
     *
     * @return whether or not Jedis-pools are enabled.
     */
    boolean isJedisEnabled();

    /**
     * Gets ready-for-use {@link HikariPool} instance if Hikari-pools are enabled
     * to be used for JDBC-related operations.
     *
     * @return Optional of for usage {@code HikariPool} present if Hikari-pools are enabled.
     */
    Optional<HikariPool> getHikariPool();

    /**
     * Gets specific ready-for-use {@link HikariPool} instance if Hikari-pools are enabled
     * and there is a database-specific pool for database specified to be used for Hikari-related operations.
     *
     * @param database database for which to get specific pool.
     * @return Optional of for usage {@code HikariPool} present if Hikari-pools are enabled are enabled
     * and there is a valid one for database specified.
     */
    Optional<HikariPool> getHikariPool(String database);

    /**
     * Gets ready-for-use {@link JedisPool} instance if Jedis-pools are enabled
     * to be used for Redis-related operations.
     *
     * @return Optional of for usage {@code JedisPool} present if Jedis-pools are enabled.
     */
    Optional<JedisPool> getJedisPool();

    /**
     * Gets specific ready-for-use {@link JedisPool} instance if Jedis-pools are enabled
     * and there is a database-specific pool for database specified
     * to be used for Redis-related operations.
     *
     * @param database database for which to get specific pool.
     * @return Optional of for usage {@code JedisPool} present if Jedis-pools are enabled
     * and there is a valid one for database specified.
     */
    Optional<JedisPool> getJedisPool(int database);

    /**
     * Shuts down all pools.
     */
    default void shutdown() {}
}
