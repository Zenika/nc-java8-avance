package mmm.part01_lambda;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Gru {

    private final Collection<Minion> minions;

    private final AtomicInteger minionsTryingToStealTheMoon = new AtomicInteger(0);

    public Gru(Collection<Minion> minions) {
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

    public Minion createSuperMinion() {
        //TODO create a super minion which is the sum of all minions
        return null;
    }

    public List<Integer> getAgeList() {
        //TODO create list of all minions age without using the toArray function
        return null;
    }

    public static class SuperMinion implements Minion {

        private int age;

        private int eye;

        public SuperMinion(int age, int eye) {
            this.age = age;
            this.eye = eye;
        }

        @Override
        public void takeOrder(Order order) {
            order.doOrder();
        }

        @Override
        public boolean hasExecutedOrder() {
            return true;
        }

        @Override
        public int getAge() {
            return age;
        }

        @Override
        public int getEye() {
            return eye;
        }
    }
}
