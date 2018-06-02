import java.util.Comparator;

public class AutarquiaComparator implements Comparator<Municipe> {

    @Override
    public int compare(Municipe o1, Municipe o2) {
       return o1.getAutarquia().compareTo(o2.getAutarquia());
    }
}
