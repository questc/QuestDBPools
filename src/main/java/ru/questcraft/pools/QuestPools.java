package ru.questcraft.pools;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ServiceLoader;

/**
 * Основной класс для работы с пулом баз данных MySQL и Redis
 *
 * @author CatCoder
 */
public abstract class QuestPools {

    private static QuestPools instance;

    public static QuestPools instance() {
        if (instance == null) instance = ServiceLoader.load(QuestPools.class).iterator().next();

        return instance;
    }

    /**
     * Получение пула баз данных Redis.
     *
     * @return пул Redis.
     */
    public abstract JedisPool jedisPool();

    /**
     * Авторизация экзмепляра класса {@link Jedis} для работы с запросами.
     *
     * @param jedis - инстанс Jedis
     * @return авторизованный Jedis.
     */
    public abstract Jedis authenticate(Jedis jedis);

    /**
     * Возвращает дефолтный конектор MySQL.
     *
     * @return конектор.
     */
    public abstract SqlConnector defaultSqlConnector();

    /**
     * Возвращает специфический конектор для определенной БД.
     *
     * @param database - имя БД
     * @return конектор.
     * @throws java.util.NoSuchElementException если конектор для такой БД не найден.
     */
    public abstract SqlConnector sqlConnector(String database);
}
