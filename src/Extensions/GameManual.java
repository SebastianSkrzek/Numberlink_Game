import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GameManual {

    private String aboutGameText;
    private String rulesText;

    private final String aboutGameFile;
    private final String rulesFile;

    public GameManual(String aboutGameFile, String rulesFile) {
        this.aboutGameFile = aboutGameFile;
        this.rulesFile = rulesFile;
    }

    public void createAboutGame() throws IOException {

        aboutGameText = "";


        BufferedReader br = new BufferedReader(new FileReader(aboutGameFile));
        String aLineFromFile;
        while ((aLineFromFile = br.readLine()) != null){
            aboutGameText = aboutGameText + aLineFromFile + "\n";
        }

    }

    public void createRules() throws IOException {

        rulesText = "";


        BufferedReader br = new BufferedReader(new FileReader(rulesFile));
        String aLineFromFile;
        while ((aLineFromFile = br.readLine()) != null){
            rulesText = rulesText + aLineFromFile + "\n";
        }
        br.close();
    }


    public void viewAboutGame() {
        JOptionPane.showMessageDialog(null, aboutGameText);
    }

    public void viewRules() {
        JOptionPane.showMessageDialog(null, rulesText);
    }

}
