package mmm.part04_annotations_reflexion;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

//TODO check if collections minions is null 
public class Gru {

    private final Collection<Minion> minions;

    private final AtomicInteger minionsTryingToStealTheMoon = new AtomicInteger(0);

    public Gru(Collection<Minion> minions) {
    	//TODO add check if minions are not Null
        this.minions = minions;
    }

    public void stealTheMoon() {
        minions.parallelStream().forEach(m -> m.takeOrder(minionsTryingToStealTheMoon::incrementAndGet));
    }

    public double computeMinionsAverageAge() {
        return minions.parallelStream().mapToInt(Minion::getAge).average().orElseThrow(IllegalStateException::new);
    }

    public boolean hasStealTheMoon() {
        return minionsTryingToStealTheMoon.get() == minions.size();
    }
}
