package com.dmp.devtest.service.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class Job implements Serializable {
    String id;
    String type;
    String url;
    String created_at;
    String company;
    String company_url;
    String location;
    String title;
    String description;
    String how_to_apply;
    String company_logo;
}
