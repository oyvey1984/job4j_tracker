package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int count = 0;
        int sum = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
            }
        }
        return (double) sum / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label>  averageScoreList = new LinkedList<>();
        for (Pupil pupil : pupils) {
            int sumScoreBySubjects = 0;
            double averageScoreSubjects;
            for (Subject subject : pupil.subjects()) {
                sumScoreBySubjects += subject.score();
            }
            averageScoreSubjects = (double) sumScoreBySubjects / pupil.subjects().size();
            Label label = new Label(pupil.name(), averageScoreSubjects);
            averageScoreList.add(label);
        }
        return averageScoreList;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> sumScoreOfSubject = new LinkedHashMap<>();
        List<Label> averageScoreBysub = new LinkedList<>();
        int sumPupils = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumScoreOfSubject.put(subject.name(), sumScoreOfSubject.getOrDefault(subject.name(), 0)
                        + subject.score());
            }
            sumPupils++;
        }
        for (String key : sumScoreOfSubject.keySet()) {
            averageScoreBysub.add(new Label(key, (double) sumScoreOfSubject.get(key) / sumPupils));
        }
        return averageScoreBysub;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        LinkedList<Label>  students = new LinkedList<>();
        for (Pupil pupil : pupils) {
            int sumScoreBySubjects = 0;
            for (Subject subject : pupil.subjects()) {
                sumScoreBySubjects += subject.score();
            }
            Label label = new Label(pupil.name(), sumScoreBySubjects);
            students.add(label);
        }
        students.sort(Comparator.naturalOrder());
        return students.getLast();
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> subjectsSumScore = new LinkedHashMap<>();
        LinkedList<Label> subjectsLabelForm = new LinkedList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectsSumScore.put(subject.name(), subjectsSumScore.getOrDefault(subject.name(), 0)
                        + subject.score());
            }
        }
        for (String key : subjectsSumScore.keySet()) {
            subjectsLabelForm.add(new Label(key, (double) subjectsSumScore.get(key)));
        }
        subjectsLabelForm.sort(Comparator.naturalOrder());
        return subjectsLabelForm.getLast();
    }
}