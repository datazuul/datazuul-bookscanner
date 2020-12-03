package com.datazuul.bookscanner.core;

import chdk.ptp.java.CameraFactory;
import chdk.ptp.java.ICamera;
import chdk.ptp.java.connection.CameraUsbDevice;
import chdk.ptp.java.connection.UsbUtils;
import chdk.ptp.java.exception.CameraNotFoundException;
import chdk.ptp.java.model.CameraMode;
import chdk.ptp.java.model.FocusMode;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.usb.UsbException;

public class ThumbnailsAndScanPanel extends javax.swing.JPanel {

  /**
   * Creates new form ThumbnailsAndScanPanel
   */
  public ThumbnailsAndScanPanel() {
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jScrollPane1 = new javax.swing.JScrollPane();
    thumbnailsList = new javax.swing.JList<>();
    scanPanels = new javax.swing.JPanel();
    leftScanPanel = new com.datazuul.bookscanner.core.ScanPanel();
    rightScanPanel = new com.datazuul.bookscanner.core.ScanPanel();
    bottomPanel = new javax.swing.JPanel();
    shootButton = new javax.swing.JButton();

    setLayout(new java.awt.BorderLayout());

    thumbnailsList.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
      public int getSize() { return strings.length; }
      public String getElementAt(int i) { return strings[i]; }
    });
    jScrollPane1.setViewportView(thumbnailsList);

    add(jScrollPane1, java.awt.BorderLayout.LINE_START);

    scanPanels.setLayout(new javax.swing.BoxLayout(scanPanels, javax.swing.BoxLayout.X_AXIS));
    scanPanels.add(leftScanPanel);
    scanPanels.add(rightScanPanel);

    add(scanPanels, java.awt.BorderLayout.CENTER);

    bottomPanel.setLayout(new java.awt.BorderLayout());

    shootButton.setText("shoot!");
    shootButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        shootButtonActionPerformed(evt);
      }
    });
    bottomPanel.add(shootButton, java.awt.BorderLayout.CENTER);

    add(bottomPanel, java.awt.BorderLayout.PAGE_END);
  }// </editor-fold>//GEN-END:initComponents

  private void shootButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shootButtonActionPerformed
    BufferedImage image = shoot();
    if (image != null) {
      this.leftScanPanel.imagePanel.setImage(image);
      this.leftScanPanel.imagePanel.repaint();
    }
  }//GEN-LAST:event_shootButtonActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel bottomPanel;
  private javax.swing.JScrollPane jScrollPane1;
  private com.datazuul.bookscanner.core.ScanPanel leftScanPanel;
  private com.datazuul.bookscanner.core.ScanPanel rightScanPanel;
  private javax.swing.JPanel scanPanels;
  private javax.swing.JButton shootButton;
  private javax.swing.JList<String> thumbnailsList;
  // End of variables declaration//GEN-END:variables

  private BufferedImage shoot() {
    try {
      Collection<CameraUsbDevice> cameras = UsbUtils.listAttachedCameras();
      for (CameraUsbDevice cameraUsbDevice : cameras) {
        System.out.println(cameraUsbDevice);
      }
      ICamera cam = CameraFactory.getCamera();
      if (cam != null) {
        byte portNumber = cam.getUsbDevice().getParentUsbPort().getPortNumber();
        StringBuilder sbCameraName = new StringBuilder();
        sbCameraName.append(cam.getUsbDevice().getProductString());
        sbCameraName.append(" ").append(cam.getCameraInfo().name());
        sbCameraName.append(" - Port: ").append(portNumber);
        
        this.leftScanPanel.cameraPanel.setCameraName(sbCameraName.toString());
        cam.connect();
        boolean isConnected = true;
        cam.setOperationMode(CameraMode.RECORD);
        cam.setFocusMode(FocusMode.AUTO);
        BufferedImage image = cam.getPicture();
        System.out.println("" + image.getWidth() + " x " + image.getWidth() + " pixels");
        File outputfile = new File(System.getProperty("user.home") + File.separator + "saved.png");
        ImageIO.write(image, "png", outputfile);
        System.out.println("saved to " + outputfile.getAbsolutePath());
        cam.disconnect();
        return image;
      } 
    } catch (CameraNotFoundException ex) {
      Logger.getLogger(ThumbnailsAndScanPanel.class.getName()).log(Level.WARNING, "no camera detected");
    } catch (SecurityException ex) {
      Logger.getLogger(ThumbnailsAndScanPanel.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (UsbException ex) {
      Logger.getLogger(ThumbnailsAndScanPanel.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
    } catch (Exception ex) {
      Logger.getLogger(ThumbnailsAndScanPanel.class.getName()).log(Level.SEVERE, (String)null, ex);
    } 
    return null;
  }
}
