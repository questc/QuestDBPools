package ru.questc.dbpools.jedis;

import lombok.Data;
import lombok.EqualsAndHashCode;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import static redis.clients.jedis.Protocol.*;

@Data
@EqualsAndHashCode(callSuper = true)
public class JedisConfig extends JedisPoolConfig {
    private String host, password = null, clientName = null;
    private int
            port = DEFAULT_PORT,
            connectionTimeout = DEFAULT_TIMEOUT,
            soTimeout = DEFAULT_TIMEOUT,
            database = DEFAULT_DATABASE;
    private boolean ssl = false;

    public JedisPool createPool() {
        return new JedisPool(
                this, host, port, connectionTimeout, soTimeout, password, database, clientName, ssl, null, null, null
        );
    }
}
