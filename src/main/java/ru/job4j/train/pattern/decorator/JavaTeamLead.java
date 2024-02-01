package ru.job4j.train.pattern.decorator;

public class JavaTeamLead extends DeveloperDecorator {

    public JavaTeamLead(Developer developer) {
        super(developer);
    }

    public String sendWeekReport() {
        return " Send week report to customer.";
    }

    @Override
    public String makejob() {
        return super.makejob() + sendWeekReport();
    }
}