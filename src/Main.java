
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== CHARACTER MANAGER v0.1 ===");

        // Membuat tiga karakter
        Character hero = new Character(
            "Arjuna", CharacterType.WARRIOR, 5
        );

        Character wizard = new Character(
            "Merlin", CharacterType.MAGE, 3
        );

        Character scout = new Character(
            "Athena", CharacterType.ARCHER, 4
        );

        // Menampilkan data karakter
        System.out.println(hero);
        System.out.println(wizard);
        System.out.println(scout);

        // Menguji fitur level up
        System.out.println();
        System.out.println(">> " + hero.getName() + " level up!");

        hero.setLevel(hero.getLevel() + 1);

        System.out.println("After level up: " + hero);

        // Menampilkan informasi karakter
        System.out.println();
        System.out.println(">> Nama karakter: " + hero.getName());
        System.out.println(">> Jenis karakter: " + hero.getType());
        System.out.println(">> HP saat ini: " + hero.getHitPoints());

        // Menguji fitur tambahan TP3
        System.out.println();
        System.out.println("=== UJI FITUR TAMBAHAN TP3 ===");

        Character newHero = new Character(
            "Luna", CharacterType.HEALER, 2
        );

        newHero.setMana(75);

        System.out.println(newHero);

        System.out.println(
            ">> Apakah " + newHero.getName()
            + " masih hidup? " + newHero.isAlive()
        );
    }
}
