import java.util.ArrayList;
import java.util.List;
public class B {
    private List<String> chara = new ArrayList<>();

    B(){
        chara.add("B");
    }

    B(List<String> ofObj) {
        this.chara = ofObj;
    }

    public List<String> get() {
        return this.chara;
    }

    public B add(C c) {
        for(String items: c.get()) {
            chara.add(items);
        }
        return new B(this.chara);
    }

    public B add(B b) {
        for(String items: b.get()) {
            chara.add(items);
        }
        return new B(this.chara);
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
