package dk.cphbusiness.template;


public class Pet {
    private String name;
    private Person owner;

    public Pet(String name, Person owner) {
        this.name = name;
        setOwner(owner);
        }

    public String getName() { return name; }

    public Person getOwner() { return owner; }

    public void setOwner(Person value) {
        owner = value;
        owner.getPets().add(this);
        }
}
