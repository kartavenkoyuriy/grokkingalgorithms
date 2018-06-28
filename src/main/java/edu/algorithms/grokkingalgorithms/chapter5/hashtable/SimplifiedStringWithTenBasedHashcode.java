package edu.algorithms.grokkingalgorithms.chapter5.hashtable;

import edu.algorithms.grokkingalgorithms.chapter5.hashtable.hashcodebased.TenBased;

import java.util.Objects;

class SimplifiedStringWithTenBasedHashcode implements TenBased {
    private String value;

    public SimplifiedStringWithTenBasedHashcode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimplifiedStringWithTenBasedHashcode that = (SimplifiedStringWithTenBasedHashcode) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value) % 10;
    }
}
