package test

import org.eclipse.emf.ecore.EPackage
import java.util.List
import org.eclipse.emf.ecore.EClass
import java.io.StringWriter
import javax.json.Json

class EPackageToJSon {
	
	def render(EPackage self) {
		val List<EClass> nodes = newArrayList
		self.EClassifiers.filter(typeof(EClass)).forEach[fill(nodes, it)]
		
		val out = new StringWriter
		val graph = Json::createGenerator(out)
		
		graph.writeStartObject
			.writeStartArray("nodes")
				nodes.forEach[
					graph.writeStartObject
						.write("name", it.name)
						.write("group", it.EAllSuperTypes.size)
					.writeEnd		
				]
			graph.writeEnd // end nodes
			
			.writeStartArray("links")
			nodes.forEach[from | 
				from.ESuperTypes.forEach[ to |
					graph.writeStartObject
						.write("source", nodes.indexOf(from))
						.write("target", nodes.indexOf(to))
						.write("type", "extends")
					.writeEnd
				]
			]
			graph.writeEnd // end links
		graph.writeEnd.close
		return out.toString
		
	}
	
	def void fill(List<EClass> list, EClass self) {
		if (list.contains(self)) {
			return
		}
		
		list.add(self)
		self.EAllSuperTypes.forEach[fill(list, it)]
	}
}