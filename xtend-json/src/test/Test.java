package test;

import org.eclipse.uml2.uml.UMLPackage;

public class Test {

	@org.junit.Test
	public void uml() {
		System.out.println(new EPackageToJSon().render(UMLPackage.eINSTANCE));
	}

}
