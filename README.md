# PuckmanBall
HackRPI 2024 Project

### build instructions
in a terminal
compile:

    javac -cp lib/jaylib-5.0.0-0.jar src/PuckmanBall.java
    
run (windows uses semicolon instead of colon, also slashes might be different):

    java -cp lib/jaylib-5.0.0-0.jar:. src/PuckmanBall.java
    
run (mac requires -XstartOnFirstThread after java):

    java -cp lib/jaylib-5.0.0-0.jar:. src/PuckmanBall.java
