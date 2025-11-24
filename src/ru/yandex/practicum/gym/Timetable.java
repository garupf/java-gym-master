package org.example;

import java.util.*;

public class Timetable {

    public Timetable() {
        this.timetable = new HashMap<>();
    }

    private final Map<DayOfWeek, TreeMap<TimeOfDay, List<TrainingSession>>> timetable;

    public void addNewTrainingSession(TrainingSession trainingSession) {
        DayOfWeek dayOfWeek = trainingSession.getDayOfWeek();
        TimeOfDay timeOfDay = trainingSession.getTimeOfDay();

        TreeMap<TimeOfDay, List<TrainingSession>> map = timetable.computeIfAbsent(dayOfWeek, k -> new TreeMap<>());
        List<TrainingSession> trainingSessions = map.computeIfAbsent(timeOfDay, k -> new ArrayList<>());
        trainingSessions.add(trainingSession);
    }

    public List<TrainingSession> getTrainingSessionsForDay(DayOfWeek dayOfWeek) {
        if (dayOfWeek == null) return new ArrayList<>();

        TreeMap<TimeOfDay, List<TrainingSession>> map = timetable.get(dayOfWeek);
        if (map == null) return new ArrayList<>();

        List<TrainingSession> result = new ArrayList<>();

        for (List<TrainingSession> list : map.values()) {
            result.addAll(list);
        }

        return result;
    }

    public List<TrainingSession>  getTrainingSessionsForDayAndTime(DayOfWeek dayOfWeek, TimeOfDay timeOfDay) {
        TreeMap<TimeOfDay, List<TrainingSession>> map = timetable.get(dayOfWeek);
        if (map == null) {
            return new ArrayList<>();
        }
        List<TrainingSession> trainingSession = map.get(timeOfDay);
        if (trainingSession == null) {
            return new ArrayList<>();
        }
        return trainingSession;
    }

    public List<Map.Entry<Coach, Integer>> getCountByCoaches() {
        Map<Coach, Integer> coachCount = new HashMap<>();

        for (TreeMap<TimeOfDay, List<TrainingSession>> dayMap : timetable.values()) {
            if (dayMap == null) continue;

            for (List<TrainingSession> session : dayMap.values()) {
                for (TrainingSession trainingSession : session) {
                    Coach coach = trainingSession.getCoach();
                    coachCount.put(coach, coachCount.getOrDefault(coach, 0) + 1);
                }
            }
        }

        List<Map.Entry<Coach, Integer>> list = new ArrayList<>(coachCount.entrySet());
        list.sort(Map.Entry.<Coach, Integer>comparingByValue().reversed());
        return list;
    }

}
