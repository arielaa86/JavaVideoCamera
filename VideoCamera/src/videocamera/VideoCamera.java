/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videocamera;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

/**
 *
 * @author ariel
 */
public class VideoCamera {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

       
        JDialog loading = new JDialog();
       
        JLabel label =new JLabel(new ImageIcon(VideoCamera.class.getResource("/imagen/aperture.gif"))); 
        loading.add(label);
        loading.setUndecorated(true);
        
        
        
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        
        loading.setBounds(0, 0, 800, 600);
        
   
        
 
        int w = loading.getSize().width;
        int h = loading.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;

        loading.setBounds(x, y, 800, 600);
        loading.setVisible(true);

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {

                configAll();
                return null;

            }
        };

        worker.addPropertyChangeListener(evt -> {
            if (SwingWorker.StateValue.DONE == evt.getNewValue()) {

                
                loading.setVisible(false);

            }
        });

        worker.execute();

    }

    public static void configAll() {

        JFrame window = new JFrame("Video Camera JAVA");

        window.setLocationRelativeTo(null);

        Webcam webcam = Webcam.getDefault();

        webcam.setViewSize(new Dimension(1024, 750));

        WebcamPanel panel = new WebcamPanel(webcam);
        
        
       

        window.add(panel);
        window.setResizable(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
 
        int w = window.getSize().width;
        int h = window.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;

        window.setLocation(x, y);

        window.setVisible(true);

    }

}
