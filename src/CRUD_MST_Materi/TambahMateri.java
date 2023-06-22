package CRUD_MST_Materi;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TambahMateri  extends JFrame{
    private JTextField textID;
    private JTextField textNama;
    private JTextField textFile;
    private JTextField textStatus;
    private JButton hapusBtn;
    private JButton ubahBtn;
    private JButton lihatBtn;
    private JButton tambahButton;
    private JButton kembaliBtn;
    private JButton tutupBtn;
    private JPanel Materi;
    private JScrollPane view;
    private JTable tbViewMateri;


    String IdMTR, NamaMTR, FileMTR, StatusMTR;



    public TambahMateri()
    {
        this.setSize(450, 300);
        this.setContentPane(Materi);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("TambahMateri");
        setLocationRelativeTo(null);
        tambahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IdMTR=textID.getText();
                NamaMTR=textNama.getText();
                FileMTR=textFile.getText();
                StatusMTR=textStatus.getText();

//                try {
//                    String query = "";
//
//                }
//                catch (SQLException ex)
//                {
//                    JOptionPane.showMessageDialog(null,"isert data materi berhasil");
//                }
            }
        });
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
