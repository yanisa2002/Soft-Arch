
import java.util.Set;
import java.util.LinkedHashSet;

public class HealthcareWorkerTeam implements HealthcareServiceable {
    private Set<HealthcareServiceable> members = new LinkedHashSet<>();

    public void addMember(HealthcareServiceable worker) {
        this.members.add(worker);
    }

    public void removeMember(HealthcareServiceable worker) {
        this.members.remove(worker);
    }

    @Override
    public void service() {
        for (HealthcareServiceable worker : this.members) {
            worker.service();
        }
    }

    @Override
    public double getPrice() {
        double sum = 0;
        for (HealthcareServiceable worker : this.members) {
            sum += worker.getPrice();
        }
        return sum;
    }
}
