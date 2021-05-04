package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * The class for Entry - Hibernate.
 */
@Entity(name = "Entry")
@Table(name = "entry")
public class Entry {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    /**
     * Instantiates a new Entry.
     */
    public Entry() {
    }

    /**
     * Instantiates a new Entry.
     *
     * @param entryName  the entry name
     * @param entryType  the entry type
     * @param value      the value
     * @param categoryId the category id
     * @param userId     the user id
     */
    public Entry(String entryName, String entryType, Double value, Category categoryId, User userId) {
        this.entryName = entryName;
        this.entryType = entryType;
        this.value = value;
        this.categoryId = categoryId;
        this.userId = userId;
    }

    /**
     * Instantiates a new Entry.
     *
     * @param id         the id
     * @param date       the date
     * @param entryName  the entry name
     * @param entryType  the entry type
     * @param value      the value
     * @param categoryId the category id
     * @param userId     the user id
     */
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

    /**
     * Instantiates a new Entry.
     *
     * @param date       the date
     * @param entryName  the entry name
     * @param entryType  the entry type
     * @param value      the value
     * @param categoryId the category id
     */
    public Entry(String date, String entryName, String entryType, Double value, String categoryId) {
    }

    /**
     * Instantiates a new Entry.
     *
     * @param date       the date
     * @param entryName  the entry name
     * @param entryType  the entry type
     * @param value      the value
     * @param categoryId the category id
     * @param userId     the user id
     */
    public Entry(LocalDate date, String entryName, String entryType, Double value, Category categoryId, User userId) {
        this.date = date;
        this.entryName = entryName;
        this.entryType = entryType;
        this.value = value;
        this.categoryId = categoryId;
        this.userId = userId;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Gets entry name.
     *
     * @return the entry name
     */
    public String getEntryName() {
        return entryName;
    }

    /**
     * Sets entry name.
     *
     * @param entryName the entry name
     */
    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    /**
     * Gets entry type.
     *
     * @return the entry type
     */
    public String getEntryType() {
        return entryType;
    }

    /**
     * Sets entry type.
     *
     * @param entryType the entry type
     */
    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public Double getValue() {
        return value;
    }

    /**
     * Sets value.
     *
     * @param value the value
     */
    public void setValue(Double value) {
        this.value = value;
    }

    /**
     * Gets category id.
     *
     * @return the category id
     */
    public Category getCategoryId() {
        return categoryId;
    }

    /**
     * Sets category id.
     *
     * @param categoryId the category id
     */
    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public User getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
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
