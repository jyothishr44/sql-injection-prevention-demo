package in.demo.SQLInjection.dao;

import in.demo.SQLInjection.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@Repository
@RequiredArgsConstructor
public class UserDAO {

    private final Connection connection;

    // =============================
    // Register (Prepared Statement)
    // =============================

    public boolean register(User user) {

        String sql = "INSERT INTO users(username, password) VALUES(?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // ===================================================
    // Login using Statement (This Approach is Vulnerable)
    // ===================================================

    public boolean loginUsingStatement(User user) {

        try {
            Statement st = connection.createStatement();

            String query = "SELECT * FROM users WHERE username='"
                    + user.getUsername()
                    + "' AND password='"
                    + user.getPassword()
                    + "'";

            System.out.println("Generated Query:");
            System.out.println(query);

            ResultSet rs = st.executeQuery(query);

            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // ================================================
    // Login using PreparedStatement (This is Protected)
    // ================================================

    public boolean loginUsingPrepared(User user) {

        String sql = "SELECT * FROM users WHERE username=? AND password=?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
