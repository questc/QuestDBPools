package ru.questcraft.pools;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Основной класс для работы с пулом баз данных MySQL и Redis
 *
 * @author CatCoder
 */
public interface QuestPools {

    /**
     * Получение пула баз данных Redis.
     *
     * @return пул Redis.
     */
    JedisPool jedisPool();

    /**
     * Авторизация экзмепляра класса {@link Jedis} для работы с запросами.
     *
     * @param jedis - инстанс Jedis
     * @return авторизованный Jedis.
     */
    Jedis authenticate(Jedis jedis);

    /**
     * Возвращает дефолтный конектор MySQL.
     *
     * @return конектор.
     */
    SqlConnector defaultSqlConnector();

    /**
     * Возвращает специфический конектор для определенной БД.
     *
     * @param database - имя БД
     * @return конектор.
     * @throws java.util.NoSuchElementException если конектор для такой БД не найден.
     */
    SqlConnector sqlConnector(String database);

    /**
     * Используя темную магию SPI достаем реализацию {@link QuestPools}
     * @return реализацию, если она найдена, иначе {@link IllegalStateException}
     */
    static QuestPools instance(){
        Iterator<QuestPools> iterator = ServiceLoader.load(QuestPools.class).iterator();

        if(!iterator.hasNext()) throw new IllegalStateException("QPools implementations not found.");

        return iterator.next();
    }
}
