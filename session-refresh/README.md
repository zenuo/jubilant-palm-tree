## 这是什么

混用Hibernate与JdbcTemplate时，由于前者实际请求DB的时机不一定与代码一致，所以会导致程序行为与预期不一致的情况，本例子试图重现这种情况。

## 准备

MySQL数据库：

用户名密码见`application.properties`，DDL：

```sql
CREATE TABLE `customer` (
  `id` bigint(20) unsigned NOT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```

## 怎么玩儿
您可以执行下面两个单元测试来重现：

1. demo.BaseTest.updateWithoutRefresh
2. demo.BaseTest.updateWithRefresh