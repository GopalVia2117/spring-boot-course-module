package com.spring.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.springrest.entities.Course;


@Service
public class CourseServiceImpl implements CourseService {
	List<Course> list;
	
	
	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Course(145, "Java", "Basics of Java"));
		list.add(new Course(141, "Python", "Basics of Python"));
	}


	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return list;
	}


	@Override
	public Course getCourse(long courseId) {
		Course c = null;
		
		for (Course course : list) {
			if(course.getId() == courseId) {
				c = course;
				break;
			}
		}
		return c;
	}


	@Override
	public Course addCourse(Course course) {
		this.list.add(course);
		return course;
	}


	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		for(Course c: list) {
			if(c.getId() == course.getId()) {
				c.setTitle(course.getTitle());
				c.setDescription(course.getDescription());
				break;
			}
		}
		return course;
	}


	@Override
	public Course deleteCourse(long courseId) {
		Course c = this.getCourse(courseId);
		
		if(c != null) {
			this.list.remove(c);
		}
		return c;
	}

}
