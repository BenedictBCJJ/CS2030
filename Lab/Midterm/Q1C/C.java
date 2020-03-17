import java.util.ArrayList;
import java.util.List;
public class C{
    private List<String> chara = new ArrayList<>();

    C(){
        chara.add("C");
    }

    C(List<String> ofObj) {
        this.chara = ofObj;
    }

    public List<String> get() {
        return this.chara;
    }

    public C add(C c) {
        for(String items: c.get()) {
            chara.add(items);
        }
        return new C(this.chara);
    }

    public C add(B b) {
        for(String items: b.get()) {
            chara.add(items);
        }
        return new C(this.chara);
    }

    @Override
    public String toString() {
        String string = "";
        for(String item: chara) {
            string += item;
        }
        return string;
    }
}
