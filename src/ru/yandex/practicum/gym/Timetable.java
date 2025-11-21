package org.example;

import java.util.*;

public class Timetable {

    public Timetable() {
        this.timetable = new HashMap<>();
    }

    private final Map<DayOfWeek, TreeMap<TimeOfDay, TrainingSession>> timetable;

    public void addNewTrainingSession(TrainingSession trainingSession) {
        DayOfWeek dayOfWeek = trainingSession.getDayOfWeek();
        TimeOfDay timeOfDay = trainingSession.getTimeOfDay();

        timetable.computeIfAbsent(dayOfWeek, k -> new TreeMap<>());
        timetable.get(dayOfWeek).put(timeOfDay, trainingSession);
    }

    public List<TrainingSession> getTrainingSessionsForDay(DayOfWeek dayOfWeek) {
        if (dayOfWeek != null) {
            TreeMap<TimeOfDay, TrainingSession> map = timetable.get(dayOfWeek);
            if (map == null) {
                return new ArrayList<>();
            } else {
                return new ArrayList<>(map.values());
            }
        }
        return new ArrayList<>();
    }

    public List<TrainingSession>  getTrainingSessionsForDayAndTime(DayOfWeek dayOfWeek, TimeOfDay timeOfDay) {
        TreeMap<TimeOfDay, TrainingSession> map = timetable.get(dayOfWeek);
        if (map == null) {
            return new ArrayList<>();
        }
        TrainingSession trainingSession = map.get(timeOfDay);
        if (trainingSession == null) {
            return new ArrayList<>();
        } else {
            List<TrainingSession> trainingSessions = new ArrayList<>();
            trainingSessions.add(trainingSession);
            return trainingSessions;
        }
    }

    public List<Map.Entry<Coach, Integer>> getCountByCoaches() {
        Map<Coach, Integer> coachCount = new HashMap<>();

        for (TreeMap<TimeOfDay, TrainingSession> dayMap : timetable.values()) {
            if (dayMap == null) continue;

            for (TrainingSession session : dayMap.values()) {
                Coach coach = session.getCoach();
                coachCount.put(coach, coachCount.getOrDefault(coach, 0) + 1);
            }
        }

        List<Map.Entry<Coach, Integer>> list = new ArrayList<>(coachCount.entrySet());
        list.sort(Map.Entry.<Coach, Integer>comparingByValue().reversed());
        return list;
    }

}
