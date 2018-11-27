package com.pwfz.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "navi_item", schema = "j2ee_design")
public class NaviItem {
    private int id;
    private ModuleItem moduleItem;
    private NaviItem father;
    private String linkPath;
    private List<NaviItem> sons;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "module_id")
    public ModuleItem getModuleItem() {
        return moduleItem;
    }

    public void setModuleItem(ModuleItem moduleItem) {
        this.moduleItem = moduleItem;
    }

    @ManyToOne
    @JoinColumn(name = "father_id")
    public NaviItem getFather() {
        return father;
    }

    public void setFather(NaviItem father) {
        this.father = father;
    }

    @Basic
    @Column(name = "link_path")
    public String getLinkPath() {
        return linkPath;
    }

    public void setLinkPath(String linkPath) {
        this.linkPath = linkPath;
    }

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "father"
    )
    public List<NaviItem> getSons() {
        return sons;
    }

    public void setSons(List<NaviItem> sons) {
        this.sons = sons;
    }
}
