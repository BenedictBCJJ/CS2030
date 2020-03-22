import java.util.ArrayList;
import java.util.List;

class Cluster{
    private String clusterName;
    List<Case> cluster = new ArrayList<>();
}

interface AddContactType{
}

class Case implements AddContactType{
    private int id;
    List<Case> contacts;
    private Contact contactType;
}


class ImportedCase extends Case {
    private String country;
}

class LocalCase extends Case {
}


class Contact {
    private String contactType;
}
