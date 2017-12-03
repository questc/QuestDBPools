package ru.questcraft.pools;

import redis.clients.jedis.JedisPool;

/**
 * Основной класс для работы с пулом баз данных MySQL и Redis
 *
 * @author CatCoder
 */
public interface QuestPools {

    /**
     * Получение пула баз данных Redis.
     * @return пул Redis.
     */
    JedisPool jedisPool();

    /**
     * Возвращает дефолтный конектор MySQL.
     * @return конектор.
     */
    SqlConnector defaultSqlConnector();

    /**
     * Возвращает специфический конектор для определенной БД.
     * @param database - имя БД
     * @return конектор.
     * @throws java.util.NoSuchElementException если конектор для такой БД не найден.
     */
    SqlConnector sqlConnector(String database);
}
