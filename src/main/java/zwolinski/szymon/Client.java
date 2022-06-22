package zwolinski.szymon;

import java.util.Objects;

public class Client {
    private String name;
    private String surname;
    private String email;
    private long identificationNumber;

    public Client(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", identificationNumber=" + identificationNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return identificationNumber == client.identificationNumber && Objects.equals(name, client.name) && Objects.equals(surname, client.surname) && Objects.equals(email, client.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, email, identificationNumber);
    }
}
