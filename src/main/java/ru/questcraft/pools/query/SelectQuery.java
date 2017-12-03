package ru.questcraft.pools.query;

import lombok.NonNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectQuery extends AbstractQuery {

    public SelectQuery(@NonNull String query, @NonNull Object... objects) {
        this.query = query;
        this.objects = objects;
    }

    private final String query;
    private final Object[] objects;

    @Override
    ResultSet execute(Connection connection) throws SQLException {
        try (PreparedStatement ps = fillObjects(connection.prepareStatement(query), objects)) {
            return ps.executeQuery();
        }
    }
}
