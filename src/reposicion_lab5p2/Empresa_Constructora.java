/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reposicion_lab5p2;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lourdes
 */
public class Empresa_Constructora extends javax.swing.JFrame {

    private List<String[]> data;

    private DefaultTableModel residencialModel;
    private DefaultTableModel villaModel;
    private DefaultTableModel apartamentoModel;
    private DefaultTableModel casasModel;
    private DefaultTableModel negocioModel;
    private JSpinner spinnerHoraApertura;
    private JSpinner spinnerHoraCierre;


    /**
     * Creates new form Empresa_Constructora
     */
    public Empresa_Constructora() {
        initComponents();

         initializeSpinners();
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
        apartamentoModel = new DefaultTableModel();
        apartamentoModel.addColumn("CODIGO");
        apartamentoModel.addColumn("VILLA DE P.");
        apartamentoModel.addColumn("PISOS");
        apartamentoModel.addColumn("CUARTOS FAM");
        apartamentoModel.addColumn("CUARTOS PERS.");

        // Crear la lista de datos y agregar algunos datos de ejemplo
        data = new ArrayList<>();

        // Agregar los datos al modelo de la tabla
        for (String[] row : data) {
            apartamentoModel.addRow(row);
        }

        casasModel = new DefaultTableModel();
        casasModel.addColumn("CODIGO");
        casasModel.addColumn("VILLA DE P.");
        casasModel.addColumn("PISOS");
        casasModel.addColumn("CUARTOS PERS.");
        data = new ArrayList<>();

        // Agregar los datos al modelo de la tabla
        for (String[] row : data) {
            casasModel.addRow(row);
        }

        negocioModel = new DefaultTableModel();
        negocioModel.addColumn("CODIGO");
        negocioModel.addColumn("VILLA DE P.");
        negocioModel.addColumn("PISOS");
        negocioModel.addColumn("Hora Apertura");
        negocioModel.addColumn("Hora Cierre");
        data = new ArrayList<>();

        // Agregar los datos al modelo de la tabla
        for (String[] row : data) {
            negocioModel.addRow(row);
        }
        LISTA_NEGOCIO.setModel(negocioModel);
        LISTA_CASAS.setModel(casasModel);
        LISTA_APARTAMENTOS.setModel(apartamentoModel);
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
        // Configurar el KeyListener para el campo de edición de nombre de villa
        NombreVilla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    Villa villa = getVillaSeleccionada();
                    if (villa != null) {
                        // Obtener los nuevos valores editados
                        String nuevoNombre = NombreVilla.getText();
                        int capacidadLotesActual = (int) CapacidadLotes.getValue();
                        String seguridadActual = (String) comboBoxSeguridad24Hr.getSelectedItem();

                        // Actualizar los valores en la tabla y en el objeto de la villa
                        int filaSeleccionada = Tabla_Villas.getSelectedRow();
                        villaModel.setValueAt(nuevoNombre, filaSeleccionada, 0);
                        villaModel.setValueAt(capacidadLotesActual, filaSeleccionada, 2);
                        villaModel.setValueAt(seguridadActual, filaSeleccionada, 3);
                        villa.setNombre(nuevoNombre);
                        villa.setCapacidadLotes(String.valueOf(capacidadLotesActual));
                        villa.setSeguridad24Horas(seguridadActual);

                        // Limpiar el campo de edición
                        NombreVilla.setText("");
                        ResidencialPertenencia.setText("");
                        CapacidadLotes.setValue(0);
                        comboBoxSeguridad24Hr.setSelectedIndex(0);

                        // Mostrar mensaje de éxito
                        JOptionPane.showMessageDialog(null, "Villa editada exitosamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "Selecciona una fila para editar", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        
        spinnerHoraApertura = new JSpinner(new SpinnerDateModel());
        spinnerHoraCierre = new JSpinner(new SpinnerDateModel());

        JSpinner.DateEditor horaAperturaEditor = new JSpinner.DateEditor(spinnerHoraApertura, "HH:mm");
        JSpinner.DateEditor horaCierreEditor = new JSpinner.DateEditor(spinnerHoraCierre, "HH:mm");
        spinnerHoraApertura.setEditor(horaAperturaEditor);
        spinnerHoraCierre.setEditor(horaCierreEditor);

    }
    private void initializeSpinners() {
        // Configurar los valores mínimos y máximos del JSpinner
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime horaMinima = LocalTime.parse("00:00", formatter);
        LocalTime horaMaxima = LocalTime.parse("23:59", formatter);

        SpinnerDateModel horaAperturaModel = (SpinnerDateModel) spinnerHoraApertura.getModel();
        horaAperturaModel.setStart(horaMinima);
        horaAperturaModel.setEnd(horaMaxima);

        SpinnerDateModel horaCierreModel = (SpinnerDateModel) spinnerHoraCierre.getModel();
        horaCierreModel.setStart(horaMinima);
        horaCierreModel.setEnd(horaMaxima);
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
        jLabel10 = new javax.swing.JLabel();
        LOTES = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        CodigoLote = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        CantidadPisos = new javax.swing.JSpinner();
        jLabel26 = new javax.swing.JLabel();
        CuartosFamiliares = new javax.swing.JSpinner();
        CuartosPersonales = new javax.swing.JSpinner();
        jLabel27 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jList6 = new javax.swing.JList<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        LISTA_APARTAMENTOS = new javax.swing.JTable();
        CREAR_APARTAMENTOS = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        VillaPertenencia = new javax.swing.JTextField();
        COLOR_ROPA = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        CODIGO_CASA = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        PISOS_CASA = new javax.swing.JSpinner();
        CasaColor = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        CUARTOS_P_CASA = new javax.swing.JSpinner();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jList5 = new javax.swing.JList<>();
        jScrollPane10 = new javax.swing.JScrollPane();
        LISTA_CASAS = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        VILLA_P_CASA = new javax.swing.JTextField();
        CREAR_CASAS = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        CODIGO_NEGOCIO = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        PISOS_NEGOCIOS = new javax.swing.JSpinner();
        COLOR_NEGOCIO = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList<>();
        jScrollPane11 = new javax.swing.JScrollPane();
        LISTA_NEGOCIO = new javax.swing.JTable();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        HR_APERTURA = new javax.swing.JSpinner();
        HR_CIERRE = new javax.swing.JSpinner();
        VILLA_P_NEGOCIOS = new javax.swing.JTextField();
        CREAR_NEGOCIO = new javax.swing.JButton();

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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE))
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
                        .addGap(0, 67, Short.MAX_VALUE))
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

