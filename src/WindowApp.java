import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class WindowApp extends JFrame {
    JTextField fieldForDirPath;
    JTextField fieldForSearchString;
    JTextField fieldForFormatFiles;

    JButton start;
    JButton cancel;

    public WindowApp(){
        super("Поиск в директории");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Box box1 = Box.createHorizontalBox();
        JLabel dirPathLabel = new JLabel("Директория:");
        dirPathLabel.setForeground(Color.LIGHT_GRAY);
        fieldForDirPath = new JTextField(15);
        box1.add(dirPathLabel);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(fieldForDirPath);

        Box box2 = Box.createHorizontalBox();
        JLabel searchStringLabel = new JLabel("Строка для поиска:");
        searchStringLabel.setForeground(Color.LIGHT_GRAY);
        fieldForSearchString = new JTextField(15);
        box2.add(searchStringLabel);
        box2.add(Box.createHorizontalStrut(6));
        box2.add(fieldForSearchString);

        Box boxForFormatFile = Box.createHorizontalBox();
        JLabel formatFileLabel = new JLabel("Формат файлов:");
        formatFileLabel.setForeground(Color.LIGHT_GRAY);
        fieldForFormatFiles = new JTextField(7);
        boxForFormatFile.add(formatFileLabel);
        boxForFormatFile.add(Box.createHorizontalStrut(6));
        boxForFormatFile.add(fieldForFormatFiles);

        Box box3 = Box.createHorizontalBox();
        start = new JButton("Старт");
        cancel = new JButton("Отмена");
        box3.add(Box.createHorizontalGlue());
        box3.add(start);
        box3.add(Box.createHorizontalStrut(12));
        box3.add(cancel);
        box3.add(Box.createHorizontalStrut(12));
        box3.add(boxForFormatFile);
        box3.add(Box.createHorizontalStrut(12));

        dirPathLabel.setPreferredSize(searchStringLabel.getPreferredSize());
        formatFileLabel.setPreferredSize(dirPathLabel.getPreferredSize());

        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12,12,12,12));
        mainBox.add(box1);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box2);
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(boxForFormatFile);
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(box3);
        setContentPane(mainBox);

        setBounds(750, 200, 600, 200);

        setResizable(false);
        setBackground(Color.DARK_GRAY);

        fieldForDirPath.setText("C:/");
        fieldForSearchString.setText("example");
        fieldForFormatFiles.setText(".log");

        start.setBackground(Color.LIGHT_GRAY);
        cancel.setBackground(Color.LIGHT_GRAY);
    }
}
