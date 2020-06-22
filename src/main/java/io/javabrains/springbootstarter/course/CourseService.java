package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository CourseRepository;
	
	public List<Course> getAllCourses(String topicId)
	{
		//return topics;
		List<Course> courses = new ArrayList<>();
		CourseRepository.findByTopicId(topicId)
		.forEach(courses::add);;
		return courses;
	}
	
	public Course getCourse(String id)
	{
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return CourseRepository.findOne(id);
	}
	
	public void addCourse(Course course)
	{
		//topics.add(topic);
		CourseRepository.save(course);
	}

	public void updateCourse(Course course) 
	{
		CourseRepository.save(course);
	}

	public void deleteCourse(String id) 
	{
		//topics.removeIf(t -> t.getId().equals(id));
		CourseRepository.delete(id);
	}
}
