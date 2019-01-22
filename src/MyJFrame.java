import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyJFrame extends JFrame {

    private static MyJFrame jFrame;

    private MyJFrame() {

    }

    public static MyJFrame getMyJFrame() {
        if (jFrame == null) {
            jFrame = new MyJFrame();
            jFrame.setVisible(true);
            jFrame.setBounds(250, 100, 900, 600);
            jFrame.setTitle("Программа поиска строк в файлах");
            jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);

            JPanel jPanel = new JPanel(new GridLayout(1, 2, 5, 0));
            jPanel.setSize(200, 100);
            jPanel.setVisible(true);

            JButton jButtonStart = new JButton("Start");
            jButtonStart.setBackground(Color.LIGHT_GRAY);
            jButtonStart.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jButtonStart.setBackground(Color.BLUE);
                }
            });

            JButton jButtonCancel = new JButton("Cancel");
            jButtonCancel.setBackground(Color.LIGHT_GRAY);
            jPanel.add(jButtonStart);
            jPanel.add(jButtonCancel);

            JPanel flow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            flow.add(jPanel);

            Container container = jFrame.getContentPane();
            container.add(flow, BorderLayout.SOUTH);
            container.setVisible(true);
            container.setBackground(Color.DARK_GRAY);


            JTextField jTextFieldForDirPath = new JTextField(15);
            jTextFieldForDirPath.setBackground(Color.BLUE);
            jTextFieldForDirPath.setText("text");
            JTextField jTextFieldForFormatFile = new JTextField(15);
            JTextField jTextFieldForSearchString = new JTextField(15);
           JPanel jPanelforTextFields = new JPanel(new FlowLayout(FlowLayout.LEFT));

        //    jPanelforTextFields.setSize(600, 300);
        //    jPanelforTextFields.setVisible(true);

           jPanelforTextFields.add(jTextFieldForDirPath);

           jPanelforTextFields.add(jTextFieldForFormatFile);
           jPanelforTextFields.add(jTextFieldForSearchString);
           jPanel.setSize(400, 130);
           jPanel.setVisible(true);
            jFrame.setContentPane(jPanelforTextFields);
         //   jFrame.pack();
        //    JPanel flowJPanelTextFields = new JPanel(new FlowLayout(FlowLayout.LEFT));
        //    flowJPanelTextFields.add(jPanelforTextFields);

          //  Container containerForTextFields = jFrame.getContentPane();
        //    container.add(flowJPanelTextFields, BorderLayout.CENTER);
        //    container.setVisible(true);
        //    container.setBackground(Color.LIGHT_GRAY);

         //   jFrame.add(jTextFieldForDirPath);
          //  jFrame.add(jTextFieldForFormatFile);
           // jFrame.add(jTextFieldForSearchString);
        }

        return jFrame;
    }

}
