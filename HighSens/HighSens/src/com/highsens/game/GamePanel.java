package com.highsens.game;
///////////////////////////////

// Imports a specific class (Class Object)
// Class Object is the root of the class hierarchy.
// Every class has Object as a superclass. All objects, including arrays, implement the methods of this class.

// The Color class is used to encapsulate colors
//     in the default sRGB color space or colors in arbitrary color spaces identified by a ColorSpace.
//ColorSpace: 
//     This abstract class is used to serve as a color space tag to identify the specific color space of a Color object or, via a ColorModel object, of an Image, a BufferedImage, or a GraphicsDevice.
//     It contains methods that transform colors in a specific color space to/from sRGB and to/from a well-defined CIEXYZ color space.
import java.awt.Color;

///////////////////////////////
// Commented out: NOT NEEDED?
// The Dimension class encapsulates the width and height of a component (in integer precision) in a single object. 
// import java.awt.Dimension;
///////////////////////////////

// The Font class represents fonts, which are used to render text in a visible way.
// A font provides the information needed to map sequences of characters to sequences of glyphs and to render sequences of glyphs on Graphics and Component objects.
import java.awt.Font;
//The Graphics class is the abstract base class for all graphics contexts
//     that allow an application to draw onto components that are realized on various devices,
//     as well as onto off-screen images.
import java.awt.Graphics;
// This Graphics2D class extends the Graphics class to provide more sophisticated control over geometry, coordinate transformations, color management, and text layout.
// This is the fundamental class for rendering 2-dimensional shapes, text and images on the Java(tm) platform.
import java.awt.Graphics2D;
// The abstract class Image is the superclass of all classes that represent graphical images.
// The image must be obtained in a platform-specific manner.
// Allows us to use to instantiate and utilize the Image objects within the project
import java.awt.Image;

///////////////////////////////
// Commented Out: unimplemented use of mass select via box
//import java.awt.Rectangle;
///////////////////////////////

// This class is the abstract superclass of all actual implementations of the Abstract Window Toolkit.
//Subclasses of Toolkit are used to bind the various components to particular native toolkit implementations.
import java.awt.Toolkit;
// The File class is based on (implements) the FileOutputStream class.
// The FileOutputStream class is based on the OutputStream class.
// ***********OUT OF DATE************
import java.io.File;
import java.io.IOException;

// Allows for 
import javax.imageio.ImageIO;
// Allows for 
import javax.swing.JOptionPane;
// Allows for 
import javax.swing.JPanel;
///////////////////////////////

// Imports a specific class (Class Object)
// Class Object is the root of the class hierarchy.
// Every class has Object as a superclass. All objects, including arrays, implement the methods of this class.

// The Color class is used to encapsulate colors
//     in the default sRGB color space or colors in arbitrary color spaces identified by a ColorSpace.
//ColorSpace: 
//     This abstract class is used to serve as a color space tag to identify the specific color space of a Color object or, via a ColorModel object, of an Image, a BufferedImage, or a GraphicsDevice.
//     It contains methods that transform colors in a specific color space to/from sRGB and to/from a well-defined CIEXYZ color space.
import java.awt.Color;

///////////////////////////////
// Commented out: NOT NEEDED?
// The Dimension class encapsulates the width and height of a component (in integer precision) in a single object. 
// import java.awt.Dimension;
///////////////////////////////

// The Font class represents fonts, which are used to render text in a visible way.
// A font provides the information needed to map sequences of characters to sequences of glyphs and to render sequences of glyphs on Graphics and Component objects.
import java.awt.Font;
//The Graphics class is the abstract base class for all graphics contexts
//     that allow an application to draw onto components that are realized on various devices,
//     as well as onto off-screen images.
import java.awt.Graphics;
// This Graphics2D class extends the Graphics class to provide more sophisticated control over geometry, coordinate transformations, color management, and text layout.
// This is the fundamental class for rendering 2-dimensional shapes, text and images on the Java(tm) platform.
import java.awt.Graphics2D;
// The abstract class Image is the superclass of all classes that represent graphical images.
// The image must be obtained in a platform-specific manner.
// Allows us to use to instantiate and utilize the Image objects within the project
import java.awt.Image;

///////////////////////////////
// Commented Out: unimplemented use of mass select via box
//import java.awt.Rectangle;
///////////////////////////////

