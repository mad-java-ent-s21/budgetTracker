package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Entry")
@Table(name = "entry")
public class Entry {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    public Entry() {
    }

    public Entry(String entryName, String entryType, Double value, Category categoryId, User userId) {
        this.entryName = entryName;
        this.entryType = entryType;
        this.value = value;
        this.categoryId = categoryId;
        this.userId = userId;
    }

    public Entry(int id, LocalDate date, String entryName, String entryType, Double value, Category categoryId, User userId) {
        this.id = id;
        this.date = date;
        this.entryName = entryName;
        this.entryType = entryType;
        this.value = value;
        this.categoryId = categoryId;
        this.userId = userId;
    }

    @Column
    private LocalDate date;

    @Column(name = "entry_name")
    private String entryName;

    @Column(name = "entry_type")
    private String entryType;

    private Double value;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category categoryId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userId;

    public Entry(String date, String entryName, String entryType, Double value, String categoryId) {
    }

    public Entry(LocalDate date, String entryName, String entryType, Double value, Category categoryId, User userId) {
        this.date = date;
        this.entryName = entryName;
        this.entryType = entryType;
        this.value = value;
        this.categoryId = categoryId;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public String getEntryType() {
        return entryType;
    }

    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", date=" + date +
                ", entryName='" + entryName + '\'' +
                ", entryType='" + entryType + '\'' +
                ", value=" + value +
                ", categoryId=" + categoryId +
                ", userId=" + userId +
                '}';
    }
}
