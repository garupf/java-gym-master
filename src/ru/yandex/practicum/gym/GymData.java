package org.example;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GymData {
    Map<String, Coach> coaches = new HashMap<>();

    Map<String, Group> groups = new HashMap<>();

    public GymData() {
        initCoaches();
        initGroups();
    }

    private void initCoaches() {
        coaches.put("Шмотков Владимир Владимирович", new Coach("Шмотков", "Владимир", "Владимирович"));
        coaches.put("Семёнов Василий Константинович", new Coach("Семёнов", "Василий", "Константинович"));
        coaches.put("Тихомиров Александр Евгеньевич", new Coach("Тихомиров", "Александр", "Евгеньевич"));
        coaches.put("Беляев Евгений Викторович", new Coach("Беляев", "Евгений", "Викторович"));
        coaches.put("Морев Егор Владиславович", new Coach("Морев", "Егор", "Владиславович"));
        coaches.put("Уксусов Николай Алексеевич", new Coach("Уксусов", "Николай", "Алексеевич"));
        coaches.put("Смирнов Никита Антонович", new Coach("Смирнов", "Никита", "Антонович"));
        coaches.put("Миролюбов Юрий Борисович", new Coach("Миролюбов", "Юрий", "Борисович"));
        coaches.put("Топрова Анастасия Сергеевна", new Coach("Топрова", "Анастасия", "Сергеевна"));
        coaches.put("Страшная Анна Семёновна", new Coach("Страшная", "Анна", "Семёновна"));
        coaches.put("Веселов Степан Андреевич", new Coach("Веселов", "Степан", "Андреевич"));
        coaches.put("Волкова Галина Юрьевна", new Coach("Волкова", "Галина", "Юрьевна"));

    }

    public Coach getCoachByFullName(String fullName) {
        return coaches.get(fullName);
    }

    public Collection<Coach> getAllCoaches() {
        return coaches.values();
    }

    private void initGroups() {
        groups.put("гимнастика дети 9-10", new Group("гимнастика дети 8-10", Age.CHILD, 60));
        groups.put("гимнастика дети 11-12", new Group("гимнастика дети 11-12", Age.CHILD, 60));
        groups.put("бассейн взрослые", new Group("бассейн взрослые", Age.ADULT, 90));
        groups.put("каратэ взрослые", new Group("каратэ взрослые", Age.ADULT, 90));
        groups.put("футбол взрослые", new Group("футбол взрослые", Age.ADULT, 90));
        groups.put("волейбол взрослые", new Group("волейбол взрослые", Age.ADULT, 90));
        groups.put("гимнастика дети 7-8", new Group("гимнастика дети 7-8", Age.CHILD, 60));
        groups.put("дзюдо взрослые", new Group("дзюдо взрослые", Age.ADULT, 90));
        groups.put("йога взрослые", new Group("йога взрослые", Age.ADULT, 90));
        groups.put("пилатес взрослые", new Group("пилатес взрослые", Age.ADULT, 90));

    }

    public Group getGroupByName(String groupName) {
        return groups.get(groupName);
    }

    public Collection<Group> getAllGroups() {
        return groups.values();
    }

}
