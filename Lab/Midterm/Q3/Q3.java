   import java.util.ArrayList;
   import java.util.List;
   
   public class Cluster{
   final String clusterName;
   List<Case> cluser = new ArrayList<>();
   }
   public class Case{
   final int id;
   Case(id){}
   };
   
   public interface Contacts;
   
   public class ConfirmedCase extends Case implements Contacts{
   List<Case> contacts = new ArrayList<>();
   }
   
   public class ImportedCase extends ConfirmedCase{
   final String country;
   };
   
   public class LocalCase extends ConfirmedCase;
   
   
   public class ContactTypes{
   private final String type;
   }
