/**
 * 
 */
package org.deb.multiplayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.fullscreen.FullScreenStrategy;
import uk.co.caprica.vlcj.player.embedded.fullscreen.exclusivemode.ExclusiveModeFullScreenStrategy;

/**
 * @author Debmalya
 *
 */
public class MPlayer {

	private static String[] medias = {
			"https://www.youtube.com/watch?v=4-hQFOaJyxQ",
			"https://www.youtube.com/watch?v=IkOlwbjUofI",
			"https://www.youtube.com/watch?v=jlwe_9YbY94",
			"https://www.youtube.com/watch?v=dc5xG1agUrI",
	// Your MRL's go here
	};

	private final int rows = 4;
	private final int cols = 1;

	private final Frame mainFrame;

	private final List<PlayerInstance> players = new ArrayList<>();
	private final MediaPlayerFactory factory;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		medias = args;
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MPlayer().start();
            }
        });

	}

	public MPlayer() {
		factory = new MediaPlayerFactory();
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.black);
		contentPane.setLayout(new GridLayout(rows, cols, 16, 16));
		contentPane.setBorder(new EmptyBorder(16, 16, 16, 16));
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		mainFrame = new Frame("Multi Player");
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setBackground(Color.black);
		mainFrame.add(contentPane, BorderLayout.CENTER);
		mainFrame.setBounds(0, 0, screenSize.width/4, screenSize.height);

		mainFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent evt) {
				for (PlayerInstance pi : players) {
					pi.mediaPlayer().release();
				}
				factory.release();
				System.exit(0);
			}
		});
		
		
		mainFrame.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                for(int i = 0; i < players.size(); i ++ ) {
                    players.get(i).mediaPlayer().controls().pause();
                }
            }
        });
		
		FullScreenStrategy fullScreenStrategy = new ExclusiveModeFullScreenStrategy(mainFrame);

        for(int i = 0; i < medias.length; i ++ ) {
            EmbeddedMediaPlayer player = factory.mediaPlayers().newEmbeddedMediaPlayer();
            player.fullScreen().strategy(fullScreenStrategy);
            PlayerInstance playerInstance = new PlayerInstance(player);
            players.add(playerInstance);

            JPanel playerPanel = new JPanel();
            playerPanel.setLayout(new BorderLayout());
            playerPanel.setBorder(new LineBorder(Color.white, 2));
            playerPanel.add(playerInstance.videoSurface());

            contentPane.add(playerPanel);
        }

        mainFrame.setVisible(true);
		
		
	}

    private void start() {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < medias.length; i ++ ) {
                    players.get(i).mediaPlayer().videoSurface().set(factory.videoSurfaces().newVideoSurface(players.get(i).videoSurface()));
                    players.get(i).mediaPlayer().media().start(medias[i]);
                }

                // There is a race condition somewhere when invoking libvlc_media_player_play()
                // multiple times in quick succession that causes a hard-failure and a fatal
                // VM crash.
                //
                // This is _not_ about _concurrently_ calling play multiple times, but the
                // native play function call must be off-loading something to a separate
                // thread and returning - then a subsequent call to play somehow interferes
                // with that or fails because of that.
                //
                // When libvlc_media_player_play() is called, the video playback is kicked
                // off asynchronously - so the API call will return before the video has
                // started playing. If we invoke play and then wait (making this effectively
                // a synchronous call) for the player to start playing, there is less chance
                // for the hard VM crash to occur - but it still might
                for(int i = 0; i < medias.length; i ++ ) {
                    EmbeddedMediaPlayer mediaPlayer = players.get(i).mediaPlayer();
                    mediaPlayer.controls().start();
                }
            }
        });
    }
}
