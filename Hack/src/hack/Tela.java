/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;

/**
 *
 * @author Godofga
 */
public class Tela extends javax.swing.JFrame {

    /**
     * Creates new form Tela
     */
    private static boolean onp;
    
    public Tela() {
        initComponents();
        onp = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fundo = new javax.swing.JPanel();
        botao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Money Cube macro");
        setBackground(new java.awt.Color(255, 0, 0));
        setMaximumSize(new java.awt.Dimension(400, 400));
        setMinimumSize(new java.awt.Dimension(400, 400));
        setPreferredSize(new java.awt.Dimension(400, 400));
        setResizable(false);

        fundo.setBackground(new java.awt.Color(255, 0, 0));
        fundo.setForeground(new java.awt.Color(255, 0, 0));

        botao.setBackground(new java.awt.Color(255, 255, 255));
        botao.setForeground(new java.awt.Color(102, 102, 102));
        botao.setText("Ligar");
        botao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        botao.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoMouseClicked(evt);
            }
        });
        botao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fundoLayout = new javax.swing.GroupLayout(fundo);
        fundo.setLayout(fundoLayout);
        fundoLayout.setHorizontalGroup(
            fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fundoLayout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(botao, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
        );
        fundoLayout.setVerticalGroup(
            fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fundoLayout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(botao, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(160, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoActionPerformed

    private void botaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoMouseClicked
        // TODO add your handling code here:
        mudar();
    }//GEN-LAST:event_botaoMouseClicked
    public void mudar(){
        onp=!onp;
        if(onp){
            fundo.setBackground(Color.green);
            botao.setText("Desligar");
        }else{
            fundo.setBackground(Color.red);
            botao.setText("Ligar");
            
        }
    }
    /**
     * @param args the command line arguments   
     */
    public  static void main(String args[])throws AWTException {     
        
            new Tela().setVisible(true);
            
            Robot robot = new Robot();
            Propaganda prop = new Propaganda();
            for(;;){
   
                if(onp){
                    System.out.println("o primeiro foi");
                    PointerInfo a = MouseInfo.getPointerInfo();
                    Point b = a.getLocation();
                    int y = (int) b.y;
                    if(y>45&&y<830){
                        System.out.println("ta funcionando?");
                        prop.checar();
                    }
                    else{
                        onp=!onp;
                        System.out.println("e aqui?");
                    }
                    
                } else robot.delay(100);
                
            }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao;
    private javax.swing.JPanel fundo;
    // End of variables declaration//GEN-END:variables
}
