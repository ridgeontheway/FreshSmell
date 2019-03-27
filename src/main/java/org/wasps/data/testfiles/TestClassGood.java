package org.wasps.data.testfiles;

import java.util.List;

public class TestClassGood {

    private int testInt;
    private String testString;
    private final String testConstString;
    private List<Object> dependency;

    public TestClassGood(List<Object> dependencyInjection) {
        this.testConstString = "Magic strings are bad";
        this.dependency = dependencyInjection;
    }

    public int getTestInt() {
        return testInt;
    }

    public void setTestInt(int testInt) {
        this.testInt = testInt;
    }

    public String getTestString() {
        return testString;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }

    public String getTestConstString() {
        return testConstString;
    }

    // Methods
    public void setSomethingFromString() {
        String tester = testConstString;
    }
    public void addToDependencyList(Object object) { dependency.add(object); }
}
