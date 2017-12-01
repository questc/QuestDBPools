package ru.questcraft.pools;

import lombok.NonNull;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

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
     * Получение доступа к определенной базе данных по ключу.
     * Если база данных публичная, то ключ не потребуется.
     *
     * @param morphia - инстанс морфии
     * @param key     - ключ, может быть null.
     * @return БД.
     */
    Datastore getDatastore(@NonNull Morphia morphia, String key);

    /**
     * Выполнение асинхронной операции.
     *
     * @param runnable - операция
     */
    void asyncOperation(@NonNull Runnable runnable);
}
