/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

/**
 *
 * @author hailiang194
 */
public class MainForm extends Form {

    private enum OPTION {
        COUNT_WORD, FIND_FILE, EXIT
    };

    @Override
    public void setup() {

    }

    @Override
    public EXIT_OPTION update() {

        System.out.println("================= Word Program ===================");

        OPTION option = (OPTION) Input.inputOption(OPTION.values());

        Form nextForm = null;
        switch (option) {
            case COUNT_WORD:
                nextForm = new CountWordForm();
                break;
            case FIND_FILE:
                nextForm = new WordInFileForm();
                break;
            case EXIT:
                System.exit(0);
        }
        
        nextForm.setup();
        nextForm.loop();
        
        System.out.println("Press Enter to continue");
        Input.hold();

        return EXIT_OPTION.UPDATE_EXIT;
    }

}
