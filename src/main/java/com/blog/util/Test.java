package com.blog.util;



import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    private DataSource dataSource;

    @org.junit.Test
    public void test() throws SQLException {
        Connection data = dataSource.getConnection();

        System.out.println("------" + data.getClass());

        System.out.println("------" + dataSource.getClass());

        data.close();
    }

}

