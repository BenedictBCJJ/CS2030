import java.util.ArrayList;
import java.util.List;

public class Cluster{
    private String clusterName;
    List<Case> cluster = new ArrayList<>();
}

public interface AddContactType{
}

public class Case implements AddContactType{
    private int id;
}


public class ImportedCase extends Case {
    private String country;
}

public class LocalCase extends Case {
}


public class Contact {
    private Case case1;
    private Case case2;
    private String contactType;
}
