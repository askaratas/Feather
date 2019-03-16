import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;


/** *******************************************************************************************
 * TVL_CodeGenerator
 * --------------------------------------------------------------------------------------------
 * @author Ahmet Serkan Karatas
 *
 ** ******************************************************************************************* */
class TVL_CodeGenerator
{

	public static boolean generateCode(Feature root, ArrayList<Feature> featureList, ArrayList<CrossTreeConstraint> constraintList, String fileName)
	{
		String code;
		
		code  = generateStringEnumerationsCode(featureList);
		code += generateFeatureDeclarationsCode(root, constraintList);
		
		FileWriter featherFile;
		BufferedWriter bufferedWriter;
		try
		{
			featherFile = new FileWriter(fileName);
			bufferedWriter = new BufferedWriter(featherFile);
			bufferedWriter.write(code);
			bufferedWriter.close();
		}
		catch (Exception e)
		{
			return false;
		}
		
		return true;
	}
	
	
	private static String generateStringEnumerationsCode(ArrayList<Feature> featList)
	{
		if ( featList == null || featList.size() == 0 )
		{
			return "";
		}
		
		int i, j, k;
		boolean found;
		ArrayList<String> strList = new ArrayList<String>();
		Feature feat;
		Attribute attr;
		
		for (i=0; i < featList.size(); i++)
		{
			feat = featList.get(i);
			
			for (j=0; j < feat.attributes.size(); j++)
			{
				attr = feat.attributes.get(j);
				if ( attr.type == Codes.TYPE_STRING )
				{
					found = false;
					for (k=0; k < strList.size(); k++)
					{
						if ( attr.stringval.equals((String)strList.get(k)) )
						{
							found = true;
							break;
						}
					}
					if ( !found )
					{
						strList.add(attr.stringval);
					}
				}
			}
		}
		
		if ( strList.size() == 0 )
		{
			return "";
		}
		
		String code = "enum string in { ";
		
		code += "\"" + strList.get(0) + "\" ";
		for (i=1; i < strList.size(); i++)
		{
			code += ", \"" + strList.get(i) + "\" ";
		}
		code += "}\r\n";
		
		return code;
	}

	private static String generateFeatureDeclarationsCode(Feature root, ArrayList<CrossTreeConstraint> ctcList)
	{
		if ( root == null )
		{
			return "";
		}
		
		int i;
		Feature feat;
		
		String code, codePiece;
		
		code = "root " + root._name + "\r\n";
		code += "{\r\n";
		
		codePiece = generateAttributeDeclarationsCode(root.attributes);
		code += codePiece;
		if ( codePiece.equals("") == false )
		{
			code += "\r\n";
		}
		
		codePiece = generateChildrenDeclarationsCode(root.children);
		code += codePiece;
		if ( codePiece.equals("") == false )
		{
			code += "\r\n";
		}
		
		codePiece = generateConstraintDeclarationsCode(root.idNo, ctcList);
		code += codePiece;
		if ( codePiece.equals("") == false )
		{
			code += "\r\n";
		}
		
		code += "}\r\n\r\n";
		
		ArrayList<Feature> stack = new ArrayList<Feature>();
		ArrayList<Feature> featList = new ArrayList<Feature>();
		stack.addAll(root.children);
		while ( stack.isEmpty() == false )
		{
			feat = stack.get(stack.size()-1);
			featList.add(feat);
			
			stack.remove(feat);
			stack.addAll(feat.children);
		}
		
		if ( featList == null || featList.size() == 0 )
		{
			return code;
		}
		
		for (i=0; i < featList.size(); i++)
		{
			feat = featList.get(i);
			
			if ( feat.idNo == root.idNo )
			{
				continue;
			}
			
			code += feat._name + "\r\n{\r\n";
			
			codePiece = generateAttributeDeclarationsCode(feat.attributes);
			code += codePiece;
			if ( codePiece.equals("") == false )
			{
				code += "\r\n";
			}
			
			codePiece = generateChildrenDeclarationsCode(feat.children);
			code += codePiece;
			if ( codePiece.equals("") == false )
			{
				code += "\r\n";
			}
			
			codePiece = generateConstraintDeclarationsCode(feat.idNo, ctcList);
			code += codePiece;
			if ( codePiece.equals("") == false )
			{
				code += "\r\n";
			}
			
			code += "}\r\n\r\n";
		}
		
		return code;
	}

