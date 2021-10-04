/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.sql.*;

import conexion.ConexionBD;
import entidades.CategoriaJuvenil;
import entidades.CategoriaMayores;
import entidades.Equipo;
import entidades.Jugador;
import entidades.Torneo;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import manejo_archivos.Archivo;

/**
 *
 * @author Nicolás
 */
public class Vista extends javax.swing.JFrame {
    DefaultTableModel modeloEquipos;
    DefaultTableModel modeloJugadores;
    /**
     * Creates new form Vista
     */
    public Vista() {
        modeloEquipos = new DefaultTableModel();
        modeloEquipos.addColumn("Nombre");
        modeloEquipos.addColumn("Numero Jugadores");
        modeloEquipos.addColumn("Categoria");
        modeloEquipos.addColumn("Numero Aficionados");
        modeloEquipos.addColumn("Victorias");
        modeloEquipos.addColumn("Derrotas");
        
        modeloJugadores = new DefaultTableModel();
        modeloJugadores.addColumn("Nombre");
        modeloJugadores.addColumn("Edad");
        modeloJugadores.addColumn("Equipo al que pertenece");

        initComponents();
        tablaEquipos.setModel(modeloEquipos);
        tablaJugadores.setModel(modeloJugadores);
        mostrarDatos();
    }
    
