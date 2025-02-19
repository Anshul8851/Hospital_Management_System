package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {

    JTextField textField;
    JPasswordField passField;
    JButton b1,b2;

    Login(){

        JLabel nameLabel = new JLabel("UserName: ");
        nameLabel.setBounds(40,20,100,30);
        nameLabel.setFont(new Font("Tahoma",Font.BOLD,16));
        add(nameLabel);

        JLabel passLabel = new JLabel("Password: ");
        passLabel.setBounds(40,70,100,30);
        passLabel.setFont(new Font("Tohama",Font.BOLD,16));
        add(passLabel);

        textField = new JTextField();
        textField.setBounds(150,20,150,30);
        textField.setFont(new Font("Tahoma",Font.PLAIN,16));
        textField.setBackground(new Color(255,179,0));
        add(textField);

        passField = new JPasswordField();
        passField.setBounds(150,70,150,30);
        passField.setFont(new Font("Tahoma",Font.PLAIN,16));
        passField.setBackground(new Color(255,179,0));
        add(passField);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icon/10130.jpg"));
        Image i1 = image.getImage().getScaledInstance(300,150,Image.SCALE_DEFAULT);
        ImageIcon img = new ImageIcon(i1);
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(320,20,400,150);
        add(imgLabel);

        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);




//        it is used to set bgcolor of our frame
        getContentPane().setBackground(new Color(109,164,170));
        setSize(750,300);
        setLayout(null);
        setLocation(400,270);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            try{
                Conn c = new Conn();
                String user = textField.getText();
                String password = passField.getText();
                String query = "select * from login_table where user_name = '"+user+"' and password = '"+password+"';";
                ResultSet rs = c.statement.executeQuery(query);

                if(rs.next()){
                    new Reception();
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid");
                }
            }catch(Exception E){
                E.printStackTrace();
            }

        }else{
            System.exit(10);
        }
    }
}
