package ru.questcraft.pools.query;

import java.sql.SQLException;

/**
 * Слушатель специфических ответов.
 *
 * @param <TType> - тип класса, который обрабатывается
 */
public interface QueryListener<TType> {

    /**
     * Обработка
     *
     * @param response - ответ
     * @throws SQLException если при обработке возникли ошибки, связанные с SQL.
     */
    void handleResponse(TType response) throws SQLException;

    /**
     * Обработка ошибок со стороны MySQL сервера при выполнении запроса.
     *
     * @param throwable - ошибка
     */
    void handleError(Throwable throwable);
}
