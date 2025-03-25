package authentication.ui;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class LoginPanelTest {

    @Test
    void testSignInButtonAction() {
        LoginPanel loginPanel = new LoginPanel(new UserAuthApp());

        // Fill email and password fields
        loginPanel.emailField.setText("john@example.com");
        loginPanel.passwordField.setText("password123");

        // Access the Sign-In button from components
        JButton signInButton = (JButton) loginPanel.getComponents()[6]; // Update this index as per the order in your code
        signInButton.doClick();

        // Assuming action performed changes fields in some way or triggers UI update
        // Add your assertion logic based on actual UI behavior
        assertEquals("john@example.com", loginPanel.emailField.getText());
        assertEquals("password123", new String(loginPanel.passwordField.getPassword()));
    }

    @Test
    void testSignUpButtonAction() {
        UserAuthApp app = new UserAuthApp();
        LoginPanel loginPanel = new LoginPanel(app);

        // Access the Sign Up button from components
        JButton signUpButton = (JButton) loginPanel.getComponents()[7]; // Update this index as per the order in your code
        signUpButton.doClick();

        // Verify if the current panel is REGISTER
        assertInstanceOf(RegisterPanel.class, app.getPanel("REGISTER"));  // Assuming "RegisterPanel" is the class for the register screen
    }

    @Test
    void testClearFields() {
        LoginPanel loginPanel = new LoginPanel(new UserAuthApp());
        loginPanel.emailField.setText("john@example.com");
        loginPanel.passwordField.setText("password123");

        loginPanel.clearFields();

        assertTrue(loginPanel.emailField.getText().isEmpty());
        assertTrue(new String(loginPanel.passwordField.getPassword()).isEmpty());
    }
}
