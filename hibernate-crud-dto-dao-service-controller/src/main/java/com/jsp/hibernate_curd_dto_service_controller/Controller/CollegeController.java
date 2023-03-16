package com.jsp.hibernate_curd_dto_service_controller.Controller;

import java.util.List;
import java.util.Scanner;

import com.jsp.hibernate_curd_dto_service_controller.Service.CollegeService;
import com.jsp.hibernate_curd_dto_service_controller.dto.College;

public class CollegeController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CollegeService collegeService = new CollegeService();
		College college = new College();
		while(true) {
			System.out.println("Enter the choice");
			System.out.println("1.Insert\n2.GetById\n3.Delete\n4.Update \n5.Display");
			int ch = sc.nextInt();
			switch(ch) {
			case 1: {
				System.out.println("Enter the collegeId");
				college.setCollegeId(sc.nextInt());
				
				System.out.println("Enter the collegeName");
				college.setCollegeName(sc.next());
				
				System.out.println("Enter the collegeAddres");
				college.setCollegeAddress(sc.next());
				
				System.out.println("Enter the collegeType");
				college.setCollegeType(sc.next());
				collegeService.saveCollege(college);
			}break;
			case 2: {
				System.out.println("Enter the collegeId");
				int id = sc.nextInt();
				College c = collegeService.getById(id);
				System.out.println("Collage Id = "+c.getCollegeId());
				System.out.println("Collage Name = "+c.getCollegeName());
				System.out.println("Collage Adress = "+c.getCollegeAddress());
				System.out.println("Collage Type = "+c.getCollegeType());
			}break;
			case 3: {
				System.out.println("Enter the collegeId");
				int id = sc.nextInt();
				collegeService.deleteCollege(id);
			}break;
			case 4: {
			      while(true) {
				System.out.println("Enter the collegeId");
				int id= sc.nextInt();
			System.out.println("what do you want update");
			System.out.println("1.CollageName\n2.CollageAdress\n3.CollageType");
			int want = sc.nextInt();
			switch(want) {
			case 1:{
				System.out.println("Enter the CollageName");
				String name= sc.next();
				collegeService.updateCollege(id, name);
				
			}break;
			case 2: {
				System.out.println("Enter the collageAdress");
				String adress = sc.next();
				collegeService.updateCollegeAdress(id, adress);
			}break;
			case 3: {
				System.out.println("Enter the CollageType");
				String type = sc.next();
				collegeService.updateCollegeType(id, type);
			}break;
			}
			break;
			      }
			      
			}break;
			
			case 5: {
				System.out.println("--------College Details-----------");
				List<College> colleges = collegeService.displayCollege();
				for (College college2 : colleges) {
					
					System.out.println("College Id= "+college2.getCollegeId());
					System.out.println("College Name = "+college2.getCollegeName());
					System.out.println("Collage Address = "+college2.getCollegeAddress());
					System.out.println("Collage Type = "+college2.getCollegeType());
				}
			}break;
			
			}
		}

	}

}
