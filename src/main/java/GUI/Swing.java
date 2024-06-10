package GUI;

import com.example.spring.impl.ПользовательServiceImpl;
import com.example.spring.model.Пользователь;
import com.example.spring.service.ПользовательService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.swing.*;
import javax.swing.plaf.IconUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Optional;

public class Swing extends JFrame{
    private JPanel VoitiLabel;
    private JTextField loginTextField;
    private JTextField passwordTextField;
    private JButton autorizeButton;
    private JPasswordField passwordField1;
    private JLabel label2121 ;
    private final PasswordEncoder passwordEncoder;
    private ПользовательServiceGUI пользовательServiceGUI = new ПользовательServiceGUI();
    private final Swing swing = Swing.this;
    public Swing(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        autorizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = loginTextField.getText();
                String password = new String(passwordField1.getText());
                if (validateUser(username, password)) {
                    Optional<Пользователь> user = пользовательServiceGUI.findByЛогин(username);
                    JOptionPane.showMessageDialog(autorizeButton, "Успешная авторизация!");
                    mainGUI mainGUI = new mainGUI(passwordEncoder, swing, user.get().getНазваниеРоли());
                    mainGUI.setTitle("Hello");
                    mainGUI.setContentPane(mainGUI.getJp());
                    mainGUI.setSize(835, 430);
                    mainGUI.pack();
                    mainGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    mainGUI.setVisible(true);
                    Swing.this.dispose();
                } else {
                    JOptionPane.showMessageDialog(autorizeButton, "Неверный логин или пароль!");
                }
            }
        });
    }

    private boolean validateUser(String username, String password) {
        Optional<Пользователь> user = пользовательServiceGUI.findByЛогин(username);
        return user.isPresent() && passwordEncoder.matches(password, user.get().getПароль());
    }

    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Swing swing = new Swing(passwordEncoder);

        try {
            Icon icon = new ImageIcon("D:\\OneDrive\\Desktop\\spring\\src\\main\\java\\GUI\\image\\conv.png");
            swing.label2121.setIcon(icon);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        swing.pack();
        swing.setContentPane(swing.VoitiLabel);
        swing.setTitle("Hello");
        swing.setSize(835, 430);
        swing.setVisible(true);
        swing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

