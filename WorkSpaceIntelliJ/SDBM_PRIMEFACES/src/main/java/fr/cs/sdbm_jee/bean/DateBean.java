package fr.cs.sdbm_jee.bean;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.Future;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

@Named
@ViewScoped
public class DateBean implements Serializable {

    private Date date;

    private Date dateTimeDe;
    private Date dateTimeMillis;
    private List<Date> multi;
    private List<Date> range;
    private List<Date> invalidDates;
    private List<Integer> invalidDays;
    private Date minDate;
    private Date maxDate;
    private Date minTime;
    private Date maxTime;
    private Date minDateTime;
    private Date maxDateTime;

    @PostConstruct
    public void init() {
        invalidDates = new ArrayList<>();
        Date today = new Date();
        invalidDates.add(today);
        long oneDay = 24 * 60 * 60 * 1000;
        for (int i = 0; i < 5; i++) {
            invalidDates.add(new Date(invalidDates.get(i).getTime() + oneDay));
        }

        invalidDays = new ArrayList<>();
        invalidDays.add(0);
        /* the first day of week is disabled */
        invalidDays.add(3);

        minDate = new Date(today.getTime() - (365 * oneDay));
        maxDate = new Date(today.getTime() + (365 * oneDay));

        Calendar tmp = Calendar.getInstance();
        tmp.set(Calendar.HOUR_OF_DAY, 9);
        tmp.set(Calendar.MINUTE, 0);
        tmp.set(Calendar.SECOND, 0);
        tmp.set(Calendar.MILLISECOND, 0);
        minTime = tmp.getTime();

        tmp = Calendar.getInstance();
        tmp.set(Calendar.HOUR_OF_DAY, 17);
        tmp.set(Calendar.MINUTE, 0);
        tmp.set(Calendar.SECOND, 0);
        tmp.set(Calendar.MILLISECOND, 0);
        maxTime = tmp.getTime();

        minDateTime = new Date(today.getTime() - (7 * oneDay));
        maxDateTime = new Date(today.getTime() + (7 * oneDay));


        dateTimeMillis = GregorianCalendar.getInstance().getTime();
    }

    public void onDateSelect(SelectEvent<Date> event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }

    public void click() {
        PrimeFaces.current().ajax().update("form:display");
        PrimeFaces.current().executeScript("PF('dlg').show()");
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public List<Date> getMulti() {
        return multi;
    }

    public void setMulti(List<Date> multi) {
        this.multi = multi;
    }

    public List<Date> getRange() {
        return range;
    }

    public void setRange(List<Date> range) {
        this.range = range;
    }

    public List<Date> getInvalidDates() {
        return invalidDates;
    }

    public void setInvalidDates(List<Date> invalidDates) {
        this.invalidDates = invalidDates;
    }

    public List<Integer> getInvalidDays() {
        return invalidDays;
    }

    public void setInvalidDays(List<Integer> invalidDays) {
        this.invalidDays = invalidDays;
    }

    public Date getMinDate() {
        return minDate;
    }

    public void setMinDate(Date minDate) {
        this.minDate = minDate;
    }

    public Date getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(Date maxDate) {
        this.maxDate = maxDate;
    }

    public Date getDateTimeDe() {
        return dateTimeDe;
    }

    public void setDateTimeDe(Date dateTimeDe) {
        this.dateTimeDe = dateTimeDe;
    }

    public Date getDateTimeMillis() {
        return dateTimeMillis;
    }

    public void setDateTimeMillis(Date dateTimeMillis) {
        this.dateTimeMillis = dateTimeMillis;
    }


    public Date getMinTime() {
        return minTime;
    }

    public void setMinTime(Date minTime) {
        this.minTime = minTime;
    }

    public Date getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(Date maxTime) {
        this.maxTime = maxTime;
    }

    public Date getMinDateTime() {
        return minDateTime;
    }

    public void setMinDateTime(Date minDateTime) {
        this.minDateTime = minDateTime;
    }

    public Date getMaxDateTime() {
        return maxDateTime;
    }

    public void setMaxDateTime(Date maxDateTime) {
        this.maxDateTime = maxDateTime;
    }
}