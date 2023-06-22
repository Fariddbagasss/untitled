package CRUD_MST_Siswa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MuridAstra extends  JFrame
{
    private JPanel MuridAstra;
    private JTextField textID_Murid;
    private JTextField textNama;
    private JTextField textAlamat;
    private JTextField textJenjang;
    private JScrollPane viewMuridAstra;
    private JTable tbViewMurid;
    private JTextField textKelas;
    private JTextField textNomorHP;
    private JTextField textUsername;
    private JTextField textPassword;
    private JButton KeluarButton;
    private JTextField textField1;
    private JButton buttonbersih;
    private JButton buttontambah;
    private JButton buttonubah;
    private JButton buttonhapus;
    private JPanel JpanelMurid;
    String id_md, nama_md, alamat_md, jenjang, kelas, no_md, username, password;
    Integer status_mtr;
    private DefaultTableModel model;
    public MuridAstra()
    {
        model = new DefaultTableModel();
        this.setSize(1000,600);
        this.setContentPane(JpanelMurid);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JpaneMurid");
        tbViewMurid.setModel(model);
        setLocationRelativeTo(null);

    }
}
