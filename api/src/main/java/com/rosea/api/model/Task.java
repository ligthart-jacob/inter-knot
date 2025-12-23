package com.rosea.api.model;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.List;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "task_type")
@Entity
public abstract class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne
    private Task parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Task> children;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Instant created;

    @Temporal(TemporalType.TIMESTAMP)
    private Instant updated;

    @PrePersist
    public void onCreate() {
        created = updated = Instant.now();
    }

    @PreUpdate
    public void onUpdate() {
        updated = Instant.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Task getParent() {
        return parent;
    }

    public void setParent(Task parent) {
        this.parent = parent;
    }

    public List<Task> getChildren() {
        return children;
    }

    public void setChildren(List<Task> children) {
        this.children = children;
    }

    public Instant getCreated() {
        return created;
    }

    public Instant getUpdated() {
        return updated;
    }

    public abstract Task complete(Instant date);
}
