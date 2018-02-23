package eu.aria.dm.gui;

import eu.aria.dm.util.Say;

import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.DefaultCaret;

/**
 * @author Siewart
 */
public class UserAndAgentGUI extends javax.swing.JFrame implements Observer{
    private static HashMap<GUIController, UserAndAgentGUI> instances = new HashMap<>();
    private GUIController controller = null;
    private UserAndAgentGUI(GUIController controller ){
        this.controller = controller;
        initComponents();
        DefaultCaret caret = (DefaultCaret)conversationText.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    };

    /**
     *
     * @param controller the controller for which this instance will be/was created.
     * @return return an previous or new instance of the gui
     */
    public synchronized static UserAndAgentGUI getInstance(GUIController controller){
        UserAndAgentGUI inst = instances.get(controller);
        if( inst == null){
            inst = createNewInstance(controller);
            instances.put(controller, inst);
        }

        return inst;
    }

    @Override
    public synchronized void update(Observable o, Object arg) {
        if(o == controller){
            GUIController.DataChanged evt = (GUIController.DataChanged) arg;
            if(evt.getType() == GUIController.DataChangedType.AgentSay){
                Say say = (Say) evt.getArgument();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                conversationText.append(say.getActorName() +" [" + sdf.format(new Date(say.getTimestamp())) + "] : "+ say.getText()+"\n");
            }else if(evt.getType() == GUIController.DataChangedType.UserSay){
                Say say = (Say) evt.getArgument();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                conversationText.append(say.getActorName() +" [" + sdf.format(new Date(say.getTimestamp())) + "] : "+ say.getText()+"\n");
            }else if(evt.getType() == GUIController.DataChangedType.PresenceChange){
                boolean present = (Boolean) evt.getArgument();
                isPresent.setSelected(present);
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        conversationText = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        valenceSlider = new javax.swing.JSlider();
        valenceLabel = new javax.swing.JLabel();
        interestLabel = new javax.swing.JLabel();
        arousalSlider = new javax.swing.JSlider();
        interestSlider = new javax.swing.JSlider();
        arousalLabel = new javax.swing.JLabel();
        updateEmotions = new javax.swing.JButton();
        isPresent = new javax.swing.JCheckBox();
        blockASR = new javax.swing.JCheckBox();
        overwriteEmotion = new javax.swing.JCheckBox();
        overwritePresent = new javax.swing.JCheckBox();
        sayButton = new javax.swing.JButton();
        sayText = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dialogue + WoZ");

        conversationText.setColumns(20);
        conversationText.setRows(5);
        conversationText.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        conversationText.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        conversationText.setEnabled(false);
        jScrollPane1.setViewportView(conversationText);

        valenceSlider.setMajorTickSpacing(100);
        valenceSlider.setMinimum(-100);
        valenceSlider.setMinorTickSpacing(10);
        valenceSlider.setValue(0);
        valenceSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                valenceSliderStateChanged(evt);
            }
        });

        valenceLabel.setText("Valence (0.5)");
        valenceLabel.setAlignmentX(0.5F);

        interestLabel.setText("Interest (0.5)");
        interestLabel.setAlignmentX(0.5F);

