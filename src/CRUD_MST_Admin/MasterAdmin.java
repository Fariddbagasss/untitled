package CRUD_MST_Admin;

import CRUD_MST_Materi.ConnectMateri;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MasterAdmin extends JFrame {
    private JTextField textID_Admin;
    private JTextField textNama;
    private JTextField textAlamat;
    private JTextField textNoTlp;
    private JTextField textUsername;
    private JTextField textPasword;
    private JButton hapusButton;
    private JButton ubahButton;
    private JButton tambahButton;
    private JTable tableMSTAdmin;
    private JButton kembaliButton;
    private JScrollPane JScrolPane_Admin;
    private JPanel Jpanel_Admin;
    private JTextField textStatus;
    private JButton Bersih;
    ConnectMateri connectMateri = new ConnectMateri();
    String id_adm, nama_adm, alamat_adm, no_adm, username, password;
    Integer status_adm;
    private  DefaultTableModel model;

    public MasterAdmin() {
        model = new DefaultTableModel();
        this.setSize(1000,600);
        this.setContentPane(Jpanel_Admin);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Jpanel_Admin");
        tableMSTAdmin.setModel(model);
        setLocationRelativeTo(null);
        addColumn();
        loaddata();

        tambahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                id_adm = textID_Admin.getText();
                nama_adm = textNama.getText();
                alamat_adm = textAlamat.getText();
                no_adm = textNoTlp.getText();
                username = textUsername.getText();
                password = textPasword.getText();
                status_adm = Integer.parseInt(textStatus.getText());

                try {
                    String query = "INSERT INTO tblAdmin VALUES (?,?,?,?,?,?,?)";
                    connectMateri.pstat = connectMateri.conn.prepareStatement(query);
                    connectMateri.pstat.setString(1, id_adm);
                    connectMateri.pstat.setString(2, nama_adm);
                    connectMateri.pstat.setString(3, alamat_adm);
                    connectMateri.pstat.setString(4, no_adm);
                    connectMateri.pstat.setString(5, username);
                    connectMateri.pstat.setString(6, password);
                    connectMateri.pstat.setInt(7, status_adm);
                    JOptionPane.showMessageDialog(null, "Berhasil Boss !!!");

                    connectMateri.pstat.executeUpdate();
                    connectMateri.pstat.close();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Gagal"+ex.getMessage());
                }
            }
        });
        ubahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tableMSTAdmin.getSelectedRow();
                if (selectedRow != -1) {
                    id_adm = textID_Admin.getText();
                    nama_adm = textNama.getText();
                    alamat_adm = textAlamat.getText();
                    no_adm = textNoTlp.getText();
                    username = textUsername.getText();
                    password = textPasword.getText();
                    status_adm = Integer.parseInt(textStatus.getText());

                    try {
                        String query = "UPDATE tblAdmin SET nama_adm=?, alamat_adm=?, no_adm=?, username=?, password=?, status_adm=? WHERE id_adm=?";
                        connectMateri.pstat = connectMateri.conn.prepareStatement(query);
                        connectMateri.pstat.setString(1, nama_adm);
                        connectMateri.pstat.setString(2, alamat_adm);
                        connectMateri.pstat.setString(3, no_adm);
                        connectMateri.pstat.setString(4, username);
                        connectMateri.pstat.setString(5, password);
                        connectMateri.pstat.setInt(6, status_adm);
                        connectMateri.pstat.setString(7, id_adm);

                        int rowsAffected = connectMateri.pstat.executeUpdate();

                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Data berhasil diperbarui!");
                            loaddata(); // Memuat ulang data setelah pembaruan
                        } else {
                            JOptionPane.showMessageDialog(null, "Gagal memperbarui data!");
                        }

                        connectMateri.pstat.close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Gagal: " + ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih baris data yang ingin diperbarui!");
                }
            }
        });
        Bersih.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textID_Admin.setText(""); // Membersihkan isi JTextField
                textNama.setText("");
                textAlamat.setText("");
                textNoTlp.setText("");
                textUsername.setText("");
                textPasword.setText("");
                textStatus.setText("");
            }
        });

        hapusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tableMSTAdmin.getSelectedRow();
                if (selectedRow != -1) {
                    String id_adm = tableMSTAdmin.getValueAt(selectedRow, 0).toString();

                    int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

                    if (confirm == JOptionPane.YES_OPTION) {
                        try {
                            String query = "DELETE FROM tblAdmin WHERE id_adm=?";
                            connectMateri.pstat = connectMateri.conn.prepareStatement(query);
                            connectMateri.pstat.setString(1, id_adm);

                            int rowsAffected = connectMateri.pstat.executeUpdate();

                            if (rowsAffected > 0) {
                                JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
                                loaddata(); // Memuat ulang data setelah penghapusan
                            } else {
                                JOptionPane.showMessageDialog(null, "Gagal menghapus data!");
                            }

                            connectMateri.pstat.close();
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Gagal: " + ex.getMessage());
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih baris data yang ingin dihapus!");
                }
            }
        });
    }
    public void addColumn() {
        model.addColumn("ID_Admin");
        model.addColumn("Nama");
        model.addColumn("Alamat");
        model.addColumn("No_Telephone");
        model.addColumn("Username"); // Tambahkan kolom username
        model.addColumn("Password"); // Tambahkan kolom password
        model.addColumn("Status_adm");
    }
    public void loaddata() {
        if (model != null) {
            model.getDataVector().removeAllElements();
            model.fireTableStructureChanged();
        } else {
            model = new DefaultTableModel();
            addColumn(); // Tambahkan kolom jika model belum diinisialisasi sebelumnya
        }

        try {
            ConnectMateri connectMateri = new ConnectMateri();
            connectMateri.stat = connectMateri.conn.createStatement();
            String query = "SELECT * FROM tblAdmin";
            connectMateri.result = connectMateri.stat.executeQuery(query);
            while (connectMateri.result.next()) {
                Object[] obj = new Object[7]; // Ubah ukuran obj menjadi 7
                obj[0] = connectMateri.result.getString("id_adm");
                obj[1] = connectMateri.result.getString("nama_adm");
                obj[2] = connectMateri.result.getString("alamat_adm");
                obj[3] = connectMateri.result.getString("no_adm");
                obj[4] = connectMateri.result.getString("username"); // Tambahkan username
                obj[5] = connectMateri.result.getString("password"); // Tambahkan password
                obj[6] = connectMateri.result.getString("status_adm");
                model.addRow(obj);
            }
            connectMateri.stat.close();
            connectMateri.result.close();
        } catch (SQLException e) {
            System.out.println("Terjadi error saat load data transaksi: " + e);
        }
    }
    public static void main(String[] args) {
        JFrame form = new MasterAdmin();
        form.setVisible(true);
    }
}

