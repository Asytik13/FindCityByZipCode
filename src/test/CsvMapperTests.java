package test;

import com.company.CsvMapper;
import com.company.CsvReader;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CsvMapperTests {
    CsvReader reader = new CsvReader();
    CsvMapper mapper = reader.readFile();

    @Test
    public void happyPathOneCity(){
        List<String> expected = Arrays.asList("TEST CITY");
        List<String> actual = mapper.getCityByCode("11111");

        assertThat(actual).containsOnlyElementsOf(expected);
    }

    @Test
    public void happyPathTwoCities(){
        List<String> expected = Arrays.asList("SAINT PAUL", "V A");
        List<String> actual = mapper.getCityByCode("55168");

        assertThat(actual).containsOnlyElementsOf(expected);
    }

    @Test
    public void happyPathNotFoundCity(){
        List<String> expected = Arrays.asList();
        List<String> actual = mapper.getCityByCode("000");

        assertThat(actual).containsOnlyElementsOf(expected);
    }





}
