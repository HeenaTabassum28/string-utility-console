package com.minorproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.minorproject.constants.Constants.*;
import static com.minorproject.util.StringUtil.countWords;


public class StringUtilityConsole extends JFrame implements ActionListener {
    JLabel charactersLabel;
    JLabel wordsLabel;
    JTextArea textArea;
    JButton countButton;
    JButton padColorButton;
    JButton textColorButton;
    JButton upperCaseButton;
    JButton lowerCaseButton;

    StringUtilityConsole() {
        super(TITLE);

        charactersLabel = new JLabel(NO_OF_CHARACTERS);
        charactersLabel.setBounds(50, 50, 120, 20);

        wordsLabel = new JLabel(NO_OF_WORDS);
        wordsLabel.setBounds(50, 80, 100, 20);

        textArea = new JTextArea();
        textArea.setBounds(50, 110, 320, 200);

        countButton = new JButton(COUNT);
        countButton.setBounds(50, 320, 80, 30);
        countButton.addActionListener(this);

        padColorButton = new JButton(PAD_COLOR);
        padColorButton.setBounds(80, 360, 110, 30);
        padColorButton.addActionListener(this);

        textColorButton = new JButton(TEXT_COLOR);
        textColorButton.setBounds(200, 360, 110, 30);
        textColorButton.addActionListener(this);

        upperCaseButton = new JButton(UPPER_CASE);
        upperCaseButton.setBounds(140, 320, 110, 30);
        upperCaseButton.addActionListener(this);

        lowerCaseButton = new JButton(LOWER_CASE);
        lowerCaseButton.setBounds(260, 320, 110, 30);
        lowerCaseButton.addActionListener(this);

        addComponentsToContainer();

        setFrameProperties();
    }

    private void addComponentsToContainer() {
        add(charactersLabel);
        add(wordsLabel);
        add(textArea);
        add(countButton);
        add(padColorButton);
        add(textColorButton);
        add(upperCaseButton);
        add(lowerCaseButton);
    }

    private void setFrameProperties() {
        setSize(430, 490);
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
        } else if (e.getSource() == upperCaseButton) {
            textArea.setText(textArea.getText().toUpperCase());
        } else if (e.getSource() == lowerCaseButton) {
            textArea.setText(textArea.getText().toLowerCase());
        }
    }

}