package org.example.wrappers;

import java.util.Objects;

public class ProjectPrices {
    private String id;
    private int price;

    public ProjectPrices(){
        id="";
        price=0;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                "price=" + price +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectPrices that = (ProjectPrices) o;
        return price == that.price && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price);
    }
}
