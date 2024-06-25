package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/*
    ContactList Class - Contains a series of Contacts
    Defines a method getContactsMatchingExpression that evaluates the Expression and
    returns an ArrayList
 */
public class ContactList implements Serializable {
    private ArrayList contacts = new ArrayList();

    public ArrayList getContacts() {
        return contacts;
    }
    public Contact[] getContactsAsArray() {
        return (Contact[]) (contacts.toArray(new Contact[1]));
    }

    public ArrayList getContactsMatchingExpression(Expression expr, Context ctx, Object key) {
        ArrayList results = new ArrayList();
        Iterator elements = contacts.iterator();
        while(elements.hasNext()) {
            Object currentElement = elements.next();
            ctx.addVariable(key, currentElement);
            expr.interpret(ctx);
            Object interpretResult = ctx.get(expr);
            if((interpretResult != null) && (interpretResult.equals(Boolean.TRUE))) {
                results.add(currentElement);
            }
        }
        return results;
    }

    public void setContacts(ArrayList contacts) {
        this.contacts = contacts;
    }

    public void addContact(Contact contact) {
        if(!contacts.contains(contact)) {
            contacts.add(contact);
        }
    }

    public void removeContact(Contact contact) {
        contacts.remove(contact);
    }

    public String toString() {
        return contacts.toString();
    }
}
