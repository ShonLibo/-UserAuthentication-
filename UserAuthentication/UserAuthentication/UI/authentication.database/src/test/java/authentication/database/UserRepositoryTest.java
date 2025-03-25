package authentication.database;

import org.junit.jupiter.api.*;
import java.sql.*;
import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {
    private UserRepository userRepository;

    @BeforeEach
    void setUp() throws SQLException {
        userRepository = new UserRepository() {
            @Override
            public Connection getConnection() throws SQLException {
                return DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
            }
        };
        try (Statement stmt = userRepository.getConnection().createStatement()) {
            stmt.execute("DROP TABLE IF EXISTS users"); // Drop table if it exists
            stmt.execute("CREATE TABLE users (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR, tel VARCHAR, email VARCHAR, password VARCHAR)");
        }
    }


    @Test
    void getConnection_ShouldNotBeNull() throws SQLException {
        assertNotNull(userRepository.getConnection());
    }

    @Test
    void getUserByEmailAndPassword_ShouldReturnUser() throws SQLException {
        userRepository.registerUser("John Doe", "123456789", "john@example.com", "password123");
        assertTrue(userRepository.getUserByEmailAndPassword("john@example.com", "password123").next());
    }

    @Test
    void isEmailRegistered_ShouldReturnCorrectBoolean() throws SQLException {
        assertFalse(userRepository.isEmailRegistered("test@example.com"));
        userRepository.registerUser("Jane Doe", "987654321", "jane@example.com", "securepass");
        assertTrue(userRepository.isEmailRegistered("jane@example.com"));
    }

    @Test
    void registerUser_ShouldInsertUser() throws SQLException {
        userRepository.registerUser("Alice", "5551234", "alice@example.com", "mypassword");
        assertTrue(userRepository.isEmailRegistered("alice@example.com"));
    }

    @Test
    void getUserByEmailAndPassword_ShouldReturnEmptyResultForInvalidUser() throws SQLException {
        assertFalse(userRepository.getUserByEmailAndPassword("invalid@example.com", "wrongpassword").next());
    }
}
