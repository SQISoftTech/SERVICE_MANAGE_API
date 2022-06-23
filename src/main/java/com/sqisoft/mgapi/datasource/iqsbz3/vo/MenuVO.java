package com.sqisoft.mgapi.datasource.iqsbz3.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@IdClass(MenuPK.class)
@Table(schema = "iqsbz3", name = "menu")
public class MenuVO {
    @Id
    @Column(name = "menu_seq")
    private int menuSeq;

    @Id
    @Column(name = "menu_category_index")
    private int menuIndex;

    @Column(name = "menu_category_name")
    private String menuCatName;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_url")
    private String menuUrl;

}
