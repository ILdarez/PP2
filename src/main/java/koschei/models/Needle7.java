package koschei.models;

import org.springframework.stereotype.Component;

@Component
public class Needle7 {
    private Deth8 deth;

    public Needle7() {
        this.deth = new Deth8();
    }

    @Override
    public String toString() {
        return ", смерть Кощея на игле :( " + deth.toString();
    }
}
