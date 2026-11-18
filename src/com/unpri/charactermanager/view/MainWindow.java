
package com.unpri.charactermanager.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;

public class MainWindow extends JFrame {

    private JPanel mainPanel;
    private ArrayList<Character> characterList;
    private CharacterManager manager;

    public MainWindow(
            ArrayList<Character> characterList,
            CharacterManager manager) {

        super("Character Manager v0.3");

        this.characterList = characterList;
        this.manager = manager;

        initComponents();

        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        mainPanel = new JPanel(new GridLayout(0, 1, 5, 10));

        mainPanel.setBorder(
            BorderFactory.createEmptyBorder(20, 25, 20, 25)
        );

        JLabel titleLabel = new JLabel(
            "=== Daftar Karakter (" + characterList.size() + ") ===",
            JLabel.CENTER
        );

        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        mainPanel.add(titleLabel);

        // Menampilkan daftar karakter
        for (Character c : characterList) {

            String info = c.getName()
                    + " | " + c.getType()
                    + " | Lv." + c.getLevel()
                    + " | HP:" + c.getHitPoints()
                    + " | ATK:" + c.getAttackPower();

            JLabel characterLabel = new JLabel(info);
            characterLabel.setFont(new Font("Arial", Font.PLAIN, 14));

            mainPanel.add(characterLabel);
        }

        // Mengambil rata-rata level dari CharacterManager
        double averageLevel = manager.getAverageLevel();

        JLabel averageLabel = new JLabel(
            String.format("Rata-rata Level: %.2f", averageLevel)
        );

        averageLabel.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(averageLabel);

        add(mainPanel, BorderLayout.CENTER);
    }
}
