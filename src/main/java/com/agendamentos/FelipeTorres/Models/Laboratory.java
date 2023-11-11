package com.agendamentos.FelipeTorres.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;

@Entity
public class Laboratory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private int qtyComputers;

    /**
     * Getter for id Laboratory.
     *
     * @return int
     */
    public int getId()
    {
        return id;
    }

    /**
     * Setter for id Laboratory.
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * Getter for name Laboratory.
     *
     * @return String
     */
    public String getName()
    {
        return name;
    }

    /**
     * Setter for name Laboratory.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Getter for qtyComputers Laboratory.
     *
     * @return int
     */
    public int getQtyComputers()
    {
        return qtyComputers;
    }

    /**
     * Setter for id Laboratory.
     */
    public void setQtyComputers(int qtyComputers)
    {
        this.qtyComputers = qtyComputers;
    }
}
