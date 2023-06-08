/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reposicion_lab5p2;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lourdes
 */
public class Empresa_Constructora extends javax.swing.JFrame {

    private List<String[]> data;

    private DefaultTableModel residencialModel;
    private DefaultTableModel villaModel;

    /**
     * Creates new form Empresa_Constructora
     */
    public Empresa_Constructora() {
        initComponents();

        residencialModel = new DefaultTableModel();
        residencialModel.addColumn("NOMBRE");
        residencialModel.addColumn("AÑO DE FUNDACION");

        // Crear la lista de datos y agregar algunos datos de ejemplo
        data = new ArrayList<>();

        // Agregar los datos al modelo de la tabla
        for (String[] row : data) {
            residencialModel.addRow(row);
        }
        villaModel = new DefaultTableModel();
        villaModel.addColumn("NOMBRE");
        villaModel.addColumn("RESIDENCIAL DE P.");
        villaModel.addColumn("CAPACIDAD DE LOTES");
        villaModel.addColumn("SEGURIDAD 24 HRS");

        // Crear la lista de datos y agregar algunos datos de ejemplo
        data = new ArrayList<>();

        // Agregar los datos al modelo de la tabla
        for (String[] row : data) {
            villaModel.addRow(row);
        }

        LISTA_RESIDENCIALES.setModel(residencialModel);
        // Configurar el KeyListener para el campo de edición
        Name_Residenciales.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Obtener la residencial seleccionada
                    Residencial residencial = getResidencialSeleccionada();
                    if (residencial != null) {
                        // Obtener los nuevos valores editados
                        String nuevoNombre = Name_Residenciales.getText();
                        int nuevoAnioFundacion = Año_Fundacion.getYear();

                        // Actualizar los valores en la tabla y en el objeto de la residencial
                        int filaSeleccionada = LISTA_RESIDENCIALES.getSelectedRow();
                        residencialModel.setValueAt(nuevoNombre, filaSeleccionada, 0);
                        residencialModel.setValueAt(nuevoAnioFundacion, filaSeleccionada, 1);
                        residencial.setNombre(nuevoNombre);
                        residencial.setAñoFundacion(nuevoAnioFundacion);

                        // Limpiar los campos de edición
                        Name_Residenciales.setText("");
                        Año_Fundacion.setYear(Calendar.getInstance().get(Calendar.YEAR));

                        // Mostrar mensaje de éxito
                        JOptionPane.showMessageDialog(null, "Residencial editada exitosamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "Selecciona una fila para editar", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Obtener la villa seleccionada
        Tabla_Villas.setModel(villaModel);
        // Configurar el KeyListener para el campo de edición de nombre de villa
        NombreVilla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    Villa villa = getVillaSeleccionada();
                    if (villa != null) {
                        // Obtener los nuevos valores editados
                        String nuevoNombre = NombreVilla.getText();
                        String residencialActual = villa.getResidencial();
                        int capacidadLotesActual = villa.getCapacidadLotes();
                        String seguridadActual = villa.getSeguridad24Horas();

                        // Actualizar los valores en la tabla y en el objeto de la villa
                        int filaSeleccionada = Tabla_Villas.getSelectedRow();
                        villaModel.setValueAt(nuevoNombre, filaSeleccionada, 0);
                        villaModel.setValueAt(residencialActual, filaSeleccionada, 1);
                        villaModel.setValueAt(capacidadLotesActual, filaSeleccionada, 2);
                        villaModel.setValueAt(seguridadActual, filaSeleccionada, 3);
                        villa.setNombre(nuevoNombre);
                        villa.setResidencial(residencialActual);
                        villa.setCapacidadLotes(capacidadLotesActual);
                        villa.setSeguridad24Horas(seguridadActual);

                        // Limpiar el campo de edición
                        NombreVilla.setText("");
                        

                        // Mostrar mensaje de éxito
                        JOptionPane.showMessageDialog(null, "Villa editada exitosamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "Selecciona una fila para editar", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
   

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        RESIDENCIALES = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        LISTA_RESIDENCIALES = new javax.swing.JTable();
        EDITAR_RESIDENCIALES = new javax.swing.JButton();
        ELIMINAR_RESIDENCIAL = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Name_Residenciales = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Año_Fundacion = new com.toedter.calendar.JYearChooser();
        CREAR_RESIDENCIALES = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        VILLAS = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        NombreVilla = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        CapacidadLotes = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        comboBoxSeguridad24Hr = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tabla_Villas = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        EDITAR_VILLA = new javax.swing.JButton();
        ELIMIAR_VILLA = new javax.swing.JButton();
        CREAR_VILLA = new javax.swing.JButton();
        ResidencialPertenencia = new javax.swing.JTextField();
        LOTES = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        jSpinner6 = new javax.swing.JSpinner();
        COLOR_LOTES2 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jSpinner7 = new javax.swing.JSpinner();
        jSpinner8 = new javax.swing.JSpinner();
        jLabel27 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jList6 = new javax.swing.JList<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        jSpinner9 = new javax.swing.JSpinner();
        COLOR_LOTES3 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jSpinner10 = new javax.swing.JSpinner();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jList5 = new javax.swing.JList<>();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jSpinner3 = new javax.swing.JSpinner();
        COLOR_LOTES1 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList<>();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jSpinner2 = new javax.swing.JSpinner();
        jSpinner4 = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LISTA_RESIDENCIALES.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "NOMBRE", "AÑO DE FUNDACION"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        LISTA_RESIDENCIALES.setSelectionBackground(new java.awt.Color(0, 204, 51));
        jScrollPane1.setViewportView(LISTA_RESIDENCIALES);
        if (LISTA_RESIDENCIALES.getColumnModel().getColumnCount() > 0) {
            LISTA_RESIDENCIALES.getColumnModel().getColumn(0).setResizable(false);
            LISTA_RESIDENCIALES.getColumnModel().getColumn(1).setResizable(false);
        }

        EDITAR_RESIDENCIALES.setText("EDITAR");
        EDITAR_RESIDENCIALES.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EDITAR_RESIDENCIALESMouseClicked(evt);
            }
        });
        EDITAR_RESIDENCIALES.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EDITAR_RESIDENCIALESKeyPressed(evt);
            }
        });

        ELIMINAR_RESIDENCIAL.setText("ELIMINAR");
        ELIMINAR_RESIDENCIAL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ELIMINAR_RESIDENCIALMouseClicked(evt);
            }
        });

        jLabel1.setText("Nombre");

        Name_Residenciales.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Name_ResidencialesKeyPressed(evt);
            }
        });

        jLabel2.setText("Año de fundacion");

        Año_Fundacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Año_FundacionKeyPressed(evt);
            }
        });

        CREAR_RESIDENCIALES.setText("CREAR");
        CREAR_RESIDENCIALES.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CREAR_RESIDENCIALESMouseClicked(evt);
            }
        });

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jList1);

        jScrollPane3.setViewportView(jList2);

        jLabel3.setText("VILLAS");

        jLabel4.setText("LOTES");

        javax.swing.GroupLayout RESIDENCIALESLayout = new javax.swing.GroupLayout(RESIDENCIALES);
        RESIDENCIALES.setLayout(RESIDENCIALESLayout);
        RESIDENCIALESLayout.setHorizontalGroup(
            RESIDENCIALESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RESIDENCIALESLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(RESIDENCIALESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RESIDENCIALESLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(RESIDENCIALESLayout.createSequentialGroup()
                        .addGroup(RESIDENCIALESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(RESIDENCIALESLayout.createSequentialGroup()
                                .addGroup(RESIDENCIALESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(Name_Residenciales, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addGroup(RESIDENCIALESLayout.createSequentialGroup()
                                        .addGroup(RESIDENCIALESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(Año_Fundacion, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(58, 58, 58)
                                        .addComponent(CREAR_RESIDENCIALES, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RESIDENCIALESLayout.createSequentialGroup()
                                .addGroup(RESIDENCIALESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(144, 144, 144)))
                        .addGroup(RESIDENCIALESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(RESIDENCIALESLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51))
                            .addGroup(RESIDENCIALESLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(EDITAR_RESIDENCIALES, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ELIMINAR_RESIDENCIAL, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77))))))
        );
        RESIDENCIALESLayout.setVerticalGroup(
            RESIDENCIALESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RESIDENCIALESLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(RESIDENCIALESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(RESIDENCIALESLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(RESIDENCIALESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(RESIDENCIALESLayout.createSequentialGroup()
                                .addComponent(Name_Residenciales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Año_Fundacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(CREAR_RESIDENCIALES, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addComponent(jLabel4)
                .addGroup(RESIDENCIALESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RESIDENCIALESLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 63, Short.MAX_VALUE))
                    .addGroup(RESIDENCIALESLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(RESIDENCIALESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EDITAR_RESIDENCIALES, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ELIMINAR_RESIDENCIAL, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("RESIDENCIALES", RESIDENCIALES);

        jLabel5.setText("Nombre");

        NombreVilla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NombreVillaKeyPressed(evt);
            }
        });

        jLabel6.setText("Residencial de Pertenencia");

        jLabel7.setText("Capacidad de Lotes Totales");

        CapacidadLotes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CapacidadLotesKeyPressed(evt);
            }
        });

        jLabel8.setText("Seguridad 24 Hrs");

        comboBoxSeguridad24Hr.setMaximumRowCount(2);
        comboBoxSeguridad24Hr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));
        comboBoxSeguridad24Hr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboBoxSeguridad24HrKeyPressed(evt);
            }
        });

        Tabla_Villas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "RESIDENCIAL DE P.", "CAPACIDAD LOTES", "SEGURIDAD 24 Hrs"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(Tabla_Villas);

        jLabel9.setText("RESIDENCIALES");

        jList3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane5.setViewportView(jList3);

        EDITAR_VILLA.setText("EDITAR");
        EDITAR_VILLA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EDITAR_VILLAMouseClicked(evt);
            }
        });

        ELIMIAR_VILLA.setText("ELIMINAR");
        ELIMIAR_VILLA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ELIMIAR_VILLAMouseClicked(evt);
            }
        });

        CREAR_VILLA.setText("CREAR");
        CREAR_VILLA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CREAR_VILLAMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout VILLASLayout = new javax.swing.GroupLayout(VILLAS);
        VILLAS.setLayout(VILLASLayout);
        VILLASLayout.setHorizontalGroup(
            VILLASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VILLASLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(VILLASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VILLASLayout.createSequentialGroup()
                        .addGroup(VILLASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(VILLASLayout.createSequentialGroup()
                                .addGroup(VILLASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(VILLASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel5)
                                        .addComponent(NombreVilla, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                        .addComponent(CapacidadLotes, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                    .addComponent(ResidencialPertenencia, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(100, 100, 100)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9))
                        .addContainerGap(45, Short.MAX_VALUE))
                    .addGroup(VILLASLayout.createSequentialGroup()
                        .addGroup(VILLASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(comboBoxSeguridad24Hr, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37)
                        .addComponent(CREAR_VILLA, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118)
                        .addComponent(EDITAR_VILLA, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ELIMIAR_VILLA, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))))
        );
        VILLASLayout.setVerticalGroup(
            VILLASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VILLASLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(VILLASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(VILLASLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(NombreVilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(ResidencialPertenencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CapacidadLotes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(VILLASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VILLASLayout.createSequentialGroup()
                        .addComponent(comboBoxSeguridad24Hr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addGroup(VILLASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EDITAR_VILLA, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ELIMIAR_VILLA, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11))
                    .addGroup(VILLASLayout.createSequentialGroup()
                        .addComponent(CREAR_VILLA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        jTabbedPane1.addTab("VILLAS", VILLAS);

        jLabel21.setText("Codigo:  ");

        jLabel22.setText("(Comenzar su Codigo con AP)");

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel23.setText("Nombre");

        jLabel24.setText("Villa de Pertenencia");

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel25.setText("Pisos");

        COLOR_LOTES2.setText("COLOR");
        COLOR_LOTES2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                COLOR_LOTES2ActionPerformed(evt);
            }
        });

        jLabel26.setText("Cuartos Familiares:");

        jLabel27.setText("Cuartos Personales:");

        jLabel36.setText("VILLAS");

        jList6.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane8.setViewportView(jList6);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NOMBRE", "RESIDENCIAL DE P.", "CAPACIDAD LOTES", "SEGURIDAD 24 Hrs"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(jTable3);

        jButton7.setText("CREAR");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });

        jButton8.setText("ELIMINAR");

        jButton9.setText("EDITAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel26)
                                            .addComponent(jSpinner7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(29, 29, 29)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel27)
                                            .addComponent(jSpinner8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(61, 61, 61)
                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel36)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))))
                        .addGap(330, 330, 330))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jSpinner6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(COLOR_LOTES2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel21)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel22)))
                            .addComponent(jLabel24)
                            .addComponent(jLabel23)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(128, 128, 128)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel22))
                                .addGap(18, 18, 18)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel24)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addComponent(jLabel25)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinner6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(COLOR_LOTES2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("APARTAMENTOS", jPanel1);

        jLabel28.setText("Codigo:  ");

        jLabel29.setText("(Comenzar su Codigo con CS)");

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jLabel30.setText("Nombre");

        jLabel31.setText("Villa de Pertenencia");

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel32.setText("Pisos");

        COLOR_LOTES3.setText("COLOR");
        COLOR_LOTES3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                COLOR_LOTES3ActionPerformed(evt);
            }
        });

        jLabel33.setText("Cuartos Personales:");

        jLabel35.setText("VILLAS");

        jList5.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane7.setViewportView(jList5);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NOMBRE", "RESIDENCIAL DE P.", "CAPACIDAD LOTES", "SEGURIDAD 24 Hrs"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane10.setViewportView(jTable4);

        jButton10.setText("EDITAR");

        jButton11.setText("ELIMINAR");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinner10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                        .addGap(443, 443, 443))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addComponent(jLabel31)
                            .addComponent(jLabel30)
                            .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner9, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel29))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(COLOR_LOTES3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(128, 128, 128)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)))
                        .addGap(36, 36, 36))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29))
                        .addGap(18, 18, 18)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel30)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel31)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel32)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinner9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(COLOR_LOTES3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(69, 69, 69))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinner10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("CASAS", jPanel4);

        LOTES.addTab("HABITABLES", jTabbedPane2);

        jLabel14.setText("Codigo:  ");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel15.setText("Nombre");

        jLabel16.setText("Villa de Pertenencia");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel17.setText("Pisos");

        COLOR_LOTES1.setText("COLOR DE LOTE");
        COLOR_LOTES1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                COLOR_LOTES1ActionPerformed(evt);
            }
        });

        jLabel18.setText("Hora Apertura:");

        jLabel19.setText("Hora Cierre:");

        jLabel20.setText("(Comenzar su Codigo con NG)");

        jLabel34.setText("VILLAS");

        jList4.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane6.setViewportView(jList4);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NOMBRE", "RESIDENCIAL DE P.", "CAPACIDAD LOTES", "SEGURIDAD 24 Hrs"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane11.setViewportView(jTable5);

        jButton12.setText("EDITAR");

        jButton13.setText("ELIMINAR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(COLOR_LOTES1)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel18)
                                            .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(31, 31, 31)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jSpinner4))))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel34)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))))
                        .addGap(379, 379, 379))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(128, 128, 128)
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)))
                        .addGap(62, 62, 62))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel20))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(COLOR_LOTES1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(69, 69, 69))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        LOTES.addTab("NEGOCIOS", jPanel2);

        jTabbedPane1.addTab("LOTES", LOTES);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void COLOR_LOTES1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_COLOR_LOTES1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_COLOR_LOTES1ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void COLOR_LOTES2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_COLOR_LOTES2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_COLOR_LOTES2ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void COLOR_LOTES3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_COLOR_LOTES3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_COLOR_LOTES3ActionPerformed

    private void CREAR_RESIDENCIALESMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CREAR_RESIDENCIALESMouseClicked
        // TODO add your handling code here:
        Residencial r = new Residencial((String) Name_Residenciales.getText(), (Integer) Año_Fundacion.getValue());
        residencial.add(r);
        String nombreResidecial = Name_Residenciales.getText();

        // Validar que se haya ingresado un nombre de residecial
        if (nombreResidecial.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el nombre de la Residencial", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this, "Creado Exitosamente!");

        int Año = (Integer) Año_Fundacion.getValue();
        String Nombre_Residencial = Name_Residenciales.getText();

        // Crea una lista para almacenar los datos ingresados
        data = new ArrayList<>();
        // Agrega los datos a la lista
        String[] rowData = {String.valueOf(Nombre_Residencial), String.valueOf(Año)};
        data.add(rowData);

        // Agrega los datos a la tabla
        residencialModel.addRow(rowData);

        // Limpia los campos de texto después de guardar los datos
        Name_Residenciales.setText("  ");


    }//GEN-LAST:event_CREAR_RESIDENCIALESMouseClicked

    private void ELIMINAR_RESIDENCIALMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ELIMINAR_RESIDENCIALMouseClicked
        int filaSeleccionada = LISTA_RESIDENCIALES.getSelectedRow();
        if (filaSeleccionada != -1) {
            int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar esta Residencial?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                residencialModel.removeRow(filaSeleccionada);
                residencial.remove(filaSeleccionada);
                JOptionPane.showMessageDialog(this, "Residencial eliminada exitosamente");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ELIMINAR_RESIDENCIALMouseClicked

    private Villa getVillaSeleccionada() {
        int filaSeleccionada = Tabla_Villas.getSelectedRow();
        if (filaSeleccionada != -1) {
            String nombre = (String) Tabla_Villas.getValueAt(filaSeleccionada, 0);
            String Residencial = (String) Tabla_Villas.getValueAt(filaSeleccionada, 1);
            // Aquí debes obtener el resto de los valores de la villa (capacidad de lotes y seguridad 24 hrs)
            // Puedes utilizar los métodos getValueAt() para obtener los valores de las otras columnas
            int capacidadLotes = (int) Tabla_Villas.getValueAt(filaSeleccionada, 2);
            String seguridad24Hrs = (String) Tabla_Villas.getValueAt(filaSeleccionada, 3);

            // Crear y devolver el objeto de la villa seleccionada
            return new Villa(nombre, Residencial, capacidadLotes, seguridad24Hrs);
        }
        return null;
    }

    // Método para obtener la residencial seleccionada de la tabla
    private Residencial getResidencialSeleccionada() {
        int filaSeleccionada = LISTA_RESIDENCIALES.getSelectedRow();
        if (filaSeleccionada != -1) {
            // Obtener los valores de la fila seleccionada en la tabla
            String nombre = residencialModel.getValueAt(filaSeleccionada, 0).toString();
            int anioFundacion = Integer.parseInt(residencialModel.getValueAt(filaSeleccionada, 1).toString());

            // Buscar la residencial en la lista según los valores obtenidos
            for (Residencial residencial : residencial) {
                if (residencial.getNombre().equals(nombre) && residencial.getAñoFundacion() == anioFundacion) {
                    return residencial;
                }
            }
        }
        return null;
    }
    // Método para validar si el nombre de residencial ingresado es válido

    private boolean esResidencialExistente(String nombreResidencial) {
        // Aquí debes implementar la lógica para comprobar si el nombre de residencial existe
        // Puedes utilizar una lista o una estructura de datos para almacenar los nombres de las residenciales existentes
        // y luego verificar si el nombre ingresado está en esa lista

        // Ejemplo de validación
        for (Residencial r : residencial) {
            if (r.getNombre().equals(nombreResidencial)) {
                return true;
            }
        }
        return false;
    }
    private void CREAR_VILLAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CREAR_VILLAMouseClicked
        // Obtener los valores ingresados por el usuario
        String nombreVilla = NombreVilla.getText();
        String residencialPertenencia = ResidencialPertenencia.getText();
        int capacidadLotes = (int) CapacidadLotes.getValue();
        String seguridad24Hr = comboBoxSeguridad24Hr.getSelectedItem().toString();

        // Validar que se haya ingresado un nombre de villa
        if (nombreVilla.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el nombre de la villa", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar que se haya ingresado un nombre de residencial
        if (residencialPertenencia.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el nombre de la residencial de pertenencia", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Validar que el nombre de residencial ingresado sea válido
        if (!esResidencialExistente(residencialPertenencia)) {
            JOptionPane.showMessageDialog(this, "El nombre de residencial ingresado no existe", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear la villa con los valores ingresados
        Villa villa = new Villa(nombreVilla, residencialPertenencia, capacidadLotes, seguridad24Hr);

        DefaultTableModel model = (DefaultTableModel) Tabla_Villas.getModel();
        model.addRow(new Object[]{villa.getNombre(), villa.getResidencial(), villa.getCapacidadLotes(), villa.getSeguridad24Horas()});

        // Mostrar mensaje de éxito
        JOptionPane.showMessageDialog(this, "Villa creada exitosamente");

        // Limpiar los campos de entrada
        NombreVilla.setText("");
        ResidencialPertenencia.setText("");
        CapacidadLotes.setValue(0);
        comboBoxSeguridad24Hr.setSelectedIndex(0);

    }//GEN-LAST:event_CREAR_VILLAMouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        Residencial r = new Residencial((String) Name_Residenciales.getText(), (Integer) Año_Fundacion.getValue());
        residencial.add(r);
        JOptionPane.showMessageDialog(this, "Creado Exitosamente!");

        int Año = (Integer) Año_Fundacion.getValue();
        String Nombre_Residencial = Name_Residenciales.getText();

        // Crea una lista para almacenar los datos ingresados
        data = new ArrayList<>();
        // Agrega los datos a la lista
        String[] rowData = {String.valueOf(Nombre_Residencial), String.valueOf(Año)};
        data.add(rowData);

        // Agrega los datos a la tabla
        residencialModel.addRow(rowData);

        // Limpia los campos de texto después de guardar los datos
        Name_Residenciales.setText("  ");

    }//GEN-LAST:event_jButton7MouseClicked

    private void EDITAR_RESIDENCIALESKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EDITAR_RESIDENCIALESKeyPressed


    }//GEN-LAST:event_EDITAR_RESIDENCIALESKeyPressed

    private void EDITAR_RESIDENCIALESMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EDITAR_RESIDENCIALESMouseClicked
        Residencial residencial = getResidencialSeleccionada();
        if (residencial != null) {
            // Obtén los valores actuales de la residencial seleccionada
            String nombreActual = residencial.getNombre();
            int anioFundacionActual = residencial.getAñoFundacion();

            // Mostrar los valores actuales en los campos de edición
            Name_Residenciales.setText(nombreActual);
            Año_Fundacion.setYear(anioFundacionActual);

            // Aquí puedes agregar la lógica necesaria para mostrar los campos de edición en tu JFrame
            // Puedes utilizar el método setVisible(true) para mostrar los componentes
            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(this, "Residencial lista para editar");
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para editar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_EDITAR_RESIDENCIALESMouseClicked

    private void Name_ResidencialesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Name_ResidencialesKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Name_ResidencialesKeyPressed

    private void Año_FundacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Año_FundacionKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Año_FundacionKeyPressed

    private void EDITAR_VILLAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EDITAR_VILLAMouseClicked
        Villa villa = getVillaSeleccionada();
        if (villa != null) {
            // Obtener los valores actuales de la villa seleccionada
            String nombreActual = villa.getNombre();
            String residencialActual = villa.getResidencial();
            int capacidadLotesActual = villa.getCapacidadLotes();
            String seguridadActual = villa.getSeguridad24Horas();

            // Mostrar los valores actuales en los campos de edición
            NombreVilla.setText(nombreActual);
            CapacidadLotes.setValue(capacidadLotesActual);
            comboBoxSeguridad24Hr.setSelectedItem(seguridadActual);

            // Aquí puedes agregar la lógica necesaria para mostrar los campos de edición en tu JFrame
            // Puedes utilizar el método setVisible(true) para mostrar los componentes
            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(null, "Villa lista para editar");
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una fila para editar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_EDITAR_VILLAMouseClicked

    private void NombreVillaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombreVillaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreVillaKeyPressed

    private void CapacidadLotesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CapacidadLotesKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_CapacidadLotesKeyPressed

    private void comboBoxSeguridad24HrKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboBoxSeguridad24HrKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxSeguridad24HrKeyPressed

    private void ELIMIAR_VILLAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ELIMIAR_VILLAMouseClicked
        // TODO add your handling code here:
        int filaSeleccionada = Tabla_Villas.getSelectedRow();
        if (filaSeleccionada != -1) {
            int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar esta Villa?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                villaModel.removeRow(filaSeleccionada);
                villa.remove(filaSeleccionada);
                JOptionPane.showMessageDialog(this, "Villa eliminada exitosamente");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ELIMIAR_VILLAMouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Empresa_Constructora.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Empresa_Constructora.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Empresa_Constructora.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Empresa_Constructora.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Empresa_Constructora().setVisible(true);
            }
        });
    }

    ArrayList<Residencial> residencial = new ArrayList();
    ArrayList<Villa> villa = new ArrayList();
    ArrayList<Lote> lotes = new ArrayList();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JYearChooser Año_Fundacion;
    private javax.swing.JButton COLOR_LOTES1;
    private javax.swing.JButton COLOR_LOTES2;
    private javax.swing.JButton COLOR_LOTES3;
    private javax.swing.JButton CREAR_RESIDENCIALES;
    private javax.swing.JButton CREAR_VILLA;
    private javax.swing.JSpinner CapacidadLotes;
    private javax.swing.JButton EDITAR_RESIDENCIALES;
    private javax.swing.JButton EDITAR_VILLA;
    private javax.swing.JButton ELIMIAR_VILLA;
    private javax.swing.JButton ELIMINAR_RESIDENCIAL;
    private javax.swing.JTable LISTA_RESIDENCIALES;
    private javax.swing.JTabbedPane LOTES;
    private javax.swing.JTextField Name_Residenciales;
    private javax.swing.JTextField NombreVilla;
    private javax.swing.JPanel RESIDENCIALES;
    private javax.swing.JTextField ResidencialPertenencia;
    private javax.swing.JTable Tabla_Villas;
    private javax.swing.JPanel VILLAS;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboBoxSeguridad24Hr;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JList<String> jList4;
    private javax.swing.JList<String> jList5;
    private javax.swing.JList<String> jList6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSpinner jSpinner10;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JSpinner jSpinner6;
    private javax.swing.JSpinner jSpinner7;
    private javax.swing.JSpinner jSpinner8;
    private javax.swing.JSpinner jSpinner9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
