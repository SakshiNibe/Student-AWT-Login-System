import java.awt.*;
import java.awt.event.*;

public class LoginForm extends Frame implements ActionListener {

    Label title, l1, l2;
    TextField t1, t2;
    Button login, cancel;

    LoginForm() {

        // Background color
        setBackground(new Color(200, 220, 240));

        // Title
        title = new Label("Student Login System", Label.CENTER);
        title.setBounds(80, 60, 240, 30);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setForeground(Color.BLUE);

        // Username
        l1 = new Label("Username:");
        l1.setBounds(60, 130, 80, 30);
        l1.setFont(new Font("Arial", Font.BOLD, 12));

        t1 = new TextField();
        t1.setBounds(160, 130, 160, 30);

        // Password
        l2 = new Label("Password:");
        l2.setBounds(60, 180, 80, 30);
        l2.setFont(new Font("Arial", Font.BOLD, 12));

        t2 = new TextField();
        t2.setBounds(160, 180, 160, 30);
        t2.setEchoChar('*');

        // Buttons
        login = new Button("Login");
        login.setBounds(110, 240, 80, 30);
        login.setBackground(Color.GREEN);

        cancel = new Button("Cancel");
        cancel.setBounds(210, 240, 80, 30);
        cancel.setBackground(Color.RED);

        // Add
        add(title);
        add(l1); add(t1);
        add(l2); add(t2);
        add(login); add(cancel);

        // Action
        login.addActionListener(this);
        cancel.addActionListener(this);

        // Frame
        setSize(400, 350);
        setLayout(null);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == login) {
            String user = t1.getText().trim();
            String pass = t2.getText().trim();

            if(user.equals("admin") && pass.equals("1234")) {
                showMessage("Login Successful");
            } else {
                showMessage("Invalid Username or Password");
            }
        }

        if(e.getSource() == cancel) {
            t1.setText("");
            t2.setText("");
        }
    }

    void showMessage(String msg) {
        Dialog d = new Dialog(this, "Message", true);
        d.setLayout(new FlowLayout());

        Label l = new Label(msg);
        Button ok = new Button("OK");

        ok.addActionListener(e -> d.setVisible(false));

        d.add(l);
        d.add(ok);

        d.setSize(250, 150);
        d.setVisible(true);
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}