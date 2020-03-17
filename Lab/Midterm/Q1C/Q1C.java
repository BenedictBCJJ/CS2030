import java.util.ArrayList;
import java.util.List;

public class A {
    private List<String> chara = new ArrayList<>();

    A(String string){
        chara.add(string);
    }

    A(List<String> ofObj) {
        this.chara = ofObj;
    }

    public List<String> get() {
        return this.chara;
    }

    public A add(A c) {
        for(String items: c.get()) {
            chara.add(items);
        }
        return new A(this.chara);
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

                          

public class B extends A{

    B(){
        super("B");
    }

    B(List<String> ofObj) {
        super(ofObj);
    }
}

public class C extends A{
    private List<String> chara = new ArrayList<>();

    C(){
        super("C");
    }

    C(List<String> ofObj) {
        super(ofObj);
    }

}
