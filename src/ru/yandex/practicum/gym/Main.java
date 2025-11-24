package org.example;

public class Main {
    public static void main(String[] args) {

        GymData gymData = new GymData();

        Timetable timetable = new Timetable();

        initTimetable(gymData, timetable);
    }

    public static void initTimetable(GymData gymData, Timetable timetable) {
        TrainingSession session1 = new TrainingSession(gymData.getGroupByName("гимнастика дети 9-10"),
                gymData.getCoachByFullName("Шмотков Владимир Владимирович"), DayOfWeek.MONDAY, new TimeOfDay(10,0));
        timetable.addNewTrainingSession(session1);
        TrainingSession session2 = new TrainingSession(gymData.getGroupByName("гимнастика дети 11-12"),
                gymData.getCoachByFullName("Шмотков Владимир Владимирович"), DayOfWeek.MONDAY, new TimeOfDay(13,0));
        timetable.addNewTrainingSession(session2);
        TrainingSession session3 = new TrainingSession(gymData.getGroupByName("бассейн взрослые"),
                gymData.getCoachByFullName("Семёнов Василий Константинович"), DayOfWeek.MONDAY, new TimeOfDay(14,0));
        timetable.addNewTrainingSession(session3);

        TrainingSession session4 = new TrainingSession(gymData.getGroupByName("бассейн взрослые"),
                gymData.getCoachByFullName("Семёнов Василий Константинович"), DayOfWeek.TUESDAY, new TimeOfDay(12,0));
        timetable.addNewTrainingSession(session4);
        TrainingSession session5 = new TrainingSession(gymData.getGroupByName("каратэ взрослые"),
                gymData.getCoachByFullName("Шмотков Владимир Владимирович"), DayOfWeek.TUESDAY, new TimeOfDay(15,0));
        timetable.addNewTrainingSession(session5);

        TrainingSession session6 = new TrainingSession(gymData.getGroupByName("футбол взрослые"),
                gymData.getCoachByFullName("Тихомиров Александр Евгеньевич"), DayOfWeek.WEDNESDAY, new TimeOfDay(10,0));
        timetable.addNewTrainingSession(session6);
        TrainingSession session7 = new TrainingSession(gymData.getGroupByName("волейбол взрослые"),
                gymData.getCoachByFullName("Беляев Евгений Викторович"), DayOfWeek.WEDNESDAY, new TimeOfDay(12,0));
        timetable.addNewTrainingSession(session7);
        TrainingSession session8 = new TrainingSession(gymData.getGroupByName("гимнастика дети 7-8"),
                gymData.getCoachByFullName("Морев Егор Владиславович"), DayOfWeek.WEDNESDAY, new TimeOfDay(14,0));
        timetable.addNewTrainingSession(session8);

        TrainingSession session9 = new TrainingSession(gymData.getGroupByName("дзюдо взрослые"),
                gymData.getCoachByFullName("Уксусов Николай Алексеевич"), DayOfWeek.THURSDAY, new TimeOfDay(13,0));
        timetable.addNewTrainingSession(session9);
        TrainingSession session10 = new TrainingSession(gymData.getGroupByName("йога взрослые"),
                gymData.getCoachByFullName("Смирнов Никита Антонович"), DayOfWeek.THURSDAY, new TimeOfDay(15,0));
        timetable.addNewTrainingSession(session10);

        TrainingSession session11 = new TrainingSession(gymData.getGroupByName("пилатес взрослые"),
                gymData.getCoachByFullName("Миролюбов Юрий Борисович"), DayOfWeek.FRIDAY, new TimeOfDay(10,0));
        timetable.addNewTrainingSession(session11);
        TrainingSession session12 = new TrainingSession(gymData.getGroupByName("гимнастика дети 9-10"),
                gymData.getCoachByFullName("Топрова Анастасия Сергеевна"), DayOfWeek.FRIDAY, new TimeOfDay(12,0));
        timetable.addNewTrainingSession(session12);
        TrainingSession session13 = new TrainingSession(gymData.getGroupByName("гимнастика дети 11-12"),
                gymData.getCoachByFullName("Страшная Анна Семёновна"), DayOfWeek.FRIDAY, new TimeOfDay(14,0));
        timetable.addNewTrainingSession(session13);

        TrainingSession session14 = new TrainingSession(gymData.getGroupByName("бассейн взрослые"),
                gymData.getCoachByFullName("Веселов Степан Андреевич"), DayOfWeek.SATURDAY, new TimeOfDay(13,0));
        timetable.addNewTrainingSession(session14);
        TrainingSession session15 = new TrainingSession(gymData.getGroupByName("каратэ взрослые"),
                gymData.getCoachByFullName("Волкова Галина Юрьевна"), DayOfWeek.SATURDAY, new TimeOfDay(15,0));
        timetable.addNewTrainingSession(session15);

    }
}