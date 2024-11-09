# PuckmanBall
HackRPI 2024 Project

### build instructions
**modified from the [library instructions](https://github.com/electronstudio/jaylib?tab=readme-ov-file#how-to-use-from-command-line)**

Compile:

    javac -cp jaylib-5.0.0-0.jar PuckmanBall.java
    
Run it:

    java -cp jaylib-5.0.0-0.jar:. PuckmanBall
    
On MacOS you need this additional option:

    java -XstartOnFirstThread -cp jaylib-5.0.0-0.jar:. PuckmanBall
    
On weirdy Windows you use semi-colons:

    java -cp jaylib-5.0.0-0.jar;. PuckmanBall


### raylib library resources

**function cheatsheet**
https://www.raylib.com/cheatsheet/cheatsheet.html

**[Java-specific examples](https://github.com/electronstudio/jaylib-example-project/tree/master/src/main/java/examples)**

**various examples**
https://www.raylib.com/examples.html

**game examples**
https://www.raylib.com/games.html
