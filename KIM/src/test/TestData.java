package test;

import org.openrdf.model.impl.LiteralImpl;
import org.openrdf.model.impl.URIImpl;

import tool.KIMAPI;

import com.ontotext.kim.client.entity.EntityDescription;
import com.ontotext.kim.client.entity.EntityDescriptionImpl;
import com.ontotext.kim.client.semanticrepository.SemanticRepositoryException;

public class TestData {
	public static void importData() {

		EntityDescriptionImpl e1 = new EntityDescriptionImpl(new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#kha"));
		e1.addAttribute(new URIImpl("http://www.w3.org/2000/01/rdf-schema#label"), new LiteralImpl("kha"));
		e1.addRelation(new URIImpl("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), new URIImpl("http://proton.semanticweb.org/2006/05/protonu#Man"));
		e1.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasAlias"), new LiteralImpl("Nguyen Kim Kha"));
		e1.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasWife"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#suong"));
		e1.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasBoss"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#nguyen"));
		e1.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasBrother"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#khanh"));
		e1.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasSister"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#khue"));
		e1.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#luan"));
		e1.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#trang"));
		e1.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#nghi"));
		e1.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#tuyen"));
		e1.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#dieu"));
		e1.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#tri"));
		e1.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#tai"));
		e1.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#hoang"));
		e1.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasNationlaty"), new LiteralImpl("vietnam"));
		e1.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasProvince"), new LiteralImpl("Phu Yen"));
		e1.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#birthday"), new LiteralImpl("1987"));
		e1.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#height"), new LiteralImpl("177"));
		e1.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#weight"), new LiteralImpl("53"));
		e1.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#studentOf"), new LiteralImpl("Bach khoa"));
		e1.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#department"), new LiteralImpl("May tinh"));
		e1.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#company"), new LiteralImpl("Qhoach"));
		try {
		KIMAPI.getEntApi().addEntityDescription(e1);
		}
		catch (SemanticRepositoryException ex1) {
		ex1.printStackTrace();
		}
		EntityDescriptionImpl e2 = new EntityDescriptionImpl(new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#suong"));
		e2.addAttribute(new URIImpl("http://www.w3.org/2000/01/rdf-schema#label"), new LiteralImpl("suong"));
		e2.addRelation(new URIImpl("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#Woman"));
		e2.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasAlias"), new LiteralImpl("Dang Thi Thu Suong"));
		e2.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasHusband"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#kha"));
		e2.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasBrother"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#tam"));
		e2.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasSister"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#thao"));
		e2.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#trang"));
		e2.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#tuyen"));
		e2.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#nghi"));
		e2.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#dieu"));
		e2.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#hoang"));
		e2.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasNationlaty"), new LiteralImpl("vietnam"));
		e2.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasProvince"), new LiteralImpl("Phu Yen"));
		e2.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#birthday"), new LiteralImpl("1988"));
		e2.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#height"), new LiteralImpl("162"));
		e2.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#weight"), new LiteralImpl("49"));
		e2.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#studentOf"), new LiteralImpl("Bach khoa"));
		e2.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#department"), new LiteralImpl("Thuc pham"));
		try {
		KIMAPI.getEntApi().addEntityDescription(e2);
		}
		catch (SemanticRepositoryException ex2) {
		ex2.printStackTrace();
		}
		EntityDescriptionImpl e3 = new EntityDescriptionImpl(new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#nguyen"));
		e3.addAttribute(new URIImpl("http://www.w3.org/2000/01/rdf-schema#label"), new LiteralImpl("nguyen"));
		e3.addRelation(new URIImpl("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#Man"));
		e3.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasAlias"), new LiteralImpl("Le Dang Nguyen"));
		e3.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasWife"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#na"));
		e3.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasNationlaty"), new LiteralImpl("vietnam"));
		e3.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasProvince"), new LiteralImpl("Can Tho"));
		e3.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#birthday"), new LiteralImpl("1977"));
		e3.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#height"), new LiteralImpl("170"));
		e3.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#weight"), new LiteralImpl("66"));
		e3.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#studentOf"), new LiteralImpl("New Jersey"));
		e3.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#department"), new LiteralImpl("May tinh"));
		e3.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#company"), new LiteralImpl("Qhoach"));
		try {
		KIMAPI.getEntApi().addEntityDescription(e3);
		}
		catch (SemanticRepositoryException ex3) {
		ex3.printStackTrace();
		}
		EntityDescriptionImpl e4 = new EntityDescriptionImpl(new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#na"));
		e4.addAttribute(new URIImpl("http://www.w3.org/2000/01/rdf-schema#label"), new LiteralImpl("na"));
		e4.addRelation(new URIImpl("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#Woman"));
		e4.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasAlias"), new LiteralImpl("Le Na"));
		e4.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasHusband"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#nguyen"));
		e4.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasBoss"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#nguyen"));
		e4.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasNationlaty"), new LiteralImpl("vietnam"));
		e4.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasProvince"), new LiteralImpl("Can Tho"));
		e4.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#birthday"), new LiteralImpl("1980"));
		e4.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#height"), new LiteralImpl("156"));
		e4.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#weight"), new LiteralImpl("45"));
		e4.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#studentOf"), new LiteralImpl("Can Tho"));
		e4.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#department"), new LiteralImpl("Marketing"));
		e4.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#company"), new LiteralImpl("Qhoach"));
		try {
		KIMAPI.getEntApi().addEntityDescription(e4);
		}
		catch (SemanticRepositoryException ex4) {
		ex4.printStackTrace();
		}
		EntityDescriptionImpl e5 = new EntityDescriptionImpl(new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#luan"));
		e5.addAttribute(new URIImpl("http://www.w3.org/2000/01/rdf-schema#label"), new LiteralImpl("luan"));
		e5.addRelation(new URIImpl("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#Man"));
		e5.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasAlias"), new LiteralImpl("Mai Thanh Luan"));
		e5.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#kha"));
		e5.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#suong"));
		e5.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#nghi"));
		e5.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#tuyen"));
		e5.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#tai"));
		e5.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasNationlaty"), new LiteralImpl("vietnam"));
		e5.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasProvince"), new LiteralImpl("Dong Nai"));
		e5.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#birthday"), new LiteralImpl("1988"));
		e5.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#height"), new LiteralImpl("167"));
		e5.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#weight"), new LiteralImpl("55"));
		e5.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#studentOf"), new LiteralImpl("Bach khoa"));
		e5.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#department"), new LiteralImpl("May tinh"));
		try {
		KIMAPI.getEntApi().addEntityDescription(e5);
		}
		catch (SemanticRepositoryException ex5) {
		ex5.printStackTrace();
		}
		EntityDescriptionImpl e6 = new EntityDescriptionImpl(new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#trang"));
		e6.addAttribute(new URIImpl("http://www.w3.org/2000/01/rdf-schema#label"), new LiteralImpl("trang"));
		e6.addRelation(new URIImpl("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#Woman"));
		e6.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasAlias"), new LiteralImpl("Tran Thi Thu Trang"));
		e6.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasBoss"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#dung"));
		e6.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasBrother"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#hoang"));
		e6.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#kha"));
		e6.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#suong"));
		e6.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#nghi"));
		e6.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#tuyen"));
		e6.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#dieu"));
		e6.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#hien"));
		e6.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasNationlaty"), new LiteralImpl("vietnam"));
		e6.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasProvince"), new LiteralImpl("Phu Yen"));
		e6.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#birthday"), new LiteralImpl("1988"));
		e6.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#height"), new LiteralImpl("155"));
		e6.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#weight"), new LiteralImpl("45"));
		e6.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#studentOf"), new LiteralImpl("Bach khoa"));
		e6.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#department"), new LiteralImpl("Hoa hoc"));
		try {
		KIMAPI.getEntApi().addEntityDescription(e6);
		}
		catch (SemanticRepositoryException ex6) {
		ex6.printStackTrace();
		}
		EntityDescriptionImpl e7 = new EntityDescriptionImpl(new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#nghi"));
		e7.addAttribute(new URIImpl("http://www.w3.org/2000/01/rdf-schema#label"), new LiteralImpl("nghi"));
		e7.addRelation(new URIImpl("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#Man"));
		e7.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasAlias"), new LiteralImpl("Nguyen Viet Nghi"));
		e7.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasWife"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#tuyen"));
		e7.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#kha"));
		e7.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#suong"));
		e7.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#luan"));
		e7.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#trang"));
		e7.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#tai"));
		e7.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasNationlaty"), new LiteralImpl("vietnam"));
		e7.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasProvince"), new LiteralImpl("Ninh Thuan"));
		e7.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#birthday"), new LiteralImpl("1988"));
		e7.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#studentOf"), new LiteralImpl("Bach khoa"));
		e7.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#department"), new LiteralImpl("May tinh"));
		try {
		KIMAPI.getEntApi().addEntityDescription(e7);
		}
		catch (SemanticRepositoryException ex7) {
		ex7.printStackTrace();
		}
		EntityDescriptionImpl e8 = new EntityDescriptionImpl(new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#tuyen"));
		e8.addAttribute(new URIImpl("http://www.w3.org/2000/01/rdf-schema#label"), new LiteralImpl("tuyen"));
		e8.addRelation(new URIImpl("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#Woman"));
		e8.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasAlias"), new LiteralImpl("Nguyen Thi Kim Tuyen"));
		e8.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasHusband"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#nghi"));
		e8.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#kha"));
		e8.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#suong"));
		e8.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#luan"));
		e8.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#trang"));
		e8.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#tai"));
		e8.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#hien"));
		e8.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasNationlaty"), new LiteralImpl("vietnam"));
		e8.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasProvince"), new LiteralImpl("Long An"));
		e8.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#birthday"), new LiteralImpl("1988"));
		e8.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#studentOf"), new LiteralImpl("Bach khoa"));
		e8.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#department"), new LiteralImpl("May tinh"));
		try {
		KIMAPI.getEntApi().addEntityDescription(e8);
		}
		catch (SemanticRepositoryException ex8) {
		ex8.printStackTrace();
		}
		EntityDescriptionImpl e9 = new EntityDescriptionImpl(new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#tai"));
		e9.addAttribute(new URIImpl("http://www.w3.org/2000/01/rdf-schema#label"), new LiteralImpl("tai"));
		e9.addRelation(new URIImpl("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#Man"));
		e9.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasAlias"), new LiteralImpl("Ta Tat Tai"));
		e9.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#kha"));
		e9.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#nghi"));
		e9.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#tuyen"));
		e9.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#luan"));
		e9.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasNationlaty"), new LiteralImpl("vietnam"));
		e9.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasProvince"), new LiteralImpl("Lam Dong"));
		e9.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#birthday"), new LiteralImpl("1988"));
		e9.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#studentOf"), new LiteralImpl("Bach khoa"));
		e9.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#department"), new LiteralImpl("May tinh"));
		try {
		KIMAPI.getEntApi().addEntityDescription(e9);
		}
		catch (SemanticRepositoryException ex9) {
		ex9.printStackTrace();
		}
		EntityDescriptionImpl e10 = new EntityDescriptionImpl(new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#dieu"));
		e10.addAttribute(new URIImpl("http://www.w3.org/2000/01/rdf-schema#label"), new LiteralImpl("dieu"));
		e10.addRelation(new URIImpl("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#Woman"));
		e10.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasAlias"), new LiteralImpl("Dam Thi Dieu"));
		e10.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasHusband"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#tri"));
		e10.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#kha"));
		e10.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#suong"));
		e10.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#trang"));
		e10.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#tuyen"));
		e10.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#hien"));
		e10.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasNationlaty"), new LiteralImpl("vietnam"));
		e10.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasProvince"), new LiteralImpl("Phu Yen"));
		e10.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#birthday"), new LiteralImpl("1986"));
		e10.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#studentOf"), new LiteralImpl("Bach khoa"));
		e10.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#department"), new LiteralImpl("Hoa hoc"));
		try {
		KIMAPI.getEntApi().addEntityDescription(e10);
		}
		catch (SemanticRepositoryException ex10) {
		ex10.printStackTrace();
		}
		EntityDescriptionImpl e11 = new EntityDescriptionImpl(new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#tri"));
		e11.addAttribute(new URIImpl("http://www.w3.org/2000/01/rdf-schema#label"), new LiteralImpl("tri"));
		e11.addRelation(new URIImpl("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#Man"));
		e11.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasAlias"), new LiteralImpl("Nguyen Dac Tri"));
		e11.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasWife"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#dieu"));
		e11.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#kha"));
		e11.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#suong"));
		e11.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#trang"));
		e11.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasNationlaty"), new LiteralImpl("vietnam"));
		e11.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasProvince"), new LiteralImpl("TPHCM"));
		e11.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#birthday"), new LiteralImpl("1987"));
		e11.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#studentOf"), new LiteralImpl("Bach khoa"));
		e11.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#department"), new LiteralImpl("May tinh"));
		try {
		KIMAPI.getEntApi().addEntityDescription(e11);
		}
		catch (SemanticRepositoryException ex11) {
		ex11.printStackTrace();
		}
		EntityDescriptionImpl e12 = new EntityDescriptionImpl(new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#khanh"));
		e12.addAttribute(new URIImpl("http://www.w3.org/2000/01/rdf-schema#label"), new LiteralImpl("khanh"));
		e12.addRelation(new URIImpl("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#Man"));
		e12.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasAlias"), new LiteralImpl("Nguyen Kim Khanh"));
		e12.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasBoss"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#minh"));
		e12.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasBrother"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#kha"));
		e12.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasSister"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#khue"));
		e12.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#hien"));
		e12.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasNationlaty"), new LiteralImpl("vietnam"));
		e12.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasProvince"), new LiteralImpl("Phu Yen"));
		e12.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#birthday"), new LiteralImpl("1985"));
		e12.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#height"), new LiteralImpl("178"));
		e12.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#weight"), new LiteralImpl("63"));
		e12.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#studentOf"), new LiteralImpl("Bach khoa"));
		e12.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#department"), new LiteralImpl("Khoa hoc ung dung"));
		e12.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#company"), new LiteralImpl("Medic"));
		try {
		KIMAPI.getEntApi().addEntityDescription(e12);
		}
		catch (SemanticRepositoryException ex12) {
		ex12.printStackTrace();
		}
		EntityDescriptionImpl e13 = new EntityDescriptionImpl(new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#khue"));
		e13.addAttribute(new URIImpl("http://www.w3.org/2000/01/rdf-schema#label"), new LiteralImpl("khue"));
		e13.addRelation(new URIImpl("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#Woman"));
		e13.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasAlias"), new LiteralImpl("Nguyen Thi Kim Khue"));
		e13.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasBrother"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#kha"));
		e13.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasBrother"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#khanh"));
		e13.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#hoang"));
		e13.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasNationlaty"), new LiteralImpl("vietnam"));
		e13.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasProvince"), new LiteralImpl("Phu Yen"));
		e13.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#birthday"), new LiteralImpl("1989"));
		e13.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#height"), new LiteralImpl("167"));
		e13.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#weight"), new LiteralImpl("51"));
		e13.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#studentOf"), new LiteralImpl("Kinh te"));
		e13.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#department"), new LiteralImpl("Tai chinh"));
		try {
		KIMAPI.getEntApi().addEntityDescription(e13);
		}
		catch (SemanticRepositoryException ex13) {
		ex13.printStackTrace();
		}
		EntityDescriptionImpl e14 = new EntityDescriptionImpl(new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#hien"));
		e14.addAttribute(new URIImpl("http://www.w3.org/2000/01/rdf-schema#label"), new LiteralImpl("hien"));
		e14.addRelation(new URIImpl("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#Woman"));
		e14.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasAlias"), new LiteralImpl("Nguyen Thi Ngoc Hien"));
		e14.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#kha"));
		e14.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#suong"));
		e14.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#tuyen"));
		e14.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#trang"));
		e14.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#dieu"));
		e14.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#khanh"));
		e14.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasNationlaty"), new LiteralImpl("vietnam"));
		e14.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasProvince"), new LiteralImpl("Phu Yen"));
		e14.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#birthday"), new LiteralImpl("1988"));
		e14.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#studentOf"), new LiteralImpl("Tu nhien"));
		e14.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#department"), new LiteralImpl("Sinh hoc"));
		try {
		KIMAPI.getEntApi().addEntityDescription(e14);
		}
		catch (SemanticRepositoryException ex14) {
		ex14.printStackTrace();
		}
		EntityDescriptionImpl e15 = new EntityDescriptionImpl(new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#hoang"));
		e15.addAttribute(new URIImpl("http://www.w3.org/2000/01/rdf-schema#label"), new LiteralImpl("hoang"));
		e15.addRelation(new URIImpl("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#Man"));
		e15.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasAlias"), new LiteralImpl("Tran Minh Hoang"));
		e15.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasSister"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#trang"));
		e15.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#kha"));
		e15.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#suong"));
		e15.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#khue"));
		e15.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasNationlaty"), new LiteralImpl("vietnam"));
		e15.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasProvince"), new LiteralImpl("Phu Yen"));
		e15.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#birthday"), new LiteralImpl("1990"));
		e15.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#studentOf"), new LiteralImpl("SPKT"));
		e15.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#department"), new LiteralImpl("Dien tu"));
		try {
		KIMAPI.getEntApi().addEntityDescription(e15);
		}
		catch (SemanticRepositoryException ex15) {
		ex15.printStackTrace();
		}
		}
	
	public static EntityDescription getTest1() {
		EntityDescriptionImpl e1 = new EntityDescriptionImpl(new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#kha1"));
		e1.addAttribute(new URIImpl("http://www.w3.org/2000/01/rdf-schema#label"), new LiteralImpl("kha1"));
		e1.addAttribute(new URIImpl("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), new LiteralImpl("man"));
		e1.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasAlias"), new LiteralImpl("Nguyen Kim Kha"));
		e1.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasBoss"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#nguyen"));
		e1.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasBrother"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#khanh"));
		e1.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasSister"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#khue"));
		
		return e1;
	}
	
	public static EntityDescription getTest2() {
		EntityDescriptionImpl e2 = new EntityDescriptionImpl(new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#kha2"));
		e2.addAttribute(new URIImpl("http://www.w3.org/2000/01/rdf-schema#label"), new LiteralImpl("kha2"));
		e2.addAttribute(new URIImpl("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), new LiteralImpl("man"));
		e2.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasWife"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#suong"));
		e2.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasBoss"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#nguyen"));
		e2.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#luan"));
		e2.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#trang"));
		e2.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#nghi"));
		e2.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#tuyen"));
		e2.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#dieu"));
		e2.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#tri"));
		e2.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#tai"));
		e2.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#hoang"));
		e2.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#studentOf"), new LiteralImpl("Bach khoa"));
		e2.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#department"), new LiteralImpl("May tinh"));
		e2.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#company"), new LiteralImpl("Qhoach"));
		
		return e2;
	}
	
	public static EntityDescription getTest3() {
		EntityDescriptionImpl e3 = new EntityDescriptionImpl(new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#kha3"));
		e3.addAttribute(new URIImpl("http://www.w3.org/2000/01/rdf-schema#label"), new LiteralImpl("kha3"));
		e3.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasWife"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#suong"));
		e3.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#luan"));
		e3.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#trang"));
		e3.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasNationlaty"), new LiteralImpl("vietnam"));
		e3.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasProvince"), new LiteralImpl("Phu Yen"));
		e3.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#birthday"), new LiteralImpl("1987"));
		e3.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#height"), new LiteralImpl("177"));
		e3.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#weight"), new LiteralImpl("53"));
		
		return e3;
	}
	
}
