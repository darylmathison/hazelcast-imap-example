/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.darylmathison.hazelcast.imap.data;

import java.io.Serializable;

/**
 *
 * @author Daryl
 */
public class Person implements Serializable {
    private final Name name;

    public Person(String first, String last) {
        name = new Name(first, last);
    }

    public Name getName() {
        return name;
    }

    public static class Name implements Serializable {
        private final String last;
        private final String first;


        private Name(String first, String last) {
            this.first = first;
            this.last = last;
        }

        public String getLast() {
            return last;
        }

        public String getFirst() {
            return first;
        }
    }
}
