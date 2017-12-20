package mainGame;

import Engine.GameEngine;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameManager
{
    //Private Static Fields
    private static GameEngine _engineInstance;

    //Private Variables - UI
    private Stage _primaryStage;
    private GraphicsContext _gc;
    private Timeline _gameLoop;

    //Constructor
    public GameManager(Stage displayStage) throws Exception
    {
        _primaryStage = displayStage;
        _engineInstance = new GameEngine();
    }

    //Get Methods

    //Set Methods

    //Public Methods
    public void Start() throws Exception
    {
        _engineInstance.Start();
        _gameLoop.play();
    }

    //Private Methods
    private void InitRenderLoop()
    {
        _gameLoop = new Timeline();
        _gameLoop.setCycleCount( Timeline.INDEFINITE );
        KeyFrame kf = Render(_gc);
        _gameLoop.getKeyFrames().add( kf );
    }

    public KeyFrame Render(final GraphicsContext gc)
    {
        return new KeyFrame(
                Duration.seconds(0.017),
                new EventHandler<ActionEvent>()
                {
                    public void handle(ActionEvent ae)
                    {
                        //gc.clearRect(0, 0, _viewPort.GetWidth(), _viewPort.GetHeight());
                    }
                });
    }
}
