/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableColumn;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Isal
 */
public class Home extends javax.swing.JFrame {
    
     //deklarasi
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    PreparedStatement pst;
    private DefaultTableModel angmode;
    private DefaultTableModel simmode;
    private DefaultTableModel pinmode;
    private DefaultTableModel angsmode;
    public static int statusSearch = 0;
    public static int simstatusSearch = 0;
    
       protected void angbersih(){
        angid.setText("");
        angnama.setText("");
        angjenkel.setSelectedIndex(0);
        angkota.setText("");
        angtgl.setDate(null);
        angtelp.setText("");
        angsp.setSelectedIndex(0);
        angtglmsk.setDate(null);
        angalamat.setText("");
        angid.requestFocus();
    }
    protected void angdata() {
        Object[] Baris = {"ID","Nama","JK","Kota","Tgl Lahir","Telp","Pegawai","Tgl Masuk","Alamat"};
        angmode = new DefaultTableModel(null,Baris);
        angtabel.setModel(angmode);
        //String as = "yyyy-MM-dd";
        //DateFormat df =  new SimpleDateFormat("yyyy-MM-dd");
        //Date d1 = df.parse(tgl);
        
            try {
                sql = "SELECT * FROM dataanggota";//dataanggota.noanggota,dataanggota.namaanggota,dataanggota.tempat,dataanggota.ttl,dataanggota.jenkel,dataanggota.notelp,dataanggota.status,dataanggota.tglmsk,dataanggota.alamat";
                rs = stat.executeQuery(sql);
            while (rs.next()){
            String a = rs.getString("noanggota");
            String b = rs.getString("namaanggota");
            String c = rs.getString("jenkel");
            String d = rs.getString("tempat");
            java.sql.Date lahir = rs.getDate("ttl");
            String e = lahir.toString();// ini Udah Bener, Nah yang bawahnya Tulisnya Gimana?
            String f = rs.getString("notelp");
            String g = rs.getString("status");
            java.sql.Date masuk = rs.getDate("tglmsk");
            String h = masuk.toString();
            String i = rs.getString("alamat");
          
            String[] data = {a,b,c,d,e,f,g,h,i};  // Bagian Enya di tulis apa Pak ?
            angmode.addRow(data);
            }
            }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Database Error");
        }
    }
    
    public void angkolom(){ 
        TableColumn column;
        angtabel.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF); 
        column = angtabel.getColumnModel().getColumn(0); // ID
        column.setPreferredWidth(40);
        column = angtabel.getColumnModel().getColumn(1); // Nama
        column.setPreferredWidth(100); 
        column = angtabel.getColumnModel().getColumn(2); // JK
        column.setPreferredWidth(60); 
        column = angtabel.getColumnModel().getColumn(3); // Kota
        column.setPreferredWidth(70);
        column = angtabel.getColumnModel().getColumn(4); // TTL
        column.setPreferredWidth(80);
        column = angtabel.getColumnModel().getColumn(5); // Telp
        column.setPreferredWidth(100); 
        column = angtabel.getColumnModel().getColumn(6); // Pegawai
        column.setPreferredWidth(60); 
        column = angtabel.getColumnModel().getColumn(7); // Tgl
        column.setPreferredWidth(80);
        column = angtabel.getColumnModel().getColumn(8); // Alamat
        column.setPreferredWidth(200);
    }
    
    protected void simbersih(){
        simid.setText("");
        simkode.setText("");
        simnama.setText("");
        simtgl.setDate(null);
        simpokok.setText("");
        simwajib.setText("");
        simsukarela.setText("");
        simtotal.setText("");
        simid.requestFocus();
    }
    protected void simdata() {
        Object[] Baris = {"ID","Kode","Nama","Tgl Simpan","Pokok","Wajib","Sukarela","Total"};
        simmode = new DefaultTableModel(null,Baris);
        simtabel.setModel(simmode);
        //String as = "yyyy-MM-dd";
        //DateFormat df =  new SimpleDateFormat("yyyy-MM-dd");
        //Date d1 = df.parse(tgl);
        
            try {
                sql = "SELECT * FROM datasimpan";//dataanggota.noanggota,dataanggota.namaanggota,dataanggota.tempat,dataanggota.ttl,dataanggota.jenkel,dataanggota.notelp,dataanggota.status,dataanggota.tglmsk,dataanggota.alamat";
                rs = stat.executeQuery(sql);
            while (rs.next()){
            String a = rs.getString("id");
            String b = rs.getString("kode");
            String c = rs.getString("nama");
            java.sql.Date lahir = rs.getDate("tgl");
            String d = lahir.toString();
            String e = rs.getString("pokok");
            String f = rs.getString("wajib");
            String g = rs.getString("sukarela");
            String h = rs.getString("total");
          
            String[] data = {a,b,c,d,e,f,g,h};  // Bagian Enya di tulis apa Pak ?
            simmode.addRow(data);
            }
            }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Database Error");
        }
    }   
    
    public void simtotal(){
        int hasil;
        hasil = Integer.parseInt(simpokok.getText())+(Integer.parseInt(simwajib.getText()))+(Integer.parseInt(simsukarela.getText()));
            simtotal.setText(""+hasil);
    }
    
    public void simkolom(){ 
        TableColumn column;
        angtabel.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF); 
        column = simtabel.getColumnModel().getColumn(0); // ID
        column.setPreferredWidth(40);
        column = simtabel.getColumnModel().getColumn(1); // Kode
        column.setPreferredWidth(50); 
        column = simtabel.getColumnModel().getColumn(2); // Nama
        column.setPreferredWidth(100); 
        column = simtabel.getColumnModel().getColumn(3); // Tgl
        column.setPreferredWidth(80);
        column = simtabel.getColumnModel().getColumn(4); // Pokok
        column.setPreferredWidth(80);
        column = simtabel.getColumnModel().getColumn(5); // Wajib
        column.setPreferredWidth(80); 
        column = simtabel.getColumnModel().getColumn(6); // Sukarela
        column.setPreferredWidth(80); 
        column = simtabel.getColumnModel().getColumn(7); // Total
        column.setPreferredWidth(80);
    }
    
    protected void pinbersih(){
        pinid.setText("");
        pinkode.setText("");
        pinnama.setText("");
        pintgl.setDate(null);
        pinjumlah.setText("");
        pinbunga.setText("");
        pinlama.setText("");
        pinangsuran.setText("");
        pinid.requestFocus();
    }
    
    protected void pindata() {
        Object[] Baris = {"ID","Kode","Nama","Tanggal","Jumlah","Bunga","Durasi","Angsuran"};
        pinmode = new DefaultTableModel(null,Baris);
        pintabel.setModel(pinmode);
        //String as = "yyyy-MM-dd";
        //DateFormat df =  new SimpleDateFormat("yyyy-MM-dd");
        //Date d1 = df.parse(tgl);
        
            try {
                sql = "SELECT * FROM datapinjam";//dataanggota.noanggota,dataanggota.namaanggota,dataanggota.tempat,dataanggota.ttl,dataanggota.jenkel,dataanggota.notelp,dataanggota.status,dataanggota.tglmsk,dataanggota.alamat";
                rs = stat.executeQuery(sql);
            while (rs.next()){
            String a = rs.getString("id");
            String b = rs.getString("kode");
            String c = rs.getString("nama");
            java.sql.Date lahir = rs.getDate("tgl");
            String d = lahir.toString();
            String e = rs.getString("jumlah");
            String f = rs.getString("bunga");
            String g = rs.getString("lama");
            String h = rs.getString("angsuran");
          
            String[] data = {a,b,c,d,e,f,g,h};  // Bagian Enya di tulis apa Pak ?
            pinmode.addRow(data);
            }
            }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Database Error");
        }
    }
    
    public void pintotal(){
        int hasil, jumlah;
        Double bu;
        hasil = Integer.parseInt(pinjumlah.getText())/Integer.parseInt(pinlama.getText());
        bu = Integer.parseInt(pinjumlah.getText())*(Double.parseDouble(pinbunga.getText())/100)/Integer.parseInt(pinlama.getText());
        jumlah = (int) (hasil + bu);
        pinangsuran.setText(""+jumlah);
    }
    
    public void pinkolom(){ 
        TableColumn column;
        angtabel.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF); 
        column = pintabel.getColumnModel().getColumn(0); // ID
        column.setPreferredWidth(40);
        column = pintabel.getColumnModel().getColumn(1); // Kode
        column.setPreferredWidth(50); 
        column = pintabel.getColumnModel().getColumn(2); // Nama
        column.setPreferredWidth(100); 
        column = pintabel.getColumnModel().getColumn(3); // Tgl
        column.setPreferredWidth(80);
        column = pintabel.getColumnModel().getColumn(4); // Jumlah
        column.setPreferredWidth(80);
        column = pintabel.getColumnModel().getColumn(5); // Bunga
        column.setPreferredWidth(80); 
        column = pintabel.getColumnModel().getColumn(6); // Durasi
        column.setPreferredWidth(80); 
        column = pintabel.getColumnModel().getColumn(7); // Angsuran
        column.setPreferredWidth(80);
    }
        
    protected void angsbersih(){
        angsno.setText("");
        angskode.setText("");
        angsnama.setText("");
        angstgl.setDate(null);
        angsangsuran.setText("");
        angske.setText("");
        angsdari.setText("");
        angsbukti.setText("");
        angskode.requestFocus();
    }
    
    protected void angsdata() {
        Object[] Baris = {"No","Kode","Nama","Angsuran","Tanggal","Angsuran Ke","Dari","Bukti","Keterangan"};
        angsmode = new DefaultTableModel(null,Baris);
        angstabel.setModel(angsmode);
        //String as = "yyyy-MM-dd";
        //DateFormat df =  new SimpleDateFormat("yyyy-MM-dd");
        //Date d1 = df.parse(tgl);
        
            try {
                sql = "SELECT * FROM dataangsuran";//dataanggota.noanggota,dataanggota.namaanggota,dataanggota.tempat,dataanggota.ttl,dataanggota.jenkel,dataanggota.notelp,dataanggota.status,dataanggota.tglmsk,dataanggota.alamat";
                rs = stat.executeQuery(sql);
            while (rs.next()){
                
            String a = rs.getString("no");
            String b = rs.getString("kode");
            String c = rs.getString("nama");
            String d = rs.getString("angsuran");
            java.sql.Date lahir = rs.getDate("tgl");
            String e = lahir.toString();
            String f = rs.getString("angsuranke");
            String g = rs.getString("dari");
            String h = rs.getString("bukti");
            String i = rs.getString("keterangan");
          
            String[] data = {a,b,c,d,e,f,g,h,i};  // Bagian Enya di tulis apa Pak ?
            angsmode.addRow(data);
            }
            }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Database Error");
        }
    }
    public void angskolom(){ 
        TableColumn column;
        angtabel.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF); 
        column = angstabel.getColumnModel().getColumn(0); // ID
        column.setPreferredWidth(40);
        column = angstabel.getColumnModel().getColumn(1); // Kode
        column.setPreferredWidth(50); 
        column = angstabel.getColumnModel().getColumn(2); // Nama
        column.setPreferredWidth(100); 
        column = angstabel.getColumnModel().getColumn(3); // Angsuran 
        column.setPreferredWidth(80);
        column = angstabel.getColumnModel().getColumn(4); // Tgl
        column.setPreferredWidth(80);
        column = angstabel.getColumnModel().getColumn(5); // Ke
        column.setPreferredWidth(80); 
        column = angstabel.getColumnModel().getColumn(6); // Dari
        column.setPreferredWidth(80); 
        column = angstabel.getColumnModel().getColumn(7); // Total
        column.setPreferredWidth(80);
        column = angstabel.getColumnModel().getColumn(8); // Total
        column.setPreferredWidth(80);
    }
    
    void tanggal (){
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd - MM - yyyy");
        Datenow.setText(sdf.format(now));
    }

    /**
     * Creates new form Home
     */
    public Home() {
        //membuat koneksi
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        initComponents();
        // biar pas muncul ditengah
        this.setLocationRelativeTo(null);
        tanggal();
        new Thread(){
            public void run(){
                while(true){
            Calendar kal =  new GregorianCalendar();
            int jam = kal.get(Calendar.HOUR_OF_DAY);
            int menit = kal.get(Calendar.MINUTE);
            int detik = kal.get(Calendar.SECOND);
            String waktu =  jam+" : "+menit+" : "+detik;
            Timenow.setText(waktu);
            }
        }
    }.start();
        // panggil database untuk CRUD & Tabel
        angdata();
        angkolom();
        simdata();
        simkolom();
        pindata();
        pinkolom();
        angsdata();
        angskolom();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        bg = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        menu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        main = new javax.swing.JPanel();
        home = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        anggota = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        angtabel = new javax.swing.JTable();
        angcari = new javax.swing.JTextField();
        anghapus = new javax.swing.JButton();
        input = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        angid = new javax.swing.JTextField();
        angnama = new javax.swing.JTextField();
        angtelp = new javax.swing.JTextField();
        angjenkel = new javax.swing.JComboBox();
        angsp = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        angkota = new javax.swing.JTextField();
        angtgl = new com.toedter.calendar.JDateChooser();
        angtglmsk = new com.toedter.calendar.JDateChooser();
        jScrollPane5 = new javax.swing.JScrollPane();
        angalamat = new javax.swing.JTextArea();
        angbersih = new javax.swing.JButton();
        angedit = new javax.swing.JButton();
        angtambah = new javax.swing.JButton();
        simpanan = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        simtabel = new javax.swing.JTable();
        simcari = new javax.swing.JTextField();
        simhapus = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        simnama = new javax.swing.JLabel();
        simpokok = new javax.swing.JTextField();
        simsukarela = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        simkode = new javax.swing.JTextField();
        simtgl = new com.toedter.calendar.JDateChooser();
        simwajib = new javax.swing.JTextField();
        simtotal = new javax.swing.JTextField();
        simbersih = new javax.swing.JButton();
        simedit = new javax.swing.JButton();
        simtambah = new javax.swing.JButton();
        simid = new javax.swing.JTextField();
        pinjaman = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        pintabel = new javax.swing.JTable();
        pincari = new javax.swing.JTextField();
        pinhapus = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        pinid = new javax.swing.JTextField();
        pinnama = new javax.swing.JLabel();
        pinjumlah = new javax.swing.JTextField();
        pinlama = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        pinkode = new javax.swing.JLabel();
        pinbunga = new javax.swing.JTextField();
        pinangsuran = new javax.swing.JTextField();
        pinedit = new javax.swing.JButton();
        pinbersih = new javax.swing.JButton();
        pintgl = new com.toedter.calendar.JDateChooser();
        pintambah = new javax.swing.JButton();
        angsuran = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        angstabel = new javax.swing.JTable();
        angscari = new javax.swing.JTextField();
        angshapus = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        angskode = new javax.swing.JTextField();
        angske = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        angslunas = new javax.swing.JCheckBox();
        angsbelum = new javax.swing.JCheckBox();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        angsnama = new javax.swing.JLabel();
        angsbukti = new javax.swing.JTextField();
        angsbersih = new javax.swing.JButton();
        angsedit = new javax.swing.JButton();
        angstambah = new javax.swing.JButton();
        angsangsuran = new javax.swing.JLabel();
        angsno = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        angstgl = new com.toedter.calendar.JDateChooser();
        angsdari = new javax.swing.JTextField();
        laporan = new javax.swing.JPanel();
        lapsim = new javax.swing.JLabel();
        lappin = new javax.swing.JLabel();
        lapangs = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        about = new javax.swing.JPanel();
        logout = new javax.swing.JLabel();
        Datenow = new javax.swing.JLabel();
        Timenow = new javax.swing.JLabel();

        jLabel29.setText("Kode Pinjaman :");

        jLabel30.setText("Tgl Pinjam :");

        jLabel31.setText("Bunga (%) :");

        jLabel32.setText("Angsuran :");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(104, 186, 209));

        jPanel1.setBackground(new java.awt.Color(104, 186, 209));

        jLabel28.setBackground(new java.awt.Color(104, 186, 209));
        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("APLIKASI KOPERASI SIMPAN PINJAM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        menu.setBackground(new java.awt.Color(104, 186, 209));
        menu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(1, 1, 1))); // NOI18N
        menu.setForeground(new java.awt.Color(104, 186, 209));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATA ANGGOTA");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DATA SIMPANAN");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DATA ANGSURAN");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("DATA PINJAMAN");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Lainnya");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("LAPORAN");
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel37MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        main.setBackground(new java.awt.Color(255, 255, 0));
        main.setLayout(new java.awt.CardLayout());

        home.setBackground(new java.awt.Color(104, 186, 209));
        home.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel45.setText("Sistem Informasi");

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel48.setText("Koperasi");

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("Simpan Pinjam");

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel50.setText("Berbasis Dekstop");

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel51.setText("Copy Right @2020");

        javax.swing.GroupLayout homeLayout = new javax.swing.GroupLayout(home);
        home.setLayout(homeLayout);
        homeLayout.setHorizontalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel48)
                    .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(homeLayout.createSequentialGroup()
                            .addGap(123, 123, 123)
                            .addComponent(jLabel45))
                        .addGroup(homeLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel51))
                        .addGroup(homeLayout.createSequentialGroup()
                            .addGap(288, 288, 288)
                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(330, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel50)
                .addGap(163, 163, 163))
        );
        homeLayout.setVerticalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jLabel45)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addComponent(jLabel51)
                .addContainerGap())
        );

        main.add(home, "card2");

        anggota.setBackground(new java.awt.Color(104, 186, 209));
        anggota.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Anggota", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        angtabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama", "J. Kel", "Kota", "Tgl Lahir", "Telp", "Pegawai", "Tgl Masuk", "Alamat"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        angtabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                angtabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(angtabel);
        if (angtabel.getColumnModel().getColumnCount() > 0) {
            angtabel.getColumnModel().getColumn(0).setResizable(false);
            angtabel.getColumnModel().getColumn(1).setResizable(false);
            angtabel.getColumnModel().getColumn(2).setResizable(false);
            angtabel.getColumnModel().getColumn(3).setResizable(false);
            angtabel.getColumnModel().getColumn(4).setResizable(false);
            angtabel.getColumnModel().getColumn(5).setResizable(false);
            angtabel.getColumnModel().getColumn(6).setResizable(false);
            angtabel.getColumnModel().getColumn(7).setResizable(false);
            angtabel.getColumnModel().getColumn(8).setResizable(false);
        }

        angcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                angcariKeyReleased(evt);
            }
        });

        anghapus.setText("Hapus");
        anghapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anghapusActionPerformed(evt);
            }
        });

        input.setBackground(new java.awt.Color(104, 186, 209));
        input.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input Data Anggota", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel6.setText("No ID :");

        jLabel7.setText("Nama Lengkap :");

        jLabel8.setText("Jenis Kelamin :");

        jLabel9.setText("No Telp :");

        jLabel10.setText("Status Pegawai :");

        angjenkel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---Pilih---", "Pria", "Wanita" }));

        angsp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---Pilih---", "Aktif", "Tidak Aktif" }));

        jLabel11.setText("Kota :");

        jLabel12.setText("Tgl Lahir :");

        jLabel13.setText("Tgl Masuk :");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Alamat :");

        angalamat.setColumns(20);
        angalamat.setRows(5);
        jScrollPane5.setViewportView(angalamat);

        angbersih.setText("Bersih");
        angbersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                angbersihActionPerformed(evt);
            }
        });

        angedit.setText("Edit");
        angedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                angeditActionPerformed(evt);
            }
        });

        angtambah.setText("Tambah");
        angtambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                angtambahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout inputLayout = new javax.swing.GroupLayout(input);
        input.setLayout(inputLayout);
        inputLayout.setHorizontalGroup(
            inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputLayout.createSequentialGroup()
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(inputLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(angtambah)
                        .addGap(18, 18, 18)
                        .addComponent(angedit)
                        .addGap(18, 18, 18)
                        .addComponent(angbersih))
                    .addGroup(inputLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(angid, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(angnama, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(angtelp)
                            .addComponent(angjenkel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(angsp, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(angkota)
                            .addComponent(angtglmsk, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(angtgl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(35, 35, 35))
        );
        inputLayout.setVerticalGroup(
            inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputLayout.createSequentialGroup()
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(angkota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(angtgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(angtglmsk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(inputLayout.createSequentialGroup()
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(angid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(angnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(angjenkel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(angtelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(angsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(angbersih)
                    .addComponent(angedit)
                    .addComponent(angtambah))
                .addContainerGap())
        );

        javax.swing.GroupLayout anggotaLayout = new javax.swing.GroupLayout(anggota);
        anggota.setLayout(anggotaLayout);
        anggotaLayout.setHorizontalGroup(
            anggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(anggotaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(anggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(input, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, anggotaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(anggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(anghapus, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(angcari, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        anggotaLayout.setVerticalGroup(
            anggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(anggotaLayout.createSequentialGroup()
                .addComponent(angcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(anghapus)
                .addGap(11, 11, 11)
                .addComponent(input, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        main.add(anggota, "card3");

        simpanan.setBackground(new java.awt.Color(104, 186, 209));
        simpanan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Simpanan", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        simtabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Kode", "Nama", "Tgl Simp", "Pokok", "Wajib", "Sukarela", "Total"
            }
        ));
        simtabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                simtabelMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(simtabel);

        simcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                simcariKeyReleased(evt);
            }
        });

        simhapus.setText("Hapus");
        simhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simhapusActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(104, 186, 209));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input Data Simpanan", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel15.setText("No ID :");

        jLabel16.setText("Nama Anggota :");

        jLabel17.setText("Simp. Pokok :");

        jLabel18.setText("Simp. Sukarela :");

        simpokok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpokokActionPerformed(evt);
            }
        });

        simsukarela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simsukarelaActionPerformed(evt);
            }
        });

        jLabel20.setText("Kode Transaksi :");

        jLabel21.setText("Tgl Simpan :");

        jLabel22.setText("Simp. Wajib :");

        jLabel23.setText("Total :");

        simtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simtotalActionPerformed(evt);
            }
        });
        simtotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                simtotalKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                simtotalKeyReleased(evt);
            }
        });

        simbersih.setText("Bersih");
        simbersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simbersihActionPerformed(evt);
            }
        });

        simedit.setText("Edit");
        simedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simeditActionPerformed(evt);
            }
        });

        simtambah.setText("Tambah");
        simtambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simtambahActionPerformed(evt);
            }
        });

        simid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simidActionPerformed(evt);
            }
        });
        simid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                simidKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(simsukarela))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel17)))
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(simnama, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(simpokok)
                            .addComponent(simid))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(simtambah)
                        .addGap(18, 18, 18)
                        .addComponent(simedit)
                        .addGap(18, 18, 18)
                        .addComponent(simbersih)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(simkode)
                            .addComponent(simwajib)
                            .addComponent(simtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(simtgl, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(simid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(simnama, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(simpokok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(simsukarela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(simkode))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(simtgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(simwajib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(simtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simbersih)
                    .addComponent(simedit)
                    .addComponent(simtambah))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout simpananLayout = new javax.swing.GroupLayout(simpanan);
        simpanan.setLayout(simpananLayout);
        simpananLayout.setHorizontalGroup(
            simpananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(simpananLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(simpananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, simpananLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(simpananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(simcari, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(simhapus, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        simpananLayout.setVerticalGroup(
            simpananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(simpananLayout.createSequentialGroup()
                .addComponent(simcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(simhapus)
                .addGap(11, 11, 11)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        main.add(simpanan, "card4");

        pinjaman.setBackground(new java.awt.Color(104, 186, 209));
        pinjaman.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Pinjaman", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        pintabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Kode", "Nama", "Tanggal", "Jumlah", "Bunga", "Durasi", "Angsuran"
            }
        ));
        pintabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pintabelMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(pintabel);

        pincari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pincariKeyReleased(evt);
            }
        });

        pinhapus.setText("Hapus");
        pinhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pinhapusActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(104, 186, 209));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input Data Simpanan", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel24.setText("ID :");

        jLabel25.setText("Nama Lengkap :");

        jLabel26.setText("Jumlah Pinjaman :");

        jLabel27.setText("Lama Pinjam :");

        pinid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pinidKeyReleased(evt);
            }
        });

        jLabel33.setText("Kode Pinjaman :");

        jLabel34.setText("Tgl Pinjam :");

        jLabel35.setText("Bunga (%) :");

        jLabel36.setText("Angsuran :");

        pinangsuran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pinangsuranActionPerformed(evt);
            }
        });

        pinedit.setText("Edit");
        pinedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pineditActionPerformed(evt);
            }
        });

        pinbersih.setText("Bersih");
        pinbersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pinbersihActionPerformed(evt);
            }
        });

        pintambah.setText("Tambah");
        pintambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pintambahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pintambah)
                        .addGap(18, 18, 18)
                        .addComponent(pinedit)
                        .addGap(18, 18, 18)
                        .addComponent(pinbersih)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel27))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pinlama, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pinjumlah)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel24))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pinnama, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pinid, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel34)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36)
                            .addComponent(jLabel33))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pintgl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pinkode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pinbunga, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pinangsuran, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pinid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pinnama, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pinjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pinlama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pinkode, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(pintgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pinbunga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pinangsuran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pintambah)
                    .addComponent(pinedit)
                    .addComponent(pinbersih))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pinjamanLayout = new javax.swing.GroupLayout(pinjaman);
        pinjaman.setLayout(pinjamanLayout);
        pinjamanLayout.setHorizontalGroup(
            pinjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pinjamanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pinjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pinjamanLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pinjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pincari, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pinhapus, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        pinjamanLayout.setVerticalGroup(
            pinjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pinjamanLayout.createSequentialGroup()
                .addComponent(pincari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pinhapus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        main.add(pinjaman, "card5");

        angsuran.setBackground(new java.awt.Color(104, 186, 209));
        angsuran.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Angsuran", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        angstabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Kode", "Nama", "Nominal", "Tgl ", "Angsuran", "Dari", "No Bukti", "Keterangan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        angstabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                angstabelMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(angstabel);
        if (angstabel.getColumnModel().getColumnCount() > 0) {
            angstabel.getColumnModel().getColumn(0).setResizable(false);
            angstabel.getColumnModel().getColumn(1).setResizable(false);
            angstabel.getColumnModel().getColumn(2).setResizable(false);
            angstabel.getColumnModel().getColumn(3).setResizable(false);
            angstabel.getColumnModel().getColumn(4).setResizable(false);
            angstabel.getColumnModel().getColumn(5).setResizable(false);
            angstabel.getColumnModel().getColumn(6).setResizable(false);
            angstabel.getColumnModel().getColumn(7).setResizable(false);
            angstabel.getColumnModel().getColumn(8).setResizable(false);
        }

        angscari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                angscariKeyReleased(evt);
            }
        });

        angshapus.setText("Hapus");
        angshapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                angshapusActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(104, 186, 209));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input Data Angsuran", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel38.setText("Kode Pinjaman :");

        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel39.setText("Angsuran :");

        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel40.setText("Angsuran Ke :");

        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel41.setText("Keterangan :");

        angskode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                angskodeKeyReleased(evt);
            }
        });

        jLabel42.setText("Dari");

        buttonGroup1.add(angslunas);
        angslunas.setText("Lunas");

        buttonGroup1.add(angsbelum);
        angsbelum.setText("Belum Lunas");

        jLabel43.setText("Nama Lengkap :");

        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel44.setText("Tgl Angsuran :");

        angsbersih.setText("Bersih");

        angsedit.setText("Edit");
        angsedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                angseditActionPerformed(evt);
            }
        });

        angstambah.setText("Tambah");
        angstambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                angstambahActionPerformed(evt);
            }
        });

        angsno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                angsnoKeyReleased(evt);
            }
        });

        jLabel46.setText("No Angsuran :");

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Bukti  :");

        angsdari.setEditable(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(angsnama, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(angsno, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(angske, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel42)
                        .addGap(18, 18, 18)
                        .addComponent(angsdari, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(angslunas, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(angsbelum)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(angstambah)
                        .addGap(18, 18, 18)
                        .addComponent(angsedit)
                        .addGap(18, 18, 18)
                        .addComponent(angsbersih))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(angsbukti, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(angskode, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(angsangsuran, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(angstgl, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(28, 28, 28))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(angskode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(angsno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(angsangsuran, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(angsnama, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(angske, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(angsdari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(angstgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(angslunas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(angsbelum, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(angsbukti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(angsbersih)
                    .addComponent(angsedit)
                    .addComponent(angstambah))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout angsuranLayout = new javax.swing.GroupLayout(angsuran);
        angsuran.setLayout(angsuranLayout);
        angsuranLayout.setHorizontalGroup(
            angsuranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(angsuranLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(angsuranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, angsuranLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(angsuranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(angscari, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(angshapus, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        angsuranLayout.setVerticalGroup(
            angsuranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(angsuranLayout.createSequentialGroup()
                .addComponent(angscari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(angshapus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        main.add(angsuran, "card6");

        laporan.setBackground(new java.awt.Color(104, 186, 209));
        laporan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Laporan", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        lapsim.setFont(new java.awt.Font("Clarendon BT", 1, 14)); // NOI18N
        lapsim.setForeground(new java.awt.Color(255, 255, 255));
        lapsim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/print.png"))); // NOI18N
        lapsim.setText("Laporan Simpanan");
        lapsim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lapsimMouseClicked(evt);
            }
        });

        lappin.setFont(new java.awt.Font("Clarendon BT", 1, 14)); // NOI18N
        lappin.setForeground(new java.awt.Color(255, 255, 255));
        lappin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/print.png"))); // NOI18N
        lappin.setText("Laporan Pinjaman");
        lappin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lappinMouseClicked(evt);
            }
        });

        lapangs.setFont(new java.awt.Font("Clarendon BT", 1, 14)); // NOI18N
        lapangs.setForeground(new java.awt.Color(255, 255, 255));
        lapangs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lapangs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/print.png"))); // NOI18N
        lapangs.setText("Laporan Angsuran");
        lapangs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lapangsMouseClicked(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Clarendon BT", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("Note :");
        jLabel55.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel55MouseClicked(evt);
            }
        });

        jLabel56.setFont(new java.awt.Font("Clarendon BT", 1, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel56.setText("Jika Ingin Mencetak Langsung Klik Saja.");
        jLabel56.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel56MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout laporanLayout = new javax.swing.GroupLayout(laporan);
        laporan.setLayout(laporanLayout);
        laporanLayout.setHorizontalGroup(
            laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(laporanLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(laporanLayout.createSequentialGroup()
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel56))
                    .addComponent(lapangs)
                    .addComponent(lappin)
                    .addGroup(laporanLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lapsim)))
                .addContainerGap(357, Short.MAX_VALUE))
        );
        laporanLayout.setVerticalGroup(
            laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(laporanLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(lapsim)
                .addGap(69, 69, 69)
                .addComponent(lappin)
                .addGap(69, 69, 69)
                .addComponent(lapangs)
                .addGap(63, 63, 63)
                .addGroup(laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(jLabel56))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        main.add(laporan, "card2");

        about.setBackground(new java.awt.Color(104, 186, 209));
        about.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menu Lainnya", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        javax.swing.GroupLayout aboutLayout = new javax.swing.GroupLayout(about);
        about.setLayout(aboutLayout);
        aboutLayout.setHorizontalGroup(
            aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 769, Short.MAX_VALUE)
        );
        aboutLayout.setVerticalGroup(
            aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 431, Short.MAX_VALUE)
        );

        main.add(about, "card7");

        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/exit (3).png"))); // NOI18N
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });

        Datenow.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Datenow.setForeground(new java.awt.Color(255, 255, 255));
        Datenow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Timenow.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Timenow.setForeground(new java.awt.Color(255, 255, 255));
        Timenow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(menu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(logout)
                            .addComponent(Datenow, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Timenow, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(Datenow, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Timenow, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logout))
                    .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        main.removeAll();
        main.repaint();
        main.revalidate();
        
        main.add(anggota);
        main.repaint();
        main.revalidate();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        main.removeAll();
        main.repaint();
        main.revalidate();
        
        main.add(simpanan);
        main.repaint();
        main.revalidate();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        main.removeAll();
        main.repaint();
        main.revalidate();
        
        main.add(pinjaman);
        main.repaint();
        main.revalidate();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        main.removeAll();
        main.repaint();
        main.revalidate();
        
        main.add(angsuran);
        main.repaint();
        main.revalidate();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        main.removeAll();
        main.repaint();
        main.revalidate();
        
        main.add(about);
        main.repaint();
        main.revalidate();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void angtambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_angtambahActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        //String tanggal=fm.format(tgl.getDate());
        //String masuk = fm.format(tgl_msk.getDate());
        if(angjenkel.getSelectedItem().toString().equalsIgnoreCase("---Pilih---")){
            JOptionPane.showMessageDialog(null, "Opsi Jenis Kelamin Belum Dipilih \n atau Opsi Status Belum dipilih");
        }else if(angsp.getSelectedItem().toString().equalsIgnoreCase("---Pilih---")){
            JOptionPane.showMessageDialog(null, "Opsi Status Pegawai Belum Dipilih \n atau Opsi Status Belum dipilih");
        }else {
        try {
            sql = "INSERT INTO `dataanggota`(`noanggota`,`namaanggota`,`jenkel`,`tempat`,`ttl`,`notelp`,`status`,`tglmsk`,`alamat`) VALUES (?,?,?,?,?,?,?,?,?)";
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, angid.getText());
            stat.setString(2, angnama.getText());
            stat.setString(3, angjenkel.getSelectedItem().toString());
            stat.setString(4, angkota.getText());
            stat.setString(5, fm.format(angtgl.getDate()));
            stat.setString(6, angtelp.getText());
            stat.setString(7, angsp.getSelectedItem().toString());
            stat.setString(8, fm.format(angtglmsk.getDate()));
            stat.setString(9, angalamat.getText());
            stat.executeUpdate();
            angid.requestFocus();
            angdata();
            angkolom();
            angbersih();
            JOptionPane.showMessageDialog(null, "Berhasil");
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Gagal Disimpan "+e);
        }
        }
    }//GEN-LAST:event_angtambahActionPerformed

    private void angcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_angcariKeyReleased
        // TODO add your handling code here:
        Object[] Baris = {"ID","Nama","JK","Kota","Tgl Lahir","Telp","Pegawai","Tgl Masuk","Alamat"};
        angmode = new DefaultTableModel(null,Baris);
        angtabel.setModel(angmode);
        //String as = "yyyy-MM-dd";
        //DateFormat df =  new SimpleDateFormat("yyyy-MM-dd");
        //Date d1 = df.parse(tgl);
        
            try {
                sql = "SELECT * FROM dataanggota where namaanggota like '"+angcari.getText()+"%'";//dataanggota.noanggota,dataanggota.namaanggota,dataanggota.tempat,dataanggota.ttl,dataanggota.jenkel,dataanggota.notelp,dataanggota.status,dataanggota.tglmsk,dataanggota.alamat";
                rs = stat.executeQuery(sql);
            while (rs.next()){
            String a = rs.getString("noanggota");
            String b = rs.getString("namaanggota");
            String c = rs.getString("jenkel");
            String d = rs.getString("tempat");
            java.sql.Date lahir = rs.getDate("ttl");
            String e = lahir.toString();
            String f = rs.getString("notelp");
            String g = rs.getString("status");
            java.sql.Date masuk = rs.getDate("tglmsk");
            String h = masuk.toString();
            String i = rs.getString("alamat");
          
            String[] data = {a,b,c,d,e,f,g,h,i};
            angmode.addRow(data);
            }
            }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Database Error");
        }
    }//GEN-LAST:event_angcariKeyReleased

    private void angtabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_angtabelMouseClicked
        // TODO add your handling code here:
        try{
                DefaultTableModel model = (DefaultTableModel)angtabel.getModel();
                int srow = angtabel.getSelectedRow();
                java.util.Date dad = new SimpleDateFormat("yyyy-MM-dd").parse((String)angmode.getValueAt(srow, 4));
                java.util.Date dad1 = new SimpleDateFormat("yyyy-MM-dd").parse((String)angmode.getValueAt(srow, 7));
                angtgl.setDate(dad);
                angtglmsk.setDate(dad1);
                
                int bar = angtabel.getSelectedRow();
                
                String a = angmode.getValueAt(bar, 0).toString(); //No ID
                String b = angmode.getValueAt(bar, 1).toString(); // Nama Anggota
                String c = angmode.getValueAt(bar, 2).toString(); // Jenkel
                String d = angmode.getValueAt(bar, 3).toString(); // Kota
                String e = angmode.getValueAt(bar, 4).toString(); // TTL
                String f = angmode.getValueAt(bar, 5).toString(); // No Telp
                String g = angmode.getValueAt(bar, 6).toString(); // Status
                String h = angmode.getValueAt(bar, 7).toString(); // Tanggal Masuk
                String i = angmode.getValueAt(bar, 8).toString(); // Alamat
                angid.setText(a);
                angnama.setText(b);
                angjenkel.setSelectedItem(c);
                angkota.setText(d);
                angtgl.setDate(dad);
                angtelp.setText(f);
                angsp.setSelectedItem(g);
                angtglmsk.setDate(dad1);
                angalamat.setText(i);
                
                angid.setEditable(false);
            } catch (Exception ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_angtabelMouseClicked

    private void angeditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_angeditActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal=fm.format(angtgl.getDate());
        String masuk = fm.format(angtglmsk.getDate());
        try {
            sql = "UPDATE dataanggota SET namaanggota=?,jenkel=?,tempat=?,ttl=?, notelp=?,status=?,tglmsk=?,alamat=? WHERE noanggota=?";
            
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, angnama.getText());
            stat.setString(2, angjenkel.getSelectedItem().toString());
            stat.setString(3, angkota.getText());
            stat.setString(4, tanggal);
            stat.setString(5, angtelp.getText());
            stat.setString(6, angsp.getSelectedItem().toString());
            stat.setString(7, masuk);
            stat.setString(8, angalamat.getText());
            stat.setString(9, angid.getText());
            stat.executeUpdate();
            angid.requestFocus();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");
            angdata();
            angkolom();
            angbersih();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diupdate");
        }
    }//GEN-LAST:event_angeditActionPerformed

    private void angbersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_angbersihActionPerformed
        // TODO add your handling code here:
        angbersih();
    }//GEN-LAST:event_angbersihActionPerformed

    private void anghapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anghapusActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Hapus", "Konfirmasi Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok==0){
            try{
                sql = "Delete from `dataanggota` WHERE `noanggota`='"+angid.getText()+"'";
                java.sql.PreparedStatement stat = con.prepareStatement(sql);
                stat.executeUpdate();
                angnama.requestFocus();
                angdata();
                angkolom();
                angbersih();
                JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus");
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Gagal di Hapus");
            }
        }
    }//GEN-LAST:event_anghapusActionPerformed

    private void simpokokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpokokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_simpokokActionPerformed

    private void simcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_simcariKeyReleased
        // TODO add your handling code here:
        Object[] Baris = {"ID","Kode","Nama","Tgl Simpan","Pokok","Wajib","Sukarela","Total"};
        simmode = new DefaultTableModel(null,Baris);
        simtabel.setModel(simmode);
        //String as = "yyyy-MM-dd";
        //DateFormat df =  new SimpleDateFormat("yyyy-MM-dd");
        //Date d1 = df.parse(tgl);
        
            try {
                sql = "SELECT * FROM datasimpan where nama like'"+simcari.getText()+"%'";//dataanggota.noanggota,dataanggota.namaanggota,dataanggota.tempat,dataanggota.ttl,dataanggota.jenkel,dataanggota.notelp,dataanggota.status,dataanggota.tglmsk,dataanggota.alamat";
                rs = stat.executeQuery(sql);
            while (rs.next()){
            String a = rs.getString("id");
            String b = rs.getString("kode");
            String c = rs.getString("nama");
            java.sql.Date lahir = rs.getDate("tgl");
            String d = lahir.toString();
            String e = rs.getString("pokok");
            String f = rs.getString("wajib");
            String g = rs.getString("sukarela");
            String h = rs.getString("total");
          
            String[] data = {a,b,c,d,e,f,g,h};  // Bagian Enya di tulis apa Pak ?
            simmode.addRow(data);
            }
            }catch (Exception e){
        }
    }//GEN-LAST:event_simcariKeyReleased

    private void simtambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simtambahActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal=fm.format(simtgl.getDate());
        try {
            sql = "INSERT INTO `datasimpan`(`id`,`kode`,`nama`,`tgl`,`pokok`,`wajib`,`sukarela`,`total`) VALUES (?,?,?,?,?,?,?,?)";
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, simid.getText());
            stat.setString(2, simkode.getText());
            stat.setString(3, simnama.getText());
            stat.setString(4, tanggal);
            stat.setString(5, simpokok.getText());
            stat.setString(6, simwajib.getText());
            stat.setString(7, simsukarela.getText());
            stat.setString(8, simtotal.getText());
            stat.executeUpdate();
            simid.requestFocus();
            simdata();
            simbersih();
            simkolom();
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Tambahkan");
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Gagal Disimpan");
        }
    }//GEN-LAST:event_simtambahActionPerformed

    private void simeditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simeditActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat simfm = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal=simfm.format(simtgl.getDate());
        try {
            sql = "UPDATE datasimpan SET kode=?,nama=?,tgl=?,pokok=?,wajib=?,sukarela=?,total=? WHERE id=?";
            // database tgl belom di tulis karena belom berhasil di Update
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, simkode.getText());
            stat.setString(2, simnama.getText());
            stat.setString(3, tanggal);
            stat.setString(4, simpokok.getText());
            stat.setString(5, simwajib.getText());
            stat.setString(6, simsukarela.getText());
            stat.setString(7, simtotal.getText());
            stat.setString(8, simid.getText());
            stat.executeUpdate();
            simid.requestFocus();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diperbarui");
            simdata();
            simbersih();
            simkolom();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
        }
    }//GEN-LAST:event_simeditActionPerformed

    private void simbersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simbersihActionPerformed
        // TODO add your handling code here:
        simbersih();
    }//GEN-LAST:event_simbersihActionPerformed

    private void simtabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simtabelMouseClicked
        // TODO add your handling code here:
        try{
                DefaultTableModel model = (DefaultTableModel)simtabel.getModel();
                int srow = simtabel.getSelectedRow();
                java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)simmode.getValueAt(srow, 3));
                simtgl.setDate(date);
                
                int bar = simtabel.getSelectedRow();
                String a = simmode.getValueAt(bar, 0).toString(); //No ID
                String b = simmode.getValueAt(bar, 1).toString(); // Nama Anggota
                String c = simmode.getValueAt(bar, 2).toString(); // Jenkel
                String d = simmode.getValueAt(bar, 3).toString(); // Kota
                String e = simmode.getValueAt(bar, 4).toString(); // TTL
                String f = simmode.getValueAt(bar, 5).toString(); // No Telp
                String g = simmode.getValueAt(bar, 6).toString(); // Status
                String h = simmode.getValueAt(bar, 7).toString(); // Tanggal Masuk
                simid.setText(a);
                simkode.setText(b);
                simnama.setText(c);
                simtgl.setDate(date);
                simpokok.setText(e);
                simwajib.setText(f);
                simsukarela.setText(g);
                simtotal.setText(h);
            } catch (Exception ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_simtabelMouseClicked

    private void pincariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pincariKeyReleased
        // TODO add your handling code here:
        Object[] Baris = {"ID","Kode","Nama","Tanggal","Jumlah","Bunga","Durasi","Angsuran"};
        pinmode = new DefaultTableModel(null,Baris);
        pintabel.setModel(pinmode);
        //String as = "yyyy-MM-dd";
        //DateFormat df =  new SimpleDateFormat("yyyy-MM-dd");
        //Date d1 = df.parse(tgl);
        
            try {
                sql = "SELECT * FROM datapinjam where nama like'"+pincari.getText()+"%'";//dataanggota.noanggota,dataanggota.namaanggota,dataanggota.tempat,dataanggota.ttl,dataanggota.jenkel,dataanggota.notelp,dataanggota.status,dataanggota.tglmsk,dataanggota.alamat";
                rs = stat.executeQuery(sql);
            while (rs.next()){
            String a = rs.getString("id");
            String b = rs.getString("kode");
            String c = rs.getString("nama");
            java.sql.Date lahir = rs.getDate("tgl");
            String d = lahir.toString();
            String e = rs.getString("jumlah");
            String f = rs.getString("bunga");
            String g = rs.getString("lama");
            String h = rs.getString("angsuran");
          
            String[] data = {a,b,c,d,e,f,g,h,};  // Bagian Enya di tulis apa Pak ?
            pinmode.addRow(data);
            }
            }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Database Error");
        }
    }//GEN-LAST:event_pincariKeyReleased

    private void pintabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pintabelMouseClicked
        // TODO add your handling code here:
        try{
                DefaultTableModel model = (DefaultTableModel)pintabel.getModel();
                int srow = pintabel.getSelectedRow();
                java.util.Date da = new SimpleDateFormat("yyyy-MM-dd").parse((String)pinmode.getValueAt(srow, 3));
                pintgl.setDate(da);
                
                int bar = pintabel.getSelectedRow();
                String a = pinmode.getValueAt(bar, 0).toString(); //No ID
                String b = pinmode.getValueAt(bar, 1).toString(); // Nama Anggota
                String c = pinmode.getValueAt(bar, 2).toString(); // Jenkel
                String d = pinmode.getValueAt(bar, 3).toString(); // Kota
                String e = pinmode.getValueAt(bar, 4).toString(); // TTL
                String f = pinmode.getValueAt(bar, 5).toString(); // No Telp
                String g = pinmode.getValueAt(bar, 6).toString(); // Status
                String h = pinmode.getValueAt(bar, 7).toString(); // Tanggal Masuk
                pinid.setText(a);
                pinkode.setText(b);
                pinnama.setText(c);
                pintgl.setDate(da);
                pinjumlah.setText(e);
                pinbunga.setText(f);
                pinlama.setText(g);
                pinangsuran.setText(h);
            } catch (Exception ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_pintabelMouseClicked

    private void pinidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pinidKeyReleased
        // TODO add your handling code here:
        try{
            sql = "Select * From datasimpan where id ='"+pinid.getText()+"'";
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            rs = stat.executeQuery(sql);
            if (rs.next() == false) {
            pinnama.setText("");
            pinkode.setText("");
            } else {
            do{
            pinnama.setText(rs.getString("nama"));
            pinkode.setText(rs.getString("kode"));
            }while(rs.next());
            }
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pinidKeyReleased

    private void pinangsuranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pinangsuranActionPerformed
        // TODO add your handling code here:
        pintotal();
    }//GEN-LAST:event_pinangsuranActionPerformed

    private void pinhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pinhapusActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Hapus", "Konfirmasi Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok==0){
            try{
                sql = "Delete from `datapinjam` WHERE `id`='"+pinid.getText()+"'";
                java.sql.PreparedStatement stat = con.prepareStatement(sql);
                stat.executeUpdate();
                pinkode.requestFocus();
                pindata();
                pinbersih();
                pinkolom();
                JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus");
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Gagal di Hapus");
            }
        }
    }//GEN-LAST:event_pinhapusActionPerformed

    private void pintambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pintambahActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal=fm.format(pintgl.getDate());
        try {
            sql = "INSERT INTO `datapinjam`(`id`,`kode`,`nama`,`tgl`,`jumlah`,`bunga`,`lama`,`angsuran`) VALUES (?,?,?,?,?,?,?,?)";
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, pinid.getText());
            stat.setString(2, pinkode.getText());
            stat.setString(3, pinnama.getText());
            stat.setString(4, tanggal);
            stat.setString(5, pinjumlah.getText());
            stat.setString(6, pinbunga.getText());
            stat.setString(7, pinlama.getText());
            stat.setString(8, pinangsuran.getText());
            stat.executeUpdate();
            pinid.requestFocus();
            pindata();
            pinbersih();
            pinkolom();
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Tambahkan");
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Gagal Disimpan");
        }
    }//GEN-LAST:event_pintambahActionPerformed

    private void pineditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pineditActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal=fm.format(pintgl.getDate());
        try {
            sql = "UPDATE datapinjam SET kode=?,nama=?,tgl=?,jumlah=?,bunga=?,lama=?,angsuran=? WHERE id=?";
            
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, pinkode.getText());
            stat.setString(2, pinnama.getText());
            stat.setString(3, tanggal);
            stat.setString(4, pinjumlah.getText());
            stat.setString(5, pinbunga.getText());
            stat.setString(6, pinlama.getText());
            stat.setString(7, pinangsuran.getText());
            stat.setString(8, pinid.getText());
            stat.executeUpdate();
            pinid.requestFocus();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diperbarui");
            pindata();
            pinbersih();
            pinkolom();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diperbarui");
        }
    }//GEN-LAST:event_pineditActionPerformed

    private void pinbersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pinbersihActionPerformed
        // TODO add your handling code here:
        pinbersih();
    }//GEN-LAST:event_pinbersihActionPerformed

    private void angscariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_angscariKeyReleased
        // TODO add your handling code here:
        Object[] Baris = {"Kode","Nama","Angsuran","Tanggal","Angsuran Ke","Dari","Bukti","Keterangan"};
        angsmode = new DefaultTableModel(null,Baris);
        angstabel.setModel(angsmode);
        //String as = "yyyy-MM-dd";
        //DateFormat df =  new SimpleDateFormat("yyyy-MM-dd");
        //Date d1 = df.parse(tgl);
        
            try {
                sql = "SELECT * FROM dataangsuran where nama like '"+angscari.getText()+"%'";//dataanggota.noanggota,dataanggota.namaanggota,dataanggota.tempat,dataanggota.ttl,dataanggota.jenkel,dataanggota.notelp,dataanggota.status,dataanggota.tglmsk,dataanggota.alamat";
                rs = stat.executeQuery(sql);
            while (rs.next()){
            String a = rs.getString("kode");
            String b = rs.getString("nama");
            String c = rs.getString("angsuran");
            java.sql.Date lahir = rs.getDate("tgl");
            String d = lahir.toString();
            String e = rs.getString("angsuranke");
            String f = rs.getString("dari");
            String g = rs.getString("bukti");
            String h = rs.getString("keterangan");
          
            String[] data = {a,b,c,d,e,f,g,h};  // Bagian Enya di tulis apa Pak ?
            angsmode.addRow(data);
            }
            }catch (Exception e){
        }
    }//GEN-LAST:event_angscariKeyReleased

    private void angstabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_angstabelMouseClicked
        // TODO add your handling code here:
        try{
                DefaultTableModel model = (DefaultTableModel)angstabel.getModel();
                int srow = angstabel.getSelectedRow();
                java.util.Date tgl = new SimpleDateFormat("yyyy-MM-dd").parse((String)angsmode.getValueAt(srow, 4));
                angstgl.setDate(tgl);
                
                int bar = angstabel.getSelectedRow();
                String a = angsmode.getValueAt(bar, 0).toString();
                String b = angsmode.getValueAt(bar, 1).toString(); //No ID
                String c = angsmode.getValueAt(bar, 2).toString(); // Nama Anggota
                String d = angsmode.getValueAt(bar, 3).toString(); // Jenkel
                String e = angsmode.getValueAt(bar, 4).toString(); // Kota
                String f = angsmode.getValueAt(bar, 5).toString(); // TTL
                String g = angsmode.getValueAt(bar, 6).toString(); // No Telp
                String h = angsmode.getValueAt(bar, 7).toString(); // Status
                String i = angsmode.getValueAt(bar, 8).toString(); // Tanggal Masuk
                angsno.setText(a);
                angskode.setText(b);
                angsnama.setText(c);
                angsangsuran.setText(d);
                angstgl.setDate(tgl);
                angske.setText(f);
                angsdari.setText(g);
                angsbukti.setText(h);
                if (i.equals("Lunas")){
                    angslunas.setSelected(true); angsbelum.setSelected(false);
                }else {
                    angslunas.setSelected(false); angsbelum.setSelected(true);
                }
            } catch (Exception ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_angstabelMouseClicked

    private void angstambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_angstambahActionPerformed
        // TODO add your handling code here
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal=fm.format(angstgl.getDate());
        
        try {
            sql = "INSERT INTO `dataangsuran`(`no`,`kode`,`nama`,`angsuran`,`tgl`,`angsuranke`,`dari`,`bukti`,`keterangan`) VALUES (?,?,?,?,?,?,?,?,?)";
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            
            stat.setString(1, angsno.getText());
            stat.setString(2, angskode.getText());
            stat.setString(3, angsnama.getText());
            stat.setString(4, angsangsuran.getText());
            stat.setString(5, tanggal);
            stat.setString(6, angske.getText());
            stat.setString(7, angsdari.getText());
            stat.setString(8, angsbukti.getText());
            String kete = "";
            if(angslunas.isSelected()){
            kete = "Lunas";
                    stat.setString(9, kete);
            }else {
            kete = "Belum Lunas";
                    stat.setString(9, kete);
            }
            stat.executeUpdate();
            angskode.requestFocus();
            angsdata();
            angsbersih();
            angskolom();
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Tambahkan");
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Gagal Disimpan");
        }
    }//GEN-LAST:event_angstambahActionPerformed

    private void angshapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_angshapusActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Hapus", "Konfirmasi Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok==0){
            try{
                sql = "Delete from `dataangsuran` WHERE `no`='"+angsno.getText()+"'";
                java.sql.PreparedStatement stat = con.prepareStatement(sql);
                stat.executeUpdate();
                angske.requestFocus();
                angsdata();
                angsbersih();
                angskolom();
                JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus");
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Gagal di Hapus");
            }
        }
    }//GEN-LAST:event_angshapusActionPerformed

    private void simidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_simidActionPerformed

    private void simidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_simidKeyReleased
        // TODO add your handling code here:
        try{
            sql = "Select * From dataanggota where noanggota ='"+simid.getText()+"'";
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            rs = stat.executeQuery(sql);
                while (rs.next())
                simnama.setText(rs.getString("namaanggota"));
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_simidKeyReleased

    private void angskodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_angskodeKeyReleased
        // TODO add your handling code here:
        
        try{
            sql = "Select * From datapinjam where kode ='"+angskode.getText()+"'";
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            rs = stat.executeQuery(sql);
            if (rs.next() == false) {
            angsnama.setText("");
            angsangsuran.setText("");
            angsdari.setText("");
            } else {
            do{
            angsnama.setText(rs.getString("nama"));
            angsangsuran.setText(rs.getString("angsuran"));
            angsdari.setText(rs.getString("lama"));
            }while(rs.next());
            }
            
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_angskodeKeyReleased

    private void angsnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_angsnoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_angsnoKeyReleased

    private void angseditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_angseditActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal=fm.format(angstgl.getDate());
        try {
            sql = "UPDATE dataangsuran SET kode=?,nama=?,angsuran=?,tgl=?,angsuranke=?,dari=?,bukti=?,keterangan=? WHERE no=?";
            // database ttl dan tglmsk belom di tulis karena belom berhasil di Update
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, angskode.getText());
            stat.setString(2, angsnama.getText());
            stat.setString(3, angsangsuran.getText());
            stat.setString(4, tanggal);
            stat.setString(5, angske.getText());
            stat.setString(6, angsdari.getText());
            stat.setString(7, angsbukti.getText());
            String ket = "";
            if(angslunas.isSelected()){
            ket = "Lunas";
                    stat.setString(8, ket);
            }else {
            ket = "Belum Lunas";
                    stat.setString(8, ket);
            }
            stat.setString(9, angsno.getText());
            stat.executeUpdate();
            angsno.requestFocus();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            angsdata();
            angsbersih();
            angskolom();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
        }
    }//GEN-LAST:event_angseditActionPerformed

    private void jLabel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseClicked
        // TODO add your handling code here:
        main.removeAll();
        main.repaint();
        main.revalidate();
        
        main.add(laporan);
        main.repaint();
        main.revalidate();
    }//GEN-LAST:event_jLabel37MouseClicked

    private void simhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simhapusActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Hapus", "Konfirmasi Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok==0){
            try{
                sql = "Delete from `datasimpan` WHERE `id`='"+simid.getText()+"'";
                java.sql.PreparedStatement stat = con.prepareStatement(sql);
                stat.executeUpdate();
                simkode.requestFocus();
                simdata();
                simbersih();
                simkolom();
                JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus");
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Gagal di Hapus");
            }
        }
    }//GEN-LAST:event_simhapusActionPerformed

    private void simtotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_simtotalKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_simtotalKeyPressed

    private void simtotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_simtotalKeyReleased
        // TODO add your handling code here:
        simtotal();
    }//GEN-LAST:event_simtotalKeyReleased

    private void simtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simtotalActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_simtotalActionPerformed

    private void lapsimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lapsimMouseClicked
        // TODO add your handling code here:
        try{
            HashMap parameter=new HashMap();
            String namaFile="src/Laporan/lapsimpan.jasper";
            JasperReport jr=(JasperReport) JRLoader.loadObject(namaFile);
            JasperPrint jp=JasperFillManager.fillReport(jr, parameter, con);
            JasperViewer.viewReport(jp, false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        }catch (Exception e){
            javax.swing.JOptionPane.showMessageDialog(null, "Data Tidak Dapat dicetak!!"+"\n"+ e.getMessage(), "Cetak Data", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_lapsimMouseClicked

    private void lappinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lappinMouseClicked
        // TODO add your handling code here:
        try{
            HashMap parameter=new HashMap();
            String namaFile="src/Laporan/lappinjam.jasper";
            JasperReport jr=(JasperReport) JRLoader.loadObject(namaFile);
            JasperPrint jp=JasperFillManager.fillReport(jr, parameter, con);
            JasperViewer.viewReport(jp, false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        }catch (Exception e){
            javax.swing.JOptionPane.showMessageDialog(null, "Data Tidak Dapat dicetak!!"+"\n"+ e.getMessage(), "Cetak Data", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_lappinMouseClicked

    private void lapangsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lapangsMouseClicked
        // TODO add your handling code here:
        try{
            HashMap parameter=new HashMap();
            String namaFile="src/Laporan/lapangsuran.jasper";
            JasperReport jr=(JasperReport) JRLoader.loadObject(namaFile);
            JasperPrint jp=JasperFillManager.fillReport(jr, parameter, con);
            JasperViewer.viewReport(jp, false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        }catch (Exception e){
            javax.swing.JOptionPane.showMessageDialog(null, "Data Tidak Dapat dicetak!!"+"\n"+ e.getMessage(), "Cetak Data", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_lapangsMouseClicked

    private void jLabel55MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel55MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel55MouseClicked

    private void jLabel56MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel56MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel56MouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        // TODO add your handling code here:
        int signout = JOptionPane.YES_NO_OPTION;
        int signoutResult = JOptionPane.showConfirmDialog(this, "Apakah Ingin Logout?", "Keluar", signout);
        if (signoutResult == 0){
            new login().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_logoutMouseClicked

    private void simsukarelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simsukarelaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_simsukarelaActionPerformed

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Datenow;
    private javax.swing.JLabel Timenow;
    private javax.swing.JPanel about;
    private javax.swing.JTextArea angalamat;
    private javax.swing.JButton angbersih;
    private javax.swing.JTextField angcari;
    private javax.swing.JButton angedit;
    private javax.swing.JPanel anggota;
    private javax.swing.JButton anghapus;
    private javax.swing.JTextField angid;
    private javax.swing.JComboBox angjenkel;
    private javax.swing.JTextField angkota;
    private javax.swing.JTextField angnama;
    private javax.swing.JLabel angsangsuran;
    private javax.swing.JCheckBox angsbelum;
    private javax.swing.JButton angsbersih;
    private javax.swing.JTextField angsbukti;
    private javax.swing.JTextField angscari;
    private javax.swing.JTextField angsdari;
    private javax.swing.JButton angsedit;
    private javax.swing.JButton angshapus;
    private javax.swing.JTextField angske;
    private javax.swing.JTextField angskode;
    private javax.swing.JCheckBox angslunas;
    private javax.swing.JLabel angsnama;
    private javax.swing.JTextField angsno;
    private javax.swing.JComboBox angsp;
    private javax.swing.JTable angstabel;
    private javax.swing.JButton angstambah;
    private com.toedter.calendar.JDateChooser angstgl;
    private javax.swing.JPanel angsuran;
    private javax.swing.JTable angtabel;
    private javax.swing.JButton angtambah;
    private javax.swing.JTextField angtelp;
    private com.toedter.calendar.JDateChooser angtgl;
    private com.toedter.calendar.JDateChooser angtglmsk;
    private javax.swing.JPanel bg;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel home;
    private javax.swing.JPanel input;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lapangs;
    private javax.swing.JPanel laporan;
    private javax.swing.JLabel lappin;
    private javax.swing.JLabel lapsim;
    private javax.swing.JLabel logout;
    private javax.swing.JPanel main;
    private javax.swing.JPanel menu;
    private javax.swing.JTextField pinangsuran;
    private javax.swing.JButton pinbersih;
    private javax.swing.JTextField pinbunga;
    private javax.swing.JTextField pincari;
    private javax.swing.JButton pinedit;
    private javax.swing.JButton pinhapus;
    private javax.swing.JTextField pinid;
    private javax.swing.JPanel pinjaman;
    private javax.swing.JTextField pinjumlah;
    private javax.swing.JLabel pinkode;
    private javax.swing.JTextField pinlama;
    private javax.swing.JLabel pinnama;
    private javax.swing.JTable pintabel;
    private javax.swing.JButton pintambah;
    private com.toedter.calendar.JDateChooser pintgl;
    private javax.swing.JButton simbersih;
    private javax.swing.JTextField simcari;
    private javax.swing.JButton simedit;
    private javax.swing.JButton simhapus;
    private javax.swing.JTextField simid;
    private javax.swing.JTextField simkode;
    private javax.swing.JLabel simnama;
    private javax.swing.JPanel simpanan;
    private javax.swing.JTextField simpokok;
    private javax.swing.JTextField simsukarela;
    private javax.swing.JTable simtabel;
    private javax.swing.JButton simtambah;
    private com.toedter.calendar.JDateChooser simtgl;
    private javax.swing.JTextField simtotal;
    private javax.swing.JTextField simwajib;
    // End of variables declaration//GEN-END:variables
}
