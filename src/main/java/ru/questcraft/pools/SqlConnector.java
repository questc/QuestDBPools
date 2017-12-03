package ru.questcraft.pools;

import lombok.NonNull;
import ru.questcraft.pools.query.AbstractQuery;
import ru.questcraft.pools.query.QueryListener;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public interface SqlConnector {

    void execute(@NonNull AbstractQuery query, QueryListener<ResultSet> listener);

    void metadata(@NonNull QueryListener<ResultSetMetaData> listener);

    String getDatabaseName();
}