// This class is the abstract superclass of all actual implementations of the Abstract Window Toolkit.
//Subclasses of Toolkit are used to bind the various components to particular native toolkit implementations.
import java.awt.Toolkit;
// The File class is based on (implements) the FileOutputStream class.
// The FileOutputStream class is based on the OutputStream class.
// ***********OUT OF DATE************
import java.io.File;
import java.io.IOException;

// Allows for 
import javax.imageio.ImageIO;
// Allows for 
import javax.swing.JOptionPane;
// Allows for 
import javax.swing.JPanel;
///////////////////////////////

///////////////////////////////
//  ::New Class::
//  JPanel: An internal lightweight container. 
//          To appear on your windowing system as a regular application.
//          The GUI must be contained in a top-level window (such as JFrame or JDialog). 
//Public meaning that any other class can use this class.
public class GamePanel extends JPanel {
	///////////////////////////////

	private static final long serialVersionUID = -6235582196874360230L;
	///////////////////////////////
	// size of the game panel
	// static and final are two ways of saying that this is a constant public
	/////////////////////////////// variable.
	// public meaning that any class within this folder can use this variable
	// 32-bit signed two's complement integer,
	// Minimum value of -2^(31) and a maximum value of 2^(31) - 1.
	public static final int PWIDTH = 600;
	public static final int PHEIGHT = 400;
	///////////////////////////////

	///////////////////////////////
	// Commented Out: unimplemented use of mass select via box
	// Rectangle areaSelector = null;
	///////////////////////////////

	///////////////////////////////
	// Allows the game to use the classes Animator and GameData
	private Animator animator;
	private GameData gameData;
	///////////////////////////////

	///////////////////////////////
	// Graphical screen rendering (Instantiation)
	private Graphics graphics;
	private Image dbImage;
	private Image mapImage;
	private Image ArrowTowerImage;
	private Image BlueTowerImage;
	private Image RegularMonsterImage;
	private Image FastMonsterImage;
	private Image BossImage;
	private Image mute;
	///////////////////////////////

	public GamePanel(Animator animator, GameData gameData) {
		///////////////////////////////
		// Use the animator and gamedata from within this class
		this.animator = animator;
		this.gameData = gameData;
		///////////////////////////////

		// Set global background color
		setBackground(Color.gray);

		///////////////////////////////
		// Commented out: Unsure what it does and game works without it (Watch
		/////////////////////////////// for bugs)
		// ???? fits the dimensions of the of the game panel ????
		// setPreferredSize(new Dimension(PWIDTH, PHEIGHT));
		///////////////////////////////

		///////////////////////////////
		// Set user defined file path and use desired seperator for path name
		String imagePath = System.getProperty("user.dir");
		String separator = System.getProperty("file.separator");
		///////////////////////////////

		///////////////////////////////
		// Add images to the game.
		// Adds the map image from the images director with a distinct seperator
		/////////////////////////////// and path
		mapImage = getImage(imagePath + separator + "images" + separator + "map.png");
		// Adds the Regular Tower image from the images director with a distinct
		// seperator and path
		ArrowTowerImage = getImage(imagePath + separator + "images" + separator + "ArrowTower.png");
		// Adds the Blue Tower image from the images director with a distinct
		// seperator and path
		BlueTowerImage = getImage(imagePath + separator + "images" + separator + "BlueTower.png");

		RegularMonsterImage = getImage(imagePath + separator + "images" + separator + "RegularMonster1.png");

		FastMonsterImage = getImage(imagePath + separator + "images" + separator + "fastMonster1.png");

		BossImage = getImage(imagePath + separator + "images" + separator + "boss1.png");
		
		mute = getImage(imagePath + separator + "images" + separator + "mute.jpg");
		
		AudioPlayer.loadStream("background", "sounds/bgmusic.wav");
		///////////////////////////////
	}

	///////////////////////////////
	// This class allows us to obtain an image file from disk.
	public static Image getImage(String fileName) {
		// Create an instance of image and make it null
		Image image = null;

		// Try to pull the file from a user defined file path
		try {
			// Returns a BufferedImage as the result of decoding a supplied File
			// with an ImageReader chosen automatically from among those
			// currently registered.
			// The File is wrapped in an ImageInputStream.
			// If no registered ImageReader claims to be able to read the
			// resulting stream, null is returned.
			// Place that file path into our Image class instantiation
			// image = ImageIO.read(new File(fileName));
			image = ImageIO.read(new File(fileName));
			// If that fails to succeed.
		} catch (IOException ioe) {
			// ERROR: either the the file wasn't in the folder or mispelled.
			System.out.println("Error: Cannot open image:" + fileName);
			JOptionPane.showMessageDialog(null, "Error: Cannot open image:" + fileName);
		}
		// Return the obtained Image Class Instantiation
		return image;
	}
	///////////////////////////////

