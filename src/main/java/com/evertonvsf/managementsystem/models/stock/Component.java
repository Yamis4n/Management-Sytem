package com.evertonvsf.managementsystem.models.stock;

import java.util.Objects;

public class Component {
    private String description;
    private ComponentType type;

    Component(String description, ComponentType type){
        this.description = description;
        this.type = type;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ComponentType getType() {
        return type;
    }

    public void setType(ComponentType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Component component = (Component) o;
        return Objects.equals(description.toLowerCase(), component.description.toLowerCase()) && type == component.type;
    }

}
