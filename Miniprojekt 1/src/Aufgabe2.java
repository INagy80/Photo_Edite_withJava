import java.nio.channels.Pipe;

/**
 * Image Manipulation
 * 
 * @author Marcus
 */
public class Aufgabe2 {

	/**
	 * Converts a RGB color to a gray scale.
	 * 
	 * @param rgb The RGB value to convert.
	 * @return The gray scale value.
	 */
	public static int convertColorToGrayscale(int rgb) {

		int zahl = rgb;
		int grauwert = Colors.toRGB ( zahl, zahl , zahl);
		return grauwert;
	}
	
	/**
	 * Converts the pixels of an image from RGB to a gray scale.
	 * 
	 * @param pixels The input pixels.
	 * @return The modified pixels.
	 */
	public static int[][] convertPictureToGrayscale(int[][] pixels) {
		for (int i = 0; i < pixels.length; i++) {
			for (int j = 0; j < pixels[i].length; j++) {
				pixels[i][j] = convertColorToGrayscale(pixels[i][j]);
			}
		}
		return pixels;
	}
	
	/**
	 * Converts a picture by dividing it in three equal parts along the X axis. 
	 * In the first (left) part, only the red component is drawn. In the second 
	 * (middle) part, only the green component is drawn. In the third (right) part,
	 * only the blue component is drawn.
	 * 
	 * @param pixels The input pixels.
	 * @return The output pixels.
	 */
	public static int[][] andyWarhol(int[][] pixels) {

		for (int i = 0; i < pixels.length/3; i++) {
			for (int j = 0; j < pixels[i].length; j++) {
				int newpixel = Colors.toRGB(Colors.getR(pixels[i][j]), 0, 0);
                pixels[i][j] = newpixel;
			}
		}
		for (int i = pixels.length/3; i < 2 * pixels.length/3; i++) {
			for (int j = 0; j < pixels[i].length; j++) {
				int newpixel = Colors.toRGB(0,Colors.getG(pixels[i][j]), 0);
				pixels[i][j] = newpixel;

			}
		}

		for (int i = 2 * pixels.length / 3; i <  pixels.length; i++) {
			for (int j = 0; j < pixels[i].length; j++) {
				int newpixel = Colors.toRGB(0, 0, Colors.getG(pixels[i][j]));
				pixels[i][j] = newpixel;
			}
		}
		return pixels;
	}
	
	/**
	 * Draws a border of the specified borderWidth with the specified borderColor
	 * onto the picture.
	 * 
	 * @param pixels The pixels of the picture.
	 * @param borderWidth The border width in number of pixels (>= 0).
	 * @param borderColor The border color.
	 * @return The picture with a border of the specified width and color.
	 */
	public static  int[][] drawBorderOnPicture(int[][] pixels, int borderWidth, int borderColor) {

		for (int i = 0; i < pixels.length; i++) {
			for (int j = 0; j < pixels[i].length; j++) {
				for (int k = 0; k < borderWidth; k++) {
					pixels[k][j] = borderColor;
					pixels[i][k] = borderColor;
				}
				}
			}
		for (int i = pixels.length -1; i >= 0; i--) {
			for (int j = pixels[i].length -1 ; j >= 0 ; j--) {
				for (int k = pixels.length -1 ; k > pixels.length - borderWidth; k--) {
					for (int l = pixels[i].length -1 ; l > pixels[i].length - borderWidth ; l--) {
						pixels[k][j] = borderColor;
						pixels[i][l] = borderColor;
					}
				}
			}
		}


		return pixels;
	}
	
	/**
	 * Extends a picture with a border with the specified borderWidth and borderColor.
	 * 
	 * @param pixels The pixels of the picture.
	 * @param borderWidth The width of the border in pixels (>= 0).
	 * @param borderColor The border color.
	 * @return The extended picture with a border with the specified number of pixels in the specified color.
	 */
	public static  int[][] extendPictureWithBorder(int[][] pixels, int borderWidth, int borderColor) {
		int[][] newpixels = new int[pixels.length + 2 * borderWidth][ pixels[pixels.length-1].length +  2 * borderWidth];
		for (int i = 0; i < pixels.length; i++) {
			for (int j = 0; j < pixels[i].length; j++) {
				newpixels[i+borderWidth][j+borderWidth] = pixels[i][j];
			}
		}


		/*
		falsche antwort

		for (int i = borderWidth; i < newpixels.length- borderWidth ; i++) {
			for (int j = borderWidth; j < newpixels[i].length -borderWidth; j++) {
				for (int k = 0; k < pixels.length; k++) {
					for (int l = 0; l < pixels[k].length; l++) {
						newpixels[i][j] = pixels[k][l];
					}
				}
			}
		}*/



		for (int i = 0; i < newpixels.length; i++) {
			for (int j = 0; j < newpixels[i].length; j++) {
				for (int k = 0; k < borderWidth; k++) {
					newpixels[k][j] = borderColor;
					newpixels[i][k] = borderColor;
				}
			}
		}
		for (int i = newpixels.length -1; i >= 0; i--) {
			for (int j = newpixels[i].length -1 ; j >= 0 ; j--) {
				for (int k = newpixels.length -1 ; k > newpixels.length - borderWidth; k--) {
					for (int l = newpixels[i].length -1 ; l > newpixels[i].length - borderWidth ; l--) {
						newpixels[k][j] = borderColor;
						newpixels[i][l] = borderColor;
					}
				}
			}
		}

		return newpixels;

	}
	
