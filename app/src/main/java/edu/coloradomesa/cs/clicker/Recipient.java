package edu.coloradomesa.cs.clicker;

/**
 * Created by wmacevoy on 9/15/16.
 */

public class Recipient<T> {
    T value;
    void setValue(T _value) { value=_value; }
    T getValue() { return _value; }
}
