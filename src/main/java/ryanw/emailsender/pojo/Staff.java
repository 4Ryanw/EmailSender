package ryanw.emailsender.pojo;/**
 * Created by NARNEW on 2021/7/5
 */

/**
 * @ClassName Staff
 * @Description 员工实体类
 * @Author NARNEW
 * @Date 2021/7/5 0:18
 */
public class Staff {

    public Staff(String workNumber, String name, String birthday, String emailAddress) {
        this.workNumber = workNumber;
        this.name = name;
        this.birthday = birthday;
        this.emailAddress = emailAddress;
    }

    //工号
    private String workNumber;
    //姓名
    private String name;
    //生日
    private String birthday;
    //邮箱地址
    private String emailAddress;

    public String getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
