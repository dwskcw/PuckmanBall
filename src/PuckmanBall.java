import static com.raylib.Jaylib.*;
import static com.raylib.Raylib.*;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import com.raylib.Raylib.Image;
import com.raylib.Raylib.Texture;

public class PuckmanBall {
	public static void main(String[] args) {
		// Load images, sounds, etc. here
		//
		//
		/* Image goalScore = Raylib.LoadImageAnim("resources/goalgif.gif", 0);
		Texture2D texGoalScore = LoadTextureFromImage(goalScore); IDK. But add this to goalBox collisions. Or not...
		^^ https://www.raylib.com/examples/textures/loader.html?name=textures_gif_player
		Do something with the sound. Maybe if puck goes a fast enough speed after play a hardslap sound */
		Sound goalSound = LoadSound("rpigoalsfx.mp3");

		// Initial puck-related variables and Puck object
		double pX = 400;
		double pY = 225;
		double pVelX = -10;
		double pVelY = -10;


		/* Something with the movement feels weird. 
		   Might be too slow of acceleration and puck slows down too much
		   Do we want puckmans to collide with each other or do we want them
		   to stay the way they are OR only be able to move on one half
		*/
		
		double play1X = 100;
		double play1Y = 225;
		double p1VelY = 0.05;
		double p1VelX = 0.05;
		double play2X = 700;
		double play2Y = 225;
		double p2VelY = 0.05;
		double p2VelX = 0.05;

		int p1Score = 0;
		int p2Score = 0;
		
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
								p1VelX -= 1.75 * p1VelX;
                            //  p2VelX -= 1.75 * p2VelX; Lol
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


			// HITBOXES
			Jaylib.Rectangle puckBox = new Jaylib.Rectangle((float)pX, (float)pY, (float)puck.width(), (float)puck.height()); 
			// Note: It would be better if these were circles for hitting and scoring purposes. Puckman Feet >:( .

			Jaylib.Rectangle p1Box = new Jaylib.Rectangle((float)play1X, (float)play1Y, (float)p1.width(), (float)p1.height());
			Jaylib.Rectangle p2Box = new Jaylib.Rectangle((float)play2X, (float)play2Y, (float)p2.width(), (float)p2.height());

			// Check for collision
			if (Jaylib.CheckCollisionRecs(p1Box, puckBox)) {
				float deltaX = (float)pX - (float)play1X;
				float deltaY = (float)pY - (float)play1Y;
				float angle = (float)Math.atan2(deltaY, deltaX);

				// Adjust puck velocity based on the collision angle and player's velocity
				pVelX = (float)(Math.cos(angle) * Math.abs(pVelX) + p1VelX);
				pVelY = (float)(Math.sin(angle) * Math.abs(pVelY) + p1VelY);
			}

			if (Jaylib.CheckCollisionRecs(p2Box, puckBox)) {
				float deltaX = (float)pX - (float)play2X;
				float deltaY = (float)pY - (float)play2Y;
				float angle = (float)Math.atan2(deltaY, deltaX);

				// Adjust puck velocity based on the collision angle and player's velocity
				pVelX = (float)(Math.cos(angle) * Math.abs(pVelX) + p2VelX);
				pVelY = (float)(Math.sin(angle) * Math.abs(pVelY) + p2VelY);
			}
			
			DrawRectangle(screenWidth - screenWidth/16, screenHeight / 3, screenWidth/16 - 10, screenHeight/3, ColorFromHSV(180f, 1, 1));

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

			DrawText(String.valueOf(p1Score), screenWidth * 1 / 4 - 10, screenHeight/10, 70, BLACK);
			DrawText(String.valueOf(p2Score), screenWidth * 3 / 4 - 10, screenHeight/10, 70, BLACK);

			DrawCircle(screenWidth/2, screenHeight/2, 40, RED);
			DrawCircle(screenWidth/2, screenHeight/2, 37, WHITE);
			DrawTexture(logo, screenWidth/2 - logo.width()/2, screenHeight/2 - logo.height()/2, WHITE);

			// Right/Player 2 Goal Box
			DrawRectangle(screenWidth - screenWidth/16, screenHeight / 3, screenWidth/16 - 10, screenHeight/3, ColorFromHSV(180f, 1, 1));
			DrawRectangle(screenWidth - screenWidth/16 + 3, screenHeight / 3 + 3, screenWidth/16 - 13, screenHeight/3 - 6, WHITE);

			
			Jaylib.Rectangle p2GoalBox = new Jaylib.Rectangle((float)screenWidth-15, (float)screenHeight / 3 + screenHeight/27, 
											4, (float)screenHeight/3 - screenHeight/15);

			DrawRectangle(screenWidth-15,screenHeight / 3 + screenHeight/27, 4, screenHeight/3 - screenHeight/14,BLACK);
			if (Jaylib.CheckCollisionRecs(p2GoalBox, puckBox)) {
				p1Score++;
				pY = screenHeight/2;
				pX = screenWidth/2 + 40;
				PlaySound(goalSound);
				pVelX = 0;
				pVelY = 0;
				// Position reset
				play1X = 100;
				play1Y = 225;
				p1VelY = 0.05;
				p1VelX = 0.05;
				play2X = 700;
				play2Y = 225;
				p2VelY = 0.05;
				p2VelX = 0.05;
			}

			// Left/Player 1 Goal Box
			DrawRectangle(10, screenHeight / 3, screenWidth/16 - 10, screenHeight/3, RED);
			DrawRectangle(10, screenHeight / 3 + 3, screenWidth/16 - 13, screenHeight/3 - 6, WHITE);

			Jaylib.Rectangle p1GoalBox = new Jaylib.Rectangle(20,screenHeight / 3 + screenHeight/27, 4, screenHeight/3 - screenHeight/14);

			DrawRectangle(15,screenHeight / 3 + screenHeight/27, 4, screenHeight/3 - screenHeight/14,BLACK);

			if (Jaylib.CheckCollisionRecs(p1GoalBox, puckBox)) {
				p2Score++;
				pY = screenHeight/2;
				pX = screenWidth/2 - 40;
				PlaySound(goalSound);
				pVelX = 0;
				pVelY = 0;
				// Position reset
				play1X = 100;
				play1Y = 225;
				p1VelY = 0.05;
				p1VelX = 0.05;
				play2X = 700;
				play2Y = 225;
				p2VelY = 0.05;
				p2VelX = 0.05;
			}

			if (p1Score == 7) {
				DrawText("Player 1 Wins", screenWidth/4, screenHeight/2, 50, BLACK);
			}

			if (p2Score == 7) {
				DrawText("Player 2 Wins", screenWidth/4, screenHeight/2, 50, BLACK);
			}
	


	
			//DrawText( X, Y, font size, color
			// DrawText("Puckman", 190, 200, 20, BLACK);

			DrawTexture(p1, (int)(play1X - p1.width() / 2), (int)(play1Y - p1.height() / 2), WHITE);
			DrawTexture(p2, (int)(play2X - p1.width() / 2), (int)(play2Y - p2.height() / 2), WHITE);
			DrawTexture(puck, (int)(pX - 25), (int)(pY - 25), WHITE);

			

			EndDrawing();
		}

		UnloadSound(goalSound);
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
