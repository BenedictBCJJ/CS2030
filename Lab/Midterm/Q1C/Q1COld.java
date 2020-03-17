import java.util.ArrayList;
public class B{
    private final List<String> char = new ArrayList<>();

    B(){
        char.add("B");
    }

    B(List ofObj) {
        this.char = ofObj;
    }

    public List<String> get() {
        return this.char;
    }

    public B add(C c) {
        for(String items: c.get()) {
            char.add(items);
        }
        return new B(this.char);
    }

    public B add(B b) {
        for(String items: b.get()) {
            char.add(items);
        }
        return new B(this.char);
    }

    @Override
    public String toString() {
        for(Obj item: char) {
            string += (String) item;
        }
        return string;
    }
}

public class C{
    private final List<String> char = new ArrayList<>();

    C(){
        char.add("C");
    }

    C(List ofObj) {
        this.char = ofObj;
    }

    public List<String> get() {
        return this.char;
    }

    public C add(C c) {
        for(String items: c.get()) {
            char.add(items);
        }
        return new C(this.char);
    }

    public C add(B b) {
        for(String items: b.get()) {
            char.add(items);
        }
        return new C(this.char);
    }

    @Override
    public String toString() {
        for(Obj item: char) {
            string += (String) item;
        }
        return string;
    }
}
