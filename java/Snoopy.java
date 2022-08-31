package test.java;

interface Comic<C>{
    void draw(C c);
}

class ComicClass<C> implements Comic<C>{
    public void draw(C c){
        System.out.println(c);
    }
}

class Class<C> implements Comic<C>{
    public void draw(C c){
        System.out.println(c);
    }
}