	///////////////////////////////
	// This function starts the game loop (heart beat) of game
	public void startGame() {
		// Creates a new thread for the animator within this class.
		Thread t = new Thread(animator);
		AudioPlayer.play("background", true);
		// Calls the start class within our Thread Instantiation (starts the
		// loop)
		t.start();
	}
	///////////////////////////////

	///////////////////////////////
	// Renders every image 1 by 1 on the screen
	public void gameRender() {
		// If the Image object: dbImage is null
		if (dbImage == null) {

			// createImage(int width, int height)
			// Creates a new, mutable image for off-screen drawing.
			// Mutable images can be modified
			// by rendering to them through a Graphics object
			// obtained from the getGraphics() method of this object.
			dbImage = createImage(PWIDTH, PHEIGHT);
			// if the Image object is still null after trying to createImage
			if (dbImage == null) {
				// Print error
				System.out.println("dbImage is null");
				// return fail (0)
				return;
				// Else dbImage is not null and createImage succeeded
			} else {
				// getGraphics()
				// Creates a new Graphics object that renders to this image.
				// sets it too the previously instantiated Graphics object
				graphics = dbImage.getGraphics();
			}
		}

		// Clears the specified rectangle by filling it with the background
		// color of the current drawing surface.
		graphics.clearRect(0, 0, GamePanel.PWIDTH, GamePanel.PHEIGHT);

		///////////////////////////////
		// Threads communicate primarily by sharing access to fields and the
		/////////////////////////////// objects reference fields refer to.
		// Synchronization prevents thread interference and memory consistency
		/////////////////////////////// errors
		synchronized (gameData.figures) {

			// Instantiates class GameFigure
			GameFigure f;

			//

			graphics.drawImage(mapImage, 0, 0, null);
			Graphics2D g2 = (Graphics2D) graphics;
			g2.setColor(Color.RED);
			g2.setFont(new Font("Serif", Font.PLAIN, 20));
			g2.drawString("Lives: " + gameData.getLives(), 375, 60);
			g2.drawString("Gold: " + gameData.getMoney(), 470, 60);

			///////////////////////////////
			// Creates white box. Puts the image of the Regular Tower in it
			// BUTTON
			Graphics2D g3 = (Graphics2D) graphics;
			g3.setColor(Color.WHITE);
			g3.fillRect(440, 250, 70, 70);
			g3.drawImage(ArrowTowerImage, 450, 250, this);
			///////////////////////////////

			///////////////////////////////
			// Creates white box. Puts the image of the Blue Tower in it
			// BUTTON
			Graphics2D g4 = (Graphics2D) graphics;
			g4.setColor(Color.WHITE);
			g4.fillRect(520, 250, 70, 70);
			g4.drawImage(BlueTowerImage, 530, 250, this);
			///////////////////////////////

			///////////////////////////////
			// Creates Red Text with the name and price for the Regular Tower
			// Info Text
			Graphics2D g5 = (Graphics2D) graphics;
			g5.setColor(Color.RED);
			g5.setFont(new Font("Serif", Font.PLAIN, 16));
			g5.drawString("Tower 1", 450, 240);
			g5.drawString("50 Gold", 450, 330);
			///////////////////////////////

			///////////////////////////////
			// Creates Red Text with the name and price for the Regular Tower
			// Info Text
			Graphics2D g6 = (Graphics2D) graphics;
			g6.setColor(Color.RED);
			g6.setFont(new Font("Serif", Font.PLAIN, 16));
			g6.drawString("Tower 2", 530, 240);
			g6.drawString("100 Gold", 530, 330);
			///////////////////////////////

			///////////////////////////////
			// Creates a Yellow box
			// BUTTON
			Graphics2D g7 = (Graphics2D) graphics;
			g7.setColor(Color.yellow);
			g7.fillRect(250, 295, 100, 30);
			///////////////////////////////

			///////////////////////////////
			// Creates text for the Yellow Button
			Graphics2D g8 = (Graphics2D) graphics;
			g8.setColor(Color.BLACK);
			g8.setFont(new Font("Serif", Font.PLAIN, 20));
			g8.drawString("Next Wave", 255, 317);
			///////////////////////////////

			///////////////////////////////
			//Creates the mute button
			Graphics2D g16 = (Graphics2D) graphics;
			g16.drawImage(mute, 10, 295, this);
			///////////////////////////////
			
			//////////////////////////////
			Graphics2D g12 = (Graphics2D) graphics;
			g12.drawImage(RegularMonsterImage, 30, 30, this);

			Graphics2D g13 = (Graphics2D) graphics;
			g13.drawImage(FastMonsterImage, 88, 30, this);

			Graphics2D g14 = (Graphics2D) graphics;
			g14.drawImage(BossImage, 144, 28, this);

			Graphics2D g15 = (Graphics2D) graphics;
			g15.setColor(Color.RED);
			g15.setFont(new Font("Serif", Font.PLAIN, 20));
			g15.drawString("x" + gameData.getRegularMonsterCount(), 64, 48);
			g15.drawString("x" + gameData.getFastMonsterCount(), 124, 48);
			g15.drawString("x" + gameData.getBossCount(), 180, 48);

			// END GAME CONDITION
			// If the user has no more lives
			if (gameData.lives <= 0) {
				//
				for (int i = 0; i < gameData.figures.size(); i++) {
					f = (GameFigure) gameData.figures.get(i);
					f.setState(GameFigure.STATE_DONE);
				}

				///////////////////////////////
				// Fills the screen from the origin (Top Left Corner) to (1000,
				/////////////////////////////// 1000) with black
				Graphics2D g9 = (Graphics2D) graphics;
				g9.setColor(Color.BLACK);
				g9.fillRect(0, 0, 1000, 1000);
				///////////////////////////////

				///////////////////////////////
				// Renders Red Text in the specified Font to print GAME OVER
				/////////////////////////////// MAN!!!
				Graphics2D g10 = (Graphics2D) graphics;
				g10.setColor(Color.RED);
				g10.setFont(new Font("Serif", Font.PLAIN, 50));
				g10.drawString("GAME OVER, MAN!!!", 75, 100);
				///////////////////////////////

				///////////////////////////////
				// Renders White Text in the specified Font to print the amount
				/////////////////////////////// of waves and the score
				Graphics2D g11 = (Graphics2D) graphics;
				g11.setColor(Color.WHITE);
				g11.setFont(new Font("Serif", Font.PLAIN, 25));
				g11.drawString("Waves Completed: " + gameData.wave, 200, 150);
				g11.drawString("Score: " + gameData.score, 200, 200);
				///////////////////////////////
			}
			///////////////////////////////

			// int i = 0.
			// increment i by 1 each time i is
			// less than the size of the figure object within the gameData
			// object
			for (int i = 0; i < gameData.figures.size(); i++) {

				// get(i): Function gets the object from the collection of
				// figures (images) within the gamedata
				f = (GameFigure) gameData.figures.get(i);

				// Calls render from class GameFigure:
				f.render(graphics);
			}
		}

	}
	///////////////////////////////

