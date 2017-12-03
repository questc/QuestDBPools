package ru.questcraft.pools.query;

import java.sql.SQLException;

public interface QueryListener<TType> {

    void handleResponse(TType response) throws SQLException;

    void handleError(Throwable throwable);
}
