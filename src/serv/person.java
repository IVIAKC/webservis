package serv; /**
 * Created by IVIAKC on 13.11.2015.
 */

import javax.persistence.*;

@Entity
@Table(name = "serv.Person")
public class Person {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="login")
    private String login;

    @Column(name="pas")
    private String pas;

    @Column(name="last_name")
    private String last_name;

    @Column(name="first_name")
    private String first_name;

    // getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPas() {
        return pas;
    }

    public void setPas(String pas) {
        this.pas = pas;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
}