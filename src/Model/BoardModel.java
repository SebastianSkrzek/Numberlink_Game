import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BoardModel {

    BoardView boardView;
    GameController gameController;


    int size;
    int difficulty;
    int randomNum;


    ArrayList<Integer> coordinates_x_numbers_first;
    ArrayList<Integer> coordinates_y_numbers_first;

    ArrayList<Integer> coordinates_x_numbers_second;
    ArrayList<Integer> coordinates_y_numbers_second;


    public BoardModel() {

        coordinates_x_numbers_first = new ArrayList<>();
        coordinates_y_numbers_first = new ArrayList<>();
        coordinates_x_numbers_second = new ArrayList<>();
        coordinates_y_numbers_second = new ArrayList<>();

        size = 6;
        difficulty = 1;//domyślny poziom to łatwy
    }

    public void loadBoard(File file) throws FileNotFoundException {

        coordinates_x_numbers_first.clear();
        coordinates_y_numbers_first.clear();
        coordinates_x_numbers_second.clear();
        coordinates_y_numbers_second.clear();

        HashMap<Integer, Integer> cord_x_first = new HashMap<>();
        HashMap<Integer, Integer> cord_y_first = new HashMap<>();
        HashMap<Integer, Integer> cord_x_second = new HashMap<>();
        HashMap<Integer, Integer> cord_y_second = new HashMap<>();

        Scanner in = new Scanner(file);
        int temp = 0;


        while(in.hasNextLine()){
            String line = in.nextLine();
            String[] parts = line.split(" ");
            temp = Math.max(temp, Integer.parseInt(parts[5]));
            if(parts[0].equals("true")) { // jesli jest digitem

                boardView.getButton()[Integer.parseInt(parts[4])][Integer.parseInt(parts[5])] = new Digit(new Color(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),Integer.parseInt(parts[3])),Integer.parseInt(parts[4]),Integer.parseInt(parts[5]),Integer.parseInt(parts[6]),true);
                if (!cord_x_first.containsKey(Integer.parseInt(parts[6]))) {
                    cord_x_first.put(Integer.parseInt(parts[6]), Integer.parseInt(parts[4]));
                    cord_y_first.put(Integer.parseInt(parts[6]), Integer.parseInt(parts[5]));
                }

                else {
                    cord_x_second.put(Integer.parseInt(parts[6]), Integer.parseInt(parts[4]));
                    cord_y_second.put(Integer.parseInt(parts[6]), Integer.parseInt(parts[5]));
                }

            }
            else boardView.getButton()[Integer.parseInt(parts[4])][Integer.parseInt(parts[5])] = new Square(new Color(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),Integer.parseInt(parts[3])),Integer.parseInt(parts[4]),Integer.parseInt(parts[5]),false);

        }

        for(int i = 0; i<cord_x_first.size();i++){
            coordinates_x_numbers_first.add(cord_x_first.get(i));
            coordinates_y_numbers_first.add(cord_y_first.get(i));
            coordinates_x_numbers_second.add(cord_x_second.get(i));
            coordinates_y_numbers_second.add(cord_y_second.get(i));
        }

        size = temp + 1;

        for(int i=0; i<size;i++){

            for(int j=0; j<size;j++) {
                boardView.getButton()[i][j].setBounds(60 + 50 * i, 20 + 50 * j, 50, 50);
                String s = String.valueOf(boardView.getButton()[i][j].getname());


                if(boardView.getButton()[i][j].getClass()==new Digit(Color.WHITE,1,1,2, true).getClass()) {
                    boardView.getButton()[i][j].setText(s);
                }

                boardView.getButton()[i][j].setBackground(boardView.getButton()[i][j].getColor());

                boardView.add(boardView.getButton()[i][j]);
                boardView.getButton()[i][j].addActionListener(gameController);
            }
        }

        in.close();
        this.size = temp;
        boardView.repaint();
    }

    public int check(){
        boolean flag1 = false;
        boolean flag2;
        boolean flag3;

        for(int i=0;i<size+1;i++){

            for(int j=0;j<size+1;j++){

                if(boardView.getButton()[i][j].getColor().equals(Color.WHITE)){

                    flag1=true;
                }
            }
        }

        if (flag1){
            return 1;
        }

        for(int i=0;i<coordinates_x_numbers_second.size();i++){
            int x_now=coordinates_x_numbers_second.get(i);
            int y_now=coordinates_y_numbers_second.get(i);
            int count;
            int move=0;
            int lastMove;
            flag2=true;

            while(flag2){

                flag3=true;

                if(boardView.getButton()[x_now][y_now].getClass()==new Digit(Color.WHITE,1,1,2, true).getClass()) {

                    count = 0;
                    move = 0;

                    if(y_now<size) {
                        if (boardView.getButton()[x_now][y_now + 1].getColor().equals(boardView.getButton()[x_now][y_now].getColor())) {
                            count++;
                            move = 1;
                        }
                    }

                    if(y_now>0){

                        if (boardView.getButton()[x_now][y_now - 1].getColor().equals(boardView.getButton()[x_now][y_now].getColor())) {
                            count++;
                            move = 2;
                        }
                    }

                    if(x_now<size) {
                        if (boardView.getButton()[x_now + 1][y_now].getColor().equals(boardView.getButton()[x_now][y_now].getColor())) {
                            count++;
                            move = 3;
                        }
                    }

                    if(x_now>0) {

                        if (boardView.getButton()[x_now - 1][y_now].getColor().equals(boardView.getButton()[x_now][y_now].getColor())) {
                            count++;
                            move = 4;
                        }
                    }

                    if (count == 1) {
                        if (move == 1) {
                            y_now++;
                        }
                        if (move == 2) {
                            y_now--;
                        }
                        if (move == 3) {
                            x_now++;
                        }
                        if (move == 4) {
                            x_now--;
                        }
                    }

                    if (count != 1) {
                        return 1;
                    }

                    flag3=false;
                }

                if((boardView.getButton()[x_now][y_now].getClass()!=(new Digit(Color.WHITE,1,1,2, true).getClass()))&&flag3) {
                    lastMove = move;
                    count = 0;
                    move = 0;

                    if(y_now<size) {
                        if ((boardView.getButton()[x_now][y_now + 1].getColor().equals(boardView.getButton()[x_now][y_now].getColor()) && lastMove != 2)) {
                            count++;
                            move = 1;
                        }
                    }

                    if(y_now>0) {
                        if ((boardView.getButton()[x_now][y_now - 1].getColor().equals(boardView.getButton()[x_now][y_now].getColor()) && lastMove != 1)) {
                            count++;
                            move = 2;
                        }
                    }

                    if(x_now<size) {
                        if (boardView.getButton()[x_now + 1][y_now].getColor().equals(boardView.getButton()[x_now][y_now].getColor()) && lastMove != 4) {
                            count++;
                            move = 3;
                        }
                    }

                    if(x_now>0) {
                        if (boardView.getButton()[x_now - 1][y_now].getColor().equals(boardView.getButton()[x_now][y_now].getColor()) && lastMove != 3) {
                            count++;
                            move = 4;
                        }
                    }

                    if(y_now>0) {
                        if (boardView.getButton()[x_now][y_now - 1].equals(boardView.getButton()[coordinates_x_numbers_first.get(i)][coordinates_y_numbers_first.get(i)])) {
                            flag2 = false;
                        }
                    }

                    if(y_now<size) {
                        if (boardView.getButton()[x_now][y_now + 1].equals(boardView.getButton()[coordinates_x_numbers_first.get(i)][coordinates_y_numbers_first.get(i)])) {
                            flag2 = false;
                        }
                    }

                    if(x_now>0) {
                        if (boardView.getButton()[x_now - 1][y_now].equals(boardView.getButton()[coordinates_x_numbers_first.get(i)][coordinates_y_numbers_first.get(i)])) {
                            flag2 = false;

                        }
                    }

                    if(x_now<size) {
                        if (boardView.getButton()[x_now + 1][y_now].equals(boardView.getButton()[coordinates_x_numbers_first.get(i)][coordinates_y_numbers_first.get(i)])) {
                            flag2 = false;
                        }
                    }

                    if(count==1){
                        if(move==1 ){
                            y_now++;
                        }
                        if(move==2 ){
                            y_now--;
                        }
                        if(move==3 ){
                            x_now++;
                        }
                        if(move==4 ){
                            x_now--;
                        }
                    }

                    if(flag2) {
                        if (count != 1) {
                            return 1;
                        }
                    }
                }
            }
        }
        return 2;
    }

    public void saveBoard(File file, Square[][] button) throws FileNotFoundException {
        PrintWriter zapis = new PrintWriter(file);
        for (Square[] s : button) {
            for (Square p : s) {
                if(p != null) {
                    zapis.println(p.isDigit() + " " + p.getColor().getRed() + " " + p.getColor().getGreen() + " " + p.getColor().getBlue() + " " + p.getxCoordinate() + " " + p.getyCoordinate() + " " + p.getname());
                }
            }
        }
        zapis.close();
    }

    public void reset(){//czyszczenie przycisków przy rozpoczęciu nowej gry lub zmianie trudności

        for(int i=0; i<size+1;i++)
        {
            for (int j=0; j<size+1; j++){
                if(boardView.getButton()[i][j]!=null) {
                    boardView.remove(boardView.getButton()[i][j]);
                    boardView.repaint();
                }
            }
        }
    }

    public void tip(File file) throws FileNotFoundException {
        //tip działa dla naszych zdefiniowanych plansz
        //koloruje jeden losowy poprawny przycisk

        if(check()==2){
            return;
        }


        Scanner in = new Scanner(file);
        int lineCounter=0;
        String line="";
        while(in.hasNextLine()){
            lineCounter++;
            line = in.nextLine();
        }

        in = new Scanner(file);
        int randomLine = 1 + (int)(Math.random() * lineCounter);
        for (int i=0; i<randomLine; i++){
            line = in.nextLine();
        }

        String[] parts = line.split(" ");

        int i=Integer.parseInt(parts[4]);
        int j=Integer.parseInt(parts[5]);

        int r=Integer.parseInt(parts[1]);
        int g=Integer.parseInt(parts[2]);
        int b=Integer.parseInt(parts[3]);

        Color tipColor= new Color(r,g,b);

        //jeśli wylosowany przycisk jest dobrze pokolorowany lub jest digitem to powtórz jeszcze raz
        if(boardView.getButton()[i][j].getClass().equals(new Digit(Color.WHITE,1,1,2, true).getClass())){
            tip(file);
        }

        else if(boardView.getButton()[i][j].getColor().equals(tipColor)){
            tip(file);
        }

        boardView.getButton()[i][j].setColor(tipColor);
        boardView.getButton()[i][j].setBackground(tipColor);

    }


    public int getSize() {
        return size;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getRandomNum() {
        return randomNum;
    }





    public void changeDifficulty(int difficulty) throws FileNotFoundException {

        if(difficulty==1){
            size=6;
            randomNum = (int)(Math.random() * 9);
            File file = new File("easy_board");
            File[] contents = file.listFiles();
            loadBoard(contents[randomNum]);
        }

        if(difficulty==2){
            size=7;
            randomNum = (int)(Math.random() * 9);
            System.out.println();
            File file = new File("medium_board");
            File[] contents = file.listFiles();
            loadBoard(contents[randomNum]);
        }

        if(difficulty==3){
            size=8;
            randomNum = (int)(Math.random() * 9);
            File file = new File("hard_board");
            File[] contents = file.listFiles();
            loadBoard(contents[randomNum]);
        }

    }

    public void setBoardView(BoardView boardView) {
        this.boardView = boardView;
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}



