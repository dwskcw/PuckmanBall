import static com.raylib.Jaylib.*;
import static com.raylib.Raylib.*;

import com.raylib.Jaylib;
import com.raylib.Raylib;

public class PuckmanBall {
	public static void main(String[] args) {

		int screenWidth = 800;
		int screenHeight = 450;

		InitWindow(800, 450, "Puckman Ball");

		SetTargetFPS(60);

		while (!WindowShouldClose()) {
			BeginDrawing();

			ClearBackground(LIGHTGRAY);

			DrawRectangleRounded(new Jaylib.Rectangle(5, 5, screenWidth - 10, screenHeight - 10), 0.3f, 1, DARKGRAY);	
			DrawRectangleRounded(new Jaylib.Rectangle(10, 10, screenWidth - 20, screenHeight - 20), 0.3f, 1, WHITE);

			DrawRectangle(screenWidth/2 - 2, 10, 4, screenHeight - 20, RED);
			DrawRectangle((int)(screenWidth * 0.15) - 2, 10, 4, screenHeight- 20, RED);
			DrawRectangle((int)(screenWidth * 0.85) - 2, 10, 4, screenHeight- 20, RED);

			DrawCircle(screenWidth/2, screenHeight/2, 30, RED);
			DrawCircle(screenWidth/2, screenHeight/2, 27, WHITE);
			DrawCircle(screenWidth/2, screenHeight/2, 3, RED);

			DrawRectangle(screenWidth - screenWidth/16, screenHeight / 3, screenWidth/16 - 10, screenHeight/3, RED);
			DrawRectangle(screenWidth - screenWidth/16 + 3, screenHeight / 3 + 3, screenWidth/16 - 13, screenHeight/3 - 6, WHITE);
			DrawRectangle(10, screenHeight / 3, screenWidth/16 - 10, screenHeight/3, RED);
			DrawRectangle(10, screenHeight / 3 + 3, screenWidth/16 - 13, screenHeight/3 - 6, WHITE);

			DrawText("Puckman", 190, 200, 20, BLACK);


			EndDrawing();
		}

		CloseWindow();
	}
}
