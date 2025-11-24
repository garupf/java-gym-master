import org.example.*;
import org.junit.jupiter.api.Test;
import org.example.Timetable;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TimetableTest {

    @Test
    void testGetTrainingSessionsForDaySingleSession(DayOfWeek dayOfWeek) {
        Timetable timetable = new Timetable();

        Group group = new Group("Акробатика для детей", Age.CHILD, 60);
        Coach coach = new Coach("Васильев", "Николай", "Сергеевич");
        TrainingSession singleTrainingSession = new TrainingSession(group, coach,
                DayOfWeek.MONDAY, new TimeOfDay(13, 0));

        timetable.addNewTrainingSession(singleTrainingSession);
        List<TrainingSession> mondaySessions = timetable.getTrainingSessionsForDay(DayOfWeek.MONDAY);
        assertEquals(1, mondaySessions.size());
        List<TrainingSession> tuesdaySessions = timetable.getTrainingSessionsForDay(DayOfWeek.TUESDAY);
        assertTrue(tuesdaySessions.isEmpty());

    }

    @Test
    void testGetTrainingSessionsForDayMultipleSessions() {
        Timetable timetable = new Timetable();

        Coach coach = new Coach("Васильев", "Николай", "Сергеевич");

        Group groupAdult = new Group("Акробатика для взрослых", Age.ADULT, 90);
        TrainingSession tuesdayAdultTrainingSession = new TrainingSession(groupAdult, coach,
                DayOfWeek.TUESDAY, new TimeOfDay(20, 0));

        timetable.addNewTrainingSession(tuesdayAdultTrainingSession);

        Group groupChild = new Group("Акробатика для детей", Age.CHILD, 60);
        TrainingSession mondayChildTrainingSession = new TrainingSession(groupChild, coach,
                DayOfWeek.MONDAY, new TimeOfDay(13, 0));
        TrainingSession tuesdayChildTrainingSession = new TrainingSession(groupChild, coach,
                DayOfWeek.TUESDAY, new TimeOfDay(13, 0));
        TrainingSession saturdayChildTrainingSession = new TrainingSession(groupChild, coach,
                DayOfWeek.SATURDAY, new TimeOfDay(10, 0));

        timetable.addNewTrainingSession(mondayChildTrainingSession);
        timetable.addNewTrainingSession(tuesdayChildTrainingSession);
        timetable.addNewTrainingSession(saturdayChildTrainingSession);

        List<TrainingSession> mondaySessions = timetable.getTrainingSessionsForDay(DayOfWeek.MONDAY);
        assertEquals(1, mondaySessions.size());
        List<TrainingSession> tuesdaySessions = timetable.getTrainingSessionsForDay(DayOfWeek.TUESDAY);
        List<TrainingSession> thursdaySessions = timetable.getTrainingSessionsForDay(DayOfWeek.THURSDAY);
        assertEquals(13, tuesdaySessions.get(0).getTimeOfDay().getHours());
        assertEquals(0, tuesdaySessions.get(0).getTimeOfDay().getMinutes());
        assertEquals(20, tuesdaySessions.get(1).getTimeOfDay().getHours());
        assertEquals(0, tuesdaySessions.get(1).getTimeOfDay().getMinutes());
        assertTrue(thursdaySessions.isEmpty());
    }

    @Test
    void testGetTrainingSessionsForDayAndTime() {
        Timetable timetable = new Timetable();

        Group group = new Group("Акробатика для детей", Age.CHILD, 60);
        Coach coach = new Coach("Васильев", "Николай", "Сергеевич");
        TrainingSession singleTrainingSession = new TrainingSession(group, coach,
                DayOfWeek.MONDAY, new TimeOfDay(13, 0));

        timetable.addNewTrainingSession(singleTrainingSession);

        List<TrainingSession> mondaySessions = timetable.getTrainingSessionsForDay(DayOfWeek.MONDAY);
        assertEquals(1, mondaySessions.size());
        assertEquals(mondaySessions.get(0).getTimeOfDay(), singleTrainingSession.getTimeOfDay());
        assertEquals(13, mondaySessions.get(0).getTimeOfDay().getHours());
        assertEquals(0, mondaySessions.get(0).getTimeOfDay().getMinutes());
        assertTrue(timetable.getTrainingSessionsForDayAndTime(DayOfWeek.MONDAY, new TimeOfDay(14, 0)).isEmpty());

    }

    @Test
    void testGetTrainingSessionsForSingleCoach() {
        Timetable timetable = new Timetable();
        Group group = new Group("Акробатика для детей", Age.CHILD, 60);
        Coach coach = new Coach("Васильев", "Николай", "Сергеевич");
        TrainingSession singleTrainingSession = new TrainingSession(group, coach,
                DayOfWeek.MONDAY, new TimeOfDay(13, 0));

        timetable.addNewTrainingSession(singleTrainingSession);

        List<Map.Entry<Coach, Integer>> list = timetable.getCountByCoaches();

        assertEquals(1, list.size());
        assertEquals(coach, list.get(0).getKey());
        assertEquals(1, list.get(0).getValue());

    }

    @Test
    void testGetTrainingSessionsForMultipleCoaches() {
        Timetable timetable = new Timetable();
        Group group = new Group("Акробатика для детей", Age.CHILD, 60);
        Coach coachPetrov = new Coach("Петров", "Андрей", "Викторович");
        Coach coachIvanov = new Coach("Иванов", "Николай", "Егорович");
        TrainingSession mondayTrainingSession = new TrainingSession(group, coachPetrov,
                DayOfWeek.MONDAY, new TimeOfDay(13, 0));

        timetable.addNewTrainingSession(mondayTrainingSession);

        TrainingSession thursdayTrainingSession = new TrainingSession(group, coachPetrov,
                DayOfWeek.THURSDAY, new TimeOfDay(14, 0));

        timetable.addNewTrainingSession(thursdayTrainingSession);

        TrainingSession wednesdayTrainingSession = new TrainingSession(group, coachIvanov,
                DayOfWeek.WEDNESDAY, new TimeOfDay(13, 0));

        timetable.addNewTrainingSession(wednesdayTrainingSession);

        List<Map.Entry<Coach, Integer>> list = timetable.getCountByCoaches();

        boolean foundPetrov = false;
        boolean foundIvanov = false;
        int petrovCount = 0;
        int ivanovCount = 0;
        for (Map.Entry<Coach, Integer> entry : list) {
            if (entry.getKey().equals(coachPetrov)) {
                foundPetrov = true;
                petrovCount = entry.getValue();
            }
            if (entry.getKey().equals(coachIvanov)) {
                foundIvanov = true;
                ivanovCount = entry.getValue();
            }
        }

        assertTrue(foundPetrov);
        assertTrue(foundIvanov);
        assertEquals(2, petrovCount);
        assertEquals(1, ivanovCount);
        System.out.println("Coach class: " + coachPetrov.getClass().getProtectionDomain().getCodeSource().getLocation());

    }

    @Test
    void testGetTrainingSessionsForEmptyCoaches() {
        Timetable timetable = new Timetable();
        List<Map.Entry<Coach, Integer>> list = timetable.getCountByCoaches();

        assertEquals(0, list.size());
    }

    @Test
    void testGetTrainingSessionsForSameTime() {
        Timetable timetable = new Timetable();
        Coach coachPetrov = new Coach("Петров", "Андрей", "Викторович");
        Coach coachIvanov = new Coach("Иванов", "Николай", "Егорович");
        Group groupOfChildren = new Group("Акробатика для детей", Age.CHILD, 60);
        Group groupOfAdults = new Group("Акробатика для взрослых", Age.CHILD, 60);

        TrainingSession childSession = new TrainingSession(groupOfChildren, coachPetrov, DayOfWeek.MONDAY, new TimeOfDay(13, 0));
        TrainingSession adultSession = new TrainingSession(groupOfAdults, coachIvanov, DayOfWeek.MONDAY, new TimeOfDay(13, 0));

        timetable.addNewTrainingSession(childSession);
        timetable.addNewTrainingSession(adultSession);

        assertEquals(2, timetable.getTrainingSessionsForDay(DayOfWeek.MONDAY).size());
        assertEquals(2,timetable.getTrainingSessionsForDayAndTime(DayOfWeek.MONDAY, new TimeOfDay(13, 0)).size());
        assertEquals(0,timetable.getTrainingSessionsForDayAndTime(DayOfWeek.MONDAY, new TimeOfDay(14, 0)).size());

    }

}

