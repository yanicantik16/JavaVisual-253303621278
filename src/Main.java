
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        // Membuat CharacterManager
        CharacterManager manager = new CharacterManager();

        // ===== MENAMBAHKAN 8 KARAKTER =====

        manager.addCharacter(
                new Character("Arjuna", CharacterType.WARRIOR, 5)
        );

        manager.addCharacter(
                new Character("Merlin", CharacterType.MAGE, 3)
        );

        manager.addCharacter(
                new Character("Athena", CharacterType.ARCHER, 4)
        );

        manager.addCharacter(
                new Character("Bima", CharacterType.WARRIOR, 7)
        );

        manager.addCharacter(
                new Character("Luna", CharacterType.HEALER, 10)
        );

        manager.addCharacter(
                new Character("Morgana", CharacterType.MAGE, 1)
        );

        manager.addCharacter(
                new Character("Ranger", CharacterType.ARCHER, 6)
        );

        manager.addCharacter(
                new Character("Aurelia", CharacterType.HEALER, 8)
        );

        // ===== MENJALANKAN GUI MELALUI EDT =====

        SwingUtilities.invokeLater(() -> {

            MainWindow window = new MainWindow(
                    manager.getAllCharacters(),
                    manager
            );

            window.setVisible(true);
        });
    }
}
