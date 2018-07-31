package edu.algorithms.grokkingalgorithms.chapter8.greedyalgorithms;

import com.sun.istack.internal.Nullable;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

class Lesson {
    private String name;
    private LocalTime startTime;
    private LocalTime endTime;

    public Lesson(String name, LocalTime startTime, LocalTime endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "name='" + name + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}

public class ScheduleExample {

    public static void main(String[] args) {
        ScheduleExample scheduleExample = new ScheduleExample();
        List<Lesson> allLessons = scheduleExample.populate();
        List<Lesson> resultLessons = scheduleExample.calculateOptimalLessonsSchedule(allLessons);
        System.out.println(resultLessons);
    }

    private List<Lesson> populate() {
        ArrayList<Lesson> resultLessons = new ArrayList<>();

        resultLessons.add(new Lesson("painting", LocalTime.of(9, 0), LocalTime.of(10, 0)));
        resultLessons.add(new Lesson("english", LocalTime.of(9, 30), LocalTime.of(10, 30)));
        resultLessons.add(new Lesson("math", LocalTime.of(10, 0), LocalTime.of(11, 0)));
        resultLessons.add(new Lesson("info", LocalTime.of(10, 30), LocalTime.of(11, 30)));
        resultLessons.add(new Lesson("music", LocalTime.of(11, 0), LocalTime.of(12, 0)));

        return resultLessons;
    }

    public List<Lesson> calculateOptimalLessonsSchedule(List<Lesson> allLessons) {
        List<Lesson> temporaryLessons = new ArrayList<>(allLessons);

        List<Lesson> optimalLessons = new ArrayList<>();
        Lesson earlierLesson = getTheEarlierLesson(temporaryLessons, null);
        while (earlierLesson != null) {
            optimalLessons.add(earlierLesson);
            temporaryLessons.remove(earlierLesson);
            earlierLesson = getTheEarlierLesson(temporaryLessons, earlierLesson.getEndTime());
        }

        return optimalLessons;
    }

    @Nullable
    private Lesson getTheEarlierLesson(List<Lesson> lessons, @Nullable LocalTime endOfPreviousLesson) {
        if (endOfPreviousLesson == null) {
            return getTheFirstLesson(lessons);
        }

        List<Lesson> lessonsAfterPreviousLesson = getAllLessonsStartsAfterTime(lessons, endOfPreviousLesson);
        if (lessonsAfterPreviousLesson.size() > 0) {
            return getTheEarliestEndTimeLesson(lessonsAfterPreviousLesson);
        }
        return null;
    }

    private List<Lesson> getAllLessonsStartsAfterTime(List<Lesson> allLessons, LocalTime endOfPreviousLesson) {
        ArrayList<Lesson> resultLessons = new ArrayList<>();
        for (Lesson lesson : allLessons) {
            if(!lesson.getStartTime().isBefore(endOfPreviousLesson)){
                resultLessons.add(lesson);
            }
        }

        return resultLessons;
    }

    private Lesson getTheEarliestEndTimeLesson(List<Lesson> lessonsAfterPreviousLesson) {
        Lesson lessonToCompare = lessonsAfterPreviousLesson.get(0);
        for (int i = 1; i < lessonsAfterPreviousLesson.size(); i++) {
            Lesson currentLesson = lessonsAfterPreviousLesson.get(i);
            if (currentLesson.getEndTime().isBefore(lessonToCompare.getEndTime())){
                lessonToCompare = currentLesson;
            }
        }
        return lessonToCompare;
    }

    private Lesson getTheFirstLesson(List<Lesson> lessons) {
        Lesson lessonToCompare = lessons.get(0);
        for (int i = 0; i < lessons.size(); i++) {
            if (lessons.get(i).getEndTime().isBefore(lessonToCompare.getEndTime())) {
                lessonToCompare = lessons.get(i);
            }
        }
        return lessonToCompare;
    }

}
