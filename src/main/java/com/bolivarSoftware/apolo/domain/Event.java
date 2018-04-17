package com.bolivarSoftware.apolo.domain;

import com.bolivarSoftware.apolo.beans.UtilDate;

import javax.persistence.*;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Damian Saez on 20/3/2018.
 */
@Table(name = "EVENTOS_DE_AGENDA")
@Entity
public class Event {

    @Id
    @Column(name = "EVE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "EVE_TITULO")
    private String title;

    @Column(name = "EVE_INICIO")
    private Date inicio;

    @Column(name = "EVE_FIN")
    private Date fin;

    @Transient
    private boolean allDay;

    @Transient
    private String start;

    @Transient
    private String end;

    @Transient
    private String url;

    @Transient
    private String className;

    @Transient
    private boolean editable;

    @Transient
    private boolean startEditable;

    @Transient
    private boolean durationEditable;

    @Transient
    private boolean resourceEditable;

    @Transient
    private String rendering;

    @Transient
    private boolean overlap;

    @Transient
    private String constraint;

    @Transient
    private String source;

    @Transient
    private String color;

    @Transient
    private String backgroundColor;

    @Transient
    private String borderColor;

    @Transient
    private String textColor;

    public Event(String titulo, String inicio, String fin) throws ParseException {
        title = titulo;
        this.inicio = UtilDate.convertToDate(inicio);
        this.fin = UtilDate.convertToDate(fin);
    }


    public Event() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAllDay() {
        return allDay;
    }

    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }

    public String getRendering() {
        return rendering;
    }

    public void setRendering(String rendering) {
        this.rendering = rendering;
    }

    public String getConstraint() {
        return constraint;
    }

    public void setConstraint(String constraint) {
        this.constraint = constraint;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public boolean isStartEditable() {
        return startEditable;
    }

    public void setStartEditable(boolean startEditable) {
        this.startEditable = startEditable;
    }

    public boolean isDurationEditable() {
        return durationEditable;
    }

    public void setDurationEditable(boolean durationEditable) {
        this.durationEditable = durationEditable;
    }

    public boolean isResourceEditable() {
        return resourceEditable;
    }

    public void setResourceEditable(boolean resourceEditable) {
        this.resourceEditable = resourceEditable;
    }

    public boolean isOverlap() {
        return overlap;
    }

    public void setOverlap(boolean overlap) {
        this.overlap = overlap;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public String getStart() {
        return UtilDate.formatterDate.format(inicio);
    }

//    public String getEnd() {
//        return UtilDate.formatterDate.format(end);
//    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

}
