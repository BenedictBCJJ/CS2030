import java.util.ArrayList;
import java.util.List;
public class A{
    private final List<String> chara = new ArrayList<>();

    public A add(A a) {
        for(String items: a.get()) {
            chara.add(items);
        }
        return new B(this.chara);
    }
}

public class B extends A{

    B(){
        super.chara.add("B");
    }

    B(List ofObj) {
        super.chara = ofObj;
    }

    public List<String> get() {
        return super.chara;
    }

    @Override
    public String toString() {
        String string ="";
        for(Obj item: chara) {
            string += (String) item;
        }
        return string;
    }
}

public class C extends A{

    C(){
        super.chara.add("C");
    }

    C(List ofObj) {
        super.chara = ofObj;
    }

    public List<String> get() {
        return super.chara;
    }

    @Override
    public String toString() {
        String string ="";
        for(Obj item: chara) {
            string += (String) item;
        }
        return string;
    }
}
