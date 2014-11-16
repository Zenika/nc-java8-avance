package mmm.part04_annotations_reflexion;

import org.junit.Test;

import java.io.IOException;

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
		//TODO checking that carl is an evil minion
	}
	
	@Test
    public void shouldHaveMinions() throws IOException { 
		//TODO get "takeOrder" method's parameter names and check that it has a parameter name order
	}
}
