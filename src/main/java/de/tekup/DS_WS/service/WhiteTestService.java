package de.tekup.DS_WS.service;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Service;

import de.tekup.DS_WS.DsWsSoapApplication;
import de.tekup.soap.models.whitetest.Exam;
import de.tekup.soap.models.whitetest.ObjectFactory;
import de.tekup.soap.models.whitetest.StudentRequest;
import de.tekup.soap.models.whitetest.WhiteTestResponse;
import de.tekup.soap.models.whitetest.Student;
import de.tekup.soap.models.whitetest.Student.Address;

@Service
public class WhiteTestService {
	
	public  List<Student> students = new ArrayList<Student>();
	public  List<Exam> exams = new ArrayList<Exam>();


	public WhiteTestResponse checkExam(StudentRequest studentRequest) throws DatatypeConfigurationException
	{
		
		Address a1 = new Address();
		a.setCity("tunis");
		a.setStreet("amalStreet");
		a.setPosteCode("9000");
		
		Address b = new Address();
	    b.setCity("beja");
		b.setStreet("nourStreet");
		b.setPosteCode("2000");
		
		Address c = new Address();
		c.setCity("nabeul");
		c.setStreet("rueamal");
		c.setPosteCode("2020");
		
		
		
		students.add(new Student(1,"student1",a));
		students.add(new Student(2,"student2",b));
		students.add(new Student(3,"student3",c));
		
		exams.add(new Exam("code_OCA","OCA"));
		exams.add(new Exam("code_OCP","OCP"));
		
		
		
		WhiteTestResponse response = new ObjectFactory().createWhiteTestResponse();
		
		
		
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
        DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
        XMLGregorianCalendar now = 
            datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
		
		for (Student student : students) { 		

	           if (student.getId() == studentRequest.getStudentId())
	           {
	        	   System.out.println("id etudiant : "+student.getId());
	        	   System.out.println("requestId : "+studentRequest.getStudentId());
	        	   System.out.println(student.getId() == studentRequest.getStudentId());
	        	   System.out.println(student.toString());
	        	   response.setStudent(student);
	           }
	      }
		for (Exam exam : exams)
		{
			if (exam.getCode().equals(studentRequest.getExamCode()))
			{
				response.setExam(exam);
				response.setDate(now);
			}
		}

		return response;
	}

}
