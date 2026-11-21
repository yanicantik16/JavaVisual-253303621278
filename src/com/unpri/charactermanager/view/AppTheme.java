
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.CharacterType;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public final class AppTheme {

    // ===== WARNA UTAMA =====
    public static final Color BG_MAIN = Color.decode("#13131f");
    public static final Color TEXT_MAIN = Color.decode("#dfe6e9");
    public static final Color TEXT_LIGHT = Color.WHITE;
    public static final Color GOLD = Color.decode("#fdcb6e");

    // ===== WARNA STATUS BAR =====
    public static final Color BG_STATUS = Color.decode("#0d0d1a");
    public static final Color TEXT_MUTED = Color.decode("#9d9dbf");

    // ===== WARNA BERDASARKAN ROLE =====
    public static final Color WARRIOR_COLOR = Color.decode("#d63031");
    public static final Color MAGE_COLOR = Color.decode("#0984e3");
    public static final Color ARCHER_COLOR = Color.decode("#00b894");
    public static final Color HEALER_COLOR = Color.decode("#6c5ce7");

    // ===== FONT =====
    public static final Font FONT_TITLE =
            new Font("SansSerif", Font.BOLD, 22);

    public static final Font FONT_BODY =
            new Font("SansSerif", Font.PLAIN, 14);

    public static final Font FONT_MONO =
            new Font("Monospaced", Font.PLAIN, 13);

    // ===== BATAS LEVEL TINGGI =====
    public static final int HIGH_LEVEL_THRESHOLD = 5;

    // ===== BORDER =====
    public static final Border CARD_BORDER =
            BorderFactory.createEmptyBorder(8, 12, 8, 12);

    public static final Border PANEL_BORDER =
            BorderFactory.createEmptyBorder(20, 25, 20, 25);

    private AppTheme() {
    }

    // ===== WARNA BERDASARKAN ROLE =====
    public static Color colorFor(CharacterType type) {

        switch (type) {
            case WARRIOR:
                return WARRIOR_COLOR;

            case MAGE:
                return MAGE_COLOR;

            case ARCHER:
                return ARCHER_COLOR;

            case HEALER:
                return HEALER_COLOR;

            default:
                return Color.GRAY;
        }
    }

    // ===== DESKRIPSI ROLE =====
    public static String describe(CharacterType type) {

        switch (type) {
            case WARRIOR:
                return "Warrior: jarak dekat, HP tinggi";

            case MAGE:
                return "Mage: serangan sihir, HP rendah";

            case ARCHER:
                return "Archer: serangan jarak jauh";

            case HEALER:
                return "Healer: mendukung dan memulihkan karakter";

            default:
                return "Role belum terdaftar";
        }
    }
}