	///////////////////////////////
	// This class uses active rendering to put the buffered image on-screen
	public void printScreen() {
		// Instantiagtes the Graphics class
		Graphics g;
		// PLEASE WORK
		try {
			// getGraphics() is a function within the Graphics library imported
			// at top
			// g contains the graphics within THIS class
			g = this.getGraphics();
			// If nothing is in the graphics object
			// and nothing is in image object: dbImage
			// and nothing is in image object: mapImage
			if ((g != null) && (dbImage != null) && (mapImage != null)) {
				// drawImage(Image img, int x, int y, ImageObserver observer)
				// Draws as much of the specified image as is currently
				// available.
				g.drawImage(dbImage, 0, 0, null);
			}
			// sync() - sunchronizes the graphics state on some systems
			Toolkit.getDefaultToolkit().sync();
			// Disposes of this graphics context and releases any system
			// resources that it is using.
			g.dispose();
			// Catch any errors
		} catch (Exception e) {
			System.out.println("Graphics error: " + e);
		}
	}
}

	///////////////////////////////
	// Commented out: It worked before, but i dont believe this is necessary
	/////////////////////////////// (watch for bugs)
	///////////////////////////////
	// private File File(Image mapImage) {
	// throw new UnsupportedOperationException("Not supported yet."); //To
	// change body of generated methods, choose Tools | Templates.
	// }
	///////////////////////////////