        jLabel10.setText("(Dar ENTER en Nombre, para guardar los datos editados)");

        javax.swing.GroupLayout VILLASLayout = new javax.swing.GroupLayout(VILLAS);
        VILLAS.setLayout(VILLASLayout);
        VILLASLayout.setHorizontalGroup(
            VILLASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VILLASLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(VILLASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VILLASLayout.createSequentialGroup()
                        .addGroup(VILLASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(NombreVilla, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CapacidadLotes, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ResidencialPertenencia, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(100, 100, 100)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(65, Short.MAX_VALUE))
                    .addGroup(VILLASLayout.createSequentialGroup()
                        .addGroup(VILLASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(VILLASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGroup(VILLASLayout.createSequentialGroup()
                                    .addGroup(VILLASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(comboBoxSeguridad24Hr, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(37, 37, 37)
                                    .addComponent(CREAR_VILLA, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(VILLASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(VILLASLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(EDITAR_VILLA, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ELIMIAR_VILLA, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83))
                            .addGroup(VILLASLayout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel10)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
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
                    .addComponent(comboBoxSeguridad24Hr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CREAR_VILLA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(VILLASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VILLASLayout.createSequentialGroup()
                        .addGroup(VILLASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EDITAR_VILLA, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ELIMIAR_VILLA, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10))
                    .addGroup(VILLASLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(90, 90, 90))
        );

        jTabbedPane1.addTab("VILLAS", VILLAS);

        jLabel21.setText("Codigo:  ");

        jLabel22.setText("(Comenzar su Codigo con AP)");

        CodigoLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodigoLoteActionPerformed(evt);
            }
        });

        jLabel24.setText("Villa de Pertenencia");

        jLabel25.setText("Pisos");

        jLabel26.setText("Cuartos Familiares:");

        jLabel27.setText("Cuartos Personales:");

        jLabel36.setText("VILLAS");

        jList6.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane8.setViewportView(jList6);

        LISTA_APARTAMENTOS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "VILLA DE P.", "PISOS", "CUARTOS FAM", "CUARTOS PERS."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane9.setViewportView(LISTA_APARTAMENTOS);

        CREAR_APARTAMENTOS.setText("CREAR");
        CREAR_APARTAMENTOS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CREAR_APARTAMENTOSMouseClicked(evt);
            }
        });

        jButton8.setText("ELIMINAR");

        jButton9.setText("EDITAR");

        COLOR_ROPA.setText("Color");
        COLOR_ROPA.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        COLOR_ROPA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                COLOR_ROPAMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(CREAR_APARTAMENTOS, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                        .addGap(330, 330, 330))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(CodigoLote, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addComponent(CuartosFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27)
                                    .addComponent(CuartosPersonales, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel25)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel22))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(CantidadPisos, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(COLOR_ROPA, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(VillaPertenencia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(128, 128, 128)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 24, Short.MAX_VALUE)
                                .addComponent(CantidadPisos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel22))
                                .addGap(18, 18, 18)
                                .addComponent(CodigoLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel24)
                                .addGap(18, 18, 18)
                                .addComponent(VillaPertenencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel25)
                                        .addGap(38, 38, 38))
                                    .addComponent(COLOR_ROPA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CuartosPersonales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CuartosFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)))
                .addComponent(jLabel36)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CREAR_APARTAMENTOS, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("APARTAMENTOS", jPanel1);

        jLabel28.setText("Codigo:  ");

        jLabel29.setText("(Comenzar su Codigo con CS)");

        CODIGO_CASA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CODIGO_CASAActionPerformed(evt);
            }
        });

        jLabel31.setText("Villa de Pertenencia");

        jLabel32.setText("Pisos");

        CasaColor.setText("COLOR");
        CasaColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CasaColorActionPerformed(evt);
            }
        });

        jLabel33.setText("Cuartos Personales:");

        jLabel35.setText("VILLAS");

        jList5.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane7.setViewportView(jList5);

        LISTA_CASAS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "RESIDENCIAL DE P.", "CAPACIDAD LOTES", "SEGURIDAD 24 Hrs"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane10.setViewportView(LISTA_CASAS);

        jButton10.setText("EDITAR");

        jButton11.setText("ELIMINAR");

        CREAR_CASAS.setText("CREAR");
        CREAR_CASAS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CREAR_CASASMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(CODIGO_CASA, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel29))
                    .addComponent(VILLA_P_CASA, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addComponent(PISOS_CASA, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CUARTOS_P_CASA, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(CasaColor, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(CREAR_CASAS, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel35)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
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
                        .addComponent(CODIGO_CASA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel31)
                        .addGap(18, 18, 18)
                        .addComponent(VILLA_P_CASA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(jLabel33))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PISOS_CASA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CUARTOS_P_CASA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(CasaColor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addComponent(jLabel35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(CREAR_CASAS, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("CASAS", jPanel4);

        LOTES.addTab("HABITABLES", jTabbedPane2);

        jLabel14.setText("Codigo:  ");

        CODIGO_NEGOCIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CODIGO_NEGOCIOActionPerformed(evt);
            }
        });

        jLabel16.setText("Villa de Pertenencia");

        jLabel17.setText("Pisos");

        COLOR_NEGOCIO.setText("COLOR");
        COLOR_NEGOCIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                COLOR_NEGOCIOActionPerformed(evt);
            }
        });

        jLabel18.setText("Hora Apertura:");

        jLabel19.setText("Hora Cierre:");

        jLabel20.setText("(Comenzar su Codigo con NG)");

        jLabel34.setText("VILLAS");

        jList4.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane6.setViewportView(jList4);

        LISTA_NEGOCIO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "VILLA DE P.", "PISOS", "HORA ENTRADA", "HORA SALIDA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane11.setViewportView(LISTA_NEGOCIO);

        jButton12.setText("EDITAR");

        jButton13.setText("ELIMINAR");

        CREAR_NEGOCIO.setText("CREAR");
        CREAR_NEGOCIO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CREAR_NEGOCIOMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(jLabel34)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel16)
                                            .addComponent(CODIGO_NEGOCIO, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(34, 34, 34))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(CREAR_NEGOCIO, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(HR_APERTURA, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(HR_CIERRE, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel18)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel19))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel17)
                                                        .addComponent(PISOS_NEGOCIOS, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(COLOR_NEGOCIO, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(VILLA_P_NEGOCIOS)))
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(128, 128, 128)
                                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(84, 84, 84))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(100, 100, 100)
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(36, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(CODIGO_NEGOCIO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(VILLA_P_NEGOCIOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(PISOS_NEGOCIOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(COLOR_NEGOCIO, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(HR_APERTURA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HR_CIERRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(CREAR_NEGOCIO, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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

    private void CODIGO_NEGOCIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CODIGO_NEGOCIOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CODIGO_NEGOCIOActionPerformed

    private void COLOR_NEGOCIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_COLOR_NEGOCIOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_COLOR_NEGOCIOActionPerformed

    private void CodigoLoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodigoLoteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodigoLoteActionPerformed

    private void CODIGO_CASAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CODIGO_CASAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CODIGO_CASAActionPerformed

    private void CasaColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CasaColorActionPerformed
        // TODO add your handling code here:   
        CasaColor.setBackground(
                JColorChooser.showDialog(this, "Elige un color", Color.yellow));
    }//GEN-LAST:event_CasaColorActionPerformed

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
            String residencial = (String) Tabla_Villas.getValueAt(filaSeleccionada, 1);
            String capacidadLotes = (String) Tabla_Villas.getValueAt(filaSeleccionada, 2);
            String seguridad24Horas = (String) Tabla_Villas.getValueAt(filaSeleccionada, 3);

            // Crear y devolver el objeto de la villa seleccionada
            return new Villa(nombre, residencial, capacidadLotes, seguridad24Horas);
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

        // Crear un objeto Villa con los datos ingresados
        Villa v = new Villa(nombreVilla, residencialPertenencia, String.valueOf(capacidadLotes), seguridad24Hr);

        // Agregar la villa a la lista
        villa.add(v);

        // Agregar los datos a la tabla
        String[] rowData = {nombreVilla, residencialPertenencia, String.valueOf(capacidadLotes), seguridad24Hr};
        villaModel.addRow(rowData);

        // Mostrar mensaje de éxito
        JOptionPane.showMessageDialog(this, "Villa creada exitosamente");

        // Limpiar los campos de entrada
        NombreVilla.setText("");
        ResidencialPertenencia.setText("");
        CapacidadLotes.setValue(0);
        comboBoxSeguridad24Hr.setSelectedIndex(0);
    }//GEN-LAST:event_CREAR_VILLAMouseClicked

    private Villa obtenerVillaPertenencia(String nombreVilla) {
        for (Villa v : villa) {
            if (v.getNombre().equals(nombreVilla)) {
                return v;
            }
        }
        return null;
    }
    private void CREAR_APARTAMENTOSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CREAR_APARTAMENTOSMouseClicked
        // Obtener los valores ingresados por el usuario
        String codigoLote = CodigoLote.getText();
        Villa villaPertenencia = obtenerVillaPertenencia(VillaPertenencia.getText());
        int cantidadPisos = (int) CantidadPisos.getValue();
        Color color = COLOR_ROPA.getBackground();
        int cuartosFamiliares = (int) CuartosFamiliares.getValue();
        int cuartosPersonales = (int) CuartosPersonales.getValue();

        // Validar que se haya ingresado un código de lote y que inicie con "AP"
        if (codigoLote.isEmpty() || !codigoLote.startsWith("AP")) {
            JOptionPane.showMessageDialog(this, "Ingrese un código de lote válido que inicie con 'AP'", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar que se haya seleccionado una villa de pertenencia existente
        if (villaPertenencia == null) {
            JOptionPane.showMessageDialog(this, "La villa de pertenencia no existe", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear el objeto de Apartamento
        Apartamento apar = new Apartamento(codigoLote, villaPertenencia, cantidadPisos, color, cuartosFamiliares, cuartosPersonales);

        // Agregar el apartamento a la lista de apartamentos
        apartamento.add(apar);

        // Agregar los datos a la tabla de apartamentos
        String[] rowData = {codigoLote, villaPertenencia.getNombre(), String.valueOf(cantidadPisos),
            String.valueOf(cuartosFamiliares), String.valueOf(cuartosPersonales)};
        apartamentoModel.addRow(rowData);

        // Mostrar mensaje de éxito
        JOptionPane.showMessageDialog(this, "Apartamento creado exitosamente");

        // Limpiar los campos de entrada
        CodigoLote.setText("");
        VillaPertenencia.setText("");
        CantidadPisos.setValue(0);
        COLOR_ROPA.setBackground(Color.WHITE);
        CuartosFamiliares.setValue(0);
        CuartosPersonales.setValue(0);

    }//GEN-LAST:event_CREAR_APARTAMENTOSMouseClicked

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
            //String residencialActual = villa.getResidencial();
            int capacidadLotesActual = (int) villa.getCapacidadLotes();
            String seguridadActual = villa.getSeguridad24Horas();

            // Mostrar los valores actuales en los campos de edición
            NombreVilla.setText(nombreActual);
            CapacidadLotes.setValue(capacidadLotesActual);
            comboBoxSeguridad24Hr.setSelectedItem(seguridadActual);

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

    private void COLOR_ROPAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_COLOR_ROPAMouseClicked
        // TODO add your handling code here:
        COLOR_ROPA.setBackground(
                JColorChooser.showDialog(this, "Elige un color", Color.yellow));
    }//GEN-LAST:event_COLOR_ROPAMouseClicked

    private boolean esVillaExistente(String nombreVilla) {
        for (Villa v : villa) {
            if (v.getNombre().equals(nombreVilla)) {
                return true;
            }
        }
        return false;
    }

    private void CREAR_CASASMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CREAR_CASASMouseClicked
// Obtener los valores ingresados por el usuario
        String codigoLote = CODIGO_CASA.getText();
        Villa villaPertenencia = obtenerVillaPertenencia(VILLA_P_CASA.getText());
        int cantidadPisos = (int) PISOS_CASA.getValue();
        Color color = CasaColor.getBackground();
        int cuartosPersonales = (int) CUARTOS_P_CASA.getValue();

        // Validar que se haya ingresado un código de lote y que inicie con "AP"
        if (codigoLote.isEmpty() || !codigoLote.startsWith("CS")) {
            JOptionPane.showMessageDialog(this, "Ingrese un código de lote válido que inicie con 'CS'", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar que se haya seleccionado una villa de pertenencia existente
        if (villaPertenencia == null) {
            JOptionPane.showMessageDialog(this, "La villa de pertenencia no existe", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear el objeto de Casa
        Casa cs = new Casa(codigoLote, villaPertenencia, cantidadPisos, color, cuartosPersonales);

        // Agregar la casa a la lista de casas
        casa.add(cs);

        // Agregar los datos a la tabla de casas
        String[] rowData = {codigoLote, villaPertenencia.getNombre(), String.valueOf(cantidadPisos), String.valueOf(cuartosPersonales)};
        casasModel.addRow(rowData);

        // Mostrar mensaje de éxito
        JOptionPane.showMessageDialog(this, "Casa creada exitosamente");

        // Limpiar los campos de entrada
        CODIGO_CASA.setText("");
        VILLA_P_CASA.setText("");
        PISOS_CASA.setValue(0);
        CasaColor.setBackground(Color.WHITE);
        CUARTOS_P_CASA.setValue(0);
    }//GEN-LAST:event_CREAR_CASASMouseClicked

    private void CREAR_NEGOCIOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CREAR_NEGOCIOMouseClicked
         // Obtener los valores ingresados por el usuario
    String codigoLote = CODIGO_NEGOCIO.getText();
    Villa villaPertenencia = obtenerVillaPertenencia(VILLA_P_NEGOCIOS.getText());
    int cantidadPisos = (int) PISOS_NEGOCIOS.getValue();
    Color color = COLOR_NEGOCIO.getBackground();
    LocalTime horaApertura = ((Date) HR_APERTURA.getValue()).toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
    LocalTime horaCierre = ((Date) HR_CIERRE.getValue()).toInstant().atZone(ZoneId.systemDefault()).toLocalTime();

        // Validar que se haya ingresado un código de lote y que inicie con "AP"
        if (codigoLote.isEmpty() || !codigoLote.startsWith("NG")) {
            JOptionPane.showMessageDialog(this, "Ingrese un código de lote válido que inicie con 'NG'", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar que se haya seleccionado una villa de pertenencia existente
        if (villaPertenencia == null) {
            JOptionPane.showMessageDialog(this, "La villa de pertenencia no existe", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear el objeto de Casa
    Negocio ng = new Negocio(codigoLote, villaPertenencia, cantidadPisos, color, horaApertura, horaCierre);

        // Agregar la casa a la lista de casas
        negocio.add(ng);

        // Agregar los datos a la tabla de casas
        String[] rowData = {codigoLote, villaPertenencia.getNombre(), String.valueOf(cantidadPisos),
            String.valueOf(horaApertura),String.valueOf(horaCierre)};
        negocioModel.addRow(rowData);

        // Mostrar mensaje de éxito
        JOptionPane.showMessageDialog(this, "Negocio creado exitosamente");

        // Limpiar los campos de entrada
        CODIGO_NEGOCIO.setText("");
        VILLA_P_NEGOCIOS.setText("");
        PISOS_NEGOCIOS.setValue(0);
        COLOR_NEGOCIO.setBackground(Color.WHITE);
        HR_APERTURA.setValue(0);
        HR_CIERRE.setValue(0);

        
    }//GEN-LAST:event_CREAR_NEGOCIOMouseClicked

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
    ArrayList<Apartamento> apartamento = new ArrayList();
    ArrayList<Casa> casa = new ArrayList();
    ArrayList<Negocio> negocio = new ArrayList();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JYearChooser Año_Fundacion;
    private javax.swing.JTextField CODIGO_CASA;
    private javax.swing.JTextField CODIGO_NEGOCIO;
    private javax.swing.JButton COLOR_NEGOCIO;
    private javax.swing.JButton COLOR_ROPA;
    private javax.swing.JButton CREAR_APARTAMENTOS;
    private javax.swing.JButton CREAR_CASAS;
    private javax.swing.JButton CREAR_NEGOCIO;
    private javax.swing.JButton CREAR_RESIDENCIALES;
    private javax.swing.JButton CREAR_VILLA;
    private javax.swing.JSpinner CUARTOS_P_CASA;
    private javax.swing.JSpinner CantidadPisos;
    private javax.swing.JSpinner CapacidadLotes;
    private javax.swing.JButton CasaColor;
    private javax.swing.JTextField CodigoLote;
    private javax.swing.JSpinner CuartosFamiliares;
    private javax.swing.JSpinner CuartosPersonales;
    private javax.swing.JButton EDITAR_RESIDENCIALES;
    private javax.swing.JButton EDITAR_VILLA;
    private javax.swing.JButton ELIMIAR_VILLA;
    private javax.swing.JButton ELIMINAR_RESIDENCIAL;
    private javax.swing.JSpinner HR_APERTURA;
    private javax.swing.JSpinner HR_CIERRE;
    private javax.swing.JTable LISTA_APARTAMENTOS;
    private javax.swing.JTable LISTA_CASAS;
    private javax.swing.JTable LISTA_NEGOCIO;
    private javax.swing.JTable LISTA_RESIDENCIALES;
    private javax.swing.JTabbedPane LOTES;
    private javax.swing.JTextField Name_Residenciales;
    private javax.swing.JTextField NombreVilla;
    private javax.swing.JSpinner PISOS_CASA;
    private javax.swing.JSpinner PISOS_NEGOCIOS;
    private javax.swing.JPanel RESIDENCIALES;
    private javax.swing.JTextField ResidencialPertenencia;
    private javax.swing.JTable Tabla_Villas;
    private javax.swing.JPanel VILLAS;
    private javax.swing.JTextField VILLA_P_CASA;
    private javax.swing.JTextField VILLA_P_NEGOCIOS;
    private javax.swing.JTextField VillaPertenencia;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboBoxSeguridad24Hr;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    // End of variables declaration//GEN-END:variables
}
