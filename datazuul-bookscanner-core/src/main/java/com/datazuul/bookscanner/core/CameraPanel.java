package com.datazuul.bookscanner.core;

public class CameraPanel extends javax.swing.JPanel {

  /**
   * Creates new form CameraPanel
   */
  public CameraPanel() {
    initComponents();
  }

  public void setCameraName(String cameraName) {
    this.cameraName.setText(cameraName);
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    cameraName = new javax.swing.JLabel();

    setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

    cameraName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    cameraName.setText("- no camera selected -");
    add(cameraName);
  }// </editor-fold>//GEN-END:initComponents


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel cameraName;
  // End of variables declaration//GEN-END:variables
}
