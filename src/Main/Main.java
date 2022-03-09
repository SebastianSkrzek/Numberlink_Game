import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


        GameController gameController = new GameController();
        BoardModel boardModel = new BoardModel();
        BoardView boardView = new BoardView();

        boardView.setBoardModel(boardModel);
        boardView.setGameController(gameController);

        gameController.setBoardModel(boardModel);
        gameController.setBoardView(boardView);

        boardModel.setBoardView(boardView);
        boardModel.setGameController(gameController);

        boardView.setUp();
    }
}
