import com.minorproject.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharCount extends JFrame implements ActionListener {
    JLabel charactersLabel, wordsLabel;
    JTextArea textArea;
    JButton countButton;
    JButton padColorButton;

    JButton textColorButton;


    CharCount() {
        super(Constants.TITLE);

        charactersLabel = new JLabel(Constants.NO_OF_CHARACTERS);
        charactersLabel.setBounds(50, 50, 100, 20);

        wordsLabel = new JLabel(Constants.NO_OF_WORDS);
        wordsLabel.setBounds(50, 80, 100, 20);

        textArea = new JTextArea();
        textArea.setBounds(50, 110, 300, 200);

        countButton = new JButton(Constants.COUNT);
        countButton.setBounds(50, 320, 80, 30);
        countButton.addActionListener(this);

        padColorButton = new JButton(Constants.PAD_COLOR);
        padColorButton.setBounds(140, 320, 110, 30);
        padColorButton.addActionListener(this);

        textColorButton = new JButton(Constants.TEXT_COLOR);
        textColorButton.setBounds(260, 320, 110, 30);
        textColorButton.addActionListener(this);

        add(charactersLabel);
        add(wordsLabel);
        add(textArea);
        add(countButton);
        add(padColorButton);
        add(textColorButton);

        setSize(400, 400);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == countButton) {
            String text = textArea.getText();
            charactersLabel.setText(Constants.NO_OF_CHARACTERS + text.length());
            String[] words = text.split("\\s");
            wordsLabel.setText(Constants.NO_OF_WORDS + words.length);
        } else if (e.getSource() == padColorButton) {
            textArea.setBackground(JColorChooser.showDialog(this, Constants.CHOOSE_COLOR, Color.BLACK));
        } else if (e.getSource() == textColorButton) {
            textArea.setForeground(JColorChooser.showDialog(this, Constants.CHOOSE_COLOR, Color.BLACK));
        }
    }

    public static void main(String[] args) {
        new CharCount();
    }
}