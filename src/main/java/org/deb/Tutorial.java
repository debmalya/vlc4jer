/**
 * 
 */
package org.deb;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

/**
 * @author Debmalya
 *
 */
public class Tutorial {

	private final JFrame frame;

	private final EmbeddedMediaPlayerComponent mediaPlayerComponent;

	/**
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length > 0) {
			Tutorial thisApp = new Tutorial();
			thisApp.mediaPlayerComponent.mediaPlayer().media().play(args[0]);
		} else {
            System.err.println("Usage: java Tutorial <media file name with path>");     
		}

	}

	public Tutorial() {

		frame = new JFrame("My First Media Player");
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				mediaPlayerComponent.release();
				System.exit(0);
			}
		});

		mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
		frame.setContentPane(mediaPlayerComponent);

		frame.setVisible(true);

	}

}
