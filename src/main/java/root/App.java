package root;

import root.GUI.TestFrame;
import root.model.*;

import java.util.ArrayList;

public class App
{
    public static void main( String[] args ) {
//        HeroGenerator heroGenerator= new HeroGenerator();
//        Hero myHero = heroGenerator.createNewHero("Barbarian", "Jakob");
//        System.out.println(myHero.toString());

        MapGenerator mapGenerator = new MapGenerator(1);
        ArrayList<Coordinates> map = mapGenerator.createMap();
        for (Coordinates i : map)
            System.out.println(i.toString());
    }
}




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
//        TestFrame testFrame = new TestFrame(1920, 1080);
//        testFrame.setUpGUI();
//GUI and event driven programming via Swing example