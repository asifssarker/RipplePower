package org.ripple.power.utils;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dialog.ModalityType;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JDialog;
import javax.swing.JFrame;

import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class SwingUtils {

	static public Window getParentContainer(Component component) {
		if (component instanceof Window) {
			return (Window) component;
		}
		while (component.getParent() != null) {
			component = component.getParent();
			if (component instanceof Window) {
				return (Window) component;
			}
		}
		if (component instanceof Window) {
			return (Window) component;
		} else {
			return null;
		}
	}

	static public JDialog addModelessWindow(Component jpanel, String title) {
		return addModelessWindow((Window) null, jpanel, title);
	}

	static public JDialog addModelessWindow(Window mainWindow,
			Component jpanel, String title) {
		JDialog dialog;
		if (mainWindow != null) {
			dialog = new JDialog(mainWindow, title);
		} else {
			dialog = new JDialog();
			dialog.setTitle(title);
		}
		dialog.getContentPane().setLayout(new BorderLayout());
		dialog.getContentPane().add(jpanel, BorderLayout.CENTER);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.pack();
		dialog.setLocationRelativeTo(mainWindow);
		dialog.setModalityType(ModalityType.MODELESS);
		dialog.setSize(jpanel.getPreferredSize());
		dialog.setVisible(true);
		return dialog;
	}

	static public JDialog addModelessWindow(Frame mainWindow, Component jpanel,
			String title) {
		JDialog dialog = new JDialog(mainWindow, title, true);
		dialog.getContentPane().setLayout(new BorderLayout());
		dialog.getContentPane().add(jpanel, BorderLayout.CENTER);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.pack();
		dialog.setLocationRelativeTo(mainWindow);
		dialog.setModalityType(ModalityType.MODELESS);
		dialog.setSize(jpanel.getPreferredSize());
		dialog.setVisible(true);
		return dialog;
	}

	static public JDialog addDialogWindow(Frame mainWindow, Component jpanel,
			String title) {
		JDialog dialog = new JDialog(mainWindow, title, true);
		dialog.getContentPane().setLayout(new BorderLayout());
		dialog.getContentPane().add(jpanel, BorderLayout.CENTER);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.pack();
		dialog.setLocationRelativeTo(mainWindow);
		dialog.setSize(jpanel.getPreferredSize());
		dialog.setVisible(true);
		return dialog;
	}

	public static void fadeIn(final Dialog win) {
		if (!win.isUndecorated()) {
			return;
		}
		final Timer timer = new Timer(30, null);
		timer.setRepeats(true);
		timer.addActionListener(new ActionListener() {
			private float opacity = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				opacity += 0.05f;
				win.setOpacity(Math.min(opacity, 1f));
				if (opacity >= 1) {
					timer.stop();
				}
			}
		});
		win.setOpacity(0);
		timer.start();
		win.setVisible(true);
	}

	public static void fadeOut(final Dialog win, final boolean close) {
		if (!win.isUndecorated()) {
			if (close) {
				SwingUtils.close(win);
			}
			return;
		}
		final Timer timer = new Timer(30, null);
		timer.setRepeats(true);
		timer.addActionListener(new ActionListener() {
			private float opacity = 1;

			@Override
			public void actionPerformed(ActionEvent e) {
				opacity -= 0.05f;
				win.setOpacity(Math.max(opacity, 0f));
				if (opacity <= 0) {
					timer.stop();
					if (close) {
						SwingUtils.close(win);
					} else {
						win.setVisible(false);
					}
				}
			}
		});
		win.setOpacity(1);
		timer.start();
	}

	public static void close(Window win) {
		if (win != null) {
			win.setVisible(false);
			win.dispose();
		}
	}

	public static Rectangle getScreenSize(Window win) {
		Rectangle sb;
		if (win == null) {
			sb = GraphicsEnvironment.getLocalGraphicsEnvironment()
					.getDefaultScreenDevice().getDefaultConfiguration()
					.getBounds();
		} else {
			sb = win.getGraphicsConfiguration().getBounds();
		}
		return sb;
	}

	public static Insets getScreenInsets(Window win) {
		Insets si;
		if (win == null) {
			si = Toolkit.getDefaultToolkit()
					.getScreenInsets(
							GraphicsEnvironment.getLocalGraphicsEnvironment()
									.getDefaultScreenDevice()
									.getDefaultConfiguration());
		} else {
			si = win.getToolkit().getScreenInsets(
					win.getGraphicsConfiguration());
		}
		return si;
	}

	public static void fullScreen(Window win) {
		Rectangle screenBounds = SwingUtils.getScreenSize(win);
		win.setBounds(screenBounds);
	}

	public static void centerOnScreen(Window win) {
		Rectangle screenBounds = SwingUtils.getScreenSize(win);
		win.setBounds((int) (screenBounds.getWidth() - win.getWidth()) / 2,
				(int) (screenBounds.getHeight() - win.getHeight()) / 2,
				win.getWidth(), win.getHeight());
	}

	public static void centerOnParent(Window win) {
		Container parent = win.getParent();

		if (parent != null) {
			Point parentPosition = parent.getLocationOnScreen();
			win.setLocation(
					parentPosition.x + (parent.getWidth() - win.getWidth()) / 2,
					parentPosition.y + (parent.getHeight() - win.getHeight())
							/ 2);
		} else {
			centerOnScreen(win);
		}
	}

	public static boolean isTranslucentSupported() {
		GraphicsEnvironment ge = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();

		boolean isUniformTranslucencySupported = gd
				.isWindowTranslucencySupported(GraphicsDevice.WindowTranslucency.TRANSLUCENT);
		return isUniformTranslucencySupported;
	}

	public static void setWindowTransparent(Window win) {
		if (SwingUtils.isTranslucentSupported()) {
			win.setBackground(new Color(0, 0, 0, 0));
		}
	}

	public BufferedImage toCompatibleImage(BufferedImage image) {
		GraphicsConfiguration gfx_config = GraphicsEnvironment
				.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();

		if (image.getColorModel().equals(gfx_config.getColorModel())) {
			return image;
		}

		BufferedImage new_image = gfx_config.createCompatibleImage(
				image.getWidth(), image.getHeight(), image.getTransparency());

		Graphics2D g2d = (Graphics2D) new_image.getGraphics();

		g2d.drawImage(image, 0, 0, null);
		g2d.dispose();

		return new_image;
	}

	public static void addWindowListener(final Component source,
			final WindowListener listener) {
		if (source instanceof Window) {
			((Window) source).addWindowListener(listener);
		} else {
			source.addHierarchyListener(new HierarchyListener() {
				@Override
				public void hierarchyChanged(HierarchyEvent e) {
					if ((e.getChangeFlags() & HierarchyEvent.SHOWING_CHANGED) == HierarchyEvent.SHOWING_CHANGED) {
						SwingUtilities.getWindowAncestor(source)
								.addWindowListener(listener);
					}
				}
			});
		}
	}

	public static JFrame getJFrame(Component cmp) {
		return (JFrame) SwingUtilities.getWindowAncestor(cmp);
	}

	public static void packLater(final Window win, final Component parent) {
		win.pack();
		win.setLocationRelativeTo(parent);
		win.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				win.pack();
				win.setLocationRelativeTo(parent);
			}
		});
	}

	public static void importFont(InputStream stream) {
		try {
			Font font1 = Font.createFont(Font.TRUETYPE_FONT, stream);
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(
					font1);
		} catch (FontFormatException ex) {
			throw new RuntimeException(ex);
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
}
