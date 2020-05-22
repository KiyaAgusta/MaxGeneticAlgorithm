package maxgeneticalgorithm.view;

import java.text.DecimalFormat;
import maxgeneticalgorithm.controller.MaxLogic;
import maxgeneticalgorithm.model.*;

public class MaxView extends javax.swing.JFrame {
    private static int geneSize = 8;
    private static int individualSize;
    private static int populationSize;
    private static double crossoverRate;
    private static double mutationRate;
    
    public MaxView() {
        initComponents();
        generationTextArea.setEditable(false);
    }

    public void setResult() {
        Individual individual;

        // Initialize population
        Population pop = new Population(individualSize, true);
        
        // Evolve population
        String genes, binary, value;
        for (int i = 0; i < populationSize; i++) {
            pop = MaxLogic.evolvePopulation(pop, crossoverRate, mutationRate);
            generationTextArea.append("GENERATION " + (i + 1) + "\n");
            generationTextArea.append("GENES\tBINARY\tVALUE\n");
            
            for (int j = 0; j < individualSize; j++) {
                genes = "";
                
                for (int k = 0; k < geneSize; k++)
                    genes += pop.getIndividual(j).getGene(k);
                
                binary = getDecimalFormat(pop.getIndividual(j).getBinary());
                value = getDecimalFormat(pop.getIndividual(j).getValue());
                generationTextArea.append(genes + "\t" + binary + "\t"
                                          + value + "\n");
            }
            
            individual = pop.getFittest();
            genes = "";
            binary = getDecimalFormat(individual.getBinary());
            value = getDecimalFormat(individual.getValue());
            
            for (int j = 0; j < 8; j++)
                genes += individual.getGene(j);
            
            generationTextArea.append("\nMAX VALUE OF GENERATION "
                                      + (i + 1) + " : " + "\n");
            generationTextArea.append(genes + "\t" + binary + "\t"
                                      + value + "\n\n");
        }
    }
    
    public static String getDecimalFormat(double number) {
        DecimalFormat df = new DecimalFormat("#.###");
        return df.format(number);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        individualLabel = new javax.swing.JLabel();
        generationLabel = new javax.swing.JLabel();
        crossoverLabel = new javax.swing.JLabel();
        mutationLabel = new javax.swing.JLabel();
        individualTextField = new javax.swing.JTextField();
        generationTextField = new javax.swing.JTextField();
        crossoverTextField = new javax.swing.JTextField();
        mutationTextField = new javax.swing.JTextField();
        processButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        generationTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Made Akira - Genetic Algorithm");

        backgroundPanel.setBackground(new java.awt.Color(204, 255, 255));

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titleLabel.setText("MAX VALUE OF FUNCTION f(x) = e^(-2x) * sin(3x)");

        individualLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        individualLabel.setText("NUMBER OF INDIVIDUALS :");

        generationLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        generationLabel.setText("NUMBER OF GENERATION :");

        crossoverLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        crossoverLabel.setText("CROSSOVER PROBABILITY :");

        mutationLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mutationLabel.setText("MUTATION PROBABILITY :");

        processButton.setText("PROCESS");
        processButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processButtonActionPerformed(evt);
            }
        });

        generationTextArea.setColumns(20);
        generationTextArea.setRows(5);
        jScrollPane1.setViewportView(generationTextArea);

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(individualLabel)
                            .addComponent(generationLabel)
                            .addComponent(crossoverLabel)
                            .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(processButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(mutationLabel)))
                        .addGap(25, 25, 25)
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(individualTextField)
                            .addComponent(generationTextField)
                            .addComponent(crossoverTextField)
                            .addComponent(mutationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(156, 156, 156))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98))))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(titleLabel)
                .addGap(28, 28, 28)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(individualLabel)
                    .addComponent(individualTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generationLabel)
                    .addComponent(generationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crossoverLabel)
                    .addComponent(crossoverTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mutationLabel)
                    .addComponent(mutationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(processButton)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void processButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processButtonActionPerformed
        individualSize = Integer.valueOf(individualTextField.getText());
        populationSize = Integer.valueOf(generationTextField.getText());
        crossoverRate = Double.valueOf(crossoverTextField.getText());
        mutationRate = Double.valueOf(mutationTextField.getText());
        
        setResult();
    }//GEN-LAST:event_processButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MaxView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MaxView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MaxView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MaxView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MaxView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JLabel crossoverLabel;
    private javax.swing.JTextField crossoverTextField;
    private javax.swing.JLabel generationLabel;
    private javax.swing.JTextArea generationTextArea;
    private javax.swing.JTextField generationTextField;
    private javax.swing.JLabel individualLabel;
    private javax.swing.JTextField individualTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mutationLabel;
    private javax.swing.JTextField mutationTextField;
    private javax.swing.JButton processButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
