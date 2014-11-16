package mmm.part04_annotations_reflexion;


import org.junit.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

public class DaveDateTest {

    @Test
    public void shouldGiveMonthDayAndYearOfBirth() throws IOException {
        Dave dave = new Dave();
        
        LocalDateTime birthDate = dave.getBirthDate();
        
        assertThat(birthDate.getMonthValue()).isEqualTo(11);
        assertThat(birthDate.getDayOfMonth()).isEqualTo(17);
        assertThat(birthDate.getYear()).isEqualTo(1984);
    }

    @Test
    public void shouldGivePeriodYearsMonths() throws IOException {
        Dave dave = new Dave();
        Kevin kevin = new Kevin();

        Period period = Period.between(dave.getBirthDate().toLocalDate(), kevin.getBirthDate().toLocalDate());

        assertThat(period.getYears()).isEqualTo(30);
        assertThat(period.getMonths()).isEqualTo(0);
    }
    

    @Test
    public void shouldFormatDate() throws IOException {
        Dave dave = new Dave();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        assertThat(dateFormatter.format(dave.getBirthDate())).isEqualTo("1984-11-17");
    }
}
