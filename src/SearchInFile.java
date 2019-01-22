import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Pattern;

public class SearchInFile extends Thread{
    private String fileName;
    private String researchString;

    public SearchInFile(String fileName, String researchString) {
        this.fileName = fileName;
        this.researchString = researchString;
        start();
    }

    @Override
    public void run() {
        StringBuffer stringBuffer = new StringBuffer("");

        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            byte[] data = new byte[fileInputStream.available()];
            fileInputStream.read(data);
            for (byte b : data)
                stringBuffer.append( (char) b);

        } catch (IOException e) {

        }

        if (!stringBuffer.equals("") && stringBuffer.toString().indexOf(researchString) != -1) {
            String text = Pattern.compile(researchString).matcher(stringBuffer.toString()).replaceAll(researchString.toUpperCase());
            JFrame jFrame = new JFrame();
            JTextArea jTextArea = new JTextArea();

            jTextArea.setText(text);
            jTextArea.setBackground(Color.DARK_GRAY);
            jTextArea.setForeground(Color.white);

            jFrame.setBounds(200, 0, 500, 725);

            jTextArea.setVisible(true);
            jTextArea.setAutoscrolls(true);

            jFrame.setTitle("Text from " + fileName);
            jFrame.add(jTextArea);
            jFrame.setVisible(true);
        }
        else
            JOptionPane.showMessageDialog(null, "This file is not contains string " + researchString, "Message", JOptionPane.PLAIN_MESSAGE);
    }
}
