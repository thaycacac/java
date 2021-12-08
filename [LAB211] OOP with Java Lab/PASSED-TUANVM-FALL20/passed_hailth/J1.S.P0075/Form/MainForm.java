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
public class MainForm extends Form{

    enum OPTION{CHECK_PATH, JAVA_FILE, SIZE_FILE, WRITE_FILE, COUNT_CHAR, EXIT};
    
    @Override
    public void setup() {
    
    }

    @Override
    protected EXIT_STATUS update() {
        
        System.out.println("================= File Processing ===================");
        
        OPTION option = (OPTION)Input.inputOption(OPTION.values());
        
        Form nextForm = null;
        switch(option)
        {
            case CHECK_PATH:
                nextForm = new CheckPathForm();
                break;
            case JAVA_FILE:
                nextForm = new JavaFileForm();
                break;
            case SIZE_FILE:
                nextForm = new GreaterSizeForm();
                break;
            case WRITE_FILE:
                nextForm = new WriteToFileForm();
                break;
            case COUNT_CHAR:
                nextForm = new CountWordForm();
                break;
            case EXIT:
                System.exit(0);
        }
        
        nextForm.setup();
        nextForm.loop();
        
        Input.hold();
        
        return EXIT_STATUS.UPDATE_EXIT;
    }
    
}
