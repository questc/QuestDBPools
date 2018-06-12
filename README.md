# QuestDBPools
###### A simple wrapper for database communications

## Usage
To use QuestDBPools you can simply access default instance's methods using static methods of `QuestPools` class.
You can invoke `QuestPools.defaultProvider()` to get this instance.

In order to work with general JDBC or Redis operations, get instance of `Connection` or `Jedis`:
```java

// JDBC
try (final Connection connection = QuestPools.jdbcConnection()){
    // do whatever needed with Connection
}
try (final Jedis connection = QuestPools.jedis()){
    // do whatever needed with Jedis
}
```
As you can see both of them are `AutoCloseable` and can and __should__ be put in _try-with-resource_ statement.