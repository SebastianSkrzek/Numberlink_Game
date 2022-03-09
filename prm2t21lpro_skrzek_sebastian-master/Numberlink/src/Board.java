//import BoardElements.Digit;
//import BoardElements.Square;
//import Extensions.GameManual;
//
//import javax.imageio.ImageIO;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Scanner;
//
//
//public class Board extends JFrame implements ActionListener {
//
//
//
//
//
//    Color color;
//
//    Square[][] button = new Square[10][10];
//
//    JLabel label1;
//    ButtonGroup bgRadio,board;
//    JRadioButton rBrak, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10;
//    JMenuBar menuBar;
//    JMenu menuGame, menuHelp, menuDifficulty;
//    JMenuItem mNew, mTip, mSave, mLoad, mExport, mAboutGame, mInstruction, mEasy, mMedium, mHard;
//    JButton checkButton;
//
//    GameManual gameManual;
//
//    int size;
//    int difficulty;
//    int randomNum;
//
//    ArrayList<Integer> coordinates_x_numbers_first;
//    ArrayList<Integer> coordinates_y_numbers_first;
//
//    ArrayList<Integer> coordinates_x_numbers_second;
//    ArrayList<Integer> coordinates_y_numbers_second;
//
//    //tworzenie okna
//    public Board() {
//
//        gameManual = new GameManual("Numberlink/AboutGame.txt",
//                "Numberlink/Rules.txt");
//
//
//        color = Color.WHITE;
//        size = 6;
//        difficulty = 1;//domyślny poziom to łatwy
//
//        coordinates_x_numbers_first = new ArrayList<>();
//        coordinates_y_numbers_first = new ArrayList<>();
//        coordinates_x_numbers_second = new ArrayList<>();
//        coordinates_y_numbers_second = new ArrayList<>();
//
//        setSize(700, 550);
//        setTitle("Numberlink");
//        setLayout(null);
//
//        label1 = new JLabel("Number");
//        label1.setBounds(600, 5, 60, 20);
//        add(label1);
//
//        //przyciski
//        board = new ButtonGroup();
//        bgRadio = new ButtonGroup();
//        rBrak = new JRadioButton("---",true);
//        rBrak.setBounds(600, 20, 60, 20);
//        bgRadio.add(rBrak);
//        add(rBrak);
//        rBrak.addActionListener(this);
//
//        r1 = new JRadioButton("0",false);
//        r1.setBounds(600, 40, 60, 20);
//        bgRadio.add(r1);
//        add(r1);
//        r1.addActionListener(this);
//
//        r2 = new JRadioButton("1",false);
//        r2.setBounds(600, 60, 60, 20);
//        bgRadio.add(r2);
//        add(r2);
//        r2.addActionListener(this);
//
//        r3 = new JRadioButton("2",false);
//        r3.setBounds(600, 80, 60, 20);
//        bgRadio.add(r3);
//        add(r3);
//        r3.addActionListener(this);
//
//        r4 = new JRadioButton("3",false);
//        r4.setBounds(600, 100, 60, 20);
//        bgRadio.add(r4);
//        add(r4);
//        r4.addActionListener(this);
//
//        r5 = new JRadioButton("4",false);
//        r5.setBounds(600, 120, 60, 20);
//        bgRadio.add(r5);
//        add(r5);
//        r5.addActionListener(this);
//
//        r6 = new JRadioButton("5",false);
//        r6.setBounds(600, 140, 60, 20);
//        bgRadio.add(r6);
//        add(r6);
//        r6.addActionListener(this);
//
//        r7 = new JRadioButton("6",false);
//        r7.setBounds(600, 160, 60, 20);
//        bgRadio.add(r7);
//        add(r7);
//        r7.addActionListener(this);
//
//        r8 = new JRadioButton("7",false);
//        r8.setBounds(600, 180, 60, 20);
//        bgRadio.add(r8);
//        add(r8);
//        r8.addActionListener(this);
//
//        r9 = new JRadioButton("8",false);
//        r9.setBounds(600, 200, 60, 20);
//        bgRadio.add(r9);
//        add(r9);
//        r9.addActionListener(this);
//
//        r10 = new JRadioButton("9",false);
//        r10.setBounds(600, 220, 60, 20);
//        bgRadio.add(r10);
//        add(r10);
//        r10.addActionListener(this);
//
//        checkButton = new JButton("Check");
//        checkButton.setBounds(600, 250, 80, 50);
//        add(checkButton);
//        checkButton.addActionListener(this);
//
//        //menu
//        menuBar = new JMenuBar();
//
//        menuGame = new JMenu("Game");
//        mNew = new JMenuItem("New Game");
//        mNew.addActionListener(this);
//        mTip = new JMenuItem("Tip");
//        mTip.addActionListener(this);
//        mSave = new JMenuItem("Save");
//        mSave.addActionListener(this);
//        mLoad = new JMenuItem("Load");
//        mLoad.addActionListener(this);
//        mExport = new JMenuItem("Export");
//        mExport.addActionListener(this);
//        menuDifficulty = new JMenu("Difficulty");
//        mEasy = new JMenuItem("Easy");
//        mEasy.addActionListener(this);
//        mMedium = new JMenuItem("Medium");
//        mMedium.addActionListener(this);
//        mHard = new JMenuItem("Hard");
//        mHard.addActionListener(this);
//        menuDifficulty.add(mEasy);
//        menuDifficulty.add(mMedium);
//        menuDifficulty.add(mHard);
//        menuGame.add(mNew);
//        menuGame.add(mTip);
//        menuGame.add(mSave);
//        menuGame.add(mLoad);
//        menuGame.add(mExport);
//        menuGame.add(menuDifficulty);
//
//        menuHelp = new JMenu("Help");
//        mAboutGame = new JMenuItem("About Game");
//        mAboutGame.addActionListener(this);
//        mInstruction = new JMenuItem("Instruction");
//        mInstruction.addActionListener(this);
//        menuHelp.add(mAboutGame);
//        menuHelp.add(mInstruction);
//
//        setJMenuBar(menuBar);
//        menuBar.add(menuGame);
//        menuBar.add(menuHelp);
//
//    }
//
//
//    //akcje po wciskaniu przycisków
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        Object from = e.getSource();
//
//        for(int i=0;i<size+1;i++)
//        {
//            for(int j=0;j<size+1;j++)
//            {
//                if(from==button[i][j] && !button[i][j].isDigit()){
//                    button[i][j].setColor(color);
//                    button[i][j].setBackground(color);
//                }
//            }
//        }
//
//        if (from==rBrak){
//            color=Color.WHITE;
//        }
//
//        else if (from==r1){
//            color=Color.RED;
//        }
//
//        else if (from==r2){
//            color=Color.BLUE;
//        }
//
//        else if (from==r3){
//            color=Color.YELLOW;
//        }
//
//        else if (from==r4){
//            color=Color.CYAN;
//        }
//
//        else if (from==r5){
//            color=Color.darkGray;
//        }
//
//        else if (from==r6){
//            color=Color.orange;
//        }
//
//        else if (from==r7){
//            color=Color.pink;
//        }
//
//        else if (from==r8){
//            color=Color.magenta;
//        }
//
//        else if (from==r9){
//            color=Color.lightGray;
//        }
//
//        else if (from==r10){
//            color=Color.GREEN;
//        }
//
//        else if (from==mNew){
//
//            reset();
//
//            try {
//                changeDifficulty(difficulty);
//            } catch (FileNotFoundException fileNotFoundException) {
//                fileNotFoundException.printStackTrace();
//            }
//        }
//
//        else if (from == checkButton){
//
//            JFrame f = new JFrame();
//
//            if(check() == 2){
//                JOptionPane.showMessageDialog(f,"Correct, Congratulations!");
//            }else JOptionPane.showMessageDialog(f,"Incorrect, try again");
//
//        }
//
//        else if (from == mAboutGame) {
//
//            gameManual.viewAboutGame();
//
//        }
//
//        else if (from == mInstruction) {
//            JOptionPane.showMessageDialog(
//                    this,
//                    "Zasady:\n" +
//                            "Gracz musi połączyć wszystkie pasujące liczby na siatce z pojedyńczymi ciągłymi ścieżkami. \n" +
//                            "Ścieżki nie mogą się rozgałęziać ani przecinać, a liczby muszą znajdować się na krańcach każdej ścieżki.\n" +
//                            "Każde pole planszy powinna wypełnić ścieżka.\n" +
//                            "\n" +
//                            "Instrukcja:\n" +
//                            "Aby zacząć tworzyć ścieżkę, należy z prawej strony wybrać numer liczby, którą chcemy połączyć, \n" +
//                            "a następnie klikając w pola na planszy, zmieniamy ich kolory. W ten sposób łącząc wszystkie pary \n" +
//                            "cyfr ścieżką jednego koloru (kolor musi odpowiadać kolorowi cyfry), rozwiązujemy układankę.\n" +
//                            "Aby sprawdzić poprawność rozwiązania, należy wcisnąć przycisk \"solve\".");
//        }
//
//        else if (from==mSave) {//wybór miejsca do zapisu
//
//            if(button[0][0]==null){
//                return;
//            }
//
//            JFileChooser fLoad = new JFileChooser();
//            if (fLoad.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
//            {
//                File file = fLoad.getSelectedFile();
//                try {
//                    saveBoard(file, button);
//                } catch (FileNotFoundException fileNotFoundException) {
//                    fileNotFoundException.printStackTrace();
//                }
//            }
//        }
//
//        else if (from==mLoad) {//pojawia się okienku by wybrać plik do wczytania
//            reset();
//            JFileChooser fLoad = new JFileChooser();
//            if (fLoad.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
//            {
//                File file = fLoad.getSelectedFile();
//                try {
//                    loadBoard(file);
//                } catch (FileNotFoundException fileNotFoundException) {
//                    fileNotFoundException.printStackTrace();
//                }
//            }
//        }
//
//        else if (from==mExport) { //wybór miejsca do eksportu
//            JFileChooser fExport = new JFileChooser();
//            if (fExport.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
//            {
//                File file = fExport.getSelectedFile();
//                BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
//                Graphics2D graphics2D = image.createGraphics();
//                this.paint(graphics2D);
//                try {
//                    ImageIO.write(image, "jpeg", file);
//                }
//                catch (IOException ioException) {
//                    ioException.printStackTrace();
//                }
//            }
//        }
//
//        else if (from==mEasy){
//            reset();
//            size=6;
//            difficulty=1; //1-easy,2-medium,3-hard
//        }
//
//        else if (from==mMedium){
//            reset();
//            size=7;
//            difficulty=2;
//        }
//
//        else if (from==mHard){
//            reset();
//            size=8;
//            difficulty=3;
//        }
//
//        else if (from==mTip){
//
//            if(button[0][0]==null){//blokada jeśli nie mamy aktywnej planszy
//                return;
//            }
//
//            File file= new File("easy_solve");
//
//            if(difficulty==1) {
//                 file = new File("easy_solve");
//            }
//            if(difficulty==2) {
//                 file = new File("medium_solve");
//            }
//            if(difficulty==3) {
//                 file = new File("hard_solve");
//            }
//
//            File[] contents = file.listFiles();
//
//            try {
//                tip(contents[randomNum]);
//            } catch (FileNotFoundException fileNotFoundException) {
//                fileNotFoundException.printStackTrace();
//            }
//        }
//    }
//
//
//    //algorytm sprawdzający poprawność rozwiązania planszy
//
//
//
//    public void saveBoard(File file, Square[][] button) throws FileNotFoundException {
//        PrintWriter zapis = new PrintWriter(file);
//        for (Square[] s : button) {
//            for (Square p : s) {
//                if(p != null) {
//                    zapis.println(p.isDigit() + " " + p.getColor().getRed() + " " + p.getColor().getGreen() + " " + p.getColor().getBlue() + " " + p.getxCoordinate() + " " + p.getyCoordinate() + " " + p.getname());
//                }
//            }
//        }
//        zapis.close();
//    }
//
//
//    public void loadBoard(File file) throws FileNotFoundException {
//
//        coordinates_x_numbers_first.clear();
//        coordinates_y_numbers_first.clear();
//        coordinates_x_numbers_second.clear();
//        coordinates_y_numbers_second.clear();
//
//        HashMap<Integer, Integer> cord_x_first = new HashMap<Integer, Integer>();
//        HashMap<Integer, Integer> cord_y_first = new HashMap<Integer, Integer>();
//        HashMap<Integer, Integer> cord_x_second = new HashMap<Integer, Integer>();
//        HashMap<Integer, Integer> cord_y_second = new HashMap<Integer, Integer>();
//
//        Scanner in = new Scanner(file);
//        int temp = 0;
//        while(in.hasNextLine()){
//            String line = in.nextLine();
//            String[] parts = line.split(" ");
//            temp = Math.max(temp, Integer.parseInt(parts[5]));
//            if(parts[0].equals("true")) { // jesli jest digitem
//
//                button[Integer.parseInt(parts[4])][Integer.parseInt(parts[5])] = new Digit(new Color(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),Integer.parseInt(parts[3])),Integer.parseInt(parts[4]),Integer.parseInt(parts[5]),Integer.parseInt(parts[6]),true);
//                if (!cord_x_first.containsKey(Integer.parseInt(parts[6]))) {
//                    cord_x_first.put(Integer.parseInt(parts[6]), Integer.parseInt(parts[4]));
//                    cord_y_first.put(Integer.parseInt(parts[6]), Integer.parseInt(parts[5]));
//                }
//
//                else {
//                    cord_x_second.put(Integer.parseInt(parts[6]), Integer.parseInt(parts[4]));
//                    cord_y_second.put(Integer.parseInt(parts[6]), Integer.parseInt(parts[5]));
//                }
//
//            }
//            else button[Integer.parseInt(parts[4])][Integer.parseInt(parts[5])] = new Square(new Color(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),Integer.parseInt(parts[3])),Integer.parseInt(parts[4]),Integer.parseInt(parts[5]),false);
//
//        }
//
//        for(int i = 0; i<cord_x_first.size();i++){
//            coordinates_x_numbers_first.add(cord_x_first.get(i));
//            coordinates_y_numbers_first.add(cord_y_first.get(i));
//            coordinates_x_numbers_second.add(cord_x_second.get(i));
//            coordinates_y_numbers_second.add(cord_y_second.get(i));
//        }
//
//        size = temp + 1;
//
//        for(int i=0; i<size;i++){
//
//            for(int j=0; j<size;j++) {
//                button[i][j].setBounds(60 + 50 * i, 20 + 50 * j, 50, 50);
//                String s = String.valueOf(button[i][j].name);
//
//                if(button[i][j].getClass()==new Digit(Color.WHITE,1,1,2, true).getClass()) {
//                    button[i][j].setText(s);
//                }
//
//                button[i][j].setBackground(button[i][j].color);
//
//                add(button[i][j]);
//                button[i][j].addActionListener(this);
//            }
//        }
//
//        in.close();
//        this.size = temp;
//        repaint();
//    }
//
//    public void changeDifficulty(int difficulty) throws FileNotFoundException {
//
//        if(difficulty==1){
//            size=6;
//            randomNum = 1 + (int)(Math.random() * 9);
//            File file = new File("easy_board");
//            File[] contents = file.listFiles();
//            loadBoard(contents[randomNum]);
//        }
//
//        if(difficulty==2){
//            size=7;
//            randomNum = 1 + (int)(Math.random() * 9);
//            File file = new File("medium_board");
//            File[] contents = file.listFiles();
//            loadBoard(contents[randomNum]);
//        }
//
//        if(difficulty==3){
//            size=8;
//            randomNum = 1 + (int)(Math.random() * 9);
//            File file = new File("hard_board");
//            File[] contents = file.listFiles();
//            loadBoard(contents[randomNum]);
//        }
//
//    }
//
//    public void reset(){//czyszczenie przycisków przy rozpoczęciu nowej gry lub zmianie trudności
//
//        for(int i=0; i<size+1;i++)
//        {
//            for (int j=0; j<size+1; j++){
//                if(button[i][j]!=null) {
//                    remove(button[i][j]);
//                    repaint();
//                }
//            }
//        }
//    }
//
//    public void tip(File file) throws FileNotFoundException {
//        //tip działa dla naszych zdefiniowanych plansz
//        //koloruje jeden losowy poprawny przycisk
//
//        if(check()==2){
//            return;
//        }
//
//
//        Scanner in = new Scanner(file);
//        int lineCounter=0;
//        String line="";
//        while(in.hasNextLine()){
//            lineCounter++;
//            line = in.nextLine();
//        }
//
//        in = new Scanner(file);
//        int randomLine = 1 + (int)(Math.random() * lineCounter);
//        for (int i=0; i<randomLine; i++){
//            line = in.nextLine();
//        }
//
//        String[] parts = line.split(" ");
//
//        int i=Integer.parseInt(parts[4]);
//        int j=Integer.parseInt(parts[5]);
//
//        int r=Integer.parseInt(parts[1]);
//        int g=Integer.parseInt(parts[2]);
//        int b=Integer.parseInt(parts[3]);
//
//        Color tipColor= new Color(r,g,b);
//
//        //jeśli wylosowany przycisk jest dobrze pokolorowany lub jest digitem to powtórz jeszcze raz
//        if(button[i][j].getClass().equals(new Digit(Color.WHITE,1,1,2, true).getClass())){
//            tip(file);
//        }
//
//        else if(button[i][j].color.equals(tipColor)){
//            tip(file);
//        }
//
//        button[i][j].setColor(tipColor);
//        button[i][j].setBackground(tipColor);
//
//    }
//}
