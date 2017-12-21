package mainGame;

import Engine.GameEngine;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameManager
{
    //Private Static Fields
    private static GameEngine _engineInstance;
    private static boolean _showPropertyDebugMode = false;

    //Private Variables - UI
    private Stage _primaryStage;
    private GraphicsContext _gc;
    private Timeline _gameLoop;
    private ViewPort _viewPort;

    //Constructor
    public GameManager(Stage displayStage) throws Exception
    {
        _primaryStage = displayStage;
        _engineInstance = new GameEngine();

        InitRenderLoop();
        InitStage();
        InitKeyHandlers();
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

    private void InitStage()
    {
        Group root = new Group();
        Scene scene = new Scene( root );

//        if(_isFullscreen)
//        {
//            _primaryStage.setFullScreen(true);
//            Scale scale = new Scale(1.8, 1.8);
//            scale.setPivotX(0);
//            scale.setPivotY(0);
//            scene.getRoot().getTransforms().setAll(scale);
//        }

        _primaryStage.setScene( scene );

        _viewPort = new ViewPort(
                ViewPort.X_RES,
                ViewPort.Y_RES,
                GameConstants.GAME_STARTING_POINT.x,
                GameConstants.GAME_STARTING_POINT.y,
                GameConstants.DEFAULT_SECTOR_WIDTH,
                GameConstants.DEFAULT_SECTOR_HEIGHT
        );

        Canvas canvas = new Canvas( ViewPort.X_RES, ViewPort.Y_RES );
        root.getChildren().add( canvas );
        _gc = canvas.getGraphicsContext2D();

    }

    private void InitKeyHandlers()
    {
        _primaryStage.getScene().setOnKeyPressed(
                new EventHandler<KeyEvent>()
                {
                    @Override
                    public void handle(KeyEvent event)
                    {
                        GameConstants.SetKeyPressed(event.getCode());

                        //Shift + Ctrl + X enters debug mode.
                        if(event.getCode() == KeyCode.X
                                && event.isShiftDown()
                                && event.isControlDown())
                        {
                            _showPropertyDebugMode = !_showPropertyDebugMode;
                        }
                    }
                });

        _primaryStage.getScene().setOnKeyReleased(
                new EventHandler<KeyEvent>()
                {
                    @Override
                    public void handle(KeyEvent event)
                    {
                        GameConstants.SetKeyReleased(event.getCode());
                    }
                });
    }
}
