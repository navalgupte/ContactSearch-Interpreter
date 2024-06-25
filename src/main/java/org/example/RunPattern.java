package org.example;

public class RunPattern {
    public static void main(String[] args) {
        System.out.println("Example showing use of Interpreter Pattern");
        System.out.println("---- ---- ---- ---- ----");
        ContactList candidates = makeContactList();
        Context ctx = new Context();

        System.out.println("Contents of ContactList:");
        System.out.println(candidates);
        System.out.println("---- ---- ---- ---- ----");
        Contact testContact = new ContactImpl();
        VariableExpression varLName = new VariableExpression(testContact, "getLastName");
        ConstantExpression constLName = new ConstantExpression("u");
        ContainsExpression eqLName = new ContainsExpression(varLName, constLName);
        System.out.println("Search Contents on ContactList - Contacts with 'u' in Last Name:");
        Object result = candidates.getContactsMatchingExpression(eqLName, ctx, testContact);
        System.out.println(result);
        System.out.println("---- ---- ---- ---- ----");
        VariableExpression varTitle = new VariableExpression(testContact, "getTitle");
        ConstantExpression constTitle = new ConstantExpression("LT");
        EqualsExpression eqTitle = new EqualsExpression(varTitle, constTitle);
        System.out.println("Search Contents on ContactList - All 'LT' Personnel:");
        result = candidates.getContactsMatchingExpression(eqTitle, ctx, testContact);
        System.out.println(result);
        System.out.println("---- ---- ---- ---- ----");
        VariableExpression varLastName = new VariableExpression(testContact, "getLastName");
        ConstantExpression constLastName = new ConstantExpression("S");
        ContainsExpression cLName = new ContainsExpression(varLastName, constLastName);
        AndExpression andExpr = new AndExpression(eqTitle, cLName);
        System.out.println("Search Contents on ContactList - All 'LT' Personnel with 'S' in Last Name:");
        result = candidates.getContactsMatchingExpression(andExpr, ctx, testContact);
        System.out.println(result);
        System.out.println("---- ---- ---- ---- ----");

    }

    private static ContactList makeContactList() {
        ContactList returnList = new ContactList();

        returnList.addContact(new ContactImpl("James", "Kirk", "Captain", "USS Enterprise"));
        returnList.addContact(new ContactImpl("Mr.", "Spock", "Science Officer", "USS Enterprise"));
        returnList.addContact(new ContactImpl("LT", "Uhura", "LT", "USS Enterprise"));
        returnList.addContact(new ContactImpl("LT", "Sulu", "LT", "USS Enterprise"));
        returnList.addContact(new ContactImpl("Ensign", "Checkhov", "Ensign", "USS Enterprise"));
        returnList.addContact(new ContactImpl("Dr.", "McCoy", "Ship's Doctor", "USS Enterprise"));
        returnList.addContact(new ContactImpl("Montgomery", "Scott", "LT", "USS Enterprise"));

        return returnList;
    }
}