package ru.questc.dbpools;

import com.zaxxer.hikari.pool.HikariPool;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;
import redis.clients.jedis.JedisPool;

import java.util.Optional;

/**
 * Static wrapper for {@link QuestPoolsProvider} providing static proxies for its methods.
 *
 * @author CatCoder
 * @author PROgrm_JARvis
 */
@Accessors(fluent = true)
@SuppressWarnings({"unused", "WeakerAccess"})
public abstract class QuestPools {

    /**
     * Default {@link QuestPoolsProvider} instance.
     */
    @Getter private static QuestPoolsProvider defaultProvider;

    /**
     * Sets up global (read static) {@link QuestPoolsProvider}'s instance to be used as default.
     *
     * @param provider default provider for {@code QuestPools}
     *
     * @throws IllegalStateException if default provider is already set
     */
    public static void setupDefaultProvider(@NonNull final QuestPoolsProvider provider) {
        if (defaultProvider == null) defaultProvider = provider;
        else throw new IllegalStateException("QuestPools already has default provider ("
                .concat(defaultProvider.toString()).concat(")"));
    }

    /**
     * Retrieves whether Hikari-pools are enabled for default {@code QuestPoolsProvider}.
     * This guarantees that {@link #hikariPool()} will return non-empty Optional.
     *
     * @return whether or not Hikari-pools are enabled for default instance.
     */
    public boolean hikariEnabled() {
        return defaultProvider.isHikariEnabled();
    }

    /**
     * Retrieves whether Jedis-pools are enabled for default {@code QuestPoolsProvider}.
     * This guarantees that {@link #jedisPool()} will return non-empty Optional.
     *
     * @return whether or not Jedis-pools are enabled for default instance.
     */
    public boolean jedisEnabled() {
        return defaultProvider.isJedisEnabled();
    }

    /**
     * Gets ready-for-use {@link HikariPool} instance if Hikari-pools are enabled
     * for default {@code QuestPoolsProvider} to be used for JDBC-related operations.
     *
     * @return Optional of for usage {@code HikariPool} present if Hikari-pools are enabled.
     */
    public Optional<HikariPool> hikariPool() {
        return defaultProvider.getHikariPool();
    }

    /**
     * Gets specific ready-for-use {@link HikariPool} instance if Hikari-pools are enabled
     * for default {@code QuestPoolsProvider} and there is a database-specific pool for database specified
     * to be used for Hikari-related operations.
     *
     * @param database database for which to get specific pool.
     * @return Optional of for usage {@code HikariPool} present if Hikari-pools are enabled are enabled
     * and there is a valid one for database specified.
     */
    public Optional<HikariPool> hikariPool(final String database) {
        return defaultProvider.getHikariPool(database);
    }

    /**
     * Gets ready-for-use {@link JedisPool} instance if Jedis-pools are enabled
     * for default {@code QuestPoolsProvider} to be used for Redis-related operations.
     *
     * @return Optional of for usage {@code JedisPool} present if Jedis-pools are enabled.
     */
    public Optional<JedisPool> jedisPool() {
        return defaultProvider.getJedisPool();
    }

    /**
     * Gets specific ready-for-use {@link JedisPool} instance if Jedis-pools are enabled
     * for default {@code QuestPoolsProvider} and there is a database-specific pool for database specified
     * to be used for Redis-related operations.
     *
     * @param database database for which to get specific pool.
     * @return Optional of for usage {@code JedisPool} present if Jedis-pools are enabled
     * and there is a valid one for database specified.
     */
    public Optional<JedisPool> jedisPool(final int database) {
        return defaultProvider.getJedisPool(database);
    }

    /**
     * Shuts down all providers of default {@link QuestPoolsProvider}.
     */
    public static void shutdown() {
        defaultProvider.shutdown();
    }
}
