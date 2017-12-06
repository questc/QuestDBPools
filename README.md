# QuestDBPools
Работа с базой данных сервера

## Использование

Данный пул поддерживает работу с Jedis и MySQL.

#### MySQL

Для работы с базой данных, нужно получить конектор:
```java
SqlConnector connector = QuestPools.instance().sqlConnector(имя_БД);
```
Выполнение запросов:
```java
//Запись данных
connector.execute(new UpdateQuery("CREATE TABLE IF NOT EXISTS `users` (`name` VARCHAR(16))"), null);
//Чтение данных
connector.execute(new SelectQuery("SELECT * FROM `users`"), new QueryListener<ResultSet>() {
    @Override
    public void handleResponse(ResultSet response) throws SQLException {
        while (response.next()){
            System.out.println(response.getString("name"));
        }
    }

   @Override
    public void handleError(Throwable throwable) {
        throwable.printStackTrace();
    }
});
```
Параметризированные запросы:
```java
connector.execute(new SelectQuery("SELECT * FROM `users` WHERE name=?", "CatCoder"), обработчик);
```

#### Redis

Для работы с СУБД Redis нужно получить пул:
```java
JedisPool pool = QuestPools.instance().jedisPool();
```
Для выполнения запросов нужно авторизовать клиента:
```java
//Получение клиента
Jedis jedis = pool.getResource();
//Авторизация
QuestPools.instance().authenticate(jedis);
//Выполнение запросов
jedis.set("key", "meoow");
jedis.get("key");

//Не забываем закрывать соединение
jedis.close();
```
