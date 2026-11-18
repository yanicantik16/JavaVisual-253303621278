
package com.unpri.charactermanager.model;

import java.util.ArrayList;

/**
 * Mengelola kumpulan karakter.
 * Menerapkan Composition: CharacterManager memiliki ArrayList<Character>.
 */
public class CharacterManager {

    private ArrayList<Character> characterList;

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

        if (findByName(character.getName()) != null) {
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

    // ===== MENCARI KARAKTER BERDASARKAN NAMA =====
    public Character findByName(String name) {
        if (name == null) {
            return null;
        }

        for (Character c : characterList) {
            if (c.getName().equals(name)) {
                return c;
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
            "Karakter '" + name + "' berhasil dihapus."
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

        for (Character c : characterList) {
            totalLevel += c.getLevel();
        }

        return (double) totalLevel / characterList.size();
    }

    // ===== MINI-CHALLENGE: MENCARI BERDASARKAN TIPE =====
    public ArrayList<Character> findByType(CharacterType type) {
        ArrayList<Character> hasil = new ArrayList<>();

        if (type == null) {
            return hasil;
        }

        for (Character c : characterList) {
            if (c.getType() == type) {
                hasil.add(c);
            }
        }

        return hasil;
    }

    // ===== FITUR MANDIRI: MENCARI KARAKTER TERKUAT =====

    /**
     * Mencari karakter dengan attackPower tertinggi.
     *
     * @return karakter dengan attackPower tertinggi,
     *         atau null jika daftar karakter kosong.
     */
    public Character findStrongest() {
        if (characterList.isEmpty()) {
            return null;
        }

        Character strongest = characterList.get(0);

        for (Character c : characterList) {
            if (c.getAttackPower() > strongest.getAttackPower()) {
                strongest = c;
            }
        }

        return strongest;
    }
}
