package com.zxf.entities;

import java.util.Objects;

/**
 * @Author: zhaoxiaofeng
 * @Description:
 * @Date: 2021/1/31 19:01
 */
public class Student {
    private String stuId;
    private String stuName;
    private String sex;

    public Student(String stuId, String stuName, String sex) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.sex = sex;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId='" + stuId + '\'' +
                ", stuName='" + stuName + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        //当type、color 内容都相等的时候，才返回true
        return Objects.equals(stuId, student.stuId) &&
                Objects.equals(stuName, student.stuName) &&
                Objects.equals(sex, student.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuId, stuName, sex);
    }
}
