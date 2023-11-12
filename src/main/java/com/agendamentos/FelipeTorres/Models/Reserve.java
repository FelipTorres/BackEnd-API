package com.agendamentos.FelipeTorres.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reserve {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String email;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "laboratory_id", nullable = false)
    private Laboratory laboratory;

    /**
     * Getter for id Reserve.
     *
     * @return int
     */
    public int getId()
    {
        return id;
    }

    /**
     * Setter for id Reserve.
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * Getter for email Reserve.
     *
     * @return String
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Setter for email Reserve.
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * Getter for date Reserve.
     *
     * @return Date
     */
    public Date getDate()
    {
        return date;
    }

    /**
     * Setter for date Reserve.
     */
    public void setDate(Date date)
    {
        this.date = date;
    }

    /**
     * Getter for relation Laboratory in Reserve.
     *
     * @return Laboratory
     */
    public Laboratory getLaboratory()
    {
        return laboratory;
    }

    /**
     * Setter for relation Laboratory in Reserve.
     */
    public void setLaboratory(Laboratory laboratory)
    {
        this.laboratory = laboratory;
    }
}
