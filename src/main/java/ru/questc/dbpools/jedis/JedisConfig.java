package ru.questc.dbpools.jedis;

import lombok.Data;
import lombok.EqualsAndHashCode;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import static redis.clients.jedis.Protocol.*;

/**
 * A wrapper for {@link JedisPool} configuration including most of its parameters used in constructors.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@SuppressWarnings("unused")
public class JedisConfig extends JedisPoolConfig {
    private String host = "localhost", password = null, clientName = null;
    private int
            port = DEFAULT_PORT,
            connectionTimeout = DEFAULT_TIMEOUT,
            soTimeout = DEFAULT_TIMEOUT,
            database = DEFAULT_DATABASE;
    private boolean ssl = false;

    /**
     * Creates new {@link JedisPool} from this configuration.
     *
     * @return newly created Jedis-pool based on this config
     */
    public JedisPool createPool() {
        return new JedisPool(
                this, host, port, connectionTimeout, soTimeout, password, database, clientName, ssl, null, null, null
        );
    }
}
