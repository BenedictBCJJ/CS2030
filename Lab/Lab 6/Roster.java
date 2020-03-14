import java.util.Optional;

public class Roster extends KeyableMap<String, String, Student> {

    Roster(String year) {        
        super(year);
    }

    public String getGrade(String student, String module, String test) {        
        return this.get(student)
            .flatMap(x -> x.get(module))
            .flatMap(x -> x.get(test))
            .map(x -> x.getGrade())
            .orElseThrow();   
    }

    @Override
    public Roster put(Student student) {
        super.put(student);
        return this;
    }
}
