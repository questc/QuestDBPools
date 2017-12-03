package ru.questcraft.pools.query;

import lombok.NonNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractQuery {

    abstract ResultSet execute(Connection connection) throws SQLException;

    public static PreparedStatement fillObjects(@NonNull PreparedStatement ps, @NonNull Object... objects) throws SQLException {
        for(int i = 0; i < objects.length; i++){
            ps.setObject(i + 1, objects[i]);
        }
        return ps;
    }
}
