import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BoardView extends JFrame implements ActionListener {

    GameController gameController;
    BoardModel boardModel;

    Color color;

    Square[][] button = new Square[10][10];

    JLabel label1;
    ButtonGroup bgRadio, board;
    JRadioButton rBrak, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10;
    JMenuBar menuBar;
    JMenu menuGame, menuHelp, menuDifficulty;
    JMenuItem mNew, mTip, mSave, mLoad, mExport, mAboutGame, mInstruction, mEasy, mMedium, mHard;
    JButton checkButton;




    public BoardView() {

    }

    public void setUp(){
        setSize(700, 550);
        setTitle("Numberlink");
        setLayout(null);

        label1 = new JLabel("Number");
        label1.setBounds(600, 5, 60, 20);
        add(label1);

        //przyciski
        board = new ButtonGroup();
        bgRadio = new ButtonGroup();
        rBrak = new JRadioButton("---", true);
        rBrak.setBounds(600, 20, 60, 20);
        bgRadio.add(rBrak);
        add(rBrak);
        rBrak.addActionListener(gameController);

        r1 = new JRadioButton("0", false);
        r1.setBounds(600, 40, 60, 20);
        bgRadio.add(r1);
        add(r1);
        r1.addActionListener(gameController);

        r2 = new JRadioButton("1", false);
        r2.setBounds(600, 60, 60, 20);
        bgRadio.add(r2);
        add(r2);
        r2.addActionListener(gameController);

        r3 = new JRadioButton("2", false);
        r3.setBounds(600, 80, 60, 20);
        bgRadio.add(r3);
        add(r3);
        r3.addActionListener(gameController);

        r4 = new JRadioButton("3", false);
        r4.setBounds(600, 100, 60, 20);
        bgRadio.add(r4);
        add(r4);
        r4.addActionListener(gameController);

        r5 = new JRadioButton("4", false);
        r5.setBounds(600, 120, 60, 20);
        bgRadio.add(r5);
        add(r5);
        r5.addActionListener(gameController);

        r6 = new JRadioButton("5", false);
        r6.setBounds(600, 140, 60, 20);
        bgRadio.add(r6);
        add(r6);
        r6.addActionListener(gameController);

        r7 = new JRadioButton("6", false);
        r7.setBounds(600, 160, 60, 20);
        bgRadio.add(r7);
        add(r7);
        r7.addActionListener(gameController);

        r8 = new JRadioButton("7", false);
        r8.setBounds(600, 180, 60, 20);
        bgRadio.add(r8);
        add(r8);
        r8.addActionListener(gameController);

        r9 = new JRadioButton("8", false);
        r9.setBounds(600, 200, 60, 20);
        bgRadio.add(r9);
        add(r9);
        r9.addActionListener(gameController);

        r10 = new JRadioButton("9", false);
        r10.setBounds(600, 220, 60, 20);
        bgRadio.add(r10);
        add(r10);
        r10.addActionListener(gameController);

        checkButton = new JButton("Check");
        checkButton.setBounds(600, 250, 80, 50);
        add(checkButton);
        checkButton.addActionListener(gameController);

        //menu
        menuBar = new JMenuBar();

        menuGame = new JMenu("Game");
        mNew = new JMenuItem("New Game");
        mNew.addActionListener(gameController);
        mTip = new JMenuItem("Tip");
        mTip.addActionListener(gameController);
        mSave = new JMenuItem("Save");
        mSave.addActionListener(gameController);
        mLoad = new JMenuItem("Load");
        mLoad.addActionListener(gameController);
        mExport = new JMenuItem("Export");
        mExport.addActionListener(gameController);
        menuDifficulty = new JMenu("Difficulty");
        mEasy = new JMenuItem("Easy");
        mEasy.addActionListener(gameController);
        mMedium = new JMenuItem("Medium");
        mMedium.addActionListener(gameController);
        mHard = new JMenuItem("Hard");
        mHard.addActionListener(gameController);
        menuDifficulty.add(mEasy);
        menuDifficulty.add(mMedium);
        menuDifficulty.add(mHard);
        menuGame.add(mNew);
        menuGame.add(mTip);
        menuGame.add(mSave);
        menuGame.add(mLoad);
        menuGame.add(mExport);
        menuGame.add(menuDifficulty);

        menuHelp = new JMenu("Help");
        mAboutGame = new JMenuItem("About Game");
        mAboutGame.addActionListener(gameController);
        mInstruction = new JMenuItem("Instruction");
        mInstruction.addActionListener(gameController);
        menuHelp.add(mAboutGame);
        menuHelp.add(mInstruction);

        setJMenuBar(menuBar);
        menuBar.add(menuGame);
        menuBar.add(menuHelp);

        setVisible(true);


        setColor(Color.WHITE);


    }



    public Square[][] getButton() {
        return button;
    }

    public Color getColor() {
        return color;
    }

    public JRadioButton getrBrak() {
        return rBrak;
    }

    public JRadioButton getR1() {
        return r1;
    }

    public JRadioButton getR2() {
        return r2;
    }

    public JRadioButton getR3() {
        return r3;
    }

    public JRadioButton getR4() {
        return r4;
    }

    public JRadioButton getR5() {
        return r5;
    }

    public JRadioButton getR6() {
        return r6;
    }

    public JRadioButton getR7() {
        return r7;
    }

    public JRadioButton getR8() {
        return r8;
    }

    public JRadioButton getR9() {
        return r9;
    }

    public JRadioButton getR10() {
        return r10;
    }


    public JMenuItem getmNew() {
        return mNew;
    }

    public JMenuItem getmTip() {
        return mTip;
    }

    public JMenuItem getmSave() {
        return mSave;
    }

    public JMenuItem getmLoad() {
        return mLoad;
    }

    public JMenuItem getmExport() {
        return mExport;
    }

    public JMenuItem getmAboutGame() {
        return mAboutGame;
    }

    public JMenuItem getmInstruction() {
        return mInstruction;
    }

    public JMenuItem getmEasy() {
        return mEasy;
    }

    public JMenuItem getmMedium() {
        return mMedium;
    }

    public JMenuItem getmHard() {
        return mHard;
    }

    public JButton getCheckButton() {
        return checkButton;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    public void setBoardModel(BoardModel boardModel) {
        this.boardModel = boardModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("tytytytytyyt");
    }
}



