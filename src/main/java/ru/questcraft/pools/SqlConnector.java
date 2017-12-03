package ru.questcraft.pools;

import lombok.NonNull;
import ru.questcraft.pools.query.AbstractQuery;
import ru.questcraft.pools.query.QueryListener;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

public interface SqlConnector {

    void execute(@NonNull AbstractQuery query, QueryListener<ResultSet> listener);

    void metadata(@NonNull QueryListener<DatabaseMetaData> listener);

    String getDatabaseName();

    void close();
}
