package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.border.EmptyBorder;

import modelo.BigPanel;

@SuppressWarnings("serial")
public class VistaVenta extends javax.swing.JPanel {

    private final BigPanel barra;
    
    /**
     * Creates new form VistaAlmacen
     * @param barra
     */
    public VistaVenta(BigPanel barra) {
        this.barra = barra;
        initComponents();
        cargarAjustesComponentes();
    }
    
    private void cargarAjustesComponentes() {
    	jPanel1.setBorder(new EmptyBorder(80, 80, 80, 80));
        this.add(barra, BorderLayout.NORTH);
    }
    
    public void setControlador(ActionListener e){
        
    }
    
    public BigPanel getBigPanel(){
        return barra;
    }

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jScrollPaneArticulos = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPaneCompra = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButtonMultiplicador = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButtonResta = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton0 = new javax.swing.JButton();
        jButtonPunto = new javax.swing.JButton();
        jButtonSuma = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButtonCobrar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelResultado = new javax.swing.JLabel();
        jButtonReset = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPaneArticulos.setViewportView(jTable3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.9;
        jPanel1.add(jScrollPaneArticulos, gridBagConstraints);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPaneCompra.setViewportView(jTable4);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(jScrollPaneCompra, gridBagConstraints);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel1.add(jButton1, gridBagConstraints);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        jPanel1.add(jButton2, gridBagConstraints);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton3.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        jPanel1.add(jButton3, gridBagConstraints);

        jButtonMultiplicador.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonMultiplicador.setText("*");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        jPanel1.add(jButtonMultiplicador, gridBagConstraints);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton4.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.1;
        jPanel1.add(jButton4, gridBagConstraints);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton5.setText("5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(jButton5, gridBagConstraints);

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton6.setText("6");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(jButton6, gridBagConstraints);

        jButtonResta.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonResta.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(jButtonResta, gridBagConstraints);

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton7.setText("7");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.1;
        jPanel1.add(jButton7, gridBagConstraints);

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton8.setText("8");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(jButton8, gridBagConstraints);

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton9.setText("9");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(jButton9, gridBagConstraints);

        jButton0.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton0.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.1;
        jPanel1.add(jButton0, gridBagConstraints);

        jButtonPunto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonPunto.setText(".");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(jButtonPunto, gridBagConstraints);

        jButtonSuma.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonSuma.setText("+");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(jButtonSuma, gridBagConstraints);

        jButton32.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton32.setText("LIMPIAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        jPanel1.add(jButton32, gridBagConstraints);

        jButtonCobrar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonCobrar.setText("COBRAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        jPanel1.add(jButtonCobrar, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 40;
        jPanel1.add(jSeparator1, gridBagConstraints);

        jLabelResultado.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelResultado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelResultado.setText("0");
        jLabelResultado.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.1;
        jPanel1.add(jLabelResultado, gridBagConstraints);

        jButtonReset.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonReset.setText("CE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(jButtonReset, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 40;
        jPanel1.add(jSeparator2, gridBagConstraints);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>                        

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton0;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonCobrar;
    private javax.swing.JButton jButtonMultiplicador;
    private javax.swing.JButton jButtonPunto;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonResta;
    private javax.swing.JButton jButtonSuma;
    private javax.swing.JLabel jLabelResultado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPaneArticulos;
    private javax.swing.JScrollPane jScrollPaneCompra;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    // End of variables declaration                   
}