import static com.raylib.Jaylib.*;
import static com.raylib.Raylib.*;

import com.raylib.Jaylib;
import com.raylib.Raylib;

public class PuckmanBall {
	public static void main(String[] args) {
		// Load images, sounds, etc. here
		//
		//

		// Initial puck-related variables and Puck object
		double pX = 400;
		double pY = 225;
		double pVelX = -10;
		double pVelY = -10;

		double play1X = 100;
		double play1Y = 225;
		double p1VelY = 0.05;
		double p1VelX = 0.05;
		double play2X = 700;
		double play2Y = 225;
		double p2VelY = 0.05;
		double p2VelX = 0.05;
		
		int p1score = 0;
		int p2score = 0;

		int screenWidth = 800;
		int screenHeight = 450;

		InitWindow(800, 450, "Puckman Ball");

		SetTargetFPS(60);

		Image rpiLogo = LoadImage("resources/rpi-logo.png"); 
		Texture logo = LoadTextureFromImage(rpiLogo); 
		logo.height(logo.height() / 16);
		logo.width(logo.width() / 16);

		Image puckImg = LoadImage("resources/puck.png");
		Texture puck = LoadTextureFromImage(puckImg);
		puck.height( puck.height() / 3 );
		puck.width( puck.width() / 3 );

		Image p1Img = LoadImage("resources/puckman.png");
		Texture p1 = LoadTextureFromImage(p1Img);
		p1.height( (int)(p1.height() / 1.75) );
		p1.width( (int)(p1.width() / 1.75) );

		Image p2Img = LoadImage("resources/greenpuckman.png");
                Texture p2 = LoadTextureFromImage(p2Img);
                p2.height( (int)(p2.height() / 1.75) );
                p2.width( (int)(p2.width() / 1.75) );


		while (!WindowShouldClose()) {

			/*
			 * Update variables
			 *
			 */

			pVelX *= 0.98;
			pVelY *= 0.98;

			// change position by velocity
			pY += pVelY;
			pX += pVelX;

			// Puck bounds check
			// TODO: advanced collision for rounded corners
			if (pX <= 20) {
				pX = 21;
				pVelX -= 1.75 * pVelX;
			}
			if (pX >= 780) {
				pX = 779;
				pVelX -= 1.75 * pVelX;
			}
			if (pY <= 20) {
				pY = 21;
				pVelY -= 1.75 * pVelY;
			}
			if (pY >= 430) {
				pY = 429;
				pVelY -= 1.75 * pVelY;
			}

			// bounds for both players
			if (play1X <= 20) {
                                play1X = 21;
                                p2VelX -= 1.75 * p2VelX;
                        }
                        if (play1X >= 780) {
                                play1X = 779;
                                p1VelX -= 1.75 * p1VelX;
                        }
                        if (play1Y <= 20) {
                                play1Y = 21;
                                p1VelY -= 1.75 * p1VelY;
                        }
                        if (play1Y >= 430) {
                                play1Y = 429;
                                p1VelY -= 1.75 * p1VelY;
                        }

			if (play2X <= 20) {
                                play2X = 21;
                                p2VelX -= 1.75 * p2VelX;
                        }
                        if (play2X >= 780) {
                                play2X = 779;
                                p2VelX -= 1.75 * p2VelX;
                        }
                        if (play2Y <= 20) {
                                play2Y = 21;
                                p2VelY -= 1.75 * p2VelY;
                        }
                        if (play2Y >= 430) {
                                play2Y = 429;
                                p2VelY -= 1.75 * p2VelY;
                        }

			p1VelX *= 0.98;
			p1VelY *= 0.98;
			p2VelX *= 0.98;
			p2VelY *= 0.98;


			play1X += p1VelX;
			play1Y += p1VelY;
			play2X += p2VelX;
			play2Y += p2VelY;

			// Detect key presses to move both players
			if ( IsKeyDown( Raylib.KEY_W ) ) { p1VelY -= 0.25; }
			if ( IsKeyDown( Raylib.KEY_S ) ) { p1VelY += 0.25; }
			if ( IsKeyDown( Raylib.KEY_A ) ) { p1VelX -= 0.25; }
			if ( IsKeyDown( Raylib.KEY_D ) ) { p1VelX += 0.25; }
			if ( IsKeyDown( Raylib.KEY_UP ) ) { p2VelY -= 0.25; }
			if ( IsKeyDown( Raylib.KEY_DOWN ) ) { p2VelY += 0.25; }
			if ( IsKeyDown( Raylib.KEY_LEFT ) ) { p2VelX -= 0.25; }
			if ( IsKeyDown( Raylib.KEY_RIGHT ) ) { p2VelX += 0.25; }

				

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
			DrawTexture(logo, screenWidth/2 - logo.width()/2, screenHeight/2 - logo.height()/2, WHITE);

			DrawRectangle(screenWidth - screenWidth/16, screenHeight / 3, screenWidth/16 - 10, screenHeight/3, ColorFromHSV(180f, 1, 1));
			DrawRectangle(screenWidth - screenWidth/16 + 3, screenHeight / 3 + 3, screenWidth/16 - 13, screenHeight/3 - 6, WHITE);
			DrawRectangle(10, screenHeight / 3, screenWidth/16 - 10, screenHeight/3, RED);
			DrawRectangle(10, screenHeight / 3 + 3, screenWidth/16 - 13, screenHeight/3 - 6, WHITE);

			
			DrawText(String.valueOf(p1score), screenWidth * 1 / 4 - 10, screenHeight/10, 70, BLACK);
			DrawText(String.valueOf(p2score), screenWidth * 3 / 4 - 10, screenHeight/10, 70, BLACK);
			
			// DrawText("Puckman", 190, 200, 20, BLACK);

			DrawTexture(p1, (int)(play1X - p1.width() / 2), (int)(play1Y - p1.height() / 2), WHITE);
			DrawTexture(p2, (int)(play2X - p1.width() / 2), (int)(play2Y - p2.height() / 2), WHITE);
			DrawTexture(puck, (int)(pX - 25), (int)(pY - 25), WHITE);

			EndDrawing();
		}

		CloseWindow();

		// UNLOAD all images, sounds, etc. here
		//
		//
		
		UnloadTexture(logo);
		UnloadImage(rpiLogo);

		UnloadTexture(puck);
		UnloadImage(puckImg);

		UnloadTexture(p1);
		UnloadImage(p1Img);

	}
}
