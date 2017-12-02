package ru.questcraft.pools;

import lombok.NonNull;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.DAO;

/**
 * Основной класс для работы с пулом баз данных.
 *
 * @author CatCoder
 */
public interface QuestPools {

    /**
     * Создание стандартного экземпляра {@link Morphia}
     * со стандартным маппингом объектов.
     *
     * @return стандартный экземпляр.
     */
    Morphia defaultMorphia();

    /**
     * Получение доступа к определенной базе данных.
     *
     * @param morphia - инстанс морфии
     * @param dbName  - имя БД.
     * @return БД.
     */
    Datastore getDatastore(@NonNull Morphia morphia, String dbName);

    /**
     * Выполнение асинхронной операции.
     *
     * @param runnable - операция
     */
    void asyncOperation(@NonNull Runnable runnable);


    /**
     * Создает контейнер, содержащий объекты типа дженерика.
     *
     * @param datastore   - БД.
     * @param objectClass - тип объекта.
     * @param idClass     - тип идентификатора объекта.
     * @return контейнер (DAO).
     */
    <T, K> DAO<T, K> asDao(@NonNull Datastore datastore, Class<T> objectClass, Class<K> idClass);
}
