package lesson3.streams.objects.stream;

import java.io.*;
import java.util.Objects;

public class Person extends Human /*implements Externalizable*/ {

    public /*transient*/ String name;
    public Person friend;

//    public Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", test='" + test + '\'' +
                ", name='" + name + '\'' +
                ", friend=" + friend +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(friend, person.friend);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, friend);
    }

//        @Override
//    public void writeExternal(ObjectOutput out) throws IOException {
//        out.writeUTF(name);
//        out.writeObject(friend);
//        out.writeInt(33);
//    }
//
//        @Override
//    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
//        name = in.readUTF();
//        friend = (Person) in.readObject();
//        age = in.readInt();
//    }
//
//    // without serializable
//    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//        name = in.readUTF();
//        friend = (Person) in.readObject();
////        age = in.readInt();
//    }
//
//    // without serializable
//    private void writeObject(ObjectOutputStream out) throws IOException {
//        out.writeUTF(name);
//        out.writeObject(friend);
////        out.writeInt(33);
//    }
}
