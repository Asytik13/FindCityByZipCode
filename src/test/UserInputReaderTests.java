package test;

import com.company.UserInputReader;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class UserInputReaderTests {
    UserInputReader reader = new UserInputReader();

    @Test
    public void PathVerifyInputReturnsTrue(){
        boolean actual = reader.VerifyInput("11111");

        assertThat(actual).isEqualTo(true);
    }

    @Test
    public void VerifyInputReturnsFalse(){
        boolean actual = reader.VerifyInput("11111111");

        assertThat(actual).isEqualTo(false);
    }

    @Test
    public void VerifyInputReturnsFalseForEmptyZipcode(){
        boolean actual = reader.VerifyInput("");

        assertThat(actual).isEqualTo(false);
    }

    @Test
    public void VerifyInputReturnsFalseForZipcodeWithLetters(){
        boolean actual = reader.VerifyInput("23er5");

        assertThat(actual).isEqualTo(false);
    }
}
