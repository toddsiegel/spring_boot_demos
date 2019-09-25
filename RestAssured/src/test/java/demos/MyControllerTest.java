package demos;

import demos.controllers.MyController;
import demos.controllers.Thing;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyController.class)
public class MyControllerTest {
    @Autowired
    private MyController controller;

    @Test
    public void hello() {
        Thing thing = controller.hello();

        assertThat(thing.getName(), equalTo("One"));
    }
}
