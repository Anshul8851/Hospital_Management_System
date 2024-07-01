package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class NewPatient extends JFrame implements ActionListener {

    JComboBox combo;
    JTextField textFieldNumber,textName,textFieldDisease,textFieldDeposit;
    JRadioButton r1,r2;
    JLabel date;
    JButton btn1,btn2;
    Choice c1;



    NewPatient(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icon/patient.png"));
        Image img1 = img.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i1 = new ImageIcon(img1);
        JLabel label = new JLabel(i1);
        label.setBounds(550,150,200,200);
        panel.add(label);

        JLabel labelName = new JLabel("New Patient Form");
        labelName.setBounds(118,11,260,53);
        labelName.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(labelName);

        JLabel labelId = new JLabel("ID :");
        labelId.setBounds(35,76,200,14);
        labelId.setFont(new Font("Tahoma",Font.BOLD,14));
        labelId.setForeground(Color.white);
        panel.add(labelId);



        combo = new JComboBox(new String[] {"Aadhar Card","Voter Id","Driving Licence"});
        combo.setBounds(241,73,150,20);
        combo.setBackground(new Color(3,45,48));
        combo.setForeground(Color.white);
        combo.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(combo);

        JLabel labelNumber  = new JLabel("Number :");
        labelNumber.setBounds(35,111,200,14);
        labelNumber.setFont(new Font("Tahoma",Font.BOLD,14));
        labelNumber.setForeground(Color.white);
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(241,111,150,20);
        panel.add(textFieldNumber);

        JLabel patientName  = new JLabel("Name :");
        patientName.setBounds(35,151,200,14);
        patientName.setFont(new Font("Tahoma",Font.BOLD,14));
        patientName.setForeground(Color.white);
        panel.add(patientName);

        textName = new JTextField();
        textName.setBounds(241,151,150,20);
        panel.add(textName);

        JLabel labelGender  = new JLabel("Gender :");
        labelGender.setBounds(35,191,200,14);
        labelGender.setFont(new Font("Tahoma",Font.BOLD,14));
        labelGender.setForeground(Color.white);
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma",Font.BOLD,14));
        r1.setForeground(Color.white);
        r1.setBackground(new Color(109,164,170));
        r1.setBounds(241,191,80,15);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma",Font.BOLD,14));
        r2.setForeground(Color.white);
        r2.setBackground(new Color(109,164,170));
        r2.setBounds(321,191,80,15);
        panel.add(r2);

        JLabel labelDisease  = new JLabel("Disease :");
        labelDisease.setBounds(35,231,200,14);
        labelDisease.setFont(new Font("Tahoma",Font.BOLD,14));
        labelDisease.setForeground(Color.white);
        panel.add(labelDisease);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(241,231,150,20);
        panel.add(textFieldDisease);

        JLabel labelRoom  = new JLabel("Room N0 :");
        labelRoom.setBounds(35,274,200,14);
        labelRoom.setFont(new Font("Tahoma",Font.BOLD,14));
        labelRoom.setForeground(Color.white);
        panel.add(labelRoom);

//        room table
        c1 = new Choice();
        try{
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("select * from room_info;");
            while(rs.next()){
                c1.add(rs.getString("room_no"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        c1.setBounds(241,274,150,20);
        c1.setFont(new Font("Tahoma",Font.BOLD,14));
        c1.setForeground(Color.white);
        c1.setBackground(new Color(3,45,48));
        panel.add(c1);

        JLabel labelTime = new JLabel("Time :");
        labelTime.setBounds(35,316,200,14);
        labelTime.setForeground(Color.white);
        labelTime.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(labelTime);

        Date date1 = new Date();
        date = new JLabel(""+date1);
        date.setBounds(241,316,250,14);
        date.setForeground(Color.WHITE);
        date.setFont(new Font("Tamoha",Font.BOLD,14));
        panel.add(date);

        JLabel labelDeposite  = new JLabel("Deposite :");
        labelDeposite.setBounds(35,359,200,18);
        labelDeposite.setFont(new Font("Tahoma",Font.BOLD,14));
        labelDeposite.setForeground(Color.white);
        panel.add(labelDeposite);

        textFieldDeposit = new JTextField();
        textFieldDeposit.setBounds(241,359,150,20);
        panel.add(textFieldDeposit);

        btn1 = new JButton("ADD");
        btn1.setBounds(100,430,120,30);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.black);
        btn1.addActionListener(this);
        panel.add(btn1);

        btn2 = new JButton("BACK");
        btn2.setBounds(260,430,120,30);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.black);
        btn2.addActionListener(this);
        panel.add(btn2);

        setUndecorated(true);
        setSize(850,550);
        setLayout(null);
        setLocation(300,250);
        setVisible(true);
    }
    public static void main(String[] args) {
        new NewPatient();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn1){

            String radioBTN = null;
            if(r1.isSelected()){
                radioBTN = "Male";
            }else if(r2.isSelected()){
                radioBTN = "Female";
            }

            String s1 = (String)combo.getSelectedItem();
            String s2 = textFieldNumber.getText();
            String s3 = textName.getText();
            String s4 = textFieldDisease.getText();
            String s5 = c1.getSelectedItem();
            String s6 = date.getText();
            String s7 = textFieldDeposit.getText();

            try{
                Conn c = new Conn();
                String q = "insert into patient_info values('"+s2+"','"+s3+"','"+radioBTN+"','"+s1+"','"+s4+"','"+s5+"','"+s7+"','"+s6+"');";
                String q1 = "update room_info set room_availability = 'Occupied' where room_no = '"+s5+"';";
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Added Successfully");
                setVisible(false);
            }catch(Exception E){
                E.printStackTrace();
            }

        }else{
            setVisible(false);
        }
    }
}
