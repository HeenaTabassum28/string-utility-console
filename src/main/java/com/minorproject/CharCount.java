package com.minorproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.minorproject.constants.Constants.*;
import static com.minorproject.util.StringUtil.countWords;


public class CharCount extends JFrame implements ActionListener {
    JLabel charactersLabel;
    JLabel wordsLabel;
    JTextArea textArea;
    JButton countButton;
    JButton padColorButton;
    JButton textColorButton;

    CharCount() {
        super(TITLE);

        charactersLabel = new JLabel(NO_OF_CHARACTERS);
        charactersLabel.setBounds(50, 50, 120, 20);

        wordsLabel = new JLabel(NO_OF_WORDS);
        wordsLabel.setBounds(50, 80, 100, 20);

        textArea = new JTextArea();
        textArea.setBounds(50, 110, 300, 200);

        countButton = new JButton(COUNT);
        countButton.setBounds(50, 320, 80, 30);
        countButton.addActionListener(this);

        padColorButton = new JButton(PAD_COLOR);
        padColorButton.setBounds(140, 320, 110, 30);
        padColorButton.addActionListener(this);

        textColorButton = new JButton(TEXT_COLOR);
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
            charactersLabel.setText(NO_OF_CHARACTERS + text.length());
            wordsLabel.setText(NO_OF_WORDS + countWords(text));
        } else if (e.getSource() == padColorButton) {
            textArea.setBackground(JColorChooser.showDialog(this, CHOOSE_COLOR, Color.BLACK));
        } else if (e.getSource() == textColorButton) {
            textArea.setForeground(JColorChooser.showDialog(this, CHOOSE_COLOR, Color.BLACK));
        }
    }

}