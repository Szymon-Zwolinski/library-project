package zwolinski.szymon;

import java.util.Objects;

public class Client {
    private String name;
    private String surname;
    private long identificationNumber;

    public Client(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", identificationNumber=" + identificationNumber +
                '}';
    }
}
