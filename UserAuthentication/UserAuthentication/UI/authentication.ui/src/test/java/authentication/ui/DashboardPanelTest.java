package authentication.ui;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import static org.junit.jupiter.api.Assertions.*;

class DashboardPanelTest {

    @Test
    void setUserInfo_ShouldUpdateLabels() {
        // Create the DashboardPanel instance
        DashboardPanel dashboardPanel = new DashboardPanel(new UserAuthApp());

        // Ensure that the components are initialized
        SwingUtilities.invokeLater(() -> {
            // Accessing components directly after layout is completed
            JLabel nameLabel = (JLabel) dashboardPanel.getComponents()[1];
            JLabel telLabel = (JLabel) dashboardPanel.getComponents()[2];
            JLabel emailLabel = (JLabel) dashboardPanel.getComponents()[3];

            // Set user info
            dashboardPanel.setUserInfo("John", "12345", "john@example.com");

            // Verify that the labels are updated correctly
            assertEquals("Name: John", nameLabel.getText());
            assertEquals("Tel No: 12345", telLabel.getText());
            assertEquals("Email: john@example.com", emailLabel.getText());
        });
    }

    @Test
    void backButton_ShouldBeClickable() {
        // Create the DashboardPanel instance
        DashboardPanel dashboardPanel = new DashboardPanel(new UserAuthApp());

        // Ensure that the components are initialized
        SwingUtilities.invokeLater(() -> {
            // Accessing the button after layout is completed
            JButton backButton = (JButton) dashboardPanel.getComponents()[4];

            // Verify that the button is not null and click it
            assertNotNull(backButton);
            backButton.doClick();
        });
    }
}
