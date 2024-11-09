import static com.raylib.Jaylib.*;
import static com.raylib.Raylib.*;

import com.raylib.Raylib;

public class PuckmanBall {
	public static void main(String[] args) {

		int screenWidth = 800;
		int screenHeight = 450;

		InitWindow(800, 450, "Puckman Ball");

		SetTargetFPS(60);

		while (!WindowShouldClose()) {

			//
			//


			BeginDrawing();

			ClearBackground(LIGHTGRAY);
			
			DrawText("Puckman", 190, 200, 20, RAYWHITE);

			EndDrawing();

		}

		CloseWindow();

	}

}
