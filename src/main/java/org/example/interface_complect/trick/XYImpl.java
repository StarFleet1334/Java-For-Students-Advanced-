package org.example.interface_complect.trick;

public class XYImpl implements X,Y{
    @Override
    public void foo() {

    }

    @Override
    public void bar() {
        X.super.bar();
        Y.super.bar();
    }

    @Override
    public void doo() {

    }

    public static void main(String[] args) {
        XYImpl xy = new XYImpl();
        xy.bar();
    }
}
