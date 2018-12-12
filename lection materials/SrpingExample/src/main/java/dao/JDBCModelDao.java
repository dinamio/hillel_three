package dao;

import org.springframework.stereotype.Component;

/**
 * Created by eugen on 12/12/18.
 */
@Component
public class JDBCModelDao implements ModelDao {
    public void printSmth() {
        System.out.println("We are JDBC");
    }
}
