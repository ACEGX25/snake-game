# Snake Game

This is a classic Snake Game implemented using Java, JavaFX, and Swing. The game involves controlling a snake to eat food, grow in length, and avoid collisions with the walls and itself.


## Features
- Classic snake game mechanics.
- Smooth gameplay with responsive controls.
- Visual interface using JavaFX for modern and enhanced graphics.
- Legacy support with Swing for compatibility.

## Requirements
- Java Development Kit (JDK) 8 or higher
- JavaFX SDK
- Any Java IDE (IntelliJ IDEA, Eclipse, NetBeans, etc.)

## Installation
1. **Clone the repository:**
    ```sh
    git clone https://github.com/ACEGX25/snake-game.git
    ```
2. **Navigate to the project directory:**
    ```sh
    cd snake-game
    ```
3. **Set up JavaFX:**
    - Download the JavaFX SDK from the official [website](https://openjfx.io/).
    - Extract the JavaFX SDK and set the `PATH_TO_FX` environment variable to the `lib` directory of the extracted SDK.

4. **Open the project in your preferred Java IDE.**
5. **Configure your IDE to include the JavaFX libraries:**
    - For IntelliJ IDEA: 
        1. Open `Project Structure` (Ctrl+Alt+Shift+S).
        2. Go to `Libraries` and add the JavaFX SDK `lib` directory.
        3. In `Run/Debug Configurations`, add VM options:
            ```
            --module-path PATH_TO_FX --add-modules javafx.controls,javafx.fxml
            ```

## Usage
1. **Run the Main class:**
    - Locate the `snakegame.java` file in the `src` directory.
    - Run the file as a Java application.

2. **Game will start and display the main menu.**

## Game Controls
- **Arrow Keys**: Move the snake up, down, left, or right.
  
### Adding New Features
- Fork the repository.
- Create a new branch for your feature: `git checkout -b feature-name`.
- Commit your changes: `git commit -am 'Add new feature'`.
- Push to the branch: `git push origin feature-name`.
- Submit a pull request.
- Added a jar file for quick overlook.

### Screenshots
![Screenshot 2024-06-08 161919](https://github.com/ACEGX25/snake-game/assets/143728245/010aebed-18ea-4272-9893-ca51738486a5)


![Screenshot 2024-06-11 111213](https://github.com/ACEGX25/snake-game/assets/143728245/c0b7a5b6-9c86-4292-bbfa-0879e1a9d7b9)
