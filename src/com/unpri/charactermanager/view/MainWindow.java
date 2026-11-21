
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class MainWindow extends JFrame {

    private final ArrayList<Character> characterList;
    private final CharacterManager manager;

    private JPanel mainPanel;

    public MainWindow(
            ArrayList<Character> characterList,
            CharacterManager manager) {

        super("Character Manager v0.5");

        this.characterList = characterList;
        this.manager = manager;

        initComponents();

        setMinimumSize(new Dimension(560, 380));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        // ===== MAIN PANEL =====
        mainPanel = new JPanel(new BorderLayout(12, 12));
        mainPanel.setBackground(AppTheme.BG_MAIN);
        mainPanel.setBorder(AppTheme.PANEL_BORDER);

        // ===== NORTH: HEADER DAN PANEL STATISTIK =====
        JPanel northPanel = new JPanel(new BorderLayout(0, 10));
        northPanel.setBackground(AppTheme.BG_MAIN);

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(AppTheme.BG_MAIN);

        JLabel titleLabel = new JLabel(
                "=== Daftar Karakter (" + characterList.size() + ") ==="
        );

        titleLabel.setFont(AppTheme.FONT_TITLE);
        titleLabel.setForeground(AppTheme.TEXT_MAIN);

        JLabel subtitleLabel = new JLabel(
                "Character Manager - Kelola karakter petualanganmu"
        );

        subtitleLabel.setFont(AppTheme.FONT_BODY);
        subtitleLabel.setForeground(AppTheme.TEXT_MUTED);

        headerPanel.add(titleLabel, BorderLayout.WEST);
        headerPanel.add(subtitleLabel, BorderLayout.SOUTH);

        northPanel.add(headerPanel, BorderLayout.NORTH);

        // ===== PANEL TAMBAHAN: STATISTIK =====
        JPanel statisticsPanel = new JPanel(new GridLayout(2, 2, 8, 5));
        statisticsPanel.setBackground(AppTheme.BG_STATUS);
        statisticsPanel.setBorder(
                BorderFactory.createEmptyBorder(8, 10, 8, 10)
        );

        double averageLevel = manager.getAverageLevel();

        Character strongest = manager.findStrongest();

        String strongestName = strongest == null
                ? "-"
                : strongest.getName();

        addStatistic(statisticsPanel,
                "TOTAL KARAKTER",
                String.valueOf(manager.getTotalCharacters()));

        addStatistic(statisticsPanel,
                "RATA-RATA LEVEL",
                String.format("%.2f", averageLevel));

        addStatistic(statisticsPanel,
                "KARAKTER TERKUAT",
                strongestName);

        addStatistic(statisticsPanel,
                "VERSI APLIKASI",
                "v0.5");

        northPanel.add(statisticsPanel, BorderLayout.CENTER);

        mainPanel.add(northPanel, BorderLayout.NORTH);

        // ===== CENTER: DAFTAR KARAKTER =====
        JPanel characterHolder = new JPanel(new GridLayout(0, 1, 5, 10));
        characterHolder.setBackground(AppTheme.BG_MAIN);

        characterHolder.setBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        );

        for (Character c : characterList) {
            characterHolder.add(createCharacterLabel(c));
        }

        JScrollPane scroll = new JScrollPane(characterHolder);

        scroll.setPreferredSize(new Dimension(460, 280));
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        );
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );

        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.getViewport().setBackground(AppTheme.BG_MAIN);

        mainPanel.add(scroll, BorderLayout.CENTER);

        // ===== EAST: ROLE LEGEND =====
        JPanel legendPanel = createLegendPanel();

        mainPanel.add(legendPanel, BorderLayout.EAST);

        // ===== SOUTH: STATUS BAR =====
        JPanel statusPanel = new JPanel(new BorderLayout());

        statusPanel.setBackground(AppTheme.BG_STATUS);
        statusPanel.setBorder(
                BorderFactory.createEmptyBorder(8, 12, 8, 12)
        );

        JLabel statusLabel = new JLabel(
                "Total karakter: " + characterList.size()
                        + " | Semua data berhasil dimuat"
        );

        statusLabel.setFont(AppTheme.FONT_MONO);
        statusLabel.setForeground(AppTheme.TEXT_MUTED);

        JLabel versionLabel = new JLabel("v0.5");

        versionLabel.setFont(AppTheme.FONT_MONO);
        versionLabel.setForeground(AppTheme.GOLD);

        statusPanel.add(statusLabel, BorderLayout.WEST);
        statusPanel.add(versionLabel, BorderLayout.EAST);

        mainPanel.add(statusPanel, BorderLayout.SOUTH);

        // ===== TAMBAHKAN MAIN PANEL =====
        add(mainPanel);
    }

    // ===== MEMBUAT KOMPONEN STATISTIK =====
    private void addStatistic(
            JPanel panel,
            String title,
            String value) {

        JPanel itemPanel = new JPanel(
                new BorderLayout(0, 3)
        );

        itemPanel.setBackground(AppTheme.BG_STATUS);

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(AppTheme.FONT_MONO);
        titleLabel.setForeground(AppTheme.TEXT_MUTED);

        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(AppTheme.FONT_BODY.deriveFont(Font.BOLD));
        valueLabel.setForeground(AppTheme.GOLD);

        itemPanel.add(titleLabel, BorderLayout.NORTH);
        itemPanel.add(valueLabel, BorderLayout.CENTER);

        panel.add(itemPanel);
    }

    // ===== MEMBUAT LEGEND ROLE =====
    private JPanel createLegendPanel() {

        JPanel legendPanel = new JPanel();

        legendPanel.setLayout(
                new BoxLayout(legendPanel, BoxLayout.Y_AXIS)
        );

        legendPanel.setBackground(AppTheme.BG_STATUS);
        legendPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(AppTheme.TEXT_MUTED),
                        new EmptyBorder(10, 10, 10, 10)
                )
        );

        JLabel legendTitle = new JLabel("ROLE LEGEND");

        legendTitle.setFont(AppTheme.FONT_BODY.deriveFont(Font.BOLD));
        legendTitle.setForeground(AppTheme.GOLD);
        legendTitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        legendPanel.add(legendTitle);
        legendPanel.add(Box.createVerticalStrut(15));

        for (CharacterType type : CharacterType.values()) {

            JLabel roleLabel = new JLabel(
                    type.toString()
            );

            roleLabel.setFont(AppTheme.FONT_BODY);
            roleLabel.setForeground(AppTheme.colorFor(type));
            roleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

            JLabel descriptionLabel = new JLabel(
                    AppTheme.describe(type)
            );

            descriptionLabel.setFont(
                    AppTheme.FONT_MONO.deriveFont(10f)
            );

            descriptionLabel.setForeground(AppTheme.TEXT_MUTED);
            descriptionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

            legendPanel.add(roleLabel);
            legendPanel.add(descriptionLabel);
            legendPanel.add(Box.createVerticalStrut(12));
        }

        legendPanel.add(Box.createVerticalGlue());

        legendPanel.setPreferredSize(new Dimension(205, 200));

        return legendPanel;
    }

    // ===== MEMBUAT KARTU KARAKTER =====
    private JLabel createCharacterLabel(Character c) {

        String info = c.getName()
                + " | " + c.getType()
                + " | Lv." + c.getLevel()
                + " | HP:" + c.getHitPoints()
                + " | ATK:" + c.getAttackPower();

        JLabel characterLabel = new JLabel(info);

        characterLabel.setBackground(
                AppTheme.colorFor(c.getType())
        );

        characterLabel.setOpaque(true);
        characterLabel.setBorder(AppTheme.CARD_BORDER);
        characterLabel.setFont(AppTheme.FONT_BODY);

        if (c.getLevel() >= AppTheme.HIGH_LEVEL_THRESHOLD) {

            characterLabel.setForeground(AppTheme.GOLD);

            characterLabel.setFont(
                    AppTheme.FONT_BODY.deriveFont(Font.BOLD)
            );

        } else {

            characterLabel.setForeground(AppTheme.TEXT_LIGHT);
        }

        characterLabel.setToolTipText(
                AppTheme.describe(c.getType())
                        + " | HP: " + c.getHitPoints()
                        + " | ATK: " + c.getAttackPower()
        );

        if (c.getLevel() == 1) {

            characterLabel.setEnabled(false);

            characterLabel.setToolTipText(
                    "Karakter terkunci - Level masih 1"
            );
        }

        return characterLabel;
    }
}
