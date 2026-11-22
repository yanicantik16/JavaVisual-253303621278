
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComponent;
import javax.swing.border.Border;

public class CharacterFormPanel extends JPanel {

    private final CharacterManager manager;
    private final Runnable onAdded;

    private JTextField nameField;
    private JComboBox<CharacterType> roleComboBox;
    private JSpinner levelSpinner;
    private JLabel messageLabel;

    private Border originalNameBorder;
    private Border originalRoleBorder;
    private Border originalLevelBorder;

    public CharacterFormPanel(
            CharacterManager manager,
            Runnable onAdded) {

        this.manager = manager;
        this.onAdded = onAdded;

        initComponents();
    }

    // ===== MEMBUAT FORM =====
    private void initComponents() {

        setLayout(new BorderLayout(8, 10));
        setBackground(AppTheme.BG_STATUS);

        setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                AppTheme.TEXT_MUTED
                        ),
                        BorderFactory.createEmptyBorder(
                                15, 12, 15, 12
                        )
                )
        );

        setPreferredSize(new Dimension(270, 350));

        JLabel titleLabel = new JLabel("TAMBAH KARAKTER");
        titleLabel.setFont(
                AppTheme.FONT_BODY.deriveFont(Font.BOLD)
        );
        titleLabel.setForeground(AppTheme.GOLD);

        add(titleLabel, BorderLayout.NORTH);

        JPanel fieldsPanel = new JPanel(
                new GridLayout(0, 1, 5, 5)
        );
        fieldsPanel.setBackground(AppTheme.BG_STATUS);

        // ===== NAMA =====
        JLabel nameLabel = new JLabel("Nama Karakter");
        nameLabel.setForeground(AppTheme.TEXT_MAIN);

        nameField = new JTextField();
        nameField.setFont(AppTheme.FONT_BODY);
        originalNameBorder = nameField.getBorder();

        // ===== ROLE =====
        JLabel roleLabel = new JLabel("Pilih Role");
        roleLabel.setForeground(AppTheme.TEXT_MAIN);

        roleComboBox = new JComboBox<>(CharacterType.values());
        originalRoleBorder = roleComboBox.getBorder();

        // ===== LEVEL =====
        JLabel levelLabel = new JLabel("Level (1-99)");
        levelLabel.setForeground(AppTheme.TEXT_MAIN);

        levelSpinner = new JSpinner(
                new SpinnerNumberModel(1, 1, 99, 1)
        );
        originalLevelBorder = levelSpinner.getBorder();

        // ===== TOMBOL SIMPAN =====
        JButton saveButton = new JButton("Simpan Karakter");
        saveButton.setFont(AppTheme.FONT_BODY);
        saveButton.setBackground(AppTheme.GOLD);
        saveButton.setForeground(AppTheme.BG_MAIN);
        saveButton.setFocusPainted(false);

        saveButton.addActionListener(e -> saveCharacter());
        nameField.addActionListener(e -> saveCharacter());

        // ===== PESAN VALIDASI =====
        messageLabel = new JLabel(" ");
        messageLabel.setFont(AppTheme.FONT_MONO);
        messageLabel.setForeground(AppTheme.TEXT_MUTED);

        fieldsPanel.add(nameLabel);
        fieldsPanel.add(nameField);
        fieldsPanel.add(roleLabel);
        fieldsPanel.add(roleComboBox);
        fieldsPanel.add(levelLabel);
        fieldsPanel.add(levelSpinner);
        fieldsPanel.add(saveButton);
        fieldsPanel.add(messageLabel);

        add(fieldsPanel, BorderLayout.CENTER);
    }

    // ===== VALIDASI NAMA =====
    private String validateName(String name) {

        if (name.isEmpty()) {
            return "Nama wajib diisi!";
        }

        if (name.length() < 3 || name.length() > 20) {
            return "Nama harus 3-20 karakter!";
        }

        if (!name.matches("[\\p{L} ]+")) {
            return "Nama hanya boleh berisi huruf& spasi!";
        }

        if (name.contains("  ")) {
            return "Nama tidak boleh memiliki spasi ganda!";
        }

        if (manager.isNameTaken(name)) {
            return "Nama karakter sudah digunakan!";
        }

        return null;
    }

    // ===== MENYIMPAN KARAKTER =====
    private void saveCharacter() {

        clearMessage();

        String name = nameField.getText().trim();

        String error = validateName(name);

        if (error != null) {
            showError(error, nameField, originalNameBorder);
            return;
        }

        try {
            levelSpinner.commitEdit();
        } catch (ParseException ex) {
            showError(
                    "Level harus berupa angka!",
                    levelSpinner,
                    originalLevelBorder
            );
            return;
        }

        CharacterType selectedType =
                (CharacterType) roleComboBox.getSelectedItem();

        Integer selectedLevel =
                (Integer) levelSpinner.getValue();

        if (selectedType == null) {
            showError(
                    "Role wajib dipilih!",
                    roleComboBox,
                    originalRoleBorder
            );
            return;
        }

        try {

            Character newCharacter = new Character(
                    name,
                    selectedType,
                    selectedLevel
            );

            boolean added = manager.addCharacter(newCharacter);

            if (!added) {
                showError(
                        "Karakter gagal ditambahkan!",
                        nameField,
                        originalNameBorder
                );
                return;
            }

            showSuccess("Karakter berhasil ditambahkan!");

            nameField.setText("");
            roleComboBox.setSelectedIndex(0);
            levelSpinner.setValue(1);

            clearBorders();

            if (onAdded != null) {
                onAdded.run();
            }

            nameField.requestFocusInWindow();

        } catch (IllegalArgumentException ex) {

            showError(
                    ex.getMessage(),
                    nameField,
                    originalNameBorder
            );
        }
    }

    // ===== MENAMPILKAN ERROR =====
    private void showError(
            String message,
            JComponent component,
            Border originalBorder) {

        messageLabel.setText(
                "<html><div style='width:225px;'>"
                        + message
                        + "</div></html>"
        );

        messageLabel.setForeground(AppTheme.ERROR);

        component.setBorder(
                BorderFactory.createLineBorder(AppTheme.ERROR, 2)
        );

        component.requestFocusInWindow();
    }

    // ===== MENAMPILKAN SUKSES =====
    private void showSuccess(String message) {

        messageLabel.setText(
                "<html><div style='width:225px;'>"
                        + message
                        + "</div></html>"
        );

        messageLabel.setForeground(AppTheme.SUCCESS);
    }

    // ===== MENGEMBALIKAN BORDER =====
    private void clearBorders() {

        nameField.setBorder(originalNameBorder);
        roleComboBox.setBorder(originalRoleBorder);
        levelSpinner.setBorder(originalLevelBorder);
    }

    // ===== MEMBERSIHKAN PESAN =====
    private void clearMessage() {

        messageLabel.setText(" ");
        messageLabel.setForeground(AppTheme.TEXT_MUTED);

        clearBorders();
    }
}
