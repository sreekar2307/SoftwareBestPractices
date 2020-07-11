package com.designPatterns.Singleton;

import java.io.*;


// enums are inherently singletons the only problem is lazy initialization is not possible
public enum Singleton {
    instance(6);
    private final int value;

    Singleton(int value){
        this.value = value;
    }

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Singleton instance1 = Singleton.instance;
        ObjectOutput out
                = new ObjectOutputStream(new FileOutputStream("file"));
        out.writeObject(instance1);
        out.close();
        ObjectInput in
                = new ObjectInputStream(new FileInputStream("file"));

        Singleton instance2 = (Singleton) in.readObject();
        in.close();

        System.out.println("instance1 hashCode:- "
                + instance1.hashCode());
        System.out.println("instance2 hashCode:- "
                + instance2.hashCode());

        // enums have no clone support and even serialization will return the same instance once again
    }
}
