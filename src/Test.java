import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Test {

    public static void main(String[] args) throws Exception {
        WindowApp windowApp = new WindowApp();
        windowApp.setVisible(true);

        windowApp.start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = windowApp.fieldForDirPath.getText();
                File path = new File(fileName);

                String formatFile = windowApp.fieldForFormatFiles.getText();
                String searchString = windowApp.fieldForSearchString.getText();

                if (path.isDirectory() && formatFile.matches("\\.[a-zA-z]{1,}")) {
                    DefaultMutableTreeNode root = new DefaultMutableTreeNode(fileName);
                    searchForDatFiles(path, root, formatFile);
                    new MyJTree(root, searchString, formatFile);
                } else
                    JOptionPane.showMessageDialog(null, "Ошибка при вводе данных", "Message", JOptionPane.PLAIN_MESSAGE);
            }

        });
    }

    public static void searchForDatFiles(File root, DefaultMutableTreeNode dir, String formatFile) {
        if(root == null ) return;
        if(root.isDirectory()) {
            DefaultMutableTreeNode dirNew = new DefaultMutableTreeNode(root.getPath());
            dir.add(dirNew);
            for(File file : root.listFiles()) {
                searchForDatFiles(file, dirNew, formatFile);
            }
        } else if(root.isFile() && root.getName().endsWith(formatFile)) {
            dir.add(new DefaultMutableTreeNode(root.getPath()));
        }
    }

}

