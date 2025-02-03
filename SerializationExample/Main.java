package SerializationExample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.CompletableFuture;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 8/3/22
 */
public class Main {
    public static void main(String[] args) throws Exception{

        //serialization
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serialization.txt"));
        Employee emp = Employee.getInstance();
        emp.setEmpId(2);
        emp.setEmpName("Dinakar");
        emp.setDept("IT");

        //writeReplace() is called before writeObject
        oos.writeObject(emp);
        oos.flush();
        oos.close();

        //deserialization
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serialization.txt"));
        Employee emp2 = (Employee)ois.readObject();

        //after readObject is returned, readResolve() is called
        System.out.println("Employee Id: "+emp2.getEmpId());
        System.out.println("Employee Name: "+emp2.getEmpName());
        System.out.println("Dept Name: "+emp2.getDept());

        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future = completableFuture.thenApply(s -> s + " World");
    }

}
