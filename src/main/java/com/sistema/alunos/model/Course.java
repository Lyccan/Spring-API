package com.sistema.alunos.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.text.SimpleDateFormat;
import java.util.Date;

@Document(collection = "User")
public class Course {

    @MongoId
    private ObjectId _id;
    private String course;
    private String institution;
    private int workload;
    private long creationDate;


    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(long creationDate) {
        this.creationDate = creationDate;
    }

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(String _id) {
        this._id = new ObjectId(_id);
    }
    public Course(String course, String institution, int workload) {

        this._id = new ObjectId();
        this.course = course;
        this.institution = institution;
        this.workload = workload;
        this.creationDate = new Date().getTime();
    }

    @Override
    public String toString() {
        Date convertedCreationDate = new Date(creationDate);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/year HH:mm:ss");
        return _id.toHexString() + institution + course + workload + sdf.format(convertedCreationDate);
    }
}
