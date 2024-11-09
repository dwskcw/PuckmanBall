import static com.raylib.Jaylib.*;
import static com.raylib.Raylib.*;

import com.raylib.Jaylib;

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

		final int PLAYER_X = 125;
		final int PLAYER_Y = 200;
		int play1X = 75;
		int play1Y = 150;
		int play2X = 660;
		int play2Y = 150;
		

		int screenWidth = 800;
		int screenHeight = 450;

		InitWindow(800, 450, "Puckman Ball");

		SetTargetFPS(60);

		Image rpiLogo = LoadImage("img/rpi-logo.png"); 
		Texture texture = LoadTextureFromImage(rpiLogo); 
		texture.height(texture.height() / 16);
		texture.width(texture.width() / 16);

		Image puckImg = LoadImage("img/puck.png");
		Texture puck = LoadTextureFromImage(puckImg);

		while (!WindowShouldClose()) {

			/*
			 * Update variables
			 *
			 */

			pVelX *= 0.96;
			pVelY *= 0.96;

			// change position by velocity
			pY += pVelY;
			pX += pVelX;

			/*
			 * Begin drawing objects to screen
			 *
			 */
			BeginDrawing();

			ClearBackground(LIGHTGRAY);



			// Draw the stadium to screen

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

			
			
			
			// DrawText("Puckman", 190, 200, 20, BLACK);

			DrawTexture(puck, (int)(pX - puck.width() / 2), (int)(pY - puck.height() / 2), WHITE);

			EndDrawing();
		}

		CloseWindow();

		// UNLOAD all images, sounds, etc. here
		//
		//
		
		UnloadTexture(texture);
		UnloadImage(rpiLogo);

		UnloadTexture(puck);
		UnloadImage(puckImg);

	}
}
