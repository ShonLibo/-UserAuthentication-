package musiccatalogue.ui;

import javax.swing.*;
import java.awt.*;

public class UserAuthApp extends JFrame {
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public UserAuthApp() {
        setTitle("User Authentication");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        // Add panels
        cardPanel.add(new LoginPanel(this), "LOGIN");
        cardPanel.add(new RegisterPanel(this), "REGISTER");
        cardPanel.add(new DashboardPanel(this), "DASHBOARD");

        add(cardPanel);
        cardLayout.show(cardPanel, "LOGIN");
    }

    public void showPanel(String panelName) {
        cardLayout.show(cardPanel, panelName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UserAuthApp().setVisible(true));
    }
}