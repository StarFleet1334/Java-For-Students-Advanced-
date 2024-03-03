package org.example.interface_complect.rule_eight;

public interface Animal {
}
interface Predator extends Animal {}

interface Herbivore extends Animal {}

interface Human extends Predator,Herbivore {}
