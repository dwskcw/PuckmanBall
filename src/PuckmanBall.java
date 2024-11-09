import static com.raylib.Jaylib.*;
import static com.raylib.Raylib.*;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import com.raylib.Raylib.Image;

// Stores position and velocity of puck
public class Puck {
	private double puckX;
	private double puckY;
	private double velX;
	private double velY;
	
	// default puck- still at center of screen
	public Puck() {
		puckX = 400;
		puckY = 225;
		velX = 0;
		velY = 0;
	}

	public Puck(pX, pY) {
		puckX = pX;
		puckY = pY;
		velX = 0;
		velY = 0;
	}

	// getters
	public double getX() { return puckX; }
	public double getY() { return puckY; }
	public double getVelX() { return velX; }
	public double getVelY() { return velY; }

	public void setX(double pX) { puckX = pX; }
	public void setY(double pY) { puckY = pY; }
	public void setVelX(double vX) { velX = vX; }
	public void setVelY(double vY) { velY = vY; }

}


public class PuckmanBall {
	public static void main(String[] args) {
		// Load images, sounds, etc. here
		//
		//

		// Initial puck-related variables and Puck object
		double pX = 400;
		double pY = 450;
		double pVelX = 0;
		double pVelY = 0;
		Puck p = new Puck(pX, pY);

		int screenWidth = 800;
		int screenHeight = 450;

		InitWindow(800, 450, "Puckman Ball");

		SetTargetFPS(60);

		Image rpiLogo = LoadImage("img/rpi-logo.png"); 
		Texture texture = LoadTextureFromImage(rpiLogo); 
		texture.height(texture.height() / 16);
		texture.width(texture.width() / 16);

		while (!WindowShouldClose()) {

			/*
			 * Update variables
			 *
			 */

			// Puck-related:
			// effectively slightly negative acceleration
			// p.setVelX( p.getVelX() * 0.96 );
			// pVelX *= 0.96;

			// change position by velocity
			// p.setX( p.getX() + p.getVelX() );
			// pY += velY;

			// set puck position
			// p.setX(pX);
			// p.setY(pY);

			/*
			 * Begin drawing objects to screen
			 *
			 */
			BeginDrawing();

			ClearBackground(LIGHTGRAY);

			DrawRectangleRounded(new Jaylib.Rectangle(5, 5, screenWidth - 10, screenHeight - 10), 0.3f, 1, DARKGRAY);	
			DrawRectangleRounded(new Jaylib.Rectangle(10, 10, screenWidth - 20, screenHeight - 20), 0.3f, 1, WHITE);

			DrawRectangle(screenWidth/2 - 2, 10, 4, screenHeight - 20, RED);
			DrawRectangle((int)(screenWidth * 0.15) - 2, 10, 4, screenHeight- 20, RED);
			DrawRectangle((int)(screenWidth * 0.85) - 2, 10, 4, screenHeight- 20, RED);



			DrawCircle(screenWidth/2, screenHeight/2, 40, RED);
			DrawCircle(screenWidth/2, screenHeight/2, 37, WHITE);
			DrawTexture(texture, screenWidth/2 - texture.width()/2, screenHeight/2 - texture.height()/2, WHITE);

			DrawRectangle(screenWidth - screenWidth/16, screenHeight / 3, screenWidth/16 - 10, screenHeight/3, RED);
			DrawRectangle(screenWidth - screenWidth/16 + 3, screenHeight / 3 + 3, screenWidth/16 - 13, screenHeight/3 - 6, WHITE);
			DrawRectangle(10, screenHeight / 3, screenWidth/16 - 10, screenHeight/3, RED);
			DrawRectangle(10, screenHeight / 3 + 3, screenWidth/16 - 13, screenHeight/3 - 6, WHITE);

			DrawText("Puckman", 190, 200, 20, BLACK);


			EndDrawing();
		}

		CloseWindow();

		// UNLOAD all images, sounds, etc. here
		//
		//
	}
}
