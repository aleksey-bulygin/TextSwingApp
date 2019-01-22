import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;

public class MyJTree extends JFrame {
     private  JTree tree;
     private String searchString;
     private String formatFile;

     public MyJTree(DefaultMutableTreeNode root, String searchString, String formatFile) {
         this.searchString = searchString;
         this.formatFile = formatFile;

         tree = new JTree(root);
         add(new JScrollPane(tree));

         tree.setShowsRootHandles(true);

         setTitle("Найденные файлы:");
         setLocation(0, 0);
         setSize(400, 725);
         setVisible(true);

         tree.setBackground(Color.lightGray);

         tree.addTreeSelectionListener(new TreeSelectionListener() {
             @Override
             public void valueChanged(TreeSelectionEvent e) {
                 JTree jTree = (JTree) e.getSource();
                 TreePath[] treePaths = e.getPaths();

                 TreePath[] selected =  jTree.getSelectionPaths();
                 int[] rows = jTree.getSelectionRows();

                 for (int i = 0; i < selected.length; i++) {
                     if (selected[i].getLastPathComponent().toString().contains(formatFile))
                         new SearchInFile(selected[i].getLastPathComponent().toString(), searchString);
                 }

             }
         });
     }
}

