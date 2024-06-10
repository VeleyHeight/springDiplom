package GUI;

import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;
import java.sql.*;

public class mainGUI extends JFrame {
    @Getter
    private JPanel jp;
    private JPanel jp4;
    private JPanel jp1;
    private JPanel jp2;
    private JPanel jp3;
    private JPanel jpButton4;
    private JPanel mainJP;
    private JTable table1;
    private JButton addBTN;
    private JButton button2;
    private JButton updateBTN;
    private JButton deleteBTN;
    private JScrollPane jsScroll;
    private JLabel label4;
    private JTextField tf4;
    private JTextField tf1;
    private JTextField tf2;
    private JTextField tf3;
    private JMenuBar MyMenu;
    private JMenuItem userOpen;
    private JMenuItem jClient;
    private JMenuItem jSposob;
    private JMenuItem menuZakaz;
    private JMenuItem logoutItem;
    private JMenuItem infotItem;
    private JMenuItem contactItem;
    private JMenuItem manager;
    private JMenuItem obemItem;
    private JMenuItem skladItem;
    private JMenuItem sostavSkladaItem;
    private JMenuItem sostavZakaza;
    private JMenuItem postavshikItem;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JPanel jp5;
    private JPanel jp6;
    private JPanel jp7;
    private JPanel jp8;
    private JPanel jp9;
    private JPanel jp10;
    private JPanel jp11;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JTextField tf5;
    private JTextField tf6;
    private JTextField tf7;
    private JTextField tf8;
    private JTextField tf9;
    private JTextField tf10;
    private JTextField tf11;
    private JLabel noSelect;
    private JLabel idSave;
    private final PasswordEncoder passwordEncoder;
    private String saveId = "-1";
    private String tableName = "Заказ";
    private Swing swingForm;
    private String getIdColumnName(String tableName) {
        switch (tableName) {
            case "Пользователь":
                return "Код_пользователя";
            case "Клиент":
                return "\"Код клиента\"";
            case "Заказ":
                return "\"Код заказа\"";
            case "Информация_о_товаре":
                return "Код_информации_о_товаре";
            case "Контактное_лицо":
                return "Код_контактного_лица";
            case "Менеджеры":
                return "Код_менеджера";
            case "Объем_продукции":
                return "Код_объема";
            case "Поставщики":
                return "Код_поставщика";
            case "Склад_доставки":
                return "Код_склада_доставки";
            case "Состав_заказа":
                return "Код_состава_заказа";
            case "Состав_склада":
                return "Код_состава_склада";
            case "Способ_доставки":
                return "Код_способа_доставки";
            default:
                return "id";
        }
    }
//    public static void main(String[] args) {
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//            mainGUI frame = new mainGUI(passwordEncoder,swingForm);
//            frame.setTitle("Hello");
//            frame.setContentPane(frame.jp);
//            frame.setSize(835, 430);
//            frame.pack();
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setVisible(true);
//
//
//    }
    private JLabel getLabel(String name) {
        switch (name) {
            case "label1":
                return label1;
            case "label2":
                return label2;
            case "label3":
                return label3;
            case "label4":
                return label4;
            case "label5":
                return label5;
            case "label6":
                return label6;
            case "label7":
                return label7;
            case "label8":
                return label8;
            case "label9":
                return label9;
            case "label10":
                return label10;

            default:
                return label1;
        }
    }
    private JTextField getTextField(String name) {
        switch (name) {
            case "tf1":
                return tf1;
            case "tf2":
                return tf2;
            case "tf3":
                return tf3;
            case "tf4":
                return tf4;
            case "tf5":
                return tf5;
            case "tf6":
                return tf6;
            case "tf7":
                return tf7;
            case "tf8":
                return tf8;
            case "tf9":
                return tf9;
            case "tf10":
                return tf10;


            default:
                return tf11;
        }
    }
    private String  getTextFieldValue(String name) {
        switch (name) {
            case "tf1":
                return tf1.getText();
            case "tf2":
                return tf2.getText();
            case "tf3":
                return tf3.getText();
            case "tf4":
                return tf4.getText();
            case "tf5":
                return tf5.getText();
            case "tf6":
                return tf6.getText();
            case "tf7":
                return tf7.getText();
            case "tf8":
                return tf8.getText();
            case "tf9":
                return tf9.getText();
            case "tf10":
                return tf10.getText();

            default:
                return tf11.getText();
        }
    }
    private JPanel getComponentByName(String name) {
        switch (name) {
            case "jp1":
                return jp1;
            case "jp2":
                return jp2;
            case "jp3":
                return jp3;
            case "jp4":
                return jp4;
            case "jp5":
                return jp5;
            case "jp6":
                return jp6;
            case "jp7":
                return jp7;
            case "jp8":
                return jp8;
            case "jp9":
                return jp9;
            case "jp10":
                return jp10;

            default:
                return jp11;
        }
    }
    public mainGUI(PasswordEncoder passwordEncoder,Swing swingForm, String role) {
        if(role.equals("Менеджер по поставщикам")){
            userOpen.setVisible(false);
            jClient.setVisible(false);
            menuZakaz.setVisible(false);
            sostavZakaza.setVisible(false);
        }
        else if(role.equals("Менеджер по продажам")){
            postavshikItem.setVisible(false);
            userOpen.setVisible(false);
        }
        this.passwordEncoder = passwordEncoder;
        this.swingForm = swingForm;
        tableName = "Заказ";
        findAll(tableName);
        jp1.setVisible(false);
        button2.setVisible(false);
        jp2.setVisible(false);
        jp3.setVisible(false);
        jp4.setVisible(false);
        jp5.setVisible(false);
        jp6.setVisible(false);
        jp7.setVisible(false);
        jp8.setVisible(false);
        jp9.setVisible(false);
        jp10.setVisible(false);
        jp11.setVisible(false);
        jpButton4.setVisible(false);
        addBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = tf1.getText();
                String password = tf2.getText();
                String name_role = tf3.getText();
                insertAll(login,password,name_role);
            }
        });
        table1.addComponentListener(new ComponentAdapter() {
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                jpButton4.setVisible(true);
                noSelect.setVisible(false);
                mainJP.setVisible(true);
                DefaultTableModel model = (DefaultTableModel) table1.getModel();
                int selectedRow = table1.getSelectedRow();
                int columnCount = model.getColumnCount();

                for (int i = 1; i <= 11; i++) {
                    JPanel textField = getComponentByName("jp" + i);
                    textField.setVisible(false);
                }
                    if (!tableName.equals("Объем_продукции")){
                for (int column = 1; column < columnCount; column++) {
                    JLabel label = getLabel("label" + column);
                    label.setText(model.getColumnName(column));

                    JPanel jpanel = getComponentByName("jp" + column);
                    jpanel.setVisible(true);
                    JTextField textField = getTextField("tf" + column);
                    try {
                        textField.setText(model.getValueAt(selectedRow, column).toString());
                    } catch (Exception exp) {
                        System.out.println(exp);
                    }
                }


                }
                    else {
                        JPanel jpanel = getComponentByName("jp" + 1);
                        JLabel label = getLabel("label" + 0);
                        label.setText(model.getColumnName(0));
                        JTextField textField = getTextField("tf" + 1);
                        textField.setText(model.getValueAt(selectedRow, 0).toString());
                        jpanel.setVisible(true);
                        for (int column = 2; column <= columnCount; column++) {
                            label = getLabel("label" + column);
                            label.setText(model.getColumnName(0));

                            jpanel = getComponentByName("jp" + column);
                            jpanel.setVisible(true);
                            textField = getTextField("tf" + column);
                            try {
                                textField.setText(model.getValueAt(selectedRow, column-1).toString());
                            } catch (Exception exp) {
                                System.out.println(exp);
                            }
                        }
                    }

                saveId = model.getValueAt(selectedRow, 0).toString();
            }

        });
        jSposob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableName = "Способ_доставки";
                findAll(tableName);
            }
        });
        manager.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableName = "Менеджеры";
                findAll(tableName);
            }
        });
        obemItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableName = "Объем_продукции";
                findAll(tableName);
            }
        });
        skladItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableName = "Склад_доставки";
                findAll(tableName);
            }
        });
        contactItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableName = "Контактное_лицо";
                findAll(tableName);
            }
        });
        infotItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableName = "Информация_о_товаре";
                findAll(tableName);
            }
        });
        sostavSkladaItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableName = "Состав_склада";
                findAll(tableName);
            }
        });
        sostavZakaza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableName = "Состав_заказа";
                findAll(tableName);
            }
        });
        postavshikItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableName = "Поставщики";
                findAll(tableName);
            }
        });
        logoutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                swingForm.setVisible(true); // показать форму Swing
                setVisible(false);
            }
        });
        userOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableName = "Пользователь";
                findAll(tableName);
            }
        });
        jClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableName = "Клиент";
                findAll(tableName);
            }
        });
        menuZakaz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableName = "Заказ";
                findAll(tableName);
            }
        });
        updateBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
            }
        });
        deleteBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete();
            }
        });



    }
    private void addLabelToPanel(JPanel panel) {
        JLabel label = new JLabel("Hello");
        panel.add(label);
    }
    public void update() {
        final String DB_URL = "jdbc:postgresql://localhost:5432/3";
        final String USERNAME = "postgres";
        final String PASSWORD = "1234";
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            if (!saveId.equals("-1")) {
                String sql = "UPDATE "+tableName+" SET ";
                for (int i= 0; i< getColumnNames(tableName).length;i++){
                    if ((i+1) == getColumnNames(tableName).length){
                        sql += getColumnNames(tableName)[i]+"=? ";
                    }
                    else {
                        sql += getColumnNames(tableName)[i] + "=?, ";
                    }
                }
                sql += "WHERE ";
                sql += getIdColumnName(tableName);
                sql += " = ";
                sql += saveId;
                System.out.println(sql);

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                for (int i= 1; i<= getColumnNames(tableName).length;i++) {
                    try {
                        if(tableName.equals("Способ_доставки") && ((i) == 2 || (i) == 3)){
                            if (getTextFieldValue("tf" + (i)).isEmpty()){
                                preparedStatement.setTime(i,null);
                            }
                            else {
                                preparedStatement.setTime(i, java.sql.Time.valueOf(getTextFieldValue("tf" + (i ))));
                            }
                        }
                        else if(tableName.equals("Информация_о_товаре") && ((i) == 7 )){
                            preparedStatement.setDouble(i ,Double.parseDouble(getTextFieldValue("tf" + (i ))));
                        }
                        else {
                            preparedStatement.setInt(i , Integer.parseInt(getTextFieldValue("tf" + (i ))));
                        }
                    }
                    catch (Exception e){
                        preparedStatement.setString(i,getTextFieldValue("tf"+(i)));
                    }
                }

                int k = preparedStatement.executeUpdate();
                if (k == 1) {
                    JOptionPane.showMessageDialog(updateBTN, "Успешно изменено");
                    DefaultTableModel model = (DefaultTableModel) table1.getModel();
                    model.setRowCount(0);
                    tableName = tableName;
                    findAll(tableName);
                } else {
                    JOptionPane.showMessageDialog(updateBTN, "Произошла ошибка при добавлении");
                }
            } else {
                JOptionPane.showMessageDialog(updateBTN, "Выберите строку для обновления");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(updateBTN, "Ошибка базы данных: " + e.getMessage());
        }
    }
    public void delete(){
        final String DB_URL = "jdbc:postgresql://localhost:5432/3";
        final String USERNAME = "postgres";
        final String PASSWORD = "1234";
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            if (!saveId.equals("-1")) {
                String query = "DELETE FROM " + tableName+ " WHERE " + getIdColumnName(tableName) + "=?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, Integer.parseInt(saveId));
                System.out.println(query);
                int k = preparedStatement.executeUpdate();
                if (k == 1) {
                    JOptionPane.showMessageDialog(deleteBTN, "Успешно удалено");
                    DefaultTableModel model = (DefaultTableModel) table1.getModel();
                    model.setRowCount(0);
                    findAll(tableName);
                } else {
                    JOptionPane.showMessageDialog(deleteBTN, "Произошла ошибка при удалении");
                }
            } else {
                JOptionPane.showMessageDialog(deleteBTN, "Выберите строку для удаления");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(deleteBTN, "Ошибка базы данных: " + e.getMessage());
        }
    }
    private String[] getColumnNames(String tableName) {
        switch (tableName) {
            case "Пользователь":
                return new String[]{"Логин", "Пароль", "Название_роли"};
            case "Объем_продукции":
                return new String[]{"Вес", "Объем"};
            case "Заказ":
                return new String[]{"\"Код клиента\"", "\"Код способа доставки\"", "Статус_оплаты"};
            case "Информация_о_товаре":
                return new String[]{"Полное_наименование", "Группа_товара","Код_поставщика","Код_объема_продукции",
                "Типоразмер","Модель","Цена_шины_с_НДС"};
            case "Клиент":
                return new String[]{"Адрес", "Наименование","ИНН","\"Основная организация\"",
                        "КПП","Регион","Юр. / физ. лицо", "\"Код менеджера\"", "\"Код контактного лица\"", "\"Код пользователя\""};
            case "Контактное_лицо":
                return new String[]{"Фамилия", "Имя","Отчество","email",
                        "Телефон"};
            case "Менеджеры":
                return new String[]{"Фамилия", "Имя","Отчество","Тип_менеджера"};
            case "Поставщики":
                return new String[]{"Наименование", "ИНН","Код_менеджера","Основная_организация",
                        "КПП","Юр_физ_лицо","Адрес"};
            case "Склад_доставки":
                return new String[]{"Название_склада", "Код_состава_склада","Код_информации_о_товаре"};
            case "Состав_заказа":
                return new String[]{"Код_информации_о_товаре", "Код_заказа","Количество"};
            case "Состав_склада":
                return new String[]{"Приход","Расход"};
            case "Способ_доставки":
                return new String[]{"Название_способа","Удобное_время_получения_начало","Удобное_время_получения_конец","Адрес_доставки"};
            default:
                return new String[0];
        }
    }
    public void insertAll(String login, String password, String name_role) {
        final String DB_URL = "jdbc:postgresql://localhost:5432/3";
        final String USERNAME = "postgres";
        final String PASSWORD = "1234";
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)){
             Statement statement = connection.createStatement();
             String sql = "INSERT INTO "+tableName+"(";
             for (int i= 0; i< getColumnNames(tableName).length;i++){
                 if ((i+1) == getColumnNames(tableName).length){
                     sql += getColumnNames(tableName)[i]+")";
                 }
                 else {
                     sql += getColumnNames(tableName)[i] + ",";
                 }
             }
             sql += " VALUES (";
            for (int i= 0; i< getColumnNames(tableName).length;i++){
                if ((i+1) == getColumnNames(tableName).length){
                    sql += "?"+")";
                }
                else {
                    sql += "?" + ",";
                }
            }

             PreparedStatement preparedStatement = connection.prepareStatement(sql);
            if(tableName.equals("Пользователь")) {
                preparedStatement.setString(1, login);
                preparedStatement.setString(2, passwordEncoder.encode(password));
                preparedStatement.setString(3, name_role);
            }
            else{
                for (int i= 0; i< getColumnNames(tableName).length;i++) {
                    try {
                        if(tableName.equals("Способ_доставки") && ((i + 1) == 2 || (i + 1) == 3)){
                            if (getTextFieldValue("tf" + (i + 1)).isEmpty()){
                                preparedStatement.setTime(i + 1,null);
                            }
                            else {
                                preparedStatement.setTime(i + 1, java.sql.Time.valueOf(getTextFieldValue("tf" + (i + 1))));
                            }
                        }
                        else if(tableName.equals("Информация_о_товаре") && ((i + 1) == 7 )){
                            preparedStatement.setDouble(i + 1,Double.parseDouble(getTextFieldValue("tf" + (i + 1))));
                        }
                        else {
                            preparedStatement.setInt(i + 1, Integer.parseInt(getTextFieldValue("tf" + (i + 1))));
                        }
                    }
                    catch (Exception e){
                        preparedStatement.setString(i+1,getTextFieldValue("tf"+(i+1)));
                    }

                }

            }
            int k = preparedStatement.executeUpdate();
            if(k == 1) {
                JOptionPane.showMessageDialog(addBTN, "Успешно");
                DefaultTableModel model = (DefaultTableModel) table1.getModel();
                model.setRowCount(0);
                findAll(tableName);
            }
            else {
                JOptionPane.showMessageDialog(addBTN, "Произошла ошибка при добавлении");
                tf1.setText("");
                tf2.setText("");
                tf3.setText("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void findAll(String tableName) {
// Assuming User is your custom class
        final String DB_URL = "jdbc:postgresql://localhost:5432/3";
        final String USERNAME = "postgres";
        final String PASSWORD = "1234";

        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            String sql = "SELECT * FROM " + tableName;
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                String[] columnNames = new String[columnCount];

                for (int i = 1; i <= columnCount; i++) {
                    columnNames[i - 1] = metaData.getColumnName(i);
                }

                DefaultTableModel model = (DefaultTableModel) table1.getModel();
                model.setRowCount(0);
                model.setColumnIdentifiers(columnNames);
                while (resultSet.next()) {
                    Object[] row = new Object[columnCount];
                    for (int i = 1; i <= columnCount; i++) {
                        row[i - 1] = resultSet.getObject(i);
                    }
                    model.addRow(row);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


}

