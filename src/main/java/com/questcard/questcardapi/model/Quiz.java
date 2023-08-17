package com.questcard.questcardapi.model;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizId;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private AppUser owner;

    @ManyToMany
    @JoinTable(
            name = "quiz_managers",
            joinColumns = @JoinColumn(name = "quiz_id"),
            inverseJoinColumns = @JoinColumn(name = "manager_id")
    )
    private List<AppUser> managers;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfCreation;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<Comment> comments;

    private String description;
    private int reputation;
    private String photoUrl;
    private int gamesPlayed;

    private boolean isForAdult;

    @ManyToOne
    @JoinColumn(name = "category_id") // Nazwa kolumny klucza obcego w tabeli Quiz
    private Category category; // Relacja z encją Category

    @ManyToMany
    @JoinTable(
            name = "quiz_tag",
            joinColumns = @JoinColumn(name = "quiz_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags; // Relacja wiele-do-wielu z encją Tag

    public Quiz() {
    }

    public Quiz(AppUser owner, List<AppUser> managers, Type type, String name, Date dateOfCreation,
                String description, int reputation, String photoUrl, int gamesPlayed, boolean isForAdult,
                Category category, List<Tag> tags) {
        this.owner = owner;
        this.managers = managers;
        this.type = type;
        this.name = name;
        this.dateOfCreation = dateOfCreation;
        this.description = description;
        this.reputation = reputation;
        this.photoUrl = photoUrl;
        this.gamesPlayed = gamesPlayed;
        this.isForAdult = isForAdult;
        this.category = category;
        this.tags = tags;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public AppUser getOwner() {
        return owner;
    }

    public void setOwner(AppUser owner) {
        this.owner = owner;
    }

    public List<AppUser> getManagers() {
        return managers;
    }

    public void setManagers(List<AppUser> managers) {
        this.managers = managers;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }


    public boolean getIsForAdult() { return isForAdult; }
    public void setIsForAdult(boolean isForAdult) { this.isForAdult = isForAdult; }



    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
