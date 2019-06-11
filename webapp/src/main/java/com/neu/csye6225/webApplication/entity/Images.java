package com.neu.csye6225.webApplication.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name= "images")
public class Images {
    @Id
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "bookId")
    private Long bookId;

    @NotNull
    @Column(name = "url")
    private String url;

    @NotNull
    @Column(name = "physical_path")
    private String physicalPath;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPhysicalPath() {
        return physicalPath;
    }

    public void setPhysicalPath(String physicalPath) {
        this.physicalPath = physicalPath;
    }
}