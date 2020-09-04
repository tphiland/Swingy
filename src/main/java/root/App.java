package root;

import root.gui.TestFrame;
import root.model.User;

import javax.swing.*;
import javax.validation.*;
import java.util.Set;

public class App
{
    public static void main( String[] args ) {

//annotation validation via javax.validation example
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        Validator validator = factory.getValidator();
//
//        User user = new User();
//        user.setWorking(false);
//        user.setAboutMe("hi");
//        user.setAge(17);
//        user.setEmail("hi");
//
//        Set<ConstraintViolation<User>> violations = validator.validate(user);
//
//        for (ConstraintViolation<User> violation : violations) {
//            System.out.println(violation.getMessage());
//        }
//annotation validation javax.validation example

//GUI and event driven programming via Swing example
        TestFrame testFrame = new TestFrame(640, 480);
        testFrame.setUpGUI();


    }
}
