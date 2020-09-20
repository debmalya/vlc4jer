/**
 * 
 */
package org.deb;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.deb.listeners.CustomMediaEventListener;

import uk.co.caprica.vlcj.media.MediaEventListener;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

/**
 * @author Debmalya
 *
 */
public class Tutorial {

	private final JFrame frame;

	private final EmbeddedMediaPlayerComponent mediaPlayerComponent;

	private final JButton pauseButton;

	private final JButton rewindButton;

	private final JButton skipButton;

	/**
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length > 0) {
			Tutorial thisApp = new Tutorial(args[0]);
			thisApp.mediaPlayerComponent.mediaPlayer().media().play(args[0]);
		} else {
			System.err
					.println("Usage: mvn compile exec:java -Dexec.mainClass=\"org.deb.Tutorial\" -Dexec.args=\"media\\aaj-tomare-dekhte-elem.mp3\"");
		}

	}

	public Tutorial(String fileName) {
		mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
		String title = "Media Player Tutorial";
		if (null != fileName) {
			int fileNameStartingPosition = fileName.lastIndexOf(File.separator);
			if (fileNameStartingPosition > -1) {
				title = fileName.substring(fileNameStartingPosition + 1);
			}else{
				title = fileName;
			}
		}
		frame = new JFrame(title);
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				mediaPlayerComponent.release();
				System.exit(0);
			}
		});

		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());

		JPanel controlsPane = new JPanel();

		pauseButton = new JButton("Pause");
		controlsPane.add(pauseButton);
		pauseButton.addActionListener(e -> mediaPlayerComponent.mediaPlayer()
				.controls().pause());

		rewindButton = new JButton("Rewind");
		// controlsPane.add(rewindButton);
		// rewindButton.addActionListener(e ->
		// mediaPlayerComponent.mediaPlayer().controls().skipPosition(1000.00f));

		skipButton = new JButton("Skip");
		// controlsPane.add(skipButton);
		// skipButton.addActionListener(e->mediaPlayerComponent.mediaPlayer().controls().skipPosition(-1000.00f));
		contentPane.add(controlsPane, BorderLayout.SOUTH);

		MediaEventListener listener = new CustomMediaEventListener();
		mediaPlayerComponent.mediaPlayer().events()
				.addMediaEventListener(listener);

		contentPane.add(mediaPlayerComponent, BorderLayout.CENTER);
		frame.setContentPane(contentPane);

		frame.setVisible(true);

	}

}
