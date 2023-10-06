import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class JUnitTest { // assertJ 사용법
    @Test
    @DisplayName("test")
    public void test() {
        final int a = 2;
        final int b = 1;
        final int sum = 3;

        assertThat(a+b).isEqualTo(sum);
    }
}