    private void mostrarDatos(){
        Torneo torneo = null;
        CategoriaJuvenil cj = null;
        CategoriaMayores cm = null;
        Equipo equipo = null;
        Jugador jugador = null;
        Jugador[] jugadores = new Jugador[8];
        
        // ArrayList de equipos
        ArrayList<Equipo> equiposJuveniles = new ArrayList<Equipo>();
        ArrayList<Equipo> equiposMayores = new ArrayList<Equipo>();
        
        
        //Datos
        ConexionBD con = new ConexionBD();
        Connection conBD = con.conexionBD();
        
        Statement st;
        ResultSet rs;
        
        try {
            st = conBD.createStatement();
            rs = st.executeQuery("SELECT * FROM categoriaJuvenil");
            
            while(rs.next()){
                cj = new CategoriaJuvenil(rs.getString("nombre"), 2, 16, rs.getString("rangoEdad"), equiposJuveniles);
            }
            
            if(cj != null) {
                nombreCategoriaJuvenil.setText(cj.getNombre());
                numeroEquiposCategoriaJuvenil.setText(Integer.toString(cj.getNumeroDeEquipos()));
                numeroTotalJugadoresCategoriaJuvenil.setText(Integer.toString(cj.getNumeroTotalJugadores()));
                rangoEdadCategoriaJuvenil.setText(cj.getRangoEdad());
            }
            
            
            rs = st.executeQuery("SELECT * FROM categoriaMayores");
            
            while(rs.next()){
                cm = new CategoriaMayores(rs.getString("nombre"), 2, 16, rs.getString("rangoEdad"), equiposMayores);
            }
            
            if(cm != null) {
                nombreCategoriaMayores.setText(cm.getNombre());
                numeroEquiposCategoriaMayores.setText(Integer.toString(cm.getNumeroDeEquipos()));
                numeroTotalJugadoresCategoriaMayores.setText(Integer.toString(cm.getNumeroTotalJugadores()));
                rangoEdadCategoriaMayores.setText(cm.getRangoEdad());
            }
            
            
            rs = st.executeQuery("SELECT * FROM torneo");
            
            while(rs.next()){
                torneo = new Torneo(rs.getString("nombre"), 4, 32, cj, cm);
            }
            
            if(torneo != null) {
                nombreTorneo.setText(torneo.getNombre());
                numeroDeEquiposTorneo.setText(Integer.toString(torneo.getNumeroDeEquipos()));
                numeroTotalJugadoresTorneo.setText(Integer.toString(torneo.getNumeroTotalJugadores()));
            }
            
            
            rs = st.executeQuery("SELECT * FROM equipos");
            
            while(rs.next()){
                equipo = new Equipo(rs.getString("nombre"), 8, "Categoria Juvenil", jugadores, rs.getString("rutaImg"), rs.getInt("numeroAficionados"), rs.getFloat("victorias") , rs.getFloat("derrotas"));
                
                if(rs.getInt("id") > 2){
                    equipo.setCategoria("Categoria Mayores");
                }
                
                String[] info = new String[6];
                info[0] = equipo.getNombre();
                info[1] = Integer.toString(equipo.getNumeroTotalJugadores());
                info[2] = equipo.getCategoria();
                info[3] = Integer.toString(equipo.getNumeroAficionados());
                info[4] = Double.toString(equipo.getVictorias()) ;
                info[5] = Double.toString(equipo.getDerrotas());
                
                modeloEquipos.addRow(info);
            }
            
            rs = st.executeQuery("SELECT * FROM jugadores");
            
            while(rs.next()){
                jugador = new Jugador(rs.getString("nombre"), rs.getInt("edad"), "", "");
                
                if(rs.getInt("id") < 9){
                    jugador.setEquipoAlQuePertenece("Tigres");
                }else if(rs.getInt("id") > 8 && rs.getInt("id") < 17){
                    jugador.setEquipoAlQuePertenece("Bulls");
                }else if(rs.getInt("id") > 16 && rs.getInt("id") < 25){
                    jugador.setEquipoAlQuePertenece("Dueños del campo");
                }else if(rs.getInt("id") > 24){
                    jugador.setEquipoAlQuePertenece("Equipo CUN");
                }
                
                String[] info = new String[3];
                info[0] = jugador.getNombre();
                info[1] = Integer.toString(jugador.getEdad());
                info[2] = jugador.getEquipoAlQuePertenece();
                
                modeloJugadores.addRow(info);
            }
            
            

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        nombreTorneo = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        numeroDeEquiposTorneo = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        numeroTotalJugadoresTorneo = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        nombreCategoriaJuvenil = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        numeroEquiposCategoriaJuvenil = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        numeroTotalJugadoresCategoriaJuvenil = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        rangoEdadCategoriaJuvenil = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        nombreCategoriaMayores = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        numeroEquiposCategoriaMayores = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        numeroTotalJugadoresCategoriaMayores = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        rangoEdadCategoriaMayores = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaEquipos = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaJugadores = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Torneo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(359, 359, 359))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 16)); // NOI18N
        jLabel2.setText("Datos torneo");

        jPanel4.setBackground(new java.awt.Color(184, 212, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.gray));

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        jLabel4.setText("Torneo");

        nombreTorneo.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        nombreTorneo.setText("\"\"");

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        jLabel5.setText("Numero de equipos");

        numeroDeEquiposTorneo.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        numeroDeEquiposTorneo.setText("\"\"");

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        jLabel6.setText("Numero total de jugadores");

        numeroTotalJugadoresTorneo.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        numeroTotalJugadoresTorneo.setText("\"\"");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator3)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(numeroTotalJugadoresTorneo)
                .addGap(147, 147, 147))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(337, 337, 337))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nombreTorneo)
                .addGap(147, 147, 147))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(numeroDeEquiposTorneo)
                .addGap(147, 147, 147))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nombreTorneo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(numeroDeEquiposTorneo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(numeroTotalJugadoresTorneo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(205, 255, 230));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.gray));

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        jLabel7.setText("Categoria Juvenil");

        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        jLabel8.setText("Nombre");

        nombreCategoriaJuvenil.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        nombreCategoriaJuvenil.setText("\"\"");

        jLabel11.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        jLabel11.setText("Numero de equipos");

        numeroEquiposCategoriaJuvenil.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        numeroEquiposCategoriaJuvenil.setText("\"\"");

        jLabel13.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        jLabel13.setText("Numero total de jugadores");

        numeroTotalJugadoresCategoriaJuvenil.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        numeroTotalJugadoresCategoriaJuvenil.setText("\"\"");

        jLabel15.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        jLabel15.setText("Rango de edad");

        rangoEdadCategoriaJuvenil.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        rangoEdadCategoriaJuvenil.setText("\"\"");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4)
            .addComponent(jSeparator6)
            .addComponent(jSeparator8)
            .addComponent(jSeparator10)
            .addComponent(jSeparator12, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nombreCategoriaJuvenil))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(numeroEquiposCategoriaJuvenil))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                        .addComponent(numeroTotalJugadoresCategoriaJuvenil))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rangoEdadCategoriaJuvenil)))
                .addGap(51, 51, 51))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(nombreCategoriaJuvenil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(numeroEquiposCategoriaJuvenil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(numeroTotalJugadoresCategoriaJuvenil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(rangoEdadCategoriaJuvenil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setBackground(new java.awt.Color(205, 255, 230));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.gray));

        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        jLabel9.setText("Categoria Mayores");

        nombreCategoriaMayores.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        nombreCategoriaMayores.setText("\"\"");

        jLabel10.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        jLabel10.setText("Nombre");

        jLabel12.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        jLabel12.setText("Numero de equipos");

        numeroEquiposCategoriaMayores.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        numeroEquiposCategoriaMayores.setText("\"\"");

        jLabel14.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        jLabel14.setText("Numero total de jugadores");

        numeroTotalJugadoresCategoriaMayores.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        numeroTotalJugadoresCategoriaMayores.setText("\"\"");

        jLabel16.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        jLabel16.setText("Rango de edad");

        rangoEdadCategoriaMayores.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        rangoEdadCategoriaMayores.setText("\"\"");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator5)
            .addComponent(jSeparator7)
            .addComponent(jSeparator9)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nombreCategoriaMayores)
                .addGap(48, 48, 48))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(numeroEquiposCategoriaMayores)
                .addGap(47, 47, 47))
            .addComponent(jSeparator11)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addComponent(numeroTotalJugadoresCategoriaMayores)
                .addGap(47, 47, 47))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rangoEdadCategoriaMayores)
                .addGap(46, 46, 46))
            .addComponent(jSeparator13, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(nombreCategoriaMayores))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(numeroEquiposCategoriaMayores))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(numeroTotalJugadoresCategoriaMayores))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(rangoEdadCategoriaMayores))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel17.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        jLabel17.setText("Equipos");

        tablaEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tablaEquipos);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(330, 330, 330))
            .addComponent(jScrollPane3)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(342, 342, 342))
        );

        jLabel18.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        jLabel18.setText("Jugadores");

        tablaJugadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaJugadores);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(633, 633, 633))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel nombreCategoriaJuvenil;
    private javax.swing.JLabel nombreCategoriaMayores;
    private javax.swing.JLabel nombreTorneo;
    private javax.swing.JLabel numeroDeEquiposTorneo;
    private javax.swing.JLabel numeroEquiposCategoriaJuvenil;
    private javax.swing.JLabel numeroEquiposCategoriaMayores;
    private javax.swing.JLabel numeroTotalJugadoresCategoriaJuvenil;
    private javax.swing.JLabel numeroTotalJugadoresCategoriaMayores;
    private javax.swing.JLabel numeroTotalJugadoresTorneo;
    private javax.swing.JLabel rangoEdadCategoriaJuvenil;
    private javax.swing.JLabel rangoEdadCategoriaMayores;
    private javax.swing.JTable tablaEquipos;
    private javax.swing.JTable tablaJugadores;
    // End of variables declaration//GEN-END:variables
}
