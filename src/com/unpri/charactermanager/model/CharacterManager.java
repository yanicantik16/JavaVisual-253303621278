
package com.unpri.charactermanager.model;

import java.util.ArrayList;

/**
 * Mengelola kumpulan karakter.
 * Menerapkan Composition: CharacterManager memiliki ArrayList<Character>.
 */
public class CharacterManager {

    private final ArrayList<Character> characterList;

    // Maksimal jumlah karakter
    private static final int MAX_CHARACTERS = 20;

    // ===== CONSTRUCTOR =====
    public CharacterManager() {
        this.characterList = new ArrayList<>();
    }

    // ===== MENAMBAHKAN KARAKTER =====
    public boolean addCharacter(Character character) {

        if (character == null) {
            System.out.println("Gagal: karakter tidak boleh kosong!");
            return false;
        }

        if (characterList.size() >= MAX_CHARACTERS) {
            throw new IllegalArgumentException(
                "Jumlah karakter maksimal adalah 20!"
            );
        }

        if (isNameTaken(character.getName())) {
            System.out.println(
                "Gagal: karakter dengan nama '" +
                character.getName() + "' sudah ada!"
            );
            return false;
        }

        characterList.add(character);

        System.out.println(
            "Karakter '" + character.getName() +
            "' berhasil ditambahkan."
        );

        return true;
    }

    // ===== MEMERIKSA NAMA KARAKTER =====
    public boolean isNameTaken(String name) {

        if (name == null || name.trim().isEmpty()) {
            return false;
        }

        for (Character character : characterList) {
            if (character.getName().equalsIgnoreCase(name.trim())) {
                return true;
            }
        }

        return false;
    }

    // ===== MENCARI KARAKTER BERDASARKAN NAMA =====
    public Character findByName(String name) {

        if (name == null) {
            return null;
        }

        for (Character character : characterList) {
            if (character.getName().equalsIgnoreCase(name.trim())) {
                return character;
            }
        }

        return null;
    }

    // ===== MENGHAPUS KARAKTER =====
    public boolean removeCharacter(String name) {

        Character target = findByName(name);

        if (target == null) {
            System.out.println(
                "Gagal hapus: karakter '" + name +
                "' tidak ditemukan."
            );
            return false;
        }

        characterList.remove(target);

        System.out.println(
            "Karakter '" + target.getName() + "' berhasil dihapus."
        );

        return true;
    }

    // ===== MENGHITUNG TOTAL KARAKTER =====
    public int getTotalCharacters() {
        return characterList.size();
    }

    // ===== MENGEMBALIKAN SALINAN LIST =====
    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characterList);
    }

    // ===== MINI-CHALLENGE: RATA-RATA LEVEL =====
    public double getAverageLevel() {

        if (characterList.isEmpty()) {
            return 0;
        }

        int totalLevel = 0;

        for (Character character : characterList) {
            totalLevel += character.getLevel();
        }

        return (double) totalLevel / characterList.size();
    }

    // ===== MINI-CHALLENGE: MENCARI BERDASARKAN TIPE =====
    public ArrayList<Character> findByType(CharacterType type) {

        ArrayList<Character> hasil = new ArrayList<>();

        if (type == null) {
            return hasil;
        }

        for (Character character : characterList) {
            if (character.getType() == type) {
                hasil.add(character);
            }
        }

        return hasil;
    }

    // ===== FITUR MANDIRI: MENCARI KARAKTER TERKUAT =====

    /**
     * Mencari karakter dengan attackPower tertinggi.
     *
     * @return karakter dengan attackPower tertinggi,
     * atau null jika daftar karakter kosong.
     */
    public Character findStrongest() {

        if (characterList.isEmpty()) {
            return null;
        }

        Character strongest = characterList.get(0);

        for (Character character : characterList) {
            if (character.getAttackPower() > strongest.getAttackPower()) {
                strongest = character;
            }
        }

        return strongest;
    }
}
