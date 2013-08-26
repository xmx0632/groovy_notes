

import static  java.io.File.separator as sep
import java.io.File

println "find files number:"

def totalFileNumber = 0

def totalDuplicatedFileNumber = 0

def map = [:]

def delClos

delClos = {
	it.eachDir( delClos );
	it.eachFileMatch( ~".*.pdf" ) {
		//		println "File ${it.canonicalPath} lastModified:${it.lastModified()}";
		def key = "${it.name}_${it.size()}"
		def values =map.get(key)? [
			map.get(key),
			it.canonicalPath
		].flatten():[it.canonicalPath]

		map.put(key,values)
		print "${totalFileNumber++}\b\b\b\b\b\b\b\b"
	}
}

//-------------------------find duplicated books------------------------------------------
[
	"C:/",
	"D:/",
	"E:/",
	//"D:/doc/",
	//"D:/doc/dev doc",
	//"E:/dev_book"
	//	"D:/tmp/test_backup"
].each {it ->
	def file = new File(it)
	/*
	if(!file.exists()){
		//println "not exists dir :${it}"
	}else{
		//println "deal with dir :${it}"
		delClos(new File(it))	
	}
	//*/
	file.exists()?delClos(new File(it)):""
}


//resolve chinese unreadable code
BufferedWriter writer = new File("d:/duplicated_pdf.txt").newWriter('UTF-8')

map.each { key, value ->
	if(value.size()>1){
		//println "\n${key}"
		writer.writeLine("\r\n${key}\r\n") 
		totalDuplicatedFileNumber++

		value.each {
			//println "* ${it}"
			writer.writeLine("* ${it}\r\n")  
		}
	}
}

writer.close() 

println "\n-------- ${totalDuplicatedFileNumber} duplicate pdf books found -------"