package spittr.web;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.result.*;
import org.springframework.test.web.servlet.request.*;
import org.springframework.web.servlet.view.InternalResourceView;
import spittr.data.SpittleRepository;
import spittr.model.Spittle;

import java.util.List;

import static org.mockito.Mockito.when;

public class HomeControllerTest {

    @Test
    public void testHomePage() throws Exception{
        HomeController controller = new HomeController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        Assert.assertEquals("home",controller.home());
    }

}
