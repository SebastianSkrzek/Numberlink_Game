import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GameController implements ActionListener {

    BoardView boardView;
    BoardModel boardModel;

    GameManual gameManual;

    public GameController() throws IOException {

        gameManual = new GameManual("AboutGame.txt", "Rules.txt");
        gameManual.createAboutGame();
        gameManual.createRules();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object from = e.getSource();

        for(int i=0;i<boardModel.getSize()+1;i++)
        {
            for(int j=0;j<boardModel.getSize()+1;j++)
            {
                if(from==boardView.getButton()[i][j] && !boardView.getButton()[i][j].isDigit()){
                    boardView.getButton()[i][j].setColor(boardView.getColor());
                    boardView.getButton()[i][j].setBackground(boardView.getColor());
                }
            }
        }

        if (from==boardView.getrBrak()){
            boardView.setColor(Color.WHITE);
        }

        else if (from==boardView.getR1()){
            boardView.setColor(Color.RED);
        }

        else if (from==boardView.getR2()){
            boardView.setColor(Color.BLUE);
        }

        else if (from==boardView.getR3()){
            boardView.setColor(Color.YELLOW);
        }

        else if (from==boardView.getR4()){
            boardView.setColor(Color.CYAN);
        }

        else if (from==boardView.getR5()){
            boardView.setColor(Color.darkGray);
        }

        else if (from==boardView.getR6()){
            boardView.setColor(Color.orange);
        }

        else if (from==boardView.getR7()){
            boardView.setColor(Color.pink);
        }

        else if (from==boardView.getR8()){
            boardView.setColor(Color.MAGENTA);
        }

        else if (from==boardView.getR9()){
            boardView.setColor(Color.LIGHT_GRAY);
        }

        else if (from==boardView.getR10()){
            boardView.setColor(Color.GREEN);
        }

        else if (from==boardView.getmNew()){

            boardModel.reset();

            try {
                boardModel.changeDifficulty(boardModel.getDifficulty());
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }

        else if (from == boardView.getCheckButton()){

            JFrame f = new JFrame();

            if(boardModel.check() == 2){
                JOptionPane.showMessageDialog(f,"Correct, Congratulations!");
            }else JOptionPane.showMessageDialog(f,"Incorrect, try again");

        }

        else if (from == boardView.getmAboutGame()) {

            gameManual.viewAboutGame();

        }

        else if (from == boardView.getmInstruction()) {
            gameManual.viewRules();
        }

        else if (from==boardView.getmSave()) {//wybór miejsca do zapisu

            if(boardView.getButton()[0][0]==null){
                return;
            }

            JFileChooser fLoad = new JFileChooser();
            if (fLoad.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
            {
                File file = fLoad.getSelectedFile();
                try {
                    boardModel.saveBoard(file, boardView.getButton());
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        }

        else if (from==boardView.getmLoad()) {//pojawia się okienku by wybrać plik do wczytania
            boardModel.reset();
            JFileChooser fLoad = new JFileChooser();
            if (fLoad.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
            {
                File file = fLoad.getSelectedFile();
                try {
                    boardModel.loadBoard(file);
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        }

        else if (from==boardView.getmExport()) { //wybór miejsca do eksportu
            JFileChooser fExport = new JFileChooser();
            if (fExport.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
            {
                File file = fExport.getSelectedFile();
                BufferedImage image = new BufferedImage(boardView.getWidth(), boardView.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D graphics2D = image.createGraphics();
                boardView.paint(graphics2D);
                try {
                    ImageIO.write(image, "jpeg", file);
                }
                catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }

        else if (from==boardView.getmEasy()){
            boardModel.reset();
            boardModel.setSize(6);
            boardModel.setDifficulty(1); //1-easy,2-medium,3-hard
        }

        else if (from==boardView.getmMedium()){
            boardModel.reset();
            boardModel.setSize(7);
            boardModel.setDifficulty(2); //1-easy,2-medium,3-hard
        }

        else if (from==boardView.getmHard()){
            boardModel.reset();
            boardModel.setSize(8);
            boardModel.setDifficulty(3); //1-easy,2-medium,3-hard
        }

        else if (from==boardView.getmTip()){

            if(boardView.getButton()[0][0]==null){//blokada jeśli nie mamy aktywnej planszy
                return;
            }

            File file= new File("easy_solve");

            if(boardModel.getDifficulty()==1) {
                file = new File("easy_solve");
            }
            if(boardModel.getDifficulty()==2) {
                file = new File("medium_solve");
            }
            if(boardModel.getDifficulty()==3) {
                file = new File("hard_solve");
            }

            File[] contents = file.listFiles();

            try {
                boardModel.tip(contents[boardModel.getRandomNum()]);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
    }

    public void setBoardView(BoardView boardView) {
        this.boardView = boardView;
    }

    public void setBoardModel(BoardModel boardModel) {
        this.boardModel = boardModel;
    }
}
