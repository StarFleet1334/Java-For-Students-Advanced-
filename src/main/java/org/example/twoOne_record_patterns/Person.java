package org.example.twoOne_record_patterns;

// Component List and name() and age() accessors
public record Person(String name,Integer age) { }
enum Ability{WEAK,AVERAGE,STRONG}

record Player(Person person,Ability ability){}
record Doubles(Player player1,Player player2) {}

record Pair<T> (T x,T y){}