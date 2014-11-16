package mmm.part05_correction;

import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

public class CarlTest {

    @Test
    public void shouldHaveAsMastersGruAndElMachoAndNefario() throws IOException {
        Master[] masters = Carl.class.getDeclaredAnnotationsByType(Master.class);
        assertThat(masters).hasSize(3);
        assertThat(masters[0].value()).isEqualTo("Gru");
        assertThat(masters[1].value()).isEqualTo("El Macho");
        assertThat(masters[2].value()).isEqualTo("Dr. Nefario");
    }

    @Test
    public void shouldBeEvil() throws IOException {
        Evil evil = Carl.class.getAnnotatedInterfaces()[0].getAnnotation(Evil.class);
        assertThat(evil).isNotNull();
    }

    @Test
    public void shouldHaveMinions() throws IOException {
        Method[] methods = Carl.class.getMethods();
        for (Method method : methods) {
            if ("takeOrder".equals(method.getName())) {
                assertThat(method.getParameters()).hasSize(1);
                assertThat(method.getParameters()[0].getName()).isEqualToIgnoringCase("order");
            }
        }
    }
}
