package com.demo.rentortopedic.model.custom;

import com.demo.rentortopedic.model.Ortopedic;

public class CountOrtopedic {
    private Long total;
    private Ortopedic ortopedic;

    public CountOrtopedic(Long total, Ortopedic ortopedic) {
        this.total = total;
        this.ortopedic = ortopedic;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Ortopedic getOrtopedic() {
        return ortopedic;
    }

    public void setOrtopedic(Ortopedic ortopedic) {
        this.ortopedic = ortopedic;
    }
}
