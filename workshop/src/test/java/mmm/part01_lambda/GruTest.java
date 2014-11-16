package mmm.part01_lambda;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class GruTest {

    @Test
    public void shouldMakeSuperMinion() {
        Gru gru = createGru();
        Assertions.assertThat(gru.createSuperMinion()).isNotNull().is(new Condition<Minion>() {
            @Override
            public boolean matches(Minion value) {
                return value.getAge() == 18 && value.getEye() == 5;
            }
        });
    }

    @Test
    public void shouldGetTheAgeList(){
        Gru gru = createGru();
        Assertions.assertThat(gru.getAgeList()).containsOnly(3, 5, 10);
    }

    private Gru createGru() {
        Collection<Minion> minions = new ArrayList<>();
        minions.add(new Carl());
        minions.add(new Kevin());
        minions.add(new Dave());
        return new Gru(minions);
    }


}
