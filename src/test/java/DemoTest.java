import com.testng.BaseTestCase;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DemoTest extends BaseTestCase {

    @Test
    public void demoRetryTest() {
//        driver.get("https://www.amazon.in/");
        assertThat(1).isEqualTo(1);
    }

}
