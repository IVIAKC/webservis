/**
 * Created by IVIAKC on 13.11.2015.
 */

import javax.persistence.*;

@Entity
@Table(name = "tes")
public class tes {

        @Id
        @Column(name="id")
        private String id;

        @Column(name="login")
        private String login;

        @Column(name="password")
        private String password;

        @Column(name="first_name")
        private String first_name;

        @Column(name="last_name")
        private String last_name;

        public tes() {}

        // getters

        public String getId()
        {
            return id;
        }

        public String getLogin()
        {
            return login;
        }

        public String getPassword()
        {
            return password;
        }

        public String getFirst_name()
        {
            return first_name;
        }

        public String getLast_name()
        {
            return last_name;
        }

        // setters

        public void setid(String id)
        {
            this.id = id;
        }

        public void setLogin(String login)
        {
            this.login = login;
        }

        public void setPassword(String password)
        {
            this.password = password;
        }

        public void setFirst_name(String first_name)
        {
            this.first_name = first_name;
        }

        public void setLast_name(String last_name){

            this.last_name = last_name;

        }
    }