class Outer {
    private int x = 10;

    static class StaticNested {
        void show() { System.out.println("Static nested can't access x directly"); }
    }

    class Inner {
        void show() { System.out.println("Inner sees x = " + x); }
    }

    public static void main(String[] args) {
        Outer.StaticNested sn = new Outer.StaticNested();
        sn.show();

        Outer o = new Outer();
        Outer.Inner in = o.new Inner();
        in.show();
    }
}
