package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.tag.Tag;

/**
 *Represents a Company in the address book.
 *Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Company {

    // Identity fields
    private final Name name;
    private final Phone phone;
    private final Email email;
    private final Salary salary;
    private final Occupation occupation;
    private final Relationship relationship;

    // Data fields
    private final Address address;
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Company(Name name, Phone phone, Email email, Address address,
                  Salary salary, Occupation occupation, Relationship relationship, Set<Tag> tags) {
        requireAllNonNull(name, phone, email, address, salary, occupation, relationship, tags);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.salary = salary;
        this.occupation = occupation;
        this.relationship = relationship;
        this.address = address;
        this.tags.addAll(tags);
    }

    public Company(Name name, Phone phone, Email email, Address address, Set<Tag> tags) {
        requireAllNonNull(name, phone, email, address, tags);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.tags.addAll(tags);
        this.salary = new Salary("1");
        this.occupation = new Occupation("");
        this.relationship = new Relationship("");
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public Salary getSalary() {
        return salary;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public Relationship getRelationship() {
        return relationship;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both companies of the same name have at least one other identity field that is the same.
     * This defines a weaker notion of equality between two companies.
     */
    public boolean isSameCompany(Company otherCompany) {

        if (otherCompany == this) {
            return true;
        }

        return otherCompany != null
                && otherCompany.getName().equals(getName())
                && (otherCompany.getPhone().equals(getPhone())
                || otherCompany.getEmail().equals(getEmail())
                || otherCompany.getSalary().equals(getSalary())
                || otherCompany.getOccupation().equals(getOccupation())
                || otherCompany.getRelationship().equals(getRelationship()));
    }

    /**
     * Returns true if both companies have the same identity and data fields.
     * This defines a stronger notion of equality between two companiess.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Company)) {
            return false;
        }

        Company otherCompany = (Company) other;
        return otherCompany.getName().equals(getName())
                && otherCompany.getPhone().equals(getPhone())
                && otherCompany.getEmail().equals(getEmail())
                && otherCompany.getAddress().equals(getAddress())
                && otherCompany.getSalary().equals(getSalary())
                && otherCompany.getOccupation().equals(getOccupation())
                && otherCompany.getRelationship().equals(getRelationship())
                && otherCompany.getTags().equals(getTags());

    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, address, salary, occupation, relationship, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append(" Phone: ")
                .append(getPhone())
                .append(" Email: ")
                .append(getEmail())
                .append(" Address: ")
                .append(getAddress())
                .append(" Salary: ")
                .append(getSalary())
                .append(" Occupation: ")
                .append(getOccupation())
                .append(" Relationship: ")
                .append(getRelationship())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        return builder.toString();
    }

}
