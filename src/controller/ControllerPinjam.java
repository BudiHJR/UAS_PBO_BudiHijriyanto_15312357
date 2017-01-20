/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.ModelPinjam;
import model.ModelTeman;
import util.Koneksi;

/**
 *
 * @author ASUS
 */
public class ControllerPinjam {
    Koneksi koneksi = new Koneksi();
    
    public void simpanDataPinjam(ModelPinjam mt){
        try {
            koneksi.koneksiDatabase();
            String querySimpan = "insert into tbl_pinjam (namaTeman,BarangDipinjam) values ('"+mt.getNamaTeman()+"','"+mt.getBarangDipinjam()+"')";
            koneksi.state.executeUpdate(querySimpan);
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
            System.err.println("Simpan Gagal : "+e);
        }
    }
    
    public void hapusDataPinjam(ModelPinjam mt){
        try {
            koneksi.koneksiDatabase();
            String queryHapus = "delete from tbl_pinjam where id=('"+mt.getId()+"')";
            koneksi.state.executeUpdate(queryHapus);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
            System.err.println("Gagal Hapus :"+e);
        }
    }
    
    public void ubahDataPinjam(ModelPinjam mt){
        try {
            koneksi.koneksiDatabase();
             int id = mt.getId();
            String nama = mt.getNamaTeman();
            String barang = mt.getBarangDipinjam();
            String queryUbahDataPinjam = "update tbl_pinjam "
                    + "set barangDipinjam=('"+ barang +"') where id=('" + id + "')";
            koneksi.state.executeUpdate(queryUbahDataPinjam);
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
            System.err.println("Gagal Ubah : "+e);
        }
    }
    
}
