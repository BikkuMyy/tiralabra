package graph;

import datastructures.MyList;
import java.util.*;

/**
 * Edustaa sukulaisuusverkon solmuja eli henkilöitä.
 */
public class Person {

    private List<Relation> relations;
    private List<Person> children;
    private List<Person> parents;
    private String name;

    public Person(String name) {
        this.name = name;
        this.relations = new MyList<>();
        this.children = new MyList<>();
        this.parents = new MyList<>();
    }

    /**
     * Luo uuden kumppanuuden parametrina annettuun henkilöön.
     *
     * @param   person    kumppani
     */
    public void addRelation(Person person) {
        this.relations.add(new Relation(this, person));
    }

    /**
     * Lisää parametrina annetun henkilön kyseisen henkilön lapseksi.
     *
     * @param   person  lapsi
     */
    public void addChild(Person person) {
        this.children.add(person);
    }

    /**
     * Lisää parametrina annetun henkilön kyseisen henkilön vanhemmaksi.
     *
     * @param   person    vanhempi
     */
    public void addParent(Person person) {
        this.parents.add(person);
    }

    public String getName() {
        return this.name;
    }

    /**
     * Palauttaa listan kyseisen henkilön kumppaneista.
     *
     * @return partners
     */
    public List<Person> getPartners() {
        List<Person> partners = new MyList<>();
        for (Relation relation : this.relations) {
            partners.add(relation.getPartner());
        }
        return partners;
    }

    public List<Person> getChildren() {
        return this.children;
    }

    public List<Person> getParents() {
        return this.parents;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n" + this.name);
        sb.append("\n  Kumppanit: ");

        for (Person partner : getPartners()) {
            sb.append(partner.getName() + " ");
        }
        sb.append("\n  Lapset: ");
        for (Person child : this.children) {
            sb.append(child.getName() + " ");
        }
        sb.append("\n  Vanhemmat: ");
        for (Person parent : this.parents) {
            sb.append(parent.getName() + " ");
        }

        return sb.toString();
    }

}
