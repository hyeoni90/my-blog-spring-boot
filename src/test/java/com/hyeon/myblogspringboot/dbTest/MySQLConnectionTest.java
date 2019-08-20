package com.hyeon.myblogspringboot.dbTest;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnectionTest {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static final String URL = "jdbc:mysql://localhost:3306/my_blog?autoReconnect=true&useUnicode=true&characterEncoding=utf-8&verifyServerCertificate=false&useSSL=false&serverTimezone=UTC";

    private static final String USER ="root";

    private static final String PW = "123qwe";

    @Test
    public void testConnection() throws Exception {
        Class.forName(DRIVER);
        try (Connection con = DriverManager.getConnection(URL, USER, PW)) {
            System.out.println(con);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