        arousalSlider.setMajorTickSpacing(100);
        arousalSlider.setMinimum(-100);
        arousalSlider.setMinorTickSpacing(10);
        arousalSlider.setValue(0);
        arousalSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                arousalSliderStateChanged(evt);
            }
        });

        interestSlider.setMajorTickSpacing(100);
        interestSlider.setMinimum(-100);
        interestSlider.setMinorTickSpacing(10);
        interestSlider.setValue(0);
        interestSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                interestSliderStateChanged(evt);
            }
        });

        arousalLabel.setText("Arousal (0.5)");
        arousalLabel.setAlignmentX(0.5F);

        updateEmotions.setText("Update Emotions");
        updateEmotions.setEnabled(false);
        updateEmotions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateEmotionsActionPerformed(evt);
            }
        });

        isPresent.setText("user present");
        isPresent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isPresentActionPerformed(evt);
            }
        });

        blockASR.setText("block ASR");
        blockASR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blockASRActionPerformed(evt);
            }
        });

        overwriteEmotion.setText("overwrite SSI-emotion");
        overwriteEmotion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                overwriteEmotionActionPerformed(evt);
            }
        });

        overwritePresent.setText("overwrite SSI-present");
        overwritePresent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                overwritePresentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(arousalSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(interestLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                .addGap(234, 234, 234))
                        .addComponent(interestSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(arousalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(valenceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addComponent(valenceSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(isPresent)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(updateEmotions))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(blockASR, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(overwriteEmotion, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(overwritePresent, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(valenceLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(valenceSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(interestLabel)
                                .addGap(2, 2, 2)
                                .addComponent(interestSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(arousalLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(arousalSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(blockASR)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(overwriteEmotion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(overwritePresent)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(updateEmotions)
                                        .addComponent(isPresent)))
        );

        sayButton.setText("Say");
        sayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sayButtonActionPerformed(evt);
            }
        });

        sayText.setToolTipText("");
        sayText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sayTextActionPerformed(evt);
            }
        });
        sayText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                sayTextKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(sayText, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(sayButton))
                                        .addComponent(jScrollPane1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(sayButton, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                        .addComponent(sayText)))
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void updateEmotionsActionPerformed(java.awt.event.ActionEvent evt) {
        controller.setValence(valenceSlider.getValue()/200d + 0.5d);
        controller.setArousal(arousalSlider.getValue()/200d + 0.5d);
        controller.setInterest(interestSlider.getValue()/200d +0.5d);
        updateEmotions.setEnabled(false);

    }

    private void arousalSliderStateChanged(javax.swing.event.ChangeEvent evt) {
        double val = arousalSlider.getValue()/200d+0.5d;
        arousalLabel.setText("Arousal ("+new DecimalFormat("#.##").format(val)+")");
        updateEmotions.setEnabled(true);
    }

    private void interestSliderStateChanged(javax.swing.event.ChangeEvent evt) {
        double val = interestSlider.getValue()/200d+0.5d;
        interestLabel.setText("Interest ("+new DecimalFormat("#.##").format(val)+")");
        updateEmotions.setEnabled(true);
    }

    private void valenceSliderStateChanged(javax.swing.event.ChangeEvent evt) {
        double val = valenceSlider.getValue()/200d+0.5d;
        valenceLabel.setText("Valence ("+new DecimalFormat("#.##").format(val)+")");
        updateEmotions.setEnabled(true);
    }

    private void sayButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String text = sayText.getText();
        sayText.setText("");
        controller.setIsTalking(false);
        controller.addUserSay(new Say(text, "User", true, System.currentTimeMillis(), 2000, false, "english"));
    }

    private void sayTextActionPerformed(java.awt.event.ActionEvent evt) {
        sayButtonActionPerformed(evt);
    }

    private void sayTextKeyTyped(java.awt.event.KeyEvent evt) {
        if(sayText.getText().trim().length() > 0){
            controller.setIsTalking(true);
        }else{
            controller.setIsTalking(false);
        }
    }

    private void isPresentActionPerformed(java.awt.event.ActionEvent evt) {
        controller.setPresent(isPresent.isSelected());
    }

    private void blockASRActionPerformed(java.awt.event.ActionEvent evt) {

        controller.setBlockASR(blockASR.isSelected());
    }

    private void overwriteEmotionActionPerformed(java.awt.event.ActionEvent evt) {
        controller.setOverrideEmo(overwriteEmotion.isSelected());
    }

    private void overwritePresentActionPerformed(java.awt.event.ActionEvent evt) {
        controller.setOverridePresent(overwritePresent.isSelected());
    }




    /**
     * @param args the command line arguments
     */
    private static UserAndAgentGUI createNewInstance(GUIController controller) {
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserAndAgentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        Holder<UserAndAgentGUI> result = new Holder();
        try {
            /* Create and display the form */
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    result.setValue(new UserAndAgentGUI(controller));
                    result.getValue().setVisible(true);
                }
            });
        } catch (InterruptedException | InvocationTargetException ex) {
            Logger.getLogger(UserAndAgentGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result.getValue();
    }
    private static class Holder<T>{
        private T value;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }


    // Variables declaration - do not modify
    private javax.swing.JLabel arousalLabel;
    private javax.swing.JSlider arousalSlider;
    private javax.swing.JCheckBox blockASR;
    private javax.swing.JTextArea conversationText;
    private javax.swing.JLabel interestLabel;
    private javax.swing.JSlider interestSlider;
    private javax.swing.JCheckBox isPresent;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JCheckBox overwriteEmotion;
    private javax.swing.JCheckBox overwritePresent;
    private javax.swing.JButton sayButton;
    private javax.swing.JTextField sayText;
    private javax.swing.JButton updateEmotions;
    private javax.swing.JLabel valenceLabel;
    private javax.swing.JSlider valenceSlider;
    // End of variables declaration
}