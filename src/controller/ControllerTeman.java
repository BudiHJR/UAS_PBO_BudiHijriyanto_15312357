/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.ModelTeman;
import util.Koneksi;

/**
 *
 * @author ASUS
 */
public class ControllerTeman {
    Koneksi koneksi = new Koneksi();
    
    public void simpanDataTeman(ModelTeman mt){
        try {
            koneksi.koneksiDatabase();
            String querySimpan = "insert into tbl_teman (nama,nope,email) values ('"+mt.getNama()+"','"+mt.getNope()+"','"+mt.getEmail()+"')";
            koneksi.state.executeUpdate(querySimpan);
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
            System.err.println("Simpan Gagal : "+e);
        }
    }
    
    public void hapusDataTeman(ModelTeman mt){
        try {
            koneksi.koneksiDatabase();
            String queryHapus = "delete from tbl_teman where id=('"+mt.getId()+"')";
            koneksi.state.executeUpdate(queryHapus);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
            System.err.println("Gagal Hapus :"+e);
        }
    }
    
    public void ubahDataTeman(ModelTeman mt){
        try {
            koneksi.koneksiDatabase();
             int id = mt.getId();
            String nama = mt.getNama();
            String nope = mt.getNope();
            String email = mt.getEmail();

            String queryUbah = "update tbl_teman "
                    + "set nama=('" + nama + "'),"
                    + "nope=('"+ nope +"'),"
                    + "email=('"+ email +"')"
                    + "where id=('" + id + "')";
            koneksi.state.executeUpdate(queryUbah);
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
            System.err.println("Gagal Ubah : "+e);
        }
    }
    
}
