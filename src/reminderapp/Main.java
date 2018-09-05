package reminderapp;
import reminderapp.view.JFrameHomeUI;
/**
 *
 * @author Riyad
 */
public class Main {
    public static void main(String args[]) {
        //This is just how we start a Swing frame
        //We chosed Look and Feel option - "Nimbus"
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameHomeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            //set the frame to visible
            JFrameHomeUI homeUI = new JFrameHomeUI();
            homeUI.setVisible(true);
        });
    }
}
