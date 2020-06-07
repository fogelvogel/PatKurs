import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class FirstWindow {
	public static final int QuantityOfImages = 20;
	public static JFrame frame;
	public BufferedImage imageToDraw;
	private  JPanel pane;

	public FirstWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		String[] items = new String[QuantityOfImages];
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(20);
		comboBox.setBounds(10, 33, 49, 22);
		frame.getContentPane().add(comboBox);
		for(int i = 1;i<=QuantityOfImages;i++) {
			comboBox.addItem(Integer.toString(i));
		}
		 try {
			imageToDraw = ImageIO.read(new File("1.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 JButton buttonFind = new JButton("\u043D\u0430\u0439\u0442\u0438 \u043F\u043E\u0445\u043E\u0436\u0435\u0435");
			buttonFind.setBounds(10, 105, 153, 23);
			frame.getContentPane().add(buttonFind);
			
			JButton buttonShow = new JButton("\u043F\u043E\u043A\u0430\u0437\u0430\u0442\u044C \u043A\u0430\u0440\u0442\u0438\u043D\u043A\u0443");
			buttonShow.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						imageToDraw = ImageIO.read(new File(comboBox.getSelectedItem()+".jpg"));
						  pane.setBounds(220, 10, imageToDraw.getWidth(), imageToDraw.getHeight());
					    	frame.setBounds(100, 0, 240+  imageToDraw.getWidth(), 20+imageToDraw.getHeight());
						pane.repaint();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			buttonShow.setBounds(10, 70, 153, 23);
			frame.getContentPane().add(buttonShow);
		 
		 
		 pane = new JPanel() {
	            @Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                g.drawImage(imageToDraw, 0, 0, null);
	            }
	        };
	        pane.setBounds(220, 10, imageToDraw.getWidth(), imageToDraw.getHeight());
	    	frame.setBounds(100, 0, 240+  imageToDraw.getWidth(), 20+imageToDraw.getHeight());

			frame.getContentPane().add(pane);
	}
}
