
package com.unpri.charactermanager.model;

/**
 * Merepresentasikan satu karakter dalam aplikasi Character Manager.
 * Menggunakan prinsip Encapsulation.
 */
public class Character {

    // ===== ATRIBUT =====
    private int id;
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attackPower;
    private int mana;

    // ===== CONSTRUCTOR 1 =====
    public Character(String name, CharacterType type, int level) {

        // Validasi nama
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Nama tidak boleh kosong"
            );
        }

        // Validasi role
        if (type == null) {
            throw new IllegalArgumentException(
                "Role wajib dipilih"
            );
        }

        // Validasi level
        if (level < 1 || level > 99) {
            throw new IllegalArgumentException(
                "Level harus 1-99"
            );
        }

        // Mini-Challenge: MAGE maksimal level 60
        if (type == CharacterType.MAGE && level > 60) {
            throw new IllegalArgumentException(
                "MAGE tidak boleh memiliki level di atas 60"
            );
        }

        this.name = name.trim();
        this.type = type;
        this.level = level;
        this.hitPoints = calculateBaseHP();
        this.attackPower = calculateBaseAttack();
        this.mana = 0;
    }

    // ===== CONSTRUCTOR 2 =====
    public Character(int id, String name, CharacterType type,
                     int level, int hitPoints, int attackPower) {

        this(id, name, type, level, hitPoints, attackPower, 0);
    }

    // Konstruktor tambahan untuk mempertahankan data lama
    public Character(int id, String name, CharacterType type,
                     int level, int hitPoints, int attackPower, int mana) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Nama tidak boleh kosong"
            );
        }

        if (type == null) {
            throw new IllegalArgumentException(
                "Role wajib dipilih"
            );
        }

        if (level < 1 || level > 99) {
            throw new IllegalArgumentException(
                "Level harus 1-99"
            );
        }

        if (type == CharacterType.MAGE && level > 60) {
            throw new IllegalArgumentException(
                "MAGE tidak boleh memiliki level di atas 60"
            );
        }

        this.id = id;
        this.name = name.trim();
        this.type = type;
        this.level = level;
        this.hitPoints = hitPoints;
        this.attackPower = attackPower;
        this.mana = mana;
    }

    // ===== HELPER METHOD =====
    private int calculateBaseHP() {
        return 100 + (level * 10);
    }

    private int calculateBaseAttack() {
        return 10 + (level * 5);
    }

    // ===== GETTER =====
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CharacterType getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getMana() {
        return mana;
    }

    // ===== SETTER =====
    public void setId(int id) {
        this.id = id;
    }

    public void setLevel(int level) {

        if (level < 1 || level > 99) {
            throw new IllegalArgumentException(
                "Level harus 1-99"
            );
        }

        if (type == CharacterType.MAGE && level > 60) {
            throw new IllegalArgumentException(
                "MAGE tidak boleh memiliki level di atas 60"
            );
        }

        this.level = level;
        this.hitPoints = calculateBaseHP();
        this.attackPower = calculateBaseAttack();
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException(
                "Mana tidak boleh negatif"
            );
        }

        this.mana = mana;
    }

    // ===== METHOD isAlive =====
    public boolean isAlive() {
        return hitPoints > 0;
    }

    // ===== METHOD equals =====
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Character)) {
            return false;
        }

        Character other = (Character) obj;

        return this.name.equalsIgnoreCase(other.name);
    }

    // ===== toString =====
    @Override
    public String toString() {
        return "Character{id=" + id +
               ", name='" + name + '\'' +
               ", type=" + type +
               ", level=" + level +
               ", hp=" + hitPoints +
               ", atk=" + attackPower +
               ", mana=" + mana +
               '}';
    }
}
