package SerializationExample;

import java.io.InvalidObjectException;
import java.io.ObjectInputValidation;
import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 8/3/22
 */
public class Employee implements Serializable, ObjectInputValidation {
    private static final long serialVersionUID = -5359502671506171397L;
    static  Employee emp;
    public static Employee getInstance(){
        synchronized (Employee.class) {
            if(emp == null){
                emp = new Employee();
            }
        }
        return emp;
    }

    private Employee(){

    }
    protected Object readResolve(){
        System.out.println("read resolve");
        return emp;
    }

    private Object writeReplace() throws ObjectStreamException {
        System.out.println("writeReplace");
        return this;
    }

    @Override
    public void validateObject() throws InvalidObjectException {
        // validate whether data makes sense before handling it back to your application
        System.out.println("validateObject");
    }

    private long empId;
    private String empName;
    private transient String dept;

    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }

    public long getEmpId() {
        return empId;
    }
    public void setEmpId(long empId) {
        this.empId = empId;
    }
    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }

}
