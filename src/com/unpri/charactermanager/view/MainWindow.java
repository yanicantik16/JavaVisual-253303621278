
package com.unpri.charactermanager.view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;

public class MainWindow extends JFrame {

    private JPanel mainPanel;
    private ArrayList<Character> characterList;
    private CharacterManager manager;

    public MainWindow(
            ArrayList<Character> characterList,
            CharacterManager manager) {

        super("Character Manager v0.4");

        this.characterList = characterList;
        this.manager = manager;

        initComponents();

        setMinimumSize(new Dimension(500, 450));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        mainPanel = new JPanel(new GridLayout(0, 1, 5, 10));

        mainPanel.setBackground(AppTheme.BG_MAIN);
        mainPanel.setBorder(AppTheme.PANEL_BORDER);

        JLabel titleLabel = new JLabel(
                "=== Daftar Karakter (" + characterList.size() + ") ===",
                SwingConstants.CENTER
        );

        titleLabel.setFont(AppTheme.FONT_TITLE);
        titleLabel.setForeground(AppTheme.TEXT_MAIN);

        mainPanel.add(titleLabel);

        for (Character c : characterList) {
            mainPanel.add(createCharacterLabel(c));
        }

        double averageLevel = manager.getAverageLevel();

        JLabel averageLabel = new JLabel(
                String.format("Rata-rata Level: %.2f", averageLevel),
                SwingConstants.CENTER
        );

        averageLabel.setFont(AppTheme.FONT_BODY.deriveFont(Font.BOLD));
        averageLabel.setForeground(AppTheme.GOLD);

        mainPanel.add(averageLabel);

        add(mainPanel, BorderLayout.CENTER);
    }

    private JLabel createCharacterLabel(Character c) {

        String info = c.getName()
                + " | " + c.getType()
                + " | Lv." + c.getLevel()
                + " | HP:" + c.getHitPoints()
                + " | ATK:" + c.getAttackPower();

        JLabel characterLabel = new JLabel(info);

        // Warna kartu berdasarkan role
        characterLabel.setBackground(AppTheme.colorFor(c.getType()));
        characterLabel.setOpaque(true);

        // Border dan font
        characterLabel.setBorder(AppTheme.CARD_BORDER);
        characterLabel.setFont(AppTheme.FONT_BODY);

        // Highlight karakter level tinggi
        if (c.getLevel() >= AppTheme.HIGH_LEVEL_THRESHOLD) {

            characterLabel.setForeground(AppTheme.GOLD);
            characterLabel.setFont(
                    AppTheme.FONT_BODY.deriveFont(Font.BOLD)
            );

        } else {

            characterLabel.setForeground(AppTheme.TEXT_LIGHT);
        }

        // Properti tambahan 1: tooltip
        characterLabel.setToolTipText(
                AppTheme.describe(c.getType())
                + " | HP: " + c.getHitPoints()
                + " | ATK: " + c.getAttackPower()
        );

        // Properti tambahan 2: level 1 dinonaktifkan
        if (c.getLevel() == 1) {
            characterLabel.setEnabled(false);
            characterLabel.setToolTipText(
                    "Karakter terkunci - Level masih 1"
            );
        }

        // Kursor berubah menjadi tangan
        characterLabel.setCursor(
                Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
        );

        return characterLabel;
    }
}
