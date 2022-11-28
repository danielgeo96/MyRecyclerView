package com.example.myrecyclerview;

public class HeroData {
    private String name;
    private String description;
    private int img;
    private int _id;

    public HeroData(String name, String description, int id_, int image) {
        this.name = name;
        this.description = description;
        this._id = id_;
        this.img = image;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getImg() {
        return img;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
}
