/**
 * 
 */
package org.deb.components;

import java.awt.Frame;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

/**
 * @author Debmalya
 *
 */
public class CustomeEmbeddedPlayer extends EmbeddedMediaPlayerComponent {

	/* (non-Javadoc)
	 * @see uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponentBase#playing(uk.co.caprica.vlcj.player.base.MediaPlayer)
	 */
	@Override
	public void playing(MediaPlayer mediaPlayer) {
		SwingUtilities.invokeLater(new Runnable() {
	        @Override
	        public void run() {
//	            showVideoView();
//	        	showDefaultView();
	        }
	    });
	}

	/* (non-Javadoc)
	 * @see uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponentBase#finished(uk.co.caprica.vlcj.player.base.MediaPlayer)
	 */
	@Override
	public void finished(MediaPlayer mediaPlayer) {
		// TODO Auto-generated method stub
		super.finished(mediaPlayer);
	}

	/* (non-Javadoc)
	 * @see uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponentBase#error(uk.co.caprica.vlcj.player.base.MediaPlayer)
	 */
	@Override
	public void error(MediaPlayer mediaPlayer) {
		// TODO Auto-generated method stub
		super.error(mediaPlayer);
		SwingUtilities.invokeLater(new Runnable() {
	        @Override
	        public void run() {
	            JOptionPane.showMessageDialog(
	                new Frame(),
	                "Failed to play media",
	                "Error",
	                JOptionPane.ERROR_MESSAGE
	            );
	        }
	    });
	}

}
