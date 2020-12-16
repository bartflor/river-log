package pl.bartflor.riverlog.testhelper

import org.json.JSONObject

class RivermapCommunicationHelper {

	static String getRivermapSectionsResponse(){
		new JSONObject("{\n" +
				"  " +
				"\"header\": {\n" +
				"    " +
				"\"timestamp\": 1607712929,\n" +
				"    " +
				"\"date\": \"Fri, 11 Dec 2020 19:55:29 +0100\"\n" +
				"  " +
				"},\n" +
				"  " +
				"\"data\": {\n" +
				"    " +
				"\"description\": {\n" +
				"      " +
				"\"title\": \"The Rivermap ODbL Extract\",\n" +
				"      " +
				"\"sourceUrl\": \"https://www.rivermap.ch/public/ODBL/extract.json\",\n" +
				"      " +
				"\"author\": \"Rivermap\",\n" +
				"      " +
				"\"authorUrl\": \"https://www.rivermap.ch/\",\n" +
				"      " +
				"\"license\": " +
				"\"This data extract is made available under the Open Database License: http://opendatacommons.org/licenses/odbl/1.0/. Any rights in individual contents of the data extract are licensed under the Database Contents License: http://opendatacommons.org/licenses/dbcl/1.0/\"" +
				",\n" +
				"      " +
				"\"licenseUrl\": \"https://www.rivermap.ch/reuse.php#RMODBL\",\n" +
				"      " +
				"\"disclaimer\": " +
				"\"No warranty, expressed or implied, is made regarding the availability, accuracy, adequacy, completeness, legality, reliability or usefulness of this information. The information is provided on an 'as is' basis. All warranties of any kind, express or implied, including but not limited to the implied warranties of merchantability, fitness for a particular purpose, and non-infringement of proprietary rights are disclaimed.\"" +
				",\n" +
				"      " +
				"\"schema\": \"0.2.0\"\n" +
				"    " +
				"},\n" +
				"    " +
				"\"sections\": [\n" +
				"      " +
				"{\n" +
				"        " +
				"\"id\": 1,\n" +
				"        " +
				"\"uuid\": \"c4ca4238-a0b9-3382-8dcc-509a6f75849b\",\n" +
				"        " +
				"\"river\": \"Thur\",\n" +
				"        " +
				"\"section\": \"Oberste (Stein - Neu St.Johann)\",\n" +
				"        " +
				"\"type\": \"section\",\n" +
				"        " +
				"\"latstart\": 47.20729999999999648707671440206468105316162109375,\n" +
				"        " +
				"\"lngstart\": 9.21829999999999927240423858165740966796875,\n" +
				"        " +
				"\"latend\": 47.22489999999999810142981004901230335235595703125,\n" +
				"        " +
				"\"lngend\": 9.1899999999999995026200849679298698902130126953125,\n" +
				"        " +
				"\"generalGrade\": \"IV-V\",\n" +
				"        " +
				"\"spotGrades\": \"(V+)\",\n" +
				"        " +
				"\"country\": \"CH\",\n" +
				"        " +
				"\"url\": \"https://www.rivermap.ch/map.html?inf=1#lat=47.2160985&lng=9.20415&zoom=12\"\n" +
				"      " +
				"},\n" +
				"      " +
				"{\n" +
				"        " +
				"\"id\": 2,\n" +
				"        " +
				"\"uuid\": \"c81e728d-9d4c-3f63-af06-7f89cc14862c\",\n" +
				"        " +
				"\"river\": \"Thur\",\n" +
				"        " +
				"\"section\": \"Welle Bürglen\",\n" +
				"        " +
				"\"type\": \"playspot\",\n" +
				"        " +
				"\"latstart\": 47.5457999999999998408384271897375583648681640625,\n" +
				"        " +
				"\"lngstart\": 9.149699999999999278088580467738211154937744140625,\n" +
				"        " +
				"\"latend\": 47.5467000000000012960299500264227390289306640625,\n" +
				"        " +
				"\"lngend\": 9.1483000000000007645439836778677999973297119140625,\n" +
				"        " +
				"\"generalGrade\": \"III-IV\",\n" +
				"        " +
				"\"country\": \"CH\",\n" +
				"        " +
				"\"url\": \"https://www.rivermap.ch/map.html?inf=2#lat=47.5462495&lng=9.149&zoom=12\"\n" +
				"      " +
				"}\n" +
				"    ]\n" +
				"  " +
				"}\n" +
				"}"
		)
	}
}
