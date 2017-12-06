package ru.questcraft.pools;

import lombok.NonNull;
import ru.questcraft.pools.query.AbstractQuery;
import ru.questcraft.pools.query.QueryListener;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

public interface SqlConnector {

    /**
     * Выполнеие запроса к базе данных, привязанной к этому коннектору.
     *
     * @param query    - класс запроса, их двое:
     *                 {@link ru.questcraft.pools.query.UpdateQuery} - изменить данные в БД.
     *                 {@link ru.questcraft.pools.query.SelectQuery} - получить данные из БД.
     * @param listener - так как запросы выполняются асинхронно, обработка результата
     *                 осуществляется классом {@link QueryListener}, может быть null.
     */
    void execute(@NonNull AbstractQuery query, QueryListener<ResultSet> listener);

    /**
     * Возвращает метадату БД, привязаной к этому конектору.
     *
     * @param listener - обработчик запроса
     * @throws NullPointerException если обработчик null.
     */
    void metadata(@NonNull QueryListener<DatabaseMetaData> listener);

    /**
     * Получение имени БД, привязанной к этому конектору.
     */
    String getDatabaseName();

    /**
     * Закрытие соединения, выполняется только главным плагином.
     */
    void close();
}