	/**
	 * Rotates a picture by 90 degrees by swapping out the
	 * x and y axis.
	 * 
	 * @param pixels The pixels.
	 * @return The rotated picture.
	 */
	public static int[][] rotatePicture(int[][] pixels) {
		int [][] newpixels = new int[pixels[pixels.length-1].length][pixels.length];
		for (int i = 0; i < pixels.length; i++) {
			for (int j = 0; j < pixels[i].length; j++) {
				newpixels[j][pixels.length-1-i] = pixels[i][j];
			}
		}

		return newpixels;
	}
	
	/**
	 * Computes the size of an axis when shrinking it by only drawing
	 * every n-th pixel.
	 * 
	 * @param length The length of the axis (>0)
	 * @param n The interval of the pixels (>0).
	 * @return The number of pixels on the axis.
	 */
	public static int computeShrinkedSize(int length, int n) {
		if(length % n == 0){
			return length/n;

		}


		return length/n+1;
	}
	
	/**
	 * Shrinks a picture while keeping the aspect ratio
	 * by drawing only every n-th pixel in each dimension.
	 * 
	 * @param pixels The pixels of the image.
	 * @param n The n to define how much to shrink the picture.
	 * @return The shrunken picture.
	 */
	public static int[][] shrinkPicture(int[][] pixels, int n) {
		int[][] newpixels = new int[computeShrinkedSize( pixels.length,n)][computeShrinkedSize( pixels[pixels.length-1].length,n)];
		for (int i = 0; i < newpixels.length; i++) {
			for (int j = 0; j < newpixels[i].length; j++) {


              newpixels[i][j] += pixels[i*n][j*n];


			}
				}


		return newpixels;
	}
	
	/**
	 * Computes the average color of a group of pixels in another array starting at
	 * startX and startY going to min(startX + n, pixels.length), 
	 * min(startY + n, pixels[0].length).
	 * 
	 * @param pixels The pixels
	 * @param startX The x coordinate of the start.
	 * @param startY The y coordinate of the start.
	 * @param n The number of pixels in each dimension.
	 * @return The (component-wise) average color value representing the group of pixels.
	 */
	public static int computeAverageColor(int[][] pixels, int startX, int startY, int n) {
		int red = 0;
		int green = 0;
		int blue = 0;
		int count = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n ; j++) {
				if(startX+i < pixels.length && startY + j < pixels[0].length) {
					red += Colors.getR(pixels[startX+i][startY+j]);
					green += Colors.getG(pixels[startX+i][startY+j]);
					blue += Colors.getB(pixels[startX+i][startY+j]);
					count++;

				}

			}

		}
		red /= count;
		green /= count;
		blue /= count;

		return Colors.toRGB(red, green, blue);
	}
	
	/**
	 * Smoothly shrinks a picture while keeping the aspect ratio
	 * by drawing only every n-th pixel in each dimension but
	 * using the average of all "shrunken" pixels.  
	 * 
	 * @param pixels The input pixels.
	 * @param n The n to define how much to shrink the picture.
	 * @return The smoothly shrunken picture.
	 */
	public static int[][] shrinkPictureSmooth(int[][] pixels, int n) {

		int[][] newpixels = new int[computeShrinkedSize( pixels.length,n)][computeShrinkedSize( pixels[pixels.length-1].length,n)];

		computeAverageColor(pixels,computeShrinkedSize( pixels.length,n),computeShrinkedSize( pixels[pixels.length-1].length,n),n);
		for (int i = 0; i < newpixels.length; i++) {
			for (int j = 0; j < newpixels[i].length; j++) {






				    newpixels[i][j] += computeAverageColor(pixels, i*n, j*n, n);


			}
		}


		return newpixels;
	}
	
	
	/**
	 * Reads a picture, runs all conversion methods and saves
	 * the output to a new file with the following format:
	 * 
	 * name-'conversion'-'timestamp'
	 * 
	 * @param args Not used.
	 */
	public static void main(String[] args) {
		String name = "notre-dame";
		String extension = ".png";
		String input = name + extension;
		long timestamp = System.currentTimeMillis();
		Images.writeImage(name + "-gray-" + timestamp + extension, convertPictureToGrayscale(Images.readImage(input)));
		Images.writeImage(name + "-warhol-" + timestamp + extension, andyWarhol(Images.readImage(input)));
		Images.writeImage(name + "-draw-" + timestamp + extension, drawBorderOnPicture(Images.readImage(input), 100, Colors.toRGB(255, 0, 0)));
		Images.writeImage(name + "-extend-" + timestamp + extension, extendPictureWithBorder(Images.readImage(input), 100, Colors.toRGB(0, 255, 0)));
		Images.writeImage(name + "-rotate-" + timestamp + extension, rotatePicture(Images.readImage(input)));
		Images.writeImage(name + "-shrink-" + timestamp + extension, shrinkPicture(Images.readImage(input), 3));
		Images.writeImage(name + "-smooth-" + timestamp + extension, shrinkPictureSmooth(Images.readImage(input), 3));
	}
	
	
	
	
	
}