	private static String generateAttributeDeclarationsCode(ArrayList<Attribute> attrList)
	{
		if ( attrList == null || attrList.size() == 0 )
		{
			return "";
		}
		
		int i;
		Attribute attr;
		String code = "";
		
		for (i=0; i < attrList.size(); i++)
		{
			attr = attrList.get(i);
			
			switch ( attr.type )
			{
				case Codes.TYPE_INT:
					code += "  int " + attr.name + " is " + attr.intval + " ;\r\n";
					break;
					
				case Codes.TYPE_REAL:
					code += "  real " + attr.name + " is " + attr.realval + " ;\r\n";
					break;

				case Codes.TYPE_BOOL:
					code += "  bool " + attr.name + " is " + attr.boolval + " ;\r\n";
					break;
					
				case Codes.TYPE_STRING:
					code += "  string " + attr.name + " is \"" + attr.stringval + "\" ;\r\n";
					break;
			}
		}
		
		return code;
	}

	private static String generateChildrenDeclarationsCode(ArrayList<Feature> childList)
	{
		if ( childList == null || childList.size() == 0 )
		{
			return "";
		}
		
		// first categorize children
		Feature feat, sibling;
		ArrayList<Feature> man_opt     = new ArrayList<Feature>();
		ArrayList<Feature> alternative = new ArrayList<Feature>();
		ArrayList<Feature> or          = new ArrayList<Feature>();
		
		int i;
		
		for (i=0; i < childList.size(); i++)
		{
			feat = childList.get(i);
			
			if ( feat._decomp == Codes.MANDATORY || feat._decomp == Codes.OPTIONAL )
			{
				man_opt.add(feat);
			}
			else if ( feat._decomp == Codes.ALTERNATIVE )
			{
				alternative.add(feat);
			}
			else if ( feat._decomp == Codes.OR )
			{
				or.add(feat);
			}
		}
		
		String code = "";
		
		if ( man_opt.size() > 0 )
		{
			code = "  group allof { ";
			
			code += ( man_opt.get(0)._decomp == Codes.MANDATORY ? "" : " opt ") + man_opt.get(0)._name;
			for (i=1; i < man_opt.size(); i++)
			{
				code += ", " + ( man_opt.get(i)._decomp == Codes.MANDATORY ? "" : " opt ") + man_opt.get(i)._name;
			}
			
			code += " }\r\n";
		}
		
		ArrayList<Feature> relSibList;
		
		while ( alternative.size() > 0 )
		{
			relSibList = new ArrayList<Feature>();
			
			feat = alternative.get(0);
			relSibList.add(feat);
			for (i=1; i < alternative.size(); i++)
			{
				sibling = alternative.get(i);
				if ( feat._decompID == sibling._decompID )
				{
					relSibList.add(sibling);
				}
			}
			
			if ( relSibList.size() == 1 )
			{
				code += "  group allof { " + relSibList.get(0)._name + " }\r\n";
				
				alternative.remove(relSibList.get(0));
			}
			else
			{
				code += "  group oneof { ";
				code += relSibList.get(0)._name;
				for (i=1; i < relSibList.size(); i++)
				{
					code += " , " + relSibList.get(i)._name;
				}
				code += " }\r\n";
				
				for (i=0; i < relSibList.size(); i++)
				{
					alternative.remove(relSibList.get(i));
				}
			}
		}
		
		while ( or.size() > 0 )
		{
			relSibList = new ArrayList<Feature>();
			
			feat = or.get(0);
			relSibList.add(feat);
			for (i=1; i < or.size(); i++)
			{
				sibling = or.get(i);
				if ( feat._decompID == sibling._decompID )
				{
					relSibList.add(sibling);
				}
			}
			
			if ( relSibList.size() == 1 )
			{
				code += "  group allof { " + relSibList.get(0)._name + " }\r\n";
				
				or.remove(relSibList.get(0));
			}
			else
			{
				code += "  group someof { ";
				code += relSibList.get(0)._name;
				for (i=1; i < relSibList.size(); i++)
				{
					code += " , " + relSibList.get(i)._name;
				}
				code += " }\r\n";
				
				for (i=0; i < relSibList.size(); i++)
				{
					or.remove(relSibList.get(i));
				}
			}
		}
		
		return code;
	}

	private static String generateConstraintDeclarationsCode(int featureIDNo, ArrayList<CrossTreeConstraint> ctcList)
	{
		if ( ctcList == null || ctcList.size() == 0 )
		{
			return "";
		}
		
		int i;
		CrossTreeConstraint ctc;
		String code = "";
		
		for (i=0; i < ctcList.size(); i++)
		{
			ctc = ctcList.get(i);
			if ( featureIDNo != ctc.leftIDNo )
			{
				continue;
			}
			
			code += "  " + ctc.leftFeature + (ctc.constraintType == Codes.REQUIRES ? " requires " : " excludes ") + ctc.rightFeature + " ;\r\n" ;
		}
		
		return code;
	}

}
